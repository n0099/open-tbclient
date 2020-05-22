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
public class af extends com.baidu.adp.base.c {
    private TextView diR;
    private BaseFragment fwn;
    private FlowLayout jOT;
    private TextView jOU;
    private TextView jOV;
    private TextView jOW;
    private TextView jOX;
    private TextView jOY;
    private TextView jOZ;
    private TextView jPa;
    private TextView jPb;
    private TextView jPc;
    private TextView jPd;
    private LinearLayout jPe;
    private TextSizeSeekBar jPf;
    public boolean jPg;
    public boolean jPh;
    private View.OnClickListener mClickListener;
    private View mView;

    public af(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.jPc = null;
        this.mClickListener = null;
        this.fwn = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cGA() {
        return this.jOU;
    }

    public TextView cGB() {
        return this.jPc;
    }

    public TextView cGC() {
        return this.diR;
    }

    public TextView cGD() {
        return this.jPd;
    }

    public TextView cGE() {
        return this.jOY;
    }

    public TextView cGF() {
        return this.jOW;
    }

    public TextView cGG() {
        return this.jPb;
    }

    public TextView cGH() {
        return this.jOV;
    }

    public TextView cGI() {
        return this.jOX;
    }

    public TextView cGJ() {
        return this.jOZ;
    }

    public TextView cGK() {
        return this.jPa;
    }

    public void release() {
    }

    public void rI(boolean z) {
        this.jPc.setVisibility(z ? 0 : 8);
    }

    public void ad(boolean z, boolean z2) {
        this.jPd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jPd.setText(R.string.group_info_intro_more);
            this.jPd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jPd.setText(R.string.view_host);
        this.jPd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ae(boolean z, boolean z2) {
        this.jOY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jOY.setText(R.string.pb_cancel_top);
            this.jOY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jOY.setText(R.string.f1281top);
        this.jOY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void af(boolean z, boolean z2) {
        this.jPb.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jPb.setText(R.string.pb_cancel_good);
            this.jPb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jPb.setText(R.string.commit_good);
        this.jPb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rJ(boolean z) {
        this.jOW.setVisibility(z ? 0 : 8);
    }

    public void rK(boolean z) {
        this.jOV.setVisibility(z ? 0 : 8);
    }

    public void rL(boolean z) {
        this.jOX.setVisibility(z ? 0 : 8);
    }

    public void ag(boolean z, boolean z2) {
        this.jOZ.setVisibility(z ? 0 : 8);
        this.jPh = z2;
        if (z2) {
            this.jOZ.setText(R.string.view_reverse);
        } else {
            this.jOZ.setText(R.string.default_sort);
        }
        this.jOZ.setText(R.string.sort_selector);
    }

    public void ah(boolean z, boolean z2) {
        this.jPa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jPa.setText(R.string.normal_mode);
            this.jPa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jPa.setText(R.string.eyeshield_mode);
        this.jPa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rM(boolean z) {
        this.jOU.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fwn.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.jOT = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.jPd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.jPd.setOnClickListener(this.mClickListener);
        this.jOZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.jOZ.setOnClickListener(this.mClickListener);
        this.jOU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.jOU.setOnClickListener(this.mClickListener);
        this.jPa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.jPa.setOnClickListener(this.mClickListener);
        this.jOV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.jOV.setOnClickListener(this.mClickListener);
        this.jPc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.jPc.setOnClickListener(this.mClickListener);
        this.jOW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.jOW.setOnClickListener(this.mClickListener);
        this.jOX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.jOX.setOnClickListener(this.mClickListener);
        this.jOY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.jOY.setOnClickListener(this.mClickListener);
        this.jPb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.jPb.setOnClickListener(this.mClickListener);
        this.jPf = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.jPe = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.diR = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.diR.setOnClickListener(this.mClickListener);
    }

    public void cGL() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.jOT, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.jPe, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.diR, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.diR, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jOU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jPc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jPd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jOV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jOW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jOY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jPb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jOX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jOZ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jPa, R.color.cp_cont_f, 1);
        this.jOT.setHorizontalSpacing(((((WindowManager) this.fwn.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.jOU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jPc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jOV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(this.jPg ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jOX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jOZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.jPf != null) {
            this.jPf.onChangeSkinType();
        }
    }
}
