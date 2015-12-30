package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.base.f {
    TextView cPG;
    TextView cPH;
    TextView cPI;
    View cPJ;
    BaseFragment cPK;
    View mView;

    public bm(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.cPK = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(n.h.person_info_more_view, (ViewGroup) null);
        this.cPG = (TextView) this.mView.findViewById(n.g.person_info_more_view_item_friend);
        this.cPG.setOnClickListener(baseFragment);
        this.cPH = (TextView) this.mView.findViewById(n.g.person_info_more_view_item_black);
        this.cPH.setOnClickListener(baseFragment);
        this.cPI = (TextView) this.mView.findViewById(n.g.person_info_more_view_item_mute);
        this.cPJ = this.mView.findViewById(n.g.person_info_more_view_item_line_mute);
        this.cPI.setOnClickListener(baseFragment);
    }

    public void o(boolean z, boolean z2) {
        if (z) {
            this.cPG.setVisibility(0);
        } else {
            this.cPG.setVisibility(8);
        }
        if (z2) {
            this.cPH.setText(n.j.remove_block_chat);
        } else {
            this.cPH.setText(n.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aoZ() {
        return this.cPG;
    }

    public View apa() {
        return this.cPH;
    }

    public View apb() {
        return this.cPI;
    }

    public void kM(int i) {
        this.cPI.setVisibility(0);
        this.cPJ.setVisibility(0);
        if (i == 0) {
            this.cPI.setText(this.cPK.getPageContext().getResources().getString(n.j.mute));
        } else if (i == 1) {
            this.cPI.setText(this.cPK.getPageContext().getResources().getString(n.j.un_mute));
        }
    }
}
