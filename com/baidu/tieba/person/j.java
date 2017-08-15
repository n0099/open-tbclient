package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.c {
    TextView aXz;
    TextView bDV;
    TextView ffP;
    TextView ffQ;
    TextView ffR;
    View ffS;
    View ffT;
    View ffU;
    View ffV;
    View mView;
    TbPageContext oV;

    public j(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.oV = tbPageContext;
        a(this.oV, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.ffP = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.ffP.setOnClickListener(onClickListener);
        this.ffQ = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.ffQ.setOnClickListener(onClickListener);
        this.ffR = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.ffS = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.ffR.setOnClickListener(onClickListener);
        this.bDV = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bDV.setOnClickListener(onClickListener);
        this.aXz = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.ffT = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.ffU = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.ffV = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void H(boolean z, boolean z2) {
        if (z) {
            this.ffP.setText(d.l.remove_friend);
        } else {
            this.ffP.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ffQ.setText(d.l.remove_block_chat);
        } else {
            this.ffQ.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aXG() {
        return this.ffP;
    }

    public View aXH() {
        return this.ffQ;
    }

    public View aXI() {
        return this.ffR;
    }

    public void qg(int i) {
        this.ffR.setVisibility(0);
        this.ffV.setVisibility(0);
        if (i == 0) {
            this.ffR.setText(this.oV.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.ffR.setText(this.oV.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aXz.setVisibility(0);
            this.ffT.setVisibility(0);
            this.aXz.setText(String.format(this.oV.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ai.j(this.mView, d.e.cp_bg_line_d_alpha90);
        ai.i(this.ffQ, d.e.cp_link_tip_a);
        ai.j(this.ffQ, d.g.more_pop_item_bg_selector);
        ai.i(this.ffP, d.e.cp_link_tip_a);
        ai.j(this.ffP, d.g.more_pop_item_bg_selector);
        ai.i(this.ffR, d.e.cp_link_tip_a);
        ai.j(this.ffR, d.g.more_pop_item_bg_selector);
        ai.k(this.ffU, d.e.cp_bg_line_b);
        ai.k(this.ffV, d.e.cp_bg_line_b);
        ai.k(this.ffT, d.e.cp_bg_line_b);
        ai.k(this.ffS, d.e.cp_bg_line_b);
        ai.j(this.bDV, d.g.person_more_pop_item_bg_selector);
        ai.i(this.bDV, d.g.person_more_pop_cancel_text_selector);
        ai.j(this.aXz, d.g.more_pop_item_bg_selector);
        ai.i(this.aXz, d.e.cp_cont_d);
    }
}
