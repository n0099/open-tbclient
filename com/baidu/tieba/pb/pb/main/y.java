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
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aGA;
    private TextView bZq;
    private TextView ePA;
    private PbActivity ePB;
    private View ePC;
    private FlowLayout ePD;
    private LinearLayout ePE;
    private TextSizeSeekBar ePF;
    public boolean ePG;
    public boolean ePH;
    private TextView ePf;
    private TextView ePq;
    private TextView ePr;
    private TextView ePs;
    private TextView ePt;
    private TextView ePu;
    private TextView ePv;
    private TextView ePw;
    private TextView ePx;
    private TextView ePy;
    private TextView ePz;
    private View.OnClickListener mClickListener;
    private View mView;

    public y(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.ePf = null;
        this.ePq = null;
        this.ePy = null;
        this.ePB = null;
        this.mClickListener = null;
        this.ePB = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aTk() {
        return this.ePf;
    }

    public TextView aTs() {
        return this.ePq;
    }

    public TextView aTt() {
        return this.ePy;
    }

    public TextView getCancelView() {
        return this.bZq;
    }

    public View aTu() {
        return this.ePC;
    }

    public TextView aTv() {
        return this.ePA;
    }

    public TextView aTw() {
        return this.ePu;
    }

    public TextView aTx() {
        return this.ePs;
    }

    public TextView aTy() {
        return this.ePx;
    }

    public TextView aTz() {
        return this.ePr;
    }

    public TextView aTA() {
        return this.ePt;
    }

    public TextView aTB() {
        return this.ePv;
    }

    public TextView aTC() {
        return this.ePw;
    }

    public TextView aTD() {
        return this.ePz;
    }

    public void aTE() {
        if (this.aGA == null) {
            this.aGA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.ePC.setBackgroundColor(y.this.ePB.getResources().getColor(d.C0080d.common_color_10082));
                }
            };
        }
        this.ePC.postDelayed(this.aGA, 200L);
    }

    public void aTF() {
        this.ePC.setBackgroundColor(this.ePB.getResources().getColor(d.C0080d.common_color_10022));
    }

    public void release() {
        this.ePC.removeCallbacks(this.aGA);
    }

    public void ja(boolean z) {
        if (z) {
            this.ePy.setVisibility(0);
        } else {
            this.ePy.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.ePz.setVisibility(0);
            this.ePz.setText(str);
            return;
        }
        this.ePz.setVisibility(8);
    }

    public void jb(boolean z) {
        this.ePf.setVisibility(z ? 0 : 8);
    }

    public void H(boolean z, boolean z2) {
        this.ePA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePA.setText(d.j.group_info_intro_more);
        } else {
            this.ePA.setText(d.j.view_host);
        }
    }

    public void I(boolean z, boolean z2) {
        this.ePu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePu.setText(d.j.cancel_top);
        } else {
            this.ePu.setText(d.j.top);
        }
    }

    public void J(boolean z, boolean z2) {
        this.ePx.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePx.setText(d.j.cancel_good);
        } else {
            this.ePx.setText(d.j.commit_good);
        }
    }

    public void jc(boolean z) {
        this.ePs.setVisibility(z ? 0 : 8);
    }

    public void jd(boolean z) {
        this.ePr.setVisibility(z ? 0 : 8);
    }

    public void je(boolean z) {
        this.ePt.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.ePv.setVisibility(z ? 0 : 8);
        this.ePH = z2;
        if (z2) {
            this.ePv.setText(d.j.view_reverse);
        } else {
            this.ePv.setText(d.j.default_sort);
        }
    }

    public void L(boolean z, boolean z2) {
        this.ePw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.ePw.setText(d.j.normal_mode);
        } else {
            this.ePw.setText(d.j.eyeshield_mode);
        }
    }

    public void jf(boolean z) {
        this.ePq.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ePB.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.ePf = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.ePf.setOnClickListener(this.mClickListener);
        this.ePq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.ePq.setOnClickListener(this.mClickListener);
        this.ePy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.ePy.setOnClickListener(this.mClickListener);
        this.ePz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.ePz.setOnClickListener(this.mClickListener);
        this.ePr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.ePr.setOnClickListener(this.mClickListener);
        this.ePs = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.ePs.setOnClickListener(this.mClickListener);
        this.ePt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.ePt.setOnClickListener(this.mClickListener);
        this.ePv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.ePv.setOnClickListener(this.mClickListener);
        this.ePw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.ePw.setOnClickListener(this.mClickListener);
        this.ePu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.ePu.setOnClickListener(this.mClickListener);
        this.ePx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.ePx.setOnClickListener(this.mClickListener);
        this.ePA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.ePA.setOnClickListener(this.mClickListener);
        this.ePC = this.mView.findViewById(d.g.pb_more_layer);
        this.ePD = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.ePF = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.ePE = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.bZq = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.bZq.setOnClickListener(this.mClickListener);
        this.ePC.setOnClickListener(this.mClickListener);
    }

    public void abh() {
        com.baidu.tbadk.core.util.aj.k(this.ePD, d.C0080d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.ePE, d.C0080d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.j(this.bZq, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.bZq, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePf, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePq, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePy, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePz, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePA, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePr, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePs, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePu, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePx, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePt, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePv, d.C0080d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.c(this.ePw, d.C0080d.cp_cont_f, 1);
        this.ePD.setHorizontalSpacing(((((WindowManager) this.ePB.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.ePf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.ePq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.ePy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.ePz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.ePr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.ePG) {
            this.ePs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.ePs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.ePu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.ePx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.ePt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.ePw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.ePH) {
            this.ePv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        } else {
            this.ePv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        }
        this.ePA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.ePF != null) {
            this.ePF.onChangeSkinType();
        }
    }
}
