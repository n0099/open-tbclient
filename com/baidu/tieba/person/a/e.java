package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView bCg;
    private c gte;
    private b gtf;
    private a gtg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bCg = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gte = new c(this.mTbPageContext, k.aBS);
        this.gtf = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gto);
        this.gtg = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.gsO);
        this.mAdapters.add(this.gte);
        this.mAdapters.add(this.gtf);
        this.mAdapters.add(this.gtg);
        this.bCg.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bCg != null) {
            this.bCg.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bCg != null && (this.bCg.getAdapter() instanceof q)) {
            ((q) this.bCg.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gte.w(onClickListener);
        this.gtf.w(onClickListener);
    }
}
