package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ao extends r.a {
    public View ekN;
    public View fTA;
    public ImageView fTB;
    public TextView fTC;
    private boolean fTD;
    public ImageView fTw;
    public TextView fTx;
    public TextView fTy;
    public View fTz;
    public View mRootView;

    public ao(View view) {
        super(view);
        this.fTD = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fTw = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fTx = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fTC = (TextView) view.findViewById(d.g.tv_share);
            this.fTy = (TextView) view.findViewById(d.g.tv_praise);
            this.fTz = view.findViewById(d.g.praise_container);
            this.fTA = view.findViewById(d.g.share_container);
            this.fTB = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.ekN = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean Eu() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fr();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.baX()) {
                if (jVar.fHX == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fTw, d.f.icon_floor_big_praised);
                } else if (jVar.fHX == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fTw, d.f.icon_floor_trample);
                } else if (jVar.fHX == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fTw, d.f.icon_floor_big_trample);
                } else if (jVar.baZ() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fTw, Eu() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fTw, Eu() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.r(this.fTy, d.C0140d.text_conth_50_color);
                this.fTz.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fTw, Eu() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.r(this.fTy, d.C0140d.text_contf_50_color);
                this.fTz.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fTD = jVar.baW();
            beC();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.am.er(com.baidu.tbadk.core.util.am.E(jVar.shareNum)) >= 6) {
                    this.fTC.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fTC.setText(com.baidu.tbadk.core.util.am.E(jVar.shareNum));
            } else {
                this.fTC.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.r(this.fTx, d.C0140d.cp_link_tip_c);
            this.fTw.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fTy.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.bbb()) {
                com.baidu.tbadk.core.util.aj.t(this.ekN, d.C0140d.cp_bg_line_c);
                this.ekN.setVisibility(0);
            } else {
                this.ekN.setVisibility(8);
            }
            if (jVar.baV() <= 0 || com.baidu.tbadk.core.util.v.E(jVar.baY())) {
                this.fTx.setText(d.j.no_praise_tip);
                this.fTy.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.r(this.fTx, d.C0140d.cp_cont_f);
                this.fTx.setTag(false);
                this.fTz.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.r(this.fTy, d.C0140d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fTw, Eu() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fTx.setTag(true);
            this.fTx.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.E(jVar.baV())));
            this.fTy.setText(com.baidu.tbadk.core.util.am.E(jVar.baV()));
        }
    }

    private void beC() {
        if (this.fTD) {
            com.baidu.tbadk.core.util.aj.s(this.fTA, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.aj.s(this.fTB, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.aj.r(this.fTC, d.C0140d.cp_cont_e);
            this.fTA.setClickable(false);
            this.fTC.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.aj.s(this.fTA, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.aj.s(this.fTB, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.r(this.fTC, d.C0140d.text_contf_50_color);
        this.fTA.setClickable(true);
        this.fTC.setClickable(true);
    }

    public void beD() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.t(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void beE() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
