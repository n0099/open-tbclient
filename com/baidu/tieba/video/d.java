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
    private View bbj;
    private ImageView cEG;
    private boolean gCA;
    private PostWriteCallBackData gCB;
    private View gCy;
    private TextView gCz;
    private Context mContext;

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bbj = viewGroup;
        if (this.mContext != null && this.bbj != null) {
            this.gCy = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.gCz = (TextView) this.gCy.findViewById(d.g.success_tip);
            this.cEG = (ImageView) this.gCy.findViewById(d.g.video_activity_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, d.e.ds128));
            if (this.gCy.getParent() == null) {
                viewGroup.addView(this.gCy, layoutParams);
            }
            this.gCy.setVisibility(8);
            this.gCy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.gCA) {
                        d.this.hideTip();
                        if (d.this.gCB != null && !StringUtils.isNull(d.this.gCB.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.f(d.this.mContext, null, d.this.gCB.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
        }
    }

    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gCB = postWriteCallBackData;
            this.gCA = postWriteCallBackData.mVideoTitleData != null;
            if (this.gCy != null && this.gCz != null && this.cEG != null) {
                aj.k(this.gCy, d.C0080d.cp_link_tip_a);
                aj.i(this.gCz, d.C0080d.cp_cont_i);
                aj.c(this.cEG, d.f.icon_arrow_more_white);
                this.gCy.setVisibility(0);
                this.gCy.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.hideTip();
                    }
                }, 3000L);
                if (this.gCA) {
                    this.gCz.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gCz.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gCy.setVisibility(8);
                }
                if (this.gCA) {
                    this.cEG.setVisibility(0);
                } else {
                    this.cEG.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gCy != null) {
            this.gCy.setVisibility(8);
        }
    }
}
