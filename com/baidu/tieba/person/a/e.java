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
    private HTypeListView msi;
    private c msj;
    private b msk;
    private a msl;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.msi = hTypeListView;
        Kw();
    }

    private void Kw() {
        this.msj = new c(this.mTbPageContext, o.agC);
        this.msk = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.mst);
        this.msl = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.mrV);
        this.bns.add(this.msj);
        this.bns.add(this.msk);
        this.bns.add(this.msl);
        this.msi.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.msi != null) {
            this.msi.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.msi != null && (this.msi.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.msi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.msj.H(onClickListener);
        this.msk.H(onClickListener);
    }
}
