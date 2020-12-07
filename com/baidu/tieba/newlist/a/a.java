package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private v iyt;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyt = vVar;
        Nt();
        this.iyt.addAdapters(this.bnf);
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.bnf.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.iyt != null) {
            this.iyt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.iyt.setData(list);
    }
}
