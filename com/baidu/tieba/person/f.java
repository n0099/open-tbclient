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
    TextView hKl;
    TextView hKm;
    TextView hKn;
    View hKo;
    View hKp;
    View hKq;
    View hKr;
    View hKs;
    TextView hKt;
    View hKu;
    TextView htQ;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.hKl = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.hKl.setOnClickListener(onClickListener);
        this.htQ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.htQ.setOnClickListener(onClickListener);
        this.hKm = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.hKm.setOnClickListener(onClickListener);
        this.hKn = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.hKo = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.hKn.setOnClickListener(onClickListener);
        this.bjI = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bjI.setOnClickListener(onClickListener);
        this.dZy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.hKp = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.hKq = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.hKr = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.hKs = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.hKt = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.hKu = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.hKt.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.hKl.setText(d.j.remove_friend);
        } else {
            this.hKl.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.hKm.setText(d.j.remove_block_chat);
        } else {
            this.hKm.setText(d.j.block_chat_message);
        }
        if (z3) {
            this.hKt.setVisibility(0);
            this.hKu.setVisibility(0);
            return;
        }
        this.hKt.setVisibility(8);
        this.hKu.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bQh() {
        return this.hKl;
    }

    public View bQi() {
        return this.hKm;
    }

    public View bQj() {
        return this.hKn;
    }

    public View bQk() {
        return this.htQ;
    }

    public View bQl() {
        return this.hKt;
    }

    public void wY(int i) {
        this.hKn.setVisibility(0);
        this.hKs.setVisibility(0);
        if (i == 0) {
            this.hKn.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.hKn.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dZy.setVisibility(8);
            this.hKp.setVisibility(8);
            return;
        }
        this.dZy.setVisibility(0);
        this.hKp.setVisibility(0);
        this.dZy.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, d.C0236d.cp_bg_line_d_alpha90);
        al.j(this.hKm, d.C0236d.cp_link_tip_a);
        al.k(this.hKm, d.f.more_pop_item_bg_selector);
        al.j(this.hKl, d.C0236d.cp_link_tip_a);
        al.k(this.hKl, d.f.more_pop_item_bg_selector);
        al.j(this.htQ, d.C0236d.cp_link_tip_a);
        al.k(this.htQ, d.f.more_pop_item_bg_selector);
        al.j(this.hKn, d.C0236d.cp_link_tip_a);
        al.k(this.hKn, d.f.more_pop_item_bg_selector);
        al.l(this.hKq, d.C0236d.cp_bg_line_b);
        al.l(this.hKr, d.C0236d.cp_bg_line_b);
        al.l(this.hKs, d.C0236d.cp_bg_line_b);
        al.l(this.hKp, d.C0236d.cp_bg_line_b);
        al.l(this.hKo, d.C0236d.cp_bg_line_b);
        al.k(this.bjI, d.f.person_more_pop_item_bg_selector);
        al.j(this.bjI, d.f.person_more_pop_cancel_text_selector);
        al.k(this.dZy, d.f.more_pop_item_bg_selector);
        al.j(this.dZy, d.C0236d.cp_cont_d);
        al.j(this.hKt, d.C0236d.cp_link_tip_a);
        al.k(this.hKt, d.f.more_pop_item_bg_selector);
        al.l(this.hKu, d.C0236d.cp_bg_line_b);
    }
}
