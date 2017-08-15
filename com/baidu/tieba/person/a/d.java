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
    private HTypeListView aYK;
    private b fgc;
    private a fgd;
    private com.baidu.tieba.personCenter.a.b fge;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aYK = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.fgc = new b(this.mTbPageContext, k.aBa);
        this.fgd = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.fgg);
        this.fge = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.ffM);
        this.mAdapters.add(this.fgc);
        this.mAdapters.add(this.fgd);
        this.mAdapters.add(this.fge);
        this.aYK.addAdapters(this.mAdapters);
    }

    public void setDatas(List<f> list) {
        if (this.aYK != null) {
            this.aYK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aYK != null && (this.aYK.getAdapter() instanceof j)) {
            ((j) this.aYK.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fgc.t(onClickListener);
        this.fgd.t(onClickListener);
    }
}
