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
    private View dWx;
    private ImageView gvG;
    private PostWriteCallBackData iHZ;
    private View ktQ;
    private TextView ktR;
    private boolean ktS;
    private TextView ktT;
    private SendVideoSuccessShareModel ktU = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.dWx = viewGroup;
        if (this.mContext != null && this.dWx != null) {
            this.ktQ = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.ktR = (TextView) this.ktQ.findViewById(R.id.success_tip);
            this.gvG = (ImageView) this.ktQ.findViewById(R.id.video_activity_btn);
            this.ktT = (TextView) this.ktQ.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.ktQ.getParent() == null) {
                viewGroup.addView(this.ktQ, layoutParams);
            }
            this.ktQ.setVisibility(8);
            this.ktQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.ktS) {
                        f.this.hideTip();
                        if (f.this.iHZ != null && !StringUtils.isNull(f.this.iHZ.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.iHZ.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.ktT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.iHZ != null && !StringUtils.isNull(f.this.iHZ.getVideoid())) {
                        f.this.ktU.JD(f.this.iHZ.getVideoid());
                        f.this.ktU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dmf = false;
                                shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.buG().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z(TiebaInitialize.Params.OBJ_PARAM2, 1).Z(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iHZ = postWriteCallBackData;
            this.ktS = postWriteCallBackData.mVideoTitleData != null;
            if (this.ktQ != null && this.ktR != null && this.gvG != null && this.ktT != null) {
                am.setBackgroundColor(this.ktQ, R.color.cp_link_tip_a);
                am.setViewTextColor(this.ktR, (int) R.color.cp_cont_a);
                am.setImageResource(this.gvG, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.ktT, R.drawable.immediately_share_background);
                this.ktQ.setVisibility(0);
                this.ktQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.ktS) {
                    this.ktR.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.ktR.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.ktQ.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.ktQ != null) {
            this.ktQ.setVisibility(8);
        }
    }

    public void bER() {
        if (this.ktU != null) {
            this.ktU.cancelLoadData();
        }
    }
}
