package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private HTypeListView kND;
    private c kNE;
    private b kNF;
    private a kNG;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.kND = hTypeListView;
        DS();
    }

    private void DS() {
        this.kNE = new c(this.mTbPageContext, m.agB);
        this.kNF = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.kNO);
        this.kNG = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.kNt);
        this.aWf.add(this.kNE);
        this.aWf.add(this.kNF);
        this.aWf.add(this.kNG);
        this.kND.addAdapters(this.aWf);
    }

    public void setDatas(List<q> list) {
        if (this.kND != null) {
            this.kND.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.kND != null && (this.kND.getAdapter() instanceof ad)) {
            ((ad) this.kND.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.kNE.E(onClickListener);
        this.kNF.E(onClickListener);
    }
}
