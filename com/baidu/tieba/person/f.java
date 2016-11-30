package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    TbPageContext GO;
    TextView eJX;
    TextView eJY;
    TextView eJZ;
    View eKa;
    View mView;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.GO = tbPageContext;
        a(this.GO, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.person_info_more_view, (ViewGroup) null);
        this.eJX = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_friend);
        this.eJX.setOnClickListener(onClickListener);
        this.eJY = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_black);
        this.eJY.setOnClickListener(onClickListener);
        this.eJZ = (TextView) this.mView.findViewById(r.g.person_info_more_view_item_mute);
        this.eKa = this.mView.findViewById(r.g.person_info_more_view_item_line_mute);
        this.eJZ.setOnClickListener(onClickListener);
    }

    public void A(boolean z, boolean z2) {
        if (z) {
            this.eJX.setText(r.j.remove_friend);
        } else {
            this.eJX.setText(r.j.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.eJY.setText(r.j.remove_block_chat);
        } else {
            this.eJY.setText(r.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aUH() {
        return this.eJX;
    }

    public View aUI() {
        return this.eJY;
    }

    public View aUJ() {
        return this.eJZ;
    }

    public void pd(int i) {
        this.eJZ.setVisibility(0);
        this.eKa.setVisibility(0);
        if (i == 0) {
            this.eJZ.setText(this.GO.getResources().getString(r.j.mute));
        } else if (i == 1) {
            this.eJZ.setText(this.GO.getResources().getString(r.j.un_mute));
        }
    }
}
