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
    private TextView cwq;
    private TextView flA;
    private TextView flB;
    private TextView flC;
    private TextView flD;
    private TextView flE;
    private TextView flF;
    private TextView flG;
    private TextView flH;
    private PbActivity flI;
    private View flJ;
    private FlowLayout flK;
    private LinearLayout flL;
    private TextSizeSeekBar flM;
    public boolean flN;
    public boolean flO;
    private TextView fll;
    private TextView flx;
    private TextView fly;
    private TextView flz;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fll = null;
        this.flx = null;
        this.flF = null;
        this.flI = null;
        this.mClickListener = null;
        this.flI = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aYV() {
        return this.fll;
    }

    public TextView aZd() {
        return this.flx;
    }

    public TextView aZe() {
        return this.flF;
    }

    public TextView getCancelView() {
        return this.cwq;
    }

    public View aZf() {
        return this.flJ;
    }

    public TextView aZg() {
        return this.flH;
    }

    public TextView aZh() {
        return this.flB;
    }

    public TextView aZi() {
        return this.flz;
    }

    public TextView aZj() {
        return this.flE;
    }

    public TextView aZk() {
        return this.fly;
    }

    public TextView aZl() {
        return this.flA;
    }

    public TextView aZm() {
        return this.flC;
    }

    public TextView aZn() {
        return this.flD;
    }

    public TextView aZo() {
        return this.flG;
    }

    public void aZp() {
        if (this.aHT == null) {
            this.aHT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.flJ.setBackgroundColor(z.this.flI.getResources().getColor(d.C0126d.common_color_10082));
                }
            };
        }
        this.flJ.postDelayed(this.aHT, 200L);
    }

    public void aZq() {
        this.flJ.setBackgroundColor(this.flI.getResources().getColor(d.C0126d.common_color_10022));
    }

    public void release() {
        this.flJ.removeCallbacks(this.aHT);
    }

    public void jT(boolean z) {
        if (z) {
            this.flF.setVisibility(0);
        } else {
            this.flF.setVisibility(8);
        }
    }

    public void m(boolean z, String str) {
        if (z) {
            this.flG.setVisibility(0);
            this.flG.setText(str);
            return;
        }
        this.flG.setVisibility(8);
    }

    public void jU(boolean z) {
        this.fll.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.flH.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flH.setText(d.k.group_info_intro_more);
        } else {
            this.flH.setText(d.k.view_host);
        }
    }

    public void G(boolean z, boolean z2) {
        this.flB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flB.setText(d.k.cancel_top);
        } else {
            this.flB.setText(d.k.top);
        }
    }

    public void H(boolean z, boolean z2) {
        this.flE.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flE.setText(d.k.cancel_good);
        } else {
            this.flE.setText(d.k.commit_good);
        }
    }

    public void jV(boolean z) {
        this.flz.setVisibility(z ? 0 : 8);
    }

    public void jW(boolean z) {
        this.fly.setVisibility(z ? 0 : 8);
    }

    public void jX(boolean z) {
        this.flA.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.flC.setVisibility(z ? 0 : 8);
        this.flO = z2;
        if (z2) {
            this.flC.setText(d.k.view_reverse);
        } else {
            this.flC.setText(d.k.default_sort);
        }
    }

    public void J(boolean z, boolean z2) {
        this.flD.setVisibility(z ? 0 : 8);
        if (z2) {
            this.flD.setText(d.k.normal_mode);
        } else {
            this.flD.setText(d.k.eyeshield_mode);
        }
    }

    public void jY(boolean z) {
        this.flx.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.flI.getPageContext().getPageActivity()).inflate(d.i.pb_more_pop_view, (ViewGroup) null);
        this.fll = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fll.setOnClickListener(this.mClickListener);
        this.flx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.flx.setOnClickListener(this.mClickListener);
        this.flF = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.flF.setOnClickListener(this.mClickListener);
        this.flG = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.flG.setOnClickListener(this.mClickListener);
        this.fly = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fly.setOnClickListener(this.mClickListener);
        this.flz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.flz.setOnClickListener(this.mClickListener);
        this.flA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.flA.setOnClickListener(this.mClickListener);
        this.flC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.flC.setOnClickListener(this.mClickListener);
        this.flD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.flD.setOnClickListener(this.mClickListener);
        this.flB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.flB.setOnClickListener(this.mClickListener);
        this.flE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.flE.setOnClickListener(this.mClickListener);
        this.flH = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.flH.setOnClickListener(this.mClickListener);
        this.flJ = this.mView.findViewById(d.g.pb_more_layer);
        this.flK = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.flM = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.flL = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cwq = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cwq.setOnClickListener(this.mClickListener);
        this.flJ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.ak.j(this.flK, d.C0126d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ak.j(this.flL, d.C0126d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ak.i(this.cwq, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ak.c(this.cwq, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ak.c(this.fll, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flx, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flF, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flG, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flH, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fly, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flz, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flB, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flE, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flA, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flC, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.flD, d.C0126d.cp_cont_f, 1);
        this.flK.setHorizontalSpacing(((((WindowManager) this.flI.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fll.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.flx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.flF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.flG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fly.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.flN) {
            this.flz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.flz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.flB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.flE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.flA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.flD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.flO) {
            this.flC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.flC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.flH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.flM != null) {
            this.flM.onChangeSkinType();
        }
    }
}
