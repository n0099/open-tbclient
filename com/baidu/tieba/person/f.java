package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends com.baidu.adp.base.c {
    TextView dtx;
    TextView gJq;
    TextView kNv;
    TextView kNw;
    TextView kNx;
    TextView kNy;
    TextView ksY;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.kNv = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.kNv.setOnClickListener(onClickListener);
        this.ksY = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.ksY.setOnClickListener(onClickListener);
        this.kNw = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.kNw.setOnClickListener(onClickListener);
        this.kNx = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.kNx.setOnClickListener(onClickListener);
        this.dtx = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dtx.setOnClickListener(onClickListener);
        this.gJq = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.kNy = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.kNy.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kNv.setText(R.string.remove_friend);
        } else {
            this.kNv.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.kNw.setText(R.string.remove_block_chat);
        } else {
            this.kNw.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.kNy.setVisibility(0);
        } else {
            this.kNy.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cVq() {
        return this.kNv;
    }

    public View cVr() {
        return this.kNw;
    }

    public View cVs() {
        return this.kNx;
    }

    public View cVt() {
        return this.ksY;
    }

    public View cVu() {
        return this.kNy;
    }

    public void CK(int i) {
        this.kNx.setVisibility(0);
        if (i == 0) {
            this.kNx.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.kNx.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gJq.setVisibility(8);
            return;
        }
        this.gJq.setVisibility(0);
        this.gJq.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ao.setViewTextColor(this.kNw, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.kNv, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.ksY, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.kNx, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.gJq, R.color.cp_cont_c, 1);
        ao.setViewTextColor(this.kNy, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.dtx, R.color.pop_window_cancel_txt_color_selector);
    }
}
