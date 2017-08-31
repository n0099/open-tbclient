package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.personCenter.a.b few;
    private f fiO;
    private l fiP;
    private g fiQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fiO = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.n.fkT);
        this.fiP = new l(tbPageContext);
        this.fiQ = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fkL);
        this.few = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.fef);
        this.mAdapters.add(this.fiO);
        this.mAdapters.add(this.fiP);
        this.mAdapters.add(this.fiQ);
        this.mAdapters.add(this.few);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fiO.setOnClickListener(onClickListener);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fiQ.setOnClickListener(onClickListener);
    }
}
