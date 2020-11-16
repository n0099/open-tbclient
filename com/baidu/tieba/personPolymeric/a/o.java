package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private com.baidu.tieba.person.a.a lUx;
    private f mbN;
    private l mbO;
    private g mbP;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mbN = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mdW);
        this.mbO = new l(tbPageContext);
        this.mbP = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mdP);
        this.lUx = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lUi);
        this.biN.add(this.mbN);
        this.biN.add(this.mbO);
        this.biN.add(this.mbP);
        this.biN.add(this.lUx);
        hTypeListView.addAdapters(this.biN);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mbN.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mbP.setOnClickListener(onClickListener);
    }
}
