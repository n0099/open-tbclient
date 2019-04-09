package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a hKi;
    private f hPW;
    private l hPX;
    private g hPY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.hPW = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.hSb);
        this.hPX = new l(tbPageContext);
        this.hPY = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.hRU);
        this.hKi = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.hJQ);
        this.mAdapters.add(this.hPW);
        this.mAdapters.add(this.hPX);
        this.mAdapters.add(this.hPY);
        this.mAdapters.add(this.hKi);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.hPW.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.hPY.setOnClickListener(onClickListener);
    }
}
