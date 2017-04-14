package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    public int ZX;
    private View.OnClickListener aOR = new c(this);
    private ImageView amu;
    public BaseActivity bcy;
    public HeadImageView euG;
    public TextView euH;
    public TextView euI;
    private bp euJ;
    public View mRootView;

    public b(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bcy = baseActivity;
            this.mRootView = view;
            this.euG = (HeadImageView) this.mRootView.findViewById(w.h.vide_video_channel_photo);
            this.euG.setDefaultResource(w.g.avatar_channel_poto_defaul160);
            this.euG.setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
            this.euH = (TextView) this.mRootView.findViewById(w.h.vide_video_channel_name);
            this.euI = (TextView) this.mRootView.findViewById(w.h.pb_video_order_button);
            this.amu = (ImageView) this.mRootView.findViewById(w.h.vide_video_channel_icon);
            this.euG.setImageDrawable(null);
            this.euG.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), w.f.ds40));
            this.euG.setOnClickListener(this.aOR);
            this.amu.setOnClickListener(this.aOR);
            this.euI.setOnClickListener(this.aOR);
            this.euH.setOnClickListener(this.aOR);
        }
    }

    public void b(bp bpVar) {
        if (bpVar != null && this.mRootView != null) {
            this.euJ = bpVar;
            this.euH.setText(bpVar.channelName);
            this.euG.c(bpVar.channelAvatar, 10, false);
            if (bpVar.ZX == 1) {
                this.ZX = 0;
            } else {
                this.ZX = bpVar.ZX;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.ZX = 2;
            }
            j(this.ZX, this.euJ.channelId);
            Bn();
        }
    }

    public void Bn() {
        this.bcy.getLayoutMode().t(this.mRootView);
        if (this.ZX == 1) {
            this.euI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.euI, w.e.cp_cont_d);
            this.euI.setText(w.l.has_ordered_channel);
            this.euI.setVisibility(0);
        } else if (this.ZX == 2) {
            this.euI.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.euI, w.e.btn_forum_focus_color);
            this.euI.setVisibility(0);
            this.euI.setText(w.l.order_video_channel);
        } else {
            this.euI.setVisibility(8);
        }
        aq.j(this.amu, w.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.euJ != null && j > 0 && j == this.euJ.channelId) {
            if (i == 1) {
                this.euI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aq.i(this.euI, w.e.cp_cont_d);
                this.euI.setClickable(false);
                this.euI.setText(w.l.has_ordered_channel);
                return;
            }
            this.euI.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.euI, w.e.btn_forum_focus_color);
            this.euI.setClickable(true);
            this.euI.setText(w.l.order_video_channel);
        }
    }
}
