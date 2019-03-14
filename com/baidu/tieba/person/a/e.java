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
    private HTypeListView cNY;
    private c hKt;
    private b hKu;
    private a hKv;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cNY = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.hKt = new c(this.mTbPageContext, m.Zr);
        this.hKu = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.hKD);
        this.hKv = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.hKd);
        this.mAdapters.add(this.hKt);
        this.mAdapters.add(this.hKu);
        this.mAdapters.add(this.hKv);
        this.cNY.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cNY != null) {
            this.cNY.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cNY != null && (this.cNY.getAdapter() instanceof v)) {
            ((v) this.cNY.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.hKt.x(onClickListener);
        this.hKu.x(onClickListener);
    }
}
