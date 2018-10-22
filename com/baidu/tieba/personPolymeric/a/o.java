package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gic;
    private f gnZ;
    private l goa;
    private g gob;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gnZ = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gqe);
        this.goa = new l(tbPageContext);
        this.gob = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gpX);
        this.gic = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghK);
        this.mAdapters.add(this.gnZ);
        this.mAdapters.add(this.goa);
        this.mAdapters.add(this.gob);
        this.mAdapters.add(this.gic);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void P(View.OnClickListener onClickListener) {
        this.gnZ.setOnClickListener(onClickListener);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.gob.setOnClickListener(onClickListener);
    }
}
