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
    TextView cIi;
    TextView fSW;
    TextView gjj;
    TextView gjk;
    TextView gjl;
    View gjm;
    View gjn;
    View gjo;
    View gjp;
    View gjq;
    TextView gjr;
    View gjs;
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
        this.gjj = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.gjj.setOnClickListener(onClickListener);
        this.fSW = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.fSW.setOnClickListener(onClickListener);
        this.gjk = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.gjk.setOnClickListener(onClickListener);
        this.gjl = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.gjm = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.gjl.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cIi = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.gjn = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.gjo = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.gjp = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.gjq = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.gjr = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.gjs = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.gjr.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.gjj.setText(e.j.remove_friend);
        } else {
            this.gjj.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gjk.setText(e.j.remove_block_chat);
        } else {
            this.gjk.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.gjr.setVisibility(0);
            this.gjs.setVisibility(0);
            return;
        }
        this.gjr.setVisibility(8);
        this.gjs.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bmy() {
        return this.gjj;
    }

    public View bmz() {
        return this.gjk;
    }

    public View bmA() {
        return this.gjl;
    }

    public View bmB() {
        return this.fSW;
    }

    public View bmC() {
        return this.gjr;
    }

    public void sD(int i) {
        this.gjl.setVisibility(0);
        this.gjq.setVisibility(0);
        if (i == 0) {
            this.gjl.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.gjl.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cIi.setVisibility(8);
            this.gjn.setVisibility(8);
            return;
        }
        this.cIi.setVisibility(0);
        this.gjn.setVisibility(0);
        this.cIi.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.gjk, e.d.cp_link_tip_a);
        al.i(this.gjk, e.f.more_pop_item_bg_selector);
        al.h(this.gjj, e.d.cp_link_tip_a);
        al.i(this.gjj, e.f.more_pop_item_bg_selector);
        al.h(this.fSW, e.d.cp_link_tip_a);
        al.i(this.fSW, e.f.more_pop_item_bg_selector);
        al.h(this.gjl, e.d.cp_link_tip_a);
        al.i(this.gjl, e.f.more_pop_item_bg_selector);
        al.j(this.gjo, e.d.cp_bg_line_b);
        al.j(this.gjp, e.d.cp_bg_line_b);
        al.j(this.gjq, e.d.cp_bg_line_b);
        al.j(this.gjn, e.d.cp_bg_line_b);
        al.j(this.gjm, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cIi, e.f.more_pop_item_bg_selector);
        al.h(this.cIi, e.d.cp_cont_d);
        al.h(this.gjr, e.d.cp_link_tip_a);
        al.i(this.gjr, e.f.more_pop_item_bg_selector);
        al.j(this.gjs, e.d.cp_bg_line_b);
    }
}
