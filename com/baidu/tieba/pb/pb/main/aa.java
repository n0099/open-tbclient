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
    private TextView bjI;
    private final float htG;
    private TextView htH;
    private TextView htI;
    private TextView htJ;
    private TextView htK;
    private TextView htL;
    private TextView htM;
    private TextView htN;
    private TextView htO;
    private TextView htP;
    private TextView htQ;
    private TextView htR;
    private PbActivity htS;
    private FlowLayout htT;
    private LinearLayout htU;
    private TextSizeSeekBar htV;
    public boolean htW;
    public boolean htX;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.htG = 0.5f;
        this.mView = null;
        this.htH = null;
        this.htP = null;
        this.htS = null;
        this.mClickListener = null;
        this.htS = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bLP() {
        return this.htH;
    }

    public TextView bLQ() {
        return this.htP;
    }

    public TextView getCancelView() {
        return this.bjI;
    }

    public TextView bLR() {
        return this.htR;
    }

    public TextView bLS() {
        return this.htL;
    }

    public TextView bLT() {
        return this.htJ;
    }

    public TextView bLU() {
        return this.htO;
    }

    public TextView bLV() {
        return this.htI;
    }

    public TextView bLW() {
        return this.htK;
    }

    public TextView bLX() {
        return this.htM;
    }

    public TextView bLY() {
        return this.htN;
    }

    public TextView bLZ() {
        return this.htQ;
    }

    public void release() {
    }

    public void nD(boolean z) {
        if (z) {
            this.htP.setVisibility(0);
        } else {
            this.htP.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.htQ.setVisibility(0);
            this.htQ.setText(str);
            return;
        }
        this.htQ.setVisibility(8);
    }

    public void V(boolean z, boolean z2) {
        this.htR.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htR.setText(d.j.group_info_intro_more);
        } else {
            this.htR.setText(d.j.view_host);
        }
    }

    public void W(boolean z, boolean z2) {
        this.htL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htL.setText(d.j.cancel_top);
        } else {
            this.htL.setText(d.j.top);
        }
    }

    public void X(boolean z, boolean z2) {
        this.htO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htO.setText(d.j.cancel_good);
        } else {
            this.htO.setText(d.j.commit_good);
        }
    }

    public void nE(boolean z) {
        this.htJ.setVisibility(z ? 0 : 8);
    }

    public void nF(boolean z) {
        this.htI.setVisibility(z ? 0 : 8);
    }

    public void nG(boolean z) {
        this.htK.setVisibility(z ? 0 : 8);
    }

    public void Y(boolean z, boolean z2) {
        this.htM.setVisibility(z ? 0 : 8);
        this.htX = z2;
        if (z2) {
            this.htM.setText(d.j.view_reverse);
        } else {
            this.htM.setText(d.j.default_sort);
        }
        this.htM.setText(d.j.sort_selector);
    }

    public void Z(boolean z, boolean z2) {
        this.htN.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htN.setText(d.j.normal_mode);
        } else {
            this.htN.setText(d.j.eyeshield_mode);
        }
    }

    public void nH(boolean z) {
        this.htH.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.htS.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.htH = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.htH.setOnClickListener(this.mClickListener);
        this.htP = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.htP.setOnClickListener(this.mClickListener);
        this.htQ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.htQ.setOnClickListener(this.mClickListener);
        this.htI = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.htI.setOnClickListener(this.mClickListener);
        this.htJ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.htJ.setOnClickListener(this.mClickListener);
        this.htK = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.htK.setOnClickListener(this.mClickListener);
        this.htM = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.htM.setOnClickListener(this.mClickListener);
        this.htN = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.htN.setOnClickListener(this.mClickListener);
        this.htL = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.htL.setOnClickListener(this.mClickListener);
        this.htO = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.htO.setOnClickListener(this.mClickListener);
        this.htR = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.htR.setOnClickListener(this.mClickListener);
        this.htT = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.htV = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.htU = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.bjI = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.bjI.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.htT, d.C0236d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.htU, d.f.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bjI, d.f.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.d(this.bjI, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.d(this.htH, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htP, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htQ, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htR, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htI, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htJ, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htL, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htO, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htK, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htM, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htN, d.C0236d.cp_cont_f, 1);
        this.htT.setHorizontalSpacing(((((WindowManager) this.htS.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.htH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.htI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htW) {
            this.htJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.htJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.htL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htV != null) {
            this.htV.onChangeSkinType();
        }
    }
}
