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
public class z extends com.baidu.adp.base.c<PbActivity> {
    private Runnable bxw;
    private TextView deA;
    private TextView fRA;
    private TextView fRB;
    private TextView fRC;
    private TextView fRD;
    private TextView fRE;
    private TextView fRF;
    private TextView fRG;
    private TextView fRH;
    private TextView fRI;
    private PbActivity fRJ;
    private View fRK;
    private FlowLayout fRL;
    private LinearLayout fRM;
    private TextSizeSeekBar fRN;
    public boolean fRO;
    public boolean fRP;
    private TextView fRm;
    private TextView fRy;
    private TextView fRz;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fRm = null;
        this.fRy = null;
        this.fRG = null;
        this.fRJ = null;
        this.mClickListener = null;
        this.fRJ = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bdY() {
        return this.fRm;
    }

    public TextView beg() {
        return this.fRy;
    }

    public TextView beh() {
        return this.fRG;
    }

    public TextView getCancelView() {
        return this.deA;
    }

    public View bei() {
        return this.fRK;
    }

    public TextView bej() {
        return this.fRI;
    }

    public TextView bek() {
        return this.fRC;
    }

    public TextView bel() {
        return this.fRA;
    }

    public TextView bem() {
        return this.fRF;
    }

    public TextView ben() {
        return this.fRz;
    }

    public TextView beo() {
        return this.fRB;
    }

    public TextView bep() {
        return this.fRD;
    }

    public TextView beq() {
        return this.fRE;
    }

    public TextView ber() {
        return this.fRH;
    }

    public void bes() {
        if (this.bxw == null) {
            this.bxw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.fRK.setBackgroundColor(z.this.fRJ.getResources().getColor(d.C0141d.common_color_10082));
                }
            };
        }
        this.fRK.postDelayed(this.bxw, 200L);
    }

    public void bet() {
        this.fRK.setBackgroundColor(this.fRJ.getResources().getColor(d.C0141d.common_color_10022));
    }

    public void release() {
        this.fRK.removeCallbacks(this.bxw);
    }

    public void kx(boolean z) {
        if (z) {
            this.fRG.setVisibility(0);
        } else {
            this.fRG.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.fRH.setVisibility(0);
            this.fRH.setText(str);
            return;
        }
        this.fRH.setVisibility(8);
    }

    public void ky(boolean z) {
        this.fRm.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.fRI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRI.setText(d.j.group_info_intro_more);
        } else {
            this.fRI.setText(d.j.view_host);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fRC.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRC.setText(d.j.cancel_top);
        } else {
            this.fRC.setText(d.j.top);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fRF.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRF.setText(d.j.cancel_good);
        } else {
            this.fRF.setText(d.j.commit_good);
        }
    }

    public void kz(boolean z) {
        this.fRA.setVisibility(z ? 0 : 8);
    }

    public void kA(boolean z) {
        this.fRz.setVisibility(z ? 0 : 8);
    }

    public void kB(boolean z) {
        this.fRB.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.fRD.setVisibility(z ? 0 : 8);
        this.fRP = z2;
        if (z2) {
            this.fRD.setText(d.j.view_reverse);
        } else {
            this.fRD.setText(d.j.default_sort);
        }
    }

    public void O(boolean z, boolean z2) {
        this.fRE.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRE.setText(d.j.normal_mode);
        } else {
            this.fRE.setText(d.j.eyeshield_mode);
        }
    }

    public void kC(boolean z) {
        this.fRy.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fRJ.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fRm = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fRm.setOnClickListener(this.mClickListener);
        this.fRy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fRy.setOnClickListener(this.mClickListener);
        this.fRG = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fRG.setOnClickListener(this.mClickListener);
        this.fRH = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fRH.setOnClickListener(this.mClickListener);
        this.fRz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fRz.setOnClickListener(this.mClickListener);
        this.fRA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fRA.setOnClickListener(this.mClickListener);
        this.fRB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fRB.setOnClickListener(this.mClickListener);
        this.fRD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fRD.setOnClickListener(this.mClickListener);
        this.fRE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fRE.setOnClickListener(this.mClickListener);
        this.fRC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fRC.setOnClickListener(this.mClickListener);
        this.fRF = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fRF.setOnClickListener(this.mClickListener);
        this.fRI = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fRI.setOnClickListener(this.mClickListener);
        this.fRK = this.mView.findViewById(d.g.pb_more_layer);
        this.fRL = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fRN = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fRM = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.deA = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.deA.setOnClickListener(this.mClickListener);
        this.fRK.setOnClickListener(this.mClickListener);
    }

    public void amI() {
        com.baidu.tbadk.core.util.aj.t(this.fRL, d.C0141d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.t(this.fRM, d.C0141d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.s(this.deA, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.e(this.deA, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRm, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRy, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRG, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRH, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRI, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRz, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRA, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRC, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRF, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRB, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRD, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRE, d.C0141d.cp_cont_f, 1);
        this.fRL.setHorizontalSpacing(((((WindowManager) this.fRJ.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fRm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fRy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fRG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fRH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fRz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fRO) {
            this.fRA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fRC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fRF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fRB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fRE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fRP) {
            this.fRD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fRI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fRN != null) {
            this.fRN.onChangeSkinType();
        }
    }
}
