package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a ich;
    private f iiI;
    private l iiJ;
    private g iiK;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.iiI = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.ikN);
        this.iiJ = new l(tbPageContext);
        this.iiK = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.ikG);
        this.ich = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibP);
        this.mAdapters.add(this.iiI);
        this.mAdapters.add(this.iiJ);
        this.mAdapters.add(this.iiK);
        this.mAdapters.add(this.ich);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void U(View.OnClickListener onClickListener) {
        this.iiI.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.iiK.setOnClickListener(onClickListener);
    }
}
