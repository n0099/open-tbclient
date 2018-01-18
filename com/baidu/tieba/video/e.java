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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View bRW;
    private ImageView dHV;
    private PostWriteCallBackData fLT;
    private View hmo;
    private TextView hmp;
    private boolean hmq;
    private TextView hmr;
    private SendVideoSuccessShareModel hms = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bRW = viewGroup;
        if (this.mContext != null && this.bRW != null) {
            this.hmo = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hmp = (TextView) this.hmo.findViewById(d.g.success_tip);
            this.dHV = (ImageView) this.hmo.findViewById(d.g.video_activity_btn);
            this.hmr = (TextView) this.hmo.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.s(context, d.e.ds128));
            if (this.hmo.getParent() == null) {
                viewGroup.addView(this.hmo, layoutParams);
            }
            this.hmo.setVisibility(8);
            this.hmo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hmq) {
                        e.this.hideTip();
                        if (e.this.fLT != null && !StringUtils.isNull(e.this.fLT.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(e.this.mContext, null, e.this.fLT.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fLT != null && !StringUtils.isNull(e.this.fLT.getVideoid())) {
                        e.this.hms.tp(e.this.fLT.getVideoid());
                        e.this.hms.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void ak(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.bjp = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                new com.baidu.tieba.d.c(e.this.mContext).a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new ak("c10125").ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_param2", 1).s("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fLT = postWriteCallBackData;
            this.hmq = postWriteCallBackData.mVideoTitleData != null;
            if (this.hmo != null && this.hmp != null && this.dHV != null && this.hmr != null) {
                aj.t(this.hmo, d.C0107d.cp_link_tip_a);
                aj.r(this.hmp, d.C0107d.cp_cont_i);
                aj.c(this.dHV, d.f.icon_arrow_more_white);
                aj.s(this.hmr, d.f.immediately_share_background);
                this.hmo.setVisibility(0);
                this.hmo.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hmq) {
                    this.hmp.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hmp.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hmo.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hmo != null) {
            this.hmo.setVisibility(8);
        }
    }

    public void avN() {
        if (this.hms != null) {
            this.hms.cancelLoadData();
        }
    }
}
