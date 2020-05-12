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
    private View eAX;
    private ImageView hii;
    private PostWriteCallBackData jvB;
    private View lhb;
    private TextView lhc;
    private boolean lhd;
    private TextView lhe;
    private SendVideoSuccessShareModel lhf = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eAX = viewGroup;
        if (this.mContext != null && this.eAX != null) {
            this.lhb = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.lhc = (TextView) this.lhb.findViewById(R.id.success_tip);
            this.hii = (ImageView) this.lhb.findViewById(R.id.video_activity_btn);
            this.lhe = (TextView) this.lhb.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.lhb.getParent() == null) {
                viewGroup.addView(this.lhb, layoutParams);
            }
            this.lhb.setVisibility(8);
            this.lhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.lhd) {
                        f.this.hideTip();
                        if (f.this.jvB != null && !StringUtils.isNull(f.this.jvB.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.jvB.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.lhe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.jvB != null && !StringUtils.isNull(f.this.jvB.getVideoid())) {
                        f.this.lhf.LD(f.this.jvB.getVideoid());
                        f.this.lhf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dQN = false;
                                shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bGd().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
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
            this.jvB = postWriteCallBackData;
            this.lhd = postWriteCallBackData.mVideoTitleData != null;
            if (this.lhb != null && this.lhc != null && this.hii != null && this.lhe != null) {
                am.setBackgroundColor(this.lhb, R.color.cp_link_tip_a);
                am.setViewTextColor(this.lhc, (int) R.color.cp_cont_a);
                am.setImageResource(this.hii, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.lhe, R.drawable.immediately_share_background);
                this.lhb.setVisibility(0);
                this.lhb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.lhd) {
                    this.lhc.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.lhc.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.lhb.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.lhb != null) {
            this.lhb.setVisibility(8);
        }
    }

    public void bRi() {
        if (this.lhf != null) {
            this.lhf.cancelLoadData();
        }
    }
}
