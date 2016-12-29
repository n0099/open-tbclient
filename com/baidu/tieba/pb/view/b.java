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
    private TextView ejZ;
    private View.OnClickListener eka = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.GO = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.mRootView = LayoutInflater.from(this.GO.getPageActivity()).inflate(r.h.login_see_more_layout, (ViewGroup) null);
        this.ejZ = (TextView) this.mRootView.findViewById(r.g.login_button);
        this.ejZ.setOnClickListener(this.eka);
        dk(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dk(int i) {
        com.baidu.tbadk.i.a.a(this.GO, this.mRootView);
    }
}
