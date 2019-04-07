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
    TextView bjM;
    TextView dYR;
    TextView hJR;
    TextView hJS;
    TextView hJT;
    View hJU;
    View hJV;
    View hJW;
    View hJX;
    View hJY;
    TextView hJZ;
    View hKa;
    TextView htw;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.hJR = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.hJR.setOnClickListener(onClickListener);
        this.htw = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.htw.setOnClickListener(onClickListener);
        this.hJS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.hJS.setOnClickListener(onClickListener);
        this.hJT = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.hJU = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.hJT.setOnClickListener(onClickListener);
        this.bjM = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bjM.setOnClickListener(onClickListener);
        this.dYR = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.hJV = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.hJW = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.hJX = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.hJY = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.hJZ = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.hKa = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.hJZ.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.hJR.setText(d.j.remove_friend);
        } else {
            this.hJR.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.hJS.setText(d.j.remove_block_chat);
        } else {
            this.hJS.setText(d.j.block_chat_message);
        }
        if (z3) {
            this.hJZ.setVisibility(0);
            this.hKa.setVisibility(0);
            return;
        }
        this.hJZ.setVisibility(8);
        this.hKa.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bQf() {
        return this.hJR;
    }

    public View bQg() {
        return this.hJS;
    }

    public View bQh() {
        return this.hJT;
    }

    public View bQi() {
        return this.htw;
    }

    public View bQj() {
        return this.hJZ;
    }

    public void wU(int i) {
        this.hJT.setVisibility(0);
        this.hJY.setVisibility(0);
        if (i == 0) {
            this.hJT.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.hJT.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dYR.setVisibility(8);
            this.hJV.setVisibility(8);
            return;
        }
        this.dYR.setVisibility(0);
        this.hJV.setVisibility(0);
        this.dYR.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, d.C0277d.cp_bg_line_d_alpha90);
        al.j(this.hJS, d.C0277d.cp_link_tip_a);
        al.k(this.hJS, d.f.more_pop_item_bg_selector);
        al.j(this.hJR, d.C0277d.cp_link_tip_a);
        al.k(this.hJR, d.f.more_pop_item_bg_selector);
        al.j(this.htw, d.C0277d.cp_link_tip_a);
        al.k(this.htw, d.f.more_pop_item_bg_selector);
        al.j(this.hJT, d.C0277d.cp_link_tip_a);
        al.k(this.hJT, d.f.more_pop_item_bg_selector);
        al.l(this.hJW, d.C0277d.cp_bg_line_b);
        al.l(this.hJX, d.C0277d.cp_bg_line_b);
        al.l(this.hJY, d.C0277d.cp_bg_line_b);
        al.l(this.hJV, d.C0277d.cp_bg_line_b);
        al.l(this.hJU, d.C0277d.cp_bg_line_b);
        al.k(this.bjM, d.f.person_more_pop_item_bg_selector);
        al.j(this.bjM, d.f.person_more_pop_cancel_text_selector);
        al.k(this.dYR, d.f.more_pop_item_bg_selector);
        al.j(this.dYR, d.C0277d.cp_cont_d);
        al.j(this.hJZ, d.C0277d.cp_link_tip_a);
        al.k(this.hJZ, d.f.more_pop_item_bg_selector);
        al.l(this.hKa, d.C0277d.cp_bg_line_b);
    }
}
