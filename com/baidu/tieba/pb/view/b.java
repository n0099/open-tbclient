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
    private TbPageContext<PbActivity> GO;
    private TextView eFZ;
    private View.OnClickListener eGa = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.GO = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.mRootView = LayoutInflater.from(this.GO.getPageActivity()).inflate(r.h.login_see_more_layout, (ViewGroup) null);
        this.eFZ = (TextView) this.mRootView.findViewById(r.g.login_button);
        this.eFZ.setOnClickListener(this.eGa);
        di(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void di(int i) {
        com.baidu.tbadk.i.a.a(this.GO, this.mRootView);
    }
}
