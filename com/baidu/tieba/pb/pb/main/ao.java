package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ao extends r.a {
    public View ekR;
    public ImageView fTB;
    public TextView fTC;
    public TextView fTD;
    public View fTE;
    public View fTF;
    public ImageView fTG;
    public TextView fTH;
    private boolean fTI;
    public View mRootView;

    public ao(View view) {
        super(view);
        this.fTI = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fTB = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fTC = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fTH = (TextView) view.findViewById(d.g.tv_share);
            this.fTD = (TextView) view.findViewById(d.g.tv_praise);
            this.fTE = view.findViewById(d.g.praise_container);
            this.fTF = view.findViewById(d.g.share_container);
            this.fTG = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.ekR = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean Eu() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fr();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.baX()) {
                if (jVar.fIc == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fTB, d.f.icon_floor_big_praised);
                } else if (jVar.fIc == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fTB, d.f.icon_floor_trample);
                } else if (jVar.fIc == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fTB, d.f.icon_floor_big_trample);
                } else if (jVar.baZ() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fTB, Eu() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fTB, Eu() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.r(this.fTD, d.C0141d.text_conth_50_color);
                this.fTE.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fTB, Eu() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.r(this.fTD, d.C0141d.text_contf_50_color);
                this.fTE.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fTI = jVar.baW();
            beC();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.am.er(com.baidu.tbadk.core.util.am.E(jVar.shareNum)) >= 6) {
                    this.fTH.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fTH.setText(com.baidu.tbadk.core.util.am.E(jVar.shareNum));
            } else {
                this.fTH.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.r(this.fTC, d.C0141d.cp_link_tip_c);
            this.fTB.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fTD.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.bbb()) {
                com.baidu.tbadk.core.util.aj.t(this.ekR, d.C0141d.cp_bg_line_c);
                this.ekR.setVisibility(0);
            } else {
                this.ekR.setVisibility(8);
            }
            if (jVar.baV() <= 0 || com.baidu.tbadk.core.util.v.E(jVar.baY())) {
                this.fTC.setText(d.j.no_praise_tip);
                this.fTD.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.r(this.fTC, d.C0141d.cp_cont_f);
                this.fTC.setTag(false);
                this.fTE.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.r(this.fTD, d.C0141d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fTB, Eu() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fTC.setTag(true);
            this.fTC.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.E(jVar.baV())));
            this.fTD.setText(com.baidu.tbadk.core.util.am.E(jVar.baV()));
        }
    }

    private void beC() {
        if (this.fTI) {
            com.baidu.tbadk.core.util.aj.s(this.fTF, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.aj.s(this.fTG, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.aj.r(this.fTH, d.C0141d.cp_cont_e);
            this.fTF.setClickable(false);
            this.fTH.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.aj.s(this.fTF, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.aj.s(this.fTG, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.r(this.fTH, d.C0141d.text_contf_50_color);
        this.fTF.setClickable(true);
        this.fTH.setClickable(true);
    }

    public void beD() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.t(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void beE() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
