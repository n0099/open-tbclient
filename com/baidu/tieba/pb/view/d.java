package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> Ea;
    private TextView dYB;
    private View.OnClickListener dYC = new e(this);
    private View mRootView;

    public d(TbPageContext<PbActivity> tbPageContext) {
        this.Ea = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jq() {
        this.mRootView = LayoutInflater.from(this.Ea.getPageActivity()).inflate(u.h.login_see_more_layout, (ViewGroup) null);
        this.dYB = (TextView) this.mRootView.findViewById(u.g.login_button);
        this.dYB.setOnClickListener(this.dYC);
        cT(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cT(int i) {
        com.baidu.tbadk.j.a.a(this.Ea, this.mRootView);
    }
}
