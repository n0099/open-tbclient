package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.personCenter.a.b eQz;
    private h eUN;
    private q eUO;
    private i eUP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eUN = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.n.eWP);
        this.eUO = new q(tbPageContext);
        this.eUP = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.h.eWH);
        this.eQz = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.eQg);
        this.mAdapters.add(this.eUN);
        this.mAdapters.add(this.eUO);
        this.mAdapters.add(this.eUP);
        this.mAdapters.add(this.eQz);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.eUN.setOnClickListener(onClickListener);
    }

    public void R(View.OnClickListener onClickListener) {
        this.eUP.setOnClickListener(onClickListener);
    }
}
