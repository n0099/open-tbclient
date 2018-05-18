package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a fDL;
    private f fJs;
    private l fJt;
    private g fJu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fJs = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.fLI);
        this.fJt = new l(tbPageContext);
        this.fJu = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fLB);
        this.fDL = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fDs);
        this.mAdapters.add(this.fJs);
        this.mAdapters.add(this.fJt);
        this.mAdapters.add(this.fJu);
        this.mAdapters.add(this.fDL);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fJs.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fJu.setOnClickListener(onClickListener);
    }
}
