package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private com.baidu.tieba.person.a.a kNG;
    private f kUP;
    private l kUQ;
    private g kUR;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.kUP = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.kWY);
        this.kUQ = new l(tbPageContext);
        this.kUR = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.kWR);
        this.kNG = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kNt);
        this.aWf.add(this.kUP);
        this.aWf.add(this.kUQ);
        this.aWf.add(this.kUR);
        this.aWf.add(this.kNG);
        hTypeListView.addAdapters(this.aWf);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.kUP.setOnClickListener(onClickListener);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kUR.setOnClickListener(onClickListener);
    }
}
