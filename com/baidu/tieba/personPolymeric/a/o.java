package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a iiD;
    private f ipe;
    private l ipf;
    private g ipg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.ipe = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.irj);
        this.ipf = new l(tbPageContext);
        this.ipg = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.irc);
        this.iiD = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.iil);
        this.mAdapters.add(this.ipe);
        this.mAdapters.add(this.ipf);
        this.mAdapters.add(this.ipg);
        this.mAdapters.add(this.iiD);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void W(View.OnClickListener onClickListener) {
        this.ipe.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.ipg.setOnClickListener(onClickListener);
    }
}
