package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View beD;
    private ImageView cOf;
    private PostWriteCallBackData eWx;
    private View gNa;
    private TextView gNb;
    private boolean gNc;
    private TextView gNd;
    private SendVideoSuccessShareModel gNe = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.beD = viewGroup;
        if (this.mContext != null && this.beD != null) {
            this.gNa = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.gNb = (TextView) this.gNa.findViewById(d.g.success_tip);
            this.cOf = (ImageView) this.gNa.findViewById(d.g.video_activity_btn);
            this.gNd = (TextView) this.gNa.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, d.e.ds128));
            if (this.gNa.getParent() == null) {
                viewGroup.addView(this.gNa, layoutParams);
            }
            this.gNa.setVisibility(8);
            this.gNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.gNc) {
                        e.this.hideTip();
                        if (e.this.eWx != null && !StringUtils.isNull(e.this.eWx.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.f(e.this.mContext, null, e.this.eWx.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gNd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.eWx != null && !StringUtils.isNull(e.this.eWx.getVideoid())) {
                        e.this.gNe.tO(e.this.eWx.getVideoid());
                        e.this.gNe.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.auK = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                new com.baidu.tieba.d.c(e.this.mContext).a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new ak("c10125").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eWx = postWriteCallBackData;
            this.gNc = postWriteCallBackData.mVideoTitleData != null;
            if (this.gNa != null && this.gNb != null && this.cOf != null && this.gNd != null) {
                aj.k(this.gNa, d.C0082d.cp_link_tip_a);
                aj.i(this.gNb, d.C0082d.cp_cont_i);
                aj.c(this.cOf, d.f.icon_arrow_more_white);
                aj.j(this.gNd, d.f.immediately_share_background);
                this.gNa.setVisibility(0);
                this.gNa.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gNc) {
                    this.gNb.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gNb.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gNa.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gNa != null) {
            this.gNa.setVisibility(8);
        }
    }

    public void amU() {
        if (this.gNe != null) {
            this.gNe.cancelLoadData();
        }
    }
}
