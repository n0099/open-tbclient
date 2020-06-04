package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private com.baidu.tieba.person.a.a kkQ;
    private f krQ;
    private l krR;
    private g krS;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.krQ = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.kuc);
        this.krR = new l(tbPageContext);
        this.krS = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.ktV);
        this.kkQ = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kkD);
        this.aSj.add(this.krQ);
        this.aSj.add(this.krR);
        this.aSj.add(this.krS);
        this.aSj.add(this.kkQ);
        hTypeListView.addAdapters(this.aSj);
    }

    public void X(View.OnClickListener onClickListener) {
        this.krQ.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.krS.setOnClickListener(onClickListener);
    }
}
