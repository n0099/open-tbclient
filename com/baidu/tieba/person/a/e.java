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
    private HTypeListView bdK;
    private c fDJ;
    private b fDK;
    private a fDL;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bdK = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fDJ = new c(this.mTbPageContext, i.aBL);
        this.fDK = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fDR);
        this.fDL = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fDs);
        this.mAdapters.add(this.fDJ);
        this.mAdapters.add(this.fDK);
        this.mAdapters.add(this.fDL);
        this.bdK.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.bdK != null) {
            this.bdK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bdK != null && (this.bdK.getAdapter() instanceof q)) {
            ((q) this.bdK.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fDJ.t(onClickListener);
        this.fDK.t(onClickListener);
    }
}
