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
/* loaded from: classes21.dex */
public class aj extends com.baidu.adp.base.c {
    public static final int bJg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    private BaseFragment gEk;
    private EMTextView joo;
    private FlowLayout lze;
    private EMTextView lzf;
    private EMTextView lzg;
    private EMTextView lzh;
    private EMTextView lzi;
    private EMTextView lzj;
    private EMTextView lzk;
    private EMTextView lzl;
    private EMTextView lzm;
    private EMTextView lzn;
    private EMTextView lzo;
    private EMTextView lzp;
    private LinearLayout lzq;
    private TextSizeSeekBar lzr;
    private View lzs;
    public boolean lzt;
    public boolean lzu;
    private View.OnClickListener mClickListener;
    private View mView;

    public aj(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.lzo = null;
        this.mClickListener = null;
        this.gEk = baseFragment;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView dmc() {
        return this.lzf;
    }

    public TextView dmd() {
        return this.lzo;
    }

    public TextView dme() {
        return this.joo;
    }

    public TextView dmf() {
        return this.lzp;
    }

    public TextView dmg() {
        return this.lzk;
    }

    public TextView dmh() {
        return this.lzi;
    }

    public TextView dmi() {
        return this.lzn;
    }

    public TextView dmj() {
        return this.lzg;
    }

    public TextView dmk() {
        return this.lzh;
    }

    public TextView dml() {
        return this.lzj;
    }

    public TextView dmm() {
        return this.lzl;
    }

    public TextView dmn() {
        return this.lzm;
    }

    public void release() {
    }

    public void uC(boolean z) {
        this.lzo.setVisibility(z ? 0 : 8);
    }

    public void an(boolean z, boolean z2) {
        this.lzp.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lzp.setText(R.string.group_info_intro_more);
            h(this.lzp, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.lzp.setText(R.string.view_host);
        h(this.lzp, R.drawable.icon_pure_pb_recommend_host30);
    }

    public void ao(boolean z, boolean z2) {
        this.lzk.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lzk.setText(R.string.pb_cancel_top);
            h(this.lzk, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.lzk.setText(R.string.top);
        h(this.lzk, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void ap(boolean z, boolean z2) {
        this.lzn.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lzn.setText(R.string.pb_cancel_good);
            h(this.lzn, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.lzn.setText(R.string.commit_good);
        h(this.lzn, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void uD(boolean z) {
        this.lzi.setVisibility(z ? 0 : 8);
    }

    public void uE(boolean z) {
        this.lzg.setVisibility(z ? 0 : 8);
    }

    public void uF(boolean z) {
        this.lzh.setVisibility(z ? 0 : 8);
    }

    public void uG(boolean z) {
        this.lzj.setVisibility(z ? 0 : 8);
    }

    public void aq(boolean z, boolean z2) {
        this.lzl.setVisibility(z ? 0 : 8);
        this.lzu = z2;
        if (z2) {
            this.lzl.setText(R.string.view_reverse);
        } else {
            this.lzl.setText(R.string.default_sort);
        }
        this.lzl.setText(R.string.sort_selector);
    }

    public void ar(boolean z, boolean z2) {
        this.lzm.setVisibility(z ? 0 : 8);
        if (z2) {
            this.lzm.setText(R.string.normal_mode);
            h(this.lzm, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.lzm.setText(R.string.eyeshield_mode);
        h(this.lzm, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void uH(boolean z) {
        this.lzf.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gEk.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.lze = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.lzp = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.lzp.setOnClickListener(this.mClickListener);
        this.lzl = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.lzl.setOnClickListener(this.mClickListener);
        this.lzf = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.lzf.setOnClickListener(this.mClickListener);
        this.lzm = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.lzm.setOnClickListener(this.mClickListener);
        this.lzg = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.lzg.setOnClickListener(this.mClickListener);
        this.lzh = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_call_fans);
        this.lzh.setOnClickListener(this.mClickListener);
        this.lzo = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.lzo.setOnClickListener(this.mClickListener);
        this.lzi = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.lzi.setOnClickListener(this.mClickListener);
        this.lzj = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.lzj.setOnClickListener(this.mClickListener);
        this.lzk = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.lzk.setOnClickListener(this.mClickListener);
        this.lzn = (EMTextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.lzn.setOnClickListener(this.mClickListener);
        this.lzr = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.lzq = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.joo = (EMTextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.joo.setOnClickListener(this.mClickListener);
        this.lzs = this.mView.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (!dmq()) {
            dmp();
        }
    }

    public void dmo() {
        int i;
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lze, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.lzq).pb(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lzs, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.joo, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.k(this.joo, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzf, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzo, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzp, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzg, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzh, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzi, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzk, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzn, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzj, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzl, R.color.CAM_X0107, 1);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzm, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.gEk.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (dmq()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.lze.setHorizontalSpacing(i);
        h(this.lzf, R.drawable.icon_pure_pb_recommend_jump30);
        h(this.lzo, R.drawable.icon_pure_pb_recommend_report30);
        h(this.lzg, R.drawable.icon_pure_pb_recommend_initial30);
        h(this.lzh, R.drawable.icon_pure_pb_recommend_fans30);
        this.lzh.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        h(this.lzi, this.lzt ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        h(this.lzj, R.drawable.icon_pure_pb_recommend_block30);
        h(this.lzl, R.drawable.icon_pure_pb_recommend_sort30);
        if (this.lzr != null) {
            this.lzr.onChangeSkinType();
        }
    }

    private void h(TextView textView, int i) {
        Drawable a2;
        if (textView != null && (a2 = WebPManager.a(i, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) != null) {
            a2.setBounds(0, 0, bJg, bJg);
            textView.setCompoundDrawables(null, a2, null, null);
        }
    }

    private void dmp() {
        this.lzp.getLayoutParams().width = 201;
        this.lzl.getLayoutParams().width = 201;
        this.lzf.getLayoutParams().width = 201;
        this.lzm.getLayoutParams().width = 201;
        this.lzg.getLayoutParams().width = 201;
        this.lzh.getLayoutParams().width = 201;
        this.lzo.getLayoutParams().width = 201;
        this.lzi.getLayoutParams().width = 201;
        this.lzj.getLayoutParams().width = 201;
        this.lzk.getLayoutParams().width = 201;
        this.lzn.getLayoutParams().width = 201;
    }

    private boolean dmq() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.gEk.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi % 160 == 0 || ((double) ((((float) displayMetrics.densityDpi) * 1.0f) / 160.0f)) == 1.5d;
    }
}
