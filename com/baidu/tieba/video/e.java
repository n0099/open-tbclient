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
    private View bSe;
    private ImageView dIq;
    private PostWriteCallBackData fMo;
    private View hmI;
    private TextView hmJ;
    private boolean hmK;
    private TextView hmL;
    private SendVideoSuccessShareModel hmM = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bSe = viewGroup;
        if (this.mContext != null && this.bSe != null) {
            this.hmI = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hmJ = (TextView) this.hmI.findViewById(d.g.success_tip);
            this.dIq = (ImageView) this.hmI.findViewById(d.g.video_activity_btn);
            this.hmL = (TextView) this.hmI.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.s(context, d.e.ds128));
            if (this.hmI.getParent() == null) {
                viewGroup.addView(this.hmI, layoutParams);
            }
            this.hmI.setVisibility(8);
            this.hmI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hmK) {
                        e.this.hideTip();
                        if (e.this.fMo != null && !StringUtils.isNull(e.this.fMo.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(e.this.mContext, null, e.this.fMo.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hmL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fMo != null && !StringUtils.isNull(e.this.fMo.getVideoid())) {
                        e.this.hmM.tx(e.this.fMo.getVideoid());
                        e.this.hmM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void ak(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.bjx = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                new com.baidu.tieba.d.c(e.this.mContext).a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new ak("c10125").aa("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_param2", 1).s("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fMo = postWriteCallBackData;
            this.hmK = postWriteCallBackData.mVideoTitleData != null;
            if (this.hmI != null && this.hmJ != null && this.dIq != null && this.hmL != null) {
                aj.t(this.hmI, d.C0108d.cp_link_tip_a);
                aj.r(this.hmJ, d.C0108d.cp_cont_i);
                aj.c(this.dIq, d.f.icon_arrow_more_white);
                aj.s(this.hmL, d.f.immediately_share_background);
                this.hmI.setVisibility(0);
                this.hmI.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hmK) {
                    this.hmJ.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hmJ.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hmI.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hmI != null) {
            this.hmI.setVisibility(8);
        }
    }

    public void avS() {
        if (this.hmM != null) {
            this.hmM.cancelLoadData();
        }
    }
}
