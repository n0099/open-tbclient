package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private HTypeListView bah;
    private c eZk;
    private b eZl;
    private a eZm;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bah = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.eZk = new c(this.mTbPageContext, j.azD);
        this.eZl = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.eZs);
        this.eZm = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYX);
        this.mAdapters.add(this.eZk);
        this.mAdapters.add(this.eZl);
        this.mAdapters.add(this.eZm);
        this.bah.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
        if (this.bah != null) {
            this.bah.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bah != null && (this.bah.getAdapter() instanceof com.baidu.adp.widget.ListView.j)) {
            ((com.baidu.adp.widget.ListView.j) this.bah.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eZk.p(onClickListener);
        this.eZl.p(onClickListener);
    }
}
