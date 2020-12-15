package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private com.baidu.tieba.person.a.a miG;
    private f mpV;
    private l mpW;
    private g mpX;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mpV = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mse);
        this.mpW = new l(tbPageContext);
        this.mpX = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mrX);
        this.miG = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mir);
        this.bnf.add(this.mpV);
        this.bnf.add(this.mpW);
        this.bnf.add(this.mpX);
        this.bnf.add(this.miG);
        hTypeListView.addAdapters(this.bnf);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mpV.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mpX.setOnClickListener(onClickListener);
    }
}
