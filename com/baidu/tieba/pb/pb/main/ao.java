package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ao extends j.a {
    public View drA;
    public ImageView fap;
    public TextView faq;
    public TextView far;
    public View fas;
    public View fat;
    public ImageView fau;
    public TextView fav;
    public View mRootView;

    public ao(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.fap = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.faq = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.fav = (TextView) view.findViewById(d.g.tv_share);
            this.far = (TextView) view.findViewById(d.g.tv_praise);
            this.fas = view.findViewById(d.g.praise_container);
            this.fat = view.findViewById(d.g.share_container);
            this.fau = (ImageView) view.findViewById(d.g.view_main_thread_share_state);
            this.drA = view.findViewById(d.g.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aRN()) {
                if (lVar.eOX == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_floor_big_praised);
                } else if (lVar.eOX == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_floor_trample);
                } else if (lVar.eOX == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_floor_big_trample);
                } else if (lVar.aRP() == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_card_liked_n);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_floor_bigpraised);
                }
                com.baidu.tbadk.core.util.aj.i(this.far, d.C0082d.text_conth_50_color);
                this.fas.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector_orange));
            } else {
                com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_card_like_n);
                com.baidu.tbadk.core.util.aj.i(this.far, d.C0082d.text_contf_50_color);
                this.fas.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
            }
            aVv();
            if (lVar.cLy > 0) {
                if (com.baidu.tbadk.core.util.am.dU(com.baidu.tbadk.core.util.am.v(lVar.cLy)) >= 6) {
                    this.fav.setPadding((int) getView().getResources().getDimension(d.e.ds40), 0, (int) getView().getResources().getDimension(d.e.ds40), 0);
                }
                this.fav.setText(com.baidu.tbadk.core.util.am.v(lVar.cLy));
            } else {
                this.fav.setText(getView().getResources().getString(d.j.share));
            }
            com.baidu.tbadk.core.util.aj.i(this.faq, d.C0082d.cp_link_tip_c);
            this.fap.setTag(d.g.pb_main_thread_praise_data, lVar);
            this.far.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aRR()) {
                com.baidu.tbadk.core.util.aj.k(this.drA, d.C0082d.cp_bg_line_c);
                this.drA.setVisibility(0);
            } else {
                this.drA.setVisibility(8);
            }
            if (lVar.aRM() <= 0 || com.baidu.tbadk.core.util.v.w(lVar.aRO())) {
                this.faq.setText(d.j.no_praise_tip);
                this.far.setText(d.j.action_praise_default);
                com.baidu.tbadk.core.util.aj.i(this.faq, d.C0082d.cp_cont_f);
                this.faq.setTag(false);
                this.fas.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
                com.baidu.tbadk.core.util.aj.i(this.far, d.C0082d.text_contf_50_color);
                com.baidu.tbadk.core.util.aj.c(this.fap, d.f.icon_card_like_n);
                return;
            }
            this.faq.setTag(true);
            this.faq.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.aRM())));
            this.far.setText(com.baidu.tbadk.core.util.am.v(lVar.aRM()));
        }
    }

    private void aVv() {
        this.fat.setBackgroundDrawable(com.baidu.tbadk.core.util.aj.getDrawable(d.f.bg_first_floor_praise_border_selector));
        com.baidu.tbadk.core.util.aj.j(this.fau, d.f.icon_pb_first_floor_share_selector);
        com.baidu.tbadk.core.util.aj.i(this.fav, d.C0082d.text_contf_50_color);
    }

    public void aVw() {
        this.mRootView.setPadding(0, com.baidu.adp.lib.util.l.f(getView().getContext(), d.e.tbds56), 0, 0);
    }

    public void aVx() {
        this.mRootView.setPadding(0, 0, 0, 0);
    }
}
