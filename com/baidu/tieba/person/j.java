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
public class j extends com.baidu.adp.base.c {
    TextView aXm;
    TextView bGQ;
    TextView feh;
    TextView fei;
    TextView fej;
    View fek;
    View fel;
    View fem;
    View fen;
    TbPageContext mF;
    View mView;

    public j(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mF = tbPageContext;
        a(this.mF, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.feh = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.feh.setOnClickListener(onClickListener);
        this.fei = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.fei.setOnClickListener(onClickListener);
        this.fej = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.fek = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.fej.setOnClickListener(onClickListener);
        this.bGQ = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bGQ.setOnClickListener(onClickListener);
        this.aXm = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.fel = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.fem = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.fen = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void I(boolean z, boolean z2) {
        if (z) {
            this.feh.setText(d.l.remove_friend);
        } else {
            this.feh.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fei.setText(d.l.remove_block_chat);
        } else {
            this.fei.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aWN() {
        return this.feh;
    }

    public View aWO() {
        return this.fei;
    }

    public View aWP() {
        return this.fej;
    }

    public void qg(int i) {
        this.fej.setVisibility(0);
        this.fen.setVisibility(0);
        if (i == 0) {
            this.fej.setText(this.mF.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.fej.setText(this.mF.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aXm.setVisibility(0);
            this.fel.setVisibility(0);
            this.aXm.setText(String.format(this.mF.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.e.cp_bg_line_d_alpha90);
        aj.i(this.fei, d.e.cp_link_tip_a);
        aj.j(this.fei, d.g.more_pop_item_bg_selector);
        aj.i(this.feh, d.e.cp_link_tip_a);
        aj.j(this.feh, d.g.more_pop_item_bg_selector);
        aj.i(this.fej, d.e.cp_link_tip_a);
        aj.j(this.fej, d.g.more_pop_item_bg_selector);
        aj.k(this.fem, d.e.cp_bg_line_b);
        aj.k(this.fen, d.e.cp_bg_line_b);
        aj.k(this.fel, d.e.cp_bg_line_b);
        aj.k(this.fek, d.e.cp_bg_line_b);
        aj.j(this.bGQ, d.g.person_more_pop_item_bg_selector);
        aj.i(this.bGQ, d.g.person_more_pop_cancel_text_selector);
        aj.j(this.aXm, d.g.more_pop_item_bg_selector);
        aj.i(this.aXm, d.e.cp_cont_d);
    }
}
