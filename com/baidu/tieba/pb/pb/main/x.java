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
    private Runnable aFV;
    private View.OnClickListener aXL;
    private TextView bCC;
    private View bCa;
    private FlowLayout bCb;
    private TextView bCc;
    private TextView eKG;
    private TextView eKQ;
    private TextView eKR;
    private TextView eKS;
    private TextView eKT;
    private TextView eKU;
    private TextView eKV;
    private TextView eKW;
    private TextView eKX;
    private TextView eKY;
    private ViewGroup eKZ;
    private TextView eLa;
    private ImageView eLb;
    private TextView eLc;
    private PbActivity eLd;
    private LinearLayout eLe;
    private View eLf;
    private View mView;

    public x(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eKG = null;
        this.eKQ = null;
        this.eKR = null;
        this.eKX = null;
        this.eKY = null;
        this.eLa = null;
        this.eLd = null;
        this.aXL = null;
        this.eLd = pbActivity;
        this.aXL = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aRU() {
        return this.eKG;
    }

    public TextView aSc() {
        return this.eKQ;
    }

    public TextView aSd() {
        return this.eKR;
    }

    public TextView aSe() {
        return this.eKY;
    }

    public TextView aSf() {
        return this.eKX;
    }

    public TextView aSg() {
        return this.eLa;
    }

    public TextView getCancelView() {
        return this.bCc;
    }

    public View Vp() {
        return this.bCa;
    }

    public TextView aSh() {
        return this.eLc;
    }

    public TextView aSi() {
        return this.eKV;
    }

    public TextView aSj() {
        return this.bCC;
    }

    public TextView aSk() {
        return this.eKW;
    }

    public TextView aSl() {
        return this.eKT;
    }

    public TextView aSm() {
        return this.eKU;
    }

    public TextView aSn() {
        return this.eKS;
    }

    public void Vq() {
        if (this.aFV == null) {
            this.aFV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.bCa.setBackgroundColor(x.this.eLd.getResources().getColor(d.e.common_color_10082));
                }
            };
        }
        this.bCa.postDelayed(this.aFV, 200L);
    }

    public void Vr() {
        this.bCa.setBackgroundColor(this.eLd.getResources().getColor(d.e.common_color_10022));
    }

    public void release() {
        this.bCa.removeCallbacks(this.aFV);
    }

    public void jp(boolean z) {
        if (z) {
            this.eKY.setVisibility(0);
        } else {
            this.eKY.setVisibility(8);
        }
    }

    public void jq(boolean z) {
        if (z) {
            this.eKX.setVisibility(0);
        } else {
            this.eKX.setVisibility(8);
        }
    }

    public void jr(boolean z) {
        this.eKZ.setVisibility(z ? 0 : 8);
    }

    public void js(boolean z) {
        this.eKG.setVisibility(z ? 0 : 8);
    }

    public void D(boolean z, boolean z2) {
        this.eLc.setVisibility(z ? 0 : 8);
    }

    public void E(boolean z, boolean z2) {
        this.eKV.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eKV.setText(d.l.cancel_top);
        } else {
            this.eKV.setText(d.l.top);
        }
    }

    public void F(boolean z, boolean z2) {
        this.eKW.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eKW.setText(d.l.cancel_good);
        } else {
            this.eKW.setText(d.l.commit_good);
        }
    }

    public void jt(boolean z) {
        this.bCC.setVisibility(z ? 0 : 8);
    }

    public void ju(boolean z) {
        this.eKT.setVisibility(z ? 0 : 8);
    }

    public void jv(boolean z) {
        this.eKU.setVisibility(z ? 0 : 8);
    }

    public void jw(boolean z) {
        this.eKS.setVisibility(z ? 0 : 8);
    }

    public void aSo() {
        this.eLb.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eLd.getPageContext().getPageActivity()).inflate(d.j.pb_more_pop_view, (ViewGroup) null);
        this.eKG = (TextView) this.mView.findViewById(d.h.pb_more_view_item_mark);
        this.eKG.setOnClickListener(this.aXL);
        this.eKQ = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump);
        this.eKQ.setOnClickListener(this.aXL);
        this.eKR = (TextView) this.mView.findViewById(d.h.pb_more_view_item_see);
        this.eKR.setOnClickListener(this.aXL);
        this.eKY = (TextView) this.mView.findViewById(d.h.pb_more_view_item_report);
        this.eKY.setOnClickListener(this.aXL);
        this.eKX = (TextView) this.mView.findViewById(d.h.pb_more_view_item_upgrade_thread);
        this.eKX.setOnClickListener(this.aXL);
        this.eKT = (TextView) this.mView.findViewById(d.h.pb_more_view_item_jump_top);
        this.eKT.setOnClickListener(this.aXL);
        this.bCC = (TextView) this.mView.findViewById(d.h.pb_more_view_item_delete);
        this.bCC.setOnClickListener(this.aXL);
        this.eKU = (TextView) this.mView.findViewById(d.h.pb_more_view_item_forbidden);
        this.eKU.setOnClickListener(this.aXL);
        this.eKV = (TextView) this.mView.findViewById(d.h.pb_more_view_item_make_top);
        this.eKV.setOnClickListener(this.aXL);
        this.eKW = (TextView) this.mView.findViewById(d.h.pb_more_view_item_add_good);
        this.eKW.setOnClickListener(this.aXL);
        this.eLc = (TextView) this.mView.findViewById(d.h.pb_more_view_item_host_only);
        this.eLc.setOnClickListener(this.aXL);
        this.eKS = (TextView) this.mView.findViewById(d.h.pb_more_view_item_share);
        this.eKS.setOnClickListener(this.aXL);
        this.eKZ = (ViewGroup) this.mView.findViewById(d.h.pb_more_view_item_god_call_layout);
        this.eLa = (TextView) this.mView.findViewById(d.h.pb_more_view_item_god_call);
        this.eLb = (ImageView) this.mView.findViewById(d.h.pb_more_view_item_god_call_tip);
        this.eLa.setOnClickListener(this.aXL);
        this.eLb.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bCa = this.mView.findViewById(d.h.pb_more_layer);
        this.bCb = (FlowLayout) this.mView.findViewById(d.h.pb_more_flowlayout);
        this.eLe = (LinearLayout) this.mView.findViewById(d.h.size_seek_bar_group);
        this.eLf = this.mView.findViewById(d.h.pb_more_seekbar_line);
        this.bCc = (TextView) this.mView.findViewById(d.h.pb_more_cancel);
        this.bCc.setOnClickListener(this.aXL);
        this.bCa.setOnClickListener(this.aXL);
    }

    public void Vu() {
        com.baidu.tbadk.core.util.ai.k(this.bCb, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eLe, d.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.ai.k(this.eLf, d.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.ai.j(this.bCc, d.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.ai.c(this.bCc, d.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKG, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKQ, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKR, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKY, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKX, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eLa, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eLc, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKT, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.bCC, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKV, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKW, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKU, d.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ai.c(this.eKS, d.e.cp_cont_j, 1);
        this.bCb.setHorizontalSpacing(((((WindowManager) this.eLd.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds100) * 5)) / 4);
        this.eKG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eKQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eKR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eKY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eLa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eLb.setImageDrawable(com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_chat_dot));
        this.eKS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eKT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.bCC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eKW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eKU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eLc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }

    public boolean be(View view) {
        return (view == null || this.mView == null || this.mView.findViewById(view.getId()) == null || view == this.bCa || view == this.bCc || view == this.bCC) ? false : true;
    }
}
