package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bp extends f {
    TextView efo;
    TextView efp;
    TextView efq;
    View efr;
    BaseFragment efs;
    View mView;

    public bp(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.efs = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(u.h.person_info_more_view, (ViewGroup) null);
        this.efo = (TextView) this.mView.findViewById(u.g.person_info_more_view_item_friend);
        this.efo.setOnClickListener(baseFragment);
        this.efp = (TextView) this.mView.findViewById(u.g.person_info_more_view_item_black);
        this.efp.setOnClickListener(baseFragment);
        this.efq = (TextView) this.mView.findViewById(u.g.person_info_more_view_item_mute);
        this.efr = this.mView.findViewById(u.g.person_info_more_view_item_line_mute);
        this.efq.setOnClickListener(baseFragment);
    }

    public void t(boolean z, boolean z2) {
        if (z) {
            this.efo.setVisibility(0);
        } else {
            this.efo.setVisibility(8);
        }
        if (z2) {
            this.efp.setText(u.j.remove_block_chat);
        } else {
            this.efp.setText(u.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aKN() {
        return this.efo;
    }

    public View aKO() {
        return this.efp;
    }

    public View aKP() {
        return this.efq;
    }

    public void nS(int i) {
        this.efq.setVisibility(0);
        this.efr.setVisibility(0);
        if (i == 0) {
            this.efq.setText(this.efs.getPageContext().getResources().getString(u.j.mute));
        } else if (i == 1) {
            this.efq.setText(this.efs.getPageContext().getResources().getString(u.j.un_mute));
        }
    }
}
