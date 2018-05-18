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
    TextView cjV;
    TextView cxw;
    View fDA;
    View fDB;
    View fDC;
    TextView fDD;
    View fDE;
    TextView fDv;
    TextView fDw;
    TextView fDx;
    View fDy;
    View fDz;
    TextView fmJ;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.person_info_more_view, (ViewGroup) null);
        this.fDv = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fDv.setOnClickListener(onClickListener);
        this.fmJ = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.fmJ.setOnClickListener(onClickListener);
        this.fDw = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fDw.setOnClickListener(onClickListener);
        this.fDx = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fDy = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fDx.setOnClickListener(onClickListener);
        this.cxw = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cxw.setOnClickListener(onClickListener);
        this.cjV = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fDz = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fDA = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fDB = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fDC = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.fDD = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.fDE = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.fDD.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fDv.setText(d.k.remove_friend);
        } else {
            this.fDv.setText(d.k.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fDw.setText(d.k.remove_block_chat);
        } else {
            this.fDw.setText(d.k.block_chat_message);
        }
        if (z3) {
            this.fDD.setVisibility(0);
            this.fDE.setVisibility(0);
            return;
        }
        this.fDD.setVisibility(8);
        this.fDE.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bdx() {
        return this.fDv;
    }

    public View bdy() {
        return this.fDw;
    }

    public View bdz() {
        return this.fDx;
    }

    public View bdA() {
        return this.fmJ;
    }

    public View bdB() {
        return this.fDD;
    }

    public void qY(int i) {
        this.fDx.setVisibility(0);
        this.fDC.setVisibility(0);
        if (i == 0) {
            this.fDx.setText(this.mPageContext.getResources().getString(d.k.mute));
        } else if (i == 1) {
            this.fDx.setText(this.mPageContext.getResources().getString(d.k.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cjV.setVisibility(0);
            this.fDz.setVisibility(0);
            this.cjV.setText(String.format(this.mPageContext.getResources().getString(d.k.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ak.i(this.mView, d.C0126d.cp_bg_line_d_alpha90);
        ak.h(this.fDw, d.C0126d.cp_link_tip_a);
        ak.i(this.fDw, d.f.more_pop_item_bg_selector);
        ak.h(this.fDv, d.C0126d.cp_link_tip_a);
        ak.i(this.fDv, d.f.more_pop_item_bg_selector);
        ak.h(this.fmJ, d.C0126d.cp_link_tip_a);
        ak.i(this.fmJ, d.f.more_pop_item_bg_selector);
        ak.h(this.fDx, d.C0126d.cp_link_tip_a);
        ak.i(this.fDx, d.f.more_pop_item_bg_selector);
        ak.j(this.fDA, d.C0126d.cp_bg_line_b);
        ak.j(this.fDB, d.C0126d.cp_bg_line_b);
        ak.j(this.fDC, d.C0126d.cp_bg_line_b);
        ak.j(this.fDz, d.C0126d.cp_bg_line_b);
        ak.j(this.fDy, d.C0126d.cp_bg_line_b);
        ak.i(this.cxw, d.f.person_more_pop_item_bg_selector);
        ak.h(this.cxw, d.f.person_more_pop_cancel_text_selector);
        ak.i(this.cjV, d.f.more_pop_item_bg_selector);
        ak.h(this.cjV, d.C0126d.cp_cont_d);
        ak.h(this.fDD, d.C0126d.cp_link_tip_a);
        ak.i(this.fDD, d.f.more_pop_item_bg_selector);
        ak.j(this.fDE, d.C0126d.cp_bg_line_b);
    }
}
