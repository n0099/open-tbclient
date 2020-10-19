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
/* loaded from: classes22.dex */
public class aj extends com.baidu.adp.base.c {
    private TextView dRC;
    private BaseFragment goK;
    private TextSizeSeekBar lgA;
    public boolean lgB;
    public boolean lgC;
    private FlowLayout lgn;
    private TextView lgo;
    private TextView lgp;
    private TextView lgq;
    private TextView lgr;
    private TextView lgs;
    private TextView lgt;
    private TextView lgu;
    private TextView lgv;
    private TextView lgw;
    private TextView lgx;
    private TextView lgy;
    private LinearLayout lgz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lgx = null;
        this.mClickListener = null;
        this.goK = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dgW() {
        return this.lgo;
    }

    public TextView dgX() {
        return this.lgx;
    }

    public TextView dgY() {
        return this.dRC;
    }

    public TextView dgZ() {
        return this.lgy;
    }

    public TextView dha() {
        return this.lgt;
    }

    public TextView dhb() {
        return this.lgr;
    }

    public TextView dhc() {
        return this.lgw;
    }

    public TextView dhd() {
        return this.lgp;
    }

    public TextView dhe() {
        return this.lgq;
    }

    public TextView dhf() {
        return this.lgs;
    }

    public TextView dhg() {
        return this.lgu;
    }

    public TextView dhh() {
        return this.lgv;
    }

    public void release() {
    }

    public void tZ(boolean z) {
        this.lgx.setVisibility(z ? 0 : 8);
    }

    public void ak(boolean z, boolean z2) {
        this.lgy.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lgy.setText(R.string.group_info_intro_more);
            this.lgy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lgy.setText(R.string.view_host);
        this.lgy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void al(boolean z, boolean z2) {
        this.lgt.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lgt.setText(R.string.pb_cancel_top);
            this.lgt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lgt.setText(R.string.top);
        this.lgt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void am(boolean z, boolean z2) {
        this.lgw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lgw.setText(R.string.pb_cancel_good);
            this.lgw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lgw.setText(R.string.commit_good);
        this.lgw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ua(boolean z) {
        this.lgr.setVisibility(z ? 0 : 8);
    }

    public void ub(boolean z) {
        this.lgp.setVisibility(z ? 0 : 8);
    }

    public void uc(boolean z) {
        this.lgq.setVisibility(z ? 0 : 8);
    }

    public void ud(boolean z) {
        this.lgs.setVisibility(z ? 0 : 8);
    }

    public void an(boolean z, boolean z2) {
        this.lgu.setVisibility(z ? 0 : 8);
        this.lgC = z2;
        if (z2) {
            this.lgu.setText(R.string.view_reverse);
        } else {
            this.lgu.setText(R.string.default_sort);
        }
        this.lgu.setText(R.string.sort_selector);
    }

    public void ao(boolean z, boolean z2) {
        this.lgv.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lgv.setText(R.string.normal_mode);
            this.lgv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lgv.setText(R.string.eyeshield_mode);
        this.lgv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ue(boolean z) {
        this.lgo.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.goK.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lgn = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lgy = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lgy.setOnClickListener(this.mClickListener);
        this.lgu = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lgu.setOnClickListener(this.mClickListener);
        this.lgo = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lgo.setOnClickListener(this.mClickListener);
        this.lgv = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lgv.setOnClickListener(this.mClickListener);
        this.lgp = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lgp.setOnClickListener(this.mClickListener);
        this.lgq = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lgq.setOnClickListener(this.mClickListener);
        this.lgx = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lgx.setOnClickListener(this.mClickListener);
        this.lgr = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lgr.setOnClickListener(this.mClickListener);
        this.lgs = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lgs.setOnClickListener(this.mClickListener);
        this.lgt = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lgt.setOnClickListener(this.mClickListener);
        this.lgw = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lgw.setOnClickListener(this.mClickListener);
        this.lgA = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lgz = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dRC = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dRC.setOnClickListener(this.mClickListener);
    }

    public void dhi() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lgn, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lgz, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.dRC, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.dRC, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgo, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgx, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgy, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgp, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgq, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgr, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgt, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgw, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgs, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgu, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lgv, R.color.cp_cont_f, 1);
        this.lgn.setHorizontalSpacing(((((WindowManager) this.goK.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.lgo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lgx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lgp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lgq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lgq.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.lgr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(this.lgB ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lgs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lgu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.lgA != null) {
            this.lgA.onChangeSkinType();
        }
    }
}
