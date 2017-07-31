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
    TextView aXy;
    TbPageContext alI;
    TextView bDm;
    TextView fdW;
    TextView fdX;
    TextView fdY;
    View fdZ;
    View fea;
    View feb;
    View fec;
    View mView;

    public j(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.alI = tbPageContext;
        a(this.alI, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.fdW = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.fdW.setOnClickListener(onClickListener);
        this.fdX = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.fdX.setOnClickListener(onClickListener);
        this.fdY = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.fdZ = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.fdY.setOnClickListener(onClickListener);
        this.bDm = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bDm.setOnClickListener(onClickListener);
        this.aXy = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.fea = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.feb = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.fec = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void G(boolean z, boolean z2) {
        if (z) {
            this.fdW.setText(d.l.remove_friend);
        } else {
            this.fdW.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fdX.setText(d.l.remove_block_chat);
        } else {
            this.fdX.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aWZ() {
        return this.fdW;
    }

    public View aXa() {
        return this.fdX;
    }

    public View aXb() {
        return this.fdY;
    }

    public void pW(int i) {
        this.fdY.setVisibility(0);
        this.fec.setVisibility(0);
        if (i == 0) {
            this.fdY.setText(this.alI.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.fdY.setText(this.alI.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aXy.setVisibility(0);
            this.fea.setVisibility(0);
            this.aXy.setText(String.format(this.alI.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ai.j(this.mView, d.e.cp_bg_line_d_alpha90);
        ai.i(this.fdX, d.e.cp_link_tip_a);
        ai.j(this.fdX, d.g.more_pop_item_bg_selector);
        ai.i(this.fdW, d.e.cp_link_tip_a);
        ai.j(this.fdW, d.g.more_pop_item_bg_selector);
        ai.i(this.fdY, d.e.cp_link_tip_a);
        ai.j(this.fdY, d.g.more_pop_item_bg_selector);
        ai.k(this.feb, d.e.cp_bg_line_b);
        ai.k(this.fec, d.e.cp_bg_line_b);
        ai.k(this.fea, d.e.cp_bg_line_b);
        ai.k(this.fdZ, d.e.cp_bg_line_b);
        ai.j(this.bDm, d.g.person_more_pop_item_bg_selector);
        ai.i(this.bDm, d.g.person_more_pop_cancel_text_selector);
        ai.j(this.aXy, d.g.more_pop_item_bg_selector);
        ai.i(this.aXy, d.e.cp_cont_d);
    }
}
