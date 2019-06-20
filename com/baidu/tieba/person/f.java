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
    TextView ejs;
    TextView hLf;
    TextView ibV;
    TextView ibW;
    TextView ibX;
    View ibY;
    View ibZ;
    View ica;
    View icb;
    View icc;
    TextView icd;
    View ice;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ibV = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ibV.setOnClickListener(onClickListener);
        this.hLf = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hLf.setOnClickListener(onClickListener);
        this.ibW = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ibW.setOnClickListener(onClickListener);
        this.ibX = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ibY = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.ibX.setOnClickListener(onClickListener);
        this.bpQ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.bpQ.setOnClickListener(onClickListener);
        this.ejs = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ibZ = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.ica = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.icb = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.icc = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.icd = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ice = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.icd.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ibV.setText(R.string.remove_friend);
        } else {
            this.ibV.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ibW.setText(R.string.remove_block_chat);
        } else {
            this.ibW.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.icd.setVisibility(0);
            this.ice.setVisibility(0);
            return;
        }
        this.icd.setVisibility(8);
        this.ice.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bYc() {
        return this.ibV;
    }

    public View bYd() {
        return this.ibW;
    }

    public View bYe() {
        return this.ibX;
    }

    public View bYf() {
        return this.hLf;
    }

    public View bYg() {
        return this.icd;
    }

    public void ya(int i) {
        this.ibX.setVisibility(0);
        this.icc.setVisibility(0);
        if (i == 0) {
            this.ibX.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ibX.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ejs.setVisibility(8);
            this.ibZ.setVisibility(8);
            return;
        }
        this.ejs.setVisibility(0);
        this.ibZ.setVisibility(0);
        this.ejs.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.k(this.mView, R.color.cp_bg_line_d_alpha90);
        al.j(this.ibW, R.color.cp_link_tip_a);
        al.k(this.ibW, R.drawable.more_pop_item_bg_selector);
        al.j(this.ibV, R.color.cp_link_tip_a);
        al.k(this.ibV, R.drawable.more_pop_item_bg_selector);
        al.j(this.hLf, R.color.cp_link_tip_a);
        al.k(this.hLf, R.drawable.more_pop_item_bg_selector);
        al.j(this.ibX, R.color.cp_link_tip_a);
        al.k(this.ibX, R.drawable.more_pop_item_bg_selector);
        al.l(this.ica, R.color.cp_bg_line_b);
        al.l(this.icb, R.color.cp_bg_line_b);
        al.l(this.icc, R.color.cp_bg_line_b);
        al.l(this.ibZ, R.color.cp_bg_line_b);
        al.l(this.ibY, R.color.cp_bg_line_b);
        al.k(this.bpQ, R.drawable.person_more_pop_item_bg_selector);
        al.j(this.bpQ, R.drawable.person_more_pop_cancel_text_selector);
        al.k(this.ejs, R.drawable.more_pop_item_bg_selector);
        al.j(this.ejs, R.color.cp_cont_d);
        al.j(this.icd, R.color.cp_link_tip_a);
        al.k(this.icd, R.drawable.more_pop_item_bg_selector);
        al.l(this.ice, R.color.cp_bg_line_b);
    }
}
