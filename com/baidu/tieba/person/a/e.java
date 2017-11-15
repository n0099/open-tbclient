package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private HTypeListView bat;
    private c fhJ;
    private b fhK;
    private a fhL;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bat = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fhJ = new c(this.mTbPageContext, l.aAk);
        this.fhK = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.fhR);
        this.fhL = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.fhv);
        this.mAdapters.add(this.fhJ);
        this.mAdapters.add(this.fhK);
        this.mAdapters.add(this.fhL);
        this.bat.addAdapters(this.mAdapters);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
        if (this.bat != null) {
            this.bat.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bat != null && (this.bat.getAdapter() instanceof j)) {
            ((j) this.bat.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.fhJ.q(onClickListener);
        this.fhK.q(onClickListener);
    }
}
