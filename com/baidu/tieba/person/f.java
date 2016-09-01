package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    TbPageContext GM;
    TextView eBv;
    TextView eBw;
    TextView eBx;
    View eBy;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.GM = tbPageContext;
        a(this.GM, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.person_info_more_view, (ViewGroup) null);
        this.eBv = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_friend);
        this.eBv.setOnClickListener(onClickListener);
        this.eBw = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_black);
        this.eBw.setOnClickListener(onClickListener);
        this.eBx = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_mute);
        this.eBy = this.mView.findViewById(t.g.person_info_more_view_item_line_mute);
        this.eBx.setOnClickListener(onClickListener);
    }

    public void w(boolean z, boolean z2) {
        if (z) {
            this.eBv.setText(t.j.remove_friend);
        } else {
            this.eBv.setText(t.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eBw.setText(t.j.remove_block_chat);
        } else {
            this.eBw.setText(t.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aSc() {
        return this.eBv;
    }

    public View aSd() {
        return this.eBw;
    }

    public View aSe() {
        return this.eBx;
    }

    public void oG(int i) {
        this.eBx.setVisibility(0);
        this.eBy.setVisibility(0);
        if (i == 0) {
            this.eBx.setText(this.GM.getResources().getString(t.j.mute));
        } else if (i == 1) {
            this.eBx.setText(this.GM.getResources().getString(t.j.un_mute));
        }
    }
}
