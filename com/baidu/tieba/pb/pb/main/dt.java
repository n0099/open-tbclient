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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dt extends com.baidu.adp.base.e<PbActivity> {
    private Runnable Jj;
    private View.OnClickListener aRG;
    private View bqJ;
    private FlowLayout bqK;
    private TextView bqL;
    private View eoA;
    private TextView eob;
    private TextView eok;
    private TextView eol;
    private TextView eom;
    private TextView eon;
    private TextView eoo;
    private TextView eop;
    private TextView eoq;
    private TextView eor;
    private TextView eos;
    private TextView eot;
    private ViewGroup eou;
    private TextView eov;
    private ImageView eow;
    private TextView eox;
    private PbActivity eoy;
    private LinearLayout eoz;
    private View mView;

    public dt(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eob = null;
        this.eok = null;
        this.eol = null;
        this.eos = null;
        this.eot = null;
        this.eov = null;
        this.eoy = null;
        this.aRG = null;
        this.eoy = pbActivity;
        this.aRG = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aLW() {
        return this.eob;
    }

    public TextView aMe() {
        return this.eok;
    }

    public TextView aMf() {
        return this.eol;
    }

    public TextView aMg() {
        return this.eot;
    }

    public TextView aMh() {
        return this.eos;
    }

    public TextView aMi() {
        return this.eov;
    }

    public TextView getCancelView() {
        return this.bqL;
    }

    public View RX() {
        return this.bqJ;
    }

    public TextView aMj() {
        return this.eom;
    }

    public TextView aMk() {
        return this.eox;
    }

    public TextView aMl() {
        return this.eoq;
    }

    public TextView aMm() {
        return this.eoo;
    }

    public TextView aMn() {
        return this.eor;
    }

    public TextView aMo() {
        return this.eon;
    }

    public TextView aMp() {
        return this.eop;
    }

    public void RY() {
        if (this.Jj == null) {
            this.Jj = new du(this);
        }
        this.bqJ.postDelayed(this.Jj, 200L);
    }

    public void RZ() {
        this.bqJ.setBackgroundColor(this.eoy.getResources().getColor(w.e.common_color_10022));
    }

    public void release() {
        this.bqJ.removeCallbacks(this.Jj);
    }

    public void iw(boolean z) {
        if (z) {
            this.eot.setVisibility(0);
        } else {
            this.eot.setVisibility(8);
        }
    }

    public void ix(boolean z) {
        if (z) {
            this.eos.setVisibility(0);
        } else {
            this.eos.setVisibility(8);
        }
    }

    public void iy(boolean z) {
        this.eou.setVisibility(z ? 0 : 8);
    }

    public void iz(boolean z) {
        this.eob.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z, boolean z2) {
        this.eox.setVisibility(z ? 0 : 8);
    }

    public void iA(boolean z) {
        this.eom.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z, boolean z2) {
        this.eoq.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eoq.setText(w.l.cancel_top);
        } else {
            this.eoq.setText(w.l.top);
        }
    }

    public void x(boolean z, boolean z2) {
        this.eor.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eor.setText(w.l.cancel_good);
        } else {
            this.eor.setText(w.l.commit_good);
        }
    }

    public void iB(boolean z) {
        this.eoo.setVisibility(z ? 0 : 8);
    }

    public void iC(boolean z) {
        this.eon.setVisibility(z ? 0 : 8);
    }

    public void iD(boolean z) {
        this.eop.setVisibility(z ? 0 : 8);
    }

    public void aMq() {
        this.eow.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eoy.getPageContext().getPageActivity()).inflate(w.j.pb_more_pop_view, (ViewGroup) null);
        this.eob = (TextView) this.mView.findViewById(w.h.pb_more_view_item_mark);
        this.eob.setOnClickListener(this.aRG);
        this.eok = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump);
        this.eok.setOnClickListener(this.aRG);
        this.eol = (TextView) this.mView.findViewById(w.h.pb_more_view_item_see);
        this.eol.setOnClickListener(this.aRG);
        this.eot = (TextView) this.mView.findViewById(w.h.pb_more_view_item_report);
        this.eot.setOnClickListener(this.aRG);
        this.eos = (TextView) this.mView.findViewById(w.h.pb_more_view_item_upgrade_thread);
        this.eos.setOnClickListener(this.aRG);
        this.eom = (TextView) this.mView.findViewById(w.h.pb_more_view_item_share);
        this.eom.setOnClickListener(this.aRG);
        this.eon = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump_top);
        this.eon.setOnClickListener(this.aRG);
        this.eoo = (TextView) this.mView.findViewById(w.h.pb_more_view_item_delete);
        this.eoo.setOnClickListener(this.aRG);
        this.eop = (TextView) this.mView.findViewById(w.h.pb_more_view_item_forbidden);
        this.eop.setOnClickListener(this.aRG);
        this.eoq = (TextView) this.mView.findViewById(w.h.pb_more_view_item_make_top);
        this.eoq.setOnClickListener(this.aRG);
        this.eor = (TextView) this.mView.findViewById(w.h.pb_more_view_item_add_good);
        this.eor.setOnClickListener(this.aRG);
        this.eox = (TextView) this.mView.findViewById(w.h.pb_more_view_item_host_only);
        this.eox.setOnClickListener(this.aRG);
        this.eou = (ViewGroup) this.mView.findViewById(w.h.pb_more_view_item_god_call_layout);
        this.eov = (TextView) this.mView.findViewById(w.h.pb_more_view_item_god_call);
        this.eow = (ImageView) this.mView.findViewById(w.h.pb_more_view_item_god_call_tip);
        this.eov.setOnClickListener(this.aRG);
        this.eow.setVisibility(com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bqJ = this.mView.findViewById(w.h.pb_more_layer);
        this.bqK = (FlowLayout) this.mView.findViewById(w.h.pb_more_flowlayout);
        this.eoz = (LinearLayout) this.mView.findViewById(w.h.size_seek_bar_group);
        this.eoA = this.mView.findViewById(w.h.pb_more_seekbar_line);
        this.bqL = (TextView) this.mView.findViewById(w.h.pb_more_cancel);
        this.bqL.setOnClickListener(this.aRG);
        this.bqJ.setOnClickListener(this.aRG);
    }

    public void Sc() {
        com.baidu.tbadk.core.util.aq.k(this.bqK, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.eoz, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.eoA, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(this.bqL, w.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aq.c(this.bqL, w.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aq.c(this.eob, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eok, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eol, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eot, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eos, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eov, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eox, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eom, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eon, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoo, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoq, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eor, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eop, w.e.cp_cont_j, 1);
        this.bqK.setHorizontalSpacing(((((WindowManager) this.eoy.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds100) * 5)) / 4);
        this.eob.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eok.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eol.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eot.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eos.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eov.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eow.setImageDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_chat_dot));
        this.eom.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.eoo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eoq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eor.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eop.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }
}
