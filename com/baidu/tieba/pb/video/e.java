package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    public int Zs;
    private View.OnClickListener aPl = new f(this);
    private bs baU;
    public BaseActivity bfa;
    public HeadImageView ezP;
    public TextView ezQ;
    public ImageView ezR;
    public LinearLayout ezS;
    public TextView ezT;
    public TextView ezU;
    public LinearLayout ezV;
    public TextView ezW;
    public RelativeLayout ezX;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bfa = baseActivity;
            this.rootView = view;
            this.ezP = (HeadImageView) this.rootView.findViewById(w.h.pb_video_channel_photo);
            this.ezQ = (TextView) this.rootView.findViewById(w.h.pb_video_channel_name);
            this.ezR = (ImageView) this.rootView.findViewById(w.h.pb_video_channel_icon);
            this.ezS = (LinearLayout) this.rootView.findViewById(w.h.pb_video_channel_panel);
            this.ezT = (TextView) this.rootView.findViewById(w.h.pb_video_channel_publish_time);
            this.ezU = (TextView) this.rootView.findViewById(w.h.pb_video_channel_location_address);
            this.ezV = (LinearLayout) this.rootView.findViewById(w.h.pb_video_channel_sub_panel);
            this.ezW = (TextView) this.rootView.findViewById(w.h.pb_video_order_button);
            this.ezX = (RelativeLayout) this.rootView.findViewById(w.h.video_pb_header_channel_info_root);
            this.ezP.setImageDrawable(null);
            this.ezP.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), w.f.ds40));
            this.ezP.setOnClickListener(this.aPl);
            this.ezR.setOnClickListener(this.aPl);
            this.ezW.setOnClickListener(this.aPl);
            this.ezQ.setOnClickListener(this.aPl);
        }
    }

    public void Q(bl blVar) {
        if (blVar != null && blVar.sx() != null && this.rootView != null) {
            this.baU = blVar.sx();
            this.ezT.setText(au.q(blVar.getCreateTime()));
            this.ezU.setText(blVar.getAddress());
            this.ezQ.setText(this.baU.channelName);
            this.ezP.c(this.baU.channelAvatar, 10, false);
            if (this.baU.Zs == 1) {
                this.Zs = 0;
            } else {
                this.Zs = this.baU.Zs;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.Zs = 2;
            }
            j(this.Zs, this.baU.channelId);
            Ar();
        }
    }

    public void Ar() {
        this.bfa.getLayoutMode().t(this.rootView);
        if (this.Zs == 1) {
            this.ezW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.ezW, w.e.cp_cont_d);
            this.ezW.setText(w.l.has_ordered_channel);
            this.ezW.setVisibility(0);
        } else if (this.Zs == 2) {
            this.ezW.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.ezW, w.e.btn_forum_focus_color);
            this.ezW.setVisibility(0);
            this.ezW.setText(w.l.order_video_channel);
        } else {
            this.ezW.setVisibility(8);
        }
        aq.i(this.ezQ, w.e.cp_cont_f);
        aq.i(this.ezT, w.e.cp_cont_f);
        aq.i(this.ezU, w.e.cp_cont_f);
        aq.j(this.ezR, w.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.baU != null && j > 0 && j == this.baU.channelId) {
            if (i == 1) {
                this.ezW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aq.i(this.ezW, w.e.cp_cont_d);
                this.ezW.setClickable(false);
                this.ezW.setText(w.l.has_ordered_channel);
                return;
            }
            this.ezW.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.ezW, w.e.btn_forum_focus_color);
            this.ezW.setClickable(true);
            this.ezW.setText(w.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aOL() {
        return this.ezW;
    }
}
