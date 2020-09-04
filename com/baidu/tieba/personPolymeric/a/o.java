package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private com.baidu.tieba.person.a.a ldD;
    private f lkR;
    private l lkS;
    private g lkT;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.lkR = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.lna);
        this.lkS = new l(tbPageContext);
        this.lkT = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.lmT);
        this.ldD = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ldq);
        this.bbw.add(this.lkR);
        this.bbw.add(this.lkS);
        this.bbw.add(this.lkT);
        this.bbw.add(this.ldD);
        hTypeListView.addAdapters(this.bbw);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.lkR.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.lkT.setOnClickListener(onClickListener);
    }
}
