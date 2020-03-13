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
    private View eaP;
    private ImageView gxV;
    private PostWriteCallBackData iJN;
    private View kvg;
    private TextView kvh;
    private boolean kvi;
    private TextView kvj;
    private SendVideoSuccessShareModel kvk = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.eaP = viewGroup;
        if (this.mContext != null && this.eaP != null) {
            this.kvg = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.kvh = (TextView) this.kvg.findViewById(R.id.success_tip);
            this.gxV = (ImageView) this.kvg.findViewById(R.id.video_activity_btn);
            this.kvj = (TextView) this.kvg.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.kvg.getParent() == null) {
                viewGroup.addView(this.kvg, layoutParams);
            }
            this.kvg.setVisibility(8);
            this.kvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.kvi) {
                        f.this.hideTip();
                        if (f.this.iJN != null && !StringUtils.isNull(f.this.iJN.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.iJN.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.kvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.iJN != null && !StringUtils.isNull(f.this.iJN.getVideoid())) {
                        f.this.kvk.JR(f.this.iJN.getVideoid());
                        f.this.kvk.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dqC = false;
                                shareItem.dqz = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bwn().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
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
            this.iJN = postWriteCallBackData;
            this.kvi = postWriteCallBackData.mVideoTitleData != null;
            if (this.kvg != null && this.kvh != null && this.gxV != null && this.kvj != null) {
                am.setBackgroundColor(this.kvg, R.color.cp_link_tip_a);
                am.setViewTextColor(this.kvh, (int) R.color.cp_cont_a);
                am.setImageResource(this.gxV, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.kvj, R.drawable.immediately_share_background);
                this.kvg.setVisibility(0);
                this.kvg.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.kvi) {
                    this.kvh.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.kvh.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.kvg.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.kvg != null) {
            this.kvg.setVisibility(8);
        }
    }

    public void bGw() {
        if (this.kvk != null) {
            this.kvk.cancelLoadData();
        }
    }
}
