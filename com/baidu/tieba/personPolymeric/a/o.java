package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private com.baidu.tieba.person.a.a kjK;
    private f kqK;
    private l kqL;
    private g kqM;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.kqK = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.ksW);
        this.kqL = new l(tbPageContext);
        this.kqM = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.ksP);
        this.kjK = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kjx);
        this.aSj.add(this.kqK);
        this.aSj.add(this.kqL);
        this.aSj.add(this.kqM);
        this.aSj.add(this.kjK);
        hTypeListView.addAdapters(this.aSj);
    }

    public void X(View.OnClickListener onClickListener) {
        this.kqK.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.kqM.setOnClickListener(onClickListener);
    }
}
