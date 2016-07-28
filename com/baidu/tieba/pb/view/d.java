package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> EA;
    private TextView eld;
    private View.OnClickListener ele = new e(this);
    private View mRootView;

    public d(TbPageContext<PbActivity> tbPageContext) {
        this.EA = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jp() {
        this.mRootView = LayoutInflater.from(this.EA.getPageActivity()).inflate(u.h.login_see_more_layout, (ViewGroup) null);
        this.eld = (TextView) this.mRootView.findViewById(u.g.login_button);
        this.eld.setOnClickListener(this.ele);
        cT(TbadkCoreApplication.m10getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cT(int i) {
        com.baidu.tbadk.j.a.a(this.EA, this.mRootView);
    }
}
