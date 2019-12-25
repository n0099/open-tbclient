package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private com.baidu.tieba.person.a.a jbo;
    private f jim;
    private l jin;
    private g jio;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jim = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.jky);
        this.jin = new l(tbPageContext);
        this.jio = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.jkq);
        this.jbo = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jbb);
        this.aoz.add(this.jim);
        this.aoz.add(this.jin);
        this.aoz.add(this.jio);
        this.aoz.add(this.jbo);
        hTypeListView.addAdapters(this.aoz);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jim.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jio.setOnClickListener(onClickListener);
    }
}
