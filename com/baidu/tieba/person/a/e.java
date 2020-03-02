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
    private HTypeListView jfR;
    private c jfS;
    private b jfT;
    private a jfU;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jfR = hTypeListView;
        wM();
    }

    private void wM() {
        this.jfS = new c(this.mTbPageContext, n.MO);
        this.jfT = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jgc);
        this.jfU = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfH);
        this.asE.add(this.jfS);
        this.asE.add(this.jfT);
        this.asE.add(this.jfU);
        this.jfR.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.jfR != null) {
            this.jfR.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jfR != null && (this.jfR.getAdapter() instanceof v)) {
            ((v) this.jfR.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jfS.D(onClickListener);
        this.jfT.D(onClickListener);
    }
}
