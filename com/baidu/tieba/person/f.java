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
    TextView fRw;
    TextView ghL;
    TextView ghM;
    TextView ghN;
    View ghO;
    View ghP;
    View ghQ;
    View ghR;
    View ghS;
    TextView ghT;
    View ghU;
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
        this.ghL = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.ghL.setOnClickListener(onClickListener);
        this.fRw = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.fRw.setOnClickListener(onClickListener);
        this.ghM = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.ghM.setOnClickListener(onClickListener);
        this.ghN = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.ghO = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.ghN.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cGZ = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.ghP = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.ghQ = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.ghR = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.ghS = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.ghT = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.ghU = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.ghT.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ghL.setText(e.j.remove_friend);
        } else {
            this.ghL.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ghM.setText(e.j.remove_block_chat);
        } else {
            this.ghM.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.ghT.setVisibility(0);
            this.ghU.setVisibility(0);
            return;
        }
        this.ghT.setVisibility(8);
        this.ghU.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bnd() {
        return this.ghL;
    }

    public View bne() {
        return this.ghM;
    }

    public View bnf() {
        return this.ghN;
    }

    public View bng() {
        return this.fRw;
    }

    public View bnh() {
        return this.ghT;
    }

    public void sk(int i) {
        this.ghN.setVisibility(0);
        this.ghS.setVisibility(0);
        if (i == 0) {
            this.ghN.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.ghN.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cGZ.setVisibility(8);
            this.ghP.setVisibility(8);
            return;
        }
        this.cGZ.setVisibility(0);
        this.ghP.setVisibility(0);
        this.cGZ.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.ghM, e.d.cp_link_tip_a);
        al.i(this.ghM, e.f.more_pop_item_bg_selector);
        al.h(this.ghL, e.d.cp_link_tip_a);
        al.i(this.ghL, e.f.more_pop_item_bg_selector);
        al.h(this.fRw, e.d.cp_link_tip_a);
        al.i(this.fRw, e.f.more_pop_item_bg_selector);
        al.h(this.ghN, e.d.cp_link_tip_a);
        al.i(this.ghN, e.f.more_pop_item_bg_selector);
        al.j(this.ghQ, e.d.cp_bg_line_b);
        al.j(this.ghR, e.d.cp_bg_line_b);
        al.j(this.ghS, e.d.cp_bg_line_b);
        al.j(this.ghP, e.d.cp_bg_line_b);
        al.j(this.ghO, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cGZ, e.f.more_pop_item_bg_selector);
        al.h(this.cGZ, e.d.cp_cont_d);
        al.h(this.ghT, e.d.cp_link_tip_a);
        al.i(this.ghT, e.f.more_pop_item_bg_selector);
        al.j(this.ghU, e.d.cp_bg_line_b);
    }
}
