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
    TextView aYJ;
    TextView bRM;
    TextView eYL;
    TextView eYM;
    TextView eYN;
    View eYO;
    View eYP;
    View eYQ;
    View eYR;
    TbPageContext mH;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mH = tbPageContext;
        a(this.mH, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.eYL = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.eYL.setOnClickListener(onClickListener);
        this.eYM = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.eYM.setOnClickListener(onClickListener);
        this.eYN = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.eYO = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.eYN.setOnClickListener(onClickListener);
        this.bRM = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bRM.setOnClickListener(onClickListener);
        this.aYJ = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.eYP = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.eYQ = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.eYR = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void J(boolean z, boolean z2) {
        if (z) {
            this.eYL.setText(d.l.remove_friend);
        } else {
            this.eYL.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eYM.setText(d.l.remove_block_chat);
        } else {
            this.eYM.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aVb() {
        return this.eYL;
    }

    public View aVc() {
        return this.eYM;
    }

    public View aVd() {
        return this.eYN;
    }

    public void qc(int i) {
        this.eYN.setVisibility(0);
        this.eYR.setVisibility(0);
        if (i == 0) {
            this.eYN.setText(this.mH.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.eYN.setText(this.mH.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aYJ.setVisibility(0);
            this.eYP.setVisibility(0);
            this.aYJ.setText(String.format(this.mH.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.e.cp_bg_line_d_alpha90);
        aj.i(this.eYM, d.e.cp_link_tip_a);
        aj.j(this.eYM, d.g.more_pop_item_bg_selector);
        aj.i(this.eYL, d.e.cp_link_tip_a);
        aj.j(this.eYL, d.g.more_pop_item_bg_selector);
        aj.i(this.eYN, d.e.cp_link_tip_a);
        aj.j(this.eYN, d.g.more_pop_item_bg_selector);
        aj.k(this.eYQ, d.e.cp_bg_line_b);
        aj.k(this.eYR, d.e.cp_bg_line_b);
        aj.k(this.eYP, d.e.cp_bg_line_b);
        aj.k(this.eYO, d.e.cp_bg_line_b);
        aj.j(this.bRM, d.g.person_more_pop_item_bg_selector);
        aj.i(this.bRM, d.g.person_more_pop_cancel_text_selector);
        aj.j(this.aYJ, d.g.more_pop_item_bg_selector);
        aj.i(this.aYJ, d.e.cp_cont_d);
    }
}
