package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje;
    private v igO;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.igO = vVar;
        Ly();
        this.igO.addAdapters(this.bje);
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.bje.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.igO != null) {
            this.igO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.igO.setData(list);
    }
}
