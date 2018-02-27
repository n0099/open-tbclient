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
    TextView cSL;
    TextView dex;
    TextView fRq;
    TextView ghG;
    TextView ghH;
    TextView ghI;
    View ghJ;
    View ghK;
    View ghL;
    View ghM;
    View ghN;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.ghG = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.ghG.setOnClickListener(onClickListener);
        this.fRq = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fRq.setOnClickListener(onClickListener);
        this.ghH = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.ghH.setOnClickListener(onClickListener);
        this.ghI = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.ghJ = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.ghI.setOnClickListener(onClickListener);
        this.dex = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.dex.setOnClickListener(onClickListener);
        this.cSL = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.ghK = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.ghL = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.ghM = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.ghN = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.ghG.setText(d.j.remove_friend);
        } else {
            this.ghG.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ghH.setText(d.j.remove_block_chat);
        } else {
            this.ghH.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View biw() {
        return this.ghG;
    }

    public View bix() {
        return this.ghH;
    }

    public View biy() {
        return this.ghI;
    }

    public View biz() {
        return this.fRq;
    }

    public void tD(int i) {
        this.ghI.setVisibility(0);
        this.ghN.setVisibility(0);
        if (i == 0) {
            this.ghI.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.ghI.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cSL.setVisibility(0);
            this.ghK.setVisibility(0);
            this.cSL.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.s(this.mView, d.C0141d.cp_bg_line_d_alpha90);
        aj.r(this.ghH, d.C0141d.cp_link_tip_a);
        aj.s(this.ghH, d.f.more_pop_item_bg_selector);
        aj.r(this.ghG, d.C0141d.cp_link_tip_a);
        aj.s(this.ghG, d.f.more_pop_item_bg_selector);
        aj.r(this.fRq, d.C0141d.cp_link_tip_a);
        aj.s(this.fRq, d.f.more_pop_item_bg_selector);
        aj.r(this.ghI, d.C0141d.cp_link_tip_a);
        aj.s(this.ghI, d.f.more_pop_item_bg_selector);
        aj.t(this.ghL, d.C0141d.cp_bg_line_b);
        aj.t(this.ghM, d.C0141d.cp_bg_line_b);
        aj.t(this.ghN, d.C0141d.cp_bg_line_b);
        aj.t(this.ghK, d.C0141d.cp_bg_line_b);
        aj.t(this.ghJ, d.C0141d.cp_bg_line_b);
        aj.s(this.dex, d.f.person_more_pop_item_bg_selector);
        aj.r(this.dex, d.f.person_more_pop_cancel_text_selector);
        aj.s(this.cSL, d.f.more_pop_item_bg_selector);
        aj.r(this.cSL, d.C0141d.cp_cont_d);
    }
}
