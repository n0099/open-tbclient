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
    private TextView bjM;
    private FlowLayout htA;
    private LinearLayout htB;
    private TextSizeSeekBar htC;
    public boolean htD;
    public boolean htE;
    private final float htn;
    private TextView hto;
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
    private PbActivity htz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.htn = 0.5f;
        this.mView = null;
        this.hto = null;
        this.htw = null;
        this.htz = null;
        this.mClickListener = null;
        this.htz = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bLM() {
        return this.hto;
    }

    public TextView bLN() {
        return this.htw;
    }

    public TextView getCancelView() {
        return this.bjM;
    }

    public TextView bLO() {
        return this.hty;
    }

    public TextView bLP() {
        return this.hts;
    }

    public TextView bLQ() {
        return this.htq;
    }

    public TextView bLR() {
        return this.htv;
    }

    public TextView bLS() {
        return this.htp;
    }

    public TextView bLT() {
        return this.htr;
    }

    public TextView bLU() {
        return this.htt;
    }

    public TextView bLV() {
        return this.htu;
    }

    public TextView bLW() {
        return this.htx;
    }

    public void release() {
    }

    public void nD(boolean z) {
        if (z) {
            this.htw.setVisibility(0);
        } else {
            this.htw.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.htx.setVisibility(0);
            this.htx.setText(str);
            return;
        }
        this.htx.setVisibility(8);
    }

    public void T(boolean z, boolean z2) {
        this.hty.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hty.setText(d.j.group_info_intro_more);
        } else {
            this.hty.setText(d.j.view_host);
        }
    }

    public void U(boolean z, boolean z2) {
        this.hts.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hts.setText(d.j.cancel_top);
        } else {
            this.hts.setText(d.j.top);
        }
    }

    public void V(boolean z, boolean z2) {
        this.htv.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htv.setText(d.j.cancel_good);
        } else {
            this.htv.setText(d.j.commit_good);
        }
    }

    public void nE(boolean z) {
        this.htq.setVisibility(z ? 0 : 8);
    }

    public void nF(boolean z) {
        this.htp.setVisibility(z ? 0 : 8);
    }

    public void nG(boolean z) {
        this.htr.setVisibility(z ? 0 : 8);
    }

    public void W(boolean z, boolean z2) {
        this.htt.setVisibility(z ? 0 : 8);
        this.htE = z2;
        if (z2) {
            this.htt.setText(d.j.view_reverse);
        } else {
            this.htt.setText(d.j.default_sort);
        }
        this.htt.setText(d.j.sort_selector);
    }

    public void X(boolean z, boolean z2) {
        this.htu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.htu.setText(d.j.normal_mode);
        } else {
            this.htu.setText(d.j.eyeshield_mode);
        }
    }

    public void nH(boolean z) {
        this.hto.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.htz.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.hto = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.hto.setOnClickListener(this.mClickListener);
        this.htw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.htw.setOnClickListener(this.mClickListener);
        this.htx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.htx.setOnClickListener(this.mClickListener);
        this.htp = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.htp.setOnClickListener(this.mClickListener);
        this.htq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.htq.setOnClickListener(this.mClickListener);
        this.htr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.htr.setOnClickListener(this.mClickListener);
        this.htt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.htt.setOnClickListener(this.mClickListener);
        this.htu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.htu.setOnClickListener(this.mClickListener);
        this.hts = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.hts.setOnClickListener(this.mClickListener);
        this.htv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.htv.setOnClickListener(this.mClickListener);
        this.hty = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.hty.setOnClickListener(this.mClickListener);
        this.htA = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.htC = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.htB = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.bjM = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.bjM.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.htA, d.C0277d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.htB, d.f.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bjM, d.f.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.d(this.bjM, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.d(this.hto, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htw, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htx, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.hty, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htp, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htq, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.hts, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htv, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htr, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htt, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.d(this.htu, d.C0277d.cp_cont_f, 1);
        this.htA.setHorizontalSpacing(((((WindowManager) this.htz.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.hto.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.htp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htD) {
            this.htq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.htq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.hts.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.htt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hty.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(d.f.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.htC != null) {
            this.htC.onChangeSkinType();
        }
    }
}
