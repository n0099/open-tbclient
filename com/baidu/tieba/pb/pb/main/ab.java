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
/* loaded from: classes7.dex */
public class ab extends com.baidu.adp.base.c {
    private TextView cuA;
    private BaseFragment ezp;
    private FlowLayout iKf;
    private TextView iKg;
    private TextView iKh;
    private TextView iKi;
    private TextView iKj;
    private TextView iKk;
    private TextView iKl;
    private TextView iKm;
    private TextView iKn;
    private TextView iKo;
    private TextView iKp;
    private TextView iKq;
    private LinearLayout iKr;
    private TextSizeSeekBar iKs;
    public boolean iKt;
    public boolean iKu;
    private View.OnClickListener mClickListener;
    private View mView;

    public ab(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.iKo = null;
        this.mClickListener = null;
        this.ezp = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cnk() {
        return this.iKg;
    }

    public TextView cnl() {
        return this.iKo;
    }

    public TextView cnm() {
        return this.cuA;
    }

    public TextView cnn() {
        return this.iKq;
    }

    public TextView cno() {
        return this.iKk;
    }

    public TextView cnp() {
        return this.iKi;
    }

    public TextView cnq() {
        return this.iKn;
    }

    public TextView cnr() {
        return this.iKh;
    }

    public TextView cns() {
        return this.iKj;
    }

    public TextView cnt() {
        return this.iKl;
    }

    public TextView cnu() {
        return this.iKm;
    }

    public TextView cnv() {
        return this.iKp;
    }

    public void release() {
    }

    public void pW(boolean z) {
        this.iKo.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z, String str) {
        this.iKp.setVisibility(z ? 0 : 8);
        this.iKp.setText(str);
    }

    public void X(boolean z, boolean z2) {
        this.iKq.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iKq.setText(R.string.group_info_intro_more);
            this.iKq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iKq.setText(R.string.view_host);
        this.iKq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void Y(boolean z, boolean z2) {
        this.iKk.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iKk.setText(R.string.pb_cancel_top);
            this.iKk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iKk.setText(R.string.top);
        this.iKk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void Z(boolean z, boolean z2) {
        this.iKn.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iKn.setText(R.string.pb_cancel_good);
            this.iKn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iKn.setText(R.string.commit_good);
        this.iKn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void pX(boolean z) {
        this.iKi.setVisibility(z ? 0 : 8);
    }

    public void pY(boolean z) {
        this.iKh.setVisibility(z ? 0 : 8);
    }

    public void pZ(boolean z) {
        this.iKj.setVisibility(z ? 0 : 8);
    }

    public void aa(boolean z, boolean z2) {
        this.iKl.setVisibility(z ? 0 : 8);
        this.iKu = z2;
        if (z2) {
            this.iKl.setText(R.string.view_reverse);
        } else {
            this.iKl.setText(R.string.default_sort);
        }
        this.iKl.setText(R.string.sort_selector);
    }

    public void ab(boolean z, boolean z2) {
        this.iKm.setVisibility(z ? 0 : 8);
        if (z2) {
            this.iKm.setText(R.string.normal_mode);
            this.iKm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.iKm.setText(R.string.eyeshield_mode);
        this.iKm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void qa(boolean z) {
        this.iKg.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ezp.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.iKf = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.iKq = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.iKq.setOnClickListener(this.mClickListener);
        this.iKl = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.iKl.setOnClickListener(this.mClickListener);
        this.iKg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.iKg.setOnClickListener(this.mClickListener);
        this.iKm = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.iKm.setOnClickListener(this.mClickListener);
        this.iKp = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.iKp.setOnClickListener(this.mClickListener);
        this.iKh = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.iKh.setOnClickListener(this.mClickListener);
        this.iKo = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.iKo.setOnClickListener(this.mClickListener);
        this.iKi = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.iKi.setOnClickListener(this.mClickListener);
        this.iKj = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.iKj.setOnClickListener(this.mClickListener);
        this.iKk = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.iKk.setOnClickListener(this.mClickListener);
        this.iKn = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.iKn.setOnClickListener(this.mClickListener);
        this.iKs = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.iKr = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.cuA = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.cuA.setOnClickListener(this.mClickListener);
    }

    public void cnw() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.iKf, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.iKr, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.cuA, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.cuA, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKg, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKo, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKp, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKq, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKh, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKi, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKk, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKn, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKj, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKl, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iKm, R.color.cp_cont_f, 1);
        this.iKf.setHorizontalSpacing(((((WindowManager) this.ezp.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.iKg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iKo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iKp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.iKh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iKi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(this.iKt ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iKj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.iKl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.iKs != null) {
            this.iKs.onChangeSkinType();
        }
    }
}
