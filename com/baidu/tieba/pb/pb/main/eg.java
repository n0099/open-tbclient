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
public class eg extends com.baidu.adp.base.e<PbActivity> {
    private Runnable aDM;
    private View.OnClickListener aSt;
    private View btr;
    private FlowLayout bts;
    private TextView btt;
    private TextView ekJ;
    private TextView ekK;
    private TextView ekL;
    private TextView ekM;
    private TextView ekN;
    private TextView ekO;
    private TextView ekP;
    private TextView ekQ;
    private TextView ekR;
    private ViewGroup ekS;
    private TextView ekT;
    private ImageView ekU;
    private TextView ekV;
    private PbActivity ekW;
    private LinearLayout ekX;
    private View ekY;
    private TextView ekz;
    private View mView;

    public eg(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.ekz = null;
        this.ekJ = null;
        this.ekK = null;
        this.ekQ = null;
        this.ekR = null;
        this.ekT = null;
        this.ekW = null;
        this.aSt = null;
        this.ekW = pbActivity;
        this.aSt = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aKy() {
        return this.ekz;
    }

    public TextView aKG() {
        return this.ekJ;
    }

    public TextView aKH() {
        return this.ekK;
    }

    public TextView aKI() {
        return this.ekR;
    }

    public TextView aKJ() {
        return this.ekQ;
    }

    public TextView aKK() {
        return this.ekT;
    }

    public TextView getCancelView() {
        return this.btt;
    }

    public View SR() {
        return this.btr;
    }

    public TextView aKL() {
        return this.ekV;
    }

    public TextView aKM() {
        return this.ekO;
    }

    public TextView aKN() {
        return this.ekM;
    }

    public TextView aKO() {
        return this.ekP;
    }

    public TextView aKP() {
        return this.ekL;
    }

    public TextView aKQ() {
        return this.ekN;
    }

    public void SS() {
        if (this.aDM == null) {
            this.aDM = new eh(this);
        }
        this.btr.postDelayed(this.aDM, 200L);
    }

    public void ST() {
        this.btr.setBackgroundColor(this.ekW.getResources().getColor(w.e.common_color_10022));
    }

    public void release() {
        this.btr.removeCallbacks(this.aDM);
    }

    public void ik(boolean z) {
        if (z) {
            this.ekR.setVisibility(0);
        } else {
            this.ekR.setVisibility(8);
        }
    }

    public void il(boolean z) {
        if (z) {
            this.ekQ.setVisibility(0);
        } else {
            this.ekQ.setVisibility(8);
        }
    }

    public void im(boolean z) {
        this.ekS.setVisibility(z ? 0 : 8);
    }

    public void in(boolean z) {
        this.ekz.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z, boolean z2) {
        this.ekV.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z, boolean z2) {
        this.ekO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ekO.setText(w.l.cancel_top);
        } else {
            this.ekO.setText(w.l.top);
        }
    }

    public void x(boolean z, boolean z2) {
        this.ekP.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ekP.setText(w.l.cancel_good);
        } else {
            this.ekP.setText(w.l.commit_good);
        }
    }

    public void io(boolean z) {
        this.ekM.setVisibility(z ? 0 : 8);
    }

    public void ip(boolean z) {
        this.ekL.setVisibility(z ? 0 : 8);
    }

    public void iq(boolean z) {
        this.ekN.setVisibility(z ? 0 : 8);
    }

    public void aKR() {
        this.ekU.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ekW.getPageContext().getPageActivity()).inflate(w.j.pb_more_pop_view, (ViewGroup) null);
        this.ekz = (TextView) this.mView.findViewById(w.h.pb_more_view_item_mark);
        this.ekz.setOnClickListener(this.aSt);
        this.ekJ = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump);
        this.ekJ.setOnClickListener(this.aSt);
        this.ekK = (TextView) this.mView.findViewById(w.h.pb_more_view_item_see);
        this.ekK.setOnClickListener(this.aSt);
        this.ekR = (TextView) this.mView.findViewById(w.h.pb_more_view_item_report);
        this.ekR.setOnClickListener(this.aSt);
        this.ekQ = (TextView) this.mView.findViewById(w.h.pb_more_view_item_upgrade_thread);
        this.ekQ.setOnClickListener(this.aSt);
        this.ekL = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump_top);
        this.ekL.setOnClickListener(this.aSt);
        this.ekM = (TextView) this.mView.findViewById(w.h.pb_more_view_item_delete);
        this.ekM.setOnClickListener(this.aSt);
        this.ekN = (TextView) this.mView.findViewById(w.h.pb_more_view_item_forbidden);
        this.ekN.setOnClickListener(this.aSt);
        this.ekO = (TextView) this.mView.findViewById(w.h.pb_more_view_item_make_top);
        this.ekO.setOnClickListener(this.aSt);
        this.ekP = (TextView) this.mView.findViewById(w.h.pb_more_view_item_add_good);
        this.ekP.setOnClickListener(this.aSt);
        this.ekV = (TextView) this.mView.findViewById(w.h.pb_more_view_item_host_only);
        this.ekV.setOnClickListener(this.aSt);
        this.ekS = (ViewGroup) this.mView.findViewById(w.h.pb_more_view_item_god_call_layout);
        this.ekT = (TextView) this.mView.findViewById(w.h.pb_more_view_item_god_call);
        this.ekU = (ImageView) this.mView.findViewById(w.h.pb_more_view_item_god_call_tip);
        this.ekT.setOnClickListener(this.aSt);
        this.ekU.setVisibility(com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.btr = this.mView.findViewById(w.h.pb_more_layer);
        this.bts = (FlowLayout) this.mView.findViewById(w.h.pb_more_flowlayout);
        this.ekX = (LinearLayout) this.mView.findViewById(w.h.size_seek_bar_group);
        this.ekY = this.mView.findViewById(w.h.pb_more_seekbar_line);
        this.btt = (TextView) this.mView.findViewById(w.h.pb_more_cancel);
        this.btt.setOnClickListener(this.aSt);
        this.btr.setOnClickListener(this.aSt);
    }

    public void SW() {
        com.baidu.tbadk.core.util.aq.k(this.bts, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.ekX, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.ekY, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(this.btt, w.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aq.c(this.btt, w.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekz, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekJ, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekK, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekR, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekQ, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekT, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekV, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekL, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekM, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekO, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekP, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.ekN, w.e.cp_cont_j, 1);
        this.bts.setHorizontalSpacing(((((WindowManager) this.ekW.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds100) * 5)) / 4);
        this.ekz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.ekJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.ekK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.ekR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.ekQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.ekT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.ekU.setImageDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_chat_dot));
        this.ekL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.ekM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.ekO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.ekP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.ekN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.ekV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }
}
