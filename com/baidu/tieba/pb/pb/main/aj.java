package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes16.dex */
public class aj extends com.baidu.adp.base.c {
    private TextView dtx;
    private BaseFragment fNd;
    private FlowLayout ksO;
    private TextView ksP;
    private TextView ksQ;
    private TextView ksR;
    private TextView ksS;
    private TextView ksT;
    private TextView ksU;
    private TextView ksV;
    private TextView ksW;
    private TextView ksX;
    private TextView ksY;
    private TextView ksZ;
    private LinearLayout kta;
    private TextSizeSeekBar ktb;
    public boolean ktc;
    public boolean ktd;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.ksY = null;
        this.mClickListener = null;
        this.fNd = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cOT() {
        return this.ksP;
    }

    public TextView cOU() {
        return this.ksY;
    }

    public TextView cOV() {
        return this.dtx;
    }

    public TextView cOW() {
        return this.ksZ;
    }

    public TextView cOX() {
        return this.ksU;
    }

    public TextView cOY() {
        return this.ksS;
    }

    public TextView cOZ() {
        return this.ksX;
    }

    public TextView cPa() {
        return this.ksQ;
    }

    public TextView cPb() {
        return this.ksR;
    }

    public TextView cPc() {
        return this.ksT;
    }

    public TextView cPd() {
        return this.ksV;
    }

    public TextView cPe() {
        return this.ksW;
    }

    public void release() {
    }

    public void sA(boolean z) {
        this.ksY.setVisibility(z ? 0 : 8);
    }

    public void af(boolean z, boolean z2) {
        this.ksZ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksZ.setText(R.string.group_info_intro_more);
            this.ksZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksZ.setText(R.string.view_host);
        this.ksZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ag(boolean z, boolean z2) {
        this.ksU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksU.setText(R.string.pb_cancel_top);
            this.ksU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksU.setText(R.string.top);
        this.ksU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ah(boolean z, boolean z2) {
        this.ksX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksX.setText(R.string.pb_cancel_good);
            this.ksX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksX.setText(R.string.commit_good);
        this.ksX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void sB(boolean z) {
        this.ksS.setVisibility(z ? 0 : 8);
    }

    public void sC(boolean z) {
        this.ksQ.setVisibility(z ? 0 : 8);
    }

    public void sD(boolean z) {
        this.ksR.setVisibility(z ? 0 : 8);
    }

    public void sE(boolean z) {
        this.ksT.setVisibility(z ? 0 : 8);
    }

    public void ai(boolean z, boolean z2) {
        this.ksV.setVisibility(z ? 0 : 8);
        this.ktd = z2;
        if (z2) {
            this.ksV.setText(R.string.view_reverse);
        } else {
            this.ksV.setText(R.string.default_sort);
        }
        this.ksV.setText(R.string.sort_selector);
    }

    public void aj(boolean z, boolean z2) {
        this.ksW.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksW.setText(R.string.normal_mode);
            this.ksW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksW.setText(R.string.eyeshield_mode);
        this.ksW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void sF(boolean z) {
        this.ksP.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fNd.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.ksO = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.ksZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.ksZ.setOnClickListener(this.mClickListener);
        this.ksV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.ksV.setOnClickListener(this.mClickListener);
        this.ksP = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.ksP.setOnClickListener(this.mClickListener);
        this.ksW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.ksW.setOnClickListener(this.mClickListener);
        this.ksQ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.ksQ.setOnClickListener(this.mClickListener);
        this.ksR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.ksR.setOnClickListener(this.mClickListener);
        this.ksY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.ksY.setOnClickListener(this.mClickListener);
        this.ksS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.ksS.setOnClickListener(this.mClickListener);
        this.ksT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.ksT.setOnClickListener(this.mClickListener);
        this.ksU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.ksU.setOnClickListener(this.mClickListener);
        this.ksX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.ksX.setOnClickListener(this.mClickListener);
        this.ktb = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.kta = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dtx = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dtx.setOnClickListener(this.mClickListener);
    }

    public void cPf() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ksO, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kta, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.dtx, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.dtx, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksP, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksZ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksQ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksW, R.color.cp_cont_f, 1);
        this.ksO.setHorizontalSpacing(((((WindowManager) this.fNd.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.ksP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksR.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.ksS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(this.ktc ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.ktb != null) {
            this.ktb.onChangeSkinType();
        }
    }
}
