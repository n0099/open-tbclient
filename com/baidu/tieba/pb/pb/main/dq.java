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
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dq extends com.baidu.adp.base.f<PbActivity> {
    private Runnable CI;
    private View.OnClickListener aif;
    private PbActivity ejJ;
    private TextView eqc;
    private TextView eqk;
    private TextView eql;
    private TextView eqm;
    private TextView eqn;
    public TextView eqo;
    private ViewGroup eqp;
    private TextView eqq;
    private ImageView eqr;
    private View eqs;
    private FlowLayout eqt;
    private LinearLayout equ;
    private TextView eqv;
    private View eqw;
    private View mView;

    public dq(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eqc = null;
        this.eqk = null;
        this.eql = null;
        this.eqm = null;
        this.eqn = null;
        this.eqq = null;
        this.ejJ = null;
        this.aif = null;
        this.ejJ = pbActivity;
        this.aif = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aOm() {
        return this.eqc;
    }

    public TextView aOv() {
        return this.eqk;
    }

    public TextView aOw() {
        return this.eql;
    }

    public TextView aOx() {
        return this.eqn;
    }

    public TextView aOy() {
        return this.eqm;
    }

    public TextView aOz() {
        return this.eqq;
    }

    public TextView aOA() {
        return this.eqv;
    }

    public View aOB() {
        return this.eqs;
    }

    public void aOC() {
        if (this.CI == null) {
            this.CI = new dr(this);
        }
        this.eqs.postDelayed(this.CI, 200L);
    }

    public void aOD() {
        this.eqs.setBackgroundColor(this.ejJ.getResources().getColor(t.d.common_color_10022));
    }

    public void release() {
        this.eqs.removeCallbacks(this.CI);
    }

    public void ii(boolean z) {
        if (z) {
            this.eqn.setVisibility(8);
        } else {
            this.eqn.setVisibility(0);
        }
    }

    public void ij(boolean z) {
        if (z) {
            this.eqo.setVisibility(8);
        } else {
            this.eqo.setVisibility(0);
        }
    }

    public void ik(boolean z) {
        if (z) {
            this.eqm.setVisibility(8);
        } else {
            this.eqm.setVisibility(0);
        }
    }

    public void il(boolean z) {
        this.eqp.setVisibility(z ? 0 : 8);
    }

    public void aOE() {
        this.eqr.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ejJ.getPageContext().getPageActivity()).inflate(t.h.pb_more_pop_view, (ViewGroup) null);
        this.eqc = (TextView) this.mView.findViewById(t.g.pb_more_view_item_mark);
        this.eqc.setOnClickListener(this.aif);
        this.eqk = (TextView) this.mView.findViewById(t.g.pb_more_view_item_jump);
        this.eqk.setOnClickListener(this.aif);
        this.eql = (TextView) this.mView.findViewById(t.g.pb_more_view_item_see);
        this.eql.setOnClickListener(this.aif);
        this.eqn = (TextView) this.mView.findViewById(t.g.pb_more_view_item_report);
        this.eqn.setOnClickListener(this.aif);
        this.eqo = (TextView) this.mView.findViewById(t.g.pb_more_view_item_report_ecomm);
        this.eqo.setOnClickListener(this.aif);
        this.eqm = (TextView) this.mView.findViewById(t.g.pb_more_view_item_upgrade_thread);
        this.eqm.setOnClickListener(this.aif);
        this.eqp = (ViewGroup) this.mView.findViewById(t.g.pb_more_view_item_god_call_layout);
        this.eqq = (TextView) this.mView.findViewById(t.g.pb_more_view_item_god_call);
        this.eqr = (ImageView) this.mView.findViewById(t.g.pb_more_view_item_god_call_tip);
        this.eqq.setOnClickListener(this.aif);
        this.eqr.setVisibility(com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.eqs = this.mView.findViewById(t.g.pb_more_layer);
        this.eqt = (FlowLayout) this.mView.findViewById(t.g.pb_more_flowlayout);
        this.equ = (LinearLayout) this.mView.findViewById(t.g.size_seek_bar_group);
        this.eqw = this.mView.findViewById(t.g.pb_more_seekbar_line);
        this.eqv = (TextView) this.mView.findViewById(t.g.pb_more_cancel);
        this.eqv.setOnClickListener(this.aif);
        this.eqs.setOnClickListener(this.aif);
    }

    public void aOF() {
        com.baidu.tbadk.core.util.av.l(this.eqt, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.equ, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.eqw, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.av.k(this.eqv, t.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.av.c(this.eqv, t.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.av.c(this.eqc, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eqk, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eql, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eqn, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eqo, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eqm, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eqq, t.d.cp_cont_c, 1);
        this.eqt.setHorizontalSpacing(((((WindowManager) this.ejJ.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(t.e.ds80)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(t.e.ds130) * 4)) / 3);
        this.eqc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eqk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eql.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eqn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eqo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eqq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eqr.setImageDrawable(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_chat_dot));
    }
}
