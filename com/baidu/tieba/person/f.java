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
    TextView cLl;
    TextView gcE;
    TextView gsQ;
    TextView gsR;
    TextView gsS;
    View gsT;
    View gsU;
    View gsV;
    View gsW;
    View gsX;
    TextView gsY;
    View gsZ;
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
        this.gsQ = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.gsQ.setOnClickListener(onClickListener);
        this.gcE = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.gcE.setOnClickListener(onClickListener);
        this.gsR = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.gsR.setOnClickListener(onClickListener);
        this.gsS = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.gsT = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.gsS.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cLl = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.gsU = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.gsV = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.gsW = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.gsX = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.gsY = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.gsZ = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.gsY.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.gsQ.setText(e.j.remove_friend);
        } else {
            this.gsQ.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gsR.setText(e.j.remove_block_chat);
        } else {
            this.gsR.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.gsY.setVisibility(0);
            this.gsZ.setVisibility(0);
            return;
        }
        this.gsY.setVisibility(8);
        this.gsZ.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bpc() {
        return this.gsQ;
    }

    public View bpd() {
        return this.gsR;
    }

    public View bpe() {
        return this.gsS;
    }

    public View bpf() {
        return this.gcE;
    }

    public View bpg() {
        return this.gsY;
    }

    public void tk(int i) {
        this.gsS.setVisibility(0);
        this.gsX.setVisibility(0);
        if (i == 0) {
            this.gsS.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.gsS.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cLl.setVisibility(8);
            this.gsU.setVisibility(8);
            return;
        }
        this.cLl.setVisibility(0);
        this.gsU.setVisibility(0);
        this.cLl.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.gsR, e.d.cp_link_tip_a);
        al.i(this.gsR, e.f.more_pop_item_bg_selector);
        al.h(this.gsQ, e.d.cp_link_tip_a);
        al.i(this.gsQ, e.f.more_pop_item_bg_selector);
        al.h(this.gcE, e.d.cp_link_tip_a);
        al.i(this.gcE, e.f.more_pop_item_bg_selector);
        al.h(this.gsS, e.d.cp_link_tip_a);
        al.i(this.gsS, e.f.more_pop_item_bg_selector);
        al.j(this.gsV, e.d.cp_bg_line_b);
        al.j(this.gsW, e.d.cp_bg_line_b);
        al.j(this.gsX, e.d.cp_bg_line_b);
        al.j(this.gsU, e.d.cp_bg_line_b);
        al.j(this.gsT, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cLl, e.f.more_pop_item_bg_selector);
        al.h(this.cLl, e.d.cp_cont_d);
        al.h(this.gsY, e.d.cp_link_tip_a);
        al.i(this.gsY, e.f.more_pop_item_bg_selector);
        al.j(this.gsZ, e.d.cp_bg_line_b);
    }
}
