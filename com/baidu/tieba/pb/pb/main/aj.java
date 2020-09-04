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
    private TextView dDA;
    private BaseFragment fZf;
    private FlowLayout kIA;
    private TextView kIB;
    private TextView kIC;
    private TextView kID;
    private TextView kIE;
    private TextView kIF;
    private TextView kIG;
    private TextView kIH;
    private TextView kII;
    private TextView kIJ;
    private TextView kIK;
    private TextView kIL;
    private LinearLayout kIM;
    private TextSizeSeekBar kIN;
    public boolean kIO;
    public boolean kIP;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.kIK = null;
        this.mClickListener = null;
        this.fZf = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cZK() {
        return this.kIB;
    }

    public TextView cZL() {
        return this.kIK;
    }

    public TextView cZM() {
        return this.dDA;
    }

    public TextView cZN() {
        return this.kIL;
    }

    public TextView cZO() {
        return this.kIG;
    }

    public TextView cZP() {
        return this.kIE;
    }

    public TextView cZQ() {
        return this.kIJ;
    }

    public TextView cZR() {
        return this.kIC;
    }

    public TextView cZS() {
        return this.kID;
    }

    public TextView cZT() {
        return this.kIF;
    }

    public TextView cZU() {
        return this.kIH;
    }

    public TextView cZV() {
        return this.kII;
    }

    public void release() {
    }

    public void tl(boolean z) {
        this.kIK.setVisibility(z ? 0 : 8);
    }

    public void aj(boolean z, boolean z2) {
        this.kIL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIL.setText(R.string.group_info_intro_more);
            this.kIL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIL.setText(R.string.view_host);
        this.kIL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ak(boolean z, boolean z2) {
        this.kIG.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIG.setText(R.string.pb_cancel_top);
            this.kIG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIG.setText(R.string.top);
        this.kIG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void al(boolean z, boolean z2) {
        this.kIJ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kIJ.setText(R.string.pb_cancel_good);
            this.kIJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kIJ.setText(R.string.commit_good);
        this.kIJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void tm(boolean z) {
        this.kIE.setVisibility(z ? 0 : 8);
    }

    public void tn(boolean z) {
        this.kIC.setVisibility(z ? 0 : 8);
    }

    public void to(boolean z) {
        this.kID.setVisibility(z ? 0 : 8);
    }

    public void tp(boolean z) {
        this.kIF.setVisibility(z ? 0 : 8);
    }

    public void am(boolean z, boolean z2) {
        this.kIH.setVisibility(z ? 0 : 8);
        this.kIP = z2;
        if (z2) {
            this.kIH.setText(R.string.view_reverse);
        } else {
            this.kIH.setText(R.string.default_sort);
        }
        this.kIH.setText(R.string.sort_selector);
    }

    public void an(boolean z, boolean z2) {
        this.kII.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kII.setText(R.string.normal_mode);
            this.kII.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kII.setText(R.string.eyeshield_mode);
        this.kII.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void tq(boolean z) {
        this.kIB.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fZf.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.kIA = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.kIL = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.kIL.setOnClickListener(this.mClickListener);
        this.kIH = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.kIH.setOnClickListener(this.mClickListener);
        this.kIB = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.kIB.setOnClickListener(this.mClickListener);
        this.kII = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.kII.setOnClickListener(this.mClickListener);
        this.kIC = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.kIC.setOnClickListener(this.mClickListener);
        this.kID = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.kID.setOnClickListener(this.mClickListener);
        this.kIK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.kIK.setOnClickListener(this.mClickListener);
        this.kIE = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.kIE.setOnClickListener(this.mClickListener);
        this.kIF = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.kIF.setOnClickListener(this.mClickListener);
        this.kIG = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.kIG.setOnClickListener(this.mClickListener);
        this.kIJ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.kIJ.setOnClickListener(this.mClickListener);
        this.kIN = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.kIM = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dDA = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dDA.setOnClickListener(this.mClickListener);
    }

    public void cZW() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kIA, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kIM, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.dDA, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.dDA, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIB, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIL, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIC, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kID, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIE, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIG, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIJ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIF, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIH, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kII, R.color.cp_cont_f, 1);
        this.kIA.setHorizontalSpacing(((((WindowManager) this.fZf.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.kIB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kID.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kID.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.kIE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(this.kIO ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kIH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.kIN != null) {
            this.kIN.onChangeSkinType();
        }
    }
}
