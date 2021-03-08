package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private f mBU;
    private l mBV;
    private g mBW;
    private com.baidu.tieba.person.a.a muC;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mBU = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mEi);
        this.mBV = new l(tbPageContext);
        this.mBW = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mEb);
        this.muC = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mun);
        this.boS.add(this.mBU);
        this.boS.add(this.mBV);
        this.boS.add(this.mBW);
        this.boS.add(this.muC);
        hTypeListView.addAdapters(this.boS);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mBU.setOnClickListener(onClickListener);
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mBW.setOnClickListener(onClickListener);
    }
}
