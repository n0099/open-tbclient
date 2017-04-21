package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    TbPageContext ajU;
    TextView eBE;
    TextView eBF;
    TextView eBG;
    View eBH;
    View mView;

    public e(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ajU = tbPageContext;
        a(this.ajU, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.person_info_more_view, (ViewGroup) null);
        this.eBE = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_friend);
        this.eBE.setOnClickListener(onClickListener);
        this.eBF = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_black);
        this.eBF.setOnClickListener(onClickListener);
        this.eBG = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_mute);
        this.eBH = this.mView.findViewById(w.h.person_info_more_view_item_line_mute);
        this.eBG.setOnClickListener(onClickListener);
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.eBE.setText(w.l.remove_friend);
        } else {
            this.eBE.setText(w.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eBF.setText(w.l.remove_block_chat);
        } else {
            this.eBF.setText(w.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aRj() {
        return this.eBE;
    }

    public View aRk() {
        return this.eBF;
    }

    public View aRl() {
        return this.eBG;
    }

    public void oX(int i) {
        this.eBG.setVisibility(0);
        this.eBH.setVisibility(0);
        if (i == 0) {
            this.eBG.setText(this.ajU.getResources().getString(w.l.mute));
        } else if (i == 1) {
            this.eBG.setText(this.ajU.getResources().getString(w.l.un_mute));
        }
    }
}
