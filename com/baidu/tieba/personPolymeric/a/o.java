package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private com.baidu.tieba.person.a.a lmu;
    private f ltO;
    private l ltP;
    private g ltQ;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.ltO = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.lvX);
        this.ltP = new l(tbPageContext);
        this.ltQ = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.lvQ);
        this.lmu = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lmh);
        this.bdV.add(this.ltO);
        this.bdV.add(this.ltP);
        this.bdV.add(this.ltQ);
        this.bdV.add(this.lmu);
        hTypeListView.addAdapters(this.bdV);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.ltO.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.ltQ.setOnClickListener(onClickListener);
    }
}
