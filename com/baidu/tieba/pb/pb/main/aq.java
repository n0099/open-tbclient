package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class aq extends q.a {
    public View dVI;
    public ImageView fEe;
    public TextView fEf;
    public TextView fEg;
    public View fEh;
    public View fEi;
    public ImageView fEj;
    public TextView fEk;
    private boolean fEl;
    public View mRootView;

    public aq(View view) {
        super(view);
        this.fEl = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fEe = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fEf = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fEk = (TextView) view.findViewById(d.g.tv_share);
            this.fEg = (TextView) view.findViewById(d.g.tv_praise);
            this.fEh = view.findViewById(d.g.praise_container);
            this.fEi = view.findViewById(d.g.share_container);
            this.fEj = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.dVI = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean AX() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BU();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.bbA()) {
                if (jVar.fta == 1) {
                    com.baidu.tbadk.core.util.am.c(this.fEe, d.f.icon_floor_big_praised);
                } else if (jVar.fta == 3) {
                    com.baidu.tbadk.core.util.am.c(this.fEe, d.f.icon_floor_trample);
                } else if (jVar.fta == 4) {
                    com.baidu.tbadk.core.util.am.c(this.fEe, d.f.icon_floor_big_trample);
                } else if (jVar.bbC() == 1) {
                    com.baidu.tbadk.core.util.am.c(this.fEe, AX() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.am.c(this.fEe, AX() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.am.h(this.fEg, d.C0142d.text_conth_50_color);
                this.fEh.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.am.c(this.fEe, AX() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.am.h(this.fEg, d.C0142d.text_contf_50_color);
                this.fEh.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fEl = jVar.bbz();
            bff();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.ap.eL(com.baidu.tbadk.core.util.ap.B(jVar.shareNum)) >= 6) {
                    this.fEk.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fEk.setText(com.baidu.tbadk.core.util.ap.B(jVar.shareNum));
            } else {
                this.fEk.setText(getView().getResources().getString(d.k.share));
            }
            com.baidu.tbadk.core.util.am.h(this.fEf, d.C0142d.cp_link_tip_c);
            this.fEe.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fEg.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.bbE()) {
                com.baidu.tbadk.core.util.am.j(this.dVI, d.C0142d.cp_bg_line_c);
                this.dVI.setVisibility(0);
            } else {
                this.dVI.setVisibility(8);
            }
            if (jVar.bby() <= 0 || com.baidu.tbadk.core.util.w.A(jVar.bbB())) {
                this.fEf.setText(d.k.no_praise_tip);
                this.fEg.setText(d.k.action_praise_default);
                com.baidu.tbadk.core.util.am.h(this.fEf, d.C0142d.cp_cont_f);
                this.fEf.setTag(false);
                this.fEh.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.am.h(this.fEg, d.C0142d.text_contf_50_color);
                com.baidu.tbadk.core.util.am.c(this.fEe, AX() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fEf.setTag(true);
            this.fEf.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.count_main_thread_praise), com.baidu.tbadk.core.util.ap.B(jVar.bby())));
            this.fEg.setText(com.baidu.tbadk.core.util.ap.B(jVar.bby()));
        }
    }

    private void bff() {
        if (this.fEl) {
            com.baidu.tbadk.core.util.am.i(this.fEi, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.am.i(this.fEj, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.am.h(this.fEk, d.C0142d.cp_cont_e);
            this.fEi.setClickable(false);
            this.fEk.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.am.i(this.fEi, d.f.bg_gray_round_border_shape);
        com.baidu.tbadk.core.util.am.i(this.fEj, d.f.icon_topbar_share_n);
        com.baidu.tbadk.core.util.am.h(this.fEk, d.C0142d.text_contf_50_color);
        this.fEi.setClickable(true);
        this.fEk.setClickable(true);
    }

    public void bfg() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.e(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void bfh() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
