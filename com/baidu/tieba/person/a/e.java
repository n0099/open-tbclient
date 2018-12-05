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
    private HTypeListView bCd;
    private c gqn;
    private b gqo;
    private a gqp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bCd = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gqn = new c(this.mTbPageContext, k.aBS);
        this.gqo = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gqx);
        this.gqp = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.gpX);
        this.mAdapters.add(this.gqn);
        this.mAdapters.add(this.gqo);
        this.mAdapters.add(this.gqp);
        this.bCd.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bCd != null) {
            this.bCd.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bCd != null && (this.bCd.getAdapter() instanceof q)) {
            ((q) this.bCd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gqn.w(onClickListener);
        this.gqo.w(onClickListener);
    }
}
