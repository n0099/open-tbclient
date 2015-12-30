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
    private TextView cMv;
    private View.OnClickListener cMw = new c(this);
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View mT() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(n.h.login_see_more_layout, (ViewGroup) null);
        this.cMv = (TextView) this.mRootView.findViewById(n.g.login_button);
        this.cMv.setOnClickListener(this.cMw);
        cP(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cP(int i) {
        com.baidu.tbadk.i.a.a(this.mPageContext, this.mRootView);
    }
}
