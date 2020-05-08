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
    private TextView cXN;
    private BaseFragment fiG;
    private FlowLayout jxE;
    private TextView jxF;
    private TextView jxG;
    private TextView jxH;
    private TextView jxI;
    private TextView jxJ;
    private TextView jxK;
    private TextView jxL;
    private TextView jxM;
    private TextView jxN;
    private TextView jxO;
    private LinearLayout jxP;
    private TextSizeSeekBar jxQ;
    public boolean jxR;
    public boolean jxS;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.jxN = null;
        this.mClickListener = null;
        this.fiG = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView czD() {
        return this.jxF;
    }

    public TextView czE() {
        return this.jxN;
    }

    public TextView czF() {
        return this.cXN;
    }

    public TextView czG() {
        return this.jxO;
    }

    public TextView czH() {
        return this.jxJ;
    }

    public TextView czI() {
        return this.jxH;
    }

    public TextView czJ() {
        return this.jxM;
    }

    public TextView czK() {
        return this.jxG;
    }

    public TextView czL() {
        return this.jxI;
    }

    public TextView czM() {
        return this.jxK;
    }

    public TextView czN() {
        return this.jxL;
    }

    public void release() {
    }

    public void rj(boolean z) {
        this.jxN.setVisibility(z ? 0 : 8);
    }

    public void aa(boolean z, boolean z2) {
        this.jxO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxO.setText(R.string.group_info_intro_more);
            this.jxO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxO.setText(R.string.view_host);
        this.jxO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ab(boolean z, boolean z2) {
        this.jxJ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxJ.setText(R.string.pb_cancel_top);
            this.jxJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxJ.setText(R.string.f1279top);
        this.jxJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ac(boolean z, boolean z2) {
        this.jxM.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxM.setText(R.string.pb_cancel_good);
            this.jxM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxM.setText(R.string.commit_good);
        this.jxM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rk(boolean z) {
        this.jxH.setVisibility(z ? 0 : 8);
    }

    public void rl(boolean z) {
        this.jxG.setVisibility(z ? 0 : 8);
    }

    public void rm(boolean z) {
        this.jxI.setVisibility(z ? 0 : 8);
    }

    public void ad(boolean z, boolean z2) {
        this.jxK.setVisibility(z ? 0 : 8);
        this.jxS = z2;
        if (z2) {
            this.jxK.setText(R.string.view_reverse);
        } else {
            this.jxK.setText(R.string.default_sort);
        }
        this.jxK.setText(R.string.sort_selector);
    }

    public void ae(boolean z, boolean z2) {
        this.jxL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jxL.setText(R.string.normal_mode);
            this.jxL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jxL.setText(R.string.eyeshield_mode);
        this.jxL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rn(boolean z) {
        this.jxF.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fiG.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.jxE = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.jxO = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.jxO.setOnClickListener(this.mClickListener);
        this.jxK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.jxK.setOnClickListener(this.mClickListener);
        this.jxF = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.jxF.setOnClickListener(this.mClickListener);
        this.jxL = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.jxL.setOnClickListener(this.mClickListener);
        this.jxG = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.jxG.setOnClickListener(this.mClickListener);
        this.jxN = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.jxN.setOnClickListener(this.mClickListener);
        this.jxH = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.jxH.setOnClickListener(this.mClickListener);
        this.jxI = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.jxI.setOnClickListener(this.mClickListener);
        this.jxJ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.jxJ.setOnClickListener(this.mClickListener);
        this.jxM = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.jxM.setOnClickListener(this.mClickListener);
        this.jxQ = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.jxP = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cXN = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cXN.setOnClickListener(this.mClickListener);
    }

    public void czO() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.jxE, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.jxP, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cXN, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cXN, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxF, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxN, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxO, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxG, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxH, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxJ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxM, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxI, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jxL, R.color.cp_cont_f, 1);
        this.jxE.setHorizontalSpacing(((((WindowManager) this.fiG.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.jxF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(this.jxR ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jxK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.jxQ != null) {
            this.jxQ.onChangeSkinType();
        }
    }
}
