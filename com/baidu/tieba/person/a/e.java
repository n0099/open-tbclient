package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private c kEA;
    private b kEB;
    private a kEC;
    private HTypeListView kEz;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.kEz = hTypeListView;
        Dz();
    }

    private void Dz() {
        this.kEA = new c(this.mTbPageContext, m.agK);
        this.kEB = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.kEK);
        this.kEC = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.kEp);
        this.aUP.add(this.kEA);
        this.aUP.add(this.kEB);
        this.aUP.add(this.kEC);
        this.kEz.addAdapters(this.aUP);
    }

    public void setDatas(List<q> list) {
        if (this.kEz != null) {
            this.kEz.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.kEz != null && (this.kEz.getAdapter() instanceof ad)) {
            ((ad) this.kEz.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.kEA.E(onClickListener);
        this.kEB.E(onClickListener);
    }
}
