package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private h eDa;
    private q eDb;
    private i eDc;
    private com.baidu.tieba.personCenter.a.b exW;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eDa = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eEm);
        this.eDb = new q(tbPageContext);
        this.eDc = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eEd);
        this.exW = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.ezv);
        this.mAdapters.add(this.eDa);
        this.mAdapters.add(this.eDb);
        this.mAdapters.add(this.eDc);
        this.mAdapters.add(this.exW);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        this.eDa.setOnClickListener(onClickListener);
    }

    public void O(View.OnClickListener onClickListener) {
        this.eDc.setOnClickListener(onClickListener);
    }
}
