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
    private FlowLayout ksM;
    private TextView ksN;
    private TextView ksO;
    private TextView ksP;
    private TextView ksQ;
    private TextView ksR;
    private TextView ksS;
    private TextView ksT;
    private TextView ksU;
    private TextView ksV;
    private TextView ksW;
    private TextView ksX;
    private LinearLayout ksY;
    private TextSizeSeekBar ksZ;
    public boolean kta;
    public boolean ktb;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.ksW = null;
        this.mClickListener = null;
        this.fNd = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cOT() {
        return this.ksN;
    }

    public TextView cOU() {
        return this.ksW;
    }

    public TextView cOV() {
        return this.dtx;
    }

    public TextView cOW() {
        return this.ksX;
    }

    public TextView cOX() {
        return this.ksS;
    }

    public TextView cOY() {
        return this.ksQ;
    }

    public TextView cOZ() {
        return this.ksV;
    }

    public TextView cPa() {
        return this.ksO;
    }

    public TextView cPb() {
        return this.ksP;
    }

    public TextView cPc() {
        return this.ksR;
    }

    public TextView cPd() {
        return this.ksT;
    }

    public TextView cPe() {
        return this.ksU;
    }

    public void release() {
    }

    public void sA(boolean z) {
        this.ksW.setVisibility(z ? 0 : 8);
    }

    public void af(boolean z, boolean z2) {
        this.ksX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksX.setText(R.string.group_info_intro_more);
            this.ksX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksX.setText(R.string.view_host);
        this.ksX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ag(boolean z, boolean z2) {
        this.ksS.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksS.setText(R.string.pb_cancel_top);
            this.ksS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksS.setText(R.string.top);
        this.ksS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ah(boolean z, boolean z2) {
        this.ksV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksV.setText(R.string.pb_cancel_good);
            this.ksV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksV.setText(R.string.commit_good);
        this.ksV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void sB(boolean z) {
        this.ksQ.setVisibility(z ? 0 : 8);
    }

    public void sC(boolean z) {
        this.ksO.setVisibility(z ? 0 : 8);
    }

    public void sD(boolean z) {
        this.ksP.setVisibility(z ? 0 : 8);
    }

    public void sE(boolean z) {
        this.ksR.setVisibility(z ? 0 : 8);
    }

    public void ai(boolean z, boolean z2) {
        this.ksT.setVisibility(z ? 0 : 8);
        this.ktb = z2;
        if (z2) {
            this.ksT.setText(R.string.view_reverse);
        } else {
            this.ksT.setText(R.string.default_sort);
        }
        this.ksT.setText(R.string.sort_selector);
    }

    public void aj(boolean z, boolean z2) {
        this.ksU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ksU.setText(R.string.normal_mode);
            this.ksU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.ksU.setText(R.string.eyeshield_mode);
        this.ksU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void sF(boolean z) {
        this.ksN.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fNd.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.ksM = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.ksX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.ksX.setOnClickListener(this.mClickListener);
        this.ksT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.ksT.setOnClickListener(this.mClickListener);
        this.ksN = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.ksN.setOnClickListener(this.mClickListener);
        this.ksU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.ksU.setOnClickListener(this.mClickListener);
        this.ksO = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.ksO.setOnClickListener(this.mClickListener);
        this.ksP = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.ksP.setOnClickListener(this.mClickListener);
        this.ksW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.ksW.setOnClickListener(this.mClickListener);
        this.ksQ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.ksQ.setOnClickListener(this.mClickListener);
        this.ksR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.ksR.setOnClickListener(this.mClickListener);
        this.ksS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.ksS.setOnClickListener(this.mClickListener);
        this.ksV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.ksV.setOnClickListener(this.mClickListener);
        this.ksZ = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.ksY = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dtx = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dtx.setOnClickListener(this.mClickListener);
    }

    public void cPf() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ksM, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ksY, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.dtx, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.dtx, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksN, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksO, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksP, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksQ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.ksU, R.color.cp_cont_f, 1);
        this.ksM.setHorizontalSpacing(((((WindowManager) this.fNd.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.ksN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksP.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.ksQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(this.kta ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.ksT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.ksZ != null) {
            this.ksZ.onChangeSkinType();
        }
    }
}
