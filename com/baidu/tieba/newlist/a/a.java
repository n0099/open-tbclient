package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private s iLY;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLY = sVar;
        Kw();
        this.iLY.addAdapters(this.bns);
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.bns.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.iLY != null) {
            this.iLY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iLY.setData(list);
    }
}
