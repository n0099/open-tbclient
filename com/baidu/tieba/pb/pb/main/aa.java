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
    private TextView bpQ;
    private final float hKV;
    private TextView hKW;
    private TextView hKX;
    private TextView hKY;
    private TextView hKZ;
    private TextView hLa;
    private TextView hLb;
    private TextView hLc;
    private TextView hLd;
    private TextView hLe;
    private TextView hLf;
    private TextView hLg;
    private PbActivity hLh;
    private FlowLayout hLi;
    private LinearLayout hLj;
    private TextSizeSeekBar hLk;
    public boolean hLl;
    public boolean hLm;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hKV = 0.5f;
        this.mView = null;
        this.hKW = null;
        this.hLe = null;
        this.hLh = null;
        this.mClickListener = null;
        this.hLh = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bTG() {
        return this.hKW;
    }

    public TextView bTH() {
        return this.hLe;
    }

    public TextView getCancelView() {
        return this.bpQ;
    }

    public TextView bTI() {
        return this.hLg;
    }

    public TextView bTJ() {
        return this.hLa;
    }

    public TextView bTK() {
        return this.hKY;
    }

    public TextView bTL() {
        return this.hLd;
    }

    public TextView bTM() {
        return this.hKX;
    }

    public TextView bTN() {
        return this.hKZ;
    }

    public TextView bTO() {
        return this.hLb;
    }

    public TextView bTP() {
        return this.hLc;
    }

    public TextView bTQ() {
        return this.hLf;
    }

    public void release() {
    }

    public void os(boolean z) {
        if (z) {
            this.hLe.setVisibility(0);
        } else {
            this.hLe.setVisibility(8);
        }
    }

    public void u(boolean z, String str) {
        if (z) {
            this.hLf.setVisibility(0);
            this.hLf.setText(str);
            return;
        }
        this.hLf.setVisibility(8);
    }

    public void U(boolean z, boolean z2) {
        this.hLg.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLg.setText(R.string.group_info_intro_more);
        } else {
            this.hLg.setText(R.string.view_host);
        }
    }

    public void V(boolean z, boolean z2) {
        this.hLa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLa.setText(R.string.cancel_top);
        } else {
            this.hLa.setText(R.string.top);
        }
    }

    public void W(boolean z, boolean z2) {
        this.hLd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLd.setText(R.string.cancel_good);
        } else {
            this.hLd.setText(R.string.commit_good);
        }
    }

    public void ot(boolean z) {
        this.hKY.setVisibility(z ? 0 : 8);
    }

    public void ou(boolean z) {
        this.hKX.setVisibility(z ? 0 : 8);
    }

    public void ov(boolean z) {
        this.hKZ.setVisibility(z ? 0 : 8);
    }

    public void X(boolean z, boolean z2) {
        this.hLb.setVisibility(z ? 0 : 8);
        this.hLm = z2;
        if (z2) {
            this.hLb.setText(R.string.view_reverse);
        } else {
            this.hLb.setText(R.string.default_sort);
        }
        this.hLb.setText(R.string.sort_selector);
    }

    public void Y(boolean z, boolean z2) {
        this.hLc.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLc.setText(R.string.normal_mode);
        } else {
            this.hLc.setText(R.string.eyeshield_mode);
        }
    }

    public void ow(boolean z) {
        this.hKW.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hLh.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hKW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hKW.setOnClickListener(this.mClickListener);
        this.hLe = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hLe.setOnClickListener(this.mClickListener);
        this.hLf = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hLf.setOnClickListener(this.mClickListener);
        this.hKX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hKX.setOnClickListener(this.mClickListener);
        this.hKY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hKY.setOnClickListener(this.mClickListener);
        this.hKZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hKZ.setOnClickListener(this.mClickListener);
        this.hLb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hLb.setOnClickListener(this.mClickListener);
        this.hLc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hLc.setOnClickListener(this.mClickListener);
        this.hLa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hLa.setOnClickListener(this.mClickListener);
        this.hLd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hLd.setOnClickListener(this.mClickListener);
        this.hLg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hLg.setOnClickListener(this.mClickListener);
        this.hLi = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hLk = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hLj = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bpQ = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bpQ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.hLi, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.hLj, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bpQ, R.drawable.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.f(this.bpQ, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.f(this.hKW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLe, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLf, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLg, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLa, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKZ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLc, R.color.cp_cont_f, 1);
        this.hLi.setHorizontalSpacing(((((WindowManager) this.hLh.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hKW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hLl) {
            this.hKY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.hKY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.hLa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hKZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hLk != null) {
            this.hLk.onChangeSkinType();
        }
    }
}
