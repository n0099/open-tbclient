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
public class d extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> GM;
    private TextView ezq;
    private View.OnClickListener ezr = new e(this);
    private View mRootView;

    public d(TbPageContext<PbActivity> tbPageContext) {
        this.GM = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.mRootView = LayoutInflater.from(this.GM.getPageActivity()).inflate(r.h.login_see_more_layout, (ViewGroup) null);
        this.ezq = (TextView) this.mRootView.findViewById(r.g.login_button);
        this.ezq.setOnClickListener(this.ezr);
        dh(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dh(int i) {
        com.baidu.tbadk.i.a.a(this.GM, this.mRootView);
    }
}
