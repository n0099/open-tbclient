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
public class dl extends com.baidu.adp.base.f<PbActivity> {
    private Runnable CJ;
    private View.OnClickListener aMS;
    private View bai;
    private FlowLayout baj;
    private TextView bak;
    private TextView ecA;
    private TextView ecB;
    private TextView ecC;
    private TextView ecD;
    private TextView ecE;
    private ViewGroup ecF;
    private TextView ecG;
    private ImageView ecH;
    private PbActivity ecI;
    private LinearLayout ecJ;
    private View ecK;
    private TextView ecm;
    private TextView ecu;
    private TextView ecv;
    private TextView ecw;
    private TextView ecx;
    private TextView ecy;
    private TextView ecz;
    private View mView;

    public dl(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.ecm = null;
        this.ecu = null;
        this.ecv = null;
        this.ecD = null;
        this.ecE = null;
        this.ecG = null;
        this.ecI = null;
        this.aMS = null;
        this.ecI = pbActivity;
        this.aMS = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aKM() {
        return this.ecm;
    }

    public TextView aKW() {
        return this.ecu;
    }

    public TextView aKX() {
        return this.ecv;
    }

    public TextView aKY() {
        return this.ecE;
    }

    public TextView aKZ() {
        return this.ecD;
    }

    public TextView aLa() {
        return this.ecG;
    }

    public TextView aLb() {
        return this.bak;
    }

    public View Oi() {
        return this.bai;
    }

    public TextView aLc() {
        return this.ecw;
    }

    public TextView aLd() {
        return this.ecx;
    }

    public TextView aLe() {
        return this.ecB;
    }

    public TextView aLf() {
        return this.ecz;
    }

    public TextView aLg() {
        return this.ecC;
    }

    public TextView aLh() {
        return this.ecy;
    }

    public TextView aLi() {
        return this.ecA;
    }

    public void Oj() {
        if (this.CJ == null) {
            this.CJ = new dm(this);
        }
        this.bai.postDelayed(this.CJ, 200L);
    }

    public void Ok() {
        this.bai.setBackgroundColor(this.ecI.getResources().getColor(r.d.common_color_10022));
    }

    public void release() {
        this.bai.removeCallbacks(this.CJ);
    }

    public void iq(boolean z) {
        if (z) {
            this.ecE.setVisibility(0);
        } else {
            this.ecE.setVisibility(8);
        }
    }

    public void ir(boolean z) {
        if (z) {
            this.ecD.setVisibility(0);
        } else {
            this.ecD.setVisibility(8);
        }
    }

    public void is(boolean z) {
        this.ecF.setVisibility(z ? 0 : 8);
    }

    public void it(boolean z) {
        this.ecw.setVisibility(z ? 0 : 8);
    }

    public void iu(boolean z) {
        this.ecm.setVisibility(z ? 0 : 8);
    }

    public void iv(boolean z) {
        this.ecx.setVisibility(z ? 0 : 8);
    }

    public void y(boolean z, boolean z2) {
        this.ecB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ecB.setText(r.j.cancel_top);
        } else {
            this.ecB.setText(r.j.top);
        }
    }

    public void z(boolean z, boolean z2) {
        this.ecC.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ecC.setText(r.j.cancel_good);
        } else {
            this.ecC.setText(r.j.commit_good);
        }
    }

    public void iw(boolean z) {
        this.ecz.setVisibility(z ? 0 : 8);
    }

    public void ix(boolean z) {
        this.ecy.setVisibility(z ? 0 : 8);
    }

    public void iy(boolean z) {
        this.ecA.setVisibility(z ? 0 : 8);
    }

    public void aLj() {
        this.ecH.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ecI.getPageContext().getPageActivity()).inflate(r.h.pb_more_pop_view, (ViewGroup) null);
        this.ecm = (TextView) this.mView.findViewById(r.g.pb_more_view_item_mark);
        this.ecm.setOnClickListener(this.aMS);
        this.ecu = (TextView) this.mView.findViewById(r.g.pb_more_view_item_jump);
        this.ecu.setOnClickListener(this.aMS);
        this.ecv = (TextView) this.mView.findViewById(r.g.pb_more_view_item_see);
        this.ecv.setOnClickListener(this.aMS);
        this.ecE = (TextView) this.mView.findViewById(r.g.pb_more_view_item_report);
        this.ecE.setOnClickListener(this.aMS);
        this.ecD = (TextView) this.mView.findViewById(r.g.pb_more_view_item_upgrade_thread);
        this.ecD.setOnClickListener(this.aMS);
        this.ecw = (TextView) this.mView.findViewById(r.g.pb_more_view_item_read_post);
        this.ecw.setOnClickListener(this.aMS);
        this.ecx = (TextView) this.mView.findViewById(r.g.pb_more_view_item_share);
        this.ecx.setOnClickListener(this.aMS);
        this.ecy = (TextView) this.mView.findViewById(r.g.pb_more_view_item_jump_top);
        this.ecy.setOnClickListener(this.aMS);
        this.ecz = (TextView) this.mView.findViewById(r.g.pb_more_view_item_delete);
        this.ecz.setOnClickListener(this.aMS);
        this.ecA = (TextView) this.mView.findViewById(r.g.pb_more_view_item_forbidden);
        this.ecA.setOnClickListener(this.aMS);
        this.ecB = (TextView) this.mView.findViewById(r.g.pb_more_view_item_make_top);
        this.ecB.setOnClickListener(this.aMS);
        this.ecC = (TextView) this.mView.findViewById(r.g.pb_more_view_item_add_good);
        this.ecC.setOnClickListener(this.aMS);
        this.ecF = (ViewGroup) this.mView.findViewById(r.g.pb_more_view_item_god_call_layout);
        this.ecG = (TextView) this.mView.findViewById(r.g.pb_more_view_item_god_call);
        this.ecH = (ImageView) this.mView.findViewById(r.g.pb_more_view_item_god_call_tip);
        this.ecG.setOnClickListener(this.aMS);
        this.ecH.setVisibility(com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bai = this.mView.findViewById(r.g.pb_more_layer);
        this.baj = (FlowLayout) this.mView.findViewById(r.g.pb_more_flowlayout);
        this.ecJ = (LinearLayout) this.mView.findViewById(r.g.size_seek_bar_group);
        this.ecK = this.mView.findViewById(r.g.pb_more_seekbar_line);
        this.bak = (TextView) this.mView.findViewById(r.g.pb_more_cancel);
        this.bak.setOnClickListener(this.aMS);
        this.bai.setOnClickListener(this.aMS);
    }

    public void On() {
        com.baidu.tbadk.core.util.ar.l(this.baj, r.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.l(this.ecJ, r.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.l(this.ecK, r.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.k(this.bak, r.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ar.c(this.bak, r.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecm, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecu, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecv, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecE, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecD, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecG, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecw, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecx, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecy, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecz, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecB, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecC, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ar.c(this.ecA, r.d.cp_cont_j, 1);
        this.baj.setHorizontalSpacing(((((WindowManager) this.ecI.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds100) * 5)) / 4);
        this.ecm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.ecu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.ecv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.ecE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.ecD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.ecG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.ecH.setImageDrawable(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_chat_dot));
        this.ecw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_readthread_selector), (Drawable) null, (Drawable) null);
        this.ecx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.ecy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.ecz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.ecB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.ecC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.ecA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
    }
}
