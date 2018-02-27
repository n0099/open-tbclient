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
    private HTypeListView bTD;
    private c ghS;
    private b ghT;
    private a ghU;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bTD = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.ghS = new c(this.mTbPageContext, i.bri);
        this.ghT = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gia);
        this.ghU = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghD);
        this.mAdapters.add(this.ghS);
        this.mAdapters.add(this.ghT);
        this.mAdapters.add(this.ghU);
        this.bTD.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.i> list) {
        if (this.bTD != null) {
            this.bTD.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bTD != null && (this.bTD.getAdapter() instanceof r)) {
            ((r) this.bTD.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ghS.r(onClickListener);
        this.ghT.r(onClickListener);
    }
}
