package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf;
    private v hlu;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hlu = vVar;
        DS();
        this.hlu.addAdapters(this.aWf);
    }

    private void DS() {
        this.aWf = new ArrayList();
        this.aWf.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hlu != null) {
            this.hlu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hlu.setData(list);
    }
}
