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
    TextView cyy;
    TextView fwA;
    TextView iLL;
    TextView jfH;
    TextView jfI;
    TextView jfJ;
    TextView jfK;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jfH = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jfH.setOnClickListener(onClickListener);
        this.iLL = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iLL.setOnClickListener(onClickListener);
        this.jfI = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jfI.setOnClickListener(onClickListener);
        this.jfJ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jfJ.setOnClickListener(onClickListener);
        this.cyy = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cyy.setOnClickListener(onClickListener);
        this.fwA = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jfK = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jfK.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jfH.setText(R.string.remove_friend);
        } else {
            this.jfH.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jfI.setText(R.string.remove_block_chat);
        } else {
            this.jfI.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jfK.setVisibility(0);
        } else {
            this.jfK.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cuS() {
        return this.jfH;
    }

    public View cuT() {
        return this.jfI;
    }

    public View cuU() {
        return this.jfJ;
    }

    public View cuV() {
        return this.iLL;
    }

    public View cuW() {
        return this.jfK;
    }

    public void zM(int i) {
        this.jfJ.setVisibility(0);
        if (i == 0) {
            this.jfJ.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jfJ.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fwA.setVisibility(8);
            return;
        }
        this.fwA.setVisibility(0);
        this.fwA.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jfI, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jfH, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iLL, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jfJ, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.fwA, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jfK, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cyy, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
