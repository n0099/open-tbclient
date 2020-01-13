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
    TextView jeG;
    TextView jeH;
    TextView jeI;
    TextView jeJ;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jeG = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jeG.setOnClickListener(onClickListener);
        this.iKo = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iKo.setOnClickListener(onClickListener);
        this.jeH = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jeH.setOnClickListener(onClickListener);
        this.jeI = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jeI.setOnClickListener(onClickListener);
        this.cuA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cuA.setOnClickListener(onClickListener);
        this.ftZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jeJ = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jeJ.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jeG.setText(R.string.remove_friend);
        } else {
            this.jeG.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jeH.setText(R.string.remove_block_chat);
        } else {
            this.jeH.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jeJ.setVisibility(0);
        } else {
            this.jeJ.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View ctx() {
        return this.jeG;
    }

    public View cty() {
        return this.jeH;
    }

    public View ctz() {
        return this.jeI;
    }

    public View ctA() {
        return this.iKo;
    }

    public View ctB() {
        return this.jeJ;
    }

    public void zF(int i) {
        this.jeI.setVisibility(0);
        if (i == 0) {
            this.jeI.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jeI.setText(this.mPageContext.getResources().getString(R.string.un_mute));
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
        am.setViewTextColor(this.jeH, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jeG, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iKo, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jeI, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.ftZ, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jeJ, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cuA, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
