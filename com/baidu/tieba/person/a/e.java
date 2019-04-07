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
    private HTypeListView cOa;
    private c hKf;
    private b hKg;
    private a hKh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cOa = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.hKf = new c(this.mTbPageContext, m.Zr);
        this.hKg = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.hKp);
        this.hKh = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.hJP);
        this.mAdapters.add(this.hKf);
        this.mAdapters.add(this.hKg);
        this.mAdapters.add(this.hKh);
        this.cOa.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.cOa != null) {
            this.cOa.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cOa != null && (this.cOa.getAdapter() instanceof v)) {
            ((v) this.cOa.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.hKf.x(onClickListener);
        this.hKg.x(onClickListener);
    }
}
