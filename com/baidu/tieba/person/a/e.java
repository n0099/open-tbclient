package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private HTypeListView cOb;
    private c hKg;
    private b hKh;
    private a hKi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cOb = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.hKg = new c(this.mTbPageContext, m.Zs);
        this.hKh = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.hKq);
        this.hKi = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.hJQ);
        this.mAdapters.add(this.hKg);
        this.mAdapters.add(this.hKh);
        this.mAdapters.add(this.hKi);
        this.cOb.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cOb != null) {
            this.cOb.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cOb != null && (this.cOb.getAdapter() instanceof v)) {
            ((v) this.cOb.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.hKg.x(onClickListener);
        this.hKh.x(onClickListener);
    }
}
