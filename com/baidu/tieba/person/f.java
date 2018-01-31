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
    TextView bQA;
    TextView dbV;
    TextView fOt;
    TextView ggj;
    TextView ggk;
    TextView ggl;
    View ggm;
    View ggn;
    View ggo;
    View ggp;
    View ggq;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.ggj = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.ggj.setOnClickListener(onClickListener);
        this.fOt = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fOt.setOnClickListener(onClickListener);
        this.ggk = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.ggk.setOnClickListener(onClickListener);
        this.ggl = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.ggm = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.ggl.setOnClickListener(onClickListener);
        this.dbV = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.dbV.setOnClickListener(onClickListener);
        this.bQA = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.ggn = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.ggo = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.ggp = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.ggq = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void O(boolean z, boolean z2) {
        if (z) {
            this.ggj.setText(d.j.remove_friend);
        } else {
            this.ggj.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ggk.setText(d.j.remove_block_chat);
        } else {
            this.ggk.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View bhn() {
        return this.ggj;
    }

    public View bho() {
        return this.ggk;
    }

    public View bhp() {
        return this.ggl;
    }

    public View bhq() {
        return this.fOt;
    }

    public void tE(int i) {
        this.ggl.setVisibility(0);
        this.ggq.setVisibility(0);
        if (i == 0) {
            this.ggl.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.ggl.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bQA.setVisibility(0);
            this.ggn.setVisibility(0);
            this.bQA.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.s(this.mView, d.C0108d.cp_bg_line_d_alpha90);
        aj.r(this.ggk, d.C0108d.cp_link_tip_a);
        aj.s(this.ggk, d.f.more_pop_item_bg_selector);
        aj.r(this.ggj, d.C0108d.cp_link_tip_a);
        aj.s(this.ggj, d.f.more_pop_item_bg_selector);
        aj.r(this.fOt, d.C0108d.cp_link_tip_a);
        aj.s(this.fOt, d.f.more_pop_item_bg_selector);
        aj.r(this.ggl, d.C0108d.cp_link_tip_a);
        aj.s(this.ggl, d.f.more_pop_item_bg_selector);
        aj.t(this.ggo, d.C0108d.cp_bg_line_b);
        aj.t(this.ggp, d.C0108d.cp_bg_line_b);
        aj.t(this.ggq, d.C0108d.cp_bg_line_b);
        aj.t(this.ggn, d.C0108d.cp_bg_line_b);
        aj.t(this.ggm, d.C0108d.cp_bg_line_b);
        aj.s(this.dbV, d.f.person_more_pop_item_bg_selector);
        aj.r(this.dbV, d.f.person_more_pop_cancel_text_selector);
        aj.s(this.bQA, d.f.more_pop_item_bg_selector);
        aj.r(this.bQA, d.C0108d.cp_cont_d);
    }
}
