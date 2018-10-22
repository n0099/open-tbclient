package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c {
    TextView cGZ;
    TextView fRx;
    TextView ghM;
    TextView ghN;
    TextView ghO;
    View ghP;
    View ghQ;
    View ghR;
    View ghS;
    View ghT;
    TextView ghU;
    View ghV;
    TextView mCancelView;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.person_info_more_view, (ViewGroup) null);
        this.ghM = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.ghM.setOnClickListener(onClickListener);
        this.fRx = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.fRx.setOnClickListener(onClickListener);
        this.ghN = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.ghN.setOnClickListener(onClickListener);
        this.ghO = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.ghP = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.ghO.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cGZ = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.ghQ = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.ghR = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.ghS = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.ghT = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.ghU = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.ghV = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.ghU.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ghM.setText(e.j.remove_friend);
        } else {
            this.ghM.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ghN.setText(e.j.remove_block_chat);
        } else {
            this.ghN.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.ghU.setVisibility(0);
            this.ghV.setVisibility(0);
            return;
        }
        this.ghU.setVisibility(8);
        this.ghV.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bnd() {
        return this.ghM;
    }

    public View bne() {
        return this.ghN;
    }

    public View bnf() {
        return this.ghO;
    }

    public View bng() {
        return this.fRx;
    }

    public View bnh() {
        return this.ghU;
    }

    public void sk(int i) {
        this.ghO.setVisibility(0);
        this.ghT.setVisibility(0);
        if (i == 0) {
            this.ghO.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.ghO.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cGZ.setVisibility(8);
            this.ghQ.setVisibility(8);
            return;
        }
        this.cGZ.setVisibility(0);
        this.ghQ.setVisibility(0);
        this.cGZ.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.ghN, e.d.cp_link_tip_a);
        al.i(this.ghN, e.f.more_pop_item_bg_selector);
        al.h(this.ghM, e.d.cp_link_tip_a);
        al.i(this.ghM, e.f.more_pop_item_bg_selector);
        al.h(this.fRx, e.d.cp_link_tip_a);
        al.i(this.fRx, e.f.more_pop_item_bg_selector);
        al.h(this.ghO, e.d.cp_link_tip_a);
        al.i(this.ghO, e.f.more_pop_item_bg_selector);
        al.j(this.ghR, e.d.cp_bg_line_b);
        al.j(this.ghS, e.d.cp_bg_line_b);
        al.j(this.ghT, e.d.cp_bg_line_b);
        al.j(this.ghQ, e.d.cp_bg_line_b);
        al.j(this.ghP, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cGZ, e.f.more_pop_item_bg_selector);
        al.h(this.cGZ, e.d.cp_cont_d);
        al.h(this.ghU, e.d.cp_link_tip_a);
        al.i(this.ghU, e.f.more_pop_item_bg_selector);
        al.j(this.ghV, e.d.cp_bg_line_b);
    }
}
