package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends e {
    private TextView bQK;
    private View.OnClickListener bQL = new c(this);
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(r.login_see_more_layout, (ViewGroup) null);
        this.bQK = (TextView) this.mRootView.findViewById(q.login_button);
        this.bQK.setOnClickListener(this.bQL);
        cy(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
    }

    public void cy(int i) {
        com.baidu.tbadk.f.a.a(this.mPageContext, this.mRootView);
    }
}
