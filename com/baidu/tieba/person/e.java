package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    TbPageContext ajT;
    TextView ezo;
    TextView ezp;
    TextView ezq;
    View ezr;
    View mView;

    public e(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ajT = tbPageContext;
        a(this.ajT, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.person_info_more_view, (ViewGroup) null);
        this.ezo = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_friend);
        this.ezo.setOnClickListener(onClickListener);
        this.ezp = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_black);
        this.ezp.setOnClickListener(onClickListener);
        this.ezq = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_mute);
        this.ezr = this.mView.findViewById(w.h.person_info_more_view_item_line_mute);
        this.ezq.setOnClickListener(onClickListener);
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.ezo.setText(w.l.remove_friend);
        } else {
            this.ezo.setText(w.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.ezp.setText(w.l.remove_block_chat);
        } else {
            this.ezp.setText(w.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aQi() {
        return this.ezo;
    }

    public View aQj() {
        return this.ezp;
    }

    public View aQk() {
        return this.ezq;
    }

    public void oR(int i) {
        this.ezq.setVisibility(0);
        this.ezr.setVisibility(0);
        if (i == 0) {
            this.ezq.setText(this.ajT.getResources().getString(w.l.mute));
        } else if (i == 1) {
            this.ezq.setText(this.ajT.getResources().getString(w.l.un_mute));
        }
    }
}
