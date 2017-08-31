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
    private Runnable aGF;
    private View.OnClickListener aYK;
    private View bGO;
    private FlowLayout bGP;
    private TextView bGQ;
    private TextView bHq;
    private ImageView eMA;
    private TextView eMB;
    private TextView eMC;
    private PbActivity eMD;
    private LinearLayout eME;
    private View eMF;
    private TextView eMG;
    private TextView eMi;
    private TextView eMs;
    private TextView eMt;
    private TextView eMu;
    private TextView eMv;
    private TextView eMw;
    private TextView eMx;
    private ViewGroup eMy;
    private TextView eMz;
    private View mView;

    public x(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eMi = null;
        this.eMs = null;
        this.eMx = null;
        this.eMz = null;
        this.eMD = null;
        this.aYK = null;
        this.eMD = pbActivity;
        this.aYK = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aRZ() {
        return this.eMi;
    }

    public TextView aSh() {
        return this.eMs;
    }

    public TextView aSi() {
        return this.eMx;
    }

    public TextView aSj() {
        return this.eMz;
    }

    public TextView getCancelView() {
        return this.bGQ;
    }

    public View WQ() {
        return this.bGO;
    }

    public TextView aSk() {
        return this.eMC;
    }

    public TextView aSl() {
        return this.eMv;
    }

    public TextView aSm() {
        return this.bHq;
    }

    public TextView aSn() {
        return this.eMw;
    }

    public TextView aSo() {
        return this.eMt;
    }

    public TextView aSp() {
        return this.eMu;
    }

    public TextView aSq() {
        return this.eMB;
    }

    public void WR() {
        if (this.aGF == null) {
            this.aGF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.bGO.setBackgroundColor(x.this.eMD.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.bGO.postDelayed(this.aGF, 200L);
    }

    public void WS() {
        this.bGO.setBackgroundColor(this.eMD.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.bGO.removeCallbacks(this.aGF);
    }

    public void js(boolean z) {
        if (z) {
            this.eMx.setVisibility(0);
        } else {
            this.eMx.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.eMB.setVisibility(0);
            this.eMB.setText(str);
            return;
        }
        this.eMB.setVisibility(8);
    }

    public void jt(boolean z) {
        this.eMy.setVisibility(z ? 0 : 8);
    }

    public void ju(boolean z) {
        this.eMi.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.eMC.setVisibility(z ? 0 : 8);
    }

    public void G(boolean z, boolean z2) {
        this.eMv.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eMv.setText(d.l.cancel_top);
        } else {
            this.eMv.setText(d.l.top);
        }
    }

    public void H(boolean z, boolean z2) {
        this.eMw.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eMw.setText(d.l.cancel_good);
        } else {
            this.eMw.setText(d.l.commit_good);
        }
    }

    public void jv(boolean z) {
        this.bHq.setVisibility(z ? 0 : 8);
    }

    public void jw(boolean z) {
        this.eMt.setVisibility(z ? 0 : 8);
    }

    public void jx(boolean z) {
        this.eMu.setVisibility(z ? 0 : 8);
    }

    public void aSr() {
        this.eMA.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    public void jy(boolean z) {
        this.eMs.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eMD.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eMi = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eMi.setOnClickListener(this.aYK);
        this.eMs = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eMs.setOnClickListener(this.aYK);
        this.eMx = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eMx.setOnClickListener(this.aYK);
        this.eMB = (TextView) this.mView.findViewById(d.h.pb_more_view_item_fans_call);
        this.eMB.setOnClickListener(this.aYK);
        this.eMt = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eMt.setOnClickListener(this.aYK);
        this.bHq = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.bHq.setOnClickListener(this.aYK);
        this.eMu = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eMu.setOnClickListener(this.aYK);
        this.eMv = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eMv.setOnClickListener(this.aYK);
        this.eMw = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eMw.setOnClickListener(this.aYK);
        this.eMC = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eMC.setOnClickListener(this.aYK);
        this.eMy = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eMz = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eMA = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eMz.setOnClickListener(this.aYK);
        this.eMA.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bGO = this.mView.findViewById(d.h.pb_more_layer);
        this.bGP = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eME = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eMF = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bGQ = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bGQ.setOnClickListener(this.aYK);
        this.bGO.setOnClickListener(this.aYK);
        this.eMG = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eMG.setOnClickListener(this.aYK);
    }

    public void WV() {
        com.baidu.tbadk.core.util.aj.k(this.bGP, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eME, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eMF, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aj.j(this.bGQ, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.bGQ, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMi, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMs, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMx, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMB, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMz, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMC, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMt, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.bHq, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMv, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMw, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMu, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eMG, d.e.cp_cont_j, 1);
        this.eMG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.bGP.setHorizontalSpacing(((((WindowManager) this.eMD.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eMi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eMs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eMx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eMB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eMz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eMA.setImageDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_chat_dot));
        this.eMt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bHq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eMv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eMw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eMu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eMC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean bm(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bGO || view == this.bGQ || view == this.bHq) ? false : true;
    }

    public void jz(boolean z) {
        this.eMG.setVisibility(z ? 0 : 8);
    }

    public TextView aSs() {
        return this.eMG;
    }
}
