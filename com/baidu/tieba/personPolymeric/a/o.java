package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a icl;
    private f iiM;
    private l iiN;
    private g iiO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.iiM = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.ikR);
        this.iiN = new l(tbPageContext);
        this.iiO = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.ikK);
        this.icl = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibT);
        this.mAdapters.add(this.iiM);
        this.mAdapters.add(this.iiN);
        this.mAdapters.add(this.iiO);
        this.mAdapters.add(this.icl);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void U(View.OnClickListener onClickListener) {
        this.iiM.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.iiO.setOnClickListener(onClickListener);
    }
}
