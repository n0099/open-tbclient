package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbw;
    private v hyr;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyr = vVar;
        Jv();
        this.hyr.addAdapters(this.bbw);
    }

    private void Jv() {
        this.bbw = new ArrayList();
        this.bbw.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hyr != null) {
            this.hyr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyr.setData(list);
    }
}
