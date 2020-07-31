package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private com.baidu.tieba.person.a.a kNE;
    private f kUN;
    private l kUO;
    private g kUP;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.kUN = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.kWW);
        this.kUO = new l(tbPageContext);
        this.kUP = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.kWP);
        this.kNE = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kNr);
        this.aWf.add(this.kUN);
        this.aWf.add(this.kUO);
        this.aWf.add(this.kUP);
        this.aWf.add(this.kNE);
        hTypeListView.addAdapters(this.aWf);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.kUN.setOnClickListener(onClickListener);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.kUP.setOnClickListener(onClickListener);
    }
}
