package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    public int ZH;
    private View.OnClickListener aOB = new c(this);
    private ImageView amg;
    public BaseActivity bcF;
    public HeadImageView ewB;
    public TextView ewC;
    public TextView ewD;
    private bq ewE;
    public View mRootView;

    public b(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bcF = baseActivity;
            this.mRootView = view;
            this.ewB = (HeadImageView) this.mRootView.findViewById(w.h.vide_video_channel_photo);
            this.ewB.setDefaultResource(w.g.avatar_channel_poto_defaul160);
            this.ewB.setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
            this.ewC = (TextView) this.mRootView.findViewById(w.h.vide_video_channel_name);
            this.ewD = (TextView) this.mRootView.findViewById(w.h.pb_video_order_button);
            this.amg = (ImageView) this.mRootView.findViewById(w.h.vide_video_channel_icon);
            this.ewB.setImageDrawable(null);
            this.ewB.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), w.f.ds40));
            this.ewB.setOnClickListener(this.aOB);
            this.amg.setOnClickListener(this.aOB);
            this.ewD.setOnClickListener(this.aOB);
            this.ewC.setOnClickListener(this.aOB);
        }
    }

    public void b(bq bqVar) {
        if (bqVar != null && this.mRootView != null) {
            this.ewE = bqVar;
            this.ewC.setText(bqVar.channelName);
            this.ewB.c(bqVar.channelAvatar, 10, false);
            if (bqVar.ZH == 1) {
                this.ZH = 0;
            } else {
                this.ZH = bqVar.ZH;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.ZH = 2;
            }
            k(this.ZH, this.ewE.channelId);
            AO();
        }
    }

    public void AO() {
        this.bcF.getLayoutMode().t(this.mRootView);
        if (this.ZH == 1) {
            this.ewD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i((View) this.ewD, w.e.cp_cont_d);
            this.ewD.setText(w.l.has_ordered_channel);
            this.ewD.setVisibility(0);
        } else if (this.ZH == 2) {
            this.ewD.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i((View) this.ewD, w.e.btn_forum_focus_color);
            this.ewD.setVisibility(0);
            this.ewD.setText(w.l.order_video_channel);
        } else {
            this.ewD.setVisibility(8);
        }
        aq.j(this.amg, w.g.icon_weiba);
    }

    public void k(int i, long j) {
        if (this.ewE != null && j > 0 && j == this.ewE.channelId) {
            if (i == 1) {
                this.ewD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aq.i((View) this.ewD, w.e.cp_cont_d);
                this.ewD.setClickable(false);
                this.ewD.setText(w.l.has_ordered_channel);
                return;
            }
            this.ewD.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i((View) this.ewD, w.e.btn_forum_focus_color);
            this.ewD.setClickable(true);
            this.ewD.setText(w.l.order_video_channel);
        }
    }
}
