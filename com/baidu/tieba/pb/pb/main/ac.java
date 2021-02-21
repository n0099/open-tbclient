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
    private BaseFragment gXl;
    private EMTextView jQZ;
    private FlowLayout lWM;
    private EMTextView lWN;
    private EMTextView lWO;
    private EMTextView lWP;
    private EMTextView lWQ;
    private EMTextView lWR;
    private EMTextView lWS;
    private EMTextView lWT;
    private EMTextView lWU;
    private EMTextView lWV;
    private EMTextView lWW;
    private EMTextView lWX;
    private LinearLayout lWY;
    private TextSizeSeekBar lWZ;
    private View lXa;
    public boolean lXb;
    public boolean lXc;
    private View.OnClickListener mClickListener;
    private View mView;

    public ac(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lWW = null;
        this.mClickListener = null;
        this.gXl = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dpK() {
        return this.lWN;
    }

    public TextView dpL() {
        return this.lWW;
    }

    public TextView dpM() {
        return this.jQZ;
    }

    public TextView dpN() {
        return this.lWX;
    }

    public TextView dpO() {
        return this.lWS;
    }

    public TextView dpP() {
        return this.lWQ;
    }

    public TextView dpQ() {
        return this.lWV;
    }

    public TextView dpR() {
        return this.lWO;
    }

    public TextView dpS() {
        return this.lWP;
    }

    public TextView dpT() {
        return this.lWR;
    }

    public TextView dpU() {
        return this.lWT;
    }

    public TextView dpV() {
        return this.lWU;
    }

    public void release() {
    }

    public void vq(boolean z) {
        this.lWW.setVisibility(z ? 0 : 8);
    }

    public void ap(boolean z, boolean z2) {
        this.lWX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWX.setText(R.string.group_info_intro_more);
            i(this.lWX, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lWX.setText(R.string.view_host);
        i(this.lWX, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void aq(boolean z, boolean z2) {
        this.lWS.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWS.setText(R.string.pb_cancel_top);
            i(this.lWS, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lWS.setText(R.string.top);
        i(this.lWS, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ar(boolean z, boolean z2) {
        this.lWV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWV.setText(R.string.pb_cancel_good);
            i(this.lWV, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lWV.setText(R.string.commit_good);
        i(this.lWV, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void vr(boolean z) {
        this.lWQ.setVisibility(z ? 0 : 8);
    }

    public void vs(boolean z) {
        this.lWO.setVisibility(z ? 0 : 8);
    }

    public void vt(boolean z) {
        this.lWP.setVisibility(z ? 0 : 8);
    }

    public void vu(boolean z) {
        this.lWR.setVisibility(z ? 0 : 8);
    }

    public void as(boolean z, boolean z2) {
        this.lWT.setVisibility(z ? 0 : 8);
        this.lXc = z2;
        if (z2) {
            this.lWT.setText(R.string.view_reverse);
        } else {
            this.lWT.setText(R.string.default_sort);
        }
        this.lWT.setText(R.string.sort_selector);
    }

    public void at(boolean z, boolean z2) {
        this.lWU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lWU.setText(R.string.normal_mode);
            i(this.lWU, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lWU.setText(R.string.eyeshield_mode);
        i(this.lWU, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void vv(boolean z) {
        this.lWN.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gXl.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lWM = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lWX = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lWX.setOnClickListener(this.mClickListener);
        this.lWT = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lWT.setOnClickListener(this.mClickListener);
        this.lWN = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lWN.setOnClickListener(this.mClickListener);
        this.lWU = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lWU.setOnClickListener(this.mClickListener);
        this.lWO = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lWO.setOnClickListener(this.mClickListener);
        this.lWP = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lWP.setOnClickListener(this.mClickListener);
        this.lWW = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lWW.setOnClickListener(this.mClickListener);
        this.lWQ = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lWQ.setOnClickListener(this.mClickListener);
        this.lWR = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lWR.setOnClickListener(this.mClickListener);
        this.lWS = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lWS.setOnClickListener(this.mClickListener);
        this.lWV = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lWV.setOnClickListener(this.mClickListener);
        this.lWZ = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lWY = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.jQZ = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.jQZ.setOnClickListener(this.mClickListener);
        this.lXa = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!dpY()) {
            dpX();
        }
    }

    public void dpW() {
        int i;
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lWM, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(this.lWY).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXa, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.jQZ, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.n(this.jQZ, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWN, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWW, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWX, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWO, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWP, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWQ, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWS, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWV, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWR, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWT, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWU, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gXl.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (dpY()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lWM.setHorizontalSpacing(i);
        i(this.lWN, R.drawable.icon_pure_pb_recommend_jump30);
        i(this.lWW, R.drawable.icon_pure_pb_recommend_report30);
        i(this.lWO, R.drawable.icon_pure_pb_recommend_initial30);
        i(this.lWP, R.drawable.icon_pure_pb_recommend_fans30);
        this.lWP.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        i(this.lWQ, this.lXb ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        i(this.lWR, R.drawable.icon_pure_pb_recommend_block30);
        i(this.lWT, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lWZ != null) {
            this.lWZ.onChangeSkinType();
        }
    }

    private void i(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bSg, bSg);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void dpX() {
        this.lWX.getLayoutParams().width = 201;
        this.lWT.getLayoutParams().width = 201;
        this.lWN.getLayoutParams().width = 201;
        this.lWU.getLayoutParams().width = 201;
        this.lWO.getLayoutParams().width = 201;
        this.lWP.getLayoutParams().width = 201;
        this.lWW.getLayoutParams().width = 201;
        this.lWQ.getLayoutParams().width = 201;
        this.lWR.getLayoutParams().width = 201;
        this.lWS.getLayoutParams().width = 201;
        this.lWV.getLayoutParams().width = 201;
    }

    private boolean dpY() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gXl.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void jJ(boolean z) {
        MaskView.b(this.lWV, z);
        MaskView.b(this.lWS, z);
        MaskView.b(this.lWP, z);
    }
}
