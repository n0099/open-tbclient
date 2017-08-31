package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private HTypeListView aYx;
    private b feu;
    private a fev;
    private com.baidu.tieba.personCenter.a.b few;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aYx = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.feu = new b(this.mTbPageContext, k.aAm);
        this.fev = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.fey);
        this.few = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.fef);
        this.mAdapters.add(this.feu);
        this.mAdapters.add(this.fev);
        this.mAdapters.add(this.few);
        this.aYx.addAdapters(this.mAdapters);
    }

    public void setDatas(List<f> list) {
        if (this.aYx != null) {
            this.aYx.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aYx != null && (this.aYx.getAdapter() instanceof j)) {
            ((j) this.aYx.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.feu.p(onClickListener);
        this.fev.p(onClickListener);
    }
}
