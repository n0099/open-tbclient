package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> Mr;
    private TextView chk;
    private View.OnClickListener chl = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.Mr = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nq() {
        this.mRootView = LayoutInflater.from(this.Mr.getPageActivity()).inflate(i.g.login_see_more_layout, (ViewGroup) null);
        this.chk = (TextView) this.mRootView.findViewById(i.f.login_button);
        this.chk.setOnClickListener(this.chl);
        cG(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cG(int i) {
        com.baidu.tbadk.f.a.a(this.Mr, this.mRootView);
    }
}
