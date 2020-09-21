package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends com.baidu.adp.base.c {
    TextView dFB;
    TextView gZE;
    TextView kRk;
    TextView lmj;
    TextView lmk;
    TextView lml;
    TextView lmm;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.lmj = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.lmj.setOnClickListener(onClickListener);
        this.kRk = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.kRk.setOnClickListener(onClickListener);
        this.lmk = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.lmk.setOnClickListener(onClickListener);
        this.lml = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.lml.setOnClickListener(onClickListener);
        this.dFB = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dFB.setOnClickListener(onClickListener);
        this.gZE = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.lmm = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.lmm.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lmj.setText(R.string.remove_friend);
        } else {
            this.lmj.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.lmk.setText(R.string.remove_block_chat);
        } else {
            this.lmk.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.lmm.setVisibility(0);
        } else {
            this.lmm.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View djR() {
        return this.lmj;
    }

    public View djS() {
        return this.lmk;
    }

    public View djT() {
        return this.lml;
    }

    public View djU() {
        return this.kRk;
    }

    public View djV() {
        return this.lmm;
    }

    public void FF(int i) {
        this.lml.setVisibility(0);
        if (i == 0) {
            this.lml.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.lml.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gZE.setVisibility(8);
            return;
        }
        this.gZE.setVisibility(0);
        this.gZE.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.lmk, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lmj, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.kRk, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lml, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.gZE, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lmm, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.dFB, R.color.pop_window_cancel_txt_color_selector);
    }
}
