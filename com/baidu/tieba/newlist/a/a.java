package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private s iLK;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLK = sVar;
        Kw();
        this.iLK.addAdapters(this.bns);
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.bns.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.iLK != null) {
            this.iLK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iLK.setData(list);
    }
}
