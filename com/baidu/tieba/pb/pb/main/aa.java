package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aRn;
    private TextView cGy;
    private TextView fBY;
    public boolean fCA;
    public boolean fCB;
    private TextView fCk;
    private TextView fCl;
    private TextView fCm;
    private TextView fCn;
    private TextView fCo;
    private TextView fCp;
    private TextView fCq;
    private TextView fCr;
    private TextView fCs;
    private TextView fCt;
    private TextView fCu;
    private PbActivity fCv;
    private View fCw;
    private FlowLayout fCx;
    private LinearLayout fCy;
    private TextSizeSeekBar fCz;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fBY = null;
        this.fCk = null;
        this.fCs = null;
        this.fCv = null;
        this.mClickListener = null;
        this.fCv = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bcU() {
        return this.fBY;
    }

    public TextView bdc() {
        return this.fCk;
    }

    public TextView bdd() {
        return this.fCs;
    }

    public TextView getCancelView() {
        return this.cGy;
    }

    public View bde() {
        return this.fCw;
    }

    public TextView bdf() {
        return this.fCu;
    }

    public TextView bdg() {
        return this.fCo;
    }

    public TextView bdh() {
        return this.fCm;
    }

    public TextView bdi() {
        return this.fCr;
    }

    public TextView bdj() {
        return this.fCl;
    }

    public TextView bdk() {
        return this.fCn;
    }

    public TextView bdl() {
        return this.fCp;
    }

    public TextView bdm() {
        return this.fCq;
    }

    public TextView bdn() {
        return this.fCt;
    }

    public void bdo() {
        if (this.aRn == null) {
            this.aRn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fCw.setBackgroundColor(aa.this.fCv.getResources().getColor(d.C0140d.common_color_10082));
                }
            };
        }
        this.fCw.postDelayed(this.aRn, 200L);
    }

    public void bdp() {
        this.fCw.setBackgroundColor(this.fCv.getResources().getColor(d.C0140d.common_color_10022));
    }

    public void release() {
        this.fCw.removeCallbacks(this.aRn);
    }

    public void jW(boolean z) {
        if (z) {
            this.fCs.setVisibility(0);
        } else {
            this.fCs.setVisibility(8);
        }
    }

    public void n(boolean z, String str) {
        if (z) {
            this.fCt.setVisibility(0);
            this.fCt.setText(str);
            return;
        }
        this.fCt.setVisibility(8);
    }

    public void jX(boolean z) {
        this.fBY.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.fCu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCu.setText(d.j.group_info_intro_more);
        } else {
            this.fCu.setText(d.j.view_host);
        }
    }

    public void J(boolean z, boolean z2) {
        this.fCo.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCo.setText(d.j.cancel_top);
        } else {
            this.fCo.setText(d.j.top);
        }
    }

    public void K(boolean z, boolean z2) {
        this.fCr.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCr.setText(d.j.cancel_good);
        } else {
            this.fCr.setText(d.j.commit_good);
        }
    }

    public void jY(boolean z) {
        this.fCm.setVisibility(z ? 0 : 8);
    }

    public void jZ(boolean z) {
        this.fCl.setVisibility(z ? 0 : 8);
    }

    public void ka(boolean z) {
        this.fCn.setVisibility(z ? 0 : 8);
    }

    public void L(boolean z, boolean z2) {
        this.fCp.setVisibility(z ? 0 : 8);
        this.fCB = z2;
        if (z2) {
            this.fCp.setText(d.j.view_reverse);
        } else {
            this.fCp.setText(d.j.default_sort);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fCq.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCq.setText(d.j.normal_mode);
        } else {
            this.fCq.setText(d.j.eyeshield_mode);
        }
    }

    public void kb(boolean z) {
        this.fCk.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fCv.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fBY = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fBY.setOnClickListener(this.mClickListener);
        this.fCk = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fCk.setOnClickListener(this.mClickListener);
        this.fCs = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fCs.setOnClickListener(this.mClickListener);
        this.fCt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fCt.setOnClickListener(this.mClickListener);
        this.fCl = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fCl.setOnClickListener(this.mClickListener);
        this.fCm = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fCm.setOnClickListener(this.mClickListener);
        this.fCn = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fCn.setOnClickListener(this.mClickListener);
        this.fCp = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fCp.setOnClickListener(this.mClickListener);
        this.fCq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fCq.setOnClickListener(this.mClickListener);
        this.fCo = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fCo.setOnClickListener(this.mClickListener);
        this.fCr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fCr.setOnClickListener(this.mClickListener);
        this.fCu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fCu.setOnClickListener(this.mClickListener);
        this.fCw = this.mView.findViewById(d.g.pb_more_layer);
        this.fCx = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fCz = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fCy = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cGy = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cGy.setOnClickListener(this.mClickListener);
        this.fCw.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.j(this.fCx, d.C0140d.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.j(this.fCy, d.C0140d.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.i(this.cGy, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.am.c(this.cGy, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.c(this.fBY, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCk, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCs, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCt, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCu, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCl, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCm, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCo, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCr, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCn, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCp, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCq, d.C0140d.cp_cont_f, 1);
        this.fCx.setHorizontalSpacing(((((WindowManager) this.fCv.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fBY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fCk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fCs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fCt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fCl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fCA) {
            this.fCm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fCm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fCo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fCr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fCn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fCq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fCB) {
            this.fCp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fCp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fCu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fCz != null) {
            this.fCz.onChangeSkinType();
        }
    }
}
