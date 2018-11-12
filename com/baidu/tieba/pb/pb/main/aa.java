package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes6.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aZO;
    private TextView fSB;
    private TextView fSO;
    private TextView fSP;
    private TextView fSQ;
    private TextView fSR;
    private TextView fSS;
    private TextView fST;
    private TextView fSU;
    private TextView fSV;
    private TextView fSW;
    private TextView fSX;
    private TextView fSY;
    private PbActivity fSZ;
    private View fTa;
    private FlowLayout fTb;
    private LinearLayout fTc;
    private TextSizeSeekBar fTd;
    public boolean fTe;
    public boolean fTf;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fSB = null;
        this.fSO = null;
        this.fSW = null;
        this.fSZ = null;
        this.mClickListener = null;
        this.fSZ = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bhY() {
        return this.fSB;
    }

    public TextView big() {
        return this.fSO;
    }

    public TextView bih() {
        return this.fSW;
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View bii() {
        return this.fTa;
    }

    public TextView bij() {
        return this.fSY;
    }

    public TextView bik() {
        return this.fSS;
    }

    public TextView bil() {
        return this.fSQ;
    }

    public TextView bim() {
        return this.fSV;
    }

    public TextView bin() {
        return this.fSP;
    }

    public TextView bio() {
        return this.fSR;
    }

    public TextView bip() {
        return this.fST;
    }

    public TextView biq() {
        return this.fSU;
    }

    public TextView bir() {
        return this.fSX;
    }

    public void bis() {
        if (this.aZO == null) {
            this.aZO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fTa.setBackgroundColor(aa.this.fSZ.getResources().getColor(e.d.common_color_10082));
                }
            };
        }
        this.fTa.postDelayed(this.aZO, 200L);
    }

    public void bit() {
        this.fTa.setBackgroundColor(this.fSZ.getResources().getColor(e.d.common_color_10022));
    }

    public void release() {
        this.fTa.removeCallbacks(this.aZO);
    }

    public void kW(boolean z) {
        if (z) {
            this.fSW.setVisibility(0);
        } else {
            this.fSW.setVisibility(8);
        }
    }

    public void q(boolean z, String str) {
        if (z) {
            this.fSX.setVisibility(0);
            this.fSX.setText(str);
            return;
        }
        this.fSX.setVisibility(8);
    }

    public void kX(boolean z) {
        this.fSB.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.fSY.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fSY.setText(e.j.group_info_intro_more);
        } else {
            this.fSY.setText(e.j.view_host);
        }
    }

    public void O(boolean z, boolean z2) {
        this.fSS.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fSS.setText(e.j.cancel_top);
        } else {
            this.fSS.setText(e.j.top);
        }
    }

    public void P(boolean z, boolean z2) {
        this.fSV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fSV.setText(e.j.cancel_good);
        } else {
            this.fSV.setText(e.j.commit_good);
        }
    }

    public void kY(boolean z) {
        this.fSQ.setVisibility(z ? 0 : 8);
    }

    public void kZ(boolean z) {
        this.fSP.setVisibility(z ? 0 : 8);
    }

    public void la(boolean z) {
        this.fSR.setVisibility(z ? 0 : 8);
    }

    public void Q(boolean z, boolean z2) {
        this.fST.setVisibility(z ? 0 : 8);
        this.fTf = z2;
        if (z2) {
            this.fST.setText(e.j.view_reverse);
        } else {
            this.fST.setText(e.j.default_sort);
        }
        this.fST.setText(e.j.sort_selector);
    }

    public void R(boolean z, boolean z2) {
        this.fSU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fSU.setText(e.j.normal_mode);
        } else {
            this.fSU.setText(e.j.eyeshield_mode);
        }
    }

    public void lb(boolean z) {
        this.fSO.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fSZ.getPageContext().getPageActivity()).inflate(e.h.pb_more_pop_view, (ViewGroup) null);
        this.fSB = (TextView) this.mView.findViewById(e.g.pb_more_view_item_mark);
        this.fSB.setOnClickListener(this.mClickListener);
        this.fSO = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump);
        this.fSO.setOnClickListener(this.mClickListener);
        this.fSW = (TextView) this.mView.findViewById(e.g.pb_more_view_item_report);
        this.fSW.setOnClickListener(this.mClickListener);
        this.fSX = (TextView) this.mView.findViewById(e.g.pb_more_view_item_fans_call);
        this.fSX.setOnClickListener(this.mClickListener);
        this.fSP = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump_top);
        this.fSP.setOnClickListener(this.mClickListener);
        this.fSQ = (TextView) this.mView.findViewById(e.g.pb_more_view_item_delete);
        this.fSQ.setOnClickListener(this.mClickListener);
        this.fSR = (TextView) this.mView.findViewById(e.g.pb_more_view_item_forbidden);
        this.fSR.setOnClickListener(this.mClickListener);
        this.fST = (TextView) this.mView.findViewById(e.g.pb_more_view_item_reversed);
        this.fST.setOnClickListener(this.mClickListener);
        this.fSU = (TextView) this.mView.findViewById(e.g.pb_more_view_item_night_style);
        this.fSU.setOnClickListener(this.mClickListener);
        this.fSS = (TextView) this.mView.findViewById(e.g.pb_more_view_item_make_top);
        this.fSS.setOnClickListener(this.mClickListener);
        this.fSV = (TextView) this.mView.findViewById(e.g.pb_more_view_item_add_good);
        this.fSV.setOnClickListener(this.mClickListener);
        this.fSY = (TextView) this.mView.findViewById(e.g.pb_more_view_item_host_only);
        this.fSY.setOnClickListener(this.mClickListener);
        this.fTa = this.mView.findViewById(e.g.pb_more_layer);
        this.fTb = (FlowLayout) this.mView.findViewById(e.g.pb_more_flowlayout);
        this.fTd = (TextSizeSeekBar) this.mView.findViewById(e.g.pb_more_text_size_seekbar);
        this.fTc = (LinearLayout) this.mView.findViewById(e.g.size_seek_bar_group);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.pb_more_cancel);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.fTa.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.fTb, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fTc, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.mCancelView, e.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.fSB, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSO, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSW, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSX, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSY, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSP, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSQ, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSS, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSV, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSR, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fST, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fSU, e.d.cp_cont_f, 1);
        this.fTb.setHorizontalSpacing(((((WindowManager) this.fSZ.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds100) * 5)) / 4);
        this.fSB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fSW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fSX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fSP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fTe) {
            this.fSQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fSQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fSS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fSV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fSR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fSU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        this.fST.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        this.fSY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fTd != null) {
            this.fTd.onChangeSkinType();
        }
    }
}
