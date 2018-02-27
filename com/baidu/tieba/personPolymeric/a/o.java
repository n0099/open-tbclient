package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a ghU;
    private f gnB;
    private l gnC;
    private g gnD;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gnB = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gpN);
        this.gnC = new l(tbPageContext);
        this.gnD = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gpG);
        this.ghU = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghD);
        this.mAdapters.add(this.gnB);
        this.mAdapters.add(this.gnC);
        this.mAdapters.add(this.gnD);
        this.mAdapters.add(this.ghU);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        this.gnB.setOnClickListener(onClickListener);
    }

    public void O(View.OnClickListener onClickListener) {
        this.gnD.setOnClickListener(onClickListener);
    }
}
