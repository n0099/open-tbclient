package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView bxV;
    private c gia;
    private b gib;
    private a gic;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bxV = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gia = new c(this.mTbPageContext, k.axF);
        this.gib = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gil);
        this.gic = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghK);
        this.mAdapters.add(this.gia);
        this.mAdapters.add(this.gib);
        this.mAdapters.add(this.gic);
        this.bxV.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bxV != null) {
            this.bxV.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bxV != null && (this.bxV.getAdapter() instanceof q)) {
            ((q) this.bxV.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gia.u(onClickListener);
        this.gib.u(onClickListener);
    }
}
