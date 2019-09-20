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
    TextView brb;
    TextView epQ;
    TextView hUk;
    TextView ilo;
    TextView ilp;
    TextView ilq;
    View ilr;
    View ils;
    View ilt;
    View ilu;
    View ilv;
    TextView ilw;
    View ilx;
    TbPageContext mPageContext;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.ilo = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_friend);
        this.ilo.setOnClickListener(onClickListener);
        this.hUk = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_report);
        this.hUk.setOnClickListener(onClickListener);
        this.ilp = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_black);
        this.ilp.setOnClickListener(onClickListener);
        this.ilq = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_mute);
        this.ilr = this.mView.findViewById(R.id.person_info_more_view_item_line_mute);
        this.ilq.setOnClickListener(onClickListener);
        this.brb = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_cancel);
        this.brb.setOnClickListener(onClickListener);
        this.epQ = (TextView) this.mView.findViewById(R.id.person_info_more_view_item_username);
        this.ils = this.mView.findViewById(R.id.person_info_more_view_item_line_username);
        this.ilt = this.mView.findViewById(R.id.person_info_more_view_item_line_friend);
        this.ilu = this.mView.findViewById(R.id.person_info_more_view_item_line_report);
        this.ilv = this.mView.findViewById(R.id.person_info_more_view_item_line_black);
        this.ilw = (TextView) this.mView.findViewById(R.id.person_info_item_remove_fans_view);
        this.ilx = this.mView.findViewById(R.id.person_info_line_remove_fans_view);
        this.ilw.setOnClickListener(onClickListener);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.ilo.setText(R.string.remove_friend);
        } else {
            this.ilo.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ilp.setText(R.string.remove_block_chat);
        } else {
            this.ilp.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.ilw.setVisibility(0);
            this.ilx.setVisibility(0);
            return;
        }
        this.ilw.setVisibility(8);
        this.ilx.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public View cbX() {
        return this.ilo;
    }

    public View cbY() {
        return this.ilp;
    }

    public View cbZ() {
        return this.ilq;
    }

    public View cca() {
        return this.hUk;
    }

    public View ccb() {
        return this.ilw;
    }

    public void yK(int i) {
        this.ilq.setVisibility(0);
        this.ilv.setVisibility(0);
        if (i == 0) {
            this.ilq.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.ilq.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.epQ.setVisibility(8);
            this.ils.setVisibility(8);
            return;
        }
        this.epQ.setVisibility(0);
        this.ils.setVisibility(0);
        this.epQ.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        am.k(this.mView, R.color.cp_bg_line_k);
        am.j(this.ilp, R.color.cp_cont_b);
        am.j(this.ilo, R.color.cp_cont_b);
        am.j(this.hUk, R.color.cp_cont_b);
        am.j(this.ilq, R.color.cp_cont_b);
        am.j(this.brb, R.drawable.person_more_pop_cancel_text_selector);
        am.j(this.epQ, R.color.cp_cont_c);
        am.j(this.ilw, R.color.cp_cont_b);
    }
}
