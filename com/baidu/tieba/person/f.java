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
    TextView bQl;
    TextView cWW;
    TextView fMy;
    TextView gep;
    TextView geq;
    TextView ger;
    View ges;
    View get;
    View geu;
    View gev;
    View gew;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.gep = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.gep.setOnClickListener(onClickListener);
        this.fMy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fMy.setOnClickListener(onClickListener);
        this.geq = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.geq.setOnClickListener(onClickListener);
        this.ger = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.ges = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.ger.setOnClickListener(onClickListener);
        this.cWW = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cWW.setOnClickListener(onClickListener);
        this.bQl = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.get = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.geu = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.gev = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.gew = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void O(boolean z, boolean z2) {
        if (z) {
            this.gep.setText(d.j.remove_friend);
        } else {
            this.gep.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.geq.setText(d.j.remove_block_chat);
        } else {
            this.geq.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View bhl() {
        return this.gep;
    }

    public View bhm() {
        return this.geq;
    }

    public View bhn() {
        return this.ger;
    }

    public View bho() {
        return this.fMy;
    }

    public void tM(int i) {
        this.ger.setVisibility(0);
        this.gew.setVisibility(0);
        if (i == 0) {
            this.ger.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.ger.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bQl.setVisibility(0);
            this.get.setVisibility(0);
            this.bQl.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.s(this.mView, d.C0108d.cp_bg_line_d_alpha90);
        aj.r(this.geq, d.C0108d.cp_link_tip_a);
        aj.s(this.geq, d.f.more_pop_item_bg_selector);
        aj.r(this.gep, d.C0108d.cp_link_tip_a);
        aj.s(this.gep, d.f.more_pop_item_bg_selector);
        aj.r(this.fMy, d.C0108d.cp_link_tip_a);
        aj.s(this.fMy, d.f.more_pop_item_bg_selector);
        aj.r(this.ger, d.C0108d.cp_link_tip_a);
        aj.s(this.ger, d.f.more_pop_item_bg_selector);
        aj.t(this.geu, d.C0108d.cp_bg_line_b);
        aj.t(this.gev, d.C0108d.cp_bg_line_b);
        aj.t(this.gew, d.C0108d.cp_bg_line_b);
        aj.t(this.get, d.C0108d.cp_bg_line_b);
        aj.t(this.ges, d.C0108d.cp_bg_line_b);
        aj.s(this.cWW, d.f.person_more_pop_item_bg_selector);
        aj.r(this.cWW, d.f.person_more_pop_cancel_text_selector);
        aj.s(this.bQl, d.f.more_pop_item_bg_selector);
        aj.r(this.bQl, d.C0108d.cp_cont_d);
    }
}
