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
    private HTypeListView bCT;
    private c gui;
    private b guj;
    private a guk;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bCT = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gui = new c(this.mTbPageContext, m.aCu);
        this.guj = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gus);
        this.guk = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.gtS);
        this.mAdapters.add(this.gui);
        this.mAdapters.add(this.guj);
        this.mAdapters.add(this.guk);
        this.bCT.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bCT != null) {
            this.bCT.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bCT != null && (this.bCT.getAdapter() instanceof q)) {
            ((q) this.bCT.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gui.w(onClickListener);
        this.guj.w(onClickListener);
    }
}
