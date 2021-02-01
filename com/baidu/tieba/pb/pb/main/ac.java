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
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class ac extends com.baidu.adp.base.d {
    public static final int bSg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private BaseFragment gWX;
    private EMTextView jQL;
    private EMTextView lWA;
    private EMTextView lWB;
    private EMTextView lWC;
    private EMTextView lWD;
    private EMTextView lWE;
    private EMTextView lWF;
    private EMTextView lWG;
    private EMTextView lWH;
    private EMTextView lWI;
    private LinearLayout lWJ;
    private TextSizeSeekBar lWK;
    private View lWL;
    public boolean lWM;
    public boolean lWN;
    private FlowLayout lWx;
    private EMTextView lWy;
    private EMTextView lWz;
    private View.OnClickListener mClickListener;
    private View mView;

    public ac(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lWH = null;
        this.mClickListener = null;
        this.gWX = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dpD() {
        return this.lWy;
    }

    public TextView dpE() {
        return this.lWH;
    }

    public TextView dpF() {
        return this.jQL;
    }

    public TextView dpG() {
        return this.lWI;
    }

    public TextView dpH() {
        return this.lWD;
    }

    public TextView dpI() {
        return this.lWB;
    }

    public TextView dpJ() {
        return this.lWG;
    }

    public TextView dpK() {
        return this.lWz;
    }

    public TextView dpL() {
        return this.lWA;
    }

    public TextView dpM() {
        return this.lWC;
    }

    public TextView dpN() {
        return this.lWE;
    }

    public TextView dpO() {
        return this.lWF;
    }

    public void release() {
    }

    public void vq(boolean z) {
        this.lWH.setVisibility(z ? 0 : 8);
    }

    public void ap(boolean z, boolean z2) {
        this.lWI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWI.setText(R.string.group_info_intro_more);
            i(this.lWI, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lWI.setText(R.string.view_host);
        i(this.lWI, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void aq(boolean z, boolean z2) {
        this.lWD.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWD.setText(R.string.pb_cancel_top);
            i(this.lWD, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lWD.setText(R.string.top);
        i(this.lWD, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ar(boolean z, boolean z2) {
        this.lWG.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWG.setText(R.string.pb_cancel_good);
            i(this.lWG, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lWG.setText(R.string.commit_good);
        i(this.lWG, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void vr(boolean z) {
        this.lWB.setVisibility(z ? 0 : 8);
    }

    public void vs(boolean z) {
        this.lWz.setVisibility(z ? 0 : 8);
    }

    public void vt(boolean z) {
        this.lWA.setVisibility(z ? 0 : 8);
    }

    public void vu(boolean z) {
        this.lWC.setVisibility(z ? 0 : 8);
    }

    public void as(boolean z, boolean z2) {
        this.lWE.setVisibility(z ? 0 : 8);
        this.lWN = z2;
        if (z2) {
            this.lWE.setText(R.string.view_reverse);
        } else {
            this.lWE.setText(R.string.default_sort);
        }
        this.lWE.setText(R.string.sort_selector);
    }

    public void at(boolean z, boolean z2) {
        this.lWF.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWF.setText(R.string.normal_mode);
            i(this.lWF, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lWF.setText(R.string.eyeshield_mode);
        i(this.lWF, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void vv(boolean z) {
        this.lWy.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gWX.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lWx = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lWI = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lWI.setOnClickListener(this.mClickListener);
        this.lWE = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lWE.setOnClickListener(this.mClickListener);
        this.lWy = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lWy.setOnClickListener(this.mClickListener);
        this.lWF = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lWF.setOnClickListener(this.mClickListener);
        this.lWz = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lWz.setOnClickListener(this.mClickListener);
        this.lWA = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lWA.setOnClickListener(this.mClickListener);
        this.lWH = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lWH.setOnClickListener(this.mClickListener);
        this.lWB = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lWB.setOnClickListener(this.mClickListener);
        this.lWC = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lWC.setOnClickListener(this.mClickListener);
        this.lWD = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lWD.setOnClickListener(this.mClickListener);
        this.lWG = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lWG.setOnClickListener(this.mClickListener);
        this.lWK = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lWJ = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.jQL = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.jQL.setOnClickListener(this.mClickListener);
        this.lWL = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!dpR()) {
            dpQ();
        }
    }

    public void dpP() {
        int i;
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lWx, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lWJ).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lWL, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.jQL, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.n(this.jQL, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWy, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWH, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWI, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWz, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWA, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWB, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWD, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWG, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWC, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWE, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWF, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gWX.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (dpR()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lWx.setHorizontalSpacing(i);
        i(this.lWy, R.drawable.icon_pure_pb_recommend_jump30);
        i(this.lWH, R.drawable.icon_pure_pb_recommend_report30);
        i(this.lWz, R.drawable.icon_pure_pb_recommend_initial30);
        i(this.lWA, R.drawable.icon_pure_pb_recommend_fans30);
        this.lWA.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        i(this.lWB, this.lWM ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        i(this.lWC, R.drawable.icon_pure_pb_recommend_block30);
        i(this.lWE, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lWK != null) {
            this.lWK.onChangeSkinType();
        }
    }

    private void i(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bSg, bSg);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void dpQ() {
        this.lWI.getLayoutParams().width = 201;
        this.lWE.getLayoutParams().width = 201;
        this.lWy.getLayoutParams().width = 201;
        this.lWF.getLayoutParams().width = 201;
        this.lWz.getLayoutParams().width = 201;
        this.lWA.getLayoutParams().width = 201;
        this.lWH.getLayoutParams().width = 201;
        this.lWB.getLayoutParams().width = 201;
        this.lWC.getLayoutParams().width = 201;
        this.lWD.getLayoutParams().width = 201;
        this.lWG.getLayoutParams().width = 201;
    }

    private boolean dpR() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gWX.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void jJ(boolean z) {
        MaskView.b(this.lWG, z);
        MaskView.b(this.lWD, z);
        MaskView.b(this.lWA, z);
    }
}
