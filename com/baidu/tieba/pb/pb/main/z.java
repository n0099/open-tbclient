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
    private Runnable aHT;
    private TextView cwn;
    private TextView flA;
    private TextView flB;
    private TextView flC;
    private TextView flD;
    private TextView flE;
    private PbActivity flF;
    private View flG;
    private FlowLayout flH;
    private LinearLayout flI;
    private TextSizeSeekBar flJ;
    public boolean flK;
    public boolean flL;
    private TextView fli;
    private TextView flu;
    private TextView flv;
    private TextView flw;
    private TextView flx;
    private TextView fly;
    private TextView flz;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fli = null;
        this.flu = null;
        this.flC = null;
        this.flF = null;
        this.mClickListener = null;
        this.flF = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aYV() {
        return this.fli;
    }

    public TextView aZd() {
        return this.flu;
    }

    public TextView aZe() {
        return this.flC;
    }

    public TextView getCancelView() {
        return this.cwn;
    }

    public View aZf() {
        return this.flG;
    }

    public TextView aZg() {
        return this.flE;
    }

    public TextView aZh() {
        return this.fly;
    }

    public TextView aZi() {
        return this.flw;
    }

    public TextView aZj() {
        return this.flB;
    }

    public TextView aZk() {
        return this.flv;
    }

    public TextView aZl() {
        return this.flx;
    }

    public TextView aZm() {
        return this.flz;
    }

    public TextView aZn() {
        return this.flA;
    }

    public TextView aZo() {
        return this.flD;
    }

    public void aZp() {
        if (this.aHT == null) {
            this.aHT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.flG.setBackgroundColor(z.this.flF.getResources().getColor(d.C0126d.common_color_10082));
                }
            };
        }
        this.flG.postDelayed(this.aHT, 200L);
    }

    public void aZq() {
        this.flG.setBackgroundColor(this.flF.getResources().getColor(d.C0126d.common_color_10022));
    }

    public void release() {
        this.flG.removeCallbacks(this.aHT);
    }

    public void jT(boolean z) {
        if (z) {
            this.flC.setVisibility(0);
        } else {
            this.flC.setVisibility(8);
        }
    }

    public void m(boolean z, String str) {
        if (z) {
            this.flD.setVisibility(0);
            this.flD.setText(str);
            return;
        }
        this.flD.setVisibility(8);
    }

    public void jU(boolean z) {
        this.fli.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.flE.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flE.setText(d.k.group_info_intro_more);
        } else {
            this.flE.setText(d.k.view_host);
        }
    }

    public void G(boolean z, boolean z2) {
        this.fly.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fly.setText(d.k.cancel_top);
        } else {
            this.fly.setText(d.k.top);
        }
    }

    public void H(boolean z, boolean z2) {
        this.flB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flB.setText(d.k.cancel_good);
        } else {
            this.flB.setText(d.k.commit_good);
        }
    }

    public void jV(boolean z) {
        this.flw.setVisibility(z ? 0 : 8);
    }

    public void jW(boolean z) {
        this.flv.setVisibility(z ? 0 : 8);
    }

    public void jX(boolean z) {
        this.flx.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.flz.setVisibility(z ? 0 : 8);
        this.flL = z2;
        if (z2) {
            this.flz.setText(d.k.view_reverse);
        } else {
            this.flz.setText(d.k.default_sort);
        }
    }

    public void J(boolean z, boolean z2) {
        this.flA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flA.setText(d.k.normal_mode);
        } else {
            this.flA.setText(d.k.eyeshield_mode);
        }
    }

    public void jY(boolean z) {
        this.flu.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.flF.getPageContext().getPageActivity()).inflate(d.i.pb_more_pop_view, (ViewGroup) null);
        this.fli = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fli.setOnClickListener(this.mClickListener);
        this.flu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.flu.setOnClickListener(this.mClickListener);
        this.flC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.flC.setOnClickListener(this.mClickListener);
        this.flD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.flD.setOnClickListener(this.mClickListener);
        this.flv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.flv.setOnClickListener(this.mClickListener);
        this.flw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.flw.setOnClickListener(this.mClickListener);
        this.flx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.flx.setOnClickListener(this.mClickListener);
        this.flz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.flz.setOnClickListener(this.mClickListener);
        this.flA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.flA.setOnClickListener(this.mClickListener);
        this.fly = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fly.setOnClickListener(this.mClickListener);
        this.flB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.flB.setOnClickListener(this.mClickListener);
        this.flE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.flE.setOnClickListener(this.mClickListener);
        this.flG = this.mView.findViewById(d.g.pb_more_layer);
        this.flH = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.flJ = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.flI = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cwn = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cwn.setOnClickListener(this.mClickListener);
        this.flG.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.ak.j(this.flH, d.C0126d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ak.j(this.flI, d.C0126d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ak.i(this.cwn, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ak.c(this.cwn, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ak.c(this.fli, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flu, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flC, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flD, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flE, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flv, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flw, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fly, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flB, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flx, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flz, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flA, d.C0126d.cp_cont_f, 1);
        this.flH.setHorizontalSpacing(((((WindowManager) this.flF.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fli.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.flu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.flC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.flD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.flv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.flK) {
            this.flw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.flw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fly.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.flB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.flx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.flA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.flL) {
            this.flz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.flz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.flE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.flJ != null) {
            this.flJ.onChangeSkinType();
        }
    }
}
