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
    private TextView cyy;
    private BaseFragment eDw;
    private FlowLayout iLC;
    private TextView iLD;
    private TextView iLE;
    private TextView iLF;
    private TextView iLG;
    private TextView iLH;
    private TextView iLI;
    private TextView iLJ;
    private TextView iLK;
    private TextView iLL;
    private TextView iLM;
    private LinearLayout iLN;
    private TextSizeSeekBar iLO;
    public boolean iLP;
    public boolean iLQ;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.iLL = null;
        this.mClickListener = null;
        this.eDw = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView coC() {
        return this.iLD;
    }

    public TextView coD() {
        return this.iLL;
    }

    public TextView coE() {
        return this.cyy;
    }

    public TextView coF() {
        return this.iLM;
    }

    public TextView coG() {
        return this.iLH;
    }

    public TextView coH() {
        return this.iLF;
    }

    public TextView coI() {
        return this.iLK;
    }

    public TextView coJ() {
        return this.iLE;
    }

    public TextView coK() {
        return this.iLG;
    }

    public TextView coL() {
        return this.iLI;
    }

    public TextView coM() {
        return this.iLJ;
    }

    public void release() {
    }

    public void pZ(boolean z) {
        this.iLL.setVisibility(z ? 0 : 8);
    }

    public void Z(boolean z, boolean z2) {
        this.iLM.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLM.setText(R.string.group_info_intro_more);
            this.iLM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLM.setText(R.string.view_host);
        this.iLM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void aa(boolean z, boolean z2) {
        this.iLH.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLH.setText(R.string.pb_cancel_top);
            this.iLH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLH.setText(R.string.f1282top);
        this.iLH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ab(boolean z, boolean z2) {
        this.iLK.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLK.setText(R.string.pb_cancel_good);
            this.iLK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLK.setText(R.string.commit_good);
        this.iLK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qa(boolean z) {
        this.iLF.setVisibility(z ? 0 : 8);
    }

    public void qb(boolean z) {
        this.iLE.setVisibility(z ? 0 : 8);
    }

    public void qc(boolean z) {
        this.iLG.setVisibility(z ? 0 : 8);
    }

    public void ac(boolean z, boolean z2) {
        this.iLI.setVisibility(z ? 0 : 8);
        this.iLQ = z2;
        if (z2) {
            this.iLI.setText(R.string.view_reverse);
        } else {
            this.iLI.setText(R.string.default_sort);
        }
        this.iLI.setText(R.string.sort_selector);
    }

    public void ad(boolean z, boolean z2) {
        this.iLJ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLJ.setText(R.string.normal_mode);
            this.iLJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLJ.setText(R.string.eyeshield_mode);
        this.iLJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qd(boolean z) {
        this.iLD.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eDw.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.iLC = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.iLM = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.iLM.setOnClickListener(this.mClickListener);
        this.iLI = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.iLI.setOnClickListener(this.mClickListener);
        this.iLD = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.iLD.setOnClickListener(this.mClickListener);
        this.iLJ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.iLJ.setOnClickListener(this.mClickListener);
        this.iLE = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.iLE.setOnClickListener(this.mClickListener);
        this.iLL = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.iLL.setOnClickListener(this.mClickListener);
        this.iLF = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.iLF.setOnClickListener(this.mClickListener);
        this.iLG = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.iLG.setOnClickListener(this.mClickListener);
        this.iLH = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.iLH.setOnClickListener(this.mClickListener);
        this.iLK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.iLK.setOnClickListener(this.mClickListener);
        this.iLO = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.iLN = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cyy = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cyy.setOnClickListener(this.mClickListener);
    }

    public void coN() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLC, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.iLN, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cyy, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cyy, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLD, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLL, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLM, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLE, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLF, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLH, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLG, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLI, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLJ, R.color.cp_cont_f, 1);
        this.iLC.setHorizontalSpacing(((((WindowManager) this.eDw.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.iLD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(this.iLP ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.iLO != null) {
            this.iLO.onChangeSkinType();
        }
    }
}
