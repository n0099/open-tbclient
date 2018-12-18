package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c {
    TextView cKl;
    TextView fZM;
    TextView gpZ;
    TextView gqa;
    TextView gqb;
    View gqc;
    View gqd;
    View gqe;
    View gqf;
    View gqg;
    TextView gqh;
    View gqi;
    TextView mCancelView;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.person_info_more_view, (ViewGroup) null);
        this.gpZ = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.gpZ.setOnClickListener(onClickListener);
        this.fZM = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.fZM.setOnClickListener(onClickListener);
        this.gqa = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.gqa.setOnClickListener(onClickListener);
        this.gqb = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.gqc = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.gqb.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cKl = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.gqd = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.gqe = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.gqf = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.gqg = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.gqh = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.gqi = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.gqh.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.gpZ.setText(e.j.remove_friend);
        } else {
            this.gpZ.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gqa.setText(e.j.remove_block_chat);
        } else {
            this.gqa.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.gqh.setVisibility(0);
            this.gqi.setVisibility(0);
            return;
        }
        this.gqh.setVisibility(8);
        this.gqi.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View boq() {
        return this.gpZ;
    }

    public View bor() {
        return this.gqa;
    }

    public View bos() {
        return this.gqb;
    }

    public View bot() {
        return this.fZM;
    }

    public View bou() {
        return this.gqh;
    }

    public void sX(int i) {
        this.gqb.setVisibility(0);
        this.gqg.setVisibility(0);
        if (i == 0) {
            this.gqb.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.gqb.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cKl.setVisibility(8);
            this.gqd.setVisibility(8);
            return;
        }
        this.cKl.setVisibility(0);
        this.gqd.setVisibility(0);
        this.cKl.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.gqa, e.d.cp_link_tip_a);
        al.i(this.gqa, e.f.more_pop_item_bg_selector);
        al.h(this.gpZ, e.d.cp_link_tip_a);
        al.i(this.gpZ, e.f.more_pop_item_bg_selector);
        al.h(this.fZM, e.d.cp_link_tip_a);
        al.i(this.fZM, e.f.more_pop_item_bg_selector);
        al.h(this.gqb, e.d.cp_link_tip_a);
        al.i(this.gqb, e.f.more_pop_item_bg_selector);
        al.j(this.gqe, e.d.cp_bg_line_b);
        al.j(this.gqf, e.d.cp_bg_line_b);
        al.j(this.gqg, e.d.cp_bg_line_b);
        al.j(this.gqd, e.d.cp_bg_line_b);
        al.j(this.gqc, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cKl, e.f.more_pop_item_bg_selector);
        al.h(this.cKl, e.d.cp_cont_d);
        al.h(this.gqh, e.d.cp_link_tip_a);
        al.i(this.gqh, e.f.more_pop_item_bg_selector);
        al.j(this.gqi, e.d.cp_bg_line_b);
    }
}
