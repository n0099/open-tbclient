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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aGd;
    private View.OnClickListener aPe;
    private TextView bRY;
    private TextView eGJ;
    private TextView eGU;
    private TextView eGV;
    private TextView eGW;
    private TextView eGX;
    private TextView eGY;
    private TextView eGZ;
    private TextView eHa;
    private ViewGroup eHb;
    private TextView eHc;
    private ImageView eHd;
    private TextView eHe;
    private TextView eHf;
    private PbActivity eHg;
    private View eHh;
    private FlowLayout eHi;
    private LinearLayout eHj;
    private View eHk;
    private TextView eHl;
    public boolean eHm;
    private View mView;

    public w(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eGJ = null;
        this.eGU = null;
        this.eHa = null;
        this.eHc = null;
        this.eHg = null;
        this.aPe = null;
        this.eHg = pbActivity;
        this.aPe = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aQh() {
        return this.eGJ;
    }

    public TextView aQp() {
        return this.eGU;
    }

    public TextView aQq() {
        return this.eHa;
    }

    public TextView aQr() {
        return this.eHc;
    }

    public TextView getCancelView() {
        return this.bRY;
    }

    public View aQs() {
        return this.eHh;
    }

    public TextView aQt() {
        return this.eHf;
    }

    public TextView aQu() {
        return this.eGY;
    }

    public TextView aQv() {
        return this.eGW;
    }

    public TextView aQw() {
        return this.eGZ;
    }

    public TextView aQx() {
        return this.eGV;
    }

    public TextView aQy() {
        return this.eGX;
    }

    public TextView aQz() {
        return this.eHe;
    }

    public void aQA() {
        if (this.aGd == null) {
            this.aGd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.eHh.setBackgroundColor(w.this.eHg.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.eHh.postDelayed(this.aGd, 200L);
    }

    public void aQB() {
        this.eHh.setBackgroundColor(this.eHg.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.eHh.removeCallbacks(this.aGd);
    }

    public void jf(boolean z) {
        if (z) {
            this.eHa.setVisibility(0);
        } else {
            this.eHa.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.eHe.setVisibility(0);
            this.eHe.setText(str);
            return;
        }
        this.eHe.setVisibility(8);
    }

    public void jg(boolean z) {
        this.eHb.setVisibility(8);
    }

    public void jh(boolean z) {
        this.eGJ.setVisibility(z ? 0 : 8);
    }

    public void G(boolean z, boolean z2) {
        this.eHf.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.eGY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eGY.setText(d.l.cancel_top);
        } else {
            this.eGY.setText(d.l.top);
        }
    }

    public void I(boolean z, boolean z2) {
        this.eGZ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eGZ.setText(d.l.cancel_good);
        } else {
            this.eGZ.setText(d.l.commit_good);
        }
    }

    public void ji(boolean z) {
        this.eGW.setVisibility(z ? 0 : 8);
    }

    public void jj(boolean z) {
        this.eGV.setVisibility(z ? 0 : 8);
    }

    public void jk(boolean z) {
        this.eGX.setVisibility(z ? 0 : 8);
    }

    public void aQC() {
        this.eHd.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    public void jl(boolean z) {
        this.eGU.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eHg.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eGJ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eGJ.setOnClickListener(this.aPe);
        this.eGU = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eGU.setOnClickListener(this.aPe);
        this.eHa = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eHa.setOnClickListener(this.aPe);
        this.eHe = (TextView) this.mView.findViewById(d.h.pb_more_view_item_fans_call);
        this.eHe.setOnClickListener(this.aPe);
        this.eGV = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eGV.setOnClickListener(this.aPe);
        this.eGW = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.eGW.setOnClickListener(this.aPe);
        this.eGX = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eGX.setOnClickListener(this.aPe);
        this.eGY = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eGY.setOnClickListener(this.aPe);
        this.eGZ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eGZ.setOnClickListener(this.aPe);
        this.eHf = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eHf.setOnClickListener(this.aPe);
        this.eHb = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eHc = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eHd = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eHc.setOnClickListener(this.aPe);
        this.eHd.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.eHb.setVisibility(8);
        this.eHh = this.mView.findViewById(d.h.pb_more_layer);
        this.eHi = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eHj = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eHk = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bRY = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bRY.setOnClickListener(this.aPe);
        this.eHh.setOnClickListener(this.aPe);
        this.eHl = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eHl.setOnClickListener(this.aPe);
    }

    public void Zb() {
        com.baidu.tbadk.core.util.aj.k(this.eHi, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eHj, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eHk, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aj.j(this.bRY, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.bRY, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGJ, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGU, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eHa, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eHe, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eHc, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eHf, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGV, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGW, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGY, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGZ, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGX, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eHl, d.e.cp_cont_j, 1);
        this.eHl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eHi.setHorizontalSpacing(((((WindowManager) this.eHg.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eGJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eGU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eHa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eHe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eHc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eHd.setImageDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_chat_dot));
        this.eGV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.eHm) {
            this.eGW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eGW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.eGY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eGZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eGX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eHf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean bj(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.eHh || view == this.bRY || view == this.eGW) ? false : true;
    }

    public void jm(boolean z) {
        this.eHl.setVisibility(z ? 0 : 8);
    }

    public TextView aQD() {
        return this.eHl;
    }
}
