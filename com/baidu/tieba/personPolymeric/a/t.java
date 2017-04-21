package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.personCenter.a.b eBS;
    private h eGO;
    private q eGP;
    private i eGQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eGO = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eHZ);
        this.eGP = new q(tbPageContext);
        this.eGQ = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eHR);
        this.eBS = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDh);
        this.mAdapters.add(this.eGO);
        this.mAdapters.add(this.eGP);
        this.mAdapters.add(this.eGQ);
        this.mAdapters.add(this.eBS);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        this.eGO.setOnClickListener(onClickListener);
    }

    public void N(View.OnClickListener onClickListener) {
        this.eGQ.setOnClickListener(onClickListener);
    }
}
