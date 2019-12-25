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
/* loaded from: classes6.dex */
public class ab extends com.baidu.adp.base.c {
    private TextView cun;
    private BaseFragment eyc;
    private FlowLayout iGB;
    private TextView iGC;
    private TextView iGD;
    private TextView iGE;
    private TextView iGF;
    private TextView iGG;
    private TextView iGH;
    private TextView iGI;
    private TextView iGJ;
    private TextView iGK;
    private TextView iGL;
    private TextView iGM;
    private LinearLayout iGN;
    private TextSizeSeekBar iGO;
    public boolean iGP;
    public boolean iGQ;
    private View.OnClickListener mClickListener;
    private View mView;

    public ab(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.iGK = null;
        this.mClickListener = null;
        this.eyc = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cmd() {
        return this.iGC;
    }

    public TextView cme() {
        return this.iGK;
    }

    public TextView cmf() {
        return this.cun;
    }

    public TextView cmg() {
        return this.iGM;
    }

    public TextView cmh() {
        return this.iGG;
    }

    public TextView cmi() {
        return this.iGE;
    }

    public TextView cmj() {
        return this.iGJ;
    }

    public TextView cmk() {
        return this.iGD;
    }

    public TextView cml() {
        return this.iGF;
    }

    public TextView cmm() {
        return this.iGH;
    }

    public TextView cmn() {
        return this.iGI;
    }

    public TextView cmo() {
        return this.iGL;
    }

    public void release() {
    }

    public void pK(boolean z) {
        this.iGK.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z, String str) {
        this.iGL.setVisibility(z ? 0 : 8);
        this.iGL.setText(str);
    }

    public void X(boolean z, boolean z2) {
        this.iGM.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iGM.setText(R.string.group_info_intro_more);
            this.iGM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iGM.setText(R.string.view_host);
        this.iGM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void Y(boolean z, boolean z2) {
        this.iGG.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iGG.setText(R.string.pb_cancel_top);
            this.iGG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iGG.setText(R.string.top);
        this.iGG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void Z(boolean z, boolean z2) {
        this.iGJ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iGJ.setText(R.string.pb_cancel_good);
            this.iGJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iGJ.setText(R.string.commit_good);
        this.iGJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void pL(boolean z) {
        this.iGE.setVisibility(z ? 0 : 8);
    }

    public void pM(boolean z) {
        this.iGD.setVisibility(z ? 0 : 8);
    }

    public void pN(boolean z) {
        this.iGF.setVisibility(z ? 0 : 8);
    }

    public void aa(boolean z, boolean z2) {
        this.iGH.setVisibility(z ? 0 : 8);
        this.iGQ = z2;
        if (z2) {
            this.iGH.setText(R.string.view_reverse);
        } else {
            this.iGH.setText(R.string.default_sort);
        }
        this.iGH.setText(R.string.sort_selector);
    }

    public void ab(boolean z, boolean z2) {
        this.iGI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iGI.setText(R.string.normal_mode);
            this.iGI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iGI.setText(R.string.eyeshield_mode);
        this.iGI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void pO(boolean z) {
        this.iGC.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eyc.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.iGB = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.iGM = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.iGM.setOnClickListener(this.mClickListener);
        this.iGH = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.iGH.setOnClickListener(this.mClickListener);
        this.iGC = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.iGC.setOnClickListener(this.mClickListener);
        this.iGI = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.iGI.setOnClickListener(this.mClickListener);
        this.iGL = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.iGL.setOnClickListener(this.mClickListener);
        this.iGD = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.iGD.setOnClickListener(this.mClickListener);
        this.iGK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.iGK.setOnClickListener(this.mClickListener);
        this.iGE = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.iGE.setOnClickListener(this.mClickListener);
        this.iGF = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.iGF.setOnClickListener(this.mClickListener);
        this.iGG = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.iGG.setOnClickListener(this.mClickListener);
        this.iGJ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.iGJ.setOnClickListener(this.mClickListener);
        this.iGO = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.iGN = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cun = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cun.setOnClickListener(this.mClickListener);
    }

    public void cmp() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.iGB, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.iGN, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cun, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cun, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGC, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGL, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGM, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGD, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGE, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGG, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGJ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGF, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGH, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iGI, R.color.cp_cont_f, 1);
        this.iGB.setHorizontalSpacing(((((WindowManager) this.eyc.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.iGC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iGK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iGL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.iGD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iGE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(this.iGP ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iGF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iGH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.iGO != null) {
            this.iGO.onChangeSkinType();
        }
    }
}
