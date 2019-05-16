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
    private final float hKS;
    private TextView hKT;
    private TextView hKU;
    private TextView hKV;
    private TextView hKW;
    private TextView hKX;
    private TextView hKY;
    private TextView hKZ;
    private TextView hLa;
    private TextView hLb;
    private TextView hLc;
    private TextView hLd;
    private PbActivity hLe;
    private FlowLayout hLf;
    private LinearLayout hLg;
    private TextSizeSeekBar hLh;
    public boolean hLi;
    public boolean hLj;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hKS = 0.5f;
        this.mView = null;
        this.hKT = null;
        this.hLb = null;
        this.hLe = null;
        this.mClickListener = null;
        this.hLe = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bTD() {
        return this.hKT;
    }

    public TextView bTE() {
        return this.hLb;
    }

    public TextView getCancelView() {
        return this.bpQ;
    }

    public TextView bTF() {
        return this.hLd;
    }

    public TextView bTG() {
        return this.hKX;
    }

    public TextView bTH() {
        return this.hKV;
    }

    public TextView bTI() {
        return this.hLa;
    }

    public TextView bTJ() {
        return this.hKU;
    }

    public TextView bTK() {
        return this.hKW;
    }

    public TextView bTL() {
        return this.hKY;
    }

    public TextView bTM() {
        return this.hKZ;
    }

    public TextView bTN() {
        return this.hLc;
    }

    public void release() {
    }

    public void os(boolean z) {
        if (z) {
            this.hLb.setVisibility(0);
        } else {
            this.hLb.setVisibility(8);
        }
    }

    public void u(boolean z, String str) {
        if (z) {
            this.hLc.setVisibility(0);
            this.hLc.setText(str);
            return;
        }
        this.hLc.setVisibility(8);
    }

    public void U(boolean z, boolean z2) {
        this.hLd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLd.setText(R.string.group_info_intro_more);
        } else {
            this.hLd.setText(R.string.view_host);
        }
    }

    public void V(boolean z, boolean z2) {
        this.hKX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hKX.setText(R.string.cancel_top);
        } else {
            this.hKX.setText(R.string.top);
        }
    }

    public void W(boolean z, boolean z2) {
        this.hLa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hLa.setText(R.string.cancel_good);
        } else {
            this.hLa.setText(R.string.commit_good);
        }
    }

    public void ot(boolean z) {
        this.hKV.setVisibility(z ? 0 : 8);
    }

    public void ou(boolean z) {
        this.hKU.setVisibility(z ? 0 : 8);
    }

    public void ov(boolean z) {
        this.hKW.setVisibility(z ? 0 : 8);
    }

    public void X(boolean z, boolean z2) {
        this.hKY.setVisibility(z ? 0 : 8);
        this.hLj = z2;
        if (z2) {
            this.hKY.setText(R.string.view_reverse);
        } else {
            this.hKY.setText(R.string.default_sort);
        }
        this.hKY.setText(R.string.sort_selector);
    }

    public void Y(boolean z, boolean z2) {
        this.hKZ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hKZ.setText(R.string.normal_mode);
        } else {
            this.hKZ.setText(R.string.eyeshield_mode);
        }
    }

    public void ow(boolean z) {
        this.hKT.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hLe.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hKT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hKT.setOnClickListener(this.mClickListener);
        this.hLb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hLb.setOnClickListener(this.mClickListener);
        this.hLc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hLc.setOnClickListener(this.mClickListener);
        this.hKU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hKU.setOnClickListener(this.mClickListener);
        this.hKV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hKV.setOnClickListener(this.mClickListener);
        this.hKW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hKW.setOnClickListener(this.mClickListener);
        this.hKY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hKY.setOnClickListener(this.mClickListener);
        this.hKZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hKZ.setOnClickListener(this.mClickListener);
        this.hKX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hKX.setOnClickListener(this.mClickListener);
        this.hLa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hLa.setOnClickListener(this.mClickListener);
        this.hLd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hLd.setOnClickListener(this.mClickListener);
        this.hLf = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hLh = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hLg = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bpQ = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bpQ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.l(this.hLf, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.k(this.hLg, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.al.k(this.bpQ, R.drawable.dialog_share_cancel_button_bg_selector);
        com.baidu.tbadk.core.util.al.f(this.bpQ, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.f(this.hKT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hLa, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.f(this.hKZ, R.color.cp_cont_f, 1);
        this.hLf.setHorizontalSpacing(((((WindowManager) this.hLe.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hKT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_jump_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hKU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_initial_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hLi) {
            this.hKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_report_n, 0.5f), (Drawable) null, (Drawable) null);
        } else {
            this.hKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_delete_n, 0.5f), (Drawable) null, (Drawable) null);
        }
        this.hKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_top_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_best_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hKW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_power_block_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hKZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_night_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hKY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_sort_n, 0.5f), (Drawable) null, (Drawable) null);
        this.hLd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, UtilHelper.getSelectorDrawableByAlpha(R.drawable.icon_pb_recommend_host_n, 0.5f), (Drawable) null, (Drawable) null);
        if (this.hLh != null) {
            this.hLh.onChangeSkinType();
        }
    }
}
