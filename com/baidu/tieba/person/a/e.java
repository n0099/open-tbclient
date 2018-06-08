package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private HTypeListView blU;
    private c fPd;
    private b fPe;
    private a fPf;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.blU = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fPd = new c(this.mTbPageContext, j.aKh);
        this.fPe = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fPl);
        this.fPf = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fOM);
        this.mAdapters.add(this.fPd);
        this.mAdapters.add(this.fPe);
        this.mAdapters.add(this.fPf);
        this.blU.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.blU != null) {
            this.blU.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.blU != null && (this.blU.getAdapter() instanceof q)) {
            ((q) this.blU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fPd.t(onClickListener);
        this.fPe.t(onClickListener);
    }
}
