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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View fTz;
    private ImageView iSL;
    private PostWriteCallBackData lvW;
    private Context mContext;
    private View nlU;
    private TextView nlV;
    private boolean nlW;
    private TextView nlX;
    private SendVideoSuccessShareModel nlY = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.fTz = viewGroup;
        if (this.mContext != null && this.fTz != null) {
            this.nlU = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nlV = (TextView) this.nlU.findViewById(R.id.success_tip);
            this.iSL = (ImageView) this.nlU.findViewById(R.id.video_activity_btn);
            this.nlX = (TextView) this.nlU.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nlU.getParent() == null) {
                viewGroup.addView(this.nlU, layoutParams);
            }
            this.nlU.setVisibility(8);
            this.nlU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.nlW) {
                        f.this.hideTip();
                        if (f.this.lvW != null && !StringUtils.isNull(f.this.lvW.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.lvW.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nlX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.lvW != null && !StringUtils.isNull(f.this.lvW.getVideoid())) {
                        f.this.nlY.TD(f.this.lvW.getVideoid());
                        f.this.nlY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fhh = false;
                                shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.cpv().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("uid", TbadkCoreApplication.getCurrentAccount()).al(TiebaInitialize.Params.OBJ_PARAM2, 1).al(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lvW = postWriteCallBackData;
            this.nlW = postWriteCallBackData.mVideoTitleData != null;
            if (this.nlU != null && this.nlV != null && this.iSL != null && this.nlX != null) {
                ap.setBackgroundColor(this.nlU, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.nlV, R.color.cp_cont_a);
                ap.setImageResource(this.iSL, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nlX, R.drawable.immediately_share_background);
                this.nlU.setVisibility(0);
                this.nlU.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.nlW) {
                    this.nlV.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nlV.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nlU.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nlU != null) {
            this.nlU.setVisibility(8);
        }
    }

    public void cBn() {
        if (this.nlY != null) {
            this.nlY.cancelLoadData();
        }
    }
}
