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
    private TbPageContext<PbActivity> ajP;
    private TextView eKR;
    private View.OnClickListener eKS = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.ajP = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lc() {
        this.mRootView = LayoutInflater.from(this.ajP.getPageActivity()).inflate(w.j.login_see_more_layout, (ViewGroup) null);
        this.eKR = (TextView) this.mRootView.findViewById(w.h.login_button);
        this.eKR.setOnClickListener(this.eKS);
        dl(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dl(int i) {
        com.baidu.tbadk.m.a.a(this.ajP, this.mRootView);
    }
}
