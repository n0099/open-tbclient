package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private TbPageContext mTbPageContext;
    private c muA;
    private b muB;
    private a muC;
    private HTypeListView muz;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.muz = hTypeListView;
        Kz();
    }

    private void Kz() {
        this.muA = new c(this.mTbPageContext, o.ahU);
        this.muB = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.muK);
        this.muC = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.mun);
        this.boS.add(this.muA);
        this.boS.add(this.muB);
        this.boS.add(this.muC);
        this.muz.addAdapters(this.boS);
    }

    public void setDatas(List<n> list) {
        if (this.muz != null) {
            this.muz.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.muz != null && (this.muz.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.muz.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.muA.I(onClickListener);
        this.muB.I(onClickListener);
    }
}
