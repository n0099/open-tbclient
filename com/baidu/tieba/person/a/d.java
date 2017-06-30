package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private HTypeListView bBi;
    private b eQx;
    private a eQy;
    private com.baidu.tieba.personCenter.a.b eQz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bBi = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.eQx = new b(this.mTbPageContext, k.ayI);
        this.eQy = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eQB);
        this.eQz = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.eQg);
        this.mAdapters.add(this.eQx);
        this.mAdapters.add(this.eQy);
        this.mAdapters.add(this.eQz);
        this.bBi.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.bBi != null) {
            this.bBi.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bBi != null && (this.bBi.getAdapter() instanceof z)) {
            ((z) this.bBi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eQx.v(onClickListener);
        this.eQy.v(onClickListener);
    }
}
