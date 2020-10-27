package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.base.c {
    TextView dZY;
    TextView hAA;
    TextView lNY;
    TextView lNZ;
    TextView lOa;
    TextView lOb;
    TextView lsZ;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.lNY = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.lNY.setOnClickListener(onClickListener);
        this.lsZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.lsZ.setOnClickListener(onClickListener);
        this.lNZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.lNZ.setOnClickListener(onClickListener);
        this.lOa = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.lOa.setOnClickListener(onClickListener);
        this.dZY = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dZY.setOnClickListener(onClickListener);
        this.hAA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.lOb = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.lOb.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lNY.setText(R.string.remove_friend);
        } else {
            this.lNY.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.lNZ.setText(R.string.remove_block_chat);
        } else {
            this.lNZ.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.lOb.setVisibility(0);
        } else {
            this.lOb.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View dqI() {
        return this.lNY;
    }

    public View dqJ() {
        return this.lNZ;
    }

    public View dqK() {
        return this.lOa;
    }

    public View dqL() {
        return this.lsZ;
    }

    public View dqM() {
        return this.lOb;
    }

    public void GE(int i) {
        this.lOa.setVisibility(0);
        if (i == 0) {
            this.lOa.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.lOa.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hAA.setVisibility(8);
            return;
        }
        this.hAA.setVisibility(0);
        this.hAA.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.lNZ, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lNY, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lsZ, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lOa, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.hAA, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lOb, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.dZY, R.color.pop_window_cancel_txt_color_selector);
    }
}
