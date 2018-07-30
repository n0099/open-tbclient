package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class aq extends q.a {
    public View dZA;
    public ImageView fEr;
    public TextView fEs;
    public TextView fEt;
    public View fEu;
    public View fEv;
    public ImageView fEw;
    public TextView fEx;
    private boolean fEy;
    public View mRootView;

    public aq(View view) {
        super(view);
        this.fEy = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fEr = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fEs = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fEx = (TextView) view.findViewById(d.g.tv_share);
            this.fEt = (TextView) view.findViewById(d.g.tv_praise);
            this.fEu = view.findViewById(d.g.praise_container);
            this.fEv = view.findViewById(d.g.share_container);
            this.fEw = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.dZA = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean AO() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BM();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.aZT()) {
                if (jVar.ftm == 1) {
                    com.baidu.tbadk.core.util.am.c(this.fEr, d.f.icon_floor_big_praised);
                } else if (jVar.ftm == 3) {
                    com.baidu.tbadk.core.util.am.c(this.fEr, d.f.icon_floor_trample);
                } else if (jVar.ftm == 4) {
                    com.baidu.tbadk.core.util.am.c(this.fEr, d.f.icon_floor_big_trample);
                } else if (jVar.aZV() == 1) {
                    com.baidu.tbadk.core.util.am.c(this.fEr, AO() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.am.c(this.fEr, AO() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.am.h(this.fEt, d.C0140d.text_conth_50_color);
                this.fEu.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.am.c(this.fEr, AO() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.am.h(this.fEt, d.C0140d.text_contf_50_color);
                this.fEu.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fEy = jVar.aZS();
            bdy();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.ap.eJ(com.baidu.tbadk.core.util.ap.C(jVar.shareNum)) >= 6) {
                    this.fEx.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fEx.setText(com.baidu.tbadk.core.util.ap.C(jVar.shareNum));
            } else {
                this.fEx.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.am.h(this.fEs, d.C0140d.cp_link_tip_c);
            this.fEr.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fEt.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.aZX()) {
                com.baidu.tbadk.core.util.am.j(this.dZA, d.C0140d.cp_bg_line_c);
                this.dZA.setVisibility(0);
            } else {
                this.dZA.setVisibility(8);
            }
            if (jVar.aZR() <= 0 || com.baidu.tbadk.core.util.w.z(jVar.aZU())) {
                this.fEs.setText(d.j.no_praise_tip);
                this.fEt.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.am.h(this.fEs, d.C0140d.cp_cont_f);
                this.fEs.setTag(false);
                this.fEu.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.am.h(this.fEt, d.C0140d.text_contf_50_color);
                com.baidu.tbadk.core.util.am.c(this.fEr, AO() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fEs.setTag(true);
            this.fEs.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.ap.C(jVar.aZR())));
            this.fEt.setText(com.baidu.tbadk.core.util.ap.C(jVar.aZR()));
        }
    }

    private void bdy() {
        if (this.fEy) {
            com.baidu.tbadk.core.util.am.i(this.fEv, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.am.i(this.fEw, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.am.h(this.fEx, d.C0140d.cp_cont_e);
            this.fEv.setClickable(false);
            this.fEx.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.am.i(this.fEv, d.f.bg_gray_round_border_shape);
        com.baidu.tbadk.core.util.am.i(this.fEw, d.f.icon_topbar_share_n);
        com.baidu.tbadk.core.util.am.h(this.fEx, d.C0140d.text_contf_50_color);
        this.fEv.setClickable(true);
        this.fEx.setClickable(true);
    }

    public void bdz() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.f(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void bdA() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
