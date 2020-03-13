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
    private TextView cyA;
    private BaseFragment eDK;
    private FlowLayout iLQ;
    private TextView iLR;
    private TextView iLS;
    private TextView iLT;
    private TextView iLU;
    private TextView iLV;
    private TextView iLW;
    private TextView iLX;
    private TextView iLY;
    private TextView iLZ;
    private TextView iMa;
    private LinearLayout iMb;
    private TextSizeSeekBar iMc;
    public boolean iMd;
    public boolean iMe;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.iLZ = null;
        this.mClickListener = null;
        this.eDK = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView coF() {
        return this.iLR;
    }

    public TextView coG() {
        return this.iLZ;
    }

    public TextView coH() {
        return this.cyA;
    }

    public TextView coI() {
        return this.iMa;
    }

    public TextView coJ() {
        return this.iLV;
    }

    public TextView coK() {
        return this.iLT;
    }

    public TextView coL() {
        return this.iLY;
    }

    public TextView coM() {
        return this.iLS;
    }

    public TextView coN() {
        return this.iLU;
    }

    public TextView coO() {
        return this.iLW;
    }

    public TextView coP() {
        return this.iLX;
    }

    public void release() {
    }

    public void pZ(boolean z) {
        this.iLZ.setVisibility(z ? 0 : 8);
    }

    public void Z(boolean z, boolean z2) {
        this.iMa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iMa.setText(R.string.group_info_intro_more);
            this.iMa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iMa.setText(R.string.view_host);
        this.iMa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void aa(boolean z, boolean z2) {
        this.iLV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLV.setText(R.string.pb_cancel_top);
            this.iLV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLV.setText(R.string.f1281top);
        this.iLV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ab(boolean z, boolean z2) {
        this.iLY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLY.setText(R.string.pb_cancel_good);
            this.iLY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLY.setText(R.string.commit_good);
        this.iLY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qa(boolean z) {
        this.iLT.setVisibility(z ? 0 : 8);
    }

    public void qb(boolean z) {
        this.iLS.setVisibility(z ? 0 : 8);
    }

    public void qc(boolean z) {
        this.iLU.setVisibility(z ? 0 : 8);
    }

    public void ac(boolean z, boolean z2) {
        this.iLW.setVisibility(z ? 0 : 8);
        this.iMe = z2;
        if (z2) {
            this.iLW.setText(R.string.view_reverse);
        } else {
            this.iLW.setText(R.string.default_sort);
        }
        this.iLW.setText(R.string.sort_selector);
    }

    public void ad(boolean z, boolean z2) {
        this.iLX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iLX.setText(R.string.normal_mode);
            this.iLX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iLX.setText(R.string.eyeshield_mode);
        this.iLX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qd(boolean z) {
        this.iLR.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eDK.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.iLQ = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.iMa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.iMa.setOnClickListener(this.mClickListener);
        this.iLW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.iLW.setOnClickListener(this.mClickListener);
        this.iLR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.iLR.setOnClickListener(this.mClickListener);
        this.iLX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.iLX.setOnClickListener(this.mClickListener);
        this.iLS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.iLS.setOnClickListener(this.mClickListener);
        this.iLZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.iLZ.setOnClickListener(this.mClickListener);
        this.iLT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.iLT.setOnClickListener(this.mClickListener);
        this.iLU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.iLU.setOnClickListener(this.mClickListener);
        this.iLV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.iLV.setOnClickListener(this.mClickListener);
        this.iLY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.iLY.setOnClickListener(this.mClickListener);
        this.iMc = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.iMb = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cyA = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cyA.setOnClickListener(this.mClickListener);
    }

    public void coQ() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLQ, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMb, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cyA, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cyA, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLZ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iMa, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLX, R.color.cp_cont_f, 1);
        this.iLQ.setHorizontalSpacing(((((WindowManager) this.eDK.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.iLR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(this.iMd ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iLW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.iMc != null) {
            this.iMc.onChangeSkinType();
        }
    }
}
