package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.base.f {
    TextView cZd;
    TextView cZe;
    TextView cZf;
    View cZg;
    BaseFragment cZh;
    View mView;

    public bn(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.cZh = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(t.h.person_info_more_view, (ViewGroup) null);
        this.cZd = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_friend);
        this.cZd.setOnClickListener(baseFragment);
        this.cZe = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_black);
        this.cZe.setOnClickListener(baseFragment);
        this.cZf = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_mute);
        this.cZg = this.mView.findViewById(t.g.person_info_more_view_item_line_mute);
        this.cZf.setOnClickListener(baseFragment);
    }

    public void q(boolean z, boolean z2) {
        if (z) {
            this.cZd.setVisibility(0);
        } else {
            this.cZd.setVisibility(8);
        }
        if (z2) {
            this.cZe.setText(t.j.remove_block_chat);
        } else {
            this.cZe.setText(t.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View atS() {
        return this.cZd;
    }

    public View atT() {
        return this.cZe;
    }

    public View atU() {
        return this.cZf;
    }

    public void ls(int i) {
        this.cZf.setVisibility(0);
        this.cZg.setVisibility(0);
        if (i == 0) {
            this.cZf.setText(this.cZh.getPageContext().getResources().getString(t.j.mute));
        } else if (i == 1) {
            this.cZf.setText(this.cZh.getPageContext().getResources().getString(t.j.un_mute));
        }
    }
}
