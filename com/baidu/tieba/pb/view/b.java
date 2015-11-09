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
    private TextView cpg;
    private View.OnClickListener cph = new c(this);
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View np() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i.g.login_see_more_layout, (ViewGroup) null);
        this.cpg = (TextView) this.mRootView.findViewById(i.f.login_button);
        this.cpg.setOnClickListener(this.cph);
        cN(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cN(int i) {
        com.baidu.tbadk.h.a.a(this.mPageContext, this.mRootView);
    }
}
