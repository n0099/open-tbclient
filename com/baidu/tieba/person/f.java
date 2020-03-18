package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.base.c {
    TextView cyL;
    TextView fxu;
    TextView iNA;
    TextView jhu;
    TextView jhv;
    TextView jhw;
    TextView jhx;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jhu = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jhu.setOnClickListener(onClickListener);
        this.iNA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iNA.setOnClickListener(onClickListener);
        this.jhv = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jhv.setOnClickListener(onClickListener);
        this.jhw = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jhw.setOnClickListener(onClickListener);
        this.cyL = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cyL.setOnClickListener(onClickListener);
        this.fxu = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jhx = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jhx.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jhu.setText(R.string.remove_friend);
        } else {
            this.jhu.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jhv.setText(R.string.remove_block_chat);
        } else {
            this.jhv.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jhx.setVisibility(0);
        } else {
            this.jhx.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cvo() {
        return this.jhu;
    }

    public View cvp() {
        return this.jhv;
    }

    public View cvq() {
        return this.jhw;
    }

    public View cvr() {
        return this.iNA;
    }

    public View cvs() {
        return this.jhx;
    }

    public void zU(int i) {
        this.jhw.setVisibility(0);
        if (i == 0) {
            this.jhw.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jhw.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fxu.setVisibility(8);
            return;
        }
        this.fxu.setVisibility(0);
        this.fxu.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jhv, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jhu, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iNA, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jhw, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.fxu, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jhx, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cyL, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
