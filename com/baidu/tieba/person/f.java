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
    TextView eog;
    TextView hSn;
    TextView ijp;
    TextView ijq;
    TextView ijr;
    View ijs;
    View ijt;
    View iju;
    View ijv;
    View ijw;
    TextView ijx;
    View ijy;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ijp = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ijp.setOnClickListener(onClickListener);
        this.hSn = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hSn.setOnClickListener(onClickListener);
        this.ijq = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ijq.setOnClickListener(onClickListener);
        this.ijr = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ijs = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.ijr.setOnClickListener(onClickListener);
        this.bqD = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.bqD.setOnClickListener(onClickListener);
        this.eog = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ijt = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.iju = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.ijv = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.ijw = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.ijx = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ijy = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.ijx.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ijp.setText(R.string.remove_friend);
        } else {
            this.ijp.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ijq.setText(R.string.remove_block_chat);
        } else {
            this.ijq.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ijx.setVisibility(0);
            this.ijy.setVisibility(0);
            return;
        }
        this.ijx.setVisibility(8);
        this.ijy.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View cbj() {
        return this.ijp;
    }

    public View cbk() {
        return this.ijq;
    }

    public View cbl() {
        return this.ijr;
    }

    public View cbm() {
        return this.hSn;
    }

    public View cbn() {
        return this.ijx;
    }

    public void yH(int i) {
        this.ijr.setVisibility(0);
        this.ijw.setVisibility(0);
        if (i == 0) {
            this.ijr.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ijr.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eog.setVisibility(8);
            this.ijt.setVisibility(8);
            return;
        }
        this.eog.setVisibility(0);
        this.ijt.setVisibility(0);
        this.eog.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.k(this.mView, R.color.cp_bg_line_d_alpha90);
        am.j(this.ijq, R.color.cp_link_tip_a);
        am.k(this.ijq, R.drawable.more_pop_item_bg_selector);
        am.j(this.ijp, R.color.cp_link_tip_a);
        am.k(this.ijp, R.drawable.more_pop_item_bg_selector);
        am.j(this.hSn, R.color.cp_link_tip_a);
        am.k(this.hSn, R.drawable.more_pop_item_bg_selector);
        am.j(this.ijr, R.color.cp_link_tip_a);
        am.k(this.ijr, R.drawable.more_pop_item_bg_selector);
        am.l(this.iju, R.color.cp_bg_line_b);
        am.l(this.ijv, R.color.cp_bg_line_b);
        am.l(this.ijw, R.color.cp_bg_line_b);
        am.l(this.ijt, R.color.cp_bg_line_b);
        am.l(this.ijs, R.color.cp_bg_line_b);
        am.k(this.bqD, R.drawable.person_more_pop_item_bg_selector);
        am.j(this.bqD, R.drawable.person_more_pop_cancel_text_selector);
        am.k(this.eog, R.drawable.more_pop_item_bg_selector);
        am.j(this.eog, R.color.cp_cont_d);
        am.j(this.ijx, R.color.cp_link_tip_a);
        am.k(this.ijx, R.drawable.more_pop_item_bg_selector);
        am.l(this.ijy, R.color.cp_bg_line_b);
    }
}
