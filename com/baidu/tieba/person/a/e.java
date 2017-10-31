package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private HTypeListView bak;
    private c fhn;
    private b fho;
    private a fhp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bak = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fhn = new c(this.mTbPageContext, l.aAc);
        this.fho = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fhv);
        this.fhp = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fgZ);
        this.mAdapters.add(this.fhn);
        this.mAdapters.add(this.fho);
        this.mAdapters.add(this.fhp);
        this.bak.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
        if (this.bak != null) {
            this.bak.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bak != null && (this.bak.getAdapter() instanceof j)) {
            ((j) this.bak.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fhn.q(onClickListener);
        this.fho.q(onClickListener);
    }
}
