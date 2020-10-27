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
    private TextView dZY;
    private BaseFragment gyP;
    private FlowLayout lsP;
    private TextView lsQ;
    private TextView lsR;
    private TextView lsS;
    private TextView lsT;
    private TextView lsU;
    private TextView lsV;
    private TextView lsW;
    private TextView lsX;
    private TextView lsY;
    private TextView lsZ;
    private TextView lta;
    private LinearLayout ltb;
    private TextSizeSeekBar ltc;
    public boolean ltd;
    public boolean lte;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lsZ = null;
        this.mClickListener = null;
        this.gyP = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dkd() {
        return this.lsQ;
    }

    public TextView dke() {
        return this.lsZ;
    }

    public TextView dkf() {
        return this.dZY;
    }

    public TextView dkg() {
        return this.lta;
    }

    public TextView dkh() {
        return this.lsV;
    }

    public TextView dki() {
        return this.lsT;
    }

    public TextView dkj() {
        return this.lsY;
    }

    public TextView dkk() {
        return this.lsR;
    }

    public TextView dkl() {
        return this.lsS;
    }

    public TextView dkm() {
        return this.lsU;
    }

    public TextView dkn() {
        return this.lsW;
    }

    public TextView dko() {
        return this.lsX;
    }

    public void release() {
    }

    public void uq(boolean z) {
        this.lsZ.setVisibility(z ? 0 : 8);
    }

    public void an(boolean z, boolean z2) {
        this.lta.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lta.setText(R.string.group_info_intro_more);
            this.lta.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lta.setText(R.string.view_host);
        this.lta.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ao(boolean z, boolean z2) {
        this.lsV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lsV.setText(R.string.pb_cancel_top);
            this.lsV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lsV.setText(R.string.top);
        this.lsV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ap(boolean z, boolean z2) {
        this.lsY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lsY.setText(R.string.pb_cancel_good);
            this.lsY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lsY.setText(R.string.commit_good);
        this.lsY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ur(boolean z) {
        this.lsT.setVisibility(z ? 0 : 8);
    }

    public void us(boolean z) {
        this.lsR.setVisibility(z ? 0 : 8);
    }

    public void ut(boolean z) {
        this.lsS.setVisibility(z ? 0 : 8);
    }

    public void uu(boolean z) {
        this.lsU.setVisibility(z ? 0 : 8);
    }

    public void aq(boolean z, boolean z2) {
        this.lsW.setVisibility(z ? 0 : 8);
        this.lte = z2;
        if (z2) {
            this.lsW.setText(R.string.view_reverse);
        } else {
            this.lsW.setText(R.string.default_sort);
        }
        this.lsW.setText(R.string.sort_selector);
    }

    public void ar(boolean z, boolean z2) {
        this.lsX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lsX.setText(R.string.normal_mode);
            this.lsX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lsX.setText(R.string.eyeshield_mode);
        this.lsX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void uv(boolean z) {
        this.lsQ.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gyP.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lsP = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lta = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lta.setOnClickListener(this.mClickListener);
        this.lsW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lsW.setOnClickListener(this.mClickListener);
        this.lsQ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lsQ.setOnClickListener(this.mClickListener);
        this.lsX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lsX.setOnClickListener(this.mClickListener);
        this.lsR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lsR.setOnClickListener(this.mClickListener);
        this.lsS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lsS.setOnClickListener(this.mClickListener);
        this.lsZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lsZ.setOnClickListener(this.mClickListener);
        this.lsT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lsT.setOnClickListener(this.mClickListener);
        this.lsU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lsU.setOnClickListener(this.mClickListener);
        this.lsV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lsV.setOnClickListener(this.mClickListener);
        this.lsY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lsY.setOnClickListener(this.mClickListener);
        this.ltc = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.ltb = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dZY = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dZY.setOnClickListener(this.mClickListener);
    }

    public void dkp() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lsP, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ltb, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.dZY, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.dZY, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsQ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsZ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lta, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lsX, R.color.cp_cont_f, 1);
        this.lsP.setHorizontalSpacing(((((WindowManager) this.gyP.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.lsQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lsZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lsR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lsS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lsS.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.lsT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(this.ltd ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lsU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lsW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.ltc != null) {
            this.ltc.onChangeSkinType();
        }
    }
}
