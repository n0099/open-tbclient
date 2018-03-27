package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gil;
    private f gnR;
    private l gnS;
    private g gnT;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gnR = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gqd);
        this.gnS = new l(tbPageContext);
        this.gnT = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gpW);
        this.gil = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghT);
        this.mAdapters.add(this.gnR);
        this.mAdapters.add(this.gnS);
        this.mAdapters.add(this.gnT);
        this.mAdapters.add(this.gil);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        this.gnR.setOnClickListener(onClickListener);
    }

    public void O(View.OnClickListener onClickListener) {
        this.gnT.setOnClickListener(onClickListener);
    }
}
