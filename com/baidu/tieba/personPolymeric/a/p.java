package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.a.a eYY;
    private f feK;
    private m feL;
    private g feM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public p(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.feK = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.p.fgY);
        this.feL = new m(tbPageContext);
        this.feM = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fgP);
        this.eYY = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYJ);
        this.mAdapters.add(this.feK);
        this.mAdapters.add(this.feL);
        this.mAdapters.add(this.feM);
        this.mAdapters.add(this.eYY);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void K(View.OnClickListener onClickListener) {
        this.feK.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.feM.setOnClickListener(onClickListener);
    }
}
