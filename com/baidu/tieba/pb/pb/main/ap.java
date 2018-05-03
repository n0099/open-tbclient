package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends q.a {
    public View dFt;
    public ImageView fnC;
    public TextView fnD;
    public TextView fnE;
    public View fnF;
    public View fnG;
    public ImageView fnH;
    public TextView fnI;
    private boolean fnJ;
    public View mRootView;

    public ap(View view2) {
        super(view2);
        this.fnJ = false;
        if (view2 != null) {
            this.mRootView = view2.findViewById(d.g.thread_praise_root);
            this.fnC = (ImageView) view2.findViewById(d.g.view_main_thread_praise_state);
            this.fnD = (TextView) view2.findViewById(d.g.view_main_thread_praise_num);
            this.fnI = (TextView) view2.findViewById(d.g.tv_share);
            this.fnE = (TextView) view2.findViewById(d.g.tv_praise);
            this.fnF = view2.findViewById(d.g.praise_container);
            this.fnG = view2.findViewById(d.g.share_container);
            this.fnH = (ImageView) view2.findViewById(d.g.view_main_thread_share_state);
            this.dFt = view2.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean xf() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.ye();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.aVW()) {
                if (jVar.fcD == 1) {
                    com.baidu.tbadk.core.util.ak.c(this.fnC, d.f.icon_floor_big_praised);
                } else if (jVar.fcD == 3) {
                    com.baidu.tbadk.core.util.ak.c(this.fnC, d.f.icon_floor_trample);
                } else if (jVar.fcD == 4) {
                    com.baidu.tbadk.core.util.ak.c(this.fnC, d.f.icon_floor_big_trample);
                } else if (jVar.aVY() == 1) {
                    com.baidu.tbadk.core.util.ak.c(this.fnC, xf() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.ak.c(this.fnC, xf() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.ak.h(this.fnE, d.C0126d.text_conth_50_color);
                this.fnF.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.ak.c(this.fnC, xf() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.ak.h(this.fnE, d.C0126d.text_contf_50_color);
                this.fnF.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fnJ = jVar.aVV();
            aZz();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.an.ej(com.baidu.tbadk.core.util.an.x(jVar.shareNum)) >= 6) {
                    this.fnI.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fnI.setText(com.baidu.tbadk.core.util.an.x(jVar.shareNum));
            } else {
                this.fnI.setText(getView().getResources().getString(d.k.share));
            }
            com.baidu.tbadk.core.util.ak.h(this.fnD, d.C0126d.cp_link_tip_c);
            this.fnC.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fnE.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.aWa()) {
                com.baidu.tbadk.core.util.ak.j(this.dFt, d.C0126d.cp_bg_line_c);
                this.dFt.setVisibility(0);
            } else {
                this.dFt.setVisibility(8);
            }
            if (jVar.aVU() <= 0 || com.baidu.tbadk.core.util.v.w(jVar.aVX())) {
                this.fnD.setText(d.k.no_praise_tip);
                this.fnE.setText(d.k.action_praise_default);
                com.baidu.tbadk.core.util.ak.h(this.fnD, d.C0126d.cp_cont_f);
                this.fnD.setTag(false);
                this.fnF.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.ak.h(this.fnE, d.C0126d.text_contf_50_color);
                com.baidu.tbadk.core.util.ak.c(this.fnC, xf() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fnD.setTag(true);
            this.fnD.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.count_main_thread_praise), com.baidu.tbadk.core.util.an.x(jVar.aVU())));
            this.fnE.setText(com.baidu.tbadk.core.util.an.x(jVar.aVU()));
        }
    }

    private void aZz() {
        if (this.fnJ) {
            com.baidu.tbadk.core.util.ak.i(this.fnG, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.ak.i(this.fnH, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.ak.h(this.fnI, d.C0126d.cp_cont_e);
            this.fnG.setClickable(false);
            this.fnI.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.ak.i(this.fnG, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.ak.i(this.fnH, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.ak.h(this.fnI, d.C0126d.text_contf_50_color);
        this.fnG.setClickable(true);
        this.fnI.setClickable(true);
    }

    public void aZA() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.e(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void aZB() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
