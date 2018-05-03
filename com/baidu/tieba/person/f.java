package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c {
    TextView ciX;
    TextView cwn;
    TextView fCp;
    TextView fCq;
    TextView fCr;
    View fCs;
    View fCt;
    View fCu;
    View fCv;
    View fCw;
    TextView fCx;
    View fCy;
    TextView flC;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.person_info_more_view, (ViewGroup) null);
        this.fCp = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fCp.setOnClickListener(onClickListener);
        this.flC = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.flC.setOnClickListener(onClickListener);
        this.fCq = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fCq.setOnClickListener(onClickListener);
        this.fCr = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fCs = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fCr.setOnClickListener(onClickListener);
        this.cwn = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cwn.setOnClickListener(onClickListener);
        this.ciX = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fCt = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fCu = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fCv = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fCw = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.fCx = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.fCy = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.fCx.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fCp.setText(d.k.remove_friend);
        } else {
            this.fCp.setText(d.k.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fCq.setText(d.k.remove_block_chat);
        } else {
            this.fCq.setText(d.k.block_chat_message);
        }
        if (z3) {
            this.fCx.setVisibility(0);
            this.fCy.setVisibility(0);
            return;
        }
        this.fCx.setVisibility(8);
        this.fCy.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bdx() {
        return this.fCp;
    }

    public View bdy() {
        return this.fCq;
    }

    public View bdz() {
        return this.fCr;
    }

    public View bdA() {
        return this.flC;
    }

    public View bdB() {
        return this.fCx;
    }

    public void qZ(int i) {
        this.fCr.setVisibility(0);
        this.fCw.setVisibility(0);
        if (i == 0) {
            this.fCr.setText(this.mPageContext.getResources().getString(d.k.mute));
        } else if (i == 1) {
            this.fCr.setText(this.mPageContext.getResources().getString(d.k.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ciX.setVisibility(0);
            this.fCt.setVisibility(0);
            this.ciX.setText(String.format(this.mPageContext.getResources().getString(d.k.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ak.i(this.mView, d.C0126d.cp_bg_line_d_alpha90);
        ak.h(this.fCq, d.C0126d.cp_link_tip_a);
        ak.i(this.fCq, d.f.more_pop_item_bg_selector);
        ak.h(this.fCp, d.C0126d.cp_link_tip_a);
        ak.i(this.fCp, d.f.more_pop_item_bg_selector);
        ak.h(this.flC, d.C0126d.cp_link_tip_a);
        ak.i(this.flC, d.f.more_pop_item_bg_selector);
        ak.h(this.fCr, d.C0126d.cp_link_tip_a);
        ak.i(this.fCr, d.f.more_pop_item_bg_selector);
        ak.j(this.fCu, d.C0126d.cp_bg_line_b);
        ak.j(this.fCv, d.C0126d.cp_bg_line_b);
        ak.j(this.fCw, d.C0126d.cp_bg_line_b);
        ak.j(this.fCt, d.C0126d.cp_bg_line_b);
        ak.j(this.fCs, d.C0126d.cp_bg_line_b);
        ak.i(this.cwn, d.f.person_more_pop_item_bg_selector);
        ak.h(this.cwn, d.f.person_more_pop_cancel_text_selector);
        ak.i(this.ciX, d.f.more_pop_item_bg_selector);
        ak.h(this.ciX, d.C0126d.cp_cont_d);
        ak.h(this.fCx, d.C0126d.cp_link_tip_a);
        ak.i(this.fCx, d.f.more_pop_item_bg_selector);
        ak.j(this.fCy, d.C0126d.cp_bg_line_b);
    }
}
