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
    TextView aXA;
    TextView bDW;
    TextView ffR;
    TextView ffS;
    TextView ffT;
    View ffU;
    View ffV;
    View ffW;
    View ffX;
    View mView;
    TbPageContext oW;

    public j(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.oW = tbPageContext;
        a(this.oW, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.ffR = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.ffR.setOnClickListener(onClickListener);
        this.ffS = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.ffS.setOnClickListener(onClickListener);
        this.ffT = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.ffU = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.ffT.setOnClickListener(onClickListener);
        this.bDW = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bDW.setOnClickListener(onClickListener);
        this.aXA = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.ffV = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.ffW = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.ffX = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void H(boolean z, boolean z2) {
        if (z) {
            this.ffR.setText(d.l.remove_friend);
        } else {
            this.ffR.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ffS.setText(d.l.remove_block_chat);
        } else {
            this.ffS.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aXB() {
        return this.ffR;
    }

    public View aXC() {
        return this.ffS;
    }

    public View aXD() {
        return this.ffT;
    }

    public void qg(int i) {
        this.ffT.setVisibility(0);
        this.ffX.setVisibility(0);
        if (i == 0) {
            this.ffT.setText(this.oW.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.ffT.setText(this.oW.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aXA.setVisibility(0);
            this.ffV.setVisibility(0);
            this.aXA.setText(String.format(this.oW.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ai.j(this.mView, d.e.cp_bg_line_d_alpha90);
        ai.i(this.ffS, d.e.cp_link_tip_a);
        ai.j(this.ffS, d.g.more_pop_item_bg_selector);
        ai.i(this.ffR, d.e.cp_link_tip_a);
        ai.j(this.ffR, d.g.more_pop_item_bg_selector);
        ai.i(this.ffT, d.e.cp_link_tip_a);
        ai.j(this.ffT, d.g.more_pop_item_bg_selector);
        ai.k(this.ffW, d.e.cp_bg_line_b);
        ai.k(this.ffX, d.e.cp_bg_line_b);
        ai.k(this.ffV, d.e.cp_bg_line_b);
        ai.k(this.ffU, d.e.cp_bg_line_b);
        ai.j(this.bDW, d.g.person_more_pop_item_bg_selector);
        ai.i(this.bDW, d.g.person_more_pop_cancel_text_selector);
        ai.j(this.aXA, d.g.more_pop_item_bg_selector);
        ai.i(this.aXA, d.e.cp_cont_d);
    }
}
