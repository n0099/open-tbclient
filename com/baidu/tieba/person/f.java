package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    TbPageContext GM;
    TextView eDA;
    View eDB;
    TextView eDy;
    TextView eDz;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.GM = tbPageContext;
        a(this.GM, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.person_info_more_view, (ViewGroup) null);
        this.eDy = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_friend);
        this.eDy.setOnClickListener(onClickListener);
        this.eDz = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_black);
        this.eDz.setOnClickListener(onClickListener);
        this.eDA = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_mute);
        this.eDB = this.mView.findViewById(r.g.person_info_more_view_item_line_mute);
        this.eDA.setOnClickListener(onClickListener);
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.eDy.setText(r.j.remove_friend);
        } else {
            this.eDy.setText(r.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eDz.setText(r.j.remove_block_chat);
        } else {
            this.eDz.setText(r.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aSA() {
        return this.eDy;
    }

    public View aSB() {
        return this.eDz;
    }

    public View aSC() {
        return this.eDA;
    }

    public void oQ(int i) {
        this.eDA.setVisibility(0);
        this.eDB.setVisibility(0);
        if (i == 0) {
            this.eDA.setText(this.GM.getResources().getString(r.j.mute));
        } else if (i == 1) {
            this.eDA.setText(this.GM.getResources().getString(r.j.un_mute));
        }
    }
}
