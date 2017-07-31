package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.personCenter.a.b fel;
    private f fiA;
    private l fiB;
    private g fiC;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fiA = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.n.fkD);
        this.fiB = new l(tbPageContext);
        this.fiC = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fkv);
        this.fel = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.fdT);
        this.mAdapters.add(this.fiA);
        this.mAdapters.add(this.fiB);
        this.mAdapters.add(this.fiC);
        this.mAdapters.add(this.fel);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fiA.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fiC.setOnClickListener(onClickListener);
    }
}
