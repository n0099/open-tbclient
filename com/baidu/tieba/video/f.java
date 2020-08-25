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
/* loaded from: classes2.dex */
public class f {
    private View fpN;
    private ImageView iep;
    private PostWriteCallBackData kFE;
    private Context mContext;
    private View mtH;
    private TextView mtI;
    private boolean mtJ;
    private TextView mtK;
    private SendVideoSuccessShareModel mtL = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.fpN = viewGroup;
        if (this.mContext != null && this.fpN != null) {
            this.mtH = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.mtI = (TextView) this.mtH.findViewById(R.id.success_tip);
            this.iep = (ImageView) this.mtH.findViewById(R.id.video_activity_btn);
            this.mtK = (TextView) this.mtH.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.mtH.getParent() == null) {
                viewGroup.addView(this.mtH, layoutParams);
            }
            this.mtH.setVisibility(8);
            this.mtH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mtJ) {
                        f.this.hideTip();
                        if (f.this.kFE != null && !StringUtils.isNull(f.this.kFE.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.kFE.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.mtK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.kFE != null && !StringUtils.isNull(f.this.kFE.getVideoid())) {
                        f.this.mtL.Rz(f.this.kFE.getVideoid());
                        f.this.mtL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.eED = false;
                                shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.cdb().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai(TiebaInitialize.Params.OBJ_PARAM2, 1).ai(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kFE = postWriteCallBackData;
            this.mtJ = postWriteCallBackData.mVideoTitleData != null;
            if (this.mtH != null && this.mtI != null && this.iep != null && this.mtK != null) {
                ap.setBackgroundColor(this.mtH, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.mtI, R.color.cp_cont_a);
                ap.setImageResource(this.iep, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.mtK, R.drawable.immediately_share_background);
                this.mtH.setVisibility(0);
                this.mtH.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.mtJ) {
                    this.mtI.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.mtI.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.mtH.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.mtH != null) {
            this.mtH.setVisibility(8);
        }
    }

    public void coU() {
        if (this.mtL != null) {
            this.mtL.cancelLoadData();
        }
    }
}
