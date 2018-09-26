package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c {
    TextView cMm;
    TextView cyw;
    TextView fJV;
    TextView gak;
    TextView gal;
    TextView gam;
    View gan;
    View gao;
    View gap;
    View gaq;
    View gar;
    TextView gas;
    View gat;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.person_info_more_view, (ViewGroup) null);
        this.gak = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.gak.setOnClickListener(onClickListener);
        this.fJV = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.fJV.setOnClickListener(onClickListener);
        this.gal = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.gal.setOnClickListener(onClickListener);
        this.gam = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.gan = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.gam.setOnClickListener(onClickListener);
        this.cMm = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.cMm.setOnClickListener(onClickListener);
        this.cyw = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.gao = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.gap = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.gaq = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.gar = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.gas = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.gat = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.gas.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.gak.setText(e.j.remove_friend);
        } else {
            this.gak.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gal.setText(e.j.remove_block_chat);
        } else {
            this.gal.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.gas.setVisibility(0);
            this.gat.setVisibility(0);
            return;
        }
        this.gas.setVisibility(8);
        this.gat.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bjS() {
        return this.gak;
    }

    public View bjT() {
        return this.gal;
    }

    public View bjU() {
        return this.gam;
    }

    public View bjV() {
        return this.fJV;
    }

    public View bjW() {
        return this.gas;
    }

    public void rN(int i) {
        this.gam.setVisibility(0);
        this.gar.setVisibility(0);
        if (i == 0) {
            this.gam.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.gam.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cyw.setVisibility(8);
            this.gao.setVisibility(8);
            return;
        }
        this.cyw.setVisibility(0);
        this.gao.setVisibility(0);
        this.cyw.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.gal, e.d.cp_link_tip_a);
        al.i(this.gal, e.f.more_pop_item_bg_selector);
        al.h(this.gak, e.d.cp_link_tip_a);
        al.i(this.gak, e.f.more_pop_item_bg_selector);
        al.h(this.fJV, e.d.cp_link_tip_a);
        al.i(this.fJV, e.f.more_pop_item_bg_selector);
        al.h(this.gam, e.d.cp_link_tip_a);
        al.i(this.gam, e.f.more_pop_item_bg_selector);
        al.j(this.gap, e.d.cp_bg_line_b);
        al.j(this.gaq, e.d.cp_bg_line_b);
        al.j(this.gar, e.d.cp_bg_line_b);
        al.j(this.gao, e.d.cp_bg_line_b);
        al.j(this.gan, e.d.cp_bg_line_b);
        al.i(this.cMm, e.f.person_more_pop_item_bg_selector);
        al.h(this.cMm, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cyw, e.f.more_pop_item_bg_selector);
        al.h(this.cyw, e.d.cp_cont_d);
        al.h(this.gas, e.d.cp_link_tip_a);
        al.i(this.gas, e.f.more_pop_item_bg_selector);
        al.j(this.gat, e.d.cp_bg_line_b);
    }
}
