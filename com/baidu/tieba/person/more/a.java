package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeListView gih;
    private d lUP;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<h> abVar) {
        this.gih = bdTypeListView;
        this.lUP = new d(tbPageContext, h.lVW);
        this.lUP.c(abVar);
        this.bky.add(this.lUP);
        this.gih.addAdapters(this.bky);
    }

    public void notifyDataSetChanged() {
        this.lUP.notifyDataSetChanged();
    }
}
