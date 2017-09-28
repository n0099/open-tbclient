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
    TextView aYX;
    TextView bRY;
    TextView eYZ;
    TextView eZa;
    TextView eZb;
    View eZc;
    View eZd;
    View eZe;
    View eZf;
    TbPageContext mG;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mG = tbPageContext;
        a(this.mG, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.person_info_more_view, (ViewGroup) null);
        this.eYZ = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_friend);
        this.eYZ.setOnClickListener(onClickListener);
        this.eZa = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_black);
        this.eZa.setOnClickListener(onClickListener);
        this.eZb = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_mute);
        this.eZc = this.mView.findViewById(d.h.person_info_more_view_item_line_mute);
        this.eZb.setOnClickListener(onClickListener);
        this.bRY = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_cancel);
        this.bRY.setOnClickListener(onClickListener);
        this.aYX = (TextView) this.mView.findViewById(d.h.person_info_more_view_item_username);
        this.eZd = this.mView.findViewById(d.h.person_info_more_view_item_line_username);
        this.eZe = this.mView.findViewById(d.h.person_info_more_view_item_line_friend);
        this.eZf = this.mView.findViewById(d.h.person_info_more_view_item_line_black);
    }

    public void J(boolean z, boolean z2) {
        if (z) {
            this.eYZ.setText(d.l.remove_friend);
        } else {
            this.eYZ.setText(d.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eZa.setText(d.l.remove_block_chat);
        } else {
            this.eZa.setText(d.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aVg() {
        return this.eYZ;
    }

    public View aVh() {
        return this.eZa;
    }

    public View aVi() {
        return this.eZb;
    }

    public void qd(int i) {
        this.eZb.setVisibility(0);
        this.eZf.setVisibility(0);
        if (i == 0) {
            this.eZb.setText(this.mG.getResources().getString(d.l.mute));
        } else if (i == 1) {
            this.eZb.setText(this.mG.getResources().getString(d.l.un_mute));
        }
    }

    public void setUserName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aYX.setVisibility(0);
            this.eZd.setVisibility(0);
            this.aYX.setText(String.format(this.mG.getResources().getString(d.l.more_info_username), str));
        }
    }

    public void onChangeSkinType() {
        aj.j(this.mView, d.e.cp_bg_line_d_alpha90);
        aj.i(this.eZa, d.e.cp_link_tip_a);
        aj.j(this.eZa, d.g.more_pop_item_bg_selector);
        aj.i(this.eYZ, d.e.cp_link_tip_a);
        aj.j(this.eYZ, d.g.more_pop_item_bg_selector);
        aj.i(this.eZb, d.e.cp_link_tip_a);
        aj.j(this.eZb, d.g.more_pop_item_bg_selector);
        aj.k(this.eZe, d.e.cp_bg_line_b);
        aj.k(this.eZf, d.e.cp_bg_line_b);
        aj.k(this.eZd, d.e.cp_bg_line_b);
        aj.k(this.eZc, d.e.cp_bg_line_b);
        aj.j(this.bRY, d.g.person_more_pop_item_bg_selector);
        aj.i(this.bRY, d.g.person_more_pop_cancel_text_selector);
        aj.j(this.aYX, d.g.more_pop_item_bg_selector);
        aj.i(this.aYX, d.e.cp_cont_d);
    }
}
