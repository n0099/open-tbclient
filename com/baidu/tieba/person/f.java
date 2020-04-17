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
    TextView cXI;
    TextView gbU;
    TextView jRC;
    TextView jRD;
    TextView jRE;
    TextView jRF;
    TextView jxJ;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jRC = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jRC.setOnClickListener(onClickListener);
        this.jxJ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.jxJ.setOnClickListener(onClickListener);
        this.jRD = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jRD.setOnClickListener(onClickListener);
        this.jRE = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jRE.setOnClickListener(onClickListener);
        this.cXI = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cXI.setOnClickListener(onClickListener);
        this.gbU = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jRF = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jRF.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jRC.setText(R.string.remove_friend);
        } else {
            this.jRC.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jRD.setText(R.string.remove_block_chat);
        } else {
            this.jRD.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jRF.setVisibility(0);
        } else {
            this.jRF.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View cFV() {
        return this.jRC;
    }

    public View cFW() {
        return this.jRD;
    }

    public View cFX() {
        return this.jRE;
    }

    public View cFY() {
        return this.jxJ;
    }

    public View cFZ() {
        return this.jRF;
    }

    public void Av(int i) {
        this.jRE.setVisibility(0);
        if (i == 0) {
            this.jRE.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jRE.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gbU.setVisibility(8);
            return;
        }
        this.gbU.setVisibility(0);
        this.gbU.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jRD, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jRC, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jxJ, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jRE, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.gbU, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jRF, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cXI, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
