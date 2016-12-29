package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    TbPageContext GO;
    TextView enO;
    TextView enP;
    TextView enQ;
    View enR;
    View mView;

    public e(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.GO = tbPageContext;
        a(this.GO, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.person_info_more_view, (ViewGroup) null);
        this.enO = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_friend);
        this.enO.setOnClickListener(onClickListener);
        this.enP = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_black);
        this.enP.setOnClickListener(onClickListener);
        this.enQ = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_mute);
        this.enR = this.mView.findViewById(r.g.person_info_more_view_item_line_mute);
        this.enQ.setOnClickListener(onClickListener);
    }

    public void B(boolean z, boolean z2) {
        if (z) {
            this.enO.setText(r.j.remove_friend);
        } else {
            this.enO.setText(r.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.enP.setText(r.j.remove_block_chat);
        } else {
            this.enP.setText(r.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aOw() {
        return this.enO;
    }

    public View aOx() {
        return this.enP;
    }

    public View aOy() {
        return this.enQ;
    }

    public void of(int i) {
        this.enQ.setVisibility(0);
        this.enR.setVisibility(0);
        if (i == 0) {
            this.enQ.setText(this.GO.getResources().getString(r.j.mute));
        } else if (i == 1) {
            this.enQ.setText(this.GO.getResources().getString(r.j.un_mute));
        }
    }
}
