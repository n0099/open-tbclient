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
    private TextView bjN;
    private PbActivity htA;
    private FlowLayout htB;
    private LinearLayout htC;
    private TextSizeSeekBar htD;
    public boolean htE;
    public boolean htF;
    private final float hto;
    private TextView htp;
    private TextView htq;
    private TextView htr;
    private TextView hts;
    private TextView htt;
    private TextView htu;
    private TextView htv;
    private TextView htw;
    private TextView htx;
    private TextView hty;
    private TextView htz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hto = 0.5f;
        this.mView = null;
        this.htp = null;
        this.htx = null;
        this.htA = null;
        this.mClickListener = null;
        this.htA = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bLM() {
        return this.htp;
    }

    public TextView bLN() {
        return this.htx;
    }

    public TextView getCancelView() {
        return this.bjN;
    }

    public TextView bLO() {
        return this.htz;
    }

    public TextView bLP() {
        return this.htt;
    }

    public TextView bLQ() {
        return this.htr;
    }

    public TextView bLR() {
        return this.htw;
    }

    public TextView bLS() {
        return this.htq;
    }

    public TextView bLT() {
        return this.hts;
    }

    public TextView bLU() {
        return this.htu;
    }

    public TextView bLV() {
        return this.htv;
    }

    public TextView bLW() {
        return this.hty;
    }

    public void release() {
    }

    public void nD(boolean z) {
        if (z) {
            this.htx.setVisibility(0);
        } else {
            this.htx.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.hty.setVisibility(0);
            this.hty.setText(str);
            return;
        }
        this.hty.setVisibility(8);
    }

    public void T(boolean z, boolean z2) {
        this.htz.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htz.setText(d.j.group_info_intro_more);
        } else {
            this.htz.setText(d.j.view_host);
        }
    }

    public void U(boolean z, boolean z2) {
        this.htt.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htt.setText(d.j.cancel_top);
        } else {
            this.htt.setText(d.j.top);
        }
    }

    public void V(boolean z, boolean z2) {
        this.htw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htw.setText(d.j.cancel_good);
        } else {
            this.htw.setText(d.j.commit_good);
        }
    }

    public void nE(boolean z) {
        this.htr.setVisibility(z ? 0 : 8);
    }

    public void nF(boolean z) {
        this.htq.setVisibility(z ? 0 : 8);
    }

    public void nG(boolean z) {
        this.hts.setVisibility(z ? 0 : 8);
    }

    public void W(boolean z, boolean z2) {
        this.htu.setVisibility(z ? 0 : 8);
        this.htF = z2;
        if (z2) {
            this.htu.setText(d.j.view_reverse);
        } else {
            this.htu.setText(d.j.default_sort);
        }
        this.htu.setText(d.j.sort_selector);
    }

    public void X(boolean z, boolean z2) {
        this.htv.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htv.setText(d.j.normal_mode);
        } else {
            this.htv.setText(d.j.eyeshield_mode);
        }
    }

    public void nH(boolean z) {
        this.htp.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.htA.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.htp = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.htp.setOnClickListener(this.mClickListener);
        this.htx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.htx.setOnClickListener(this.mClickListener);
        this.hty = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.hty.setOnClickListener(this.mClickListener);
        this.htq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.htq.setOnClickListener(this.mClickListener);
        this.htr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.htr.setOnClickListener(this.mClickListener);
        this.hts = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.hts.setOnClickListener(this.mClickListener);
        this.htu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.htu.setOnClickListener(this.mClickListener);
        this.htv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.htv.setOnClickListener(this.mClickListener);
        this.htt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.htt.setOnClickListener(this.mClickListener);
        this.htw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.htw.setOnClickListener(this.mClickListener);
        this.htz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.htz.setOnClickListener(this.mClickListener);
        this.htB = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.htD = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.htC = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.bjN = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.bjN.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.htB, d.C0277d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.htC, d.f.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bjN, d.f.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.d(this.bjN, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.d(this.htp, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htx, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.hty, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htz, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htq, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htr, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htt, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htw, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.hts, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htu, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htv, d.C0277d.cp_cont_f, 1);
        this.htB.setHorizontalSpacing(((((WindowManager) this.htA.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.htp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hty.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.htq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htE) {
            this.htr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.htr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.htt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hts.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htD != null) {
            this.htD.onChangeSkinType();
        }
    }
}
