package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> GM;
    private TextView exi;
    private View.OnClickListener exj = new e(this);
    private View mRootView;

    public d(TbPageContext<PbActivity> tbPageContext) {
        this.GM = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.mRootView = LayoutInflater.from(this.GM.getPageActivity()).inflate(t.h.login_see_more_layout, (ViewGroup) null);
        this.exi = (TextView) this.mRootView.findViewById(t.g.login_button);
        this.exi.setOnClickListener(this.exj);
        dh(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dh(int i) {
        com.baidu.tbadk.j.a.a(this.GM, this.mRootView);
    }
}
