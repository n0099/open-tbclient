package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.c {
    TextView aWn;
    TbPageContext ako;
    TextView bCc;
    TextView fcK;
    TextView fcL;
    TextView fcM;
    View fcN;
    View fcO;
    View fcP;
    View fcQ;
    View mView;

    public j(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ako = tbPageContext;
        a(this.ako, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.fcK = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.fcK.setOnClickListener(onClickListener);
        this.fcL = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.fcL.setOnClickListener(onClickListener);
        this.fcM = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.fcN = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.fcM.setOnClickListener(onClickListener);
        this.bCc = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bCc.setOnClickListener(onClickListener);
        this.aWn = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.fcO = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.fcP = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.fcQ = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void G(boolean z, boolean z2) {
        if (z) {
            this.fcK.setText(d.l.remove_friend);
        } else {
            this.fcK.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fcL.setText(d.l.remove_block_chat);
        } else {
            this.fcL.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aWO() {
        return this.fcK;
    }

    public View aWP() {
        return this.fcL;
    }

    public View aWQ() {
        return this.fcM;
    }

    public void pW(int i) {
        this.fcM.setVisibility(0);
        this.fcQ.setVisibility(0);
        if (i == 0) {
            this.fcM.setText(this.ako.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.fcM.setText(this.ako.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aWn.setVisibility(0);
            this.fcO.setVisibility(0);
            this.aWn.setText(String.format(this.ako.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ai.j(this.mView, d.e.cp_bg_line_d_alpha90);
        ai.i(this.fcL, d.e.cp_link_tip_a);
        ai.j(this.fcL, d.g.more_pop_item_bg_selector);
        ai.i(this.fcK, d.e.cp_link_tip_a);
        ai.j(this.fcK, d.g.more_pop_item_bg_selector);
        ai.i(this.fcM, d.e.cp_link_tip_a);
        ai.j(this.fcM, d.g.more_pop_item_bg_selector);
        ai.k(this.fcP, d.e.cp_bg_line_b);
        ai.k(this.fcQ, d.e.cp_bg_line_b);
        ai.k(this.fcO, d.e.cp_bg_line_b);
        ai.k(this.fcN, d.e.cp_bg_line_b);
        ai.j(this.bCc, d.g.person_more_pop_item_bg_selector);
        ai.i(this.bCc, d.g.person_more_pop_cancel_text_selector);
        ai.j(this.aWn, d.g.more_pop_item_bg_selector);
        ai.i(this.aWn, d.e.cp_cont_d);
    }
}
