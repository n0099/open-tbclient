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
    TextView cyA;
    TextView fwO;
    TextView iLZ;
    TextView jfV;
    TextView jfW;
    TextView jfX;
    TextView jfY;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jfV = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jfV.setOnClickListener(onClickListener);
        this.iLZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iLZ.setOnClickListener(onClickListener);
        this.jfW = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jfW.setOnClickListener(onClickListener);
        this.jfX = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jfX.setOnClickListener(onClickListener);
        this.cyA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cyA.setOnClickListener(onClickListener);
        this.fwO = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jfY = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jfY.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jfV.setText(R.string.remove_friend);
        } else {
            this.jfV.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jfW.setText(R.string.remove_block_chat);
        } else {
            this.jfW.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jfY.setVisibility(0);
        } else {
            this.jfY.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cuV() {
        return this.jfV;
    }

    public View cuW() {
        return this.jfW;
    }

    public View cuX() {
        return this.jfX;
    }

    public View cuY() {
        return this.iLZ;
    }

    public View cuZ() {
        return this.jfY;
    }

    public void zM(int i) {
        this.jfX.setVisibility(0);
        if (i == 0) {
            this.jfX.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jfX.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fwO.setVisibility(8);
            return;
        }
        this.fwO.setVisibility(0);
        this.fwO.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jfW, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jfV, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iLZ, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jfX, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.fwO, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jfY, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cyA, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
