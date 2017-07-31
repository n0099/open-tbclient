package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.c<PbActivity> {
    private View.OnClickListener aYW;
    private TextView bDM;
    private View bDk;
    private FlowLayout bDl;
    private TextView bDm;
    private TextView eLT;
    private TextView eMd;
    private TextView eMe;
    private TextView eMf;
    private TextView eMg;
    private TextView eMh;
    private TextView eMi;
    private TextView eMj;
    private TextView eMk;
    private TextView eMl;
    private ViewGroup eMm;
    private TextView eMn;
    private ImageView eMo;
    private TextView eMp;
    private PbActivity eMq;
    private LinearLayout eMr;
    private View eMs;
    private View mView;
    private Runnable runnable;

    public x(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eLT = null;
        this.eMd = null;
        this.eMe = null;
        this.eMk = null;
        this.eMl = null;
        this.eMn = null;
        this.eMq = null;
        this.aYW = null;
        this.eMq = pbActivity;
        this.aYW = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aSf() {
        return this.eLT;
    }

    public TextView aSn() {
        return this.eMd;
    }

    public TextView aSo() {
        return this.eMe;
    }

    public TextView aSp() {
        return this.eMl;
    }

    public TextView aSq() {
        return this.eMk;
    }

    public TextView aSr() {
        return this.eMn;
    }

    public TextView getCancelView() {
        return this.bDm;
    }

    public View Vu() {
        return this.bDk;
    }

    public TextView aSs() {
        return this.eMp;
    }

    public TextView aSt() {
        return this.eMi;
    }

    public TextView aSu() {
        return this.bDM;
    }

    public TextView aSv() {
        return this.eMj;
    }

    public TextView aSw() {
        return this.eMg;
    }

    public TextView aSx() {
        return this.eMh;
    }

    public TextView aSy() {
        return this.eMf;
    }

    public void Vv() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.bDk.setBackgroundColor(x.this.eMq.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.bDk.postDelayed(this.runnable, 200L);
    }

    public void Vw() {
        this.bDk.setBackgroundColor(this.eMq.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.bDk.removeCallbacks(this.runnable);
    }

    public void jp(boolean z) {
        if (z) {
            this.eMl.setVisibility(0);
        } else {
            this.eMl.setVisibility(8);
        }
    }

    public void jq(boolean z) {
        if (z) {
            this.eMk.setVisibility(0);
        } else {
            this.eMk.setVisibility(8);
        }
    }

    public void jr(boolean z) {
        this.eMm.setVisibility(z ? 0 : 8);
    }

    public void js(boolean z) {
        this.eLT.setVisibility(z ? 0 : 8);
    }

    public void D(boolean z, boolean z2) {
        this.eMp.setVisibility(z ? 0 : 8);
    }

    public void E(boolean z, boolean z2) {
        this.eMi.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eMi.setText(d.l.cancel_top);
        } else {
            this.eMi.setText(d.l.top);
        }
    }

    public void F(boolean z, boolean z2) {
        this.eMj.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eMj.setText(d.l.cancel_good);
        } else {
            this.eMj.setText(d.l.commit_good);
        }
    }

    public void jt(boolean z) {
        this.bDM.setVisibility(z ? 0 : 8);
    }

    public void ju(boolean z) {
        this.eMg.setVisibility(z ? 0 : 8);
    }

    public void jv(boolean z) {
        this.eMh.setVisibility(z ? 0 : 8);
    }

    public void jw(boolean z) {
        this.eMf.setVisibility(z ? 0 : 8);
    }

    public void aSz() {
        this.eMo.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eMq.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eLT = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eLT.setOnClickListener(this.aYW);
        this.eMd = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eMd.setOnClickListener(this.aYW);
        this.eMe = (TextView) this.mView.findViewById(d.h.pb_more_view_item_see);
        this.eMe.setOnClickListener(this.aYW);
        this.eMl = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eMl.setOnClickListener(this.aYW);
        this.eMk = (TextView) this.mView.findViewById(d.h.pb_more_view_item_upgrade_thread);
        this.eMk.setOnClickListener(this.aYW);
        this.eMg = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eMg.setOnClickListener(this.aYW);
        this.bDM = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.bDM.setOnClickListener(this.aYW);
        this.eMh = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eMh.setOnClickListener(this.aYW);
        this.eMi = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eMi.setOnClickListener(this.aYW);
        this.eMj = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eMj.setOnClickListener(this.aYW);
        this.eMp = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eMp.setOnClickListener(this.aYW);
        this.eMf = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eMf.setOnClickListener(this.aYW);
        this.eMm = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eMn = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eMo = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eMn.setOnClickListener(this.aYW);
        this.eMo.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bDk = this.mView.findViewById(d.h.pb_more_layer);
        this.bDl = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eMr = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eMs = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bDm = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bDm.setOnClickListener(this.aYW);
        this.bDk.setOnClickListener(this.aYW);
    }

    public void Vz() {
        com.baidu.tbadk.core.util.ai.k(this.bDl, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eMr, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eMs, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.ai.j(this.bDm, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ai.c(this.bDm, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ai.c(this.eLT, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMd, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMe, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMl, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMk, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMn, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMp, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMg, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.bDM, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMi, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMj, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMh, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eMf, d.e.cp_cont_j, 1);
        this.bDl.setHorizontalSpacing(((((WindowManager) this.eMq.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eLT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eMd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eMl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eMk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eMn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eMo.setImageDrawable(com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_chat_dot));
        this.eMf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bDM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eMi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eMj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eMh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eMp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean be(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bDk || view == this.bDm || view == this.bDM) ? false : true;
    }
}
