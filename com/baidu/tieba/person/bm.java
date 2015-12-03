package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.base.f {
    TextView cLq;
    TextView cLr;
    TextView cLs;
    View cLt;
    BaseFragment cLu;
    View mView;

    public bm(BaseFragment baseFragment) {
        super(baseFragment.getPageContext());
        this.cLu = baseFragment;
        a(baseFragment);
    }

    private void a(BaseFragment baseFragment) {
        this.mView = LayoutInflater.from(baseFragment.getPageContext().getPageActivity()).inflate(n.g.person_info_more_view, (ViewGroup) null);
        this.cLq = (TextView) this.mView.findViewById(n.f.person_info_more_view_item_friend);
        this.cLq.setOnClickListener(baseFragment);
        this.cLr = (TextView) this.mView.findViewById(n.f.person_info_more_view_item_black);
        this.cLr.setOnClickListener(baseFragment);
        this.cLs = (TextView) this.mView.findViewById(n.f.person_info_more_view_item_mute);
        this.cLt = this.mView.findViewById(n.f.person_info_more_view_item_line_mute);
        this.cLs.setOnClickListener(baseFragment);
    }

    public void m(boolean z, boolean z2) {
        if (z) {
            this.cLq.setVisibility(0);
        } else {
            this.cLq.setVisibility(8);
        }
        if (z2) {
            this.cLr.setText(n.i.remove_block_chat);
        } else {
            this.cLr.setText(n.i.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View anO() {
        return this.cLq;
    }

    public View anP() {
        return this.cLr;
    }

    public View anQ() {
        return this.cLs;
    }

    public void kp(int i) {
        this.cLs.setVisibility(0);
        this.cLt.setVisibility(0);
        if (i == 0) {
            this.cLs.setText(this.cLu.getPageContext().getResources().getString(n.i.mute));
        } else if (i == 1) {
            this.cLs.setText(this.cLu.getPageContext().getResources().getString(n.i.un_mute));
        }
    }
}
