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
    public static final int bTc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private BaseFragment gYT;
    private EMTextView jOu;
    private FlowLayout lSg;
    private EMTextView lSh;
    private EMTextView lSi;
    private EMTextView lSj;
    private EMTextView lSk;
    private EMTextView lSl;
    private EMTextView lSm;
    private EMTextView lSn;
    private EMTextView lSo;
    private EMTextView lSp;
    private EMTextView lSq;
    private EMTextView lSr;
    private LinearLayout lSs;
    private TextSizeSeekBar lSt;
    private View lSu;
    public boolean lSv;
    public boolean lSw;
    private View.OnClickListener mClickListener;
    private View mView;

    public ac(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lSq = null;
        this.mClickListener = null;
        this.gYT = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView drg() {
        return this.lSh;
    }

    public TextView drh() {
        return this.lSq;
    }

    public TextView dri() {
        return this.jOu;
    }

    public TextView drj() {
        return this.lSr;
    }

    public TextView drk() {
        return this.lSm;
    }

    public TextView drl() {
        return this.lSk;
    }

    public TextView drm() {
        return this.lSp;
    }

    public TextView drn() {
        return this.lSi;
    }

    public TextView dro() {
        return this.lSj;
    }

    public TextView drp() {
        return this.lSl;
    }

    public TextView drq() {
        return this.lSn;
    }

    public TextView drr() {
        return this.lSo;
    }

    public void release() {
    }

    public void vf(boolean z) {
        this.lSq.setVisibility(z ? 0 : 8);
    }

    public void ap(boolean z, boolean z2) {
        this.lSr.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lSr.setText(R.string.group_info_intro_more);
            h(this.lSr, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lSr.setText(R.string.view_host);
        h(this.lSr, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void aq(boolean z, boolean z2) {
        this.lSm.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lSm.setText(R.string.pb_cancel_top);
            h(this.lSm, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lSm.setText(R.string.top);
        h(this.lSm, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ar(boolean z, boolean z2) {
        this.lSp.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lSp.setText(R.string.pb_cancel_good);
            h(this.lSp, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lSp.setText(R.string.commit_good);
        h(this.lSp, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void vg(boolean z) {
        this.lSk.setVisibility(z ? 0 : 8);
    }

    public void vh(boolean z) {
        this.lSi.setVisibility(z ? 0 : 8);
    }

    public void vi(boolean z) {
        this.lSj.setVisibility(z ? 0 : 8);
    }

    public void vj(boolean z) {
        this.lSl.setVisibility(z ? 0 : 8);
    }

    public void as(boolean z, boolean z2) {
        this.lSn.setVisibility(z ? 0 : 8);
        this.lSw = z2;
        if (z2) {
            this.lSn.setText(R.string.view_reverse);
        } else {
            this.lSn.setText(R.string.default_sort);
        }
        this.lSn.setText(R.string.sort_selector);
    }

    public void at(boolean z, boolean z2) {
        this.lSo.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lSo.setText(R.string.normal_mode);
            h(this.lSo, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lSo.setText(R.string.eyeshield_mode);
        h(this.lSo, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void vk(boolean z) {
        this.lSh.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gYT.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lSg = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lSr = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lSr.setOnClickListener(this.mClickListener);
        this.lSn = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lSn.setOnClickListener(this.mClickListener);
        this.lSh = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lSh.setOnClickListener(this.mClickListener);
        this.lSo = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lSo.setOnClickListener(this.mClickListener);
        this.lSi = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lSi.setOnClickListener(this.mClickListener);
        this.lSj = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lSj.setOnClickListener(this.mClickListener);
        this.lSq = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lSq.setOnClickListener(this.mClickListener);
        this.lSk = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lSk.setOnClickListener(this.mClickListener);
        this.lSl = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lSl.setOnClickListener(this.mClickListener);
        this.lSm = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lSm.setOnClickListener(this.mClickListener);
        this.lSp = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lSp.setOnClickListener(this.mClickListener);
        this.lSt = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lSs = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.jOu = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.jOu.setOnClickListener(this.mClickListener);
        this.lSu = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!dru()) {
            drt();
        }
    }

    public void drs() {
        int i;
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lSg, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.lSs).pK(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lSu, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.jOu, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ao.n(this.jOu, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSh, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSq, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSr, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSi, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSj, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSk, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSm, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSp, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSl, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSn, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSo, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gYT.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (dru()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lSg.setHorizontalSpacing(i);
        h(this.lSh, R.drawable.icon_pure_pb_recommend_jump30);
        h(this.lSq, R.drawable.icon_pure_pb_recommend_report30);
        h(this.lSi, R.drawable.icon_pure_pb_recommend_initial30);
        h(this.lSj, R.drawable.icon_pure_pb_recommend_fans30);
        this.lSj.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        h(this.lSk, this.lSv ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        h(this.lSl, R.drawable.icon_pure_pb_recommend_block30);
        h(this.lSn, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lSt != null) {
            this.lSt.onChangeSkinType();
        }
    }

    private void h(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bTc, bTc);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void drt() {
        this.lSr.getLayoutParams().width = 201;
        this.lSn.getLayoutParams().width = 201;
        this.lSh.getLayoutParams().width = 201;
        this.lSo.getLayoutParams().width = 201;
        this.lSi.getLayoutParams().width = 201;
        this.lSj.getLayoutParams().width = 201;
        this.lSq.getLayoutParams().width = 201;
        this.lSk.getLayoutParams().width = 201;
        this.lSl.getLayoutParams().width = 201;
        this.lSm.getLayoutParams().width = 201;
        this.lSp.getLayoutParams().width = 201;
    }

    private boolean dru() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gYT.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }
}
