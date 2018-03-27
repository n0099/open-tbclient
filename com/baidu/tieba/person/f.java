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
    TextView cSO;
    TextView deA;
    TextView fRG;
    TextView ghW;
    TextView ghX;
    TextView ghY;
    View ghZ;
    View gia;
    View gib;
    View gic;
    View gie;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.ghW = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.ghW.setOnClickListener(onClickListener);
        this.fRG = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fRG.setOnClickListener(onClickListener);
        this.ghX = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.ghX.setOnClickListener(onClickListener);
        this.ghY = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.ghZ = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.ghY.setOnClickListener(onClickListener);
        this.deA = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.deA.setOnClickListener(onClickListener);
        this.cSO = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.gia = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.gib = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.gic = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.gie = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.ghW.setText(d.j.remove_friend);
        } else {
            this.ghW.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ghX.setText(d.j.remove_block_chat);
        } else {
            this.ghX.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View bix() {
        return this.ghW;
    }

    public View biy() {
        return this.ghX;
    }

    public View biz() {
        return this.ghY;
    }

    public View biA() {
        return this.fRG;
    }

    public void tD(int i) {
        this.ghY.setVisibility(0);
        this.gie.setVisibility(0);
        if (i == 0) {
            this.ghY.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.ghY.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cSO.setVisibility(0);
            this.gia.setVisibility(0);
            this.cSO.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.s(this.mView, d.C0141d.cp_bg_line_d_alpha90);
        aj.r(this.ghX, d.C0141d.cp_link_tip_a);
        aj.s(this.ghX, d.f.more_pop_item_bg_selector);
        aj.r(this.ghW, d.C0141d.cp_link_tip_a);
        aj.s(this.ghW, d.f.more_pop_item_bg_selector);
        aj.r(this.fRG, d.C0141d.cp_link_tip_a);
        aj.s(this.fRG, d.f.more_pop_item_bg_selector);
        aj.r(this.ghY, d.C0141d.cp_link_tip_a);
        aj.s(this.ghY, d.f.more_pop_item_bg_selector);
        aj.t(this.gib, d.C0141d.cp_bg_line_b);
        aj.t(this.gic, d.C0141d.cp_bg_line_b);
        aj.t(this.gie, d.C0141d.cp_bg_line_b);
        aj.t(this.gia, d.C0141d.cp_bg_line_b);
        aj.t(this.ghZ, d.C0141d.cp_bg_line_b);
        aj.s(this.deA, d.f.person_more_pop_item_bg_selector);
        aj.r(this.deA, d.f.person_more_pop_cancel_text_selector);
        aj.s(this.cSO, d.f.more_pop_item_bg_selector);
        aj.r(this.cSO, d.C0141d.cp_cont_d);
    }
}
