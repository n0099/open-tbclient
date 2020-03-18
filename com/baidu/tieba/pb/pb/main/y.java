package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes9.dex */
public class y extends com.baidu.adp.base.c {
    private TextView cyL;
    private BaseFragment eEg;
    private TextView iNA;
    private TextView iNB;
    private LinearLayout iNC;
    private TextSizeSeekBar iND;
    public boolean iNE;
    public boolean iNF;
    private FlowLayout iNr;
    private TextView iNs;
    private TextView iNt;
    private TextView iNu;
    private TextView iNv;
    private TextView iNw;
    private TextView iNx;
    private TextView iNy;
    private TextView iNz;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.iNA = null;
        this.mClickListener = null;
        this.eEg = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cpa() {
        return this.iNs;
    }

    public TextView cpb() {
        return this.iNA;
    }

    public TextView cpc() {
        return this.cyL;
    }

    public TextView cpd() {
        return this.iNB;
    }

    public TextView cpe() {
        return this.iNw;
    }

    public TextView cpf() {
        return this.iNu;
    }

    public TextView cpg() {
        return this.iNz;
    }

    public TextView cph() {
        return this.iNt;
    }

    public TextView cpi() {
        return this.iNv;
    }

    public TextView cpj() {
        return this.iNx;
    }

    public TextView cpk() {
        return this.iNy;
    }

    public void release() {
    }

    public void qf(boolean z) {
        this.iNA.setVisibility(z ? 0 : 8);
    }

    public void Z(boolean z, boolean z2) {
        this.iNB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iNB.setText(R.string.group_info_intro_more);
            this.iNB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iNB.setText(R.string.view_host);
        this.iNB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void aa(boolean z, boolean z2) {
        this.iNw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iNw.setText(R.string.pb_cancel_top);
            this.iNw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iNw.setText(R.string.f1281top);
        this.iNw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ab(boolean z, boolean z2) {
        this.iNz.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iNz.setText(R.string.pb_cancel_good);
            this.iNz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iNz.setText(R.string.commit_good);
        this.iNz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qg(boolean z) {
        this.iNu.setVisibility(z ? 0 : 8);
    }

    public void qh(boolean z) {
        this.iNt.setVisibility(z ? 0 : 8);
    }

    public void qi(boolean z) {
        this.iNv.setVisibility(z ? 0 : 8);
    }

    public void ac(boolean z, boolean z2) {
        this.iNx.setVisibility(z ? 0 : 8);
        this.iNF = z2;
        if (z2) {
            this.iNx.setText(R.string.view_reverse);
        } else {
            this.iNx.setText(R.string.default_sort);
        }
        this.iNx.setText(R.string.sort_selector);
    }

    public void ad(boolean z, boolean z2) {
        this.iNy.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iNy.setText(R.string.normal_mode);
            this.iNy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iNy.setText(R.string.eyeshield_mode);
        this.iNy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qj(boolean z) {
        this.iNs.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eEg.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.iNr = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.iNB = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.iNB.setOnClickListener(this.mClickListener);
        this.iNx = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.iNx.setOnClickListener(this.mClickListener);
        this.iNs = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.iNs.setOnClickListener(this.mClickListener);
        this.iNy = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.iNy.setOnClickListener(this.mClickListener);
        this.iNt = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.iNt.setOnClickListener(this.mClickListener);
        this.iNA = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.iNA.setOnClickListener(this.mClickListener);
        this.iNu = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.iNu.setOnClickListener(this.mClickListener);
        this.iNv = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.iNv.setOnClickListener(this.mClickListener);
        this.iNw = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.iNw.setOnClickListener(this.mClickListener);
        this.iNz = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.iNz.setOnClickListener(this.mClickListener);
        this.iND = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.iNC = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cyL = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cyL.setOnClickListener(this.mClickListener);
    }

    public void cpl() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNr, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.iNC, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cyL, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cyL, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNs, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNA, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNB, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNt, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNu, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNw, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNz, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNv, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNx, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iNy, R.color.cp_cont_f, 1);
        this.iNr.setHorizontalSpacing(((((WindowManager) this.eEg.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.iNs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iNA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iNt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iNu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(this.iNE ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iNv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iNx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.iND != null) {
            this.iND.onChangeSkinType();
        }
    }
}
