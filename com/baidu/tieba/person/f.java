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
    TextView bQs;
    TextView dbA;
    TextView fNY;
    TextView gfQ;
    TextView gfR;
    TextView gfS;
    View gfT;
    View gfU;
    View gfV;
    View gfW;
    View gfX;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.gfQ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.gfQ.setOnClickListener(onClickListener);
        this.fNY = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fNY.setOnClickListener(onClickListener);
        this.gfR = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.gfR.setOnClickListener(onClickListener);
        this.gfS = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.gfT = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.gfS.setOnClickListener(onClickListener);
        this.dbA = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.dbA.setOnClickListener(onClickListener);
        this.bQs = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.gfU = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.gfV = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.gfW = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.gfX = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void O(boolean z, boolean z2) {
        if (z) {
            this.gfQ.setText(d.j.remove_friend);
        } else {
            this.gfQ.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gfR.setText(d.j.remove_block_chat);
        } else {
            this.gfR.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View bhm() {
        return this.gfQ;
    }

    public View bhn() {
        return this.gfR;
    }

    public View bho() {
        return this.gfS;
    }

    public View bhp() {
        return this.fNY;
    }

    public void tE(int i) {
        this.gfS.setVisibility(0);
        this.gfX.setVisibility(0);
        if (i == 0) {
            this.gfS.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.gfS.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bQs.setVisibility(0);
            this.gfU.setVisibility(0);
            this.bQs.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.s(this.mView, d.C0107d.cp_bg_line_d_alpha90);
        aj.r(this.gfR, d.C0107d.cp_link_tip_a);
        aj.s(this.gfR, d.f.more_pop_item_bg_selector);
        aj.r(this.gfQ, d.C0107d.cp_link_tip_a);
        aj.s(this.gfQ, d.f.more_pop_item_bg_selector);
        aj.r(this.fNY, d.C0107d.cp_link_tip_a);
        aj.s(this.fNY, d.f.more_pop_item_bg_selector);
        aj.r(this.gfS, d.C0107d.cp_link_tip_a);
        aj.s(this.gfS, d.f.more_pop_item_bg_selector);
        aj.t(this.gfV, d.C0107d.cp_bg_line_b);
        aj.t(this.gfW, d.C0107d.cp_bg_line_b);
        aj.t(this.gfX, d.C0107d.cp_bg_line_b);
        aj.t(this.gfU, d.C0107d.cp_bg_line_b);
        aj.t(this.gfT, d.C0107d.cp_bg_line_b);
        aj.s(this.dbA, d.f.person_more_pop_item_bg_selector);
        aj.r(this.dbA, d.f.person_more_pop_cancel_text_selector);
        aj.s(this.bQs, d.f.more_pop_item_bg_selector);
        aj.r(this.bQs, d.C0107d.cp_cont_d);
    }
}
