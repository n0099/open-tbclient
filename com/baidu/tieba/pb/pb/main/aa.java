package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable bvw;
    private TextView dbV;
    private TextView fNZ;
    private TextSizeSeekBar fOA;
    public boolean fOB;
    public boolean fOC;
    private TextView fOl;
    private TextView fOm;
    private TextView fOn;
    private TextView fOo;
    private TextView fOp;
    private TextView fOq;
    private TextView fOr;
    private TextView fOs;
    private TextView fOt;
    private TextView fOu;
    private TextView fOv;
    private PbActivity fOw;
    private View fOx;
    private FlowLayout fOy;
    private LinearLayout fOz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fNZ = null;
        this.fOl = null;
        this.fOt = null;
        this.fOw = null;
        this.mClickListener = null;
        this.fOw = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bcw() {
        return this.fNZ;
    }

    public TextView bcE() {
        return this.fOl;
    }

    public TextView bcF() {
        return this.fOt;
    }

    public TextView getCancelView() {
        return this.dbV;
    }

    public View bcG() {
        return this.fOx;
    }

    public TextView bcH() {
        return this.fOv;
    }

    public TextView bcI() {
        return this.fOp;
    }

    public TextView bcJ() {
        return this.fOn;
    }

    public TextView bcK() {
        return this.fOs;
    }

    public TextView bcL() {
        return this.fOm;
    }

    public TextView bcM() {
        return this.fOo;
    }

    public TextView bcN() {
        return this.fOq;
    }

    public TextView bcO() {
        return this.fOr;
    }

    public TextView bcP() {
        return this.fOu;
    }

    public void bcQ() {
        if (this.bvw == null) {
            this.bvw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fOx.setBackgroundColor(aa.this.fOw.getResources().getColor(d.C0108d.common_color_10082));
                }
            };
        }
        this.fOx.postDelayed(this.bvw, 200L);
    }

    public void bcR() {
        this.fOx.setBackgroundColor(this.fOw.getResources().getColor(d.C0108d.common_color_10022));
    }

    public void release() {
        this.fOx.removeCallbacks(this.bvw);
    }

    public void ki(boolean z) {
        if (z) {
            this.fOt.setVisibility(0);
        } else {
            this.fOt.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.fOu.setVisibility(0);
            this.fOu.setText(str);
            return;
        }
        this.fOu.setVisibility(8);
    }

    public void kj(boolean z) {
        this.fNZ.setVisibility(z ? 0 : 8);
    }

    public void J(boolean z, boolean z2) {
        this.fOv.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fOv.setText(d.j.group_info_intro_more);
        } else {
            this.fOv.setText(d.j.view_host);
        }
    }

    public void K(boolean z, boolean z2) {
        this.fOp.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fOp.setText(d.j.cancel_top);
        } else {
            this.fOp.setText(d.j.top);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fOs.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fOs.setText(d.j.cancel_good);
        } else {
            this.fOs.setText(d.j.commit_good);
        }
    }

    public void kk(boolean z) {
        this.fOn.setVisibility(z ? 0 : 8);
    }

    public void kl(boolean z) {
        this.fOm.setVisibility(z ? 0 : 8);
    }

    public void km(boolean z) {
        this.fOo.setVisibility(z ? 0 : 8);
    }

    public void M(boolean z, boolean z2) {
        this.fOq.setVisibility(z ? 0 : 8);
        this.fOC = z2;
        if (z2) {
            this.fOq.setText(d.j.view_reverse);
        } else {
            this.fOq.setText(d.j.default_sort);
        }
    }

    public void N(boolean z, boolean z2) {
        this.fOr.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fOr.setText(d.j.normal_mode);
        } else {
            this.fOr.setText(d.j.eyeshield_mode);
        }
    }

    public void kn(boolean z) {
        this.fOl.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fOw.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fNZ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fNZ.setOnClickListener(this.mClickListener);
        this.fOl = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fOl.setOnClickListener(this.mClickListener);
        this.fOt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fOt.setOnClickListener(this.mClickListener);
        this.fOu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fOu.setOnClickListener(this.mClickListener);
        this.fOm = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fOm.setOnClickListener(this.mClickListener);
        this.fOn = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fOn.setOnClickListener(this.mClickListener);
        this.fOo = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fOo.setOnClickListener(this.mClickListener);
        this.fOq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fOq.setOnClickListener(this.mClickListener);
        this.fOr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fOr.setOnClickListener(this.mClickListener);
        this.fOp = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fOp.setOnClickListener(this.mClickListener);
        this.fOs = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fOs.setOnClickListener(this.mClickListener);
        this.fOv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fOv.setOnClickListener(this.mClickListener);
        this.fOx = this.mView.findViewById(d.g.pb_more_layer);
        this.fOy = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fOA = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fOz = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.dbV = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.dbV.setOnClickListener(this.mClickListener);
        this.fOx.setOnClickListener(this.mClickListener);
    }

    public void alZ() {
        com.baidu.tbadk.core.util.aj.t(this.fOy, d.C0108d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.t(this.fOz, d.C0108d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.s(this.dbV, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.e(this.dbV, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNZ, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOl, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOt, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOu, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOv, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOm, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOn, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOp, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOs, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOo, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOq, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOr, d.C0108d.cp_cont_f, 1);
        this.fOy.setHorizontalSpacing(((((WindowManager) this.fOw.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fNZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fOl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fOt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fOu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fOm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fOB) {
            this.fOn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fOn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fOp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fOs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fOo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fOr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fOC) {
            this.fOq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fOq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.fOv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fOA != null) {
            this.fOA.onChangeSkinType();
        }
    }
}
