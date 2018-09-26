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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aUC;
    private TextView cMm;
    private TextView fJA;
    private TextView fJN;
    private TextView fJO;
    private TextView fJP;
    private TextView fJQ;
    private TextView fJR;
    private TextView fJS;
    private TextView fJT;
    private TextView fJU;
    private TextView fJV;
    private TextView fJW;
    private TextView fJX;
    private PbActivity fJY;
    private View fJZ;
    private FlowLayout fKa;
    private LinearLayout fKb;
    private TextSizeSeekBar fKc;
    public boolean fKd;
    public boolean fKe;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fJA = null;
        this.fJN = null;
        this.fJV = null;
        this.fJY = null;
        this.mClickListener = null;
        this.fJY = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bfp() {
        return this.fJA;
    }

    public TextView bfx() {
        return this.fJN;
    }

    public TextView bfy() {
        return this.fJV;
    }

    public TextView getCancelView() {
        return this.cMm;
    }

    public View bfz() {
        return this.fJZ;
    }

    public TextView bfA() {
        return this.fJX;
    }

    public TextView bfB() {
        return this.fJR;
    }

    public TextView bfC() {
        return this.fJP;
    }

    public TextView bfD() {
        return this.fJU;
    }

    public TextView bfE() {
        return this.fJO;
    }

    public TextView bfF() {
        return this.fJQ;
    }

    public TextView bfG() {
        return this.fJS;
    }

    public TextView bfH() {
        return this.fJT;
    }

    public TextView bfI() {
        return this.fJW;
    }

    public void bfJ() {
        if (this.aUC == null) {
            this.aUC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fJZ.setBackgroundColor(aa.this.fJY.getResources().getColor(e.d.common_color_10082));
                }
            };
        }
        this.fJZ.postDelayed(this.aUC, 200L);
    }

    public void bfK() {
        this.fJZ.setBackgroundColor(this.fJY.getResources().getColor(e.d.common_color_10022));
    }

    public void release() {
        this.fJZ.removeCallbacks(this.aUC);
    }

    public void ku(boolean z) {
        if (z) {
            this.fJV.setVisibility(0);
        } else {
            this.fJV.setVisibility(8);
        }
    }

    public void r(boolean z, String str) {
        if (z) {
            this.fJW.setVisibility(0);
            this.fJW.setText(str);
            return;
        }
        this.fJW.setVisibility(8);
    }

    public void kv(boolean z) {
        this.fJA.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.fJX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fJX.setText(e.j.group_info_intro_more);
        } else {
            this.fJX.setText(e.j.view_host);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fJR.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fJR.setText(e.j.cancel_top);
        } else {
            this.fJR.setText(e.j.top);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fJU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fJU.setText(e.j.cancel_good);
        } else {
            this.fJU.setText(e.j.commit_good);
        }
    }

    public void kw(boolean z) {
        this.fJP.setVisibility(z ? 0 : 8);
    }

    public void kx(boolean z) {
        this.fJO.setVisibility(z ? 0 : 8);
    }

    public void ky(boolean z) {
        this.fJQ.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.fJS.setVisibility(z ? 0 : 8);
        this.fKe = z2;
        if (z2) {
            this.fJS.setText(e.j.view_reverse);
        } else {
            this.fJS.setText(e.j.default_sort);
        }
        this.fJS.setText(e.j.sort_selector);
    }

    public void O(boolean z, boolean z2) {
        this.fJT.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fJT.setText(e.j.normal_mode);
        } else {
            this.fJT.setText(e.j.eyeshield_mode);
        }
    }

    public void kz(boolean z) {
        this.fJN.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fJY.getPageContext().getPageActivity()).inflate(e.h.pb_more_pop_view, (ViewGroup) null);
        this.fJA = (TextView) this.mView.findViewById(e.g.pb_more_view_item_mark);
        this.fJA.setOnClickListener(this.mClickListener);
        this.fJN = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump);
        this.fJN.setOnClickListener(this.mClickListener);
        this.fJV = (TextView) this.mView.findViewById(e.g.pb_more_view_item_report);
        this.fJV.setOnClickListener(this.mClickListener);
        this.fJW = (TextView) this.mView.findViewById(e.g.pb_more_view_item_fans_call);
        this.fJW.setOnClickListener(this.mClickListener);
        this.fJO = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump_top);
        this.fJO.setOnClickListener(this.mClickListener);
        this.fJP = (TextView) this.mView.findViewById(e.g.pb_more_view_item_delete);
        this.fJP.setOnClickListener(this.mClickListener);
        this.fJQ = (TextView) this.mView.findViewById(e.g.pb_more_view_item_forbidden);
        this.fJQ.setOnClickListener(this.mClickListener);
        this.fJS = (TextView) this.mView.findViewById(e.g.pb_more_view_item_reversed);
        this.fJS.setOnClickListener(this.mClickListener);
        this.fJT = (TextView) this.mView.findViewById(e.g.pb_more_view_item_night_style);
        this.fJT.setOnClickListener(this.mClickListener);
        this.fJR = (TextView) this.mView.findViewById(e.g.pb_more_view_item_make_top);
        this.fJR.setOnClickListener(this.mClickListener);
        this.fJU = (TextView) this.mView.findViewById(e.g.pb_more_view_item_add_good);
        this.fJU.setOnClickListener(this.mClickListener);
        this.fJX = (TextView) this.mView.findViewById(e.g.pb_more_view_item_host_only);
        this.fJX.setOnClickListener(this.mClickListener);
        this.fJZ = this.mView.findViewById(e.g.pb_more_layer);
        this.fKa = (FlowLayout) this.mView.findViewById(e.g.pb_more_flowlayout);
        this.fKc = (TextSizeSeekBar) this.mView.findViewById(e.g.pb_more_text_size_seekbar);
        this.fKb = (LinearLayout) this.mView.findViewById(e.g.size_seek_bar_group);
        this.cMm = (TextView) this.mView.findViewById(e.g.pb_more_cancel);
        this.cMm.setOnClickListener(this.mClickListener);
        this.fJZ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.fKa, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fKb, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.cMm, e.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.cMm, e.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.fJA, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJN, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJV, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJW, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJX, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJO, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJP, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJR, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJU, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJQ, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJS, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fJT, e.d.cp_cont_f, 1);
        this.fKa.setHorizontalSpacing(((((WindowManager) this.fJY.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0141e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0141e.ds100) * 5)) / 4);
        this.fJA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fJN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fJV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fJW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fJO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fKd) {
            this.fJP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fJP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fJR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fJU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fJQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fJT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        this.fJS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        this.fJX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fKc != null) {
            this.fKc.onChangeSkinType();
        }
    }
}
