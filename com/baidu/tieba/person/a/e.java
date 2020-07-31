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
    private HTypeListView kNB;
    private c kNC;
    private b kND;
    private a kNE;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.kNB = hTypeListView;
        DS();
    }

    private void DS() {
        this.kNC = new c(this.mTbPageContext, m.agB);
        this.kND = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.kNM);
        this.kNE = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.kNr);
        this.aWf.add(this.kNC);
        this.aWf.add(this.kND);
        this.aWf.add(this.kNE);
        this.kNB.addAdapters(this.aWf);
    }

    public void setDatas(List<q> list) {
        if (this.kNB != null) {
            this.kNB.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.kNB != null && (this.kNB.getAdapter() instanceof ad)) {
            ((ad) this.kNB.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.kNC.E(onClickListener);
        this.kND.E(onClickListener);
    }
}
