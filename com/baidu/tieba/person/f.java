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
    TextView cyz;
    TextView fwB;
    TextView iLN;
    TextView jfJ;
    TextView jfK;
    TextView jfL;
    TextView jfM;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jfJ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jfJ.setOnClickListener(onClickListener);
        this.iLN = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iLN.setOnClickListener(onClickListener);
        this.jfK = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jfK.setOnClickListener(onClickListener);
        this.jfL = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jfL.setOnClickListener(onClickListener);
        this.cyz = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cyz.setOnClickListener(onClickListener);
        this.fwB = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jfM = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jfM.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jfJ.setText(R.string.remove_friend);
        } else {
            this.jfJ.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jfK.setText(R.string.remove_block_chat);
        } else {
            this.jfK.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jfM.setVisibility(0);
        } else {
            this.jfM.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cuU() {
        return this.jfJ;
    }

    public View cuV() {
        return this.jfK;
    }

    public View cuW() {
        return this.jfL;
    }

    public View cuX() {
        return this.iLN;
    }

    public View cuY() {
        return this.jfM;
    }

    public void zM(int i) {
        this.jfL.setVisibility(0);
        if (i == 0) {
            this.jfL.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jfL.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fwB.setVisibility(8);
            return;
        }
        this.fwB.setVisibility(0);
        this.fwB.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jfK, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jfJ, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iLN, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jfL, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.fwB, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jfM, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cyz, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
