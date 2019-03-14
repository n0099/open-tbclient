package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes4.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private TextView bjJ;
    private final float htA;
    private TextView htB;
    private TextView htC;
    private TextView htD;
    private TextView htE;
    private TextView htF;
    private TextView htG;
    private TextView htH;
    private TextView htI;
    private TextView htJ;
    private TextView htK;
    private TextView htL;
    private PbActivity htM;
    private FlowLayout htN;
    private LinearLayout htO;
    private TextSizeSeekBar htP;
    public boolean htQ;
    public boolean htR;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.htA = 0.5f;
        this.mView = null;
        this.htB = null;
        this.htJ = null;
        this.htM = null;
        this.mClickListener = null;
        this.htM = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bLP() {
        return this.htB;
    }

    public TextView bLQ() {
        return this.htJ;
    }

    public TextView getCancelView() {
        return this.bjJ;
    }

    public TextView bLR() {
        return this.htL;
    }

    public TextView bLS() {
        return this.htF;
    }

    public TextView bLT() {
        return this.htD;
    }

    public TextView bLU() {
        return this.htI;
    }

    public TextView bLV() {
        return this.htC;
    }

    public TextView bLW() {
        return this.htE;
    }

    public TextView bLX() {
        return this.htG;
    }

    public TextView bLY() {
        return this.htH;
    }

    public TextView bLZ() {
        return this.htK;
    }

    public void release() {
    }

    public void nD(boolean z) {
        if (z) {
            this.htJ.setVisibility(0);
        } else {
            this.htJ.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.htK.setVisibility(0);
            this.htK.setText(str);
            return;
        }
        this.htK.setVisibility(8);
    }

    public void V(boolean z, boolean z2) {
        this.htL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htL.setText(d.j.group_info_intro_more);
        } else {
            this.htL.setText(d.j.view_host);
        }
    }

    public void W(boolean z, boolean z2) {
        this.htF.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htF.setText(d.j.cancel_top);
        } else {
            this.htF.setText(d.j.top);
        }
    }

    public void X(boolean z, boolean z2) {
        this.htI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htI.setText(d.j.cancel_good);
        } else {
            this.htI.setText(d.j.commit_good);
        }
    }

    public void nE(boolean z) {
        this.htD.setVisibility(z ? 0 : 8);
    }

    public void nF(boolean z) {
        this.htC.setVisibility(z ? 0 : 8);
    }

    public void nG(boolean z) {
        this.htE.setVisibility(z ? 0 : 8);
    }

    public void Y(boolean z, boolean z2) {
        this.htG.setVisibility(z ? 0 : 8);
        this.htR = z2;
        if (z2) {
            this.htG.setText(d.j.view_reverse);
        } else {
            this.htG.setText(d.j.default_sort);
        }
        this.htG.setText(d.j.sort_selector);
    }

    public void Z(boolean z, boolean z2) {
        this.htH.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htH.setText(d.j.normal_mode);
        } else {
            this.htH.setText(d.j.eyeshield_mode);
        }
    }

    public void nH(boolean z) {
        this.htB.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.htM.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.htB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.htB.setOnClickListener(this.mClickListener);
        this.htJ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.htJ.setOnClickListener(this.mClickListener);
        this.htK = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.htK.setOnClickListener(this.mClickListener);
        this.htC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.htC.setOnClickListener(this.mClickListener);
        this.htD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.htD.setOnClickListener(this.mClickListener);
        this.htE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.htE.setOnClickListener(this.mClickListener);
        this.htG = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.htG.setOnClickListener(this.mClickListener);
        this.htH = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.htH.setOnClickListener(this.mClickListener);
        this.htF = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.htF.setOnClickListener(this.mClickListener);
        this.htI = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.htI.setOnClickListener(this.mClickListener);
        this.htL = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.htL.setOnClickListener(this.mClickListener);
        this.htN = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.htP = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.htO = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.bjJ = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.bjJ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.htN, d.C0277d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.htO, d.f.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bjJ, d.f.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.d(this.bjJ, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.d(this.htB, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htJ, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htK, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htL, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htC, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htD, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htF, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htI, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htE, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htG, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htH, d.C0277d.cp_cont_f, 1);
        this.htN.setHorizontalSpacing(((((WindowManager) this.htM.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.htB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.htC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htQ) {
            this.htD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.htD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.htF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htP != null) {
            this.htP.onChangeSkinType();
        }
    }
}
