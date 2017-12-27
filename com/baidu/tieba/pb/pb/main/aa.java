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
    private Runnable bve;
    private TextView cWW;
    private TextView fMA;
    private PbActivity fMB;
    private View fMC;
    private FlowLayout fMD;
    private LinearLayout fME;
    private TextSizeSeekBar fMF;
    public boolean fMG;
    public boolean fMH;
    private TextView fMe;
    private TextView fMq;
    private TextView fMr;
    private TextView fMs;
    private TextView fMt;
    private TextView fMu;
    private TextView fMv;
    private TextView fMw;
    private TextView fMx;
    private TextView fMy;
    private TextView fMz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fMe = null;
        this.fMq = null;
        this.fMy = null;
        this.fMB = null;
        this.mClickListener = null;
        this.fMB = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bcn() {
        return this.fMe;
    }

    public TextView bcv() {
        return this.fMq;
    }

    public TextView bcw() {
        return this.fMy;
    }

    public TextView getCancelView() {
        return this.cWW;
    }

    public View bcx() {
        return this.fMC;
    }

    public TextView bcy() {
        return this.fMA;
    }

    public TextView bcz() {
        return this.fMu;
    }

    public TextView bcA() {
        return this.fMs;
    }

    public TextView bcB() {
        return this.fMx;
    }

    public TextView bcC() {
        return this.fMr;
    }

    public TextView bcD() {
        return this.fMt;
    }

    public TextView bcE() {
        return this.fMv;
    }

    public TextView bcF() {
        return this.fMw;
    }

    public TextView bcG() {
        return this.fMz;
    }

    public void bcH() {
        if (this.bve == null) {
            this.bve = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fMC.setBackgroundColor(aa.this.fMB.getResources().getColor(d.C0108d.common_color_10082));
                }
            };
        }
        this.fMC.postDelayed(this.bve, 200L);
    }

    public void bcI() {
        this.fMC.setBackgroundColor(this.fMB.getResources().getColor(d.C0108d.common_color_10022));
    }

    public void release() {
        this.fMC.removeCallbacks(this.bve);
    }

    public void ke(boolean z) {
        if (z) {
            this.fMy.setVisibility(0);
        } else {
            this.fMy.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.fMz.setVisibility(0);
            this.fMz.setText(str);
            return;
        }
        this.fMz.setVisibility(8);
    }

    public void kf(boolean z) {
        this.fMe.setVisibility(z ? 0 : 8);
    }

    public void J(boolean z, boolean z2) {
        this.fMA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fMA.setText(d.j.group_info_intro_more);
        } else {
            this.fMA.setText(d.j.view_host);
        }
    }

    public void K(boolean z, boolean z2) {
        this.fMu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fMu.setText(d.j.cancel_top);
        } else {
            this.fMu.setText(d.j.top);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fMx.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fMx.setText(d.j.cancel_good);
        } else {
            this.fMx.setText(d.j.commit_good);
        }
    }

    public void kg(boolean z) {
        this.fMs.setVisibility(z ? 0 : 8);
    }

    public void kh(boolean z) {
        this.fMr.setVisibility(z ? 0 : 8);
    }

    public void ki(boolean z) {
        this.fMt.setVisibility(z ? 0 : 8);
    }

    public void M(boolean z, boolean z2) {
        this.fMv.setVisibility(z ? 0 : 8);
        this.fMH = z2;
        if (z2) {
            this.fMv.setText(d.j.view_reverse);
        } else {
            this.fMv.setText(d.j.default_sort);
        }
    }

    public void N(boolean z, boolean z2) {
        this.fMw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fMw.setText(d.j.normal_mode);
        } else {
            this.fMw.setText(d.j.eyeshield_mode);
        }
    }

    public void kj(boolean z) {
        this.fMq.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fMB.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fMe = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fMe.setOnClickListener(this.mClickListener);
        this.fMq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fMq.setOnClickListener(this.mClickListener);
        this.fMy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fMy.setOnClickListener(this.mClickListener);
        this.fMz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fMz.setOnClickListener(this.mClickListener);
        this.fMr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fMr.setOnClickListener(this.mClickListener);
        this.fMs = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fMs.setOnClickListener(this.mClickListener);
        this.fMt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fMt.setOnClickListener(this.mClickListener);
        this.fMv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fMv.setOnClickListener(this.mClickListener);
        this.fMw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fMw.setOnClickListener(this.mClickListener);
        this.fMu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fMu.setOnClickListener(this.mClickListener);
        this.fMx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fMx.setOnClickListener(this.mClickListener);
        this.fMA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fMA.setOnClickListener(this.mClickListener);
        this.fMC = this.mView.findViewById(d.g.pb_more_layer);
        this.fMD = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fMF = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fME = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cWW = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cWW.setOnClickListener(this.mClickListener);
        this.fMC.setOnClickListener(this.mClickListener);
    }

    public void akR() {
        com.baidu.tbadk.core.util.aj.t(this.fMD, d.C0108d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.t(this.fME, d.C0108d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.s(this.cWW, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.e(this.cWW, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMe, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMq, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMy, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMz, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMA, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMr, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMs, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMu, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMx, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMt, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMv, d.C0108d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fMw, d.C0108d.cp_cont_f, 1);
        this.fMD.setHorizontalSpacing(((((WindowManager) this.fMB.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fMq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fMy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fMz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fMr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fMG) {
            this.fMs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fMs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fMu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fMx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fMt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fMw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fMH) {
            this.fMv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fMv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.fMA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fMF != null) {
            this.fMF.onChangeSkinType();
        }
    }
}
