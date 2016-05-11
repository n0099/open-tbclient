package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.view.FlowLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class df extends com.baidu.adp.base.f<PbActivity> {
    private View.OnClickListener Fn;
    private PbActivity dic;
    private TextView dlS;
    private TextView dma;
    private TextView dmb;
    private TextView dmc;
    private TextView dmd;
    private TextView dme;
    private View dmf;
    private FlowLayout dmg;
    private LinearLayout dmh;
    private TextView dmi;
    private View dmj;
    private View mView;
    private Runnable zT;

    public df(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.dlS = null;
        this.dma = null;
        this.dmb = null;
        this.dmc = null;
        this.dmd = null;
        this.dme = null;
        this.dic = null;
        this.Fn = null;
        this.dic = pbActivity;
        this.Fn = onClickListener;
        nq();
    }

    public View getView() {
        return this.mView;
    }

    public TextView axY() {
        return this.dlS;
    }

    public TextView ayh() {
        return this.dma;
    }

    public TextView ayi() {
        return this.dmb;
    }

    public TextView ayj() {
        return this.dmc;
    }

    public TextView ayk() {
        return this.dme;
    }

    public TextView ayl() {
        return this.dmd;
    }

    public TextView aym() {
        return this.dmi;
    }

    public View ayn() {
        return this.dmf;
    }

    public void ayo() {
        if (this.zT == null) {
            this.zT = new dg(this);
        }
        this.dmf.postDelayed(this.zT, 200L);
    }

    public void ayp() {
        this.dmf.setBackgroundColor(this.dic.getResources().getColor(t.d.transparent));
    }

    public void release() {
        this.dmf.removeCallbacks(this.zT);
    }

    public void gK(boolean z) {
        if (z) {
            this.dme.setVisibility(8);
        } else {
            this.dme.setVisibility(0);
        }
    }

    public void gL(boolean z) {
        if (z) {
            this.dmd.setVisibility(8);
        } else {
            this.dmd.setVisibility(0);
        }
    }

    private void nq() {
        this.mView = LayoutInflater.from(this.dic.getPageContext().getPageActivity()).inflate(t.h.pb_more_pop_view, (ViewGroup) null);
        this.dlS = (TextView) this.mView.findViewById(t.g.pb_more_view_item_mark);
        this.dlS.setOnClickListener(this.Fn);
        this.dma = (TextView) this.mView.findViewById(t.g.pb_more_view_item_share);
        this.dma.setOnClickListener(this.Fn);
        this.dmb = (TextView) this.mView.findViewById(t.g.pb_more_view_item_jump);
        this.dmb.setOnClickListener(this.Fn);
        this.dmc = (TextView) this.mView.findViewById(t.g.pb_more_view_item_see);
        this.dmc.setOnClickListener(this.Fn);
        this.dme = (TextView) this.mView.findViewById(t.g.pb_more_view_item_report);
        this.dme.setOnClickListener(this.Fn);
        this.dmd = (TextView) this.mView.findViewById(t.g.pb_more_view_item_upgrade_thread);
        this.dmd.setOnClickListener(this.Fn);
        this.dmf = this.mView.findViewById(t.g.pb_more_layer);
        this.dmg = (FlowLayout) this.mView.findViewById(t.g.pb_more_flowlayout);
        this.dmh = (LinearLayout) this.mView.findViewById(t.g.size_seek_bar_group);
        this.dmj = this.mView.findViewById(t.g.pb_more_seekbar_line);
        this.dmi = (TextView) this.mView.findViewById(t.g.pb_more_cancel);
        this.dmi.setOnClickListener(this.Fn);
        this.dmf.setOnClickListener(this.Fn);
    }

    public void ayq() {
        com.baidu.tbadk.core.util.at.l(this.dmg, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.at.l(this.dmh, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.at.l(this.dmj, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.k(this.dmi, t.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.at.c(this.dmi, t.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.at.c(this.dlS, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.dma, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.dmb, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.dmc, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.dme, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.dmd, t.d.cp_cont_c, 1);
        this.dmg.setHorizontalSpacing(((((WindowManager) this.dic.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m11getInst().getContext().getResources().getDimensionPixelSize(t.e.ds80)) - (TbadkCoreApplication.m11getInst().getContext().getResources().getDimensionPixelSize(t.e.ds130) * 4)) / 3);
        this.dlS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.dma.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.dmb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.dmc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.dme.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.dmd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
    }
}
