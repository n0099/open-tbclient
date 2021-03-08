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
    public static final int bTG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private BaseFragment gYU;
    private EMTextView jSI;
    private FlowLayout lYO;
    private EMTextView lYP;
    private EMTextView lYQ;
    private EMTextView lYR;
    private EMTextView lYS;
    private EMTextView lYT;
    private EMTextView lYU;
    private EMTextView lYV;
    private EMTextView lYW;
    private EMTextView lYX;
    private EMTextView lYY;
    private EMTextView lYZ;
    private LinearLayout lZa;
    private TextSizeSeekBar lZb;
    private View lZc;
    public boolean lZd;
    public boolean lZe;
    private View.OnClickListener mClickListener;
    private View mView;

    public ac(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lYY = null;
        this.mClickListener = null;
        this.gYU = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dpT() {
        return this.lYP;
    }

    public TextView dpU() {
        return this.lYY;
    }

    public TextView dpV() {
        return this.jSI;
    }

    public TextView dpW() {
        return this.lYZ;
    }

    public TextView dpX() {
        return this.lYU;
    }

    public TextView dpY() {
        return this.lYS;
    }

    public TextView dpZ() {
        return this.lYX;
    }

    public TextView dqa() {
        return this.lYQ;
    }

    public TextView dqb() {
        return this.lYR;
    }

    public TextView dqc() {
        return this.lYT;
    }

    public TextView dqd() {
        return this.lYV;
    }

    public TextView dqe() {
        return this.lYW;
    }

    public void release() {
    }

    public void vq(boolean z) {
        this.lYY.setVisibility(z ? 0 : 8);
    }

    public void ap(boolean z, boolean z2) {
        this.lYZ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lYZ.setText(R.string.group_info_intro_more);
            i(this.lYZ, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lYZ.setText(R.string.view_host);
        i(this.lYZ, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void aq(boolean z, boolean z2) {
        this.lYU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lYU.setText(R.string.pb_cancel_top);
            i(this.lYU, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lYU.setText(R.string.top);
        i(this.lYU, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ar(boolean z, boolean z2) {
        this.lYX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lYX.setText(R.string.pb_cancel_good);
            i(this.lYX, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lYX.setText(R.string.commit_good);
        i(this.lYX, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void vr(boolean z) {
        this.lYS.setVisibility(z ? 0 : 8);
    }

    public void vs(boolean z) {
        this.lYQ.setVisibility(z ? 0 : 8);
    }

    public void vt(boolean z) {
        this.lYR.setVisibility(z ? 0 : 8);
    }

    public void vu(boolean z) {
        this.lYT.setVisibility(z ? 0 : 8);
    }

    public void as(boolean z, boolean z2) {
        this.lYV.setVisibility(z ? 0 : 8);
        this.lZe = z2;
        if (z2) {
            this.lYV.setText(R.string.view_reverse);
        } else {
            this.lYV.setText(R.string.default_sort);
        }
        this.lYV.setText(R.string.sort_selector);
    }

    public void at(boolean z, boolean z2) {
        this.lYW.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lYW.setText(R.string.normal_mode);
            i(this.lYW, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lYW.setText(R.string.eyeshield_mode);
        i(this.lYW, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void vv(boolean z) {
        this.lYP.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gYU.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lYO = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lYZ = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lYZ.setOnClickListener(this.mClickListener);
        this.lYV = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lYV.setOnClickListener(this.mClickListener);
        this.lYP = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lYP.setOnClickListener(this.mClickListener);
        this.lYW = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lYW.setOnClickListener(this.mClickListener);
        this.lYQ = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lYQ.setOnClickListener(this.mClickListener);
        this.lYR = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lYR.setOnClickListener(this.mClickListener);
        this.lYY = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lYY.setOnClickListener(this.mClickListener);
        this.lYS = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lYS.setOnClickListener(this.mClickListener);
        this.lYT = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lYT.setOnClickListener(this.mClickListener);
        this.lYU = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lYU.setOnClickListener(this.mClickListener);
        this.lYX = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lYX.setOnClickListener(this.mClickListener);
        this.lZb = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lZa = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.jSI = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.jSI.setOnClickListener(this.mClickListener);
        this.lZc = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!dqh()) {
            dqg();
        }
    }

    public void dqf() {
        int i;
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYO, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lZa).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lZc, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.jSI, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.n(this.jSI, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYP, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYY, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYZ, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYQ, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYR, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYS, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYU, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYX, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYT, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYV, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYW, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gYU.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (dqh()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lYO.setHorizontalSpacing(i);
        i(this.lYP, R.drawable.icon_pure_pb_recommend_jump30);
        i(this.lYY, R.drawable.icon_pure_pb_recommend_report30);
        i(this.lYQ, R.drawable.icon_pure_pb_recommend_initial30);
        i(this.lYR, R.drawable.icon_pure_pb_recommend_fans30);
        this.lYR.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        i(this.lYS, this.lZd ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        i(this.lYT, R.drawable.icon_pure_pb_recommend_block30);
        i(this.lYV, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lZb != null) {
            this.lZb.onChangeSkinType();
        }
    }

    private void i(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bTG, bTG);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void dqg() {
        this.lYZ.getLayoutParams().width = 201;
        this.lYV.getLayoutParams().width = 201;
        this.lYP.getLayoutParams().width = 201;
        this.lYW.getLayoutParams().width = 201;
        this.lYQ.getLayoutParams().width = 201;
        this.lYR.getLayoutParams().width = 201;
        this.lYY.getLayoutParams().width = 201;
        this.lYS.getLayoutParams().width = 201;
        this.lYT.getLayoutParams().width = 201;
        this.lYU.getLayoutParams().width = 201;
        this.lYX.getLayoutParams().width = 201;
    }

    private boolean dqh() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gYU.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void jJ(boolean z) {
        MaskView.b(this.lYX, z);
        MaskView.b(this.lYU, z);
        MaskView.b(this.lYR, z);
    }
}
