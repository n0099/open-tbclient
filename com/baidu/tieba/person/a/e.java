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
    private HTypeListView bnt;
    private c fTf;
    private b fTg;
    private a fTh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bnt = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fTf = new c(this.mTbPageContext, j.aqU);
        this.fTg = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fTn);
        this.fTh = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fSP);
        this.mAdapters.add(this.fTf);
        this.mAdapters.add(this.fTg);
        this.mAdapters.add(this.fTh);
        this.bnt.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bnt != null) {
            this.bnt.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bnt != null && (this.bnt.getAdapter() instanceof q)) {
            ((q) this.bnt.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fTf.w(onClickListener);
        this.fTg.w(onClickListener);
    }
}
