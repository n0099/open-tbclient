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
    TextView bcz;
    TextView cit;
    TextView eZG;
    TextView frA;
    View frB;
    View frC;
    View frD;
    View frE;
    View frF;
    TextView fry;
    TextView frz;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.fry = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fry.setOnClickListener(onClickListener);
        this.eZG = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.eZG.setOnClickListener(onClickListener);
        this.frz = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.frz.setOnClickListener(onClickListener);
        this.frA = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.frB = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.frA.setOnClickListener(onClickListener);
        this.cit = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cit.setOnClickListener(onClickListener);
        this.bcz = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.frC = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.frD = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.frE = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.frF = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.fry.setText(d.j.remove_friend);
        } else {
            this.fry.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.frz.setText(d.j.remove_block_chat);
        } else {
            this.frz.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aZV() {
        return this.fry;
    }

    public View aZW() {
        return this.frz;
    }

    public View aZX() {
        return this.frA;
    }

    public View aZY() {
        return this.eZG;
    }

    public void qS(int i) {
        this.frA.setVisibility(0);
        this.frF.setVisibility(0);
        if (i == 0) {
            this.frA.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.frA.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcz.setVisibility(0);
            this.frC.setVisibility(0);
            this.bcz.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.C0095d.cp_bg_line_d_alpha90);
        aj.i(this.frz, d.C0095d.cp_link_tip_a);
        aj.j(this.frz, d.f.more_pop_item_bg_selector);
        aj.i(this.fry, d.C0095d.cp_link_tip_a);
        aj.j(this.fry, d.f.more_pop_item_bg_selector);
        aj.i(this.eZG, d.C0095d.cp_link_tip_a);
        aj.j(this.eZG, d.f.more_pop_item_bg_selector);
        aj.i(this.frA, d.C0095d.cp_link_tip_a);
        aj.j(this.frA, d.f.more_pop_item_bg_selector);
        aj.k(this.frD, d.C0095d.cp_bg_line_b);
        aj.k(this.frE, d.C0095d.cp_bg_line_b);
        aj.k(this.frF, d.C0095d.cp_bg_line_b);
        aj.k(this.frC, d.C0095d.cp_bg_line_b);
        aj.k(this.frB, d.C0095d.cp_bg_line_b);
        aj.j(this.cit, d.f.person_more_pop_item_bg_selector);
        aj.i(this.cit, d.f.person_more_pop_cancel_text_selector);
        aj.j(this.bcz, d.f.more_pop_item_bg_selector);
        aj.i(this.bcz, d.C0095d.cp_cont_d);
    }
}
