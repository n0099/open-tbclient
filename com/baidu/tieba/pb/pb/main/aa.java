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
    private Runnable bvn;
    private TextView dbA;
    private TextView fNE;
    private TextView fNQ;
    private TextView fNR;
    private TextView fNS;
    private TextView fNT;
    private TextView fNU;
    private TextView fNV;
    private TextView fNW;
    private TextView fNX;
    private TextView fNY;
    private TextView fNZ;
    private TextView fOa;
    private PbActivity fOb;
    private View fOc;
    private FlowLayout fOd;
    private LinearLayout fOe;
    private TextSizeSeekBar fOf;
    public boolean fOg;
    public boolean fOh;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fNE = null;
        this.fNQ = null;
        this.fNY = null;
        this.fOb = null;
        this.mClickListener = null;
        this.fOb = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bcr() {
        return this.fNE;
    }

    public TextView bcz() {
        return this.fNQ;
    }

    public TextView bcA() {
        return this.fNY;
    }

    public TextView getCancelView() {
        return this.dbA;
    }

    public View bcB() {
        return this.fOc;
    }

    public TextView bcC() {
        return this.fOa;
    }

    public TextView bcD() {
        return this.fNU;
    }

    public TextView bcE() {
        return this.fNS;
    }

    public TextView bcF() {
        return this.fNX;
    }

    public TextView bcG() {
        return this.fNR;
    }

    public TextView bcH() {
        return this.fNT;
    }

    public TextView bcI() {
        return this.fNV;
    }

    public TextView bcJ() {
        return this.fNW;
    }

    public TextView bcK() {
        return this.fNZ;
    }

    public void bcL() {
        if (this.bvn == null) {
            this.bvn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fOc.setBackgroundColor(aa.this.fOb.getResources().getColor(d.C0107d.common_color_10082));
                }
            };
        }
        this.fOc.postDelayed(this.bvn, 200L);
    }

    public void bcM() {
        this.fOc.setBackgroundColor(this.fOb.getResources().getColor(d.C0107d.common_color_10022));
    }

    public void release() {
        this.fOc.removeCallbacks(this.bvn);
    }

    public void kg(boolean z) {
        if (z) {
            this.fNY.setVisibility(0);
        } else {
            this.fNY.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.fNZ.setVisibility(0);
            this.fNZ.setText(str);
            return;
        }
        this.fNZ.setVisibility(8);
    }

    public void kh(boolean z) {
        this.fNE.setVisibility(z ? 0 : 8);
    }

    public void J(boolean z, boolean z2) {
        this.fOa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fOa.setText(d.j.group_info_intro_more);
        } else {
            this.fOa.setText(d.j.view_host);
        }
    }

    public void K(boolean z, boolean z2) {
        this.fNU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fNU.setText(d.j.cancel_top);
        } else {
            this.fNU.setText(d.j.top);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fNX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fNX.setText(d.j.cancel_good);
        } else {
            this.fNX.setText(d.j.commit_good);
        }
    }

    public void ki(boolean z) {
        this.fNS.setVisibility(z ? 0 : 8);
    }

    public void kj(boolean z) {
        this.fNR.setVisibility(z ? 0 : 8);
    }

    public void kk(boolean z) {
        this.fNT.setVisibility(z ? 0 : 8);
    }

    public void M(boolean z, boolean z2) {
        this.fNV.setVisibility(z ? 0 : 8);
        this.fOh = z2;
        if (z2) {
            this.fNV.setText(d.j.view_reverse);
        } else {
            this.fNV.setText(d.j.default_sort);
        }
    }

    public void N(boolean z, boolean z2) {
        this.fNW.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fNW.setText(d.j.normal_mode);
        } else {
            this.fNW.setText(d.j.eyeshield_mode);
        }
    }

    public void kl(boolean z) {
        this.fNQ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fOb.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fNE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fNE.setOnClickListener(this.mClickListener);
        this.fNQ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fNQ.setOnClickListener(this.mClickListener);
        this.fNY = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fNY.setOnClickListener(this.mClickListener);
        this.fNZ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fNZ.setOnClickListener(this.mClickListener);
        this.fNR = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fNR.setOnClickListener(this.mClickListener);
        this.fNS = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fNS.setOnClickListener(this.mClickListener);
        this.fNT = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fNT.setOnClickListener(this.mClickListener);
        this.fNV = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fNV.setOnClickListener(this.mClickListener);
        this.fNW = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fNW.setOnClickListener(this.mClickListener);
        this.fNU = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fNU.setOnClickListener(this.mClickListener);
        this.fNX = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fNX.setOnClickListener(this.mClickListener);
        this.fOa = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fOa.setOnClickListener(this.mClickListener);
        this.fOc = this.mView.findViewById(d.g.pb_more_layer);
        this.fOd = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fOf = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fOe = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.dbA = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.dbA.setOnClickListener(this.mClickListener);
        this.fOc.setOnClickListener(this.mClickListener);
    }

    public void alU() {
        com.baidu.tbadk.core.util.aj.t(this.fOd, d.C0107d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.t(this.fOe, d.C0107d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.s(this.dbA, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.e(this.dbA, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNE, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNQ, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNY, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNZ, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fOa, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNR, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNS, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNU, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNX, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNT, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNV, d.C0107d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fNW, d.C0107d.cp_cont_f, 1);
        this.fOd.setHorizontalSpacing(((((WindowManager) this.fOb.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fNE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fNQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fNY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fNZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fNR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fOg) {
            this.fNS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fNS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fNU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fNX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fNT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fNW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fOh) {
            this.fNV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fNV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.fOa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fOf != null) {
            this.fOf.onChangeSkinType();
        }
    }
}
