package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private s iGb;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iGb = sVar;
        IY();
        this.iGb.addAdapters(this.bjZ);
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.bjZ.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.iGb != null) {
            this.iGb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iGb.setData(list);
    }
}
