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
    private View beE;
    private ImageView cOq;
    private PostWriteCallBackData eXA;
    private View gPI;
    private TextView gPJ;
    private boolean gPK;
    private TextView gPL;
    private SendVideoSuccessShareModel gPM = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.beE = viewGroup;
        if (this.mContext != null && this.beE != null) {
            this.gPI = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.gPJ = (TextView) this.gPI.findViewById(d.g.success_tip);
            this.cOq = (ImageView) this.gPI.findViewById(d.g.video_activity_btn);
            this.gPL = (TextView) this.gPI.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, d.e.ds128));
            if (this.gPI.getParent() == null) {
                viewGroup.addView(this.gPI, layoutParams);
            }
            this.gPI.setVisibility(8);
            this.gPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.gPK) {
                        e.this.hideTip();
                        if (e.this.eXA != null && !StringUtils.isNull(e.this.eXA.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.e(e.this.mContext, null, e.this.eXA.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gPL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.eXA != null && !StringUtils.isNull(e.this.eXA.getVideoid())) {
                        e.this.gPM.tT(e.this.eXA.getVideoid());
                        e.this.gPM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.auP = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                new com.baidu.tieba.d.c(e.this.mContext).a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new ak("c10125").ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eXA = postWriteCallBackData;
            this.gPK = postWriteCallBackData.mVideoTitleData != null;
            if (this.gPI != null && this.gPJ != null && this.cOq != null && this.gPL != null) {
                aj.k(this.gPI, d.C0096d.cp_link_tip_a);
                aj.i(this.gPJ, d.C0096d.cp_cont_i);
                aj.c(this.cOq, d.f.icon_arrow_more_white);
                aj.j(this.gPL, d.f.immediately_share_background);
                this.gPI.setVisibility(0);
                this.gPI.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gPK) {
                    this.gPJ.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gPJ.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gPI.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gPI != null) {
            this.gPI.setVisibility(8);
        }
    }

    public void and() {
        if (this.gPM != null) {
            this.gPM.cancelLoadData();
        }
    }
}
