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
    TextView cSX;
    TextView deJ;
    TextView fRB;
    TextView ghR;
    TextView ghS;
    TextView ghT;
    View ghU;
    View ghV;
    View ghW;
    View ghX;
    View ghY;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.ghR = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.ghR.setOnClickListener(onClickListener);
        this.fRB = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fRB.setOnClickListener(onClickListener);
        this.ghS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.ghS.setOnClickListener(onClickListener);
        this.ghT = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.ghU = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.ghT.setOnClickListener(onClickListener);
        this.deJ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.deJ.setOnClickListener(onClickListener);
        this.cSX = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.ghV = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.ghW = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.ghX = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.ghY = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.ghR.setText(d.j.remove_friend);
        } else {
            this.ghR.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ghS.setText(d.j.remove_block_chat);
        } else {
            this.ghS.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View bix() {
        return this.ghR;
    }

    public View biy() {
        return this.ghS;
    }

    public View biz() {
        return this.ghT;
    }

    public View biA() {
        return this.fRB;
    }

    public void tC(int i) {
        this.ghT.setVisibility(0);
        this.ghY.setVisibility(0);
        if (i == 0) {
            this.ghT.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.ghT.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cSX.setVisibility(0);
            this.ghV.setVisibility(0);
            this.cSX.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.s(this.mView, d.C0140d.cp_bg_line_d_alpha90);
        aj.r(this.ghS, d.C0140d.cp_link_tip_a);
        aj.s(this.ghS, d.f.more_pop_item_bg_selector);
        aj.r(this.ghR, d.C0140d.cp_link_tip_a);
        aj.s(this.ghR, d.f.more_pop_item_bg_selector);
        aj.r(this.fRB, d.C0140d.cp_link_tip_a);
        aj.s(this.fRB, d.f.more_pop_item_bg_selector);
        aj.r(this.ghT, d.C0140d.cp_link_tip_a);
        aj.s(this.ghT, d.f.more_pop_item_bg_selector);
        aj.t(this.ghW, d.C0140d.cp_bg_line_b);
        aj.t(this.ghX, d.C0140d.cp_bg_line_b);
        aj.t(this.ghY, d.C0140d.cp_bg_line_b);
        aj.t(this.ghV, d.C0140d.cp_bg_line_b);
        aj.t(this.ghU, d.C0140d.cp_bg_line_b);
        aj.s(this.deJ, d.f.person_more_pop_item_bg_selector);
        aj.r(this.deJ, d.f.person_more_pop_cancel_text_selector);
        aj.s(this.cSX, d.f.more_pop_item_bg_selector);
        aj.r(this.cSX, d.C0140d.cp_cont_d);
    }
}
