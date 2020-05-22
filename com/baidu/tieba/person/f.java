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
    TextView diR;
    TextView gqT;
    TextView jPc;
    TextView kjA;
    TextView kjB;
    TextView kjC;
    TextView kjz;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.kjz = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.kjz.setOnClickListener(onClickListener);
        this.jPc = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.jPc.setOnClickListener(onClickListener);
        this.kjA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.kjA.setOnClickListener(onClickListener);
        this.kjB = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.kjB.setOnClickListener(onClickListener);
        this.diR = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.diR.setOnClickListener(onClickListener);
        this.gqT = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.kjC = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.kjC.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kjz.setText(R.string.remove_friend);
        } else {
            this.kjz.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.kjA.setText(R.string.remove_block_chat);
        } else {
            this.kjA.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.kjC.setVisibility(0);
        } else {
            this.kjC.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cMS() {
        return this.kjz;
    }

    public View cMT() {
        return this.kjA;
    }

    public View cMU() {
        return this.kjB;
    }

    public View cMV() {
        return this.jPc;
    }

    public View cMW() {
        return this.kjC;
    }

    public void Bg(int i) {
        this.kjB.setVisibility(0);
        if (i == 0) {
            this.kjB.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.kjB.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gqT.setVisibility(8);
            return;
        }
        this.gqT.setVisibility(0);
        this.gqT.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.kjA, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.kjz, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jPc, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.kjB, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.gqT, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.kjC, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.diR, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
