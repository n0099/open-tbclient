package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.a.a fhp;
    private f fna;
    private m fnb;
    private g fnc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public p(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fna = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.p.fpx);
        this.fnb = new m(tbPageContext);
        this.fnc = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fpn);
        this.fhp = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fgZ);
        this.mAdapters.add(this.fna);
        this.mAdapters.add(this.fnb);
        this.mAdapters.add(this.fnc);
        this.mAdapters.add(this.fhp);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void L(View.OnClickListener onClickListener) {
        this.fna.setOnClickListener(onClickListener);
    }

    public void M(View.OnClickListener onClickListener) {
        this.fnc.setOnClickListener(onClickListener);
    }
}
