package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeListView gAY;
    private d mvm;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<h> abVar) {
        this.gAY = bdTypeListView;
        this.mvm = new d(tbPageContext, h.mwt);
        this.mvm.c(abVar);
        this.boS.add(this.mvm);
        this.gAY.addAdapters(this.boS);
    }

    public void notifyDataSetChanged() {
        this.mvm.notifyDataSetChanged();
    }
}
