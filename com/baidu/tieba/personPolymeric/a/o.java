package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private com.baidu.tieba.person.a.a jhF;
    private l joA;
    private g joB;
    private f joz;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.joz = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.jqL);
        this.joA = new l(tbPageContext);
        this.joB = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.jqE);
        this.jhF = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jhs);
        this.asP.add(this.joz);
        this.asP.add(this.joA);
        this.asP.add(this.joB);
        this.asP.add(this.jhF);
        hTypeListView.addAdapters(this.asP);
    }

    public void W(View.OnClickListener onClickListener) {
        this.joz.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.joB.setOnClickListener(onClickListener);
    }
}
