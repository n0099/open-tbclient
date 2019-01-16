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
    private View bDo;
    private ImageView dUl;
    private PostWriteCallBackData gbv;
    private View hEh;
    private TextView hEi;
    private boolean hEj;
    private TextView hEk;
    private SendVideoSuccessShareModel hEl = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bDo = viewGroup;
        if (this.mContext != null && this.bDo != null) {
            this.hEh = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hEi = (TextView) this.hEh.findViewById(e.g.success_tip);
            this.dUl = (ImageView) this.hEh.findViewById(e.g.video_activity_btn);
            this.hEk = (TextView) this.hEh.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0210e.ds128));
            if (this.hEh.getParent() == null) {
                viewGroup.addView(this.hEh, layoutParams);
            }
            this.hEh.setVisibility(8);
            this.hEh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hEj) {
                        f.this.hideTip();
                        if (f.this.gbv != null && !StringUtils.isNull(f.this.gbv.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.gbv.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hEk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.gbv != null && !StringUtils.isNull(f.this.gbv.getVideoid())) {
                        f.this.hEl.wP(f.this.gbv.getVideoid());
                        f.this.hEl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aTa = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.asB().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").aB("uid", TbadkCoreApplication.getCurrentAccount()).y("obj_param2", 1).y("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gbv = postWriteCallBackData;
            this.hEj = postWriteCallBackData.mVideoTitleData != null;
            if (this.hEh != null && this.hEi != null && this.dUl != null && this.hEk != null) {
                al.j(this.hEh, e.d.cp_link_tip_a);
                al.h(this.hEi, e.d.cp_cont_i);
                al.c(this.dUl, e.f.icon_arrow_more_white);
                al.i(this.hEk, e.f.immediately_share_background);
                this.hEh.setVisibility(0);
                this.hEh.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hEj) {
                    this.hEi.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hEi.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hEh.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hEh != null) {
            this.hEh.setVisibility(8);
        }
    }

    public void aEp() {
        if (this.hEl != null) {
            this.hEl.cancelLoadData();
        }
    }
}
