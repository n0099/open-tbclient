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
public class dr extends com.baidu.adp.base.e<PbActivity> {
    private Runnable IJ;
    private View.OnClickListener aRW;
    private View bqC;
    private FlowLayout bqD;
    private TextView bqE;
    private TextView emA;
    private ViewGroup emB;
    private TextView emC;
    private ImageView emD;
    private TextView emE;
    private PbActivity emF;
    private LinearLayout emG;
    private View emH;
    private TextView emj;
    private TextView emr;
    private TextView ems;
    private TextView emt;
    private TextView emu;
    private TextView emv;
    private TextView emw;
    private TextView emx;
    private TextView emy;
    private TextView emz;
    private View mView;

    public dr(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.emj = null;
        this.emr = null;
        this.ems = null;
        this.emz = null;
        this.emA = null;
        this.emC = null;
        this.emF = null;
        this.aRW = null;
        this.emF = pbActivity;
        this.aRW = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aMf() {
        return this.emj;
    }

    public TextView aMn() {
        return this.emr;
    }

    public TextView aMo() {
        return this.ems;
    }

    public TextView aMp() {
        return this.emA;
    }

    public TextView aMq() {
        return this.emz;
    }

    public TextView aMr() {
        return this.emC;
    }

    public TextView getCancelView() {
        return this.bqE;
    }

    public View Sv() {
        return this.bqC;
    }

    public TextView aMs() {
        return this.emt;
    }

    public TextView aMt() {
        return this.emE;
    }

    public TextView aMu() {
        return this.emx;
    }

    public TextView aMv() {
        return this.emv;
    }

    public TextView aMw() {
        return this.emy;
    }

    public TextView aMx() {
        return this.emu;
    }

    public TextView aMy() {
        return this.emw;
    }

    public void Sw() {
        if (this.IJ == null) {
            this.IJ = new ds(this);
        }
        this.bqC.postDelayed(this.IJ, 200L);
    }

    public void Sx() {
        this.bqC.setBackgroundColor(this.emF.getResources().getColor(w.e.common_color_10022));
    }

    public void release() {
        this.bqC.removeCallbacks(this.IJ);
    }

    public void iv(boolean z) {
        if (z) {
            this.emA.setVisibility(0);
        } else {
            this.emA.setVisibility(8);
        }
    }

    public void iw(boolean z) {
        if (z) {
            this.emz.setVisibility(0);
        } else {
            this.emz.setVisibility(8);
        }
    }

    public void ix(boolean z) {
        this.emB.setVisibility(z ? 0 : 8);
    }

    public void iy(boolean z) {
        this.emj.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z, boolean z2) {
        this.emE.setVisibility(z ? 0 : 8);
    }

    public void iz(boolean z) {
        this.emt.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z, boolean z2) {
        this.emx.setVisibility(z ? 0 : 8);
        if (z2) {
            this.emx.setText(w.l.cancel_top);
        } else {
            this.emx.setText(w.l.top);
        }
    }

    public void x(boolean z, boolean z2) {
        this.emy.setVisibility(z ? 0 : 8);
        if (z2) {
            this.emy.setText(w.l.cancel_good);
        } else {
            this.emy.setText(w.l.commit_good);
        }
    }

    public void iA(boolean z) {
        this.emv.setVisibility(z ? 0 : 8);
    }

    public void iB(boolean z) {
        this.emu.setVisibility(z ? 0 : 8);
    }

    public void iC(boolean z) {
        this.emw.setVisibility(z ? 0 : 8);
    }

    public void aMz() {
        this.emD.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.emF.getPageContext().getPageActivity()).inflate(w.j.pb_more_pop_view, (ViewGroup) null);
        this.emj = (TextView) this.mView.findViewById(w.h.pb_more_view_item_mark);
        this.emj.setOnClickListener(this.aRW);
        this.emr = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump);
        this.emr.setOnClickListener(this.aRW);
        this.ems = (TextView) this.mView.findViewById(w.h.pb_more_view_item_see);
        this.ems.setOnClickListener(this.aRW);
        this.emA = (TextView) this.mView.findViewById(w.h.pb_more_view_item_report);
        this.emA.setOnClickListener(this.aRW);
        this.emz = (TextView) this.mView.findViewById(w.h.pb_more_view_item_upgrade_thread);
        this.emz.setOnClickListener(this.aRW);
        this.emt = (TextView) this.mView.findViewById(w.h.pb_more_view_item_share);
        this.emt.setOnClickListener(this.aRW);
        this.emu = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump_top);
        this.emu.setOnClickListener(this.aRW);
        this.emv = (TextView) this.mView.findViewById(w.h.pb_more_view_item_delete);
        this.emv.setOnClickListener(this.aRW);
        this.emw = (TextView) this.mView.findViewById(w.h.pb_more_view_item_forbidden);
        this.emw.setOnClickListener(this.aRW);
        this.emx = (TextView) this.mView.findViewById(w.h.pb_more_view_item_make_top);
        this.emx.setOnClickListener(this.aRW);
        this.emy = (TextView) this.mView.findViewById(w.h.pb_more_view_item_add_good);
        this.emy.setOnClickListener(this.aRW);
        this.emE = (TextView) this.mView.findViewById(w.h.pb_more_view_item_host_only);
        this.emE.setOnClickListener(this.aRW);
        this.emB = (ViewGroup) this.mView.findViewById(w.h.pb_more_view_item_god_call_layout);
        this.emC = (TextView) this.mView.findViewById(w.h.pb_more_view_item_god_call);
        this.emD = (ImageView) this.mView.findViewById(w.h.pb_more_view_item_god_call_tip);
        this.emC.setOnClickListener(this.aRW);
        this.emD.setVisibility(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bqC = this.mView.findViewById(w.h.pb_more_layer);
        this.bqD = (FlowLayout) this.mView.findViewById(w.h.pb_more_flowlayout);
        this.emG = (LinearLayout) this.mView.findViewById(w.h.size_seek_bar_group);
        this.emH = this.mView.findViewById(w.h.pb_more_seekbar_line);
        this.bqE = (TextView) this.mView.findViewById(w.h.pb_more_cancel);
        this.bqE.setOnClickListener(this.aRW);
        this.bqC.setOnClickListener(this.aRW);
    }

    public void SA() {
        com.baidu.tbadk.core.util.aq.k(this.bqD, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.emG, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.emH, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(this.bqE, w.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aq.c(this.bqE, w.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aq.c(this.emj, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emr, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ems, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emA, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emz, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emC, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emE, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emt, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emu, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emv, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emx, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emy, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.emw, w.e.cp_cont_j, 1);
        this.bqD.setHorizontalSpacing(((((WindowManager) this.emF.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds100) * 5)) / 4);
        this.emj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.emr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.ems.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.emA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.emz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.emC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.emD.setImageDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_chat_dot));
        this.emt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.emu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.emv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.emx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.emy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.emw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.emE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }
}
