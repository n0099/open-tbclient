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
    TextView cLX;
    TextView gdD;
    TextView gtV;
    TextView gtW;
    TextView gtX;
    View gtY;
    View gtZ;
    View gua;
    View gub;
    View guc;
    TextView gud;
    View gue;
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
        this.gtV = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.gtV.setOnClickListener(onClickListener);
        this.gdD = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.gdD.setOnClickListener(onClickListener);
        this.gtW = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.gtW.setOnClickListener(onClickListener);
        this.gtX = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.gtY = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.gtX.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cLX = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.gtZ = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.gua = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.gub = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.guc = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.gud = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.gue = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.gud.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.gtV.setText(e.j.remove_friend);
        } else {
            this.gtV.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gtW.setText(e.j.remove_block_chat);
        } else {
            this.gtW.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.gud.setVisibility(0);
            this.gue.setVisibility(0);
            return;
        }
        this.gud.setVisibility(8);
        this.gue.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bpL() {
        return this.gtV;
    }

    public View bpM() {
        return this.gtW;
    }

    public View bpN() {
        return this.gtX;
    }

    public View bpO() {
        return this.gdD;
    }

    public View bpP() {
        return this.gud;
    }

    public void to(int i) {
        this.gtX.setVisibility(0);
        this.guc.setVisibility(0);
        if (i == 0) {
            this.gtX.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.gtX.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cLX.setVisibility(8);
            this.gtZ.setVisibility(8);
            return;
        }
        this.cLX.setVisibility(0);
        this.gtZ.setVisibility(0);
        this.cLX.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.gtW, e.d.cp_link_tip_a);
        al.i(this.gtW, e.f.more_pop_item_bg_selector);
        al.h(this.gtV, e.d.cp_link_tip_a);
        al.i(this.gtV, e.f.more_pop_item_bg_selector);
        al.h(this.gdD, e.d.cp_link_tip_a);
        al.i(this.gdD, e.f.more_pop_item_bg_selector);
        al.h(this.gtX, e.d.cp_link_tip_a);
        al.i(this.gtX, e.f.more_pop_item_bg_selector);
        al.j(this.gua, e.d.cp_bg_line_b);
        al.j(this.gub, e.d.cp_bg_line_b);
        al.j(this.guc, e.d.cp_bg_line_b);
        al.j(this.gtZ, e.d.cp_bg_line_b);
        al.j(this.gtY, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cLX, e.f.more_pop_item_bg_selector);
        al.h(this.cLX, e.d.cp_cont_d);
        al.h(this.gud, e.d.cp_link_tip_a);
        al.i(this.gud, e.f.more_pop_item_bg_selector);
        al.j(this.gue, e.d.cp_bg_line_b);
    }
}
