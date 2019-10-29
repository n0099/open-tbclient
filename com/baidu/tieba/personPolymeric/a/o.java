package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private com.baidu.tieba.person.a.a iko;
    private f iqH;
    private l iqI;
    private g iqJ;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.iqH = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.isN);
        this.iqI = new l(tbPageContext);
        this.iqJ = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.isF);
        this.iko = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijW);
        this.agQ.add(this.iqH);
        this.agQ.add(this.iqI);
        this.agQ.add(this.iqJ);
        this.agQ.add(this.iko);
        hTypeListView.addAdapters(this.agQ);
    }

    public void X(View.OnClickListener onClickListener) {
        this.iqH.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.iqJ.setOnClickListener(onClickListener);
    }
}
