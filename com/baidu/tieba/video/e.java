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
    private View bUb;
    private ImageView dLk;
    private PostWriteCallBackData fPC;
    private View hoi;
    private TextView hoj;
    private boolean hok;
    private TextView hol;
    private SendVideoSuccessShareModel hom = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bUb = viewGroup;
        if (this.mContext != null && this.bUb != null) {
            this.hoi = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hoj = (TextView) this.hoi.findViewById(d.g.success_tip);
            this.dLk = (ImageView) this.hoi.findViewById(d.g.video_activity_btn);
            this.hol = (TextView) this.hoi.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.t(context, d.e.ds128));
            if (this.hoi.getParent() == null) {
                viewGroup.addView(this.hoi, layoutParams);
            }
            this.hoi.setVisibility(8);
            this.hoi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hok) {
                        e.this.hideTip();
                        if (e.this.fPC != null && !StringUtils.isNull(e.this.fPC.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.b.g(e.this.mContext, null, e.this.fPC.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hol.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fPC != null && !StringUtils.isNull(e.this.fPC.getVideoid())) {
                        e.this.hom.tB(e.this.fPC.getVideoid());
                        e.this.hom.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void ak(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.blC = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.d.d.anj().a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
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
            this.fPC = postWriteCallBackData;
            this.hok = postWriteCallBackData.mVideoTitleData != null;
            if (this.hoi != null && this.hoj != null && this.dLk != null && this.hol != null) {
                aj.t(this.hoi, d.C0141d.cp_link_tip_a);
                aj.r(this.hoj, d.C0141d.cp_cont_i);
                aj.c(this.dLk, d.f.icon_arrow_more_white);
                aj.s(this.hol, d.f.immediately_share_background);
                this.hoi.setVisibility(0);
                this.hoi.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hok) {
                    this.hoj.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hoj.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hoi.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hoi != null) {
            this.hoi.setVisibility(8);
        }
    }

    public void awQ() {
        if (this.hom != null) {
            this.hom.cancelLoadData();
        }
    }
}
