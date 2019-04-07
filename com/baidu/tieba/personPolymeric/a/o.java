package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a hKh;
    private f hPV;
    private l hPW;
    private g hPX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.hPV = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.hSa);
        this.hPW = new l(tbPageContext);
        this.hPX = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.hRT);
        this.hKh = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.hJP);
        this.mAdapters.add(this.hPV);
        this.mAdapters.add(this.hPW);
        this.mAdapters.add(this.hPX);
        this.mAdapters.add(this.hKh);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.hPV.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.hPX.setOnClickListener(onClickListener);
    }
}
