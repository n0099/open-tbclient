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
    private HTypeListView btQ;
    private a gaA;
    private c gay;
    private b gaz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.btQ = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gay = new c(this.mTbPageContext, k.asU);
        this.gaz = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gaI);
        this.gaA = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.gai);
        this.mAdapters.add(this.gay);
        this.mAdapters.add(this.gaz);
        this.mAdapters.add(this.gaA);
        this.btQ.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.btQ != null) {
            this.btQ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.btQ != null && (this.btQ.getAdapter() instanceof q)) {
            ((q) this.btQ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gay.u(onClickListener);
        this.gaz.u(onClickListener);
    }
}
