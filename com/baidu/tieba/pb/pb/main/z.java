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
    private Runnable aHU;
    private TextView cxw;
    private TextView fmB;
    private TextView fmC;
    private TextView fmD;
    private TextView fmE;
    private TextView fmF;
    private TextView fmG;
    private TextView fmH;
    private TextView fmI;
    private TextView fmJ;
    private TextView fmK;
    private TextView fmL;
    private PbActivity fmM;
    private View fmN;
    private FlowLayout fmO;
    private LinearLayout fmP;
    private TextSizeSeekBar fmQ;
    public boolean fmR;
    public boolean fmS;
    private TextView fmp;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fmp = null;
        this.fmB = null;
        this.fmJ = null;
        this.fmM = null;
        this.mClickListener = null;
        this.fmM = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aYV() {
        return this.fmp;
    }

    public TextView aZd() {
        return this.fmB;
    }

    public TextView aZe() {
        return this.fmJ;
    }

    public TextView getCancelView() {
        return this.cxw;
    }

    public View aZf() {
        return this.fmN;
    }

    public TextView aZg() {
        return this.fmL;
    }

    public TextView aZh() {
        return this.fmF;
    }

    public TextView aZi() {
        return this.fmD;
    }

    public TextView aZj() {
        return this.fmI;
    }

    public TextView aZk() {
        return this.fmC;
    }

    public TextView aZl() {
        return this.fmE;
    }

    public TextView aZm() {
        return this.fmG;
    }

    public TextView aZn() {
        return this.fmH;
    }

    public TextView aZo() {
        return this.fmK;
    }

    public void aZp() {
        if (this.aHU == null) {
            this.aHU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.fmN.setBackgroundColor(z.this.fmM.getResources().getColor(d.C0126d.common_color_10082));
                }
            };
        }
        this.fmN.postDelayed(this.aHU, 200L);
    }

    public void aZq() {
        this.fmN.setBackgroundColor(this.fmM.getResources().getColor(d.C0126d.common_color_10022));
    }

    public void release() {
        this.fmN.removeCallbacks(this.aHU);
    }

    public void jU(boolean z) {
        if (z) {
            this.fmJ.setVisibility(0);
        } else {
            this.fmJ.setVisibility(8);
        }
    }

    public void m(boolean z, String str) {
        if (z) {
            this.fmK.setVisibility(0);
            this.fmK.setText(str);
            return;
        }
        this.fmK.setVisibility(8);
    }

    public void jV(boolean z) {
        this.fmp.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.fmL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fmL.setText(d.k.group_info_intro_more);
        } else {
            this.fmL.setText(d.k.view_host);
        }
    }

    public void G(boolean z, boolean z2) {
        this.fmF.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fmF.setText(d.k.cancel_top);
        } else {
            this.fmF.setText(d.k.top);
        }
    }

    public void H(boolean z, boolean z2) {
        this.fmI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fmI.setText(d.k.cancel_good);
        } else {
            this.fmI.setText(d.k.commit_good);
        }
    }

    public void jW(boolean z) {
        this.fmD.setVisibility(z ? 0 : 8);
    }

    public void jX(boolean z) {
        this.fmC.setVisibility(z ? 0 : 8);
    }

    public void jY(boolean z) {
        this.fmE.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.fmG.setVisibility(z ? 0 : 8);
        this.fmS = z2;
        if (z2) {
            this.fmG.setText(d.k.view_reverse);
        } else {
            this.fmG.setText(d.k.default_sort);
        }
    }

    public void J(boolean z, boolean z2) {
        this.fmH.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fmH.setText(d.k.normal_mode);
        } else {
            this.fmH.setText(d.k.eyeshield_mode);
        }
    }

    public void jZ(boolean z) {
        this.fmB.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fmM.getPageContext().getPageActivity()).inflate(d.i.pb_more_pop_view, (ViewGroup) null);
        this.fmp = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fmp.setOnClickListener(this.mClickListener);
        this.fmB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fmB.setOnClickListener(this.mClickListener);
        this.fmJ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fmJ.setOnClickListener(this.mClickListener);
        this.fmK = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fmK.setOnClickListener(this.mClickListener);
        this.fmC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fmC.setOnClickListener(this.mClickListener);
        this.fmD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fmD.setOnClickListener(this.mClickListener);
        this.fmE = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fmE.setOnClickListener(this.mClickListener);
        this.fmG = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fmG.setOnClickListener(this.mClickListener);
        this.fmH = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fmH.setOnClickListener(this.mClickListener);
        this.fmF = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fmF.setOnClickListener(this.mClickListener);
        this.fmI = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fmI.setOnClickListener(this.mClickListener);
        this.fmL = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fmL.setOnClickListener(this.mClickListener);
        this.fmN = this.mView.findViewById(d.g.pb_more_layer);
        this.fmO = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fmQ = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fmP = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cxw = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cxw.setOnClickListener(this.mClickListener);
        this.fmN.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.ak.j(this.fmO, d.C0126d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ak.j(this.fmP, d.C0126d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ak.i(this.cxw, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ak.c(this.cxw, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmp, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmB, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmJ, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmK, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmL, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmC, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmD, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmF, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmI, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmE, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmG, d.C0126d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ak.c(this.fmH, d.C0126d.cp_cont_f, 1);
        this.fmO.setHorizontalSpacing(((((WindowManager) this.fmM.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fmp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fmB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fmJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fmK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fmC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fmR) {
            this.fmD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fmD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fmF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fmI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fmE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fmH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fmS) {
            this.fmG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fmG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fmL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fmQ != null) {
            this.fmQ.onChangeSkinType();
        }
    }
}
