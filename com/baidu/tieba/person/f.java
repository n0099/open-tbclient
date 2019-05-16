package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c {
    TextView bpQ;
    TextView ejr;
    TextView hLb;
    TextView ibR;
    TextView ibS;
    TextView ibT;
    View ibU;
    View ibV;
    View ibW;
    View ibX;
    View ibY;
    TextView ibZ;
    View ica;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ibR = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ibR.setOnClickListener(onClickListener);
        this.hLb = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hLb.setOnClickListener(onClickListener);
        this.ibS = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ibS.setOnClickListener(onClickListener);
        this.ibT = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ibU = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.ibT.setOnClickListener(onClickListener);
        this.bpQ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.bpQ.setOnClickListener(onClickListener);
        this.ejr = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ibV = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.ibW = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.ibX = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.ibY = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.ibZ = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ica = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.ibZ.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ibR.setText(R.string.remove_friend);
        } else {
            this.ibR.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ibS.setText(R.string.remove_block_chat);
        } else {
            this.ibS.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ibZ.setVisibility(0);
            this.ica.setVisibility(0);
            return;
        }
        this.ibZ.setVisibility(8);
        this.ica.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bXY() {
        return this.ibR;
    }

    public View bXZ() {
        return this.ibS;
    }

    public View bYa() {
        return this.ibT;
    }

    public View bYb() {
        return this.hLb;
    }

    public View bYc() {
        return this.ibZ;
    }

    public void ya(int i) {
        this.ibT.setVisibility(0);
        this.ibY.setVisibility(0);
        if (i == 0) {
            this.ibT.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ibT.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ejr.setVisibility(8);
            this.ibV.setVisibility(8);
            return;
        }
        this.ejr.setVisibility(0);
        this.ibV.setVisibility(0);
        this.ejr.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, R.color.cp_bg_line_d_alpha90);
        al.j(this.ibS, R.color.cp_link_tip_a);
        al.k(this.ibS, R.drawable.more_pop_item_bg_selector);
        al.j(this.ibR, R.color.cp_link_tip_a);
        al.k(this.ibR, R.drawable.more_pop_item_bg_selector);
        al.j(this.hLb, R.color.cp_link_tip_a);
        al.k(this.hLb, R.drawable.more_pop_item_bg_selector);
        al.j(this.ibT, R.color.cp_link_tip_a);
        al.k(this.ibT, R.drawable.more_pop_item_bg_selector);
        al.l(this.ibW, R.color.cp_bg_line_b);
        al.l(this.ibX, R.color.cp_bg_line_b);
        al.l(this.ibY, R.color.cp_bg_line_b);
        al.l(this.ibV, R.color.cp_bg_line_b);
        al.l(this.ibU, R.color.cp_bg_line_b);
        al.k(this.bpQ, R.drawable.person_more_pop_item_bg_selector);
        al.j(this.bpQ, R.drawable.person_more_pop_cancel_text_selector);
        al.k(this.ejr, R.drawable.more_pop_item_bg_selector);
        al.j(this.ejr, R.color.cp_cont_d);
        al.j(this.ibZ, R.color.cp_link_tip_a);
        al.k(this.ibZ, R.drawable.more_pop_item_bg_selector);
        al.l(this.ica, R.color.cp_bg_line_b);
    }
}
