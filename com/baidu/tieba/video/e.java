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
    private View bRP;
    private ImageView dDu;
    private PostWriteCallBackData fKt;
    private View hwL;
    private TextView hwM;
    private boolean hwN;
    private TextView hwO;
    private SendVideoSuccessShareModel hwP = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bRP = viewGroup;
        if (this.mContext != null && this.bRP != null) {
            this.hwL = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hwM = (TextView) this.hwL.findViewById(d.g.success_tip);
            this.dDu = (ImageView) this.hwL.findViewById(d.g.video_activity_btn);
            this.hwO = (TextView) this.hwL.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.s(context, d.e.ds128));
            if (this.hwL.getParent() == null) {
                viewGroup.addView(this.hwL, layoutParams);
            }
            this.hwL.setVisibility(8);
            this.hwL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hwN) {
                        e.this.hideTip();
                        if (e.this.fKt != null && !StringUtils.isNull(e.this.fKt.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(e.this.mContext, null, e.this.fKt.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fKt != null && !StringUtils.isNull(e.this.fKt.getVideoid())) {
                        e.this.hwP.tU(e.this.fKt.getVideoid());
                        e.this.hwP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void ak(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.biY = false;
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
            this.fKt = postWriteCallBackData;
            this.hwN = postWriteCallBackData.mVideoTitleData != null;
            if (this.hwL != null && this.hwM != null && this.dDu != null && this.hwO != null) {
                aj.t(this.hwL, d.C0108d.cp_link_tip_a);
                aj.r(this.hwM, d.C0108d.cp_cont_i);
                aj.c(this.dDu, d.f.icon_arrow_more_white);
                aj.s(this.hwO, d.f.immediately_share_background);
                this.hwL.setVisibility(0);
                this.hwL.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hwN) {
                    this.hwM.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hwM.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hwL.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hwL != null) {
            this.hwL.setVisibility(8);
        }
    }

    public void auK() {
        if (this.hwP != null) {
            this.hwP.cancelLoadData();
        }
    }
}
