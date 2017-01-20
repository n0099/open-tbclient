package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> FY;
    private TextView etU;
    private View.OnClickListener etV = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.FY = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kg() {
        this.mRootView = LayoutInflater.from(this.FY.getPageActivity()).inflate(r.j.login_see_more_layout, (ViewGroup) null);
        this.etU = (TextView) this.mRootView.findViewById(r.h.login_button);
        this.etU.setOnClickListener(this.etV);
        dl(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dl(int i) {
        com.baidu.tbadk.i.a.a(this.FY, this.mRootView);
    }
}
