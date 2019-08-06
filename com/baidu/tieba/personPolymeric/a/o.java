package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a ijF;
    private f iqi;
    private l iqj;
    private g iqk;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.iqi = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.isn);
        this.iqj = new l(tbPageContext);
        this.iqk = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.isg);
        this.ijF = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijn);
        this.mAdapters.add(this.iqi);
        this.mAdapters.add(this.iqj);
        this.mAdapters.add(this.iqk);
        this.mAdapters.add(this.ijF);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void W(View.OnClickListener onClickListener) {
        this.iqi.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.iqk.setOnClickListener(onClickListener);
    }
}
