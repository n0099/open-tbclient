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
    private HTypeListView aYL;
    private b fge;
    private a fgf;
    private com.baidu.tieba.personCenter.a.b fgg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aYL = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.fge = new b(this.mTbPageContext, k.aBb);
        this.fgf = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.fgi);
        this.fgg = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.ffO);
        this.mAdapters.add(this.fge);
        this.mAdapters.add(this.fgf);
        this.mAdapters.add(this.fgg);
        this.aYL.addAdapters(this.mAdapters);
    }

    public void setDatas(List<f> list) {
        if (this.aYL != null) {
            this.aYL.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aYL != null && (this.aYL.getAdapter() instanceof j)) {
            ((j) this.aYL.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fge.p(onClickListener);
        this.fgf.p(onClickListener);
    }
}
