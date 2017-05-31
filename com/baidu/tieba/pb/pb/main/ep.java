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
public class ep extends com.baidu.adp.base.e<PbActivity> {
    private Runnable aDz;
    private View.OnClickListener bhc;
    private TextView buA;
    private View bux;
    private FlowLayout buz;
    private TextView bvL;
    private TextView eqA;
    private TextView eqB;
    private TextView eqC;
    private TextView eqD;
    private TextView eqE;
    private ViewGroup eqF;
    private TextView eqG;
    private ImageView eqH;
    private TextView eqI;
    private PbActivity eqJ;
    private LinearLayout eqK;
    private View eqL;
    private TextView eqm;
    private TextView eqw;
    private TextView eqx;
    private TextView eqy;
    private TextView eqz;
    private View mView;

    public ep(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eqm = null;
        this.eqw = null;
        this.eqx = null;
        this.eqD = null;
        this.eqE = null;
        this.eqG = null;
        this.eqJ = null;
        this.bhc = null;
        this.eqJ = pbActivity;
        this.bhc = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aLt() {
        return this.eqm;
    }

    public TextView aLB() {
        return this.eqw;
    }

    public TextView aLC() {
        return this.eqx;
    }

    public TextView aLD() {
        return this.eqE;
    }

    public TextView aLE() {
        return this.eqD;
    }

    public TextView aLF() {
        return this.eqG;
    }

    public TextView getCancelView() {
        return this.buA;
    }

    public View Td() {
        return this.bux;
    }

    public TextView aLG() {
        return this.eqI;
    }

    public TextView aLH() {
        return this.eqB;
    }

    public TextView aLI() {
        return this.bvL;
    }

    public TextView aLJ() {
        return this.eqC;
    }

    public TextView aLK() {
        return this.eqz;
    }

    public TextView aLL() {
        return this.eqA;
    }

    public TextView aLM() {
        return this.eqy;
    }

    public void Te() {
        if (this.aDz == null) {
            this.aDz = new eq(this);
        }
        this.bux.postDelayed(this.aDz, 200L);
    }

    public void Tf() {
        this.bux.setBackgroundColor(this.eqJ.getResources().getColor(w.e.common_color_10022));
    }

    public void release() {
        this.bux.removeCallbacks(this.aDz);
    }

    public void iz(boolean z) {
        if (z) {
            this.eqE.setVisibility(0);
        } else {
            this.eqE.setVisibility(8);
        }
    }

    public void iA(boolean z) {
        if (z) {
            this.eqD.setVisibility(0);
        } else {
            this.eqD.setVisibility(8);
        }
    }

    public void iB(boolean z) {
        this.eqF.setVisibility(z ? 0 : 8);
    }

    public void iC(boolean z) {
        this.eqm.setVisibility(z ? 0 : 8);
    }

    public void y(boolean z, boolean z2) {
        this.eqI.setVisibility(z ? 0 : 8);
    }

    public void z(boolean z, boolean z2) {
        this.eqB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eqB.setText(w.l.cancel_top);
        } else {
            this.eqB.setText(w.l.top);
        }
    }

    public void A(boolean z, boolean z2) {
        this.eqC.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eqC.setText(w.l.cancel_good);
        } else {
            this.eqC.setText(w.l.commit_good);
        }
    }

    public void iD(boolean z) {
        this.bvL.setVisibility(z ? 0 : 8);
    }

    public void iE(boolean z) {
        this.eqz.setVisibility(z ? 0 : 8);
    }

    public void iF(boolean z) {
        this.eqA.setVisibility(z ? 0 : 8);
    }

    public void iG(boolean z) {
        this.eqy.setVisibility(z ? 0 : 8);
    }

    public void aLN() {
        this.eqH.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eqJ.getPageContext().getPageActivity()).inflate(w.j.pb_more_pop_view, (ViewGroup) null);
        this.eqm = (TextView) this.mView.findViewById(w.h.pb_more_view_item_mark);
        this.eqm.setOnClickListener(this.bhc);
        this.eqw = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump);
        this.eqw.setOnClickListener(this.bhc);
        this.eqx = (TextView) this.mView.findViewById(w.h.pb_more_view_item_see);
        this.eqx.setOnClickListener(this.bhc);
        this.eqE = (TextView) this.mView.findViewById(w.h.pb_more_view_item_report);
        this.eqE.setOnClickListener(this.bhc);
        this.eqD = (TextView) this.mView.findViewById(w.h.pb_more_view_item_upgrade_thread);
        this.eqD.setOnClickListener(this.bhc);
        this.eqz = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump_top);
        this.eqz.setOnClickListener(this.bhc);
        this.bvL = (TextView) this.mView.findViewById(w.h.pb_more_view_item_delete);
        this.bvL.setOnClickListener(this.bhc);
        this.eqA = (TextView) this.mView.findViewById(w.h.pb_more_view_item_forbidden);
        this.eqA.setOnClickListener(this.bhc);
        this.eqB = (TextView) this.mView.findViewById(w.h.pb_more_view_item_make_top);
        this.eqB.setOnClickListener(this.bhc);
        this.eqC = (TextView) this.mView.findViewById(w.h.pb_more_view_item_add_good);
        this.eqC.setOnClickListener(this.bhc);
        this.eqI = (TextView) this.mView.findViewById(w.h.pb_more_view_item_host_only);
        this.eqI.setOnClickListener(this.bhc);
        this.eqy = (TextView) this.mView.findViewById(w.h.pb_more_view_item_share);
        this.eqy.setOnClickListener(this.bhc);
        this.eqF = (ViewGroup) this.mView.findViewById(w.h.pb_more_view_item_god_call_layout);
        this.eqG = (TextView) this.mView.findViewById(w.h.pb_more_view_item_god_call);
        this.eqH = (ImageView) this.mView.findViewById(w.h.pb_more_view_item_god_call_tip);
        this.eqG.setOnClickListener(this.bhc);
        this.eqH.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bux = this.mView.findViewById(w.h.pb_more_layer);
        this.buz = (FlowLayout) this.mView.findViewById(w.h.pb_more_flowlayout);
        this.eqK = (LinearLayout) this.mView.findViewById(w.h.size_seek_bar_group);
        this.eqL = this.mView.findViewById(w.h.pb_more_seekbar_line);
        this.buA = (TextView) this.mView.findViewById(w.h.pb_more_cancel);
        this.buA.setOnClickListener(this.bhc);
        this.bux.setOnClickListener(this.bhc);
    }

    public void Ti() {
        com.baidu.tbadk.core.util.aq.k(this.buz, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.eqK, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.eqL, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(this.buA, w.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aq.c(this.buA, w.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqm, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqw, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqx, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqE, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqD, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqG, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqI, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqz, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.bvL, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqB, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqC, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqA, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eqy, w.e.cp_cont_j, 1);
        this.buz.setHorizontalSpacing(((((WindowManager) this.eqJ.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds100) * 5)) / 4);
        this.eqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eqw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eqx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eqE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eqD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eqG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eqH.setImageDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_chat_dot));
        this.eqy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eqz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bvL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eqB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eqC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eqA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eqI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean aW(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bux || view == this.buA || view == this.bvL) ? false : true;
    }
}
