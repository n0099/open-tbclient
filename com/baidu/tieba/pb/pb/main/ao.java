package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ao extends r.a {
    public View ekB;
    public ImageView fTl;
    public TextView fTm;
    public TextView fTn;
    public View fTo;
    public View fTp;
    public ImageView fTq;
    public TextView fTr;
    private boolean fTs;
    public View mRootView;

    public ao(View view) {
        super(view);
        this.fTs = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fTl = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fTm = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fTr = (TextView) view.findViewById(d.g.tv_share);
            this.fTn = (TextView) view.findViewById(d.g.tv_praise);
            this.fTo = view.findViewById(d.g.praise_container);
            this.fTp = view.findViewById(d.g.share_container);
            this.fTq = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.ekB = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean Et() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fq();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.baW()) {
                if (jVar.fHM == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fTl, d.f.icon_floor_big_praised);
                } else if (jVar.fHM == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fTl, d.f.icon_floor_trample);
                } else if (jVar.fHM == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fTl, d.f.icon_floor_big_trample);
                } else if (jVar.baY() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fTl, Et() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fTl, Et() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.r(this.fTn, d.C0141d.text_conth_50_color);
                this.fTo.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fTl, Et() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.r(this.fTn, d.C0141d.text_contf_50_color);
                this.fTo.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fTs = jVar.baV();
            beB();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.am.er(com.baidu.tbadk.core.util.am.E(jVar.shareNum)) >= 6) {
                    this.fTr.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fTr.setText(com.baidu.tbadk.core.util.am.E(jVar.shareNum));
            } else {
                this.fTr.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.r(this.fTm, d.C0141d.cp_link_tip_c);
            this.fTl.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fTn.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.bba()) {
                com.baidu.tbadk.core.util.aj.t(this.ekB, d.C0141d.cp_bg_line_c);
                this.ekB.setVisibility(0);
            } else {
                this.ekB.setVisibility(8);
            }
            if (jVar.baU() <= 0 || com.baidu.tbadk.core.util.v.E(jVar.baX())) {
                this.fTm.setText(d.j.no_praise_tip);
                this.fTn.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.r(this.fTm, d.C0141d.cp_cont_f);
                this.fTm.setTag(false);
                this.fTo.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.r(this.fTn, d.C0141d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fTl, Et() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fTm.setTag(true);
            this.fTm.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.E(jVar.baU())));
            this.fTn.setText(com.baidu.tbadk.core.util.am.E(jVar.baU()));
        }
    }

    private void beB() {
        if (this.fTs) {
            com.baidu.tbadk.core.util.aj.s(this.fTp, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.aj.s(this.fTq, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.aj.r(this.fTr, d.C0141d.cp_cont_e);
            this.fTp.setClickable(false);
            this.fTr.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.aj.s(this.fTp, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.aj.s(this.fTq, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.r(this.fTr, d.C0141d.text_contf_50_color);
        this.fTp.setClickable(true);
        this.fTr.setClickable(true);
    }

    public void beC() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.t(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void beD() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
