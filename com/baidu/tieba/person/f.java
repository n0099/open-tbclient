package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c {
    TextView bqD;
    TextView enZ;
    TextView hRs;
    TextView iin;
    TextView iio;
    TextView iip;
    View iiq;
    View iir;
    View iis;
    View iit;
    View iiu;
    TextView iiv;
    View iiw;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.iin = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.iin.setOnClickListener(onClickListener);
        this.hRs = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hRs.setOnClickListener(onClickListener);
        this.iio = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.iio.setOnClickListener(onClickListener);
        this.iip = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.iiq = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.iip.setOnClickListener(onClickListener);
        this.bqD = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.bqD.setOnClickListener(onClickListener);
        this.enZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.iir = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.iis = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.iit = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.iiu = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.iiv = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.iiw = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.iiv.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.iin.setText(R.string.remove_friend);
        } else {
            this.iin.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.iio.setText(R.string.remove_block_chat);
        } else {
            this.iio.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.iiv.setVisibility(0);
            this.iiw.setVisibility(0);
            return;
        }
        this.iiv.setVisibility(8);
        this.iiw.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View caR() {
        return this.iin;
    }

    public View caS() {
        return this.iio;
    }

    public View caT() {
        return this.iip;
    }

    public View caU() {
        return this.hRs;
    }

    public View caV() {
        return this.iiv;
    }

    public void yF(int i) {
        this.iip.setVisibility(0);
        this.iiu.setVisibility(0);
        if (i == 0) {
            this.iip.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.iip.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.enZ.setVisibility(8);
            this.iir.setVisibility(8);
            return;
        }
        this.enZ.setVisibility(0);
        this.iir.setVisibility(0);
        this.enZ.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.k(this.mView, R.color.cp_bg_line_d_alpha90);
        am.j(this.iio, R.color.cp_link_tip_a);
        am.k(this.iio, R.drawable.more_pop_item_bg_selector);
        am.j(this.iin, R.color.cp_link_tip_a);
        am.k(this.iin, R.drawable.more_pop_item_bg_selector);
        am.j(this.hRs, R.color.cp_link_tip_a);
        am.k(this.hRs, R.drawable.more_pop_item_bg_selector);
        am.j(this.iip, R.color.cp_link_tip_a);
        am.k(this.iip, R.drawable.more_pop_item_bg_selector);
        am.l(this.iis, R.color.cp_bg_line_b);
        am.l(this.iit, R.color.cp_bg_line_b);
        am.l(this.iiu, R.color.cp_bg_line_b);
        am.l(this.iir, R.color.cp_bg_line_b);
        am.l(this.iiq, R.color.cp_bg_line_b);
        am.k(this.bqD, R.drawable.person_more_pop_item_bg_selector);
        am.j(this.bqD, R.drawable.person_more_pop_cancel_text_selector);
        am.k(this.enZ, R.drawable.more_pop_item_bg_selector);
        am.j(this.enZ, R.color.cp_cont_d);
        am.j(this.iiv, R.color.cp_link_tip_a);
        am.k(this.iiv, R.drawable.more_pop_item_bg_selector);
        am.l(this.iiw, R.color.cp_bg_line_b);
    }
}
