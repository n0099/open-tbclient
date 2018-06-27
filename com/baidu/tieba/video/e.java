package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View bnO;
    private ImageView drQ;
    private PostWriteCallBackData fAb;
    private TextView haA;
    private SendVideoSuccessShareModel haB = new SendVideoSuccessShareModel();
    private View hax;
    private TextView hay;
    private boolean haz;
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bnO = viewGroup;
        if (this.mContext != null && this.bnO != null) {
            this.hax = LayoutInflater.from(context).inflate(d.i.send_video_success_tip, (ViewGroup) null);
            this.hay = (TextView) this.hax.findViewById(d.g.success_tip);
            this.drQ = (ImageView) this.hax.findViewById(d.g.video_activity_btn);
            this.haA = (TextView) this.hax.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.e(context, d.e.ds128));
            if (this.hax.getParent() == null) {
                viewGroup.addView(this.hax, layoutParams);
            }
            this.hax.setVisibility(8);
            this.hax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.haz) {
                        e.this.hideTip();
                        if (e.this.fAb != null && !StringUtils.isNull(e.this.fAb.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(e.this.mContext, null, e.this.fAb.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.haA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fAb != null && !StringUtils.isNull(e.this.fAb.getVideoid())) {
                        e.this.haB.uB(e.this.fAb.getVideoid());
                        e.this.haB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aGn = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.akp().a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new an("c10125").ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fAb = postWriteCallBackData;
            this.haz = postWriteCallBackData.mVideoTitleData != null;
            if (this.hax != null && this.hay != null && this.drQ != null && this.haA != null) {
                am.j(this.hax, d.C0142d.cp_link_tip_a);
                am.h(this.hay, d.C0142d.cp_cont_i);
                am.c(this.drQ, d.f.icon_arrow_more_white);
                am.i(this.haA, d.f.immediately_share_background);
                this.hax.setVisibility(0);
                this.hax.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.haz) {
                    this.hay.setText(d.k.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hay.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hax.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hax != null) {
            this.hax.setVisibility(8);
        }
    }

    public void avN() {
        if (this.haB != null) {
            this.haB.cancelLoadData();
        }
    }
}
