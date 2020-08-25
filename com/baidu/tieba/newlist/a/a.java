package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu;
    private v hyl;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyl = vVar;
        Jv();
        this.hyl.addAdapters(this.bbu);
    }

    private void Jv() {
        this.bbu = new ArrayList();
        this.bbu.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hyl != null) {
            this.hyl.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyl.setData(list);
    }
}
