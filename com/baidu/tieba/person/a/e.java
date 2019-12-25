package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private HTypeListView jbl;
    private c jbm;
    private b jbn;
    private a jbo;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jbl = hTypeListView;
        uR();
    }

    private void uR() {
        this.jbm = new c(this.mTbPageContext, n.Mh);
        this.jbn = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jbw);
        this.jbo = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jbb);
        this.aoz.add(this.jbm);
        this.aoz.add(this.jbn);
        this.aoz.add(this.jbo);
        this.jbl.addAdapters(this.aoz);
    }

    public void setDatas(List<m> list) {
        if (this.jbl != null) {
            this.jbl.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jbl != null && (this.jbl.getAdapter() instanceof v)) {
            ((v) this.jbl.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jbm.D(onClickListener);
        this.jbn.D(onClickListener);
    }
}
