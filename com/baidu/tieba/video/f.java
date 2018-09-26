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
    private View bum;
    private ImageView dBh;
    private PostWriteCallBackData fHP;
    private View hjD;
    private TextView hjE;
    private boolean hjF;
    private TextView hjG;
    private SendVideoSuccessShareModel hjH = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bum = viewGroup;
        if (this.mContext != null && this.bum != null) {
            this.hjD = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hjE = (TextView) this.hjD.findViewById(e.g.success_tip);
            this.dBh = (ImageView) this.hjD.findViewById(e.g.video_activity_btn);
            this.hjG = (TextView) this.hjD.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0141e.ds128));
            if (this.hjD.getParent() == null) {
                viewGroup.addView(this.hjD, layoutParams);
            }
            this.hjD.setVisibility(8);
            this.hjD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hjF) {
                        f.this.hideTip();
                        if (f.this.fHP != null && !StringUtils.isNull(f.this.fHP.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.fHP.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hjG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.fHP != null && !StringUtils.isNull(f.this.fHP.getVideoid())) {
                        f.this.hjH.vm(f.this.fHP.getVideoid());
                        f.this.hjH.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void j(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aJA = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.amB().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").al("uid", TbadkCoreApplication.getCurrentAccount()).w("obj_param2", 1).w("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fHP = postWriteCallBackData;
            this.hjF = postWriteCallBackData.mVideoTitleData != null;
            if (this.hjD != null && this.hjE != null && this.dBh != null && this.hjG != null) {
                al.j(this.hjD, e.d.cp_link_tip_a);
                al.h(this.hjE, e.d.cp_cont_i);
                al.c(this.dBh, e.f.icon_arrow_more_white);
                al.i(this.hjG, e.f.immediately_share_background);
                this.hjD.setVisibility(0);
                this.hjD.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hjF) {
                    this.hjE.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hjE.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hjD.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hjD != null) {
            this.hjD.setVisibility(8);
        }
    }

    public void ayC() {
        if (this.hjH != null) {
            this.hjH.cancelLoadData();
        }
    }
}
