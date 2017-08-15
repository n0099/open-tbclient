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
    private View.OnClickListener aYX;
    private View bDT;
    private FlowLayout bDU;
    private TextView bDV;
    private TextView bEv;
    private TextView eNN;
    private TextView eNX;
    private TextView eNY;
    private TextView eNZ;
    private TextView eOa;
    private TextView eOb;
    private TextView eOc;
    private TextView eOd;
    private TextView eOe;
    private TextView eOf;
    private ViewGroup eOg;
    private TextView eOh;
    private ImageView eOi;
    private TextView eOj;
    private PbActivity eOk;
    private LinearLayout eOl;
    private View eOm;
    private View mView;
    private Runnable runnable;

    public x(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eNN = null;
        this.eNX = null;
        this.eNY = null;
        this.eOe = null;
        this.eOf = null;
        this.eOh = null;
        this.eOk = null;
        this.aYX = null;
        this.eOk = pbActivity;
        this.aYX = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aSM() {
        return this.eNN;
    }

    public TextView aSU() {
        return this.eNX;
    }

    public TextView aSV() {
        return this.eNY;
    }

    public TextView aSW() {
        return this.eOf;
    }

    public TextView aSX() {
        return this.eOe;
    }

    public TextView aSY() {
        return this.eOh;
    }

    public TextView getCancelView() {
        return this.bDV;
    }

    public View VQ() {
        return this.bDT;
    }

    public TextView aSZ() {
        return this.eOj;
    }

    public TextView aTa() {
        return this.eOc;
    }

    public TextView aTb() {
        return this.bEv;
    }

    public TextView aTc() {
        return this.eOd;
    }

    public TextView aTd() {
        return this.eOa;
    }

    public TextView aTe() {
        return this.eOb;
    }

    public TextView aTf() {
        return this.eNZ;
    }

    public void VR() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.bDT.setBackgroundColor(x.this.eOk.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.bDT.postDelayed(this.runnable, 200L);
    }

    public void VS() {
        this.bDT.setBackgroundColor(this.eOk.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.bDT.removeCallbacks(this.runnable);
    }

    public void js(boolean z) {
        if (z) {
            this.eOf.setVisibility(0);
        } else {
            this.eOf.setVisibility(8);
        }
    }

    public void jt(boolean z) {
        if (z) {
            this.eOe.setVisibility(0);
        } else {
            this.eOe.setVisibility(8);
        }
    }

    public void ju(boolean z) {
        this.eOg.setVisibility(z ? 0 : 8);
    }

    public void jv(boolean z) {
        this.eNN.setVisibility(z ? 0 : 8);
    }

    public void E(boolean z, boolean z2) {
        this.eOj.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.eOc.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eOc.setText(d.l.cancel_top);
        } else {
            this.eOc.setText(d.l.top);
        }
    }

    public void G(boolean z, boolean z2) {
        this.eOd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eOd.setText(d.l.cancel_good);
        } else {
            this.eOd.setText(d.l.commit_good);
        }
    }

    public void jw(boolean z) {
        this.bEv.setVisibility(z ? 0 : 8);
    }

    public void jx(boolean z) {
        this.eOa.setVisibility(z ? 0 : 8);
    }

    public void jy(boolean z) {
        this.eOb.setVisibility(z ? 0 : 8);
    }

    public void jz(boolean z) {
        this.eNZ.setVisibility(z ? 0 : 8);
    }

    public void aTg() {
        this.eOi.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eOk.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eNN = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eNN.setOnClickListener(this.aYX);
        this.eNX = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eNX.setOnClickListener(this.aYX);
        this.eNY = (TextView) this.mView.findViewById(d.h.pb_more_view_item_see);
        this.eNY.setOnClickListener(this.aYX);
        this.eOf = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eOf.setOnClickListener(this.aYX);
        this.eOe = (TextView) this.mView.findViewById(d.h.pb_more_view_item_upgrade_thread);
        this.eOe.setOnClickListener(this.aYX);
        this.eOa = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eOa.setOnClickListener(this.aYX);
        this.bEv = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.bEv.setOnClickListener(this.aYX);
        this.eOb = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eOb.setOnClickListener(this.aYX);
        this.eOc = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eOc.setOnClickListener(this.aYX);
        this.eOd = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eOd.setOnClickListener(this.aYX);
        this.eOj = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eOj.setOnClickListener(this.aYX);
        this.eNZ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eNZ.setOnClickListener(this.aYX);
        this.eOg = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eOh = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eOi = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eOh.setOnClickListener(this.aYX);
        this.eOi.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bDT = this.mView.findViewById(d.h.pb_more_layer);
        this.bDU = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eOl = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eOm = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bDV = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bDV.setOnClickListener(this.aYX);
        this.bDT.setOnClickListener(this.aYX);
    }

    public void VV() {
        com.baidu.tbadk.core.util.ai.k(this.bDU, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eOl, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eOm, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.ai.j(this.bDV, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ai.c(this.bDV, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ai.c(this.eNN, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eNX, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eNY, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOf, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOe, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOh, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOj, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOa, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.bEv, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOc, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOd, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eOb, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eNZ, d.e.cp_cont_j, 1);
        this.bDU.setHorizontalSpacing(((((WindowManager) this.eOk.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eNN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eNX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eNY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eOf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eOe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eOh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eOi.setImageDrawable(com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_chat_dot));
        this.eNZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eOa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bEv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eOc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eOd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eOb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eOj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean bg(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bDT || view == this.bDV || view == this.bEv) ? false : true;
    }
}
