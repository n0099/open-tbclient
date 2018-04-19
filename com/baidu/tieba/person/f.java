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
    TextView cja;
    TextView cwq;
    TextView fCA;
    View fCB;
    TextView fCs;
    TextView fCt;
    TextView fCu;
    View fCv;
    View fCw;
    View fCx;
    View fCy;
    View fCz;
    TextView flF;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.person_info_more_view, (ViewGroup) null);
        this.fCs = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_friend);
        this.fCs.setOnClickListener(onClickListener);
        this.flF = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_report);
        this.flF.setOnClickListener(onClickListener);
        this.fCt = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_black);
        this.fCt.setOnClickListener(onClickListener);
        this.fCu = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_mute);
        this.fCv = this.mView.findViewById(d.g.person_info_more_view_item_line_mute);
        this.fCu.setOnClickListener(onClickListener);
        this.cwq = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_cancel);
        this.cwq.setOnClickListener(onClickListener);
        this.cja = (TextView) this.mView.findViewById(d.g.person_info_more_view_item_username);
        this.fCw = this.mView.findViewById(d.g.person_info_more_view_item_line_username);
        this.fCx = this.mView.findViewById(d.g.person_info_more_view_item_line_friend);
        this.fCy = this.mView.findViewById(d.g.person_info_more_view_item_line_report);
        this.fCz = this.mView.findViewById(d.g.person_info_more_view_item_line_black);
        this.fCA = (TextView) this.mView.findViewById(d.g.person_info_item_remove_fans_view);
        this.fCB = this.mView.findViewById(d.g.person_info_line_remove_fans_view);
        this.fCA.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.fCs.setText(d.k.remove_friend);
        } else {
            this.fCs.setText(d.k.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.fCt.setText(d.k.remove_block_chat);
        } else {
            this.fCt.setText(d.k.block_chat_message);
        }
        if (z3) {
            this.fCA.setVisibility(0);
            this.fCB.setVisibility(0);
            return;
        }
        this.fCA.setVisibility(8);
        this.fCB.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bdx() {
        return this.fCs;
    }

    public View bdy() {
        return this.fCt;
    }

    public View bdz() {
        return this.fCu;
    }

    public View bdA() {
        return this.flF;
    }

    public View bdB() {
        return this.fCA;
    }

    public void qZ(int i) {
        this.fCu.setVisibility(0);
        this.fCz.setVisibility(0);
        if (i == 0) {
            this.fCu.setText(this.mPageContext.getResources().getString(d.k.mute));
        } else if (i == 1) {
            this.fCu.setText(this.mPageContext.getResources().getString(d.k.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cja.setVisibility(0);
            this.fCw.setVisibility(0);
            this.cja.setText(String.format(this.mPageContext.getResources().getString(d.k.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        ak.i(this.mView, d.C0126d.cp_bg_line_d_alpha90);
        ak.h(this.fCt, d.C0126d.cp_link_tip_a);
        ak.i(this.fCt, d.f.more_pop_item_bg_selector);
        ak.h(this.fCs, d.C0126d.cp_link_tip_a);
        ak.i(this.fCs, d.f.more_pop_item_bg_selector);
        ak.h(this.flF, d.C0126d.cp_link_tip_a);
        ak.i(this.flF, d.f.more_pop_item_bg_selector);
        ak.h(this.fCu, d.C0126d.cp_link_tip_a);
        ak.i(this.fCu, d.f.more_pop_item_bg_selector);
        ak.j(this.fCx, d.C0126d.cp_bg_line_b);
        ak.j(this.fCy, d.C0126d.cp_bg_line_b);
        ak.j(this.fCz, d.C0126d.cp_bg_line_b);
        ak.j(this.fCw, d.C0126d.cp_bg_line_b);
        ak.j(this.fCv, d.C0126d.cp_bg_line_b);
        ak.i(this.cwq, d.f.person_more_pop_item_bg_selector);
        ak.h(this.cwq, d.f.person_more_pop_cancel_text_selector);
        ak.i(this.cja, d.f.more_pop_item_bg_selector);
        ak.h(this.cja, d.C0126d.cp_cont_d);
        ak.h(this.fCA, d.C0126d.cp_link_tip_a);
        ak.i(this.fCA, d.f.more_pop_item_bg_selector);
        ak.j(this.fCB, d.C0126d.cp_bg_line_b);
    }
}
