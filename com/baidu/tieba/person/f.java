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
    TextView diR;
    TextView gre;
    TextView jQi;
    TextView kkF;
    TextView kkG;
    TextView kkH;
    TextView kkI;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.kkF = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.kkF.setOnClickListener(onClickListener);
        this.jQi = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.jQi.setOnClickListener(onClickListener);
        this.kkG = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.kkG.setOnClickListener(onClickListener);
        this.kkH = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.kkH.setOnClickListener(onClickListener);
        this.diR = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.diR.setOnClickListener(onClickListener);
        this.gre = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.kkI = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.kkI.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.kkF.setText(R.string.remove_friend);
        } else {
            this.kkF.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.kkG.setText(R.string.remove_block_chat);
        } else {
            this.kkG.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.kkI.setVisibility(0);
        } else {
            this.kkI.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cNi() {
        return this.kkF;
    }

    public View cNj() {
        return this.kkG;
    }

    public View cNk() {
        return this.kkH;
    }

    public View cNl() {
        return this.jQi;
    }

    public View cNm() {
        return this.kkI;
    }

    public void Bi(int i) {
        this.kkH.setVisibility(0);
        if (i == 0) {
            this.kkH.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.kkH.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gre.setVisibility(8);
            return;
        }
        this.gre.setVisibility(0);
        this.gre.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.kkG, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.kkF, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jQi, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.kkH, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.gre, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.kkI, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.diR, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
