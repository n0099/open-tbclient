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
    TextView bcv;
    TextView cip;
    TextView eZB;
    View frA;
    TextView frt;
    TextView fru;
    TextView frv;
    View frw;
    View frx;
    View fry;
    View frz;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.frt = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.frt.setOnClickListener(onClickListener);
        this.eZB = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.eZB.setOnClickListener(onClickListener);
        this.fru = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fru.setOnClickListener(onClickListener);
        this.frv = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.frw = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.frv.setOnClickListener(onClickListener);
        this.cip = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cip.setOnClickListener(onClickListener);
        this.bcv = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.frx = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fry = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.frz = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.frA = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.frt.setText(d.j.remove_friend);
        } else {
            this.frt.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fru.setText(d.j.remove_block_chat);
        } else {
            this.fru.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aZV() {
        return this.frt;
    }

    public View aZW() {
        return this.fru;
    }

    public View aZX() {
        return this.frv;
    }

    public View aZY() {
        return this.eZB;
    }

    public void qS(int i) {
        this.frv.setVisibility(0);
        this.frA.setVisibility(0);
        if (i == 0) {
            this.frv.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.frv.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcv.setVisibility(0);
            this.frx.setVisibility(0);
            this.bcv.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.C0096d.cp_bg_line_d_alpha90);
        aj.i(this.fru, d.C0096d.cp_link_tip_a);
        aj.j(this.fru, d.f.more_pop_item_bg_selector);
        aj.i(this.frt, d.C0096d.cp_link_tip_a);
        aj.j(this.frt, d.f.more_pop_item_bg_selector);
        aj.i(this.eZB, d.C0096d.cp_link_tip_a);
        aj.j(this.eZB, d.f.more_pop_item_bg_selector);
        aj.i(this.frv, d.C0096d.cp_link_tip_a);
        aj.j(this.frv, d.f.more_pop_item_bg_selector);
        aj.k(this.fry, d.C0096d.cp_bg_line_b);
        aj.k(this.frz, d.C0096d.cp_bg_line_b);
        aj.k(this.frA, d.C0096d.cp_bg_line_b);
        aj.k(this.frx, d.C0096d.cp_bg_line_b);
        aj.k(this.frw, d.C0096d.cp_bg_line_b);
        aj.j(this.cip, d.f.person_more_pop_item_bg_selector);
        aj.i(this.cip, d.f.person_more_pop_cancel_text_selector);
        aj.j(this.bcv, d.f.more_pop_item_bg_selector);
        aj.i(this.bcv, d.C0096d.cp_cont_d);
    }
}
