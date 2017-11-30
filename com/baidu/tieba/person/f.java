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
public class f extends com.baidu.adp.base.c {
    TextView bcu;
    TextView cia;
    TextView eYy;
    View fqA;
    View fqB;
    View fqC;
    TextView fqv;
    TextView fqw;
    TextView fqx;
    View fqy;
    View fqz;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.fqv = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fqv.setOnClickListener(onClickListener);
        this.eYy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.eYy.setOnClickListener(onClickListener);
        this.fqw = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fqw.setOnClickListener(onClickListener);
        this.fqx = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fqy = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fqx.setOnClickListener(onClickListener);
        this.cia = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cia.setOnClickListener(onClickListener);
        this.bcu = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fqz = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fqA = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fqB = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fqC = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.fqv.setText(d.j.remove_friend);
        } else {
            this.fqv.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fqw.setText(d.j.remove_block_chat);
        } else {
            this.fqw.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aZN() {
        return this.fqv;
    }

    public View aZO() {
        return this.fqw;
    }

    public View aZP() {
        return this.fqx;
    }

    public View aZQ() {
        return this.eYy;
    }

    public void qL(int i) {
        this.fqx.setVisibility(0);
        this.fqC.setVisibility(0);
        if (i == 0) {
            this.fqx.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.fqx.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcu.setVisibility(0);
            this.fqz.setVisibility(0);
            this.bcu.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.C0082d.cp_bg_line_d_alpha90);
        aj.i(this.fqw, d.C0082d.cp_link_tip_a);
        aj.j(this.fqw, d.f.more_pop_item_bg_selector);
        aj.i(this.fqv, d.C0082d.cp_link_tip_a);
        aj.j(this.fqv, d.f.more_pop_item_bg_selector);
        aj.i(this.eYy, d.C0082d.cp_link_tip_a);
        aj.j(this.eYy, d.f.more_pop_item_bg_selector);
        aj.i(this.fqx, d.C0082d.cp_link_tip_a);
        aj.j(this.fqx, d.f.more_pop_item_bg_selector);
        aj.k(this.fqA, d.C0082d.cp_bg_line_b);
        aj.k(this.fqB, d.C0082d.cp_bg_line_b);
        aj.k(this.fqC, d.C0082d.cp_bg_line_b);
        aj.k(this.fqz, d.C0082d.cp_bg_line_b);
        aj.k(this.fqy, d.C0082d.cp_bg_line_b);
        aj.j(this.cia, d.f.person_more_pop_item_bg_selector);
        aj.i(this.cia, d.f.person_more_pop_cancel_text_selector);
        aj.j(this.bcu, d.f.more_pop_item_bg_selector);
        aj.i(this.bcu, d.C0082d.cp_cont_d);
    }
}
