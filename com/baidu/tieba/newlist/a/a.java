package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM;
    private s iKI;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iKI = sVar;
        MT();
        this.iKI.addAdapters(this.boM);
    }

    private void MT() {
        this.boM = new ArrayList();
        this.boM.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.iKI != null) {
            this.iKI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iKI.setData(list);
    }
}
