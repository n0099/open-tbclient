package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.tieba.person.a.a jfS;
    private f jmM;
    private l jmN;
    private g jmO;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jmM = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.joY);
        this.jmN = new l(tbPageContext);
        this.jmO = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.joR);
        this.jfS = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfF);
        this.asE.add(this.jmM);
        this.asE.add(this.jmN);
        this.asE.add(this.jmO);
        this.asE.add(this.jfS);
        hTypeListView.addAdapters(this.asE);
    }

    public void W(View.OnClickListener onClickListener) {
        this.jmM.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jmO.setOnClickListener(onClickListener);
    }
}
