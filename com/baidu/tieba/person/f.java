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
    TextView bjI;
    TextView dZy;
    TextView hKk;
    TextView hKl;
    TextView hKm;
    View hKn;
    View hKo;
    View hKp;
    View hKq;
    View hKr;
    TextView hKs;
    View hKt;
    TextView htP;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.hKk = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.hKk.setOnClickListener(onClickListener);
        this.htP = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.htP.setOnClickListener(onClickListener);
        this.hKl = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.hKl.setOnClickListener(onClickListener);
        this.hKm = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.hKn = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.hKm.setOnClickListener(onClickListener);
        this.bjI = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bjI.setOnClickListener(onClickListener);
        this.dZy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.hKo = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.hKp = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.hKq = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.hKr = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.hKs = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.hKt = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.hKs.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.hKk.setText(d.j.remove_friend);
        } else {
            this.hKk.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.hKl.setText(d.j.remove_block_chat);
        } else {
            this.hKl.setText(d.j.block_chat_message);
        }
        if (z3) {
            this.hKs.setVisibility(0);
            this.hKt.setVisibility(0);
            return;
        }
        this.hKs.setVisibility(8);
        this.hKt.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bQg() {
        return this.hKk;
    }

    public View bQh() {
        return this.hKl;
    }

    public View bQi() {
        return this.hKm;
    }

    public View bQj() {
        return this.htP;
    }

    public View bQk() {
        return this.hKs;
    }

    public void wY(int i) {
        this.hKm.setVisibility(0);
        this.hKr.setVisibility(0);
        if (i == 0) {
            this.hKm.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.hKm.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dZy.setVisibility(8);
            this.hKo.setVisibility(8);
            return;
        }
        this.dZy.setVisibility(0);
        this.hKo.setVisibility(0);
        this.dZy.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, d.C0236d.cp_bg_line_d_alpha90);
        al.j(this.hKl, d.C0236d.cp_link_tip_a);
        al.k(this.hKl, d.f.more_pop_item_bg_selector);
        al.j(this.hKk, d.C0236d.cp_link_tip_a);
        al.k(this.hKk, d.f.more_pop_item_bg_selector);
        al.j(this.htP, d.C0236d.cp_link_tip_a);
        al.k(this.htP, d.f.more_pop_item_bg_selector);
        al.j(this.hKm, d.C0236d.cp_link_tip_a);
        al.k(this.hKm, d.f.more_pop_item_bg_selector);
        al.l(this.hKp, d.C0236d.cp_bg_line_b);
        al.l(this.hKq, d.C0236d.cp_bg_line_b);
        al.l(this.hKr, d.C0236d.cp_bg_line_b);
        al.l(this.hKo, d.C0236d.cp_bg_line_b);
        al.l(this.hKn, d.C0236d.cp_bg_line_b);
        al.k(this.bjI, d.f.person_more_pop_item_bg_selector);
        al.j(this.bjI, d.f.person_more_pop_cancel_text_selector);
        al.k(this.dZy, d.f.more_pop_item_bg_selector);
        al.j(this.dZy, d.C0236d.cp_cont_d);
        al.j(this.hKs, d.C0236d.cp_link_tip_a);
        al.k(this.hKs, d.f.more_pop_item_bg_selector);
        al.l(this.hKt, d.C0236d.cp_bg_line_b);
    }
}
