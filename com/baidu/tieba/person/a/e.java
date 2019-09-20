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
    private HTypeListView cZC;
    private c ilC;
    private b ilD;
    private a ilE;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cZC = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.ilC = new c(this.mTbPageContext, m.XD);
        this.ilD = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ilM);
        this.ilE = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ilm);
        this.mAdapters.add(this.ilC);
        this.mAdapters.add(this.ilD);
        this.mAdapters.add(this.ilE);
        this.cZC.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cZC != null) {
            this.cZC.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cZC != null && (this.cZC.getAdapter() instanceof v)) {
            ((v) this.cZC.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ilC.B(onClickListener);
        this.ilD.B(onClickListener);
    }
}
