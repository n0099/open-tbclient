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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aRk;
    private TextView cGv;
    private TextView fBR;
    private TextView fCd;
    private TextView fCe;
    private TextView fCf;
    private TextView fCg;
    private TextView fCh;
    private TextView fCi;
    private TextView fCj;
    private TextView fCk;
    private TextView fCl;
    private TextView fCm;
    private TextView fCn;
    private PbActivity fCo;
    private View fCp;
    private FlowLayout fCq;
    private LinearLayout fCr;
    private TextSizeSeekBar fCs;
    public boolean fCt;
    public boolean fCu;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fBR = null;
        this.fCd = null;
        this.fCl = null;
        this.fCo = null;
        this.mClickListener = null;
        this.fCo = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bcP() {
        return this.fBR;
    }

    public TextView bcX() {
        return this.fCd;
    }

    public TextView bcY() {
        return this.fCl;
    }

    public TextView getCancelView() {
        return this.cGv;
    }

    public View bcZ() {
        return this.fCp;
    }

    public TextView bda() {
        return this.fCn;
    }

    public TextView bdb() {
        return this.fCh;
    }

    public TextView bdc() {
        return this.fCf;
    }

    public TextView bdd() {
        return this.fCk;
    }

    public TextView bde() {
        return this.fCe;
    }

    public TextView bdf() {
        return this.fCg;
    }

    public TextView bdg() {
        return this.fCi;
    }

    public TextView bdh() {
        return this.fCj;
    }

    public TextView bdi() {
        return this.fCm;
    }

    public void bdj() {
        if (this.aRk == null) {
            this.aRk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fCp.setBackgroundColor(aa.this.fCo.getResources().getColor(f.d.common_color_10082));
                }
            };
        }
        this.fCp.postDelayed(this.aRk, 200L);
    }

    public void bdk() {
        this.fCp.setBackgroundColor(this.fCo.getResources().getColor(f.d.common_color_10022));
    }

    public void release() {
        this.fCp.removeCallbacks(this.aRk);
    }

    public void jW(boolean z) {
        if (z) {
            this.fCl.setVisibility(0);
        } else {
            this.fCl.setVisibility(8);
        }
    }

    public void m(boolean z, String str) {
        if (z) {
            this.fCm.setVisibility(0);
            this.fCm.setText(str);
            return;
        }
        this.fCm.setVisibility(8);
    }

    public void jX(boolean z) {
        this.fBR.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.fCn.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCn.setText(f.j.group_info_intro_more);
        } else {
            this.fCn.setText(f.j.view_host);
        }
    }

    public void J(boolean z, boolean z2) {
        this.fCh.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCh.setText(f.j.cancel_top);
        } else {
            this.fCh.setText(f.j.top);
        }
    }

    public void K(boolean z, boolean z2) {
        this.fCk.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCk.setText(f.j.cancel_good);
        } else {
            this.fCk.setText(f.j.commit_good);
        }
    }

    public void jY(boolean z) {
        this.fCf.setVisibility(z ? 0 : 8);
    }

    public void jZ(boolean z) {
        this.fCe.setVisibility(z ? 0 : 8);
    }

    public void ka(boolean z) {
        this.fCg.setVisibility(z ? 0 : 8);
    }

    public void L(boolean z, boolean z2) {
        this.fCi.setVisibility(z ? 0 : 8);
        this.fCu = z2;
        if (z2) {
            this.fCi.setText(f.j.view_reverse);
        } else {
            this.fCi.setText(f.j.default_sort);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fCj.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCj.setText(f.j.normal_mode);
        } else {
            this.fCj.setText(f.j.eyeshield_mode);
        }
    }

    public void kb(boolean z) {
        this.fCd.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fCo.getPageContext().getPageActivity()).inflate(f.h.pb_more_pop_view, (ViewGroup) null);
        this.fBR = (TextView) this.mView.findViewById(f.g.pb_more_view_item_mark);
        this.fBR.setOnClickListener(this.mClickListener);
        this.fCd = (TextView) this.mView.findViewById(f.g.pb_more_view_item_jump);
        this.fCd.setOnClickListener(this.mClickListener);
        this.fCl = (TextView) this.mView.findViewById(f.g.pb_more_view_item_report);
        this.fCl.setOnClickListener(this.mClickListener);
        this.fCm = (TextView) this.mView.findViewById(f.g.pb_more_view_item_fans_call);
        this.fCm.setOnClickListener(this.mClickListener);
        this.fCe = (TextView) this.mView.findViewById(f.g.pb_more_view_item_jump_top);
        this.fCe.setOnClickListener(this.mClickListener);
        this.fCf = (TextView) this.mView.findViewById(f.g.pb_more_view_item_delete);
        this.fCf.setOnClickListener(this.mClickListener);
        this.fCg = (TextView) this.mView.findViewById(f.g.pb_more_view_item_forbidden);
        this.fCg.setOnClickListener(this.mClickListener);
        this.fCi = (TextView) this.mView.findViewById(f.g.pb_more_view_item_reversed);
        this.fCi.setOnClickListener(this.mClickListener);
        this.fCj = (TextView) this.mView.findViewById(f.g.pb_more_view_item_night_style);
        this.fCj.setOnClickListener(this.mClickListener);
        this.fCh = (TextView) this.mView.findViewById(f.g.pb_more_view_item_make_top);
        this.fCh.setOnClickListener(this.mClickListener);
        this.fCk = (TextView) this.mView.findViewById(f.g.pb_more_view_item_add_good);
        this.fCk.setOnClickListener(this.mClickListener);
        this.fCn = (TextView) this.mView.findViewById(f.g.pb_more_view_item_host_only);
        this.fCn.setOnClickListener(this.mClickListener);
        this.fCp = this.mView.findViewById(f.g.pb_more_layer);
        this.fCq = (FlowLayout) this.mView.findViewById(f.g.pb_more_flowlayout);
        this.fCs = (TextSizeSeekBar) this.mView.findViewById(f.g.pb_more_text_size_seekbar);
        this.fCr = (LinearLayout) this.mView.findViewById(f.g.size_seek_bar_group);
        this.cGv = (TextView) this.mView.findViewById(f.g.pb_more_cancel);
        this.cGv.setOnClickListener(this.mClickListener);
        this.fCp.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.j(this.fCq, f.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.j(this.fCr, f.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.i(this.cGv, f.C0146f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.am.c(this.cGv, f.C0146f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.c(this.fBR, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCd, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCl, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCm, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCn, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCe, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCf, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCh, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCk, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCg, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCi, f.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCj, f.d.cp_cont_f, 1);
        this.fCq.setHorizontalSpacing(((((WindowManager) this.fCo.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds100) * 5)) / 4);
        this.fBR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fCd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fCl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fCm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fCe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fCt) {
            this.fCf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fCf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fCh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fCk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fCg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fCj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fCu) {
            this.fCi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fCi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fCn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fCs != null) {
            this.fCs.onChangeSkinType();
        }
    }
}
