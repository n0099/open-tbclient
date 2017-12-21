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
    private Runnable aHr;
    private TextView cit;
    private TextView eZA;
    private TextView eZB;
    private TextView eZC;
    private TextView eZD;
    private TextView eZE;
    private TextView eZF;
    private TextView eZG;
    private TextView eZH;
    private TextView eZI;
    private PbActivity eZJ;
    private View eZK;
    private FlowLayout eZL;
    private LinearLayout eZM;
    private TextSizeSeekBar eZN;
    public boolean eZO;
    public boolean eZP;
    private TextView eZn;
    private TextView eZy;
    private TextView eZz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eZn = null;
        this.eZy = null;
        this.eZG = null;
        this.eZJ = null;
        this.mClickListener = null;
        this.eZJ = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aVa() {
        return this.eZn;
    }

    public TextView aVi() {
        return this.eZy;
    }

    public TextView aVj() {
        return this.eZG;
    }

    public TextView getCancelView() {
        return this.cit;
    }

    public View aVk() {
        return this.eZK;
    }

    public TextView aVl() {
        return this.eZI;
    }

    public TextView aVm() {
        return this.eZC;
    }

    public TextView aVn() {
        return this.eZA;
    }

    public TextView aVo() {
        return this.eZF;
    }

    public TextView aVp() {
        return this.eZz;
    }

    public TextView aVq() {
        return this.eZB;
    }

    public TextView aVr() {
        return this.eZD;
    }

    public TextView aVs() {
        return this.eZE;
    }

    public TextView aVt() {
        return this.eZH;
    }

    public void aVu() {
        if (this.aHr == null) {
            this.aHr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.eZK.setBackgroundColor(aa.this.eZJ.getResources().getColor(d.C0095d.common_color_10082));
                }
            };
        }
        this.eZK.postDelayed(this.aHr, 200L);
    }

    public void aVv() {
        this.eZK.setBackgroundColor(this.eZJ.getResources().getColor(d.C0095d.common_color_10022));
    }

    public void release() {
        this.eZK.removeCallbacks(this.aHr);
    }

    public void jC(boolean z) {
        if (z) {
            this.eZG.setVisibility(0);
        } else {
            this.eZG.setVisibility(8);
        }
    }

    public void l(boolean z, String str) {
        if (z) {
            this.eZH.setVisibility(0);
            this.eZH.setText(str);
            return;
        }
        this.eZH.setVisibility(8);
    }

    public void jD(boolean z) {
        this.eZn.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.eZI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZI.setText(d.j.group_info_intro_more);
        } else {
            this.eZI.setText(d.j.view_host);
        }
    }

    public void I(boolean z, boolean z2) {
        this.eZC.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZC.setText(d.j.cancel_top);
        } else {
            this.eZC.setText(d.j.top);
        }
    }

    public void J(boolean z, boolean z2) {
        this.eZF.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZF.setText(d.j.cancel_good);
        } else {
            this.eZF.setText(d.j.commit_good);
        }
    }

    public void jE(boolean z) {
        this.eZA.setVisibility(z ? 0 : 8);
    }

    public void jF(boolean z) {
        this.eZz.setVisibility(z ? 0 : 8);
    }

    public void jG(boolean z) {
        this.eZB.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.eZD.setVisibility(z ? 0 : 8);
        this.eZP = z2;
        if (z2) {
            this.eZD.setText(d.j.view_reverse);
        } else {
            this.eZD.setText(d.j.default_sort);
        }
    }

    public void L(boolean z, boolean z2) {
        this.eZE.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eZE.setText(d.j.normal_mode);
        } else {
            this.eZE.setText(d.j.eyeshield_mode);
        }
    }

    public void jH(boolean z) {
        this.eZy.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eZJ.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.eZn = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.eZn.setOnClickListener(this.mClickListener);
        this.eZy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.eZy.setOnClickListener(this.mClickListener);
        this.eZG = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.eZG.setOnClickListener(this.mClickListener);
        this.eZH = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.eZH.setOnClickListener(this.mClickListener);
        this.eZz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.eZz.setOnClickListener(this.mClickListener);
        this.eZA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.eZA.setOnClickListener(this.mClickListener);
        this.eZB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.eZB.setOnClickListener(this.mClickListener);
        this.eZD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.eZD.setOnClickListener(this.mClickListener);
        this.eZE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.eZE.setOnClickListener(this.mClickListener);
        this.eZC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.eZC.setOnClickListener(this.mClickListener);
        this.eZF = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.eZF.setOnClickListener(this.mClickListener);
        this.eZI = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.eZI.setOnClickListener(this.mClickListener);
        this.eZK = this.mView.findViewById(d.g.pb_more_layer);
        this.eZL = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.eZN = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.eZM = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cit = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cit.setOnClickListener(this.mClickListener);
        this.eZK.setOnClickListener(this.mClickListener);
    }

    public void adl() {
        com.baidu.tbadk.core.util.aj.k(this.eZL, d.C0095d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eZM, d.C0095d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.j(this.cit, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.cit, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZn, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZy, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZG, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZH, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZI, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZz, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZA, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZC, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZF, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZB, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZD, d.C0095d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eZE, d.C0095d.cp_cont_f, 1);
        this.eZL.setHorizontalSpacing(((((WindowManager) this.eZJ.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.eZn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eZy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eZG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eZH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eZz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.eZO) {
            this.eZA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eZA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.eZC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eZF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eZB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eZE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.eZP) {
            this.eZD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eZD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.eZI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.eZN != null) {
            this.eZN.onChangeSkinType();
        }
    }
}
