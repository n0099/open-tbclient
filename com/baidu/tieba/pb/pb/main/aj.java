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
/* loaded from: classes22.dex */
public class aj extends com.baidu.adp.base.c {
    public static final int bOo = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private BaseFragment gNh;
    private EMTextView jBQ;
    private FlowLayout lMR;
    private EMTextView lMS;
    private EMTextView lMT;
    private EMTextView lMU;
    private EMTextView lMV;
    private EMTextView lMW;
    private EMTextView lMX;
    private EMTextView lMY;
    private EMTextView lMZ;
    private EMTextView lNa;
    private EMTextView lNb;
    private EMTextView lNc;
    private LinearLayout lNd;
    private TextSizeSeekBar lNe;
    private View lNf;
    public boolean lNg;
    public boolean lNh;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lNb = null;
        this.mClickListener = null;
        this.gNh = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView drt() {
        return this.lMS;
    }

    public TextView dru() {
        return this.lNb;
    }

    public TextView drv() {
        return this.jBQ;
    }

    public TextView drw() {
        return this.lNc;
    }

    public TextView drx() {
        return this.lMX;
    }

    public TextView dry() {
        return this.lMV;
    }

    public TextView drz() {
        return this.lNa;
    }

    public TextView drA() {
        return this.lMT;
    }

    public TextView drB() {
        return this.lMU;
    }

    public TextView drC() {
        return this.lMW;
    }

    public TextView drD() {
        return this.lMY;
    }

    public TextView drE() {
        return this.lMZ;
    }

    public void release() {
    }

    public void ve(boolean z) {
        this.lNb.setVisibility(z ? 0 : 8);
    }

    public void an(boolean z, boolean z2) {
        this.lNc.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lNc.setText(R.string.group_info_intro_more);
            h(this.lNc, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lNc.setText(R.string.view_host);
        h(this.lNc, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void ao(boolean z, boolean z2) {
        this.lMX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lMX.setText(R.string.pb_cancel_top);
            h(this.lMX, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lMX.setText(R.string.top);
        h(this.lMX, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ap(boolean z, boolean z2) {
        this.lNa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lNa.setText(R.string.pb_cancel_good);
            h(this.lNa, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lNa.setText(R.string.commit_good);
        h(this.lNa, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void vf(boolean z) {
        this.lMV.setVisibility(z ? 0 : 8);
    }

    public void vg(boolean z) {
        this.lMT.setVisibility(z ? 0 : 8);
    }

    public void vh(boolean z) {
        this.lMU.setVisibility(z ? 0 : 8);
    }

    public void vi(boolean z) {
        this.lMW.setVisibility(z ? 0 : 8);
    }

    public void aq(boolean z, boolean z2) {
        this.lMY.setVisibility(z ? 0 : 8);
        this.lNh = z2;
        if (z2) {
            this.lMY.setText(R.string.view_reverse);
        } else {
            this.lMY.setText(R.string.default_sort);
        }
        this.lMY.setText(R.string.sort_selector);
    }

    public void ar(boolean z, boolean z2) {
        this.lMZ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lMZ.setText(R.string.normal_mode);
            h(this.lMZ, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lMZ.setText(R.string.eyeshield_mode);
        h(this.lMZ, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void vj(boolean z) {
        this.lMS.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gNh.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lMR = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lNc = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lNc.setOnClickListener(this.mClickListener);
        this.lMY = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lMY.setOnClickListener(this.mClickListener);
        this.lMS = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lMS.setOnClickListener(this.mClickListener);
        this.lMZ = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lMZ.setOnClickListener(this.mClickListener);
        this.lMT = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lMT.setOnClickListener(this.mClickListener);
        this.lMU = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lMU.setOnClickListener(this.mClickListener);
        this.lNb = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lNb.setOnClickListener(this.mClickListener);
        this.lMV = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lMV.setOnClickListener(this.mClickListener);
        this.lMW = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lMW.setOnClickListener(this.mClickListener);
        this.lMX = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lMX.setOnClickListener(this.mClickListener);
        this.lNa = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lNa.setOnClickListener(this.mClickListener);
        this.lNe = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lNd = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.jBQ = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.jBQ.setOnClickListener(this.mClickListener);
        this.lNf = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!drH()) {
            drG();
        }
    }

    public void drF() {
        int i;
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lMR, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.lNd).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNf, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.jBQ, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.k(this.jBQ, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMS, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNb, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNc, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMT, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMU, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMV, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMX, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNa, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMW, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMY, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lMZ, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gNh.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (drH()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lMR.setHorizontalSpacing(i);
        h(this.lMS, R.drawable.icon_pure_pb_recommend_jump30);
        h(this.lNb, R.drawable.icon_pure_pb_recommend_report30);
        h(this.lMT, R.drawable.icon_pure_pb_recommend_initial30);
        h(this.lMU, R.drawable.icon_pure_pb_recommend_fans30);
        this.lMU.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        h(this.lMV, this.lNg ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        h(this.lMW, R.drawable.icon_pure_pb_recommend_block30);
        h(this.lMY, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lNe != null) {
            this.lNe.onChangeSkinType();
        }
    }

    private void h(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bOo, bOo);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void drG() {
        this.lNc.getLayoutParams().width = 201;
        this.lMY.getLayoutParams().width = 201;
        this.lMS.getLayoutParams().width = 201;
        this.lMZ.getLayoutParams().width = 201;
        this.lMT.getLayoutParams().width = 201;
        this.lMU.getLayoutParams().width = 201;
        this.lNb.getLayoutParams().width = 201;
        this.lMV.getLayoutParams().width = 201;
        this.lMW.getLayoutParams().width = 201;
        this.lMX.getLayoutParams().width = 201;
        this.lNa.getLayoutParams().width = 201;
    }

    private boolean drH() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gNh.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }
}
