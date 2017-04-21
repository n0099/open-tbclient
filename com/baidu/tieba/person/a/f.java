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
    private HTypeListView buF;
    private d eBQ;
    private a eBR;
    private com.baidu.tieba.personCenter.a.b eBS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.buF = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.eBQ = new d(this.mTbPageContext, com.baidu.tbadk.data.k.axX);
        this.eBR = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eCc);
        this.eBS = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDh);
        this.mAdapters.add(this.eBQ);
        this.mAdapters.add(this.eBR);
        this.mAdapters.add(this.eBS);
        this.buF.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.buF != null) {
            this.buF.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.buF != null && (this.buF.getAdapter() instanceof y)) {
            ((y) this.buF.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eBQ.u(onClickListener);
        this.eBR.u(onClickListener);
    }
}
