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
    TextView efP;
    TextView hGx;
    TextView lTU;
    TextView lTV;
    TextView lTW;
    TextView lTX;
    TextView lyX;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.lTU = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.lTU.setOnClickListener(onClickListener);
        this.lyX = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.lyX.setOnClickListener(onClickListener);
        this.lTV = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.lTV.setOnClickListener(onClickListener);
        this.lTW = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.lTW.setOnClickListener(onClickListener);
        this.efP = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.efP.setOnClickListener(onClickListener);
        this.hGx = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.lTX = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.lTX.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lTU.setText(R.string.remove_friend);
        } else {
            this.lTU.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.lTV.setText(R.string.remove_block_chat);
        } else {
            this.lTV.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.lTX.setVisibility(0);
        } else {
            this.lTX.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View dtk() {
        return this.lTU;
    }

    public View dtl() {
        return this.lTV;
    }

    public View dtm() {
        return this.lTW;
    }

    public View dtn() {
        return this.lyX;
    }

    public View dto() {
        return this.lTX;
    }

    public void GR(int i) {
        this.lTW.setVisibility(0);
        if (i == 0) {
            this.lTW.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.lTW.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hGx.setVisibility(8);
            return;
        }
        this.hGx.setVisibility(0);
        this.hGx.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.lTV, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lTU, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lyX, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lTW, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.hGx, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lTX, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.efP, R.color.pop_window_cancel_txt_color_selector);
    }
}
