package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.tieba.person.a.a jfU;
    private f jmO;
    private l jmP;
    private g jmQ;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jmO = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.jpa);
        this.jmP = new l(tbPageContext);
        this.jmQ = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.joT);
        this.jfU = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfH);
        this.asE.add(this.jmO);
        this.asE.add(this.jmP);
        this.asE.add(this.jmQ);
        this.asE.add(this.jfU);
        hTypeListView.addAdapters(this.asE);
    }

    public void W(View.OnClickListener onClickListener) {
        this.jmO.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jmQ.setOnClickListener(onClickListener);
    }
}
