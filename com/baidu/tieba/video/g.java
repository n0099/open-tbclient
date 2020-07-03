package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class g {
    private View eZS;
    private ImageView hKe;
    private PostWriteCallBackData khu;
    private View lUB;
    private TextView lUC;
    private boolean lUD;
    private TextView lUE;
    private SendVideoSuccessShareModel lUF = new SendVideoSuccessShareModel();
    private Context mContext;

    public g(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eZS = viewGroup;
        if (this.mContext != null && this.eZS != null) {
            this.lUB = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.lUC = (TextView) this.lUB.findViewById(R.id.success_tip);
            this.hKe = (ImageView) this.lUB.findViewById(R.id.video_activity_btn);
            this.lUE = (TextView) this.lUB.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.lUB.getParent() == null) {
                viewGroup.addView(this.lUB, layoutParams);
            }
            this.lUB.setVisibility(8);
            this.lUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.lUD) {
                        g.this.hideTip();
                        if (g.this.khu != null && !StringUtils.isNull(g.this.khu.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(g.this.mContext, (String) null, g.this.khu.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.lUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.hideTip();
                    if (g.this.khu != null && !StringUtils.isNull(g.this.khu.getVideoid())) {
                        g.this.lUF.NS(g.this.khu.getVideoid());
                        g.this.lUF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.g.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.enR = false;
                                shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.bPD().b(new ShareDialogConfig(g.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("uid", TbadkCoreApplication.getCurrentAccount()).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).ag(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.khu = postWriteCallBackData;
            this.lUD = postWriteCallBackData.mVideoTitleData != null;
            if (this.lUB != null && this.lUC != null && this.hKe != null && this.lUE != null) {
                an.setBackgroundColor(this.lUB, R.color.cp_link_tip_a);
                an.setViewTextColor(this.lUC, (int) R.color.cp_cont_a);
                an.setImageResource(this.hKe, R.drawable.icon_arrow_more_white);
                an.setBackgroundResource(this.lUE, R.drawable.immediately_share_background);
                this.lUB.setVisibility(0);
                this.lUB.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.hideTip();
                    }
                }, 5000L);
                if (this.lUD) {
                    this.lUC.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.lUC.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.lUB.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.lUB != null) {
            this.lUB.setVisibility(8);
        }
    }

    public void caR() {
        if (this.lUF != null) {
            this.lUF.cancelLoadData();
        }
    }
}
