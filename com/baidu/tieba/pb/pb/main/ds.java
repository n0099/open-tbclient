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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ds extends com.baidu.adp.base.e<PbActivity> {
    private Runnable BU;
    private View.OnClickListener aLT;
    private View bjY;
    private FlowLayout bjZ;
    private TextView bka;
    private PbActivity elA;
    private LinearLayout elB;
    private View elC;
    private TextView eld;
    private TextView ell;
    private TextView elm;
    private TextView eln;
    private TextView elo;
    private TextView elp;
    private TextView elq;
    private TextView elr;
    private TextView els;
    private TextView elt;
    private TextView elu;
    private TextView elv;
    private ViewGroup elw;
    private TextView elx;
    private ImageView ely;
    private TextView elz;
    private View mView;

    public ds(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eld = null;
        this.ell = null;
        this.elm = null;
        this.elu = null;
        this.elv = null;
        this.elx = null;
        this.elA = null;
        this.aLT = null;
        this.elA = pbActivity;
        this.aLT = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aMz() {
        return this.eld;
    }

    public TextView aMJ() {
        return this.ell;
    }

    public TextView aMK() {
        return this.elm;
    }

    public TextView aML() {
        return this.elv;
    }

    public TextView aMM() {
        return this.elu;
    }

    public TextView aMN() {
        return this.elx;
    }

    public TextView aMO() {
        return this.bka;
    }

    public View Rb() {
        return this.bjY;
    }

    public TextView aMP() {
        return this.eln;
    }

    public TextView aMQ() {
        return this.elo;
    }

    public TextView aMR() {
        return this.elz;
    }

    public TextView aMS() {
        return this.els;
    }

    public TextView aMT() {
        return this.elq;
    }

    public TextView aMU() {
        return this.elt;
    }

    public TextView aMV() {
        return this.elp;
    }

    public TextView aMW() {
        return this.elr;
    }

    public void Rc() {
        if (this.BU == null) {
            this.BU = new dt(this);
        }
        this.bjY.postDelayed(this.BU, 200L);
    }

    public void Rd() {
        this.bjY.setBackgroundColor(this.elA.getResources().getColor(r.e.common_color_10022));
    }

    public void release() {
        this.bjY.removeCallbacks(this.BU);
    }

    public void iA(boolean z) {
        if (z) {
            this.elv.setVisibility(0);
        } else {
            this.elv.setVisibility(8);
        }
    }

    public void iB(boolean z) {
        if (z) {
            this.elu.setVisibility(0);
        } else {
            this.elu.setVisibility(8);
        }
    }

    public void iC(boolean z) {
        this.elw.setVisibility(z ? 0 : 8);
    }

    public void iD(boolean z) {
        this.eln.setVisibility(z ? 0 : 8);
    }

    public void iE(boolean z) {
        this.eld.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z, boolean z2) {
        this.elz.setVisibility(z ? 0 : 8);
    }

    public void iF(boolean z) {
        this.elo.setVisibility(z ? 0 : 8);
    }

    public void x(boolean z, boolean z2) {
        this.els.setVisibility(z ? 0 : 8);
        if (z2) {
            this.els.setText(r.l.cancel_top);
        } else {
            this.els.setText(r.l.top);
        }
    }

    public void y(boolean z, boolean z2) {
        this.elt.setVisibility(z ? 0 : 8);
        if (z2) {
            this.elt.setText(r.l.cancel_good);
        } else {
            this.elt.setText(r.l.commit_good);
        }
    }

    public void iG(boolean z) {
        this.elq.setVisibility(z ? 0 : 8);
    }

    public void iH(boolean z) {
        this.elp.setVisibility(z ? 0 : 8);
    }

    public void iI(boolean z) {
        this.elr.setVisibility(z ? 0 : 8);
    }

    public void aMX() {
        this.ely.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.elA.getPageContext().getPageActivity()).inflate(r.j.pb_more_pop_view, (ViewGroup) null);
        this.eld = (TextView) this.mView.findViewById(r.h.pb_more_view_item_mark);
        this.eld.setOnClickListener(this.aLT);
        this.ell = (TextView) this.mView.findViewById(r.h.pb_more_view_item_jump);
        this.ell.setOnClickListener(this.aLT);
        this.elm = (TextView) this.mView.findViewById(r.h.pb_more_view_item_see);
        this.elm.setOnClickListener(this.aLT);
        this.elv = (TextView) this.mView.findViewById(r.h.pb_more_view_item_report);
        this.elv.setOnClickListener(this.aLT);
        this.elu = (TextView) this.mView.findViewById(r.h.pb_more_view_item_upgrade_thread);
        this.elu.setOnClickListener(this.aLT);
        this.eln = (TextView) this.mView.findViewById(r.h.pb_more_view_item_read_post);
        this.eln.setOnClickListener(this.aLT);
        this.elo = (TextView) this.mView.findViewById(r.h.pb_more_view_item_share);
        this.elo.setOnClickListener(this.aLT);
        this.elp = (TextView) this.mView.findViewById(r.h.pb_more_view_item_jump_top);
        this.elp.setOnClickListener(this.aLT);
        this.elq = (TextView) this.mView.findViewById(r.h.pb_more_view_item_delete);
        this.elq.setOnClickListener(this.aLT);
        this.elr = (TextView) this.mView.findViewById(r.h.pb_more_view_item_forbidden);
        this.elr.setOnClickListener(this.aLT);
        this.els = (TextView) this.mView.findViewById(r.h.pb_more_view_item_make_top);
        this.els.setOnClickListener(this.aLT);
        this.elt = (TextView) this.mView.findViewById(r.h.pb_more_view_item_add_good);
        this.elt.setOnClickListener(this.aLT);
        this.elz = (TextView) this.mView.findViewById(r.h.pb_more_view_item_host_only);
        this.elz.setOnClickListener(this.aLT);
        this.elw = (ViewGroup) this.mView.findViewById(r.h.pb_more_view_item_god_call_layout);
        this.elx = (TextView) this.mView.findViewById(r.h.pb_more_view_item_god_call);
        this.ely = (ImageView) this.mView.findViewById(r.h.pb_more_view_item_god_call_tip);
        this.elx.setOnClickListener(this.aLT);
        this.ely.setVisibility(com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bjY = this.mView.findViewById(r.h.pb_more_layer);
        this.bjZ = (FlowLayout) this.mView.findViewById(r.h.pb_more_flowlayout);
        this.elB = (LinearLayout) this.mView.findViewById(r.h.size_seek_bar_group);
        this.elC = this.mView.findViewById(r.h.pb_more_seekbar_line);
        this.bka = (TextView) this.mView.findViewById(r.h.pb_more_cancel);
        this.bka.setOnClickListener(this.aLT);
        this.bjY.setOnClickListener(this.aLT);
    }

    public void Rg() {
        com.baidu.tbadk.core.util.ap.k(this.bjZ, r.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ap.k(this.elB, r.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ap.k(this.elC, r.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.ap.j((View) this.bka, r.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ap.c(this.bka, r.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.c(this.eld, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.ell, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elm, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elv, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elu, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elx, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elz, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.eln, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elo, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elp, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elq, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.els, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elt, r.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.c(this.elr, r.e.cp_cont_j, 1);
        this.bjZ.setHorizontalSpacing(((((WindowManager) this.elA.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.f.ds100) * 5)) / 4);
        this.eld.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.ell.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.elm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.elv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.elu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.elx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.ely.setImageDrawable(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_chat_dot));
        this.eln.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_readthread_selector), (Drawable) null, (Drawable) null);
        this.elo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.elp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.elq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.els.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.elt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.elr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.elz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }
}
