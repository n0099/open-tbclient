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
    private TbPageContext<PbActivity> Nw;
    private TextView cVj;
    private View.OnClickListener cVk = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.Nw = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ni() {
        this.mRootView = LayoutInflater.from(this.Nw.getPageActivity()).inflate(t.h.login_see_more_layout, (ViewGroup) null);
        this.cVj = (TextView) this.mRootView.findViewById(t.g.login_button);
        this.cVj.setOnClickListener(this.cVk);
        dg(TbadkCoreApplication.m411getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dg(int i) {
        com.baidu.tbadk.i.a.a(this.Nw, this.mRootView);
    }
}
