package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private HTypeListView aZT;
    private c eYW;
    private b eYX;
    private a eYY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aZT = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
    }

    private void initAdapters() {
        this.eYW = new c(this.mTbPageContext, j.azr);
        this.eYX = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.eZe);
        this.eYY = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYJ);
        this.mAdapters.add(this.eYW);
        this.mAdapters.add(this.eYX);
        this.mAdapters.add(this.eYY);
        this.aZT.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
        if (this.aZT != null) {
            this.aZT.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aZT != null && (this.aZT.getAdapter() instanceof com.baidu.adp.widget.ListView.j)) {
            ((com.baidu.adp.widget.ListView.j) this.aZT.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eYW.p(onClickListener);
        this.eYX.p(onClickListener);
    }
}
