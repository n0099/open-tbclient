package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView bTP;
    private c gie;
    private b gif;
    private a gig;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bTP = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gie = new c(this.mTbPageContext, i.brv);
        this.gif = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gim);
        this.gig = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghO);
        this.mAdapters.add(this.gie);
        this.mAdapters.add(this.gif);
        this.mAdapters.add(this.gig);
        this.bTP.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.i> list) {
        if (this.bTP != null) {
            this.bTP.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bTP != null && (this.bTP.getAdapter() instanceof r)) {
            ((r) this.bTP.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gie.r(onClickListener);
        this.gif.r(onClickListener);
    }
}
