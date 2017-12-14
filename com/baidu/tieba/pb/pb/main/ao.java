package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ao extends j.a {
    public View dsF;
    public ImageView fbs;
    public TextView fbt;
    public TextView fbu;
    public View fbv;
    public View fbw;
    public ImageView fbx;
    public TextView fby;
    public View mRootView;

    public ao(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fbs = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fbt = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fby = (TextView) view.findViewById(d.g.tv_share);
            this.fbu = (TextView) view.findViewById(d.g.tv_praise);
            this.fbv = view.findViewById(d.g.praise_container);
            this.fbw = view.findViewById(d.g.share_container);
            this.fbx = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.dsF = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean wI() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.xE();
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aRW()) {
                if (lVar.eQa == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fbs, d.f.icon_floor_big_praised);
                } else if (lVar.eQa == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fbs, d.f.icon_floor_trample);
                } else if (lVar.eQa == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fbs, d.f.icon_floor_big_trample);
                } else if (lVar.aRY() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fbs, wI() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fbs, wI() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.i(this.fbu, d.C0096d.text_conth_50_color);
                this.fbv.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fbs, wI() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.i(this.fbu, d.C0096d.text_contf_50_color);
                this.fbv.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            aVE();
            if (lVar.cLI > 0) {
                if (com.baidu.tbadk.core.util.am.dU(com.baidu.tbadk.core.util.am.v(lVar.cLI)) >= 6) {
                    this.fby.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fby.setText(com.baidu.tbadk.core.util.am.v(lVar.cLI));
            } else {
                this.fby.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.i(this.fbt, d.C0096d.cp_link_tip_c);
            this.fbs.setTag(d.g.pb_main_thread_praise_data, lVar);
            this.fbu.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aSa()) {
                com.baidu.tbadk.core.util.aj.k(this.dsF, d.C0096d.cp_bg_line_c);
                this.dsF.setVisibility(0);
            } else {
                this.dsF.setVisibility(8);
            }
            if (lVar.aRV() <= 0 || com.baidu.tbadk.core.util.v.w(lVar.aRX())) {
                this.fbt.setText(d.j.no_praise_tip);
                this.fbu.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.i(this.fbt, d.C0096d.cp_cont_f);
                this.fbt.setTag(false);
                this.fbv.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.i(this.fbu, d.C0096d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fbs, wI() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fbt.setTag(true);
            this.fbt.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.aRV())));
            this.fbu.setText(com.baidu.tbadk.core.util.am.v(lVar.aRV()));
        }
    }

    private void aVE() {
        this.fbw.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
        com.baidu.tbadk.core.util.aj.j(this.fbx, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.i(this.fby, d.C0096d.text_contf_50_color);
    }

    public void aVF() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.f(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void aVG() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
