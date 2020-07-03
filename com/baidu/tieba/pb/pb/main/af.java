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
/* loaded from: classes9.dex */
public class af extends com.baidu.adp.base.c {
    private TextView dnB;
    private BaseFragment fHI;
    private FlowLayout kjN;
    private TextView kjO;
    private TextView kjP;
    private TextView kjQ;
    private TextView kjR;
    private TextView kjS;
    private TextView kjT;
    private TextView kjU;
    private TextView kjV;
    private TextView kjW;
    private TextView kjX;
    private TextView kjY;
    private LinearLayout kjZ;
    private TextSizeSeekBar kka;
    public boolean kkb;
    public boolean kkc;
    private View.OnClickListener mClickListener;
    private View mView;

    public af(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.kjX = null;
        this.mClickListener = null;
        this.fHI = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView cLg() {
        return this.kjO;
    }

    public TextView cLh() {
        return this.kjX;
    }

    public TextView cLi() {
        return this.dnB;
    }

    public TextView cLj() {
        return this.kjY;
    }

    public TextView cLk() {
        return this.kjT;
    }

    public TextView cLl() {
        return this.kjR;
    }

    public TextView cLm() {
        return this.kjW;
    }

    public TextView cLn() {
        return this.kjP;
    }

    public TextView cLo() {
        return this.kjQ;
    }

    public TextView cLp() {
        return this.kjS;
    }

    public TextView cLq() {
        return this.kjU;
    }

    public TextView cLr() {
        return this.kjV;
    }

    public void release() {
    }

    public void rV(boolean z) {
        this.kjX.setVisibility(z ? 0 : 8);
    }

    public void ae(boolean z, boolean z2) {
        this.kjY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kjY.setText(R.string.group_info_intro_more);
            this.kjY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_all30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kjY.setText(R.string.view_host);
        this.kjY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_host30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void af(boolean z, boolean z2) {
        this.kjT.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kjT.setText(R.string.pb_cancel_top);
            this.kjT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_toped30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kjT.setText(R.string.f1302top);
        this.kjT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_top30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void ag(boolean z, boolean z2) {
        this.kjW.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kjW.setText(R.string.pb_cancel_good);
            this.kjW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_bested30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kjW.setText(R.string.commit_good);
        this.kjW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_best30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void rW(boolean z) {
        this.kjR.setVisibility(z ? 0 : 8);
    }

    public void rX(boolean z) {
        this.kjP.setVisibility(z ? 0 : 8);
    }

    public void rY(boolean z) {
        this.kjQ.setVisibility(z ? 0 : 8);
    }

    public void rZ(boolean z) {
        this.kjS.setVisibility(z ? 0 : 8);
    }

    public void ah(boolean z, boolean z2) {
        this.kjU.setVisibility(z ? 0 : 8);
        this.kkc = z2;
        if (z2) {
            this.kjU.setText(R.string.view_reverse);
        } else {
            this.kjU.setText(R.string.default_sort);
        }
        this.kjU.setText(R.string.sort_selector);
    }

    public void ai(boolean z, boolean z2) {
        this.kjV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.kjV.setText(R.string.normal_mode);
            this.kjV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_daytime30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
            return;
        }
        this.kjV.setText(R.string.eyeshield_mode);
        this.kjV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
    }

    public void sa(boolean z) {
        this.kjO.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fHI.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.kjN = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.kjY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.kjY.setOnClickListener(this.mClickListener);
        this.kjU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.kjU.setOnClickListener(this.mClickListener);
        this.kjO = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.kjO.setOnClickListener(this.mClickListener);
        this.kjV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.kjV.setOnClickListener(this.mClickListener);
        this.kjP = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.kjP.setOnClickListener(this.mClickListener);
        this.kjQ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.kjQ.setOnClickListener(this.mClickListener);
        this.kjX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.kjX.setOnClickListener(this.mClickListener);
        this.kjR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.kjR.setOnClickListener(this.mClickListener);
        this.kjS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.kjS.setOnClickListener(this.mClickListener);
        this.kjT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.kjT.setOnClickListener(this.mClickListener);
        this.kjW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.kjW.setOnClickListener(this.mClickListener);
        this.kka = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.kjZ = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.dnB = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.dnB.setOnClickListener(this.mClickListener);
    }

    public void cLs() {
        com.baidu.tbadk.core.util.an.setBackgroundColor(this.kjN, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.an.setBackgroundResource(this.kjZ, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.an.setBackgroundResource(this.dnB, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.dnB, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjO, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjP, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjQ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.kjV, R.color.cp_cont_f, 1);
        this.kjN.setHorizontalSpacing(((((WindowManager) this.fHI.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - UtilHelper.getDimenPixelSize(R.dimen.ds64)) - (UtilHelper.getDimenPixelSize(R.dimen.ds100) * 5)) / 4);
        this.kjO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_jump30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kjX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_report30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kjP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_initial30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kjQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.ic_icon_pure_pb_recommend_fans30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kjQ.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        this.kjR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(this.kkb ? R.drawable.icon_pure_pb_recommend_report30_svg : R.drawable.icon_pure_pb_recommend_delete30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kjS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_block30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.kjU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_pb_recommend_sort30_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.kka != null) {
            this.kka.onChangeSkinType();
        }
    }
}
