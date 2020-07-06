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
    private View lUE;
    private TextView lUF;
    private boolean lUG;
    private TextView lUH;
    private SendVideoSuccessShareModel lUI = new SendVideoSuccessShareModel();
    private Context mContext;

    public g(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eZS = viewGroup;
        if (this.mContext != null && this.eZS != null) {
            this.lUE = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.lUF = (TextView) this.lUE.findViewById(R.id.success_tip);
            this.hKe = (ImageView) this.lUE.findViewById(R.id.video_activity_btn);
            this.lUH = (TextView) this.lUE.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.lUE.getParent() == null) {
                viewGroup.addView(this.lUE, layoutParams);
            }
            this.lUE.setVisibility(8);
            this.lUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.lUG) {
                        g.this.hideTip();
                        if (g.this.khu != null && !StringUtils.isNull(g.this.khu.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(g.this.mContext, (String) null, g.this.khu.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.lUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.hideTip();
                    if (g.this.khu != null && !StringUtils.isNull(g.this.khu.getVideoid())) {
                        g.this.lUI.NT(g.this.khu.getVideoid());
                        g.this.lUI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.g.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.enR = false;
                                shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.bPE().b(new ShareDialogConfig(g.this.mContext, shareItem, true, true));
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
            this.lUG = postWriteCallBackData.mVideoTitleData != null;
            if (this.lUE != null && this.lUF != null && this.hKe != null && this.lUH != null) {
                an.setBackgroundColor(this.lUE, R.color.cp_link_tip_a);
                an.setViewTextColor(this.lUF, (int) R.color.cp_cont_a);
                an.setImageResource(this.hKe, R.drawable.icon_arrow_more_white);
                an.setBackgroundResource(this.lUH, R.drawable.immediately_share_background);
                this.lUE.setVisibility(0);
                this.lUE.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.hideTip();
                    }
                }, 5000L);
                if (this.lUG) {
                    this.lUF.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.lUF.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.lUE.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.lUE != null) {
            this.lUE.setVisibility(8);
        }
    }

    public void caS() {
        if (this.lUI != null) {
            this.lUI.cancelLoadData();
        }
    }
}
