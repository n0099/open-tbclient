package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    TbPageContext ajF;
    TextView eBi;
    TextView eBj;
    TextView eBk;
    View eBl;
    View mView;

    public e(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ajF = tbPageContext;
        a(this.ajF, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.person_info_more_view, (ViewGroup) null);
        this.eBi = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_friend);
        this.eBi.setOnClickListener(onClickListener);
        this.eBj = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_black);
        this.eBj.setOnClickListener(onClickListener);
        this.eBk = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_mute);
        this.eBl = this.mView.findViewById(w.h.person_info_more_view_item_line_mute);
        this.eBk.setOnClickListener(onClickListener);
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.eBi.setText(w.l.remove_friend);
        } else {
            this.eBi.setText(w.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eBj.setText(w.l.remove_block_chat);
        } else {
            this.eBj.setText(w.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aPZ() {
        return this.eBi;
    }

    public View aQa() {
        return this.eBj;
    }

    public View aQb() {
        return this.eBk;
    }

    public void oT(int i) {
        this.eBk.setVisibility(0);
        this.eBl.setVisibility(0);
        if (i == 0) {
            this.eBk.setText(this.ajF.getResources().getString(w.l.mute));
        } else if (i == 1) {
            this.eBk.setText(this.ajF.getResources().getString(w.l.un_mute));
        }
    }
}
