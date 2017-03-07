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
    private HTypeListView bsu;
    private d eBu;
    private a eBv;
    private com.baidu.tieba.personCenter.a.b eBw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bsu = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.eBu = new d(this.mTbPageContext, com.baidu.tbadk.data.k.axF);
        this.eBv = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eBG);
        this.eBw = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eCU);
        this.mAdapters.add(this.eBu);
        this.mAdapters.add(this.eBv);
        this.mAdapters.add(this.eBw);
        this.bsu.addAdapters(this.mAdapters);
    }

    public void setDatas(List<v> list) {
        if (this.bsu != null) {
            this.bsu.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bsu != null && (this.bsu.getAdapter() instanceof y)) {
            ((y) this.bsu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eBu.u(onClickListener);
        this.eBv.u(onClickListener);
    }
}
