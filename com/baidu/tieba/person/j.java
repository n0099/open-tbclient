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
    TextView aXj;
    TextView bHH;
    TextView ffa;
    TextView ffb;
    TextView ffc;
    View ffd;
    View ffe;
    View fff;
    View ffg;
    TbPageContext mF;
    View mView;

    public j(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mF = tbPageContext;
        a(this.mF, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.ffa = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.ffa.setOnClickListener(onClickListener);
        this.ffb = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.ffb.setOnClickListener(onClickListener);
        this.ffc = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.ffd = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.ffc.setOnClickListener(onClickListener);
        this.bHH = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bHH.setOnClickListener(onClickListener);
        this.aXj = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.ffe = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.fff = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.ffg = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void I(boolean z, boolean z2) {
        if (z) {
            this.ffa.setText(d.l.remove_friend);
        } else {
            this.ffa.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ffb.setText(d.l.remove_block_chat);
        } else {
            this.ffb.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aWY() {
        return this.ffa;
    }

    public View aWZ() {
        return this.ffb;
    }

    public View aXa() {
        return this.ffc;
    }

    public void qi(int i) {
        this.ffc.setVisibility(0);
        this.ffg.setVisibility(0);
        if (i == 0) {
            this.ffc.setText(this.mF.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.ffc.setText(this.mF.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aXj.setVisibility(0);
            this.ffe.setVisibility(0);
            this.aXj.setText(String.format(this.mF.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.e.cp_bg_line_d_alpha90);
        aj.i(this.ffb, d.e.cp_link_tip_a);
        aj.j(this.ffb, d.g.more_pop_item_bg_selector);
        aj.i(this.ffa, d.e.cp_link_tip_a);
        aj.j(this.ffa, d.g.more_pop_item_bg_selector);
        aj.i(this.ffc, d.e.cp_link_tip_a);
        aj.j(this.ffc, d.g.more_pop_item_bg_selector);
        aj.k(this.fff, d.e.cp_bg_line_b);
        aj.k(this.ffg, d.e.cp_bg_line_b);
        aj.k(this.ffe, d.e.cp_bg_line_b);
        aj.k(this.ffd, d.e.cp_bg_line_b);
        aj.j(this.bHH, d.g.person_more_pop_item_bg_selector);
        aj.i(this.bHH, d.g.person_more_pop_cancel_text_selector);
        aj.j(this.aXj, d.g.more_pop_item_bg_selector);
        aj.i(this.aXj, d.e.cp_cont_d);
    }
}
