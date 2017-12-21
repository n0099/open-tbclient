package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ao extends j.a {
    public View dsJ;
    public View fbA;
    public View fbB;
    public ImageView fbC;
    public TextView fbD;
    public ImageView fbx;
    public TextView fby;
    public TextView fbz;
    public View mRootView;

    public ao(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fbx = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fby = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fbD = (TextView) view.findViewById(d.g.tv_share);
            this.fbz = (TextView) view.findViewById(d.g.tv_praise);
            this.fbA = view.findViewById(d.g.praise_container);
            this.fbB = view.findViewById(d.g.share_container);
            this.fbC = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.dsJ = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean wI() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.xE();
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aRW()) {
                if (lVar.eQf == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fbx, d.f.icon_floor_big_praised);
                } else if (lVar.eQf == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fbx, d.f.icon_floor_trample);
                } else if (lVar.eQf == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fbx, d.f.icon_floor_big_trample);
                } else if (lVar.aRY() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fbx, wI() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fbx, wI() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.i(this.fbz, d.C0095d.text_conth_50_color);
                this.fbA.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fbx, wI() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.i(this.fbz, d.C0095d.text_contf_50_color);
                this.fbA.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            aVE();
            if (lVar.cLM > 0) {
                if (com.baidu.tbadk.core.util.am.dU(com.baidu.tbadk.core.util.am.v(lVar.cLM)) >= 6) {
                    this.fbD.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fbD.setText(com.baidu.tbadk.core.util.am.v(lVar.cLM));
            } else {
                this.fbD.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.i(this.fby, d.C0095d.cp_link_tip_c);
            this.fbx.setTag(d.g.pb_main_thread_praise_data, lVar);
            this.fbz.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aSa()) {
                com.baidu.tbadk.core.util.aj.k(this.dsJ, d.C0095d.cp_bg_line_c);
                this.dsJ.setVisibility(0);
            } else {
                this.dsJ.setVisibility(8);
            }
            if (lVar.aRV() <= 0 || com.baidu.tbadk.core.util.v.w(lVar.aRX())) {
                this.fby.setText(d.j.no_praise_tip);
                this.fbz.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.i(this.fby, d.C0095d.cp_cont_f);
                this.fby.setTag(false);
                this.fbA.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.i(this.fbz, d.C0095d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fbx, wI() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fby.setTag(true);
            this.fby.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.aRV())));
            this.fbz.setText(com.baidu.tbadk.core.util.am.v(lVar.aRV()));
        }
    }

    private void aVE() {
        this.fbB.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
        com.baidu.tbadk.core.util.aj.j(this.fbC, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.i(this.fbD, d.C0095d.text_contf_50_color);
    }

    public void aVF() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.f(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void aVG() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
