package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.a.a fhL;
    private f fnx;
    private m fny;
    private g fnz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public p(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fnx = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.p.fpU);
        this.fny = new m(tbPageContext);
        this.fnz = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fpL);
        this.fhL = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fhv);
        this.mAdapters.add(this.fnx);
        this.mAdapters.add(this.fny);
        this.mAdapters.add(this.fnz);
        this.mAdapters.add(this.fhL);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void L(View.OnClickListener onClickListener) {
        this.fnx.setOnClickListener(onClickListener);
    }

    public void M(View.OnClickListener onClickListener) {
        this.fnz.setOnClickListener(onClickListener);
    }
}
