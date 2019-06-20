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
    private final float hKW;
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
    private TextView hLh;
    private PbActivity hLi;
    private FlowLayout hLj;
    private LinearLayout hLk;
    private TextSizeSeekBar hLl;
    public boolean hLm;
    public boolean hLn;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hKW = 0.5f;
        this.mView = null;
        this.hKX = null;
        this.hLf = null;
        this.hLi = null;
        this.mClickListener = null;
        this.hLi = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bTH() {
        return this.hKX;
    }

    public TextView bTI() {
        return this.hLf;
    }

    public TextView getCancelView() {
        return this.bpQ;
    }

    public TextView bTJ() {
        return this.hLh;
    }

    public TextView bTK() {
        return this.hLb;
    }

    public TextView bTL() {
        return this.hKZ;
    }

    public TextView bTM() {
        return this.hLe;
    }

    public TextView bTN() {
        return this.hKY;
    }

    public TextView bTO() {
        return this.hLa;
    }

    public TextView bTP() {
        return this.hLc;
    }

    public TextView bTQ() {
        return this.hLd;
    }

    public TextView bTR() {
        return this.hLg;
    }

    public void release() {
    }

    public void ot(boolean z) {
        if (z) {
            this.hLf.setVisibility(0);
        } else {
            this.hLf.setVisibility(8);
        }
    }

    public void u(boolean z, String str) {
        if (z) {
            this.hLg.setVisibility(0);
            this.hLg.setText(str);
            return;
        }
        this.hLg.setVisibility(8);
    }

    public void U(boolean z, boolean z2) {
        this.hLh.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLh.setText(R.string.group_info_intro_more);
        } else {
            this.hLh.setText(R.string.view_host);
        }
    }

    public void V(boolean z, boolean z2) {
        this.hLb.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLb.setText(R.string.cancel_top);
        } else {
            this.hLb.setText(R.string.top);
        }
    }

    public void W(boolean z, boolean z2) {
        this.hLe.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLe.setText(R.string.cancel_good);
        } else {
            this.hLe.setText(R.string.commit_good);
        }
    }

    public void ou(boolean z) {
        this.hKZ.setVisibility(z ? 0 : 8);
    }

    public void ov(boolean z) {
        this.hKY.setVisibility(z ? 0 : 8);
    }

    public void ow(boolean z) {
        this.hLa.setVisibility(z ? 0 : 8);
    }

    public void X(boolean z, boolean z2) {
        this.hLc.setVisibility(z ? 0 : 8);
        this.hLn = z2;
        if (z2) {
            this.hLc.setText(R.string.view_reverse);
        } else {
            this.hLc.setText(R.string.default_sort);
        }
        this.hLc.setText(R.string.sort_selector);
    }

    public void Y(boolean z, boolean z2) {
        this.hLd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLd.setText(R.string.normal_mode);
        } else {
            this.hLd.setText(R.string.eyeshield_mode);
        }
    }

    public void ox(boolean z) {
        this.hKX.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hLi.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hKX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hKX.setOnClickListener(this.mClickListener);
        this.hLf = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hLf.setOnClickListener(this.mClickListener);
        this.hLg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hLg.setOnClickListener(this.mClickListener);
        this.hKY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hKY.setOnClickListener(this.mClickListener);
        this.hKZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hKZ.setOnClickListener(this.mClickListener);
        this.hLa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hLa.setOnClickListener(this.mClickListener);
        this.hLc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hLc.setOnClickListener(this.mClickListener);
        this.hLd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hLd.setOnClickListener(this.mClickListener);
        this.hLb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hLb.setOnClickListener(this.mClickListener);
        this.hLe = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hLe.setOnClickListener(this.mClickListener);
        this.hLh = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hLh.setOnClickListener(this.mClickListener);
        this.hLj = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hLl = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hLk = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bpQ = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bpQ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.hLj, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.hLk, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bpQ, R.drawable.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.f(this.bpQ, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.f(this.hKX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLf, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLg, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLh, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKZ, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLe, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLa, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLd, R.color.cp_cont_f, 1);
        this.hLj.setHorizontalSpacing(((((WindowManager) this.hLi.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hKY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hLm) {
            this.hKZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.hKZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.hLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hLl != null) {
            this.hLl.onChangeSkinType();
        }
    }
}
