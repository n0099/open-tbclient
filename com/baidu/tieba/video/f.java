package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View bzb;
    private ImageView dKl;
    private PostWriteCallBackData fQQ;
    private View hsD;
    private TextView hsE;
    private boolean hsF;
    private TextView hsG;
    private SendVideoSuccessShareModel hsH = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bzb = viewGroup;
        if (this.mContext != null && this.bzb != null) {
            this.hsD = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hsE = (TextView) this.hsD.findViewById(e.g.success_tip);
            this.dKl = (ImageView) this.hsD.findViewById(e.g.video_activity_btn);
            this.hsG = (TextView) this.hsD.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0200e.ds128));
            if (this.hsD.getParent() == null) {
                viewGroup.addView(this.hsD, layoutParams);
            }
            this.hsD.setVisibility(8);
            this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hsF) {
                        f.this.hideTip();
                        if (f.this.fQQ != null && !StringUtils.isNull(f.this.fQQ.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.fQQ.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hsG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.fQQ != null && !StringUtils.isNull(f.this.fQQ.getVideoid())) {
                        f.this.hsH.vT(f.this.fQQ.getVideoid());
                        f.this.hsH.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aOS = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.apC().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").ax("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_param2", 1).x("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fQQ = postWriteCallBackData;
            this.hsF = postWriteCallBackData.mVideoTitleData != null;
            if (this.hsD != null && this.hsE != null && this.dKl != null && this.hsG != null) {
                al.j(this.hsD, e.d.cp_link_tip_a);
                al.h(this.hsE, e.d.cp_cont_i);
                al.c(this.dKl, e.f.icon_arrow_more_white);
                al.i(this.hsG, e.f.immediately_share_background);
                this.hsD.setVisibility(0);
                this.hsD.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hsF) {
                    this.hsE.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hsE.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hsD.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hsD != null) {
            this.hsD.setVisibility(8);
        }
    }

    public void aBt() {
        if (this.hsH != null) {
            this.hsH.cancelLoadData();
        }
    }
}
