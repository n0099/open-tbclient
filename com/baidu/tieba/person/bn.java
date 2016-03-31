package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.base.f {
    TextView dtG;
    TextView dtH;
    TextView dtI;
    View dtJ;
    BaseFragment dtK;
    View mView;

    public bn(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.dtK = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(t.h.person_info_more_view, (ViewGroup) null);
        this.dtG = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_friend);
        this.dtG.setOnClickListener(baseFragment);
        this.dtH = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_black);
        this.dtH.setOnClickListener(baseFragment);
        this.dtI = (TextView) this.mView.findViewById(t.g.person_info_more_view_item_mute);
        this.dtJ = this.mView.findViewById(t.g.person_info_more_view_item_line_mute);
        this.dtI.setOnClickListener(baseFragment);
    }

    public void s(boolean z, boolean z2) {
        if (z) {
            this.dtG.setVisibility(0);
        } else {
            this.dtG.setVisibility(8);
        }
        if (z2) {
            this.dtH.setText(t.j.remove_block_chat);
        } else {
            this.dtH.setText(t.j.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aBy() {
        return this.dtG;
    }

    public View aBz() {
        return this.dtH;
    }

    public View aBA() {
        return this.dtI;
    }

    public void mB(int i) {
        this.dtI.setVisibility(0);
        this.dtJ.setVisibility(0);
        if (i == 0) {
            this.dtI.setText(this.dtK.getPageContext().getResources().getString(t.j.mute));
        } else if (i == 1) {
            this.dtI.setText(this.dtK.getPageContext().getResources().getString(t.j.un_mute));
        }
    }
}
