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
public class y extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aGI;
    private TextView bZD;
    private TextView ePK;
    private TextView ePL;
    private TextView ePM;
    private TextView ePN;
    private TextView ePO;
    private TextView ePP;
    private TextView ePQ;
    private TextView ePR;
    private TextView ePS;
    private TextView ePT;
    private TextView ePU;
    private PbActivity ePV;
    private View ePW;
    private FlowLayout ePX;
    private LinearLayout ePY;
    private TextSizeSeekBar ePZ;
    private TextView ePz;
    public boolean eQa;
    public boolean eQb;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.ePz = null;
        this.ePK = null;
        this.ePS = null;
        this.ePV = null;
        this.mClickListener = null;
        this.ePV = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aTs() {
        return this.ePz;
    }

    public TextView aTA() {
        return this.ePK;
    }

    public TextView aTB() {
        return this.ePS;
    }

    public TextView getCancelView() {
        return this.bZD;
    }

    public View aTC() {
        return this.ePW;
    }

    public TextView aTD() {
        return this.ePU;
    }

    public TextView aTE() {
        return this.ePO;
    }

    public TextView aTF() {
        return this.ePM;
    }

    public TextView aTG() {
        return this.ePR;
    }

    public TextView aTH() {
        return this.ePL;
    }

    public TextView aTI() {
        return this.ePN;
    }

    public TextView aTJ() {
        return this.ePP;
    }

    public TextView aTK() {
        return this.ePQ;
    }

    public TextView aTL() {
        return this.ePT;
    }

    public void aTM() {
        if (this.aGI == null) {
            this.aGI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.ePW.setBackgroundColor(y.this.ePV.getResources().getColor(d.C0080d.common_color_10082));
                }
            };
        }
        this.ePW.postDelayed(this.aGI, 200L);
    }

    public void aTN() {
        this.ePW.setBackgroundColor(this.ePV.getResources().getColor(d.C0080d.common_color_10022));
    }

    public void release() {
        this.ePW.removeCallbacks(this.aGI);
    }

    public void jg(boolean z) {
        if (z) {
            this.ePS.setVisibility(0);
        } else {
            this.ePS.setVisibility(8);
        }
    }

    public void l(boolean z, String str) {
        if (z) {
            this.ePT.setVisibility(0);
            this.ePT.setText(str);
            return;
        }
        this.ePT.setVisibility(8);
    }

    public void jh(boolean z) {
        this.ePz.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.ePU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePU.setText(d.j.group_info_intro_more);
        } else {
            this.ePU.setText(d.j.view_host);
        }
    }

    public void I(boolean z, boolean z2) {
        this.ePO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePO.setText(d.j.cancel_top);
        } else {
            this.ePO.setText(d.j.top);
        }
    }

    public void J(boolean z, boolean z2) {
        this.ePR.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePR.setText(d.j.cancel_good);
        } else {
            this.ePR.setText(d.j.commit_good);
        }
    }

    public void ji(boolean z) {
        this.ePM.setVisibility(z ? 0 : 8);
    }

    public void jj(boolean z) {
        this.ePL.setVisibility(z ? 0 : 8);
    }

    public void jk(boolean z) {
        this.ePN.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.ePP.setVisibility(z ? 0 : 8);
        this.eQb = z2;
        if (z2) {
            this.ePP.setText(d.j.view_reverse);
        } else {
            this.ePP.setText(d.j.default_sort);
        }
    }

    public void L(boolean z, boolean z2) {
        this.ePQ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePQ.setText(d.j.normal_mode);
        } else {
            this.ePQ.setText(d.j.eyeshield_mode);
        }
    }

    public void jl(boolean z) {
        this.ePK.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ePV.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.ePz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.ePz.setOnClickListener(this.mClickListener);
        this.ePK = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.ePK.setOnClickListener(this.mClickListener);
        this.ePS = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.ePS.setOnClickListener(this.mClickListener);
        this.ePT = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.ePT.setOnClickListener(this.mClickListener);
        this.ePL = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.ePL.setOnClickListener(this.mClickListener);
        this.ePM = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.ePM.setOnClickListener(this.mClickListener);
        this.ePN = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.ePN.setOnClickListener(this.mClickListener);
        this.ePP = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.ePP.setOnClickListener(this.mClickListener);
        this.ePQ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.ePQ.setOnClickListener(this.mClickListener);
        this.ePO = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.ePO.setOnClickListener(this.mClickListener);
        this.ePR = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.ePR.setOnClickListener(this.mClickListener);
        this.ePU = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.ePU.setOnClickListener(this.mClickListener);
        this.ePW = this.mView.findViewById(d.g.pb_more_layer);
        this.ePX = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.ePZ = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.ePY = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.bZD = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.bZD.setOnClickListener(this.mClickListener);
        this.ePW.setOnClickListener(this.mClickListener);
    }

    public void abt() {
        com.baidu.tbadk.core.util.aj.k(this.ePX, d.C0080d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.ePY, d.C0080d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.j(this.bZD, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.bZD, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePz, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePK, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePS, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePT, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePU, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePL, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePM, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePO, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePR, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePN, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePP, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePQ, d.C0080d.cp_cont_f, 1);
        this.ePX.setHorizontalSpacing(((((WindowManager) this.ePV.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.ePz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.ePK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.ePS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.ePT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.ePL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.eQa) {
            this.ePM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.ePM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.ePO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.ePR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.ePN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.ePQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.eQb) {
            this.ePP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.ePP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.ePU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.ePZ != null) {
            this.ePZ.onChangeSkinType();
        }
    }
}
