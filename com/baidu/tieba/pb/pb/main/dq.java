package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.view.FlowLayout;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class dq extends com.baidu.adp.base.f<PbActivity> {
    private Runnable Au;
    private View.OnClickListener afk;
    private PbActivity dXE;
    private TextView edX;
    private TextView eef;
    private TextView eeg;
    private TextView eeh;
    private TextView eei;
    public TextView eej;
    private ViewGroup eek;
    private TextView eel;
    private ImageView eem;
    private View een;
    private FlowLayout eeo;
    private LinearLayout eep;
    private TextView eeq;
    private View eer;
    private View mView;

    public dq(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.edX = null;
        this.eef = null;
        this.eeg = null;
        this.eeh = null;
        this.eei = null;
        this.eel = null;
        this.dXE = null;
        this.afk = null;
        this.dXE = pbActivity;
        this.afk = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aJv() {
        return this.edX;
    }

    public TextView aJE() {
        return this.eef;
    }

    public TextView aJF() {
        return this.eeg;
    }

    public TextView aJG() {
        return this.eei;
    }

    public TextView aJH() {
        return this.eeh;
    }

    public TextView aJI() {
        return this.eel;
    }

    public TextView aJJ() {
        return this.eeq;
    }

    public View aJK() {
        return this.een;
    }

    public void aJL() {
        if (this.Au == null) {
            this.Au = new dr(this);
        }
        this.een.postDelayed(this.Au, 200L);
    }

    public void aJM() {
        this.een.setBackgroundColor(this.dXE.getResources().getColor(u.d.common_color_10022));
    }

    public void release() {
        this.een.removeCallbacks(this.Au);
    }

    public void hN(boolean z) {
        if (z) {
            this.eei.setVisibility(8);
        } else {
            this.eei.setVisibility(0);
        }
    }

    public void hO(boolean z) {
        if (z) {
            this.eej.setVisibility(8);
        } else {
            this.eej.setVisibility(0);
        }
    }

    public void hP(boolean z) {
        if (z) {
            this.eeh.setVisibility(8);
        } else {
            this.eeh.setVisibility(0);
        }
    }

    public void hQ(boolean z) {
        this.eek.setVisibility(z ? 0 : 8);
    }

    public void aJN() {
        this.eem.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.dXE.getPageContext().getPageActivity()).inflate(u.h.pb_more_pop_view, (ViewGroup) null);
        this.edX = (TextView) this.mView.findViewById(u.g.pb_more_view_item_mark);
        this.edX.setOnClickListener(this.afk);
        this.eef = (TextView) this.mView.findViewById(u.g.pb_more_view_item_jump);
        this.eef.setOnClickListener(this.afk);
        this.eeg = (TextView) this.mView.findViewById(u.g.pb_more_view_item_see);
        this.eeg.setOnClickListener(this.afk);
        this.eei = (TextView) this.mView.findViewById(u.g.pb_more_view_item_report);
        this.eei.setOnClickListener(this.afk);
        this.eej = (TextView) this.mView.findViewById(u.g.pb_more_view_item_report_ecomm);
        this.eej.setOnClickListener(this.afk);
        this.eeh = (TextView) this.mView.findViewById(u.g.pb_more_view_item_upgrade_thread);
        this.eeh.setOnClickListener(this.afk);
        this.eek = (ViewGroup) this.mView.findViewById(u.g.pb_more_view_item_god_call_layout);
        this.eel = (TextView) this.mView.findViewById(u.g.pb_more_view_item_god_call);
        this.eem = (ImageView) this.mView.findViewById(u.g.pb_more_view_item_god_call_tip);
        this.eel.setOnClickListener(this.afk);
        this.eem.setVisibility(com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.een = this.mView.findViewById(u.g.pb_more_layer);
        this.eeo = (FlowLayout) this.mView.findViewById(u.g.pb_more_flowlayout);
        this.eep = (LinearLayout) this.mView.findViewById(u.g.size_seek_bar_group);
        this.eer = this.mView.findViewById(u.g.pb_more_seekbar_line);
        this.eeq = (TextView) this.mView.findViewById(u.g.pb_more_cancel);
        this.eeq.setOnClickListener(this.afk);
        this.een.setOnClickListener(this.afk);
    }

    public void aJO() {
        com.baidu.tbadk.core.util.av.l(this.eeo, u.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.eep, u.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.eer, u.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.av.k(this.eeq, u.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.av.c(this.eeq, u.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.av.c(this.edX, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eef, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eeg, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eei, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eej, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eeh, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eel, u.d.cp_cont_c, 1);
        this.eeo.setHorizontalSpacing(((((WindowManager) this.dXE.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m10getInst().getContext().getResources().getDimensionPixelSize(u.e.ds80)) - (TbadkCoreApplication.m10getInst().getContext().getResources().getDimensionPixelSize(u.e.ds130) * 4)) / 3);
        this.edX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eef.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eeg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eei.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eej.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eeh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eel.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eem.setImageDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_chat_dot));
    }
}
