package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    TbPageContext ajr;
    TextView exG;
    TextView exH;
    TextView exI;
    View exJ;
    View mView;

    public e(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.ajr = tbPageContext;
        a(this.ajr, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.person_info_more_view, (ViewGroup) null);
        this.exG = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_friend);
        this.exG.setOnClickListener(onClickListener);
        this.exH = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_black);
        this.exH.setOnClickListener(onClickListener);
        this.exI = (TextView) this.mView.findViewById(w.h.person_info_more_view_item_mute);
        this.exJ = this.mView.findViewById(w.h.person_info_more_view_item_line_mute);
        this.exI.setOnClickListener(onClickListener);
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.exG.setText(w.l.remove_friend);
        } else {
            this.exG.setText(w.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.exH.setText(w.l.remove_block_chat);
        } else {
            this.exH.setText(w.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aOB() {
        return this.exG;
    }

    public View aOC() {
        return this.exH;
    }

    public View aOD() {
        return this.exI;
    }

    public void oO(int i) {
        this.exI.setVisibility(0);
        this.exJ.setVisibility(0);
        if (i == 0) {
            this.exI.setText(this.ajr.getResources().getString(w.l.mute));
        } else if (i == 1) {
            this.exI.setText(this.ajr.getResources().getString(w.l.un_mute));
        }
    }
}
