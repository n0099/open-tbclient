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
public class x extends com.baidu.adp.base.c<PbActivity> {
    private View.OnClickListener aYY;
    private View bDU;
    private FlowLayout bDV;
    private TextView bDW;
    private TextView bEw;
    private TextView eNP;
    private TextView eNZ;
    private TextView eOa;
    private TextView eOb;
    private TextView eOc;
    private TextView eOd;
    private TextView eOe;
    private TextView eOf;
    private TextView eOg;
    private TextView eOh;
    private ViewGroup eOi;
    private TextView eOj;
    private ImageView eOk;
    private TextView eOl;
    private PbActivity eOm;
    private LinearLayout eOn;
    private View eOo;
    private View mView;
    private Runnable runnable;

    public x(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eNP = null;
        this.eNZ = null;
        this.eOa = null;
        this.eOg = null;
        this.eOh = null;
        this.eOj = null;
        this.eOm = null;
        this.aYY = null;
        this.eOm = pbActivity;
        this.aYY = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aSH() {
        return this.eNP;
    }

    public TextView aSP() {
        return this.eNZ;
    }

    public TextView aSQ() {
        return this.eOa;
    }

    public TextView aSR() {
        return this.eOh;
    }

    public TextView aSS() {
        return this.eOg;
    }

    public TextView aST() {
        return this.eOj;
    }

    public TextView getCancelView() {
        return this.bDW;
    }

    public View VN() {
        return this.bDU;
    }

    public TextView aSU() {
        return this.eOl;
    }

    public TextView aSV() {
        return this.eOe;
    }

    public TextView aSW() {
        return this.bEw;
    }

    public TextView aSX() {
        return this.eOf;
    }

    public TextView aSY() {
        return this.eOc;
    }

    public TextView aSZ() {
        return this.eOd;
    }

    public TextView aTa() {
        return this.eOb;
    }

    public void VO() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.bDU.setBackgroundColor(x.this.eOm.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.bDU.postDelayed(this.runnable, 200L);
    }

    public void VP() {
        this.bDU.setBackgroundColor(this.eOm.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.bDU.removeCallbacks(this.runnable);
    }

    public void js(boolean z) {
        if (z) {
            this.eOh.setVisibility(0);
        } else {
            this.eOh.setVisibility(8);
        }
    }

    public void jt(boolean z) {
        if (z) {
            this.eOg.setVisibility(0);
        } else {
            this.eOg.setVisibility(8);
        }
    }

    public void ju(boolean z) {
        this.eOi.setVisibility(z ? 0 : 8);
    }

    public void jv(boolean z) {
        this.eNP.setVisibility(z ? 0 : 8);
    }

    public void E(boolean z, boolean z2) {
        this.eOl.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.eOe.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eOe.setText(d.l.cancel_top);
        } else {
            this.eOe.setText(d.l.top);
        }
    }

    public void G(boolean z, boolean z2) {
        this.eOf.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eOf.setText(d.l.cancel_good);
        } else {
            this.eOf.setText(d.l.commit_good);
        }
    }

    public void jw(boolean z) {
        this.bEw.setVisibility(z ? 0 : 8);
    }

    public void jx(boolean z) {
        this.eOc.setVisibility(z ? 0 : 8);
    }

    public void jy(boolean z) {
        this.eOd.setVisibility(z ? 0 : 8);
    }

    public void jz(boolean z) {
        this.eOb.setVisibility(z ? 0 : 8);
    }

    public void aTb() {
        this.eOk.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eOm.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eNP = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eNP.setOnClickListener(this.aYY);
        this.eNZ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eNZ.setOnClickListener(this.aYY);
        this.eOa = (TextView) this.mView.findViewById(d.h.pb_more_view_item_see);
        this.eOa.setOnClickListener(this.aYY);
        this.eOh = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eOh.setOnClickListener(this.aYY);
        this.eOg = (TextView) this.mView.findViewById(d.h.pb_more_view_item_upgrade_thread);
        this.eOg.setOnClickListener(this.aYY);
        this.eOc = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eOc.setOnClickListener(this.aYY);
        this.bEw = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.bEw.setOnClickListener(this.aYY);
        this.eOd = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eOd.setOnClickListener(this.aYY);
        this.eOe = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eOe.setOnClickListener(this.aYY);
        this.eOf = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eOf.setOnClickListener(this.aYY);
        this.eOl = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eOl.setOnClickListener(this.aYY);
        this.eOb = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eOb.setOnClickListener(this.aYY);
        this.eOi = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eOj = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eOk = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eOj.setOnClickListener(this.aYY);
        this.eOk.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bDU = this.mView.findViewById(d.h.pb_more_layer);
        this.bDV = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eOn = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eOo = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bDW = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bDW.setOnClickListener(this.aYY);
        this.bDU.setOnClickListener(this.aYY);
    }

    public void VS() {
        com.baidu.tbadk.core.util.ai.k(this.bDV, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eOn, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eOo, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.ai.j(this.bDW, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ai.c(this.bDW, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ai.c(this.eNP, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eNZ, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOa, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOh, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOg, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOj, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOl, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOc, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.bEw, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOe, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOf, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOd, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOb, d.e.cp_cont_j, 1);
        this.bDV.setHorizontalSpacing(((((WindowManager) this.eOm.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eNP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eNZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eOa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eOh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eOg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eOj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eOk.setImageDrawable(com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_chat_dot));
        this.eOb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eOc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bEw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eOe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eOf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eOd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eOl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean bf(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bDU || view == this.bDW || view == this.bEw) ? false : true;
    }
}
