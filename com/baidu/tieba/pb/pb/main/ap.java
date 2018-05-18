package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends q.a {
    public View dGz;
    public ImageView foK;
    public TextView foL;
    public TextView foM;
    public View foN;
    public View foO;
    public ImageView foP;
    public TextView foQ;
    private boolean foR;
    public View mRootView;

    public ap(View view2) {
        super(view2);
        this.foR = false;
        if (view2 != null) {
            this.mRootView = view2.findViewById(d.g.thread_praise_root);
            this.foK = (ImageView) view2.findViewById(d.g.view_main_thread_praise_state);
            this.foL = (TextView) view2.findViewById(d.g.view_main_thread_praise_num);
            this.foQ = (TextView) view2.findViewById(d.g.tv_share);
            this.foM = (TextView) view2.findViewById(d.g.tv_praise);
            this.foN = view2.findViewById(d.g.praise_container);
            this.foO = view2.findViewById(d.g.share_container);
            this.foP = (ImageView) view2.findViewById(d.g.view_main_thread_share_state);
            this.dGz = view2.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean xe() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.yd();
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null) {
            if (jVar.aVW()) {
                if (jVar.fdK == 1) {
                    com.baidu.tbadk.core.util.ak.c(this.foK, d.f.icon_floor_big_praised);
                } else if (jVar.fdK == 3) {
                    com.baidu.tbadk.core.util.ak.c(this.foK, d.f.icon_floor_trample);
                } else if (jVar.fdK == 4) {
                    com.baidu.tbadk.core.util.ak.c(this.foK, d.f.icon_floor_big_trample);
                } else if (jVar.aVY() == 1) {
                    com.baidu.tbadk.core.util.ak.c(this.foK, xe() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.ak.c(this.foK, xe() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.ak.h(this.foM, d.C0126d.text_conth_50_color);
                this.foN.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.ak.c(this.foK, xe() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.ak.h(this.foM, d.C0126d.text_contf_50_color);
                this.foN.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.foR = jVar.aVV();
            aZz();
            if (jVar.shareNum > 0) {
                if (com.baidu.tbadk.core.util.an.ej(com.baidu.tbadk.core.util.an.x(jVar.shareNum)) >= 6) {
                    this.foQ.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.foQ.setText(com.baidu.tbadk.core.util.an.x(jVar.shareNum));
            } else {
                this.foQ.setText(getView().getResources().getString(d.k.share));
            }
            com.baidu.tbadk.core.util.ak.h(this.foL, d.C0126d.cp_link_tip_c);
            this.foK.setTag(d.g.pb_main_thread_praise_data, jVar);
            this.foM.setTag(d.g.pb_main_thread_praise_data, jVar);
            if (jVar.aWa()) {
                com.baidu.tbadk.core.util.ak.j(this.dGz, d.C0126d.cp_bg_line_c);
                this.dGz.setVisibility(0);
            } else {
                this.dGz.setVisibility(8);
            }
            if (jVar.aVU() <= 0 || com.baidu.tbadk.core.util.v.w(jVar.aVX())) {
                this.foL.setText(d.k.no_praise_tip);
                this.foM.setText(d.k.action_praise_default);
                com.baidu.tbadk.core.util.ak.h(this.foL, d.C0126d.cp_cont_f);
                this.foL.setTag(false);
                this.foN.setBackgroundDrawable(com.baidu.tbadk.core.util.ak.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.ak.h(this.foM, d.C0126d.text_contf_50_color);
                com.baidu.tbadk.core.util.ak.c(this.foK, xe() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.foL.setTag(true);
            this.foL.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.count_main_thread_praise), com.baidu.tbadk.core.util.an.x(jVar.aVU())));
            this.foM.setText(com.baidu.tbadk.core.util.an.x(jVar.aVU()));
        }
    }

    private void aZz() {
        if (this.foR) {
            com.baidu.tbadk.core.util.ak.i(this.foO, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.ak.i(this.foP, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.ak.h(this.foQ, d.C0126d.cp_cont_e);
            this.foO.setClickable(false);
            this.foQ.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.ak.i(this.foO, d.f.bg_gray_round_border_shape);
        com.baidu.tbadk.core.util.ak.i(this.foP, d.f.icon_topbar_share_n);
        com.baidu.tbadk.core.util.ak.h(this.foQ, d.C0126d.text_contf_50_color);
        this.foO.setClickable(true);
        this.foQ.setClickable(true);
    }

    public void aZA() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.e(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void aZB() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
