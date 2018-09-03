package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class aq extends q.a {
    public View dZx;
    public ImageView fEk;
    public TextView fEl;
    public TextView fEm;
    public View fEn;
    public View fEo;
    public ImageView fEp;
    public TextView fEq;
    private boolean fEr;
    public View mRootView;

    public aq(View view) {
        super(view);
        this.fEr = false;
        if (view != null) {
            this.mRootView = view.findViewById(f.g.thread_praise_root);
            this.fEk = (ImageView) view.findViewById(f.g.view_main_thread_praise_state);
            this.fEl = (TextView) view.findViewById(f.g.view_main_thread_praise_num);
            this.fEq = (TextView) view.findViewById(f.g.tv_share);
            this.fEm = (TextView) view.findViewById(f.g.tv_praise);
            this.fEn = view.findViewById(f.g.praise_container);
            this.fEo = view.findViewById(f.g.share_container);
            this.fEp = (ImageView) view.findViewById(f.g.view_main_thread_share_state);
            this.dZx = view.findViewById(f.g.bottom_divider_line);
        }
    }

    private boolean AL() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BJ();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.aZO()) {
                if (jVar.ftf == 1) {
                    com.baidu.tbadk.core.util.am.c(this.fEk, f.C0146f.icon_floor_big_praised);
                } else if (jVar.ftf == 3) {
                    com.baidu.tbadk.core.util.am.c(this.fEk, f.C0146f.icon_floor_trample);
                } else if (jVar.ftf == 4) {
                    com.baidu.tbadk.core.util.am.c(this.fEk, f.C0146f.icon_floor_big_trample);
                } else if (jVar.aZQ() == 1) {
                    com.baidu.tbadk.core.util.am.c(this.fEk, AL() ? f.C0146f.icon_card_liked_n_xmas : f.C0146f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.am.c(this.fEk, AL() ? f.C0146f.icon_floor_bigpraised_xmas : f.C0146f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.am.h(this.fEm, f.d.text_conth_50_color);
                this.fEn.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.am.c(this.fEk, AL() ? f.C0146f.icon_card_like_n_xmas : f.C0146f.icon_card_like_n);
                com.baidu.tbadk.core.util.am.h(this.fEm, f.d.text_contf_50_color);
                this.fEn.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.bg_first_floor_praise_border_selector));
            }
            this.fEr = jVar.aZN();
            bdt();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.ap.eJ(com.baidu.tbadk.core.util.ap.C(jVar.shareNum)) >= 6) {
                    this.fEq.setPadding((int) getView().getResources().getDimension(f.e.ds40), 0, (int) getView().getResources().getDimension(f.e.ds40), 0);
                }
                this.fEq.setText(com.baidu.tbadk.core.util.ap.C(jVar.shareNum));
            } else {
                this.fEq.setText(getView().getResources().getString(f.j.share));
            }
            com.baidu.tbadk.core.util.am.h(this.fEl, f.d.cp_link_tip_c);
            this.fEk.setTag(f.g.pb_main_thread_praise_data, jVar);
            this.fEm.setTag(f.g.pb_main_thread_praise_data, jVar);
            if (jVar.aZS()) {
                com.baidu.tbadk.core.util.am.j(this.dZx, f.d.cp_bg_line_c);
                this.dZx.setVisibility(0);
            } else {
                this.dZx.setVisibility(8);
            }
            if (jVar.aZM() <= 0 || com.baidu.tbadk.core.util.w.z(jVar.aZP())) {
                this.fEl.setText(f.j.no_praise_tip);
                this.fEm.setText(f.j.action_praise_default);
                com.baidu.tbadk.core.util.am.h(this.fEl, f.d.cp_cont_f);
                this.fEl.setTag(false);
                this.fEn.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.am.h(this.fEm, f.d.text_contf_50_color);
                com.baidu.tbadk.core.util.am.c(this.fEk, AL() ? f.C0146f.icon_card_like_n_xmas : f.C0146f.icon_card_like_n);
                return;
            }
            this.fEl.setTag(true);
            this.fEl.setText(String.format(TbadkCoreApplication.getInst().getString(f.j.count_main_thread_praise), com.baidu.tbadk.core.util.ap.C(jVar.aZM())));
            this.fEm.setText(com.baidu.tbadk.core.util.ap.C(jVar.aZM()));
        }
    }

    private void bdt() {
        if (this.fEr) {
            com.baidu.tbadk.core.util.am.i(this.fEo, f.C0146f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.am.i(this.fEp, f.C0146f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.am.h(this.fEq, f.d.cp_cont_e);
            this.fEo.setClickable(false);
            this.fEq.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.am.i(this.fEo, f.C0146f.bg_gray_round_border_shape);
        com.baidu.tbadk.core.util.am.i(this.fEp, f.C0146f.icon_topbar_share_n);
        com.baidu.tbadk.core.util.am.h(this.fEq, f.d.text_contf_50_color);
        this.fEo.setClickable(true);
        this.fEq.setClickable(true);
    }

    public void bdu() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.f(getView().getContext(), f.e.tbds56), 0, 0);
    }

    public void bdv() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
