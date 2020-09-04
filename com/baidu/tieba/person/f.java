package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends com.baidu.adp.base.c {
    TextView dDA;
    TextView gVX;
    TextView kIK;
    TextView lds;
    TextView ldt;
    TextView ldu;
    TextView ldv;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.lds = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.lds.setOnClickListener(onClickListener);
        this.kIK = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.kIK.setOnClickListener(onClickListener);
        this.ldt = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ldt.setOnClickListener(onClickListener);
        this.ldu = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ldu.setOnClickListener(onClickListener);
        this.dDA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dDA.setOnClickListener(onClickListener);
        this.gVX = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ldv = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ldv.setOnClickListener(onClickListener);
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lds.setText(R.string.remove_friend);
        } else {
            this.lds.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ldt.setText(R.string.remove_block_chat);
        } else {
            this.ldt.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ldv.setVisibility(0);
        } else {
            this.ldv.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View dgo() {
        return this.lds;
    }

    public View dgp() {
        return this.ldt;
    }

    public View dgq() {
        return this.ldu;
    }

    public View dgr() {
        return this.kIK;
    }

    public View dgs() {
        return this.ldv;
    }

    public void Fe(int i) {
        this.ldu.setVisibility(0);
        if (i == 0) {
            this.ldu.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ldu.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gVX.setVisibility(8);
            return;
        }
        this.gVX.setVisibility(0);
        this.gVX.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.ldt, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lds, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.kIK, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.ldu, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.gVX, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.ldv, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.dDA, R.color.pop_window_cancel_txt_color_selector);
    }
}
