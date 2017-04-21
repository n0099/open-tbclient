package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> ajU;
    private TextView exN;
    private View.OnClickListener exO = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.ajU = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lf() {
        this.mRootView = LayoutInflater.from(this.ajU.getPageActivity()).inflate(w.j.login_see_more_layout, (ViewGroup) null);
        this.exN = (TextView) this.mRootView.findViewById(w.h.login_button);
        this.exN.setOnClickListener(this.exO);
        dk(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dk(int i) {
        com.baidu.tbadk.m.a.a(this.ajU, this.mRootView);
    }
}
