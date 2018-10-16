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
    private Runnable aZb;
    private View fRA;
    private FlowLayout fRB;
    private LinearLayout fRC;
    private TextSizeSeekBar fRD;
    public boolean fRE;
    public boolean fRF;
    private TextView fRb;
    private TextView fRo;
    private TextView fRp;
    private TextView fRq;
    private TextView fRr;
    private TextView fRs;
    private TextView fRt;
    private TextView fRu;
    private TextView fRv;
    private TextView fRw;
    private TextView fRx;
    private TextView fRy;
    private PbActivity fRz;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fRb = null;
        this.fRo = null;
        this.fRw = null;
        this.fRz = null;
        this.mClickListener = null;
        this.fRz = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView biB() {
        return this.fRb;
    }

    public TextView biJ() {
        return this.fRo;
    }

    public TextView biK() {
        return this.fRw;
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View biL() {
        return this.fRA;
    }

    public TextView biM() {
        return this.fRy;
    }

    public TextView biN() {
        return this.fRs;
    }

    public TextView biO() {
        return this.fRq;
    }

    public TextView biP() {
        return this.fRv;
    }

    public TextView biQ() {
        return this.fRp;
    }

    public TextView biR() {
        return this.fRr;
    }

    public TextView biS() {
        return this.fRt;
    }

    public TextView biT() {
        return this.fRu;
    }

    public TextView biU() {
        return this.fRx;
    }

    public void biV() {
        if (this.aZb == null) {
            this.aZb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fRA.setBackgroundColor(aa.this.fRz.getResources().getColor(e.d.common_color_10082));
                }
            };
        }
        this.fRA.postDelayed(this.aZb, 200L);
    }

    public void biW() {
        this.fRA.setBackgroundColor(this.fRz.getResources().getColor(e.d.common_color_10022));
    }

    public void release() {
        this.fRA.removeCallbacks(this.aZb);
    }

    public void kL(boolean z) {
        if (z) {
            this.fRw.setVisibility(0);
        } else {
            this.fRw.setVisibility(8);
        }
    }

    public void r(boolean z, String str) {
        if (z) {
            this.fRx.setVisibility(0);
            this.fRx.setText(str);
            return;
        }
        this.fRx.setVisibility(8);
    }

    public void kM(boolean z) {
        this.fRb.setVisibility(z ? 0 : 8);
    }

    public void L(boolean z, boolean z2) {
        this.fRy.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRy.setText(e.j.group_info_intro_more);
        } else {
            this.fRy.setText(e.j.view_host);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fRs.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRs.setText(e.j.cancel_top);
        } else {
            this.fRs.setText(e.j.top);
        }
    }

    public void N(boolean z, boolean z2) {
        this.fRv.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRv.setText(e.j.cancel_good);
        } else {
            this.fRv.setText(e.j.commit_good);
        }
    }

    public void kN(boolean z) {
        this.fRq.setVisibility(z ? 0 : 8);
    }

    public void kO(boolean z) {
        this.fRp.setVisibility(z ? 0 : 8);
    }

    public void kP(boolean z) {
        this.fRr.setVisibility(z ? 0 : 8);
    }

    public void O(boolean z, boolean z2) {
        this.fRt.setVisibility(z ? 0 : 8);
        this.fRF = z2;
        if (z2) {
            this.fRt.setText(e.j.view_reverse);
        } else {
            this.fRt.setText(e.j.default_sort);
        }
        this.fRt.setText(e.j.sort_selector);
    }

    public void P(boolean z, boolean z2) {
        this.fRu.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRu.setText(e.j.normal_mode);
        } else {
            this.fRu.setText(e.j.eyeshield_mode);
        }
    }

    public void kQ(boolean z) {
        this.fRo.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fRz.getPageContext().getPageActivity()).inflate(e.h.pb_more_pop_view, (ViewGroup) null);
        this.fRb = (TextView) this.mView.findViewById(e.g.pb_more_view_item_mark);
        this.fRb.setOnClickListener(this.mClickListener);
        this.fRo = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump);
        this.fRo.setOnClickListener(this.mClickListener);
        this.fRw = (TextView) this.mView.findViewById(e.g.pb_more_view_item_report);
        this.fRw.setOnClickListener(this.mClickListener);
        this.fRx = (TextView) this.mView.findViewById(e.g.pb_more_view_item_fans_call);
        this.fRx.setOnClickListener(this.mClickListener);
        this.fRp = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump_top);
        this.fRp.setOnClickListener(this.mClickListener);
        this.fRq = (TextView) this.mView.findViewById(e.g.pb_more_view_item_delete);
        this.fRq.setOnClickListener(this.mClickListener);
        this.fRr = (TextView) this.mView.findViewById(e.g.pb_more_view_item_forbidden);
        this.fRr.setOnClickListener(this.mClickListener);
        this.fRt = (TextView) this.mView.findViewById(e.g.pb_more_view_item_reversed);
        this.fRt.setOnClickListener(this.mClickListener);
        this.fRu = (TextView) this.mView.findViewById(e.g.pb_more_view_item_night_style);
        this.fRu.setOnClickListener(this.mClickListener);
        this.fRs = (TextView) this.mView.findViewById(e.g.pb_more_view_item_make_top);
        this.fRs.setOnClickListener(this.mClickListener);
        this.fRv = (TextView) this.mView.findViewById(e.g.pb_more_view_item_add_good);
        this.fRv.setOnClickListener(this.mClickListener);
        this.fRy = (TextView) this.mView.findViewById(e.g.pb_more_view_item_host_only);
        this.fRy.setOnClickListener(this.mClickListener);
        this.fRA = this.mView.findViewById(e.g.pb_more_layer);
        this.fRB = (FlowLayout) this.mView.findViewById(e.g.pb_more_flowlayout);
        this.fRD = (TextSizeSeekBar) this.mView.findViewById(e.g.pb_more_text_size_seekbar);
        this.fRC = (LinearLayout) this.mView.findViewById(e.g.size_seek_bar_group);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.pb_more_cancel);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.fRA.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.fRB, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fRC, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.mCancelView, e.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.fRb, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRo, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRw, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRx, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRy, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRp, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRq, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRs, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRv, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRr, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRt, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fRu, e.d.cp_cont_f, 1);
        this.fRB.setHorizontalSpacing(((((WindowManager) this.fRz.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds100) * 5)) / 4);
        this.fRb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fRo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fRw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fRx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fRp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fRE) {
            this.fRq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fRs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fRv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fRr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fRu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        this.fRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        this.fRy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fRD != null) {
            this.fRD.onChangeSkinType();
        }
    }
}
