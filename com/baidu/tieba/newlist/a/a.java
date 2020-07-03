package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private v hfK;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hfK = vVar;
        Dz();
        this.hfK.addAdapters(this.aUP);
    }

    private void Dz() {
        this.aUP = new ArrayList();
        this.aUP.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hfK != null) {
            this.hfK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hfK.setData(list);
    }
}
