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
    TextView kNt;
    TextView kNu;
    TextView kNv;
    TextView kNw;
    TextView ksW;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.kNt = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.kNt.setOnClickListener(onClickListener);
        this.ksW = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.ksW.setOnClickListener(onClickListener);
        this.kNu = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.kNu.setOnClickListener(onClickListener);
        this.kNv = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.kNv.setOnClickListener(onClickListener);
        this.dtx = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dtx.setOnClickListener(onClickListener);
        this.gJq = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.kNw = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.kNw.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kNt.setText(R.string.remove_friend);
        } else {
            this.kNt.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.kNu.setText(R.string.remove_block_chat);
        } else {
            this.kNu.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.kNw.setVisibility(0);
        } else {
            this.kNw.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cVq() {
        return this.kNt;
    }

    public View cVr() {
        return this.kNu;
    }

    public View cVs() {
        return this.kNv;
    }

    public View cVt() {
        return this.ksW;
    }

    public View cVu() {
        return this.kNw;
    }

    public void CK(int i) {
        this.kNv.setVisibility(0);
        if (i == 0) {
            this.kNv.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.kNv.setText(this.mPageContext.getResources().getString(R.string.un_mute));
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
        ao.setViewTextColor(this.kNu, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.kNt, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.ksW, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.kNv, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.gJq, R.color.cp_cont_c, 1);
        ao.setViewTextColor(this.kNw, R.color.pop_window_item_txt_color_selector);
        ao.setViewTextColor(this.dtx, R.color.pop_window_cancel_txt_color_selector);
    }
}
