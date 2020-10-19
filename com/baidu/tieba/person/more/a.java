package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeListView fSo;
    private d lCw;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.fSo = bdTypeListView;
        this.lCw = new d(tbPageContext, h.lDE);
        this.lCw.c(aaVar);
        this.bhH.add(this.lCw);
        this.fSo.addAdapters(this.bhH);
    }

    public void notifyDataSetChanged() {
        this.lCw.notifyDataSetChanged();
    }
}
