package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    public int Zt;
    private View.OnClickListener aPm = new f(this);
    private ImageView amD;
    public BaseActivity bdY;
    public HeadImageView esG;
    public TextView esH;
    public TextView esI;
    private br esJ;
    public View mRootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bdY = baseActivity;
            this.mRootView = view;
            this.esG = (HeadImageView) this.mRootView.findViewById(w.h.vide_video_channel_photo);
            this.esG.setDefaultResource(w.g.avatar_channel_poto_defaul160);
            this.esG.setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
            this.esH = (TextView) this.mRootView.findViewById(w.h.vide_video_channel_name);
            this.esI = (TextView) this.mRootView.findViewById(w.h.pb_video_order_button);
            this.amD = (ImageView) this.mRootView.findViewById(w.h.vide_video_channel_icon);
            this.esG.setImageDrawable(null);
            this.esG.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), w.f.ds40));
            this.esG.setOnClickListener(this.aPm);
            this.amD.setOnClickListener(this.aPm);
            this.esI.setOnClickListener(this.aPm);
            this.esH.setOnClickListener(this.aPm);
        }
    }

    public void b(br brVar) {
        if (brVar != null && this.mRootView != null) {
            this.esJ = brVar;
            this.esH.setText(brVar.channelName);
            this.esG.c(brVar.channelAvatar, 10, false);
            if (brVar.Zt == 1) {
                this.Zt = 0;
            } else {
                this.Zt = brVar.Zt;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.Zt = 2;
            }
            j(this.Zt, this.esJ.channelId);
            Ay();
        }
    }

    public void Ay() {
        this.bdY.getLayoutMode().t(this.mRootView);
        if (this.Zt == 1) {
            this.esI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.esI, w.e.cp_cont_d);
            this.esI.setText(w.l.has_ordered_channel);
            this.esI.setVisibility(0);
        } else if (this.Zt == 2) {
            this.esI.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.esI, w.e.btn_forum_focus_color);
            this.esI.setVisibility(0);
            this.esI.setText(w.l.order_video_channel);
        } else {
            this.esI.setVisibility(8);
        }
        aq.j(this.amD, w.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.esJ != null && j > 0 && j == this.esJ.channelId) {
            if (i == 1) {
                this.esI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aq.i(this.esI, w.e.cp_cont_d);
                this.esI.setClickable(false);
                this.esI.setText(w.l.has_ordered_channel);
                return;
            }
            this.esI.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.esI, w.e.btn_forum_focus_color);
            this.esI.setClickable(true);
            this.esI.setText(w.l.order_video_channel);
        }
    }
}
