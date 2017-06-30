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
public class ey extends com.baidu.adp.base.e<PbActivity> {
    private Runnable aEN;
    private View.OnClickListener bkk;
    private View bxT;
    private FlowLayout bxU;
    private TextView bxV;
    private TextView byw;
    private TextView ezH;
    private TextView ezI;
    private TextView ezJ;
    private TextView ezK;
    private TextView ezL;
    private TextView ezM;
    private TextView ezN;
    private TextView ezO;
    private TextView ezP;
    private ViewGroup ezQ;
    private TextView ezR;
    private ImageView ezS;
    private TextView ezT;
    private PbActivity ezU;
    private LinearLayout ezV;
    private View ezW;
    private TextView ezx;
    private View mView;

    public ey(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.ezx = null;
        this.ezH = null;
        this.ezI = null;
        this.ezO = null;
        this.ezP = null;
        this.ezR = null;
        this.ezU = null;
        this.bkk = null;
        this.ezU = pbActivity;
        this.bkk = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aPr() {
        return this.ezx;
    }

    public TextView aPz() {
        return this.ezH;
    }

    public TextView aPA() {
        return this.ezI;
    }

    public TextView aPB() {
        return this.ezP;
    }

    public TextView aPC() {
        return this.ezO;
    }

    public TextView aPD() {
        return this.ezR;
    }

    public TextView getCancelView() {
        return this.bxV;
    }

    public View UF() {
        return this.bxT;
    }

    public TextView aPE() {
        return this.ezT;
    }

    public TextView aPF() {
        return this.ezM;
    }

    public TextView aPG() {
        return this.byw;
    }

    public TextView aPH() {
        return this.ezN;
    }

    public TextView aPI() {
        return this.ezK;
    }

    public TextView aPJ() {
        return this.ezL;
    }

    public TextView aPK() {
        return this.ezJ;
    }

    public void UG() {
        if (this.aEN == null) {
            this.aEN = new ez(this);
        }
        this.bxT.postDelayed(this.aEN, 200L);
    }

    public void UH() {
        this.bxT.setBackgroundColor(this.ezU.getResources().getColor(w.e.common_color_10022));
    }

    public void release() {
        this.bxT.removeCallbacks(this.aEN);
    }

    public void iV(boolean z) {
        if (z) {
            this.ezP.setVisibility(0);
        } else {
            this.ezP.setVisibility(8);
        }
    }

    public void iW(boolean z) {
        if (z) {
            this.ezO.setVisibility(0);
        } else {
            this.ezO.setVisibility(8);
        }
    }

    public void iX(boolean z) {
        this.ezQ.setVisibility(z ? 0 : 8);
    }

    public void iY(boolean z) {
        this.ezx.setVisibility(z ? 0 : 8);
    }

    public void z(boolean z, boolean z2) {
        this.ezT.setVisibility(z ? 0 : 8);
    }

    public void A(boolean z, boolean z2) {
        this.ezM.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ezM.setText(w.l.cancel_top);
        } else {
            this.ezM.setText(w.l.top);
        }
    }

    public void B(boolean z, boolean z2) {
        this.ezN.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ezN.setText(w.l.cancel_good);
        } else {
            this.ezN.setText(w.l.commit_good);
        }
    }

    public void iZ(boolean z) {
        this.byw.setVisibility(z ? 0 : 8);
    }

    public void ja(boolean z) {
        this.ezK.setVisibility(z ? 0 : 8);
    }

    public void jb(boolean z) {
        this.ezL.setVisibility(z ? 0 : 8);
    }

    public void jc(boolean z) {
        this.ezJ.setVisibility(z ? 0 : 8);
    }

    public void aPL() {
        this.ezS.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ezU.getPageContext().getPageActivity()).inflate(w.j.pb_more_pop_view, (ViewGroup) null);
        this.ezx = (TextView) this.mView.findViewById(w.h.pb_more_view_item_mark);
        this.ezx.setOnClickListener(this.bkk);
        this.ezH = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump);
        this.ezH.setOnClickListener(this.bkk);
        this.ezI = (TextView) this.mView.findViewById(w.h.pb_more_view_item_see);
        this.ezI.setOnClickListener(this.bkk);
        this.ezP = (TextView) this.mView.findViewById(w.h.pb_more_view_item_report);
        this.ezP.setOnClickListener(this.bkk);
        this.ezO = (TextView) this.mView.findViewById(w.h.pb_more_view_item_upgrade_thread);
        this.ezO.setOnClickListener(this.bkk);
        this.ezK = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump_top);
        this.ezK.setOnClickListener(this.bkk);
        this.byw = (TextView) this.mView.findViewById(w.h.pb_more_view_item_delete);
        this.byw.setOnClickListener(this.bkk);
        this.ezL = (TextView) this.mView.findViewById(w.h.pb_more_view_item_forbidden);
        this.ezL.setOnClickListener(this.bkk);
        this.ezM = (TextView) this.mView.findViewById(w.h.pb_more_view_item_make_top);
        this.ezM.setOnClickListener(this.bkk);
        this.ezN = (TextView) this.mView.findViewById(w.h.pb_more_view_item_add_good);
        this.ezN.setOnClickListener(this.bkk);
        this.ezT = (TextView) this.mView.findViewById(w.h.pb_more_view_item_host_only);
        this.ezT.setOnClickListener(this.bkk);
        this.ezJ = (TextView) this.mView.findViewById(w.h.pb_more_view_item_share);
        this.ezJ.setOnClickListener(this.bkk);
        this.ezQ = (ViewGroup) this.mView.findViewById(w.h.pb_more_view_item_god_call_layout);
        this.ezR = (TextView) this.mView.findViewById(w.h.pb_more_view_item_god_call);
        this.ezS = (ImageView) this.mView.findViewById(w.h.pb_more_view_item_god_call_tip);
        this.ezR.setOnClickListener(this.bkk);
        this.ezS.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bxT = this.mView.findViewById(w.h.pb_more_layer);
        this.bxU = (FlowLayout) this.mView.findViewById(w.h.pb_more_flowlayout);
        this.ezV = (LinearLayout) this.mView.findViewById(w.h.size_seek_bar_group);
        this.ezW = this.mView.findViewById(w.h.pb_more_seekbar_line);
        this.bxV = (TextView) this.mView.findViewById(w.h.pb_more_cancel);
        this.bxV.setOnClickListener(this.bkk);
        this.bxT.setOnClickListener(this.bkk);
    }

    public void UK() {
        com.baidu.tbadk.core.util.as.k(this.bxU, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.k(this.ezV, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.k(this.ezW, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(this.bxV, w.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.as.c(this.bxV, w.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.as.c(this.ezx, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezH, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezI, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezP, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezO, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezR, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezT, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezK, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.byw, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezM, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezN, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezL, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.as.c(this.ezJ, w.e.cp_cont_j, 1);
        this.bxU.setHorizontalSpacing(((((WindowManager) this.ezU.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds100) * 5)) / 4);
        this.ezx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.ezH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.ezI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.ezP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.ezO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.ezR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.ezS.setImageDrawable(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_chat_dot));
        this.ezJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.ezK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.byw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.ezM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.ezN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.ezL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.ezT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean aZ(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bxT || view == this.bxV || view == this.byw) ? false : true;
    }
}
