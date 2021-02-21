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
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private TbPageContext mTbPageContext;
    private a msA;
    private HTypeListView msx;
    private c msy;
    private b msz;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.msx = hTypeListView;
        Kw();
    }

    private void Kw() {
        this.msy = new c(this.mTbPageContext, o.agC);
        this.msz = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.msI);
        this.msA = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.msl);
        this.bns.add(this.msy);
        this.bns.add(this.msz);
        this.bns.add(this.msA);
        this.msx.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.msx != null) {
            this.msx.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.msx != null && (this.msx.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.msx.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.msy.H(onClickListener);
        this.msz.H(onClickListener);
    }
}
