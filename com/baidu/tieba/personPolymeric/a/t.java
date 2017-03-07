package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.personCenter.a.b eBw;
    private h eGC;
    private q eGD;
    private i eGE;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eGC = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eHO);
        this.eGD = new q(tbPageContext);
        this.eGE = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eHF);
        this.eBw = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eCU);
        this.mAdapters.add(this.eGC);
        this.mAdapters.add(this.eGD);
        this.mAdapters.add(this.eGE);
        this.mAdapters.add(this.eBw);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void L(View.OnClickListener onClickListener) {
        this.eGC.setOnClickListener(onClickListener);
    }

    public void M(View.OnClickListener onClickListener) {
        this.eGE.setOnClickListener(onClickListener);
    }
}
