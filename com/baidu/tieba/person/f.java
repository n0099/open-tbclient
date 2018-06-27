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
    TextView cDS;
    TextView cqi;
    TextView fCf;
    TextView fSR;
    TextView fSS;
    TextView fST;
    View fSU;
    View fSV;
    View fSW;
    View fSX;
    View fSY;
    TextView fSZ;
    View fTa;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.person_info_more_view, (ViewGroup) null);
        this.fSR = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fSR.setOnClickListener(onClickListener);
        this.fCf = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fCf.setOnClickListener(onClickListener);
        this.fSS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fSS.setOnClickListener(onClickListener);
        this.fST = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fSU = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fST.setOnClickListener(onClickListener);
        this.cDS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cDS.setOnClickListener(onClickListener);
        this.cqi = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fSV = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fSW = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fSX = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fSY = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.fSZ = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.fTa = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.fSZ.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fSR.setText(d.k.remove_friend);
        } else {
            this.fSR.setText(d.k.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fSS.setText(d.k.remove_block_chat);
        } else {
            this.fSS.setText(d.k.block_chat_message);
        }
        if (z3) {
            this.fSZ.setVisibility(0);
            this.fTa.setVisibility(0);
            return;
        }
        this.fSZ.setVisibility(8);
        this.fTa.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bjd() {
        return this.fSR;
    }

    public View bje() {
        return this.fSS;
    }

    public View bjf() {
        return this.fST;
    }

    public View bjg() {
        return this.fCf;
    }

    public View bjh() {
        return this.fSZ;
    }

    public void rt(int i) {
        this.fST.setVisibility(0);
        this.fSY.setVisibility(0);
        if (i == 0) {
            this.fST.setText(this.mPageContext.getResources().getString(d.k.mute));
        } else if (i == 1) {
            this.fST.setText(this.mPageContext.getResources().getString(d.k.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cqi.setVisibility(8);
            this.fSV.setVisibility(8);
            return;
        }
        this.cqi.setVisibility(0);
        this.fSV.setVisibility(0);
        this.cqi.setText(String.format(this.mPageContext.getResources().getString(d.k.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.i(this.mView, d.C0142d.cp_bg_line_d_alpha90);
        am.h(this.fSS, d.C0142d.cp_link_tip_a);
        am.i(this.fSS, d.f.more_pop_item_bg_selector);
        am.h(this.fSR, d.C0142d.cp_link_tip_a);
        am.i(this.fSR, d.f.more_pop_item_bg_selector);
        am.h(this.fCf, d.C0142d.cp_link_tip_a);
        am.i(this.fCf, d.f.more_pop_item_bg_selector);
        am.h(this.fST, d.C0142d.cp_link_tip_a);
        am.i(this.fST, d.f.more_pop_item_bg_selector);
        am.j(this.fSW, d.C0142d.cp_bg_line_b);
        am.j(this.fSX, d.C0142d.cp_bg_line_b);
        am.j(this.fSY, d.C0142d.cp_bg_line_b);
        am.j(this.fSV, d.C0142d.cp_bg_line_b);
        am.j(this.fSU, d.C0142d.cp_bg_line_b);
        am.i(this.cDS, d.f.person_more_pop_item_bg_selector);
        am.h(this.cDS, d.f.person_more_pop_cancel_text_selector);
        am.i(this.cqi, d.f.more_pop_item_bg_selector);
        am.h(this.cqi, d.C0142d.cp_cont_d);
        am.h(this.fSZ, d.C0142d.cp_link_tip_a);
        am.i(this.fSZ, d.f.more_pop_item_bg_selector);
        am.j(this.fTa, d.C0142d.cp_bg_line_b);
    }
}
