package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private HTypeListView jhC;
    private c jhD;
    private b jhE;
    private a jhF;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jhC = hTypeListView;
        wR();
    }

    private void wR() {
        this.jhD = new c(this.mTbPageContext, n.MP);
        this.jhE = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jhN);
        this.jhF = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jhs);
        this.asP.add(this.jhD);
        this.asP.add(this.jhE);
        this.asP.add(this.jhF);
        this.jhC.addAdapters(this.asP);
    }

    public void setDatas(List<m> list) {
        if (this.jhC != null) {
            this.jhC.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jhC != null && (this.jhC.getAdapter() instanceof v)) {
            ((v) this.jhC.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jhD.D(onClickListener);
        this.jhE.D(onClickListener);
    }
}
