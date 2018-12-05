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
    private Runnable bdm;
    private TextView fZE;
    private TextView fZF;
    private TextView fZG;
    private TextView fZH;
    private TextView fZI;
    private TextView fZJ;
    private TextView fZK;
    private TextView fZL;
    private TextView fZM;
    private TextView fZN;
    private TextView fZO;
    private PbActivity fZP;
    private View fZQ;
    private FlowLayout fZR;
    private LinearLayout fZS;
    private TextSizeSeekBar fZT;
    public boolean fZU;
    public boolean fZV;
    private TextView fZr;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fZr = null;
        this.fZE = null;
        this.fZM = null;
        this.fZP = null;
        this.mClickListener = null;
        this.fZP = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bjQ() {
        return this.fZr;
    }

    public TextView bjY() {
        return this.fZE;
    }

    public TextView bjZ() {
        return this.fZM;
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View bka() {
        return this.fZQ;
    }

    public TextView bkb() {
        return this.fZO;
    }

    public TextView bkc() {
        return this.fZI;
    }

    public TextView bkd() {
        return this.fZG;
    }

    public TextView bke() {
        return this.fZL;
    }

    public TextView bkf() {
        return this.fZF;
    }

    public TextView bkg() {
        return this.fZH;
    }

    public TextView bkh() {
        return this.fZJ;
    }

    public TextView bki() {
        return this.fZK;
    }

    public TextView bkj() {
        return this.fZN;
    }

    public void bkk() {
        if (this.bdm == null) {
            this.bdm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fZQ.setBackgroundColor(aa.this.fZP.getResources().getColor(e.d.common_color_10082));
                }
            };
        }
        this.fZQ.postDelayed(this.bdm, 200L);
    }

    public void bkl() {
        this.fZQ.setBackgroundColor(this.fZP.getResources().getColor(e.d.common_color_10022));
    }

    public void release() {
        this.fZQ.removeCallbacks(this.bdm);
    }

    public void kZ(boolean z) {
        if (z) {
            this.fZM.setVisibility(0);
        } else {
            this.fZM.setVisibility(8);
        }
    }

    public void q(boolean z, String str) {
        if (z) {
            this.fZN.setVisibility(0);
            this.fZN.setText(str);
            return;
        }
        this.fZN.setVisibility(8);
    }

    public void la(boolean z) {
        this.fZr.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.fZO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fZO.setText(e.j.group_info_intro_more);
        } else {
            this.fZO.setText(e.j.view_host);
        }
    }

    public void O(boolean z, boolean z2) {
        this.fZI.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fZI.setText(e.j.cancel_top);
        } else {
            this.fZI.setText(e.j.top);
        }
    }

    public void P(boolean z, boolean z2) {
        this.fZL.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fZL.setText(e.j.cancel_good);
        } else {
            this.fZL.setText(e.j.commit_good);
        }
    }

    public void lb(boolean z) {
        this.fZG.setVisibility(z ? 0 : 8);
    }

    public void lc(boolean z) {
        this.fZF.setVisibility(z ? 0 : 8);
    }

    public void ld(boolean z) {
        this.fZH.setVisibility(z ? 0 : 8);
    }

    public void Q(boolean z, boolean z2) {
        this.fZJ.setVisibility(z ? 0 : 8);
        this.fZV = z2;
        if (z2) {
            this.fZJ.setText(e.j.view_reverse);
        } else {
            this.fZJ.setText(e.j.default_sort);
        }
        this.fZJ.setText(e.j.sort_selector);
    }

    public void R(boolean z, boolean z2) {
        this.fZK.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fZK.setText(e.j.normal_mode);
        } else {
            this.fZK.setText(e.j.eyeshield_mode);
        }
    }

    public void le(boolean z) {
        this.fZE.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fZP.getPageContext().getPageActivity()).inflate(e.h.pb_more_pop_view, (ViewGroup) null);
        this.fZr = (TextView) this.mView.findViewById(e.g.pb_more_view_item_mark);
        this.fZr.setOnClickListener(this.mClickListener);
        this.fZE = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump);
        this.fZE.setOnClickListener(this.mClickListener);
        this.fZM = (TextView) this.mView.findViewById(e.g.pb_more_view_item_report);
        this.fZM.setOnClickListener(this.mClickListener);
        this.fZN = (TextView) this.mView.findViewById(e.g.pb_more_view_item_fans_call);
        this.fZN.setOnClickListener(this.mClickListener);
        this.fZF = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump_top);
        this.fZF.setOnClickListener(this.mClickListener);
        this.fZG = (TextView) this.mView.findViewById(e.g.pb_more_view_item_delete);
        this.fZG.setOnClickListener(this.mClickListener);
        this.fZH = (TextView) this.mView.findViewById(e.g.pb_more_view_item_forbidden);
        this.fZH.setOnClickListener(this.mClickListener);
        this.fZJ = (TextView) this.mView.findViewById(e.g.pb_more_view_item_reversed);
        this.fZJ.setOnClickListener(this.mClickListener);
        this.fZK = (TextView) this.mView.findViewById(e.g.pb_more_view_item_night_style);
        this.fZK.setOnClickListener(this.mClickListener);
        this.fZI = (TextView) this.mView.findViewById(e.g.pb_more_view_item_make_top);
        this.fZI.setOnClickListener(this.mClickListener);
        this.fZL = (TextView) this.mView.findViewById(e.g.pb_more_view_item_add_good);
        this.fZL.setOnClickListener(this.mClickListener);
        this.fZO = (TextView) this.mView.findViewById(e.g.pb_more_view_item_host_only);
        this.fZO.setOnClickListener(this.mClickListener);
        this.fZQ = this.mView.findViewById(e.g.pb_more_layer);
        this.fZR = (FlowLayout) this.mView.findViewById(e.g.pb_more_flowlayout);
        this.fZT = (TextSizeSeekBar) this.mView.findViewById(e.g.pb_more_text_size_seekbar);
        this.fZS = (LinearLayout) this.mView.findViewById(e.g.size_seek_bar_group);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.pb_more_cancel);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.fZQ.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.fZR, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fZS, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.mCancelView, e.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.fZr, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZE, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZM, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZN, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZO, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZF, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZG, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZI, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZL, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZH, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZJ, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fZK, e.d.cp_cont_f, 1);
        this.fZR.setHorizontalSpacing(((((WindowManager) this.fZP.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds100) * 5)) / 4);
        this.fZr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fZE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fZM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fZN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fZF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fZU) {
            this.fZG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fZG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fZI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fZL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fZH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fZK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        this.fZJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        this.fZO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fZT != null) {
            this.fZT.onChangeSkinType();
        }
    }
}
