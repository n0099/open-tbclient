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
    private Runnable bdp;
    private TextView gcA;
    private TextView gcB;
    private TextView gcC;
    private TextView gcD;
    private TextView gcE;
    private TextView gcF;
    private TextView gcG;
    private PbActivity gcH;
    private View gcI;
    private FlowLayout gcJ;
    private LinearLayout gcK;
    private TextSizeSeekBar gcL;
    public boolean gcM;
    public boolean gcN;
    private TextView gcj;
    private TextView gcw;
    private TextView gcx;
    private TextView gcy;
    private TextView gcz;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.gcj = null;
        this.gcw = null;
        this.gcE = null;
        this.gcH = null;
        this.mClickListener = null;
        this.gcH = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bkB() {
        return this.gcj;
    }

    public TextView bkJ() {
        return this.gcw;
    }

    public TextView bkK() {
        return this.gcE;
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View bkL() {
        return this.gcI;
    }

    public TextView bkM() {
        return this.gcG;
    }

    public TextView bkN() {
        return this.gcA;
    }

    public TextView bkO() {
        return this.gcy;
    }

    public TextView bkP() {
        return this.gcD;
    }

    public TextView bkQ() {
        return this.gcx;
    }

    public TextView bkR() {
        return this.gcz;
    }

    public TextView bkS() {
        return this.gcB;
    }

    public TextView bkT() {
        return this.gcC;
    }

    public TextView bkU() {
        return this.gcF;
    }

    public void bkV() {
        if (this.bdp == null) {
            this.bdp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.gcI.setBackgroundColor(aa.this.gcH.getResources().getColor(e.d.common_color_10082));
                }
            };
        }
        this.gcI.postDelayed(this.bdp, 200L);
    }

    public void bkW() {
        this.gcI.setBackgroundColor(this.gcH.getResources().getColor(e.d.common_color_10022));
    }

    public void release() {
        this.gcI.removeCallbacks(this.bdp);
    }

    public void lc(boolean z) {
        if (z) {
            this.gcE.setVisibility(0);
        } else {
            this.gcE.setVisibility(8);
        }
    }

    public void r(boolean z, String str) {
        if (z) {
            this.gcF.setVisibility(0);
            this.gcF.setText(str);
            return;
        }
        this.gcF.setVisibility(8);
    }

    public void ld(boolean z) {
        this.gcj.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.gcG.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gcG.setText(e.j.group_info_intro_more);
        } else {
            this.gcG.setText(e.j.view_host);
        }
    }

    public void O(boolean z, boolean z2) {
        this.gcA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gcA.setText(e.j.cancel_top);
        } else {
            this.gcA.setText(e.j.top);
        }
    }

    public void P(boolean z, boolean z2) {
        this.gcD.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gcD.setText(e.j.cancel_good);
        } else {
            this.gcD.setText(e.j.commit_good);
        }
    }

    public void le(boolean z) {
        this.gcy.setVisibility(z ? 0 : 8);
    }

    public void lf(boolean z) {
        this.gcx.setVisibility(z ? 0 : 8);
    }

    public void lg(boolean z) {
        this.gcz.setVisibility(z ? 0 : 8);
    }

    public void Q(boolean z, boolean z2) {
        this.gcB.setVisibility(z ? 0 : 8);
        this.gcN = z2;
        if (z2) {
            this.gcB.setText(e.j.view_reverse);
        } else {
            this.gcB.setText(e.j.default_sort);
        }
        this.gcB.setText(e.j.sort_selector);
    }

    public void R(boolean z, boolean z2) {
        this.gcC.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gcC.setText(e.j.normal_mode);
        } else {
            this.gcC.setText(e.j.eyeshield_mode);
        }
    }

    public void lh(boolean z) {
        this.gcw.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gcH.getPageContext().getPageActivity()).inflate(e.h.pb_more_pop_view, (ViewGroup) null);
        this.gcj = (TextView) this.mView.findViewById(e.g.pb_more_view_item_mark);
        this.gcj.setOnClickListener(this.mClickListener);
        this.gcw = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump);
        this.gcw.setOnClickListener(this.mClickListener);
        this.gcE = (TextView) this.mView.findViewById(e.g.pb_more_view_item_report);
        this.gcE.setOnClickListener(this.mClickListener);
        this.gcF = (TextView) this.mView.findViewById(e.g.pb_more_view_item_fans_call);
        this.gcF.setOnClickListener(this.mClickListener);
        this.gcx = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump_top);
        this.gcx.setOnClickListener(this.mClickListener);
        this.gcy = (TextView) this.mView.findViewById(e.g.pb_more_view_item_delete);
        this.gcy.setOnClickListener(this.mClickListener);
        this.gcz = (TextView) this.mView.findViewById(e.g.pb_more_view_item_forbidden);
        this.gcz.setOnClickListener(this.mClickListener);
        this.gcB = (TextView) this.mView.findViewById(e.g.pb_more_view_item_reversed);
        this.gcB.setOnClickListener(this.mClickListener);
        this.gcC = (TextView) this.mView.findViewById(e.g.pb_more_view_item_night_style);
        this.gcC.setOnClickListener(this.mClickListener);
        this.gcA = (TextView) this.mView.findViewById(e.g.pb_more_view_item_make_top);
        this.gcA.setOnClickListener(this.mClickListener);
        this.gcD = (TextView) this.mView.findViewById(e.g.pb_more_view_item_add_good);
        this.gcD.setOnClickListener(this.mClickListener);
        this.gcG = (TextView) this.mView.findViewById(e.g.pb_more_view_item_host_only);
        this.gcG.setOnClickListener(this.mClickListener);
        this.gcI = this.mView.findViewById(e.g.pb_more_layer);
        this.gcJ = (FlowLayout) this.mView.findViewById(e.g.pb_more_flowlayout);
        this.gcL = (TextSizeSeekBar) this.mView.findViewById(e.g.pb_more_text_size_seekbar);
        this.gcK = (LinearLayout) this.mView.findViewById(e.g.size_seek_bar_group);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.pb_more_cancel);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.gcI.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.gcJ, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.gcK, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.mCancelView, e.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.gcj, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcw, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcE, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcF, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcG, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcx, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcy, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcA, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcD, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcz, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcB, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gcC, e.d.cp_cont_f, 1);
        this.gcJ.setHorizontalSpacing(((((WindowManager) this.gcH.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds100) * 5)) / 4);
        this.gcj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.gcw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.gcE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.gcF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.gcx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.gcM) {
            this.gcy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.gcy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.gcA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.gcD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.gcz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.gcC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        this.gcB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        this.gcG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.gcL != null) {
            this.gcL.onChangeSkinType();
        }
    }
}
