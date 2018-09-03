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
    private HTypeListView bob;
    private c fTi;
    private b fTj;
    private a fTk;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bob = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fTi = new c(this.mTbPageContext, j.aqw);
        this.fTj = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fTs);
        this.fTk = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fSS);
        this.mAdapters.add(this.fTi);
        this.mAdapters.add(this.fTj);
        this.mAdapters.add(this.fTk);
        this.bob.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bob != null) {
            this.bob.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bob != null && (this.bob.getAdapter() instanceof q)) {
            ((q) this.bob.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fTi.u(onClickListener);
        this.fTj.u(onClickListener);
    }
}
