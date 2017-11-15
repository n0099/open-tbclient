package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class d {
    private View bbs;
    private ImageView cEZ;
    private View gDG;
    private TextView gDH;
    private boolean gDI;
    private PostWriteCallBackData gDJ;
    private Context mContext;

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bbs = viewGroup;
        if (this.mContext != null && this.bbs != null) {
            this.gDG = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.gDH = (TextView) this.gDG.findViewById(d.g.success_tip);
            this.cEZ = (ImageView) this.gDG.findViewById(d.g.video_activity_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, d.e.ds128));
            if (this.gDG.getParent() == null) {
                viewGroup.addView(this.gDG, layoutParams);
            }
            this.gDG.setVisibility(8);
            this.gDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gDI) {
                        d.this.hideTip();
                        if (d.this.gDJ != null && !StringUtils.isNull(d.this.gDJ.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.f(d.this.mContext, null, d.this.gDJ.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gDJ = postWriteCallBackData;
            this.gDI = postWriteCallBackData.mVideoTitleData != null;
            if (this.gDG != null && this.gDH != null && this.cEZ != null) {
                aj.k(this.gDG, d.C0080d.cp_link_tip_a);
                aj.i(this.gDH, d.C0080d.cp_cont_i);
                aj.c(this.cEZ, d.f.icon_arrow_more_white);
                this.gDG.setVisibility(0);
                this.gDG.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.hideTip();
                    }
                }, 3000L);
                if (this.gDI) {
                    this.gDH.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gDH.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gDG.setVisibility(8);
                }
                if (this.gDI) {
                    this.cEZ.setVisibility(0);
                } else {
                    this.cEZ.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gDG != null) {
            this.gDG.setVisibility(8);
        }
    }
}
