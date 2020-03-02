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
    private TextView cyz;
    private BaseFragment eDx;
    private FlowLayout iLE;
    private TextView iLF;
    private TextView iLG;
    private TextView iLH;
    private TextView iLI;
    private TextView iLJ;
    private TextView iLK;
    private TextView iLL;
    private TextView iLM;
    private TextView iLN;
    private TextView iLO;
    private LinearLayout iLP;
    private TextSizeSeekBar iLQ;
    public boolean iLR;
    public boolean iLS;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.iLN = null;
        this.mClickListener = null;
        this.eDx = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView coE() {
        return this.iLF;
    }

    public TextView coF() {
        return this.iLN;
    }

    public TextView coG() {
        return this.cyz;
    }

    public TextView coH() {
        return this.iLO;
    }

    public TextView coI() {
        return this.iLJ;
    }

    public TextView coJ() {
        return this.iLH;
    }

    public TextView coK() {
        return this.iLM;
    }

    public TextView coL() {
        return this.iLG;
    }

    public TextView coM() {
        return this.iLI;
    }

    public TextView coN() {
        return this.iLK;
    }

    public TextView coO() {
        return this.iLL;
    }

    public void release() {
    }

    public void pZ(boolean z) {
        this.iLN.setVisibility(z ? 0 : 8);
    }

    public void Z(boolean z, boolean z2) {
        this.iLO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLO.setText(R.string.group_info_intro_more);
            this.iLO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLO.setText(R.string.view_host);
        this.iLO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void aa(boolean z, boolean z2) {
        this.iLJ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLJ.setText(R.string.pb_cancel_top);
            this.iLJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLJ.setText(R.string.f1281top);
        this.iLJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ab(boolean z, boolean z2) {
        this.iLM.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLM.setText(R.string.pb_cancel_good);
            this.iLM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLM.setText(R.string.commit_good);
        this.iLM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qa(boolean z) {
        this.iLH.setVisibility(z ? 0 : 8);
    }

    public void qb(boolean z) {
        this.iLG.setVisibility(z ? 0 : 8);
    }

    public void qc(boolean z) {
        this.iLI.setVisibility(z ? 0 : 8);
    }

    public void ac(boolean z, boolean z2) {
        this.iLK.setVisibility(z ? 0 : 8);
        this.iLS = z2;
        if (z2) {
            this.iLK.setText(R.string.view_reverse);
        } else {
            this.iLK.setText(R.string.default_sort);
        }
        this.iLK.setText(R.string.sort_selector);
    }

    public void ad(boolean z, boolean z2) {
        this.iLL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLL.setText(R.string.normal_mode);
            this.iLL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLL.setText(R.string.eyeshield_mode);
        this.iLL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qd(boolean z) {
        this.iLF.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eDx.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.iLE = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.iLO = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.iLO.setOnClickListener(this.mClickListener);
        this.iLK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.iLK.setOnClickListener(this.mClickListener);
        this.iLF = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.iLF.setOnClickListener(this.mClickListener);
        this.iLL = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.iLL.setOnClickListener(this.mClickListener);
        this.iLG = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.iLG.setOnClickListener(this.mClickListener);
        this.iLN = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.iLN.setOnClickListener(this.mClickListener);
        this.iLH = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.iLH.setOnClickListener(this.mClickListener);
        this.iLI = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.iLI.setOnClickListener(this.mClickListener);
        this.iLJ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.iLJ.setOnClickListener(this.mClickListener);
        this.iLM = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.iLM.setOnClickListener(this.mClickListener);
        this.iLQ = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.iLP = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cyz = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cyz.setOnClickListener(this.mClickListener);
    }

    public void coP() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLE, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.iLP, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cyz, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cyz, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLF, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLN, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLO, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLG, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLH, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLJ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLM, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLI, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLL, R.color.cp_cont_f, 1);
        this.iLE.setHorizontalSpacing(((((WindowManager) this.eDx.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.iLF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(this.iLR ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.iLQ != null) {
            this.iLQ.onChangeSkinType();
        }
    }
}
