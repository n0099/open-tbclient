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
    private View eaC;
    private ImageView gxJ;
    private PostWriteCallBackData iJB;
    private View kuU;
    private TextView kuV;
    private boolean kuW;
    private TextView kuX;
    private SendVideoSuccessShareModel kuY = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eaC = viewGroup;
        if (this.mContext != null && this.eaC != null) {
            this.kuU = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.kuV = (TextView) this.kuU.findViewById(R.id.success_tip);
            this.gxJ = (ImageView) this.kuU.findViewById(R.id.video_activity_btn);
            this.kuX = (TextView) this.kuU.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.kuU.getParent() == null) {
                viewGroup.addView(this.kuU, layoutParams);
            }
            this.kuU.setVisibility(8);
            this.kuU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.kuW) {
                        f.this.hideTip();
                        if (f.this.iJB != null && !StringUtils.isNull(f.this.iJB.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.iJB.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.kuX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.iJB != null && !StringUtils.isNull(f.this.iJB.getVideoid())) {
                        f.this.kuY.JQ(f.this.iJB.getVideoid());
                        f.this.kuY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dqp = false;
                                shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bwm().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
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
            this.iJB = postWriteCallBackData;
            this.kuW = postWriteCallBackData.mVideoTitleData != null;
            if (this.kuU != null && this.kuV != null && this.gxJ != null && this.kuX != null) {
                am.setBackgroundColor(this.kuU, R.color.cp_link_tip_a);
                am.setViewTextColor(this.kuV, (int) R.color.cp_cont_a);
                am.setImageResource(this.gxJ, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.kuX, R.drawable.immediately_share_background);
                this.kuU.setVisibility(0);
                this.kuU.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.kuW) {
                    this.kuV.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.kuV.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.kuU.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.kuU != null) {
            this.kuU.setVisibility(8);
        }
    }

    public void bGv() {
        if (this.kuY != null) {
            this.kuY.cancelLoadData();
        }
    }
}
