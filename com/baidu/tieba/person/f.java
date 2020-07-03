package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.base.c {
    TextView dnB;
    TextView gDT;
    TextView kEr;
    TextView kEs;
    TextView kEt;
    TextView kEu;
    TextView kjX;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.kEr = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.kEr.setOnClickListener(onClickListener);
        this.kjX = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.kjX.setOnClickListener(onClickListener);
        this.kEs = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.kEs.setOnClickListener(onClickListener);
        this.kEt = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.kEt.setOnClickListener(onClickListener);
        this.dnB = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dnB.setOnClickListener(onClickListener);
        this.gDT = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.kEu = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.kEu.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kEr.setText(R.string.remove_friend);
        } else {
            this.kEr.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.kEs.setText(R.string.remove_block_chat);
        } else {
            this.kEs.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.kEu.setVisibility(0);
        } else {
            this.kEu.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cRz() {
        return this.kEr;
    }

    public View cRA() {
        return this.kEs;
    }

    public View cRB() {
        return this.kEt;
    }

    public View cRC() {
        return this.kjX;
    }

    public View cRD() {
        return this.kEu;
    }

    public void Ck(int i) {
        this.kEt.setVisibility(0);
        if (i == 0) {
            this.kEt.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.kEt.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gDT.setVisibility(8);
            return;
        }
        this.gDT.setVisibility(0);
        this.gDT.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        an.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        an.setViewTextColor(this.kEs, (int) R.color.pop_window_item_txt_color_selector);
        an.setViewTextColor(this.kEr, (int) R.color.pop_window_item_txt_color_selector);
        an.setViewTextColor(this.kjX, (int) R.color.pop_window_item_txt_color_selector);
        an.setViewTextColor(this.kEt, (int) R.color.pop_window_item_txt_color_selector);
        an.setViewTextColor(this.gDT, R.color.cp_cont_c, 1);
        an.setViewTextColor(this.kEu, (int) R.color.pop_window_item_txt_color_selector);
        an.setViewTextColor(this.dnB, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
