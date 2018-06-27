package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a fTh;
    private f fYP;
    private l fYQ;
    private g fYR;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fYP = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gaU);
        this.fYQ = new l(tbPageContext);
        this.fYR = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gaN);
        this.fTh = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fSP);
        this.mAdapters.add(this.fYP);
        this.mAdapters.add(this.fYQ);
        this.mAdapters.add(this.fYR);
        this.mAdapters.add(this.fTh);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void S(View.OnClickListener onClickListener) {
        this.fYP.setOnClickListener(onClickListener);
    }

    public void T(View.OnClickListener onClickListener) {
        this.fYR.setOnClickListener(onClickListener);
    }
}
