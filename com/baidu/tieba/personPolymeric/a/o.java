package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private com.baidu.tieba.person.a.a mjj;
    private f mqC;
    private l mqD;
    private g mqE;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mqC = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.msN);
        this.mqD = new l(tbPageContext);
        this.mqE = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.msG);
        this.mjj = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.miU);
        this.bjZ.add(this.mqC);
        this.bjZ.add(this.mqD);
        this.bjZ.add(this.mqE);
        this.bjZ.add(this.mjj);
        hTypeListView.addAdapters(this.bjZ);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mqC.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mqE.setOnClickListener(onClickListener);
    }
}
