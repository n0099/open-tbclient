package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.base.c {
    TextView cun;
    TextView fqP;
    TextView iGK;
    TextView jbd;
    TextView jbe;
    TextView jbf;
    TextView jbg;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.jbd = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.jbd.setOnClickListener(onClickListener);
        this.iGK = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.iGK.setOnClickListener(onClickListener);
        this.jbe = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.jbe.setOnClickListener(onClickListener);
        this.jbf = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.jbf.setOnClickListener(onClickListener);
        this.cun = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.cun.setOnClickListener(onClickListener);
        this.fqP = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.jbg = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.jbg.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.jbd.setText(R.string.remove_friend);
        } else {
            this.jbd.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.jbe.setText(R.string.remove_block_chat);
        } else {
            this.jbe.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.jbg.setVisibility(0);
        } else {
            this.jbg.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View csq() {
        return this.jbd;
    }

    public View csr() {
        return this.jbe;
    }

    public View css() {
        return this.jbf;
    }

    public View cst() {
        return this.iGK;
    }

    public View csu() {
        return this.jbg;
    }

    public void zA(int i) {
        this.jbf.setVisibility(0);
        if (i == 0) {
            this.jbf.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.jbf.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fqP.setVisibility(8);
            return;
        }
        this.fqP.setVisibility(0);
        this.fqP.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.jbe, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jbd, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.iGK, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.jbf, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.fqP, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jbg, (int) R.color.pop_window_item_txt_color_selector);
        am.setViewTextColor(this.cun, (int) R.color.pop_window_cancel_txt_color_selector);
    }
}
