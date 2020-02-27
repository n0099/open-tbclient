package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private HTypeListView jfP;
    private c jfQ;
    private b jfR;
    private a jfS;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jfP = hTypeListView;
        wM();
    }

    private void wM() {
        this.jfQ = new c(this.mTbPageContext, n.MO);
        this.jfR = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jga);
        this.jfS = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfF);
        this.asE.add(this.jfQ);
        this.asE.add(this.jfR);
        this.asE.add(this.jfS);
        this.jfP.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.jfP != null) {
            this.jfP.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jfP != null && (this.jfP.getAdapter() instanceof v)) {
            ((v) this.jfP.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jfQ.D(onClickListener);
        this.jfR.D(onClickListener);
    }
}
