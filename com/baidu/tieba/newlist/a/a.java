package com.baidu.tieba.newlist.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky;
    private v imM;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.imM = vVar;
        LY();
        this.imM.addAdapters(this.bky);
    }

    private void LY() {
        this.bky = new ArrayList();
        this.bky.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.imM != null) {
            this.imM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.imM.setData(list);
    }
}
