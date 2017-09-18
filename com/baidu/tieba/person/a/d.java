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
    private HTypeListView aYu;
    private b ffn;
    private a ffo;
    private com.baidu.tieba.personCenter.a.b ffp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aYu = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.ffn = new b(this.mTbPageContext, k.aAj);
        this.ffo = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.ffr);
        this.ffp = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), h.feY);
        this.mAdapters.add(this.ffn);
        this.mAdapters.add(this.ffo);
        this.mAdapters.add(this.ffp);
        this.aYu.addAdapters(this.mAdapters);
    }

    public void setDatas(List<f> list) {
        if (this.aYu != null) {
            this.aYu.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aYu != null && (this.aYu.getAdapter() instanceof j)) {
            ((j) this.aYu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ffn.p(onClickListener);
        this.ffo.p(onClickListener);
    }
}
