package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private HTypeListView jRK;
    private c jRL;
    private b jRM;
    private a jRN;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jRK = hTypeListView;
        BC();
    }

    private void BC() {
        this.jRL = new c(this.mTbPageContext, l.afA);
        this.jRM = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jRV);
        this.jRN = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jRA);
        this.aMd.add(this.jRL);
        this.aMd.add(this.jRM);
        this.aMd.add(this.jRN);
        this.jRK.addAdapters(this.aMd);
    }

    public void setDatas(List<m> list) {
        if (this.jRK != null) {
            this.jRK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jRK != null && (this.jRK.getAdapter() instanceof y)) {
            ((y) this.jRK.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jRL.E(onClickListener);
        this.jRM.E(onClickListener);
    }
}
