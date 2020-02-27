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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View eaB;
    private ImageView gxH;
    private PostWriteCallBackData iJz;
    private View kuS;
    private TextView kuT;
    private boolean kuU;
    private TextView kuV;
    private SendVideoSuccessShareModel kuW = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eaB = viewGroup;
        if (this.mContext != null && this.eaB != null) {
            this.kuS = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.kuT = (TextView) this.kuS.findViewById(R.id.success_tip);
            this.gxH = (ImageView) this.kuS.findViewById(R.id.video_activity_btn);
            this.kuV = (TextView) this.kuS.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.kuS.getParent() == null) {
                viewGroup.addView(this.kuS, layoutParams);
            }
            this.kuS.setVisibility(8);
            this.kuS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.kuU) {
                        f.this.hideTip();
                        if (f.this.iJz != null && !StringUtils.isNull(f.this.iJz.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.iJz.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.kuV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.iJz != null && !StringUtils.isNull(f.this.iJz.getVideoid())) {
                        f.this.kuW.JQ(f.this.iJz.getVideoid());
                        f.this.kuW.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dqo = false;
                                shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bwk().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("uid", TbadkCoreApplication.getCurrentAccount()).X(TiebaInitialize.Params.OBJ_PARAM2, 1).X(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iJz = postWriteCallBackData;
            this.kuU = postWriteCallBackData.mVideoTitleData != null;
            if (this.kuS != null && this.kuT != null && this.gxH != null && this.kuV != null) {
                am.setBackgroundColor(this.kuS, R.color.cp_link_tip_a);
                am.setViewTextColor(this.kuT, (int) R.color.cp_cont_a);
                am.setImageResource(this.gxH, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.kuV, R.drawable.immediately_share_background);
                this.kuS.setVisibility(0);
                this.kuS.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.kuU) {
                    this.kuT.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.kuT.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.kuS.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.kuS != null) {
            this.kuS.setVisibility(8);
        }
    }

    public void bGt() {
        if (this.kuW != null) {
            this.kuW.cancelLoadData();
        }
    }
}
