package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends q.a {
    public View dFw;
    public ImageView fnF;
    public TextView fnG;
    public TextView fnH;
    public View fnI;
    public View fnJ;
    public ImageView fnK;
    public TextView fnL;
    private boolean fnM;
    public View mRootView;

    public ap(View view2) {
        super(view2);
        this.fnM = false;
        if (view2 != null) {
            this.mRootView = view2.findViewById(d.g.thread_praise_root);
            this.fnF = (ImageView) view2.findViewById(d.g.view_main_thread_praise_state);
            this.fnG = (TextView) view2.findViewById(d.g.view_main_thread_praise_num);
            this.fnL = (TextView) view2.findViewById(d.g.tv_share);
            this.fnH = (TextView) view2.findViewById(d.g.tv_praise);
            this.fnI = view2.findViewById(d.g.praise_container);
            this.fnJ = view2.findViewById(d.g.share_container);
            this.fnK = (ImageView) view2.findViewById(d.g.view_main_thread_share_state);
            this.dFw = view2.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean xf() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.ye();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.aVW()) {
                if (jVar.fcG == 1) {
                    com.baidu.tbadk.core.util.ak.c(this.fnF, d.f.icon_floor_big_praised);
                } else if (jVar.fcG == 3) {
                    com.baidu.tbadk.core.util.ak.c(this.fnF, d.f.icon_floor_trample);
                } else if (jVar.fcG == 4) {
                    com.baidu.tbadk.core.util.ak.c(this.fnF, d.f.icon_floor_big_trample);
                } else if (jVar.aVY() == 1) {
                    com.baidu.tbadk.core.util.ak.c(this.fnF, xf() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.ak.c(this.fnF, xf() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.ak.h(this.fnH, d.C0126d.text_conth_50_color);
                this.fnI.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.ak.c(this.fnF, xf() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.ak.h(this.fnH, d.C0126d.text_contf_50_color);
                this.fnI.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fnM = jVar.aVV();
            aZz();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.an.ej(com.baidu.tbadk.core.util.an.x(jVar.shareNum)) >= 6) {
                    this.fnL.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fnL.setText(com.baidu.tbadk.core.util.an.x(jVar.shareNum));
            } else {
                this.fnL.setText(getView().getResources().getString(d.k.share));
            }
            com.baidu.tbadk.core.util.ak.h(this.fnG, d.C0126d.cp_link_tip_c);
            this.fnF.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.fnH.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.aWa()) {
                com.baidu.tbadk.core.util.ak.j(this.dFw, d.C0126d.cp_bg_line_c);
                this.dFw.setVisibility(0);
            } else {
                this.dFw.setVisibility(8);
            }
            if (jVar.aVU() <= 0 || com.baidu.tbadk.core.util.v.w(jVar.aVX())) {
                this.fnG.setText(d.k.no_praise_tip);
                this.fnH.setText(d.k.action_praise_default);
                com.baidu.tbadk.core.util.ak.h(this.fnG, d.C0126d.cp_cont_f);
                this.fnG.setTag(false);
                this.fnI.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.ak.h(this.fnH, d.C0126d.text_contf_50_color);
                com.baidu.tbadk.core.util.ak.c(this.fnF, xf() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fnG.setTag(true);
            this.fnG.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.count_main_thread_praise), com.baidu.tbadk.core.util.an.x(jVar.aVU())));
            this.fnH.setText(com.baidu.tbadk.core.util.an.x(jVar.aVU()));
        }
    }

    private void aZz() {
        if (this.fnM) {
            com.baidu.tbadk.core.util.ak.i(this.fnJ, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.ak.i(this.fnK, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.ak.h(this.fnL, d.C0126d.cp_cont_e);
            this.fnJ.setClickable(false);
            this.fnL.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.ak.i(this.fnJ, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.ak.i(this.fnK, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.ak.h(this.fnL, d.C0126d.text_contf_50_color);
        this.fnJ.setClickable(true);
        this.fnL.setClickable(true);
    }

    public void aZA() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.e(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void aZB() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
