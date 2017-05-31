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
    private HTypeListView bAp;
    private b eGI;
    private a eGJ;
    private com.baidu.tieba.personCenter.a.b eGK;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bAp = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.eGI = new b(this.mTbPageContext, k.axG);
        this.eGJ = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eGM);
        this.eGK = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.eGy);
        this.mAdapters.add(this.eGI);
        this.mAdapters.add(this.eGJ);
        this.mAdapters.add(this.eGK);
        this.bAp.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.bAp != null) {
            this.bAp.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bAp != null && (this.bAp.getAdapter() instanceof z)) {
            ((z) this.bAp.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eGI.u(onClickListener);
        this.eGJ.u(onClickListener);
    }
}
