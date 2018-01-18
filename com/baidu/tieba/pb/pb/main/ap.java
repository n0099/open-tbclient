package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends r.a {
    public View egg;
    public ImageView fPP;
    public TextView fPQ;
    public TextView fPR;
    public View fPS;
    public View fPT;
    public ImageView fPU;
    public TextView fPV;
    private boolean fPW;
    public View mRootView;

    public ap(View view) {
        super(view);
        this.fPW = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fPP = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fPQ = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fPV = (TextView) view.findViewById(d.g.tv_share);
            this.fPR = (TextView) view.findViewById(d.g.tv_praise);
            this.fPS = view.findViewById(d.g.praise_container);
            this.fPT = view.findViewById(d.g.share_container);
            this.fPU = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.egg = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean DX() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.EU();
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aZn()) {
                if (lVar.fEf == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fPP, d.f.icon_floor_big_praised);
                } else if (lVar.fEf == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fPP, d.f.icon_floor_trample);
                } else if (lVar.fEf == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fPP, d.f.icon_floor_big_trample);
                } else if (lVar.aZp() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fPP, DX() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fPP, DX() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.r(this.fPR, d.C0107d.text_conth_50_color);
                this.fPS.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fPP, DX() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.r(this.fPR, d.C0107d.text_contf_50_color);
                this.fPS.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fPW = lVar.aZm();
            bcV();
            if (lVar.dFs > 0) {
                if (com.baidu.tbadk.core.util.am.eb(com.baidu.tbadk.core.util.am.E(lVar.dFs)) >= 6) {
                    this.fPV.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fPV.setText(com.baidu.tbadk.core.util.am.E(lVar.dFs));
            } else {
                this.fPV.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.r(this.fPQ, d.C0107d.cp_link_tip_c);
            this.fPP.setTag(d.g.pb_main_thread_praise_data, lVar);
            this.fPR.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aZr()) {
                com.baidu.tbadk.core.util.aj.t(this.egg, d.C0107d.cp_bg_line_c);
                this.egg.setVisibility(0);
            } else {
                this.egg.setVisibility(8);
            }
            if (lVar.aZl() <= 0 || com.baidu.tbadk.core.util.v.E(lVar.aZo())) {
                this.fPQ.setText(d.j.no_praise_tip);
                this.fPR.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.r(this.fPQ, d.C0107d.cp_cont_f);
                this.fPQ.setTag(false);
                this.fPS.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.r(this.fPR, d.C0107d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fPP, DX() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fPQ.setTag(true);
            this.fPQ.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.E(lVar.aZl())));
            this.fPR.setText(com.baidu.tbadk.core.util.am.E(lVar.aZl()));
        }
    }

    private void bcV() {
        if (this.fPW) {
            com.baidu.tbadk.core.util.aj.s(this.fPT, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.aj.s(this.fPU, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.aj.r(this.fPV, d.C0107d.cp_cont_e);
            this.fPT.setClickable(false);
            this.fPV.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.aj.s(this.fPT, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.aj.s(this.fPU, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.r(this.fPV, d.C0107d.text_contf_50_color);
        this.fPT.setClickable(true);
        this.fPV.setClickable(true);
    }

    public void bcW() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.s(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void bcX() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
