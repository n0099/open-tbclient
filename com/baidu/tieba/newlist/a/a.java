package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS;
    private s iNH;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iNH = sVar;
        Kz();
        this.iNH.addAdapters(this.boS);
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.boS.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.iNH != null) {
            this.iNH.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iNH.setData(list);
    }
}
