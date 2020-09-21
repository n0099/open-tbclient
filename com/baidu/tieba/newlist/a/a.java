package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private v hFt;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hFt = vVar;
        JZ();
        this.hFt.addAdapters(this.bdV);
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.bdV.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hFt != null) {
            this.hFt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hFt.setData(list);
    }
}
