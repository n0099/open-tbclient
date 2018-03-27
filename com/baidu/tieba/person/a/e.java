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
    private HTypeListView bTG;
    private c gij;
    private b gik;
    private a gil;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bTG = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gij = new c(this.mTbPageContext, i.brl);
        this.gik = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gir);
        this.gil = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghT);
        this.mAdapters.add(this.gij);
        this.mAdapters.add(this.gik);
        this.mAdapters.add(this.gil);
        this.bTG.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.i> list) {
        if (this.bTG != null) {
            this.bTG.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bTG != null && (this.bTG.getAdapter() instanceof r)) {
            ((r) this.bTG.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gij.r(onClickListener);
        this.gik.r(onClickListener);
    }
}
