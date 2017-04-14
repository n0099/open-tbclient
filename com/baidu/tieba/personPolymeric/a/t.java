package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private i eEA;
    private h eEy;
    private q eEz;
    private com.baidu.tieba.personCenter.a.b ezC;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eEy = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eFJ);
        this.eEz = new q(tbPageContext);
        this.eEA = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eFB);
        this.ezC = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eAR);
        this.mAdapters.add(this.eEy);
        this.mAdapters.add(this.eEz);
        this.mAdapters.add(this.eEA);
        this.mAdapters.add(this.ezC);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        this.eEy.setOnClickListener(onClickListener);
    }

    public void N(View.OnClickListener onClickListener) {
        this.eEA.setOnClickListener(onClickListener);
    }
}
