package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c {
    TextView bJM;
    TextView eAg;
    TextView hSS;
    TextView ijY;
    TextView ijZ;
    TextView ika;
    View ikb;
    View ikc;
    View ikd;
    View ike;
    View ikf;
    TextView ikg;
    View ikh;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ijY = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ijY.setOnClickListener(onClickListener);
        this.hSS = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hSS.setOnClickListener(onClickListener);
        this.ijZ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ijZ.setOnClickListener(onClickListener);
        this.ika = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ikb = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.ika.setOnClickListener(onClickListener);
        this.bJM = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.bJM.setOnClickListener(onClickListener);
        this.eAg = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ikc = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.ikd = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.ike = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.ikf = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.ikg = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ikh = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.ikg.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ijY.setText(R.string.remove_friend);
        } else {
            this.ijY.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ijZ.setText(R.string.remove_block_chat);
        } else {
            this.ijZ.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ikg.setVisibility(0);
            this.ikh.setVisibility(0);
            return;
        }
        this.ikg.setVisibility(8);
        this.ikh.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bYZ() {
        return this.ijY;
    }

    public View bZa() {
        return this.ijZ;
    }

    public View bZb() {
        return this.ika;
    }

    public View bZc() {
        return this.hSS;
    }

    public View bZd() {
        return this.ikg;
    }

    public void xp(int i) {
        this.ika.setVisibility(0);
        this.ikf.setVisibility(0);
        if (i == 0) {
            this.ika.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ika.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eAg.setVisibility(8);
            this.ikc.setVisibility(8);
            return;
        }
        this.eAg.setVisibility(0);
        this.ikc.setVisibility(0);
        this.eAg.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.ijZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ijY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hSS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ika, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bJM, (int) R.drawable.person_more_pop_cancel_text_selector);
        am.setViewTextColor(this.eAg, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.ikg, (int) R.color.cp_cont_b);
    }
}
