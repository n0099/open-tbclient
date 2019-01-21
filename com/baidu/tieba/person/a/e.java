package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView bCU;
    private c guj;
    private b guk;
    private a gul;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bCU = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.guj = new c(this.mTbPageContext, m.aCv);
        this.guk = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gut);
        this.gul = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.gtT);
        this.mAdapters.add(this.guj);
        this.mAdapters.add(this.guk);
        this.mAdapters.add(this.gul);
        this.bCU.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bCU != null) {
            this.bCU.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bCU != null && (this.bCU.getAdapter() instanceof q)) {
            ((q) this.bCU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.guj.w(onClickListener);
        this.guk.w(onClickListener);
    }
}
