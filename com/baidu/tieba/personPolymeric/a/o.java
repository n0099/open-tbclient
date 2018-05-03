package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a fCF;
    private f fIm;
    private l fIn;
    private g fIo;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fIm = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.fKC);
        this.fIn = new l(tbPageContext);
        this.fIo = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fKv);
        this.fCF = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fCm);
        this.mAdapters.add(this.fIm);
        this.mAdapters.add(this.fIn);
        this.mAdapters.add(this.fIo);
        this.mAdapters.add(this.fCF);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fIm.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fIo.setOnClickListener(onClickListener);
    }
}
