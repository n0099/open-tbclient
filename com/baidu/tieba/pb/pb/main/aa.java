package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes4.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private TextView bqD;
    private final float hSe;
    private TextView hSf;
    private TextView hSg;
    private TextView hSh;
    private TextView hSi;
    private TextView hSj;
    private TextView hSk;
    private TextView hSl;
    private TextView hSm;
    private TextView hSn;
    private TextView hSo;
    private TextView hSp;
    private PbActivity hSq;
    private FlowLayout hSr;
    private LinearLayout hSs;
    private TextSizeSeekBar hSt;
    public boolean hSu;
    public boolean hSv;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hSe = 0.5f;
        this.mView = null;
        this.hSf = null;
        this.hSn = null;
        this.hSq = null;
        this.mClickListener = null;
        this.hSq = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bWK() {
        return this.hSf;
    }

    public TextView bWL() {
        return this.hSn;
    }

    public TextView getCancelView() {
        return this.bqD;
    }

    public TextView bWM() {
        return this.hSp;
    }

    public TextView bWN() {
        return this.hSj;
    }

    public TextView bWO() {
        return this.hSh;
    }

    public TextView bWP() {
        return this.hSm;
    }

    public TextView bWQ() {
        return this.hSg;
    }

    public TextView bWR() {
        return this.hSi;
    }

    public TextView bWS() {
        return this.hSk;
    }

    public TextView bWT() {
        return this.hSl;
    }

    public TextView bWU() {
        return this.hSo;
    }

    public void release() {
    }

    public void oH(boolean z) {
        if (z) {
            this.hSn.setVisibility(0);
        } else {
            this.hSn.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.hSo.setVisibility(0);
            this.hSo.setText(str);
            return;
        }
        this.hSo.setVisibility(8);
    }

    public void X(boolean z, boolean z2) {
        this.hSp.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSp.setText(R.string.group_info_intro_more);
        } else {
            this.hSp.setText(R.string.view_host);
        }
    }

    public void Y(boolean z, boolean z2) {
        this.hSj.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSj.setText(R.string.cancel_top);
        } else {
            this.hSj.setText(R.string.top);
        }
    }

    public void Z(boolean z, boolean z2) {
        this.hSm.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSm.setText(R.string.cancel_good);
        } else {
            this.hSm.setText(R.string.commit_good);
        }
    }

    public void oI(boolean z) {
        this.hSh.setVisibility(z ? 0 : 8);
    }

    public void oJ(boolean z) {
        this.hSg.setVisibility(z ? 0 : 8);
    }

    public void oK(boolean z) {
        this.hSi.setVisibility(z ? 0 : 8);
    }

    public void aa(boolean z, boolean z2) {
        this.hSk.setVisibility(z ? 0 : 8);
        this.hSv = z2;
        if (z2) {
            this.hSk.setText(R.string.view_reverse);
        } else {
            this.hSk.setText(R.string.default_sort);
        }
        this.hSk.setText(R.string.sort_selector);
    }

    public void ab(boolean z, boolean z2) {
        this.hSl.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSl.setText(R.string.normal_mode);
        } else {
            this.hSl.setText(R.string.eyeshield_mode);
        }
    }

    public void oL(boolean z) {
        this.hSf.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hSq.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hSf = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hSf.setOnClickListener(this.mClickListener);
        this.hSn = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hSn.setOnClickListener(this.mClickListener);
        this.hSo = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hSo.setOnClickListener(this.mClickListener);
        this.hSg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hSg.setOnClickListener(this.mClickListener);
        this.hSh = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hSh.setOnClickListener(this.mClickListener);
        this.hSi = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hSi.setOnClickListener(this.mClickListener);
        this.hSk = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hSk.setOnClickListener(this.mClickListener);
        this.hSl = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hSl.setOnClickListener(this.mClickListener);
        this.hSj = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hSj.setOnClickListener(this.mClickListener);
        this.hSm = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hSm.setOnClickListener(this.mClickListener);
        this.hSp = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hSp.setOnClickListener(this.mClickListener);
        this.hSr = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hSt = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hSs = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bqD = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bqD.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.l(this.hSr, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.k(this.hSs, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.k(this.bqD, R.drawable.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.am.f(this.bqD, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.f(this.hSf, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSn, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSo, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSp, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSg, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSh, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSj, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSm, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSi, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSk, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hSl, R.color.cp_cont_f, 1);
        this.hSr.setHorizontalSpacing(((((WindowManager) this.hSq.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hSf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hSg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hSu) {
            this.hSh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.hSh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.hSj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hSp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hSt != null) {
            this.hSt.onChangeSkinType();
        }
    }
}
