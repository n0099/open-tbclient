package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private com.baidu.tieba.person.a.a jRN;
    private f jYN;
    private l jYO;
    private g jYP;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jYN = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.kba);
        this.jYO = new l(tbPageContext);
        this.jYP = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.kaT);
        this.jRN = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jRA);
        this.aMd.add(this.jYN);
        this.aMd.add(this.jYO);
        this.aMd.add(this.jYP);
        this.aMd.add(this.jRN);
        hTypeListView.addAdapters(this.aMd);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jYN.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jYP.setOnClickListener(onClickListener);
    }
}
