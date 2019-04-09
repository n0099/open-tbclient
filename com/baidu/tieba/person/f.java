package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c {
    TextView bjN;
    TextView dYS;
    TextView hJS;
    TextView hJT;
    TextView hJU;
    View hJV;
    View hJW;
    View hJX;
    View hJY;
    View hJZ;
    TextView hKa;
    View hKb;
    TextView htx;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.hJS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.hJS.setOnClickListener(onClickListener);
        this.htx = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.htx.setOnClickListener(onClickListener);
        this.hJT = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.hJT.setOnClickListener(onClickListener);
        this.hJU = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.hJV = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.hJU.setOnClickListener(onClickListener);
        this.bjN = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bjN.setOnClickListener(onClickListener);
        this.dYS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.hJW = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.hJX = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.hJY = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.hJZ = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.hKa = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.hKb = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.hKa.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.hJS.setText(d.j.remove_friend);
        } else {
            this.hJS.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.hJT.setText(d.j.remove_block_chat);
        } else {
            this.hJT.setText(d.j.block_chat_message);
        }
        if (z3) {
            this.hKa.setVisibility(0);
            this.hKb.setVisibility(0);
            return;
        }
        this.hKa.setVisibility(8);
        this.hKb.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bQf() {
        return this.hJS;
    }

    public View bQg() {
        return this.hJT;
    }

    public View bQh() {
        return this.hJU;
    }

    public View bQi() {
        return this.htx;
    }

    public View bQj() {
        return this.hKa;
    }

    public void wU(int i) {
        this.hJU.setVisibility(0);
        this.hJZ.setVisibility(0);
        if (i == 0) {
            this.hJU.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.hJU.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dYS.setVisibility(8);
            this.hJW.setVisibility(8);
            return;
        }
        this.dYS.setVisibility(0);
        this.hJW.setVisibility(0);
        this.dYS.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, d.C0277d.cp_bg_line_d_alpha90);
        al.j(this.hJT, d.C0277d.cp_link_tip_a);
        al.k(this.hJT, d.f.more_pop_item_bg_selector);
        al.j(this.hJS, d.C0277d.cp_link_tip_a);
        al.k(this.hJS, d.f.more_pop_item_bg_selector);
        al.j(this.htx, d.C0277d.cp_link_tip_a);
        al.k(this.htx, d.f.more_pop_item_bg_selector);
        al.j(this.hJU, d.C0277d.cp_link_tip_a);
        al.k(this.hJU, d.f.more_pop_item_bg_selector);
        al.l(this.hJX, d.C0277d.cp_bg_line_b);
        al.l(this.hJY, d.C0277d.cp_bg_line_b);
        al.l(this.hJZ, d.C0277d.cp_bg_line_b);
        al.l(this.hJW, d.C0277d.cp_bg_line_b);
        al.l(this.hJV, d.C0277d.cp_bg_line_b);
        al.k(this.bjN, d.f.person_more_pop_item_bg_selector);
        al.j(this.bjN, d.f.person_more_pop_cancel_text_selector);
        al.k(this.dYS, d.f.more_pop_item_bg_selector);
        al.j(this.dYS, d.C0277d.cp_cont_d);
        al.j(this.hKa, d.C0277d.cp_link_tip_a);
        al.k(this.hKa, d.f.more_pop_item_bg_selector);
        al.l(this.hKb, d.C0277d.cp_bg_line_b);
    }
}
