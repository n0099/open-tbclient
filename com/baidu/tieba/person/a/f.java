package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private HTypeListView bsm;
    private d ezA;
    private a ezB;
    private com.baidu.tieba.personCenter.a.b ezC;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bsm = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.ezA = new d(this.mTbPageContext, com.baidu.tbadk.data.k.axV);
        this.ezB = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.ezM);
        this.ezC = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eAR);
        this.mAdapters.add(this.ezA);
        this.mAdapters.add(this.ezB);
        this.mAdapters.add(this.ezC);
        this.bsm.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.bsm != null) {
            this.bsm.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bsm != null && (this.bsm.getAdapter() instanceof y)) {
            ((y) this.bsm.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ezA.u(onClickListener);
        this.ezB.u(onClickListener);
    }
}
