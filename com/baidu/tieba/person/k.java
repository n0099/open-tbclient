package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    TbPageContext ajh;
    TextView byB;
    TextView byC;
    TextView byD;
    View byE;
    View mView;

    public k(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ajh = tbPageContext;
        a(this.ajh, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.person_info_more_view, (ViewGroup) null);
        this.byB = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_friend);
        this.byB.setOnClickListener(onClickListener);
        this.byC = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_black);
        this.byC.setOnClickListener(onClickListener);
        this.byD = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_mute);
        this.byE = this.mView.findViewById(w.h.person_info_more_view_item_line_mute);
        this.byD.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2) {
        if (z) {
            this.byB.setText(w.l.remove_friend);
        } else {
            this.byB.setText(w.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.byC.setText(w.l.remove_block_chat);
        } else {
            this.byC.setText(w.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View TL() {
        return this.byB;
    }

    public View TM() {
        return this.byC;
    }

    public View TN() {
        return this.byD;
    }

    public void hg(int i) {
        this.byD.setVisibility(0);
        this.byE.setVisibility(0);
        if (i == 0) {
            this.byD.setText(this.ajh.getResources().getString(w.l.mute));
        } else if (i == 1) {
            this.byD.setText(this.ajh.getResources().getString(w.l.un_mute));
        }
    }
}
