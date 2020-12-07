package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private com.baidu.tieba.person.a.a miE;
    private f mpT;
    private l mpU;
    private g mpV;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mpT = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.msc);
        this.mpU = new l(tbPageContext);
        this.mpV = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mrV);
        this.miE = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mip);
        this.bnf.add(this.mpT);
        this.bnf.add(this.mpU);
        this.bnf.add(this.mpV);
        this.bnf.add(this.miE);
        hTypeListView.addAdapters(this.bnf);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mpT.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mpV.setOnClickListener(onClickListener);
    }
}
