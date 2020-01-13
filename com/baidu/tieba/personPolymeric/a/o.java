package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private com.baidu.tieba.person.a.a jeR;
    private f jlN;
    private l jlO;
    private g jlP;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jlN = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.joa);
        this.jlO = new l(tbPageContext);
        this.jlP = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.jnS);
        this.jeR = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jeE);
        this.apl.add(this.jlN);
        this.apl.add(this.jlO);
        this.apl.add(this.jlP);
        this.apl.add(this.jeR);
        hTypeListView.addAdapters(this.apl);
    }

    public void W(View.OnClickListener onClickListener) {
        this.jlN.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jlP.setOnClickListener(onClickListener);
    }
}
