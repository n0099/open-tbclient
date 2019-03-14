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
    TextView bjJ;
    TextView dZu;
    TextView hKf;
    TextView hKg;
    TextView hKh;
    View hKi;
    View hKj;
    View hKk;
    View hKl;
    View hKm;
    TextView hKn;
    View hKo;
    TextView htJ;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.hKf = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.hKf.setOnClickListener(onClickListener);
        this.htJ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.htJ.setOnClickListener(onClickListener);
        this.hKg = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.hKg.setOnClickListener(onClickListener);
        this.hKh = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.hKi = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.hKh.setOnClickListener(onClickListener);
        this.bjJ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bjJ.setOnClickListener(onClickListener);
        this.dZu = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.hKj = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.hKk = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.hKl = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.hKm = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.hKn = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.hKo = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.hKn.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.hKf.setText(d.j.remove_friend);
        } else {
            this.hKf.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.hKg.setText(d.j.remove_block_chat);
        } else {
            this.hKg.setText(d.j.block_chat_message);
        }
        if (z3) {
            this.hKn.setVisibility(0);
            this.hKo.setVisibility(0);
            return;
        }
        this.hKn.setVisibility(8);
        this.hKo.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bQj() {
        return this.hKf;
    }

    public View bQk() {
        return this.hKg;
    }

    public View bQl() {
        return this.hKh;
    }

    public View bQm() {
        return this.htJ;
    }

    public View bQn() {
        return this.hKn;
    }

    public void wY(int i) {
        this.hKh.setVisibility(0);
        this.hKm.setVisibility(0);
        if (i == 0) {
            this.hKh.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.hKh.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dZu.setVisibility(8);
            this.hKj.setVisibility(8);
            return;
        }
        this.dZu.setVisibility(0);
        this.hKj.setVisibility(0);
        this.dZu.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, d.C0277d.cp_bg_line_d_alpha90);
        al.j(this.hKg, d.C0277d.cp_link_tip_a);
        al.k(this.hKg, d.f.more_pop_item_bg_selector);
        al.j(this.hKf, d.C0277d.cp_link_tip_a);
        al.k(this.hKf, d.f.more_pop_item_bg_selector);
        al.j(this.htJ, d.C0277d.cp_link_tip_a);
        al.k(this.htJ, d.f.more_pop_item_bg_selector);
        al.j(this.hKh, d.C0277d.cp_link_tip_a);
        al.k(this.hKh, d.f.more_pop_item_bg_selector);
        al.l(this.hKk, d.C0277d.cp_bg_line_b);
        al.l(this.hKl, d.C0277d.cp_bg_line_b);
        al.l(this.hKm, d.C0277d.cp_bg_line_b);
        al.l(this.hKj, d.C0277d.cp_bg_line_b);
        al.l(this.hKi, d.C0277d.cp_bg_line_b);
        al.k(this.bjJ, d.f.person_more_pop_item_bg_selector);
        al.j(this.bjJ, d.f.person_more_pop_cancel_text_selector);
        al.k(this.dZu, d.f.more_pop_item_bg_selector);
        al.j(this.dZu, d.C0277d.cp_cont_d);
        al.j(this.hKn, d.C0277d.cp_link_tip_a);
        al.k(this.hKn, d.f.more_pop_item_bg_selector);
        al.l(this.hKo, d.C0277d.cp_bg_line_b);
    }
}
