package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends r.a {
    public View eeP;
    public ImageView fOp;
    public TextView fOq;
    public TextView fOr;
    public View fOs;
    public View fOt;
    public ImageView fOu;
    public TextView fOv;
    private boolean fOw;
    public View mRootView;

    public ap(View view) {
        super(view);
        this.fOw = false;
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fOp = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.fOq = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fOv = (TextView) view.findViewById(d.g.tv_share);
            this.fOr = (TextView) view.findViewById(d.g.tv_praise);
            this.fOs = view.findViewById(d.g.praise_container);
            this.fOt = view.findViewById(d.g.share_container);
            this.fOu = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.eeP = view.findViewById(d.g.bottom_divider_line);
        }
    }

    private boolean Eg() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fd();
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aZj()) {
                if (lVar.fCF == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fOp, d.f.icon_floor_big_praised);
                } else if (lVar.fCF == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fOp, d.f.icon_floor_trample);
                } else if (lVar.fCF == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fOp, d.f.icon_floor_big_trample);
                } else if (lVar.aZl() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fOp, Eg() ? d.f.icon_card_liked_n_xmas : d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fOp, Eg() ? d.f.icon_floor_bigpraised_xmas : d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.r(this.fOr, d.C0108d.text_conth_50_color);
                this.fOs.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fOp, Eg() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.r(this.fOr, d.C0108d.text_contf_50_color);
                this.fOs.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            this.fOw = lVar.aZi();
            bcR();
            if (lVar.dAR > 0) {
                if (com.baidu.tbadk.core.util.am.eb(com.baidu.tbadk.core.util.am.D(lVar.dAR)) >= 6) {
                    this.fOv.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fOv.setText(com.baidu.tbadk.core.util.am.D(lVar.dAR));
            } else {
                this.fOv.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.r(this.fOq, d.C0108d.cp_link_tip_c);
            this.fOp.setTag(d.g.pb_main_thread_praise_data, lVar);
            this.fOr.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aZn()) {
                com.baidu.tbadk.core.util.aj.t(this.eeP, d.C0108d.cp_bg_line_c);
                this.eeP.setVisibility(0);
            } else {
                this.eeP.setVisibility(8);
            }
            if (lVar.aZh() <= 0 || com.baidu.tbadk.core.util.v.G(lVar.aZk())) {
                this.fOq.setText(d.j.no_praise_tip);
                this.fOr.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.r(this.fOq, d.C0108d.cp_cont_f);
                this.fOq.setTag(false);
                this.fOs.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.r(this.fOr, d.C0108d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fOp, Eg() ? d.f.icon_card_like_n_xmas : d.f.icon_card_like_n);
                return;
            }
            this.fOq.setTag(true);
            this.fOq.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.D(lVar.aZh())));
            this.fOr.setText(com.baidu.tbadk.core.util.am.D(lVar.aZh()));
        }
    }

    private void bcR() {
        if (this.fOw) {
            com.baidu.tbadk.core.util.aj.s(this.fOt, d.f.bg_gray_round_border_shape_s);
            com.baidu.tbadk.core.util.aj.s(this.fOu, d.f.icon_topbar_share_d);
            com.baidu.tbadk.core.util.aj.r(this.fOv, d.C0108d.cp_cont_e);
            this.fOt.setClickable(false);
            this.fOv.setClickable(false);
            return;
        }
        com.baidu.tbadk.core.util.aj.s(this.fOt, d.f.bg_first_floor_praise_border_selector);
        com.baidu.tbadk.core.util.aj.s(this.fOu, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.r(this.fOv, d.C0108d.text_contf_50_color);
        this.fOt.setClickable(true);
        this.fOv.setClickable(true);
    }

    public void bcS() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.s(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void bcT() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
