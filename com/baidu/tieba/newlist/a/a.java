package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN;
    private v inB;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.inB = vVar;
        Lp();
        this.inB.addAdapters(this.biN);
    }

    private void Lp() {
        this.biN = new ArrayList();
        this.biN.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.inB != null) {
            this.inB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.inB.setData(list);
    }
}
