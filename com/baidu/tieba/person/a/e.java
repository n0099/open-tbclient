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
    private HTypeListView byG;
    private c gjx;
    private b gjy;
    private a gjz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.byG = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.gjx = new c(this.mTbPageContext, k.ays);
        this.gjy = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.gjH);
        this.gjz = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.gjh);
        this.mAdapters.add(this.gjx);
        this.mAdapters.add(this.gjy);
        this.mAdapters.add(this.gjz);
        this.byG.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (this.byG != null) {
            this.byG.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.byG != null && (this.byG.getAdapter() instanceof q)) {
            ((q) this.byG.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.gjx.w(onClickListener);
        this.gjy.w(onClickListener);
    }
}
