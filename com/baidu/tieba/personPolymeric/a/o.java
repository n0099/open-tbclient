package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private com.baidu.tieba.person.a.a ijx;
    private f ipQ;
    private l ipR;
    private g ipS;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.ipQ = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.irW);
        this.ipR = new l(tbPageContext);
        this.ipS = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.irO);
        this.ijx = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijf);
        this.agy.add(this.ipQ);
        this.agy.add(this.ipR);
        this.agy.add(this.ipS);
        this.agy.add(this.ijx);
        hTypeListView.addAdapters(this.agy);
    }

    public void X(View.OnClickListener onClickListener) {
        this.ipQ.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.ipS.setOnClickListener(onClickListener);
    }
}
