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
    TextView cXN;
    TextView gbZ;
    TextView jRG;
    TextView jRH;
    TextView jRI;
    TextView jRJ;
    TextView jxN;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jRG = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jRG.setOnClickListener(onClickListener);
        this.jxN = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.jxN.setOnClickListener(onClickListener);
        this.jRH = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jRH.setOnClickListener(onClickListener);
        this.jRI = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jRI.setOnClickListener(onClickListener);
        this.cXN = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cXN.setOnClickListener(onClickListener);
        this.gbZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jRJ = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jRJ.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jRG.setText(R.string.remove_friend);
        } else {
            this.jRG.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jRH.setText(R.string.remove_block_chat);
        } else {
            this.jRH.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jRJ.setVisibility(0);
        } else {
            this.jRJ.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cFS() {
        return this.jRG;
    }

    public View cFT() {
        return this.jRH;
    }

    public View cFU() {
        return this.jRI;
    }

    public View cFV() {
        return this.jxN;
    }

    public View cFW() {
        return this.jRJ;
    }

    public void Av(int i) {
        this.jRI.setVisibility(0);
        if (i == 0) {
            this.jRI.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jRI.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gbZ.setVisibility(8);
            return;
        }
        this.gbZ.setVisibility(0);
        this.gbZ.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jRH, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jRG, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jxN, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jRI, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.gbZ, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jRJ, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cXN, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
