package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.f {
    TextView dwW;
    TextView dwX;
    TextView dwY;
    View dwZ;
    BaseFragment dxa;
    View mView;

    public bo(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.dxa = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(t.h.person_info_more_view, (ViewGroup) null);
        this.dwW = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_friend);
        this.dwW.setOnClickListener(baseFragment);
        this.dwX = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_black);
        this.dwX.setOnClickListener(baseFragment);
        this.dwY = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_mute);
        this.dwZ = this.mView.findViewById(t.g.person_info_more_view_item_line_mute);
        this.dwY.setOnClickListener(baseFragment);
    }

    public void s(boolean z, boolean z2) {
        if (z) {
            this.dwW.setVisibility(0);
        } else {
            this.dwW.setVisibility(8);
        }
        if (z2) {
            this.dwX.setText(t.j.remove_block_chat);
        } else {
            this.dwX.setText(t.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aBS() {
        return this.dwW;
    }

    public View aBT() {
        return this.dwX;
    }

    public View aBU() {
        return this.dwY;
    }

    public void ms(int i) {
        this.dwY.setVisibility(0);
        this.dwZ.setVisibility(0);
        if (i == 0) {
            this.dwY.setText(this.dxa.getPageContext().getResources().getString(t.j.mute));
        } else if (i == 1) {
            this.dwY.setText(this.dxa.getPageContext().getResources().getString(t.j.un_mute));
        }
    }
}
