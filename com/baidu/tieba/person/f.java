package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends com.baidu.adp.base.c {
    TextView dDw;
    TextView gVT;
    TextView kID;
    TextView ldl;
    TextView ldm;
    TextView ldn;
    TextView ldo;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ldl = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ldl.setOnClickListener(onClickListener);
        this.kID = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.kID.setOnClickListener(onClickListener);
        this.ldm = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ldm.setOnClickListener(onClickListener);
        this.ldn = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ldn.setOnClickListener(onClickListener);
        this.dDw = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dDw.setOnClickListener(onClickListener);
        this.gVT = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ldo = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ldo.setOnClickListener(onClickListener);
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ldl.setText(R.string.remove_friend);
        } else {
            this.ldl.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ldm.setText(R.string.remove_block_chat);
        } else {
            this.ldm.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ldo.setVisibility(0);
        } else {
            this.ldo.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View dgn() {
        return this.ldl;
    }

    public View dgo() {
        return this.ldm;
    }

    public View dgp() {
        return this.ldn;
    }

    public View dgq() {
        return this.kID;
    }

    public View dgr() {
        return this.ldo;
    }

    public void Fe(int i) {
        this.ldn.setVisibility(0);
        if (i == 0) {
            this.ldn.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ldn.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gVT.setVisibility(8);
            return;
        }
        this.gVT.setVisibility(0);
        this.gVT.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.ldm, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.ldl, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.kID, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.ldn, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.gVT, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.ldo, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.dDw, R.color.pop_window_cancel_txt_color_selector);
    }
}
