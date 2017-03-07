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
    private TbPageContext<PbActivity> ajF;
    private TextView exq;
    private View.OnClickListener exr = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.ajF = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View la() {
        this.mRootView = LayoutInflater.from(this.ajF.getPageActivity()).inflate(w.j.login_see_more_layout, (ViewGroup) null);
        this.exq = (TextView) this.mRootView.findViewById(w.h.login_button);
        this.exq.setOnClickListener(this.exr);
        dh(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dh(int i) {
        com.baidu.tbadk.i.a.a(this.ajF, this.mRootView);
    }
}
