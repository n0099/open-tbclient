package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c {
    TextView cGy;
    TextView csJ;
    TextView fCs;
    TextView fTc;
    TextView fTd;
    TextView fTe;
    View fTf;
    View fTg;
    View fTh;
    View fTi;
    View fTj;
    TextView fTk;
    View fTl;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.fTc = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fTc.setOnClickListener(onClickListener);
        this.fCs = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fCs.setOnClickListener(onClickListener);
        this.fTd = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fTd.setOnClickListener(onClickListener);
        this.fTe = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fTf = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fTe.setOnClickListener(onClickListener);
        this.cGy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cGy.setOnClickListener(onClickListener);
        this.csJ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fTg = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fTh = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fTi = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fTj = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.fTk = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.fTl = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.fTk.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fTc.setText(d.j.remove_friend);
        } else {
            this.fTc.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fTd.setText(d.j.remove_block_chat);
        } else {
            this.fTd.setText(d.j.block_chat_message);
        }
        if (z3) {
            this.fTk.setVisibility(0);
            this.fTl.setVisibility(0);
            return;
        }
        this.fTk.setVisibility(8);
        this.fTl.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bhw() {
        return this.fTc;
    }

    public View bhx() {
        return this.fTd;
    }

    public View bhy() {
        return this.fTe;
    }

    public View bhz() {
        return this.fCs;
    }

    public View bhA() {
        return this.fTk;
    }

    public void rq(int i) {
        this.fTe.setVisibility(0);
        this.fTj.setVisibility(0);
        if (i == 0) {
            this.fTe.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.fTe.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.csJ.setVisibility(8);
            this.fTg.setVisibility(8);
            return;
        }
        this.csJ.setVisibility(0);
        this.fTg.setVisibility(0);
        this.csJ.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.i(this.mView, d.C0140d.cp_bg_line_d_alpha90);
        am.h(this.fTd, d.C0140d.cp_link_tip_a);
        am.i(this.fTd, d.f.more_pop_item_bg_selector);
        am.h(this.fTc, d.C0140d.cp_link_tip_a);
        am.i(this.fTc, d.f.more_pop_item_bg_selector);
        am.h(this.fCs, d.C0140d.cp_link_tip_a);
        am.i(this.fCs, d.f.more_pop_item_bg_selector);
        am.h(this.fTe, d.C0140d.cp_link_tip_a);
        am.i(this.fTe, d.f.more_pop_item_bg_selector);
        am.j(this.fTh, d.C0140d.cp_bg_line_b);
        am.j(this.fTi, d.C0140d.cp_bg_line_b);
        am.j(this.fTj, d.C0140d.cp_bg_line_b);
        am.j(this.fTg, d.C0140d.cp_bg_line_b);
        am.j(this.fTf, d.C0140d.cp_bg_line_b);
        am.i(this.cGy, d.f.person_more_pop_item_bg_selector);
        am.h(this.cGy, d.f.person_more_pop_cancel_text_selector);
        am.i(this.csJ, d.f.more_pop_item_bg_selector);
        am.h(this.csJ, d.C0140d.cp_cont_d);
        am.h(this.fTk, d.C0140d.cp_link_tip_a);
        am.i(this.fTk, d.f.more_pop_item_bg_selector);
        am.j(this.fTl, d.C0140d.cp_bg_line_b);
    }
}
