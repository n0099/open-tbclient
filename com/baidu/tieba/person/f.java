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
    TextView dRC;
    TextView hoF;
    TextView lBB;
    TextView lBC;
    TextView lBD;
    TextView lBE;
    TextView lgx;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.lBB = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.lBB.setOnClickListener(onClickListener);
        this.lgx = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.lgx.setOnClickListener(onClickListener);
        this.lBC = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.lBC.setOnClickListener(onClickListener);
        this.lBD = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.lBD.setOnClickListener(onClickListener);
        this.dRC = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.dRC.setOnClickListener(onClickListener);
        this.hoF = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.lBE = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.lBE.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lBB.setText(R.string.remove_friend);
        } else {
            this.lBB.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.lBC.setText(R.string.remove_block_chat);
        } else {
            this.lBC.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.lBE.setVisibility(0);
        } else {
            this.lBE.setVisibility(8);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View dnB() {
        return this.lBB;
    }

    public View dnC() {
        return this.lBC;
    }

    public View dnD() {
        return this.lBD;
    }

    public View dnE() {
        return this.lgx;
    }

    public View dnF() {
        return this.lBE;
    }

    public void Gl(int i) {
        this.lBD.setVisibility(0);
        if (i == 0) {
            this.lBD.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.lBD.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hoF.setVisibility(8);
            return;
        }
        this.hoF.setVisibility(0);
        this.hoF.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.lBC, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lBB, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lgx, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.lBD, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.hoF, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lBE, R.color.pop_window_item_txt_color_selector);
        ap.setViewTextColor(this.dRC, R.color.pop_window_cancel_txt_color_selector);
    }
}
