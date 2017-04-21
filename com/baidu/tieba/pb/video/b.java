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
    public int ZY;
    private View.OnClickListener aOT = new c(this);
    private ImageView amu;
    public BaseActivity bdG;
    public HeadImageView ewW;
    public TextView ewX;
    public TextView ewY;
    private bp ewZ;
    public View mRootView;

    public b(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bdG = baseActivity;
            this.mRootView = view;
            this.ewW = (HeadImageView) this.mRootView.findViewById(w.h.vide_video_channel_photo);
            this.ewW.setDefaultResource(w.g.avatar_channel_poto_defaul160);
            this.ewW.setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
            this.ewX = (TextView) this.mRootView.findViewById(w.h.vide_video_channel_name);
            this.ewY = (TextView) this.mRootView.findViewById(w.h.pb_video_order_button);
            this.amu = (ImageView) this.mRootView.findViewById(w.h.vide_video_channel_icon);
            this.ewW.setImageDrawable(null);
            this.ewW.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), w.f.ds40));
            this.ewW.setOnClickListener(this.aOT);
            this.amu.setOnClickListener(this.aOT);
            this.ewY.setOnClickListener(this.aOT);
            this.ewX.setOnClickListener(this.aOT);
        }
    }

    public void b(bp bpVar) {
        if (bpVar != null && this.mRootView != null) {
            this.ewZ = bpVar;
            this.ewX.setText(bpVar.channelName);
            this.ewW.c(bpVar.channelAvatar, 10, false);
            if (bpVar.ZY == 1) {
                this.ZY = 0;
            } else {
                this.ZY = bpVar.ZY;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.ZY = 2;
            }
            j(this.ZY, this.ewZ.channelId);
            Bn();
        }
    }

    public void Bn() {
        this.bdG.getLayoutMode().t(this.mRootView);
        if (this.ZY == 1) {
            this.ewY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.ewY, w.e.cp_cont_d);
            this.ewY.setText(w.l.has_ordered_channel);
            this.ewY.setVisibility(0);
        } else if (this.ZY == 2) {
            this.ewY.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.ewY, w.e.btn_forum_focus_color);
            this.ewY.setVisibility(0);
            this.ewY.setText(w.l.order_video_channel);
        } else {
            this.ewY.setVisibility(8);
        }
        aq.j(this.amu, w.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.ewZ != null && j > 0 && j == this.ewZ.channelId) {
            if (i == 1) {
                this.ewY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aq.i(this.ewY, w.e.cp_cont_d);
                this.ewY.setClickable(false);
                this.ewY.setText(w.l.has_ordered_channel);
                return;
            }
            this.ewY.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.ewY, w.e.btn_forum_focus_color);
            this.ewY.setClickable(true);
            this.ewY.setText(w.l.order_video_channel);
        }
    }
}
