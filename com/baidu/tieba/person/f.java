package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c {
    TextView cGv;
    TextView csG;
    TextView fCl;
    TextView fSU;
    TextView fSV;
    TextView fSW;
    View fSX;
    View fSY;
    View fSZ;
    View fTa;
    View fTb;
    TextView fTc;
    View fTd;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.person_info_more_view, (ViewGroup) null);
        this.fSU = (TextView) this.mView.findViewById(f.g.person_info_more_view_item_friend);
        this.fSU.setOnClickListener(onClickListener);
        this.fCl = (TextView) this.mView.findViewById(f.g.person_info_more_view_item_report);
        this.fCl.setOnClickListener(onClickListener);
        this.fSV = (TextView) this.mView.findViewById(f.g.person_info_more_view_item_black);
        this.fSV.setOnClickListener(onClickListener);
        this.fSW = (TextView) this.mView.findViewById(f.g.person_info_more_view_item_mute);
        this.fSX = this.mView.findViewById(f.g.person_info_more_view_item_line_mute);
        this.fSW.setOnClickListener(onClickListener);
        this.cGv = (TextView) this.mView.findViewById(f.g.person_info_more_view_item_cancel);
        this.cGv.setOnClickListener(onClickListener);
        this.csG = (TextView) this.mView.findViewById(f.g.person_info_more_view_item_username);
        this.fSY = this.mView.findViewById(f.g.person_info_more_view_item_line_username);
        this.fSZ = this.mView.findViewById(f.g.person_info_more_view_item_line_friend);
        this.fTa = this.mView.findViewById(f.g.person_info_more_view_item_line_report);
        this.fTb = this.mView.findViewById(f.g.person_info_more_view_item_line_black);
        this.fTc = (TextView) this.mView.findViewById(f.g.person_info_item_remove_fans_view);
        this.fTd = this.mView.findViewById(f.g.person_info_line_remove_fans_view);
        this.fTc.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fSU.setText(f.j.remove_friend);
        } else {
            this.fSU.setText(f.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fSV.setText(f.j.remove_block_chat);
        } else {
            this.fSV.setText(f.j.block_chat_message);
        }
        if (z3) {
            this.fTc.setVisibility(0);
            this.fTd.setVisibility(0);
            return;
        }
        this.fTc.setVisibility(8);
        this.fTd.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bhr() {
        return this.fSU;
    }

    public View bhs() {
        return this.fSV;
    }

    public View bht() {
        return this.fSW;
    }

    public View bhu() {
        return this.fCl;
    }

    public View bhv() {
        return this.fTc;
    }

    public void rq(int i) {
        this.fSW.setVisibility(0);
        this.fTb.setVisibility(0);
        if (i == 0) {
            this.fSW.setText(this.mPageContext.getResources().getString(f.j.mute));
        } else if (i == 1) {
            this.fSW.setText(this.mPageContext.getResources().getString(f.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.csG.setVisibility(8);
            this.fSY.setVisibility(8);
            return;
        }
        this.csG.setVisibility(0);
        this.fSY.setVisibility(0);
        this.csG.setText(String.format(this.mPageContext.getResources().getString(f.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.i(this.mView, f.d.cp_bg_line_d_alpha90);
        am.h(this.fSV, f.d.cp_link_tip_a);
        am.i(this.fSV, f.C0146f.more_pop_item_bg_selector);
        am.h(this.fSU, f.d.cp_link_tip_a);
        am.i(this.fSU, f.C0146f.more_pop_item_bg_selector);
        am.h(this.fCl, f.d.cp_link_tip_a);
        am.i(this.fCl, f.C0146f.more_pop_item_bg_selector);
        am.h(this.fSW, f.d.cp_link_tip_a);
        am.i(this.fSW, f.C0146f.more_pop_item_bg_selector);
        am.j(this.fSZ, f.d.cp_bg_line_b);
        am.j(this.fTa, f.d.cp_bg_line_b);
        am.j(this.fTb, f.d.cp_bg_line_b);
        am.j(this.fSY, f.d.cp_bg_line_b);
        am.j(this.fSX, f.d.cp_bg_line_b);
        am.i(this.cGv, f.C0146f.person_more_pop_item_bg_selector);
        am.h(this.cGv, f.C0146f.person_more_pop_cancel_text_selector);
        am.i(this.csG, f.C0146f.more_pop_item_bg_selector);
        am.h(this.csG, f.d.cp_cont_d);
        am.h(this.fTc, f.d.cp_link_tip_a);
        am.i(this.fTc, f.C0146f.more_pop_item_bg_selector);
        am.j(this.fTd, f.d.cp_bg_line_b);
    }
}
