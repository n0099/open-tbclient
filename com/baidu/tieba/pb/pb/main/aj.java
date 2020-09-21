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
/* loaded from: classes21.dex */
public class aj extends com.baidu.adp.base.c {
    private TextView dFB;
    private BaseFragment gct;
    private FlowLayout kRa;
    private TextView kRb;
    private TextView kRc;
    private TextView kRd;
    private TextView kRe;
    private TextView kRf;
    private TextView kRg;
    private TextView kRh;
    private TextView kRi;
    private TextView kRj;
    private TextView kRk;
    private TextView kRl;
    private LinearLayout kRm;
    private TextSizeSeekBar kRn;
    public boolean kRo;
    public boolean kRp;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.kRk = null;
        this.mClickListener = null;
        this.gct = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView ddn() {
        return this.kRb;
    }

    public TextView ddo() {
        return this.kRk;
    }

    public TextView ddp() {
        return this.dFB;
    }

    public TextView ddq() {
        return this.kRl;
    }

    public TextView ddr() {
        return this.kRg;
    }

    public TextView dds() {
        return this.kRe;
    }

    public TextView ddt() {
        return this.kRj;
    }

    public TextView ddu() {
        return this.kRc;
    }

    public TextView ddv() {
        return this.kRd;
    }

    public TextView ddw() {
        return this.kRf;
    }

    public TextView ddx() {
        return this.kRh;
    }

    public TextView ddy() {
        return this.kRi;
    }

    public void release() {
    }

    public void ts(boolean z) {
        this.kRk.setVisibility(z ? 0 : 8);
    }

    public void al(boolean z, boolean z2) {
        this.kRl.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kRl.setText(R.string.group_info_intro_more);
            this.kRl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kRl.setText(R.string.view_host);
        this.kRl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void am(boolean z, boolean z2) {
        this.kRg.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kRg.setText(R.string.pb_cancel_top);
            this.kRg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kRg.setText(R.string.top);
        this.kRg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void an(boolean z, boolean z2) {
        this.kRj.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kRj.setText(R.string.pb_cancel_good);
            this.kRj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kRj.setText(R.string.commit_good);
        this.kRj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void tt(boolean z) {
        this.kRe.setVisibility(z ? 0 : 8);
    }

    public void tu(boolean z) {
        this.kRc.setVisibility(z ? 0 : 8);
    }

    public void tv(boolean z) {
        this.kRd.setVisibility(z ? 0 : 8);
    }

    public void tw(boolean z) {
        this.kRf.setVisibility(z ? 0 : 8);
    }

    public void ao(boolean z, boolean z2) {
        this.kRh.setVisibility(z ? 0 : 8);
        this.kRp = z2;
        if (z2) {
            this.kRh.setText(R.string.view_reverse);
        } else {
            this.kRh.setText(R.string.default_sort);
        }
        this.kRh.setText(R.string.sort_selector);
    }

    public void ap(boolean z, boolean z2) {
        this.kRi.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kRi.setText(R.string.normal_mode);
            this.kRi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kRi.setText(R.string.eyeshield_mode);
        this.kRi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void tx(boolean z) {
        this.kRb.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gct.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.kRa = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.kRl = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.kRl.setOnClickListener(this.mClickListener);
        this.kRh = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.kRh.setOnClickListener(this.mClickListener);
        this.kRb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.kRb.setOnClickListener(this.mClickListener);
        this.kRi = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.kRi.setOnClickListener(this.mClickListener);
        this.kRc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.kRc.setOnClickListener(this.mClickListener);
        this.kRd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.kRd.setOnClickListener(this.mClickListener);
        this.kRk = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.kRk.setOnClickListener(this.mClickListener);
        this.kRe = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.kRe.setOnClickListener(this.mClickListener);
        this.kRf = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.kRf.setOnClickListener(this.mClickListener);
        this.kRg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.kRg.setOnClickListener(this.mClickListener);
        this.kRj = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.kRj.setOnClickListener(this.mClickListener);
        this.kRn = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.kRm = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dFB = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dFB.setOnClickListener(this.mClickListener);
    }

    public void ddz() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kRa, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kRm, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.dFB, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.dFB, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRk, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRl, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRe, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRg, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRj, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRf, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRh, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRi, R.color.cp_cont_f, 1);
        this.kRa.setHorizontalSpacing(((((WindowManager) this.gct.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.kRb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kRk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kRc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kRd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kRd.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.kRe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(this.kRo ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kRh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.kRn != null) {
            this.kRn.onChangeSkinType();
        }
    }
}
