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
    private TextView cXI;
    private BaseFragment fiB;
    private FlowLayout jxA;
    private TextView jxB;
    private TextView jxC;
    private TextView jxD;
    private TextView jxE;
    private TextView jxF;
    private TextView jxG;
    private TextView jxH;
    private TextView jxI;
    private TextView jxJ;
    private TextView jxK;
    private LinearLayout jxL;
    private TextSizeSeekBar jxM;
    public boolean jxN;
    public boolean jxO;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.jxJ = null;
        this.mClickListener = null;
        this.fiB = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView czG() {
        return this.jxB;
    }

    public TextView czH() {
        return this.jxJ;
    }

    public TextView czI() {
        return this.cXI;
    }

    public TextView czJ() {
        return this.jxK;
    }

    public TextView czK() {
        return this.jxF;
    }

    public TextView czL() {
        return this.jxD;
    }

    public TextView czM() {
        return this.jxI;
    }

    public TextView czN() {
        return this.jxC;
    }

    public TextView czO() {
        return this.jxE;
    }

    public TextView czP() {
        return this.jxG;
    }

    public TextView czQ() {
        return this.jxH;
    }

    public void release() {
    }

    public void rj(boolean z) {
        this.jxJ.setVisibility(z ? 0 : 8);
    }

    public void aa(boolean z, boolean z2) {
        this.jxK.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxK.setText(R.string.group_info_intro_more);
            this.jxK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxK.setText(R.string.view_host);
        this.jxK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ab(boolean z, boolean z2) {
        this.jxF.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxF.setText(R.string.pb_cancel_top);
            this.jxF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxF.setText(R.string.f1287top);
        this.jxF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ac(boolean z, boolean z2) {
        this.jxI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxI.setText(R.string.pb_cancel_good);
            this.jxI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxI.setText(R.string.commit_good);
        this.jxI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rk(boolean z) {
        this.jxD.setVisibility(z ? 0 : 8);
    }

    public void rl(boolean z) {
        this.jxC.setVisibility(z ? 0 : 8);
    }

    public void rm(boolean z) {
        this.jxE.setVisibility(z ? 0 : 8);
    }

    public void ad(boolean z, boolean z2) {
        this.jxG.setVisibility(z ? 0 : 8);
        this.jxO = z2;
        if (z2) {
            this.jxG.setText(R.string.view_reverse);
        } else {
            this.jxG.setText(R.string.default_sort);
        }
        this.jxG.setText(R.string.sort_selector);
    }

    public void ae(boolean z, boolean z2) {
        this.jxH.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxH.setText(R.string.normal_mode);
            this.jxH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxH.setText(R.string.eyeshield_mode);
        this.jxH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rn(boolean z) {
        this.jxB.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fiB.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.jxA = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.jxK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.jxK.setOnClickListener(this.mClickListener);
        this.jxG = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.jxG.setOnClickListener(this.mClickListener);
        this.jxB = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.jxB.setOnClickListener(this.mClickListener);
        this.jxH = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.jxH.setOnClickListener(this.mClickListener);
        this.jxC = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.jxC.setOnClickListener(this.mClickListener);
        this.jxJ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.jxJ.setOnClickListener(this.mClickListener);
        this.jxD = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.jxD.setOnClickListener(this.mClickListener);
        this.jxE = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.jxE.setOnClickListener(this.mClickListener);
        this.jxF = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.jxF.setOnClickListener(this.mClickListener);
        this.jxI = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.jxI.setOnClickListener(this.mClickListener);
        this.jxM = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.jxL = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cXI = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cXI.setOnClickListener(this.mClickListener);
    }

    public void czR() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.jxA, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.jxL, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cXI, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cXI, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxB, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxJ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxC, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxD, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxF, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxI, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxE, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxG, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxH, R.color.cp_cont_f, 1);
        this.jxA.setHorizontalSpacing(((((WindowManager) this.fiB.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.jxB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(this.jxN ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.jxM != null) {
            this.jxM.onChangeSkinType();
        }
    }
}
