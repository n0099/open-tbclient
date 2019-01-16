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
    TextView cLW;
    TextView gdC;
    TextView gtU;
    TextView gtV;
    TextView gtW;
    View gtX;
    View gtY;
    View gtZ;
    View gua;
    View gub;
    TextView guc;
    View gud;
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
        this.gtU = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_friend);
        this.gtU.setOnClickListener(onClickListener);
        this.gdC = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_report);
        this.gdC.setOnClickListener(onClickListener);
        this.gtV = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_black);
        this.gtV.setOnClickListener(onClickListener);
        this.gtW = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_mute);
        this.gtX = this.mView.findViewById(e.g.person_info_more_view_item_line_mute);
        this.gtW.setOnClickListener(onClickListener);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_cancel);
        this.mCancelView.setOnClickListener(onClickListener);
        this.cLW = (TextView) this.mView.findViewById(e.g.person_info_more_view_item_username);
        this.gtY = this.mView.findViewById(e.g.person_info_more_view_item_line_username);
        this.gtZ = this.mView.findViewById(e.g.person_info_more_view_item_line_friend);
        this.gua = this.mView.findViewById(e.g.person_info_more_view_item_line_report);
        this.gub = this.mView.findViewById(e.g.person_info_more_view_item_line_black);
        this.guc = (TextView) this.mView.findViewById(e.g.person_info_item_remove_fans_view);
        this.gud = this.mView.findViewById(e.g.person_info_line_remove_fans_view);
        this.guc.setOnClickListener(onClickListener);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.gtU.setText(e.j.remove_friend);
        } else {
            this.gtU.setText(e.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.gtV.setText(e.j.remove_block_chat);
        } else {
            this.gtV.setText(e.j.block_chat_message);
        }
        if (z3) {
            this.guc.setVisibility(0);
            this.gud.setVisibility(0);
            return;
        }
        this.guc.setVisibility(8);
        this.gud.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bpL() {
        return this.gtU;
    }

    public View bpM() {
        return this.gtV;
    }

    public View bpN() {
        return this.gtW;
    }

    public View bpO() {
        return this.gdC;
    }

    public View bpP() {
        return this.guc;
    }

    public void to(int i) {
        this.gtW.setVisibility(0);
        this.gub.setVisibility(0);
        if (i == 0) {
            this.gtW.setText(this.mPageContext.getResources().getString(e.j.mute));
        } else if (i == 1) {
            this.gtW.setText(this.mPageContext.getResources().getString(e.j.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cLW.setVisibility(8);
            this.gtY.setVisibility(8);
            return;
        }
        this.cLW.setVisibility(0);
        this.gtY.setVisibility(0);
        this.cLW.setText(String.format(this.mPageContext.getResources().getString(e.j.more_info_username), str));
    }

    public void onChangeSkinType() {
        al.i(this.mView, e.d.cp_bg_line_d_alpha90);
        al.h(this.gtV, e.d.cp_link_tip_a);
        al.i(this.gtV, e.f.more_pop_item_bg_selector);
        al.h(this.gtU, e.d.cp_link_tip_a);
        al.i(this.gtU, e.f.more_pop_item_bg_selector);
        al.h(this.gdC, e.d.cp_link_tip_a);
        al.i(this.gdC, e.f.more_pop_item_bg_selector);
        al.h(this.gtW, e.d.cp_link_tip_a);
        al.i(this.gtW, e.f.more_pop_item_bg_selector);
        al.j(this.gtZ, e.d.cp_bg_line_b);
        al.j(this.gua, e.d.cp_bg_line_b);
        al.j(this.gub, e.d.cp_bg_line_b);
        al.j(this.gtY, e.d.cp_bg_line_b);
        al.j(this.gtX, e.d.cp_bg_line_b);
        al.i(this.mCancelView, e.f.person_more_pop_item_bg_selector);
        al.h(this.mCancelView, e.f.person_more_pop_cancel_text_selector);
        al.i(this.cLW, e.f.more_pop_item_bg_selector);
        al.h(this.cLW, e.d.cp_cont_d);
        al.h(this.guc, e.d.cp_link_tip_a);
        al.i(this.guc, e.f.more_pop_item_bg_selector);
        al.j(this.gud, e.d.cp_bg_line_b);
    }
}
