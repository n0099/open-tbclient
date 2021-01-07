package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private TbPageContext mTbPageContext;
    private HTypeListView mnK;
    private c mnL;
    private b mnM;
    private a mnN;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.mnK = hTypeListView;
        MT();
    }

    private void MT() {
        this.mnL = new c(this.mTbPageContext, o.ahE);
        this.mnM = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.mnV);
        this.mnN = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.mny);
        this.boM.add(this.mnL);
        this.boM.add(this.mnM);
        this.boM.add(this.mnN);
        this.mnK.addAdapters(this.boM);
    }

    public void setDatas(List<n> list) {
        if (this.mnK != null) {
            this.mnK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mnK != null && (this.mnK.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.mnK.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.mnL.H(onClickListener);
        this.mnM.H(onClickListener);
    }
}
