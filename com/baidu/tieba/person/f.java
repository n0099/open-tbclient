package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c {
    TextView cFZ;
    TextView csb;
    TextView fOP;
    TextView fOQ;
    TextView fOR;
    View fOS;
    View fOT;
    View fOU;
    View fOV;
    View fOW;
    TextView fOX;
    View fOY;
    TextView fye;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.person_info_more_view, (ViewGroup) null);
        this.fOP = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fOP.setOnClickListener(onClickListener);
        this.fye = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fye.setOnClickListener(onClickListener);
        this.fOQ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fOQ.setOnClickListener(onClickListener);
        this.fOR = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fOS = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fOR.setOnClickListener(onClickListener);
        this.cFZ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cFZ.setOnClickListener(onClickListener);
        this.csb = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fOT = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fOU = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fOV = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fOW = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.fOX = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.fOY = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.fOX.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fOP.setText(d.k.remove_friend);
        } else {
            this.fOP.setText(d.k.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fOQ.setText(d.k.remove_block_chat);
        } else {
            this.fOQ.setText(d.k.block_chat_message);
        }
        if (z3) {
            this.fOX.setVisibility(0);
            this.fOY.setVisibility(0);
            return;
        }
        this.fOX.setVisibility(8);
        this.fOY.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bix() {
        return this.fOP;
    }

    public View biy() {
        return this.fOQ;
    }

    public View biz() {
        return this.fOR;
    }

    public View biA() {
        return this.fye;
    }

    public View biB() {
        return this.fOX;
    }

    public void rk(int i) {
        this.fOR.setVisibility(0);
        this.fOW.setVisibility(0);
        if (i == 0) {
            this.fOR.setText(this.mPageContext.getResources().getString(d.k.mute));
        } else if (i == 1) {
            this.fOR.setText(this.mPageContext.getResources().getString(d.k.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.csb.setVisibility(8);
            this.fOT.setVisibility(8);
            return;
        }
        this.csb.setVisibility(0);
        this.fOT.setVisibility(0);
        this.csb.setText(String.format(this.mPageContext.getResources().getString(d.k.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, d.C0141d.cp_bg_line_d_alpha90);
        al.h(this.fOQ, d.C0141d.cp_link_tip_a);
        al.i(this.fOQ, d.f.more_pop_item_bg_selector);
        al.h(this.fOP, d.C0141d.cp_link_tip_a);
        al.i(this.fOP, d.f.more_pop_item_bg_selector);
        al.h(this.fye, d.C0141d.cp_link_tip_a);
        al.i(this.fye, d.f.more_pop_item_bg_selector);
        al.h(this.fOR, d.C0141d.cp_link_tip_a);
        al.i(this.fOR, d.f.more_pop_item_bg_selector);
        al.j(this.fOU, d.C0141d.cp_bg_line_b);
        al.j(this.fOV, d.C0141d.cp_bg_line_b);
        al.j(this.fOW, d.C0141d.cp_bg_line_b);
        al.j(this.fOT, d.C0141d.cp_bg_line_b);
        al.j(this.fOS, d.C0141d.cp_bg_line_b);
        al.i(this.cFZ, d.f.person_more_pop_item_bg_selector);
        al.h(this.cFZ, d.f.person_more_pop_cancel_text_selector);
        al.i(this.csb, d.f.more_pop_item_bg_selector);
        al.h(this.csb, d.C0141d.cp_cont_d);
        al.h(this.fOX, d.C0141d.cp_link_tip_a);
        al.i(this.fOX, d.f.more_pop_item_bg_selector);
        al.j(this.fOY, d.C0141d.cp_bg_line_b);
    }
}
