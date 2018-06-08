package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends q.a {
    public View dRP;
    public ImageView fAd;
    public TextView fAe;
    public TextView fAf;
    public View fAg;
    public View fAh;
    public ImageView fAi;
    public TextView fAj;
    private boolean fAk;
    public View mRootView;

    public ap(View view) {
        super(view);
        this.fAk = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fAd = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fAe = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fAj = (TextView) view.findViewById(d.g.tv_share);
            this.fAf = (TextView) view.findViewById(d.g.tv_praise);
            this.fAg = view.findViewById(d.g.praise_container);
            this.fAh = view.findViewById(d.g.share_container);
            this.fAi = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.dRP = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean AF() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BD();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.baS()) {
                if (jVar.fpg == 1) {
                    com.baidu.tbadk.core.util.al.c(this.fAd, d.f.icon_floor_big_praised);
                } else if (jVar.fpg == 3) {
                    com.baidu.tbadk.core.util.al.c(this.fAd, d.f.icon_floor_trample);
                } else if (jVar.fpg == 4) {
                    com.baidu.tbadk.core.util.al.c(this.fAd, d.f.icon_floor_big_trample);
                } else if (jVar.baU() == 1) {
                    com.baidu.tbadk.core.util.al.c(this.fAd, AF() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.fAd, AF() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.al.h(this.fAf, d.C0141d.text_conth_50_color);
                this.fAg.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.al.c(this.fAd, AF() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.al.h(this.fAf, d.C0141d.text_contf_50_color);
                this.fAg.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fAk = jVar.baR();
            bex();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.ao.eI(com.baidu.tbadk.core.util.ao.A(jVar.shareNum)) >= 6) {
                    this.fAj.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fAj.setText(com.baidu.tbadk.core.util.ao.A(jVar.shareNum));
            } else {
                this.fAj.setText(getView().getResources().getString(d.k.share));
            }
            com.baidu.tbadk.core.util.al.h(this.fAe, d.C0141d.cp_link_tip_c);
            this.fAd.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fAf.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.baW()) {
                com.baidu.tbadk.core.util.al.j(this.dRP, d.C0141d.cp_bg_line_c);
                this.dRP.setVisibility(0);
            } else {
                this.dRP.setVisibility(8);
            }
            if (jVar.baQ() <= 0 || com.baidu.tbadk.core.util.w.z(jVar.baT())) {
                this.fAe.setText(d.k.no_praise_tip);
                this.fAf.setText(d.k.action_praise_default);
                com.baidu.tbadk.core.util.al.h(this.fAe, d.C0141d.cp_cont_f);
                this.fAe.setTag(false);
                this.fAg.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.al.h(this.fAf, d.C0141d.text_contf_50_color);
                com.baidu.tbadk.core.util.al.c(this.fAd, AF() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fAe.setTag(true);
            this.fAe.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.count_main_thread_praise), com.baidu.tbadk.core.util.ao.A(jVar.baQ())));
            this.fAf.setText(com.baidu.tbadk.core.util.ao.A(jVar.baQ()));
        }
    }

    private void bex() {
        if (this.fAk) {
            com.baidu.tbadk.core.util.al.i(this.fAh, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.al.i(this.fAi, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.al.h(this.fAj, d.C0141d.cp_cont_e);
            this.fAh.setClickable(false);
            this.fAj.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.al.i(this.fAh, d.f.bg_gray_round_border_shape);
        com.baidu.tbadk.core.util.al.i(this.fAi, d.f.icon_topbar_share_n);
        com.baidu.tbadk.core.util.al.h(this.fAj, d.C0141d.text_contf_50_color);
        this.fAh.setClickable(true);
        this.fAj.setClickable(true);
    }

    public void bey() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.e(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void bez() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
