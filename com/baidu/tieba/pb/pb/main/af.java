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
    private BaseFragment fwy;
    private FlowLayout jPZ;
    private TextView jQa;
    private TextView jQb;
    private TextView jQc;
    private TextView jQd;
    private TextView jQe;
    private TextView jQf;
    private TextView jQg;
    private TextView jQh;
    private TextView jQi;
    private TextView jQj;
    private LinearLayout jQk;
    private TextSizeSeekBar jQl;
    public boolean jQm;
    public boolean jQn;
    private View.OnClickListener mClickListener;
    private View mView;

    public af(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.jQi = null;
        this.mClickListener = null;
        this.fwy = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cGQ() {
        return this.jQa;
    }

    public TextView cGR() {
        return this.jQi;
    }

    public TextView cGS() {
        return this.diR;
    }

    public TextView cGT() {
        return this.jQj;
    }

    public TextView cGU() {
        return this.jQe;
    }

    public TextView cGV() {
        return this.jQc;
    }

    public TextView cGW() {
        return this.jQh;
    }

    public TextView cGX() {
        return this.jQb;
    }

    public TextView cGY() {
        return this.jQd;
    }

    public TextView cGZ() {
        return this.jQf;
    }

    public TextView cHa() {
        return this.jQg;
    }

    public void release() {
    }

    public void rI(boolean z) {
        this.jQi.setVisibility(z ? 0 : 8);
    }

    public void ad(boolean z, boolean z2) {
        this.jQj.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jQj.setText(R.string.group_info_intro_more);
            this.jQj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jQj.setText(R.string.view_host);
        this.jQj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ae(boolean z, boolean z2) {
        this.jQe.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jQe.setText(R.string.pb_cancel_top);
            this.jQe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jQe.setText(R.string.f1281top);
        this.jQe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void af(boolean z, boolean z2) {
        this.jQh.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jQh.setText(R.string.pb_cancel_good);
            this.jQh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jQh.setText(R.string.commit_good);
        this.jQh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rJ(boolean z) {
        this.jQc.setVisibility(z ? 0 : 8);
    }

    public void rK(boolean z) {
        this.jQb.setVisibility(z ? 0 : 8);
    }

    public void rL(boolean z) {
        this.jQd.setVisibility(z ? 0 : 8);
    }

    public void ag(boolean z, boolean z2) {
        this.jQf.setVisibility(z ? 0 : 8);
        this.jQn = z2;
        if (z2) {
            this.jQf.setText(R.string.view_reverse);
        } else {
            this.jQf.setText(R.string.default_sort);
        }
        this.jQf.setText(R.string.sort_selector);
    }

    public void ah(boolean z, boolean z2) {
        this.jQg.setVisibility(z ? 0 : 8);
        if (z2) {
            this.jQg.setText(R.string.normal_mode);
            this.jQg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.jQg.setText(R.string.eyeshield_mode);
        this.jQg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rM(boolean z) {
        this.jQa.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fwy.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.jPZ = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.jQj = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.jQj.setOnClickListener(this.mClickListener);
        this.jQf = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.jQf.setOnClickListener(this.mClickListener);
        this.jQa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.jQa.setOnClickListener(this.mClickListener);
        this.jQg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.jQg.setOnClickListener(this.mClickListener);
        this.jQb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.jQb.setOnClickListener(this.mClickListener);
        this.jQi = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.jQi.setOnClickListener(this.mClickListener);
        this.jQc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.jQc.setOnClickListener(this.mClickListener);
        this.jQd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.jQd.setOnClickListener(this.mClickListener);
        this.jQe = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.jQe.setOnClickListener(this.mClickListener);
        this.jQh = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.jQh.setOnClickListener(this.mClickListener);
        this.jQl = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.jQk = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.diR = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.diR.setOnClickListener(this.mClickListener);
    }

    public void cHb() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.jPZ, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.jQk, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.diR, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.diR, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQa, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQi, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQj, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQe, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQh, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQf, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jQg, R.color.cp_cont_f, 1);
        this.jPZ.setHorizontalSpacing(((((WindowManager) this.fwy.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.jQa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jQi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jQb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jQc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(this.jQm ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jQd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.jQf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.jQl != null) {
            this.jQl.onChangeSkinType();
        }
    }
}
