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
    private Runnable aHk;
    private TextView cia;
    private TextView eYA;
    private PbActivity eYB;
    private View eYC;
    private FlowLayout eYD;
    private LinearLayout eYE;
    private TextSizeSeekBar eYF;
    public boolean eYG;
    public boolean eYH;
    private TextView eYf;
    private TextView eYq;
    private TextView eYr;
    private TextView eYs;
    private TextView eYt;
    private TextView eYu;
    private TextView eYv;
    private TextView eYw;
    private TextView eYx;
    private TextView eYy;
    private TextView eYz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eYf = null;
        this.eYq = null;
        this.eYy = null;
        this.eYB = null;
        this.mClickListener = null;
        this.eYB = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aUR() {
        return this.eYf;
    }

    public TextView aUZ() {
        return this.eYq;
    }

    public TextView aVa() {
        return this.eYy;
    }

    public TextView getCancelView() {
        return this.cia;
    }

    public View aVb() {
        return this.eYC;
    }

    public TextView aVc() {
        return this.eYA;
    }

    public TextView aVd() {
        return this.eYu;
    }

    public TextView aVe() {
        return this.eYs;
    }

    public TextView aVf() {
        return this.eYx;
    }

    public TextView aVg() {
        return this.eYr;
    }

    public TextView aVh() {
        return this.eYt;
    }

    public TextView aVi() {
        return this.eYv;
    }

    public TextView aVj() {
        return this.eYw;
    }

    public TextView aVk() {
        return this.eYz;
    }

    public void aVl() {
        if (this.aHk == null) {
            this.aHk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.eYC.setBackgroundColor(aa.this.eYB.getResources().getColor(d.C0082d.common_color_10082));
                }
            };
        }
        this.eYC.postDelayed(this.aHk, 200L);
    }

    public void aVm() {
        this.eYC.setBackgroundColor(this.eYB.getResources().getColor(d.C0082d.common_color_10022));
    }

    public void release() {
        this.eYC.removeCallbacks(this.aHk);
    }

    public void jB(boolean z) {
        if (z) {
            this.eYy.setVisibility(0);
        } else {
            this.eYy.setVisibility(8);
        }
    }

    public void l(boolean z, String str) {
        if (z) {
            this.eYz.setVisibility(0);
            this.eYz.setText(str);
            return;
        }
        this.eYz.setVisibility(8);
    }

    public void jC(boolean z) {
        this.eYf.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.eYA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eYA.setText(d.j.group_info_intro_more);
        } else {
            this.eYA.setText(d.j.view_host);
        }
    }

    public void I(boolean z, boolean z2) {
        this.eYu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eYu.setText(d.j.cancel_top);
        } else {
            this.eYu.setText(d.j.top);
        }
    }

    public void J(boolean z, boolean z2) {
        this.eYx.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eYx.setText(d.j.cancel_good);
        } else {
            this.eYx.setText(d.j.commit_good);
        }
    }

    public void jD(boolean z) {
        this.eYs.setVisibility(z ? 0 : 8);
    }

    public void jE(boolean z) {
        this.eYr.setVisibility(z ? 0 : 8);
    }

    public void jF(boolean z) {
        this.eYt.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.eYv.setVisibility(z ? 0 : 8);
        this.eYH = z2;
        if (z2) {
            this.eYv.setText(d.j.view_reverse);
        } else {
            this.eYv.setText(d.j.default_sort);
        }
    }

    public void L(boolean z, boolean z2) {
        this.eYw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eYw.setText(d.j.normal_mode);
        } else {
            this.eYw.setText(d.j.eyeshield_mode);
        }
    }

    public void jG(boolean z) {
        this.eYq.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eYB.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.eYf = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.eYf.setOnClickListener(this.mClickListener);
        this.eYq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.eYq.setOnClickListener(this.mClickListener);
        this.eYy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.eYy.setOnClickListener(this.mClickListener);
        this.eYz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.eYz.setOnClickListener(this.mClickListener);
        this.eYr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.eYr.setOnClickListener(this.mClickListener);
        this.eYs = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.eYs.setOnClickListener(this.mClickListener);
        this.eYt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.eYt.setOnClickListener(this.mClickListener);
        this.eYv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.eYv.setOnClickListener(this.mClickListener);
        this.eYw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.eYw.setOnClickListener(this.mClickListener);
        this.eYu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.eYu.setOnClickListener(this.mClickListener);
        this.eYx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.eYx.setOnClickListener(this.mClickListener);
        this.eYA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.eYA.setOnClickListener(this.mClickListener);
        this.eYC = this.mView.findViewById(d.g.pb_more_layer);
        this.eYD = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.eYF = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.eYE = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cia = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cia.setOnClickListener(this.mClickListener);
        this.eYC.setOnClickListener(this.mClickListener);
    }

    public void adc() {
        com.baidu.tbadk.core.util.aj.k(this.eYD, d.C0082d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eYE, d.C0082d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.j(this.cia, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.cia, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYf, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYq, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYy, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYz, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYA, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYr, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYs, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYu, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYx, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYt, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYv, d.C0082d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.eYw, d.C0082d.cp_cont_f, 1);
        this.eYD.setHorizontalSpacing(((((WindowManager) this.eYB.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.eYf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eYq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eYy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eYz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eYr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.eYG) {
            this.eYs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eYs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.eYu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eYx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eYt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eYw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.eYH) {
            this.eYv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.eYv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.eYA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.eYF != null) {
            this.eYF.onChangeSkinType();
        }
    }
}
