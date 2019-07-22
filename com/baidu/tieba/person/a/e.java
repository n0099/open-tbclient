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
    private HTypeListView cXK;
    private c iiB;
    private b iiC;
    private a iiD;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cXK = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.iiB = new c(this.mTbPageContext, m.XE);
        this.iiC = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.iiL);
        this.iiD = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.iil);
        this.mAdapters.add(this.iiB);
        this.mAdapters.add(this.iiC);
        this.mAdapters.add(this.iiD);
        this.cXK.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cXK != null) {
            this.cXK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cXK != null && (this.cXK.getAdapter() instanceof v)) {
            ((v) this.cXK.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.iiB.B(onClickListener);
        this.iiC.B(onClickListener);
    }
}
