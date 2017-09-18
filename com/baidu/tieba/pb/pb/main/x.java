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
    private Runnable aGC;
    private View.OnClickListener aYH;
    private View bHF;
    private FlowLayout bHG;
    private TextView bHH;
    private TextView bIh;
    private TextView eNA;
    private TextView eNc;
    private TextView eNm;
    private TextView eNn;
    private TextView eNo;
    private TextView eNp;
    private TextView eNq;
    private TextView eNr;
    private ViewGroup eNs;
    private TextView eNt;
    private ImageView eNu;
    private TextView eNv;
    private TextView eNw;
    private PbActivity eNx;
    private LinearLayout eNy;
    private View eNz;
    private View mView;

    public x(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eNc = null;
        this.eNm = null;
        this.eNr = null;
        this.eNt = null;
        this.eNx = null;
        this.aYH = null;
        this.eNx = pbActivity;
        this.aYH = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aSk() {
        return this.eNc;
    }

    public TextView aSs() {
        return this.eNm;
    }

    public TextView aSt() {
        return this.eNr;
    }

    public TextView aSu() {
        return this.eNt;
    }

    public TextView getCancelView() {
        return this.bHH;
    }

    public View Xb() {
        return this.bHF;
    }

    public TextView aSv() {
        return this.eNw;
    }

    public TextView aSw() {
        return this.eNp;
    }

    public TextView aSx() {
        return this.bIh;
    }

    public TextView aSy() {
        return this.eNq;
    }

    public TextView aSz() {
        return this.eNn;
    }

    public TextView aSA() {
        return this.eNo;
    }

    public TextView aSB() {
        return this.eNv;
    }

    public void Xc() {
        if (this.aGC == null) {
            this.aGC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.bHF.setBackgroundColor(x.this.eNx.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.bHF.postDelayed(this.aGC, 200L);
    }

    public void Xd() {
        this.bHF.setBackgroundColor(this.eNx.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.bHF.removeCallbacks(this.aGC);
    }

    public void jt(boolean z) {
        if (z) {
            this.eNr.setVisibility(0);
        } else {
            this.eNr.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.eNv.setVisibility(0);
            this.eNv.setText(str);
            return;
        }
        this.eNv.setVisibility(8);
    }

    public void ju(boolean z) {
        this.eNs.setVisibility(z ? 0 : 8);
    }

    public void jv(boolean z) {
        this.eNc.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.eNw.setVisibility(z ? 0 : 8);
    }

    public void G(boolean z, boolean z2) {
        this.eNp.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eNp.setText(d.l.cancel_top);
        } else {
            this.eNp.setText(d.l.top);
        }
    }

    public void H(boolean z, boolean z2) {
        this.eNq.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eNq.setText(d.l.cancel_good);
        } else {
            this.eNq.setText(d.l.commit_good);
        }
    }

    public void jw(boolean z) {
        this.bIh.setVisibility(z ? 0 : 8);
    }

    public void jx(boolean z) {
        this.eNn.setVisibility(z ? 0 : 8);
    }

    public void jy(boolean z) {
        this.eNo.setVisibility(z ? 0 : 8);
    }

    public void aSC() {
        this.eNu.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    public void jz(boolean z) {
        this.eNm.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eNx.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eNc = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eNc.setOnClickListener(this.aYH);
        this.eNm = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eNm.setOnClickListener(this.aYH);
        this.eNr = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eNr.setOnClickListener(this.aYH);
        this.eNv = (TextView) this.mView.findViewById(d.h.pb_more_view_item_fans_call);
        this.eNv.setOnClickListener(this.aYH);
        this.eNn = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eNn.setOnClickListener(this.aYH);
        this.bIh = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.bIh.setOnClickListener(this.aYH);
        this.eNo = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eNo.setOnClickListener(this.aYH);
        this.eNp = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eNp.setOnClickListener(this.aYH);
        this.eNq = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eNq.setOnClickListener(this.aYH);
        this.eNw = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eNw.setOnClickListener(this.aYH);
        this.eNs = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eNt = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eNu = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eNt.setOnClickListener(this.aYH);
        this.eNu.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bHF = this.mView.findViewById(d.h.pb_more_layer);
        this.bHG = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eNy = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eNz = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bHH = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bHH.setOnClickListener(this.aYH);
        this.bHF.setOnClickListener(this.aYH);
        this.eNA = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eNA.setOnClickListener(this.aYH);
    }

    public void Xg() {
        com.baidu.tbadk.core.util.aj.k(this.bHG, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eNy, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.k(this.eNz, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aj.j(this.bHH, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.c(this.bHH, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNc, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNm, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNr, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNv, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNt, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNw, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNn, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.bIh, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNp, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNq, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNo, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aj.c(this.eNA, d.e.cp_cont_j, 1);
        this.eNA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.bHG.setHorizontalSpacing(((((WindowManager) this.eNx.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eNc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eNm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eNr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eNv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.call_fans_selector), (Drawable) null, (Drawable) null);
        this.eNt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eNu.setImageDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_chat_dot));
        this.eNn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bIh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eNp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eNq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eNw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean bm(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bHF || view == this.bHH || view == this.bIh) ? false : true;
    }

    public void jA(boolean z) {
        this.eNA.setVisibility(z ? 0 : 8);
    }

    public TextView aSD() {
        return this.eNA;
    }
}
