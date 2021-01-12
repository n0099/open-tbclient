package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class ac extends com.baidu.adp.base.d {
    public static final int bOq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private BaseFragment gUn;
    private EMTextView jJO;
    private FlowLayout lNB;
    private EMTextView lNC;
    private EMTextView lND;
    private EMTextView lNE;
    private EMTextView lNF;
    private EMTextView lNG;
    private EMTextView lNH;
    private EMTextView lNI;
    private EMTextView lNJ;
    private EMTextView lNK;
    private EMTextView lNL;
    private EMTextView lNM;
    private LinearLayout lNN;
    private TextSizeSeekBar lNO;
    private View lNP;
    public boolean lNQ;
    public boolean lNR;
    private View.OnClickListener mClickListener;
    private View mView;

    public ac(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lNL = null;
        this.mClickListener = null;
        this.gUn = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dno() {
        return this.lNC;
    }

    public TextView dnp() {
        return this.lNL;
    }

    public TextView dnq() {
        return this.jJO;
    }

    public TextView dnr() {
        return this.lNM;
    }

    public TextView dnt() {
        return this.lNH;
    }

    public TextView dnu() {
        return this.lNF;
    }

    public TextView dnv() {
        return this.lNK;
    }

    public TextView dnw() {
        return this.lND;
    }

    public TextView dnx() {
        return this.lNE;
    }

    public TextView dny() {
        return this.lNG;
    }

    public TextView dnz() {
        return this.lNI;
    }

    public TextView dnA() {
        return this.lNJ;
    }

    public void release() {
    }

    public void vb(boolean z) {
        this.lNL.setVisibility(z ? 0 : 8);
    }

    public void ap(boolean z, boolean z2) {
        this.lNM.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lNM.setText(R.string.group_info_intro_more);
            h(this.lNM, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lNM.setText(R.string.view_host);
        h(this.lNM, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void aq(boolean z, boolean z2) {
        this.lNH.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lNH.setText(R.string.pb_cancel_top);
            h(this.lNH, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lNH.setText(R.string.top);
        h(this.lNH, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ar(boolean z, boolean z2) {
        this.lNK.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lNK.setText(R.string.pb_cancel_good);
            h(this.lNK, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lNK.setText(R.string.commit_good);
        h(this.lNK, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void vc(boolean z) {
        this.lNF.setVisibility(z ? 0 : 8);
    }

    public void vd(boolean z) {
        this.lND.setVisibility(z ? 0 : 8);
    }

    public void ve(boolean z) {
        this.lNE.setVisibility(z ? 0 : 8);
    }

    public void vf(boolean z) {
        this.lNG.setVisibility(z ? 0 : 8);
    }

    public void as(boolean z, boolean z2) {
        this.lNI.setVisibility(z ? 0 : 8);
        this.lNR = z2;
        if (z2) {
            this.lNI.setText(R.string.view_reverse);
        } else {
            this.lNI.setText(R.string.default_sort);
        }
        this.lNI.setText(R.string.sort_selector);
    }

    public void at(boolean z, boolean z2) {
        this.lNJ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lNJ.setText(R.string.normal_mode);
            h(this.lNJ, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lNJ.setText(R.string.eyeshield_mode);
        h(this.lNJ, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void vg(boolean z) {
        this.lNC.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gUn.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lNB = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lNM = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lNM.setOnClickListener(this.mClickListener);
        this.lNI = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lNI.setOnClickListener(this.mClickListener);
        this.lNC = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lNC.setOnClickListener(this.mClickListener);
        this.lNJ = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lNJ.setOnClickListener(this.mClickListener);
        this.lND = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lND.setOnClickListener(this.mClickListener);
        this.lNE = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lNE.setOnClickListener(this.mClickListener);
        this.lNL = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lNL.setOnClickListener(this.mClickListener);
        this.lNF = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lNF.setOnClickListener(this.mClickListener);
        this.lNG = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lNG.setOnClickListener(this.mClickListener);
        this.lNH = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lNH.setOnClickListener(this.mClickListener);
        this.lNK = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lNK.setOnClickListener(this.mClickListener);
        this.lNO = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lNN = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.jJO = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.jJO.setOnClickListener(this.mClickListener);
        this.lNP = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!dnD()) {
            dnC();
        }
    }

    public void dnB() {
        int i;
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lNB, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.lNN).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lNP, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.jJO, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ao.n(this.jJO, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNC, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNL, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNM, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lND, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNE, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNF, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNH, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNK, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNG, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNI, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lNJ, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gUn.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (dnD()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lNB.setHorizontalSpacing(i);
        h(this.lNC, R.drawable.icon_pure_pb_recommend_jump30);
        h(this.lNL, R.drawable.icon_pure_pb_recommend_report30);
        h(this.lND, R.drawable.icon_pure_pb_recommend_initial30);
        h(this.lNE, R.drawable.icon_pure_pb_recommend_fans30);
        this.lNE.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        h(this.lNF, this.lNQ ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        h(this.lNG, R.drawable.icon_pure_pb_recommend_block30);
        h(this.lNI, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lNO != null) {
            this.lNO.onChangeSkinType();
        }
    }

    private void h(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bOq, bOq);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void dnC() {
        this.lNM.getLayoutParams().width = 201;
        this.lNI.getLayoutParams().width = 201;
        this.lNC.getLayoutParams().width = 201;
        this.lNJ.getLayoutParams().width = 201;
        this.lND.getLayoutParams().width = 201;
        this.lNE.getLayoutParams().width = 201;
        this.lNL.getLayoutParams().width = 201;
        this.lNF.getLayoutParams().width = 201;
        this.lNG.getLayoutParams().width = 201;
        this.lNH.getLayoutParams().width = 201;
        this.lNK.getLayoutParams().width = 201;
    }

    private boolean dnD() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gUn.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }
}
