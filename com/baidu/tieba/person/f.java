package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.base.c {
    TextView cuA;
    TextView ftZ;
    TextView iKo;
    TextView jeL;
    TextView jeM;
    TextView jeN;
    TextView jeO;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jeL = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jeL.setOnClickListener(onClickListener);
        this.iKo = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iKo.setOnClickListener(onClickListener);
        this.jeM = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jeM.setOnClickListener(onClickListener);
        this.jeN = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jeN.setOnClickListener(onClickListener);
        this.cuA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cuA.setOnClickListener(onClickListener);
        this.ftZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jeO = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jeO.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jeL.setText(R.string.remove_friend);
        } else {
            this.jeL.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jeM.setText(R.string.remove_block_chat);
        } else {
            this.jeM.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jeO.setVisibility(0);
        } else {
            this.jeO.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View ctz() {
        return this.jeL;
    }

    public View ctA() {
        return this.jeM;
    }

    public View ctB() {
        return this.jeN;
    }

    public View ctC() {
        return this.iKo;
    }

    public View ctD() {
        return this.jeO;
    }

    public void zF(int i) {
        this.jeN.setVisibility(0);
        if (i == 0) {
            this.jeN.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jeN.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ftZ.setVisibility(8);
            return;
        }
        this.ftZ.setVisibility(0);
        this.ftZ.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jeM, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jeL, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iKo, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jeN, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.ftZ, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jeO, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cuA, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
