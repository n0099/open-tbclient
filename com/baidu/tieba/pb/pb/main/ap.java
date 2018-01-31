package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends r.a {
    public View egB;
    public ImageView fQk;
    public TextView fQl;
    public TextView fQm;
    public View fQn;
    public View fQo;
    public ImageView fQp;
    public TextView fQq;
    private boolean fQr;
    public View mRootView;

    public ap(View view) {
        super(view);
        this.fQr = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fQk = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fQl = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fQq = (TextView) view.findViewById(d.g.tv_share);
            this.fQm = (TextView) view.findViewById(d.g.tv_praise);
            this.fQn = view.findViewById(d.g.praise_container);
            this.fQo = view.findViewById(d.g.share_container);
            this.fQp = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.egB = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean DZ() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.EW();
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aZs()) {
                if (lVar.fEA == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fQk, d.f.icon_floor_big_praised);
                } else if (lVar.fEA == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fQk, d.f.icon_floor_trample);
                } else if (lVar.fEA == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fQk, d.f.icon_floor_big_trample);
                } else if (lVar.aZu() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fQk, DZ() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fQk, DZ() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.r(this.fQm, d.C0108d.text_conth_50_color);
                this.fQn.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fQk, DZ() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.r(this.fQm, d.C0108d.text_contf_50_color);
                this.fQn.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fQr = lVar.aZr();
            bda();
            if (lVar.dFN > 0) {
                if (com.baidu.tbadk.core.util.am.ef(com.baidu.tbadk.core.util.am.E(lVar.dFN)) >= 6) {
                    this.fQq.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fQq.setText(com.baidu.tbadk.core.util.am.E(lVar.dFN));
            } else {
                this.fQq.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.r(this.fQl, d.C0108d.cp_link_tip_c);
            this.fQk.setTag(d.g.pb_main_thread_praise_data, lVar);
            this.fQm.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aZw()) {
                com.baidu.tbadk.core.util.aj.t(this.egB, d.C0108d.cp_bg_line_c);
                this.egB.setVisibility(0);
            } else {
                this.egB.setVisibility(8);
            }
            if (lVar.aZq() <= 0 || com.baidu.tbadk.core.util.v.E(lVar.aZt())) {
                this.fQl.setText(d.j.no_praise_tip);
                this.fQm.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.r(this.fQl, d.C0108d.cp_cont_f);
                this.fQl.setTag(false);
                this.fQn.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.r(this.fQm, d.C0108d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fQk, DZ() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fQl.setTag(true);
            this.fQl.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.E(lVar.aZq())));
            this.fQm.setText(com.baidu.tbadk.core.util.am.E(lVar.aZq()));
        }
    }

    private void bda() {
        if (this.fQr) {
            com.baidu.tbadk.core.util.aj.s(this.fQo, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.aj.s(this.fQp, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.aj.r(this.fQq, d.C0108d.cp_cont_e);
            this.fQo.setClickable(false);
            this.fQq.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.aj.s(this.fQo, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.aj.s(this.fQp, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.r(this.fQq, d.C0108d.text_contf_50_color);
        this.fQo.setClickable(true);
        this.fQq.setClickable(true);
    }

    public void bdb() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.s(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void bdc() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
