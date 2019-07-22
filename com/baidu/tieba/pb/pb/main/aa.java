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
    public boolean hRA;
    private final float hRj;
    private TextView hRk;
    private TextView hRl;
    private TextView hRm;
    private TextView hRn;
    private TextView hRo;
    private TextView hRp;
    private TextView hRq;
    private TextView hRr;
    private TextView hRs;
    private TextView hRt;
    private TextView hRu;
    private PbActivity hRv;
    private FlowLayout hRw;
    private LinearLayout hRx;
    private TextSizeSeekBar hRy;
    public boolean hRz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hRj = 0.5f;
        this.mView = null;
        this.hRk = null;
        this.hRs = null;
        this.hRv = null;
        this.mClickListener = null;
        this.hRv = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bWu() {
        return this.hRk;
    }

    public TextView bWv() {
        return this.hRs;
    }

    public TextView getCancelView() {
        return this.bqD;
    }

    public TextView bWw() {
        return this.hRu;
    }

    public TextView bWx() {
        return this.hRo;
    }

    public TextView bWy() {
        return this.hRm;
    }

    public TextView bWz() {
        return this.hRr;
    }

    public TextView bWA() {
        return this.hRl;
    }

    public TextView bWB() {
        return this.hRn;
    }

    public TextView bWC() {
        return this.hRp;
    }

    public TextView bWD() {
        return this.hRq;
    }

    public TextView bWE() {
        return this.hRt;
    }

    public void release() {
    }

    public void oH(boolean z) {
        if (z) {
            this.hRs.setVisibility(0);
        } else {
            this.hRs.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.hRt.setVisibility(0);
            this.hRt.setText(str);
            return;
        }
        this.hRt.setVisibility(8);
    }

    public void X(boolean z, boolean z2) {
        this.hRu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hRu.setText(R.string.group_info_intro_more);
        } else {
            this.hRu.setText(R.string.view_host);
        }
    }

    public void Y(boolean z, boolean z2) {
        this.hRo.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hRo.setText(R.string.cancel_top);
        } else {
            this.hRo.setText(R.string.top);
        }
    }

    public void Z(boolean z, boolean z2) {
        this.hRr.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hRr.setText(R.string.cancel_good);
        } else {
            this.hRr.setText(R.string.commit_good);
        }
    }

    public void oI(boolean z) {
        this.hRm.setVisibility(z ? 0 : 8);
    }

    public void oJ(boolean z) {
        this.hRl.setVisibility(z ? 0 : 8);
    }

    public void oK(boolean z) {
        this.hRn.setVisibility(z ? 0 : 8);
    }

    public void aa(boolean z, boolean z2) {
        this.hRp.setVisibility(z ? 0 : 8);
        this.hRA = z2;
        if (z2) {
            this.hRp.setText(R.string.view_reverse);
        } else {
            this.hRp.setText(R.string.default_sort);
        }
        this.hRp.setText(R.string.sort_selector);
    }

    public void ab(boolean z, boolean z2) {
        this.hRq.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hRq.setText(R.string.normal_mode);
        } else {
            this.hRq.setText(R.string.eyeshield_mode);
        }
    }

    public void oL(boolean z) {
        this.hRk.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hRv.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hRk = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hRk.setOnClickListener(this.mClickListener);
        this.hRs = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hRs.setOnClickListener(this.mClickListener);
        this.hRt = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hRt.setOnClickListener(this.mClickListener);
        this.hRl = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hRl.setOnClickListener(this.mClickListener);
        this.hRm = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hRm.setOnClickListener(this.mClickListener);
        this.hRn = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hRn.setOnClickListener(this.mClickListener);
        this.hRp = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hRp.setOnClickListener(this.mClickListener);
        this.hRq = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hRq.setOnClickListener(this.mClickListener);
        this.hRo = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hRo.setOnClickListener(this.mClickListener);
        this.hRr = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hRr.setOnClickListener(this.mClickListener);
        this.hRu = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hRu.setOnClickListener(this.mClickListener);
        this.hRw = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hRy = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hRx = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bqD = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bqD.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.l(this.hRw, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.k(this.hRx, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.k(this.bqD, R.drawable.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.am.f(this.bqD, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.f(this.hRk, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRs, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRt, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRu, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRl, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRm, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRo, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRr, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRn, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRp, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hRq, R.color.cp_cont_f, 1);
        this.hRw.setHorizontalSpacing(((((WindowManager) this.hRv.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hRk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hRl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hRz) {
            this.hRm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.hRm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.hRo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hRu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hRy != null) {
            this.hRy.onChangeSkinType();
        }
    }
}
