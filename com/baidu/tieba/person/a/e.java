package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView bdJ;
    private c fCG;
    private b fCH;
    private a fCI;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bdJ = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fCG = new c(this.mTbPageContext, i.aBK);
        this.fCH = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fCO);
        this.fCI = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fCp);
        this.mAdapters.add(this.fCG);
        this.mAdapters.add(this.fCH);
        this.mAdapters.add(this.fCI);
        this.bdJ.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bdJ != null) {
            this.bdJ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bdJ != null && (this.bdJ.getAdapter() instanceof q)) {
            ((q) this.bdJ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fCG.t(onClickListener);
        this.fCH.t(onClickListener);
    }
}
