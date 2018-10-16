package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gib;
    private f gnY;
    private l gnZ;
    private g goa;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gnY = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gqd);
        this.gnZ = new l(tbPageContext);
        this.goa = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gpW);
        this.gib = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghJ);
        this.mAdapters.add(this.gnY);
        this.mAdapters.add(this.gnZ);
        this.mAdapters.add(this.goa);
        this.mAdapters.add(this.gib);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void P(View.OnClickListener onClickListener) {
        this.gnY.setOnClickListener(onClickListener);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.goa.setOnClickListener(onClickListener);
    }
}
