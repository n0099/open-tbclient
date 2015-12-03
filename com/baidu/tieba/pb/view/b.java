package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TextView cIs;
    private View.OnClickListener cIt = new c(this);
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nv() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(n.g.login_see_more_layout, (ViewGroup) null);
        this.cIs = (TextView) this.mRootView.findViewById(n.f.login_button);
        this.cIs.setOnClickListener(this.cIt);
        cV(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cV(int i) {
        com.baidu.tbadk.i.a.a(this.mPageContext, this.mRootView);
    }
}
