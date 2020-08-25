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
    private TextView dDw;
    private BaseFragment fZb;
    private TextView kIA;
    private TextView kIB;
    private TextView kIC;
    private TextView kID;
    private TextView kIE;
    private LinearLayout kIF;
    private TextSizeSeekBar kIG;
    public boolean kIH;
    public boolean kII;
    private FlowLayout kIt;
    private TextView kIu;
    private TextView kIv;
    private TextView kIw;
    private TextView kIx;
    private TextView kIy;
    private TextView kIz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.kID = null;
        this.mClickListener = null;
        this.fZb = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cZJ() {
        return this.kIu;
    }

    public TextView cZK() {
        return this.kID;
    }

    public TextView cZL() {
        return this.dDw;
    }

    public TextView cZM() {
        return this.kIE;
    }

    public TextView cZN() {
        return this.kIz;
    }

    public TextView cZO() {
        return this.kIx;
    }

    public TextView cZP() {
        return this.kIC;
    }

    public TextView cZQ() {
        return this.kIv;
    }

    public TextView cZR() {
        return this.kIw;
    }

    public TextView cZS() {
        return this.kIy;
    }

    public TextView cZT() {
        return this.kIA;
    }

    public TextView cZU() {
        return this.kIB;
    }

    public void release() {
    }

    public void tj(boolean z) {
        this.kID.setVisibility(z ? 0 : 8);
    }

    public void aj(boolean z, boolean z2) {
        this.kIE.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIE.setText(R.string.group_info_intro_more);
            this.kIE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIE.setText(R.string.view_host);
        this.kIE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ak(boolean z, boolean z2) {
        this.kIz.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIz.setText(R.string.pb_cancel_top);
            this.kIz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIz.setText(R.string.top);
        this.kIz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void al(boolean z, boolean z2) {
        this.kIC.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIC.setText(R.string.pb_cancel_good);
            this.kIC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIC.setText(R.string.commit_good);
        this.kIC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void tk(boolean z) {
        this.kIx.setVisibility(z ? 0 : 8);
    }

    public void tl(boolean z) {
        this.kIv.setVisibility(z ? 0 : 8);
    }

    public void tm(boolean z) {
        this.kIw.setVisibility(z ? 0 : 8);
    }

    public void tn(boolean z) {
        this.kIy.setVisibility(z ? 0 : 8);
    }

    public void am(boolean z, boolean z2) {
        this.kIA.setVisibility(z ? 0 : 8);
        this.kII = z2;
        if (z2) {
            this.kIA.setText(R.string.view_reverse);
        } else {
            this.kIA.setText(R.string.default_sort);
        }
        this.kIA.setText(R.string.sort_selector);
    }

    public void an(boolean z, boolean z2) {
        this.kIB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIB.setText(R.string.normal_mode);
            this.kIB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIB.setText(R.string.eyeshield_mode);
        this.kIB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void to(boolean z) {
        this.kIu.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fZb.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.kIt = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.kIE = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.kIE.setOnClickListener(this.mClickListener);
        this.kIA = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.kIA.setOnClickListener(this.mClickListener);
        this.kIu = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.kIu.setOnClickListener(this.mClickListener);
        this.kIB = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.kIB.setOnClickListener(this.mClickListener);
        this.kIv = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.kIv.setOnClickListener(this.mClickListener);
        this.kIw = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.kIw.setOnClickListener(this.mClickListener);
        this.kID = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.kID.setOnClickListener(this.mClickListener);
        this.kIx = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.kIx.setOnClickListener(this.mClickListener);
        this.kIy = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.kIy.setOnClickListener(this.mClickListener);
        this.kIz = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.kIz.setOnClickListener(this.mClickListener);
        this.kIC = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.kIC.setOnClickListener(this.mClickListener);
        this.kIG = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.kIF = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dDw = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dDw.setOnClickListener(this.mClickListener);
    }

    public void cZV() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kIt, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kIF, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.dDw, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.dDw, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIu, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kID, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIE, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIv, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIw, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIx, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIz, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIC, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIy, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIA, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIB, R.color.cp_cont_f, 1);
        this.kIt.setHorizontalSpacing(((((WindowManager) this.fZb.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.kIu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kID.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIw.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.kIx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(this.kIH ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.kIG != null) {
            this.kIG.onChangeSkinType();
        }
    }
}
