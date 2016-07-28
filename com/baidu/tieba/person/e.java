package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    TextView epq;
    TextView epr;
    TextView eps;
    View ept;
    BaseFragment epu;
    View mView;

    public e(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.epu = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(u.h.person_info_more_view, (ViewGroup) null);
        this.epq = (TextView) this.mView.findViewById(u.g.person_info_more_view_item_friend);
        this.epq.setOnClickListener(baseFragment);
        this.epr = (TextView) this.mView.findViewById(u.g.person_info_more_view_item_black);
        this.epr.setOnClickListener(baseFragment);
        this.eps = (TextView) this.mView.findViewById(u.g.person_info_more_view_item_mute);
        this.ept = this.mView.findViewById(u.g.person_info_more_view_item_line_mute);
        this.eps.setOnClickListener(baseFragment);
    }

    public void t(boolean z, boolean z2) {
        if (z) {
            this.epq.setVisibility(0);
        } else {
            this.epq.setVisibility(8);
        }
        if (z2) {
            this.epr.setText(u.j.remove_block_chat);
        } else {
            this.epr.setText(u.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aNq() {
        return this.epq;
    }

    public View aNr() {
        return this.epr;
    }

    public View aNs() {
        return this.eps;
    }

    public void od(int i) {
        this.eps.setVisibility(0);
        this.ept.setVisibility(0);
        if (i == 0) {
            this.eps.setText(this.epu.getPageContext().getResources().getString(u.j.mute));
        } else if (i == 1) {
            this.eps.setText(this.epu.getPageContext().getResources().getString(u.j.un_mute));
        }
    }
}
