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
    TextView aYZ;
    TextView bZq;
    TextView ePy;
    TextView fhb;
    TextView fhc;
    TextView fhd;
    View fhe;
    View fhf;
    View fhg;
    View fhh;
    View fhi;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.person_info_more_view, (ViewGroup) null);
        this.fhb = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fhb.setOnClickListener(onClickListener);
        this.ePy = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.ePy.setOnClickListener(onClickListener);
        this.fhc = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fhc.setOnClickListener(onClickListener);
        this.fhd = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fhe = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fhd.setOnClickListener(onClickListener);
        this.bZq = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.bZq.setOnClickListener(onClickListener);
        this.aYZ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fhf = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fhg = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fhh = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fhi = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.fhb.setText(d.j.remove_friend);
        } else {
            this.fhb.setText(d.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fhc.setText(d.j.remove_block_chat);
        } else {
            this.fhc.setText(d.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aYd() {
        return this.fhb;
    }

    public View aYe() {
        return this.fhc;
    }

    public View aYf() {
        return this.fhd;
    }

    public View aYg() {
        return this.ePy;
    }

    public void qt(int i) {
        this.fhd.setVisibility(0);
        this.fhi.setVisibility(0);
        if (i == 0) {
            this.fhd.setText(this.mPageContext.getResources().getString(d.j.mute));
        } else if (i == 1) {
            this.fhd.setText(this.mPageContext.getResources().getString(d.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aYZ.setVisibility(0);
            this.fhf.setVisibility(0);
            this.aYZ.setText(String.format(this.mPageContext.getResources().getString(d.j.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.C0080d.cp_bg_line_d_alpha90);
        aj.i(this.fhc, d.C0080d.cp_link_tip_a);
        aj.j(this.fhc, d.f.more_pop_item_bg_selector);
        aj.i(this.fhb, d.C0080d.cp_link_tip_a);
        aj.j(this.fhb, d.f.more_pop_item_bg_selector);
        aj.i(this.ePy, d.C0080d.cp_link_tip_a);
        aj.j(this.ePy, d.f.more_pop_item_bg_selector);
        aj.i(this.fhd, d.C0080d.cp_link_tip_a);
        aj.j(this.fhd, d.f.more_pop_item_bg_selector);
        aj.k(this.fhg, d.C0080d.cp_bg_line_b);
        aj.k(this.fhh, d.C0080d.cp_bg_line_b);
        aj.k(this.fhi, d.C0080d.cp_bg_line_b);
        aj.k(this.fhf, d.C0080d.cp_bg_line_b);
        aj.k(this.fhe, d.C0080d.cp_bg_line_b);
        aj.j(this.bZq, d.f.person_more_pop_item_bg_selector);
        aj.i(this.bZq, d.f.person_more_pop_cancel_text_selector);
        aj.j(this.aYZ, d.f.more_pop_item_bg_selector);
        aj.i(this.aYZ, d.C0080d.cp_cont_d);
    }
}
