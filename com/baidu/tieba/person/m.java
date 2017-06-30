package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.e {
    TextView aVm;
    TbPageContext ajP;
    TextView bxV;
    TextView eQj;
    TextView eQk;
    TextView eQl;
    View eQm;
    View eQn;
    View eQo;
    View eQp;
    View mView;

    public m(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ajP = tbPageContext;
        a(this.ajP, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.person_info_more_view, (ViewGroup) null);
        this.eQj = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_friend);
        this.eQj.setOnClickListener(onClickListener);
        this.eQk = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_black);
        this.eQk.setOnClickListener(onClickListener);
        this.eQl = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_mute);
        this.eQm = this.mView.findViewById(w.h.person_info_more_view_item_line_mute);
        this.eQl.setOnClickListener(onClickListener);
        this.bxV = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_cancel);
        this.bxV.setOnClickListener(onClickListener);
        this.aVm = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_username);
        this.eQn = this.mView.findViewById(w.h.person_info_more_view_item_line_username);
        this.eQo = this.mView.findViewById(w.h.person_info_more_view_item_line_friend);
        this.eQp = this.mView.findViewById(w.h.person_info_more_view_item_line_black);
    }

    public void C(boolean z, boolean z2) {
        if (z) {
            this.eQj.setText(w.l.remove_friend);
        } else {
            this.eQj.setText(w.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eQk.setText(w.l.remove_block_chat);
        } else {
            this.eQk.setText(w.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aTR() {
        return this.eQj;
    }

    public View aTS() {
        return this.eQk;
    }

    public View aTT() {
        return this.eQl;
    }

    public void pH(int i) {
        this.eQl.setVisibility(0);
        this.eQp.setVisibility(0);
        if (i == 0) {
            this.eQl.setText(this.ajP.getResources().getString(w.l.mute));
        } else if (i == 1) {
            this.eQl.setText(this.ajP.getResources().getString(w.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aVm.setVisibility(0);
            this.eQn.setVisibility(0);
            this.aVm.setText(String.format(this.ajP.getResources().getString(w.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        as.j(this.mView, w.e.cp_bg_line_d_alpha90);
        as.i(this.eQk, w.e.cp_link_tip_a);
        as.j(this.eQk, w.g.more_pop_item_bg_selector);
        as.i(this.eQj, w.e.cp_link_tip_a);
        as.j(this.eQj, w.g.more_pop_item_bg_selector);
        as.i(this.eQl, w.e.cp_link_tip_a);
        as.j(this.eQl, w.g.more_pop_item_bg_selector);
        as.k(this.eQo, w.e.cp_bg_line_b);
        as.k(this.eQp, w.e.cp_bg_line_b);
        as.k(this.eQn, w.e.cp_bg_line_b);
        as.k(this.eQm, w.e.cp_bg_line_b);
        as.j(this.bxV, w.g.person_more_pop_item_bg_selector);
        as.i(this.bxV, w.g.person_more_pop_cancel_text_selector);
        as.j(this.aVm, w.g.more_pop_item_bg_selector);
        as.i(this.aVm, w.e.cp_cont_d);
    }
}
