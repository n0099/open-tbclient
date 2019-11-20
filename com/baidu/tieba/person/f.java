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
    TextView bIV;
    TextView ezp;
    TextView hSb;
    TextView ijh;
    TextView iji;
    TextView ijj;
    View ijk;
    View ijl;
    View ijm;
    View ijn;
    View ijo;
    TextView ijp;
    View ijq;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ijh = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ijh.setOnClickListener(onClickListener);
        this.hSb = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hSb.setOnClickListener(onClickListener);
        this.iji = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.iji.setOnClickListener(onClickListener);
        this.ijj = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ijk = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.ijj.setOnClickListener(onClickListener);
        this.bIV = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.bIV.setOnClickListener(onClickListener);
        this.ezp = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ijl = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.ijm = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.ijn = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.ijo = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.ijp = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ijq = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.ijp.setOnClickListener(onClickListener);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ijh.setText(R.string.remove_friend);
        } else {
            this.ijh.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.iji.setText(R.string.remove_block_chat);
        } else {
            this.iji.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ijp.setVisibility(0);
            this.ijq.setVisibility(0);
            return;
        }
        this.ijp.setVisibility(8);
        this.ijq.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View bYX() {
        return this.ijh;
    }

    public View bYY() {
        return this.iji;
    }

    public View bYZ() {
        return this.ijj;
    }

    public View bZa() {
        return this.hSb;
    }

    public View bZb() {
        return this.ijp;
    }

    public void xo(int i) {
        this.ijj.setVisibility(0);
        this.ijo.setVisibility(0);
        if (i == 0) {
            this.ijj.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ijj.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ezp.setVisibility(8);
            this.ijl.setVisibility(8);
            return;
        }
        this.ezp.setVisibility(0);
        this.ijl.setVisibility(0);
        this.ezp.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mView, R.color.cp_bg_line_k);
        am.setViewTextColor(this.iji, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ijh, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hSb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ijj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bIV, (int) R.drawable.person_more_pop_cancel_text_selector);
        am.setViewTextColor(this.ezp, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.ijp, (int) R.color.cp_cont_b);
    }
}
