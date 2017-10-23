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
    private Runnable aFQ;
    private View.OnClickListener aOR;
    private TextView bRM;
    private TextView eGG;
    private TextView eGH;
    private TextView eGI;
    private TextView eGJ;
    private TextView eGK;
    private TextView eGL;
    private TextView eGM;
    private ViewGroup eGN;
    private TextView eGO;
    private ImageView eGP;
    private TextView eGQ;
    private TextView eGR;
    private PbActivity eGS;
    private View eGT;
    private FlowLayout eGU;
    private LinearLayout eGV;
    private View eGW;
    private TextView eGX;
    public boolean eGY;
    private TextView eGv;
    private View mView;

    public w(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eGv = null;
        this.eGG = null;
        this.eGM = null;
        this.eGO = null;
        this.eGS = null;
        this.aOR = null;
        this.eGS = pbActivity;
        this.aOR = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aQc() {
        return this.eGv;
    }

    public TextView aQk() {
        return this.eGG;
    }

    public TextView aQl() {
        return this.eGM;
    }

    public TextView aQm() {
        return this.eGO;
    }

    public TextView getCancelView() {
        return this.bRM;
    }

    public View aQn() {
        return this.eGT;
    }

    public TextView aQo() {
        return this.eGR;
    }

    public TextView aQp() {
        return this.eGK;
    }

    public TextView aQq() {
        return this.eGI;
    }

    public TextView aQr() {
        return this.eGL;
    }

    public TextView aQs() {
        return this.eGH;
    }

    public TextView aQt() {
        return this.eGJ;
    }

    public TextView aQu() {
        return this.eGQ;
    }

    public void aQv() {
        if (this.aFQ == null) {
            this.aFQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.eGT.setBackgroundColor(w.this.eGS.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.eGT.postDelayed(this.aFQ, 200L);
    }

    public void aQw() {
        this.eGT.setBackgroundColor(this.eGS.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.eGT.removeCallbacks(this.aFQ);
    }

    public void je(boolean z) {
        if (z) {
            this.eGM.setVisibility(0);
        } else {
            this.eGM.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.eGQ.setVisibility(0);
            this.eGQ.setText(str);
            return;
        }
        this.eGQ.setVisibility(8);
    }

    public void jf(boolean z) {
        this.eGN.setVisibility(8);
    }

    public void jg(boolean z) {
        this.eGv.setVisibility(z ? 0 : 8);
    }

    public void G(boolean z, boolean z2) {
        this.eGR.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.eGK.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eGK.setText(d.l.cancel_top);
        } else {
            this.eGK.setText(d.l.top);
        }
    }

    public void I(boolean z, boolean z2) {
        this.eGL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eGL.setText(d.l.cancel_good);
        } else {
            this.eGL.setText(d.l.commit_good);
        }
    }

    public void jh(boolean z) {
        this.eGI.setVisibility(z ? 0 : 8);
    }

    public void ji(boolean z) {
        this.eGH.setVisibility(z ? 0 : 8);
    }

    public void jj(boolean z) {
        this.eGJ.setVisibility(z ? 0 : 8);
    }

    public void aQx() {
        this.eGP.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    public void jk(boolean z) {
        this.eGG.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eGS.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eGv = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eGv.setOnClickListener(this.aOR);
        this.eGG = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eGG.setOnClickListener(this.aOR);
        this.eGM = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eGM.setOnClickListener(this.aOR);
        this.eGQ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_fans_call);
        this.eGQ.setOnClickListener(this.aOR);
        this.eGH = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eGH.setOnClickListener(this.aOR);
        this.eGI = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.eGI.setOnClickListener(this.aOR);
        this.eGJ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eGJ.setOnClickListener(this.aOR);
        this.eGK = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eGK.setOnClickListener(this.aOR);
        this.eGL = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eGL.setOnClickListener(this.aOR);
        this.eGR = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eGR.setOnClickListener(this.aOR);
        this.eGN = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eGO = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eGP = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eGO.setOnClickListener(this.aOR);
        this.eGP.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.eGN.setVisibility(8);
        this.eGT = this.mView.findViewById(d.h.pb_more_layer);
        this.eGU = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eGV = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eGW = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bRM = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bRM.setOnClickListener(this.aOR);
        this.eGT.setOnClickListener(this.aOR);
        this.eGX = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eGX.setOnClickListener(this.aOR);
    }

    public void YX() {
        com.baidu.tbadk.core.util.aj.k(this.eGU, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eGV, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eGW, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aj.j(this.bRM, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.bRM, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGv, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGG, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGM, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGQ, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGO, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGR, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGH, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGI, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGK, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGL, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGJ, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eGX, d.e.cp_cont_j, 1);
        this.eGX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eGU.setHorizontalSpacing(((((WindowManager) this.eGS.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eGv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eGG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eGM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eGQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eGO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eGP.setImageDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_chat_dot));
        this.eGH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.eGY) {
            this.eGI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eGI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.eGK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eGL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eGJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eGR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean bj(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.eGT || view == this.bRM || view == this.eGI) ? false : true;
    }

    public void jl(boolean z) {
        this.eGX.setVisibility(z ? 0 : 8);
    }

    public TextView aQy() {
        return this.eGX;
    }
}
