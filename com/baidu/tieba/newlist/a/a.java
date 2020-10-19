package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private v hUo;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hUo = vVar;
        Le();
        this.hUo.addAdapters(this.bhH);
    }

    private void Le() {
        this.bhH = new ArrayList();
        this.bhH.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hUo != null) {
            this.hUo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hUo.setData(list);
    }
}
