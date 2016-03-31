package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> ND;
    private TextView dqe;
    private View.OnClickListener dqf = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.ND = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View mZ() {
        this.mRootView = LayoutInflater.from(this.ND.getPageActivity()).inflate(t.h.login_see_more_layout, (ViewGroup) null);
        this.dqe = (TextView) this.mRootView.findViewById(t.g.login_button);
        this.dqe.setOnClickListener(this.dqf);
        dj(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dj(int i) {
        com.baidu.tbadk.i.a.a(this.ND, this.mRootView);
    }
}
