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
    private View fNJ;
    private ImageView iMO;
    private PostWriteCallBackData lpZ;
    private Context mContext;
    private View nfY;
    private TextView nfZ;
    private boolean nga;
    private TextView ngb;
    private SendVideoSuccessShareModel ngc = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.fNJ = viewGroup;
        if (this.mContext != null && this.fNJ != null) {
            this.nfY = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nfZ = (TextView) this.nfY.findViewById(R.id.success_tip);
            this.iMO = (ImageView) this.nfY.findViewById(R.id.video_activity_btn);
            this.ngb = (TextView) this.nfY.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nfY.getParent() == null) {
                viewGroup.addView(this.nfY, layoutParams);
            }
            this.nfY.setVisibility(8);
            this.nfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.nga) {
                        f.this.hideTip();
                        if (f.this.lpZ != null && !StringUtils.isNull(f.this.lpZ.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.lpZ.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.ngb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.lpZ != null && !StringUtils.isNull(f.this.lpZ.getVideoid())) {
                        f.this.ngc.Tm(f.this.lpZ.getVideoid());
                        f.this.ngc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fbq = false;
                                shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.cmU().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("uid", TbadkCoreApplication.getCurrentAccount()).aj(TiebaInitialize.Params.OBJ_PARAM2, 1).aj(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lpZ = postWriteCallBackData;
            this.nga = postWriteCallBackData.mVideoTitleData != null;
            if (this.nfY != null && this.nfZ != null && this.iMO != null && this.ngb != null) {
                ap.setBackgroundColor(this.nfY, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.nfZ, R.color.cp_cont_a);
                ap.setImageResource(this.iMO, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.ngb, R.drawable.immediately_share_background);
                this.nfY.setVisibility(0);
                this.nfY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.nga) {
                    this.nfZ.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nfZ.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nfY.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nfY != null) {
            this.nfY.setVisibility(8);
        }
    }

    public void cyM() {
        if (this.ngc != null) {
            this.ngc.cancelLoadData();
        }
    }
}
