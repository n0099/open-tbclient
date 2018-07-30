package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView bnZ;
    private c fTq;
    private b fTr;
    private a fTs;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bnZ = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fTq = new c(this.mTbPageContext, j.aqv);
        this.fTr = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fTA);
        this.fTs = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fTa);
        this.mAdapters.add(this.fTq);
        this.mAdapters.add(this.fTr);
        this.mAdapters.add(this.fTs);
        this.bnZ.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bnZ != null) {
            this.bnZ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bnZ != null && (this.bnZ.getAdapter() instanceof q)) {
            ((q) this.bnZ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fTq.u(onClickListener);
        this.fTr.u(onClickListener);
    }
}
