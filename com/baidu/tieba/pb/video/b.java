package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    public int Uu;
    private View.OnClickListener aJe = new c(this);
    public BaseActivity aWr;
    public HeadImageView eto;
    public TextView etp;
    public TextView etq;
    private bo etr;
    public View mRootView;

    public b(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.aWr = baseActivity;
            this.mRootView = view;
            this.eto = (HeadImageView) this.mRootView.findViewById(r.h.vide_video_channel_photo);
            this.eto.setDefaultResource(r.g.avatar_channel_poto_defaul160);
            this.eto.setDefaultErrorResource(r.g.avatar_channel_poto_defaul160);
            this.etp = (TextView) this.mRootView.findViewById(r.h.vide_video_channel_name);
            this.etq = (TextView) this.mRootView.findViewById(r.h.pb_video_order_button);
            this.eto.setImageDrawable(null);
            this.eto.setRadius(com.baidu.adp.lib.util.k.e(baseActivity.getActivity(), r.f.ds40));
            this.eto.setOnClickListener(this.aJe);
            this.etq.setOnClickListener(this.aJe);
            this.etp.setOnClickListener(this.aJe);
        }
    }

    public void b(bo boVar) {
        if (boVar != null && this.mRootView != null) {
            this.etr = boVar;
            this.etp.setText(boVar.channelName);
            this.eto.c(boVar.channelAvatar, 10, false);
            if (boVar.Uu == 1) {
                this.Uu = 0;
            } else {
                this.Uu = boVar.Uu;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.Uu = 2;
            }
            k(this.Uu, this.etr.channelId);
            lJ();
        }
    }

    public void lJ() {
        this.aWr.getLayoutMode().v(this.mRootView);
        if (this.Uu == 1) {
            this.etq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.i((View) this.etq, r.e.cp_cont_d);
            this.etq.setText(r.l.has_ordered_channel);
            this.etq.setVisibility(0);
        } else if (this.Uu == 2) {
            this.etq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.i((View) this.etq, r.e.btn_forum_focus_color);
            this.etq.setVisibility(0);
            this.etq.setText(r.l.order_video_channel);
        } else {
            this.etq.setVisibility(8);
        }
    }

    public void k(int i, long j) {
        if (this.etr != null && j > 0 && j == this.etr.channelId) {
            if (i == 1) {
                this.etq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ap.i((View) this.etq, r.e.cp_cont_d);
                this.etq.setClickable(false);
                this.etq.setText(r.l.has_ordered_channel);
                return;
            }
            this.etq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.i((View) this.etq, r.e.btn_forum_focus_color);
            this.etq.setClickable(true);
            this.etq.setText(r.l.order_video_channel);
        }
    }
}
