package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private com.baidu.tieba.person.a.a ldw;
    private f lkG;
    private l lkH;
    private g lkI;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.lkG = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.lmP);
        this.lkH = new l(tbPageContext);
        this.lkI = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.lmI);
        this.ldw = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ldj);
        this.bbu.add(this.lkG);
        this.bbu.add(this.lkH);
        this.bbu.add(this.lkI);
        this.bbu.add(this.ldw);
        hTypeListView.addAdapters(this.bbu);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.lkG.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.lkI.setOnClickListener(onClickListener);
    }
}
