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
    private View eAS;
    private ImageView hib;
    private PostWriteCallBackData jvx;
    private View lgX;
    private TextView lgY;
    private boolean lgZ;
    private TextView lha;
    private SendVideoSuccessShareModel lhb = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eAS = viewGroup;
        if (this.mContext != null && this.eAS != null) {
            this.lgX = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.lgY = (TextView) this.lgX.findViewById(R.id.success_tip);
            this.hib = (ImageView) this.lgX.findViewById(R.id.video_activity_btn);
            this.lha = (TextView) this.lgX.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.lgX.getParent() == null) {
                viewGroup.addView(this.lgX, layoutParams);
            }
            this.lgX.setVisibility(8);
            this.lgX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.lgZ) {
                        f.this.hideTip();
                        if (f.this.jvx != null && !StringUtils.isNull(f.this.jvx.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.jvx.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.lha.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.jvx != null && !StringUtils.isNull(f.this.jvx.getVideoid())) {
                        f.this.lhb.LA(f.this.jvx.getVideoid());
                        f.this.lhb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dQI = false;
                                shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bGe().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("uid", TbadkCoreApplication.getCurrentAccount()).af(TiebaInitialize.Params.OBJ_PARAM2, 1).af(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jvx = postWriteCallBackData;
            this.lgZ = postWriteCallBackData.mVideoTitleData != null;
            if (this.lgX != null && this.lgY != null && this.hib != null && this.lha != null) {
                am.setBackgroundColor(this.lgX, R.color.cp_link_tip_a);
                am.setViewTextColor(this.lgY, (int) R.color.cp_cont_a);
                am.setImageResource(this.hib, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.lha, R.drawable.immediately_share_background);
                this.lgX.setVisibility(0);
                this.lgX.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.lgZ) {
                    this.lgY.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.lgY.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.lgX.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.lgX != null) {
            this.lgX.setVisibility(8);
        }
    }

    public void bRj() {
        if (this.lhb != null) {
            this.lhb.cancelLoadData();
        }
    }
}
