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
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aHo;
    private TextView cip;
    private TextView eZA;
    private TextView eZB;
    private TextView eZC;
    private TextView eZD;
    private PbActivity eZE;
    private View eZF;
    private FlowLayout eZG;
    private LinearLayout eZH;
    private TextSizeSeekBar eZI;
    public boolean eZJ;
    public boolean eZK;
    private TextView eZi;
    private TextView eZt;
    private TextView eZu;
    private TextView eZv;
    private TextView eZw;
    private TextView eZx;
    private TextView eZy;
    private TextView eZz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eZi = null;
        this.eZt = null;
        this.eZB = null;
        this.eZE = null;
        this.mClickListener = null;
        this.eZE = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aVa() {
        return this.eZi;
    }

    public TextView aVi() {
        return this.eZt;
    }

    public TextView aVj() {
        return this.eZB;
    }

    public TextView getCancelView() {
        return this.cip;
    }

    public View aVk() {
        return this.eZF;
    }

    public TextView aVl() {
        return this.eZD;
    }

    public TextView aVm() {
        return this.eZx;
    }

    public TextView aVn() {
        return this.eZv;
    }

    public TextView aVo() {
        return this.eZA;
    }

    public TextView aVp() {
        return this.eZu;
    }

    public TextView aVq() {
        return this.eZw;
    }

    public TextView aVr() {
        return this.eZy;
    }

    public TextView aVs() {
        return this.eZz;
    }

    public TextView aVt() {
        return this.eZC;
    }

    public void aVu() {
        if (this.aHo == null) {
            this.aHo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.eZF.setBackgroundColor(aa.this.eZE.getResources().getColor(d.C0096d.common_color_10082));
                }
            };
        }
        this.eZF.postDelayed(this.aHo, 200L);
    }

    public void aVv() {
        this.eZF.setBackgroundColor(this.eZE.getResources().getColor(d.C0096d.common_color_10022));
    }

    public void release() {
        this.eZF.removeCallbacks(this.aHo);
    }

    public void jC(boolean z) {
        if (z) {
            this.eZB.setVisibility(0);
        } else {
            this.eZB.setVisibility(8);
        }
    }

    public void l(boolean z, String str) {
        if (z) {
            this.eZC.setVisibility(0);
            this.eZC.setText(str);
            return;
        }
        this.eZC.setVisibility(8);
    }

    public void jD(boolean z) {
        this.eZi.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.eZD.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZD.setText(d.j.group_info_intro_more);
        } else {
            this.eZD.setText(d.j.view_host);
        }
    }

    public void I(boolean z, boolean z2) {
        this.eZx.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZx.setText(d.j.cancel_top);
        } else {
            this.eZx.setText(d.j.top);
        }
    }

    public void J(boolean z, boolean z2) {
        this.eZA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZA.setText(d.j.cancel_good);
        } else {
            this.eZA.setText(d.j.commit_good);
        }
    }

    public void jE(boolean z) {
        this.eZv.setVisibility(z ? 0 : 8);
    }

    public void jF(boolean z) {
        this.eZu.setVisibility(z ? 0 : 8);
    }

    public void jG(boolean z) {
        this.eZw.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.eZy.setVisibility(z ? 0 : 8);
        this.eZK = z2;
        if (z2) {
            this.eZy.setText(d.j.view_reverse);
        } else {
            this.eZy.setText(d.j.default_sort);
        }
    }

    public void L(boolean z, boolean z2) {
        this.eZz.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZz.setText(d.j.normal_mode);
        } else {
            this.eZz.setText(d.j.eyeshield_mode);
        }
    }

    public void jH(boolean z) {
        this.eZt.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eZE.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.eZi = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.eZi.setOnClickListener(this.mClickListener);
        this.eZt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.eZt.setOnClickListener(this.mClickListener);
        this.eZB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.eZB.setOnClickListener(this.mClickListener);
        this.eZC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.eZC.setOnClickListener(this.mClickListener);
        this.eZu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.eZu.setOnClickListener(this.mClickListener);
        this.eZv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.eZv.setOnClickListener(this.mClickListener);
        this.eZw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.eZw.setOnClickListener(this.mClickListener);
        this.eZy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.eZy.setOnClickListener(this.mClickListener);
        this.eZz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.eZz.setOnClickListener(this.mClickListener);
        this.eZx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.eZx.setOnClickListener(this.mClickListener);
        this.eZA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.eZA.setOnClickListener(this.mClickListener);
        this.eZD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.eZD.setOnClickListener(this.mClickListener);
        this.eZF = this.mView.findViewById(d.g.pb_more_layer);
        this.eZG = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.eZI = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.eZH = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cip = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cip.setOnClickListener(this.mClickListener);
        this.eZF.setOnClickListener(this.mClickListener);
    }

    public void adm() {
        com.baidu.tbadk.core.util.aj.k(this.eZG, d.C0096d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eZH, d.C0096d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.j(this.cip, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.cip, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZi, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZt, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZB, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZC, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZD, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZu, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZv, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZx, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZA, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZw, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZy, d.C0096d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZz, d.C0096d.cp_cont_f, 1);
        this.eZG.setHorizontalSpacing(((((WindowManager) this.eZE.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.eZi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eZt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eZB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eZC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eZu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.eZJ) {
            this.eZv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eZv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.eZx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eZA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eZw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eZz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.eZK) {
            this.eZy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eZy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.eZD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.eZI != null) {
            this.eZI.onChangeSkinType();
        }
    }
}
