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
    private TextView efP;
    private BaseFragment gED;
    private FlowLayout lyN;
    private TextView lyO;
    private TextView lyP;
    private TextView lyQ;
    private TextView lyR;
    private TextView lyS;
    private TextView lyT;
    private TextView lyU;
    private TextView lyV;
    private TextView lyW;
    private TextView lyX;
    private TextView lyY;
    private LinearLayout lyZ;
    private TextSizeSeekBar lza;
    public boolean lzb;
    public boolean lzc;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lyX = null;
        this.mClickListener = null;
        this.gED = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dmF() {
        return this.lyO;
    }

    public TextView dmG() {
        return this.lyX;
    }

    public TextView dmH() {
        return this.efP;
    }

    public TextView dmI() {
        return this.lyY;
    }

    public TextView dmJ() {
        return this.lyT;
    }

    public TextView dmK() {
        return this.lyR;
    }

    public TextView dmL() {
        return this.lyW;
    }

    public TextView dmM() {
        return this.lyP;
    }

    public TextView dmN() {
        return this.lyQ;
    }

    public TextView dmO() {
        return this.lyS;
    }

    public TextView dmP() {
        return this.lyU;
    }

    public TextView dmQ() {
        return this.lyV;
    }

    public void release() {
    }

    public void uz(boolean z) {
        this.lyX.setVisibility(z ? 0 : 8);
    }

    public void an(boolean z, boolean z2) {
        this.lyY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lyY.setText(R.string.group_info_intro_more);
            this.lyY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lyY.setText(R.string.view_host);
        this.lyY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ao(boolean z, boolean z2) {
        this.lyT.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lyT.setText(R.string.pb_cancel_top);
            this.lyT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lyT.setText(R.string.top);
        this.lyT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ap(boolean z, boolean z2) {
        this.lyW.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lyW.setText(R.string.pb_cancel_good);
            this.lyW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lyW.setText(R.string.commit_good);
        this.lyW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void uA(boolean z) {
        this.lyR.setVisibility(z ? 0 : 8);
    }

    public void uB(boolean z) {
        this.lyP.setVisibility(z ? 0 : 8);
    }

    public void uC(boolean z) {
        this.lyQ.setVisibility(z ? 0 : 8);
    }

    public void uD(boolean z) {
        this.lyS.setVisibility(z ? 0 : 8);
    }

    public void aq(boolean z, boolean z2) {
        this.lyU.setVisibility(z ? 0 : 8);
        this.lzc = z2;
        if (z2) {
            this.lyU.setText(R.string.view_reverse);
        } else {
            this.lyU.setText(R.string.default_sort);
        }
        this.lyU.setText(R.string.sort_selector);
    }

    public void ar(boolean z, boolean z2) {
        this.lyV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lyV.setText(R.string.normal_mode);
            this.lyV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.lyV.setText(R.string.eyeshield_mode);
        this.lyV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void uE(boolean z) {
        this.lyO.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gED.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lyN = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lyY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lyY.setOnClickListener(this.mClickListener);
        this.lyU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lyU.setOnClickListener(this.mClickListener);
        this.lyO = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lyO.setOnClickListener(this.mClickListener);
        this.lyV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lyV.setOnClickListener(this.mClickListener);
        this.lyP = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lyP.setOnClickListener(this.mClickListener);
        this.lyQ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lyQ.setOnClickListener(this.mClickListener);
        this.lyX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lyX.setOnClickListener(this.mClickListener);
        this.lyR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lyR.setOnClickListener(this.mClickListener);
        this.lyS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lyS.setOnClickListener(this.mClickListener);
        this.lyT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lyT.setOnClickListener(this.mClickListener);
        this.lyW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lyW.setOnClickListener(this.mClickListener);
        this.lza = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lyZ = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.efP = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.efP.setOnClickListener(this.mClickListener);
    }

    public void dmR() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lyN, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lyZ, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.efP, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.efP, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyO, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyP, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyQ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lyV, R.color.cp_cont_f, 1);
        this.lyN.setHorizontalSpacing(((((WindowManager) this.gED.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.lyO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lyX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lyP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lyQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lyQ.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.lyR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(this.lzb ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lyS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.lyU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.lza != null) {
            this.lza.onChangeSkinType();
        }
    }
}
