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
    private HTypeListView bdD;
    private c fqH;
    private b fqI;
    private a fqJ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bdD = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fqH = new c(this.mTbPageContext, l.aAL);
        this.fqI = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fqP);
        this.fqJ = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fqs);
        this.mAdapters.add(this.fqH);
        this.mAdapters.add(this.fqI);
        this.mAdapters.add(this.fqJ);
        this.bdD.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
        if (this.bdD != null) {
            this.bdD.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bdD != null && (this.bdD.getAdapter() instanceof j)) {
            ((j) this.bdD.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fqH.q(onClickListener);
        this.fqI.q(onClickListener);
    }
}
