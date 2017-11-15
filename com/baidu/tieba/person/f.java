package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.c {
    TextView aZi;
    TextView bZD;
    TextView ePS;
    View fhA;
    View fhB;
    View fhC;
    View fhD;
    View fhE;
    TextView fhx;
    TextView fhy;
    TextView fhz;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.fhx = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fhx.setOnClickListener(onClickListener);
        this.ePS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.ePS.setOnClickListener(onClickListener);
        this.fhy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fhy.setOnClickListener(onClickListener);
        this.fhz = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fhA = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fhz.setOnClickListener(onClickListener);
        this.bZD = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bZD.setOnClickListener(onClickListener);
        this.aZi = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fhB = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fhC = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fhD = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fhE = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.fhx.setText(d.j.remove_friend);
        } else {
            this.fhx.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fhy.setText(d.j.remove_block_chat);
        } else {
            this.fhy.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aYl() {
        return this.fhx;
    }

    public View aYm() {
        return this.fhy;
    }

    public View aYn() {
        return this.fhz;
    }

    public View aYo() {
        return this.ePS;
    }

    public void qu(int i) {
        this.fhz.setVisibility(0);
        this.fhE.setVisibility(0);
        if (i == 0) {
            this.fhz.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.fhz.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aZi.setVisibility(0);
            this.fhB.setVisibility(0);
            this.aZi.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.C0080d.cp_bg_line_d_alpha90);
        aj.i(this.fhy, d.C0080d.cp_link_tip_a);
        aj.j(this.fhy, d.f.more_pop_item_bg_selector);
        aj.i(this.fhx, d.C0080d.cp_link_tip_a);
        aj.j(this.fhx, d.f.more_pop_item_bg_selector);
        aj.i(this.ePS, d.C0080d.cp_link_tip_a);
        aj.j(this.ePS, d.f.more_pop_item_bg_selector);
        aj.i(this.fhz, d.C0080d.cp_link_tip_a);
        aj.j(this.fhz, d.f.more_pop_item_bg_selector);
        aj.k(this.fhC, d.C0080d.cp_bg_line_b);
        aj.k(this.fhD, d.C0080d.cp_bg_line_b);
        aj.k(this.fhE, d.C0080d.cp_bg_line_b);
        aj.k(this.fhB, d.C0080d.cp_bg_line_b);
        aj.k(this.fhA, d.C0080d.cp_bg_line_b);
        aj.j(this.bZD, d.f.person_more_pop_item_bg_selector);
        aj.i(this.bZD, d.f.person_more_pop_cancel_text_selector);
        aj.j(this.aZi, d.f.more_pop_item_bg_selector);
        aj.i(this.aZi, d.C0080d.cp_cont_d);
    }
}
