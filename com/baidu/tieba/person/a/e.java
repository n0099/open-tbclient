package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private HTypeListView jRO;
    private c jRP;
    private b jRQ;
    private a jRR;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jRO = hTypeListView;
        BB();
    }

    private void BB() {
        this.jRP = new c(this.mTbPageContext, l.afD);
        this.jRQ = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jRZ);
        this.jRR = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jRE);
        this.aMj.add(this.jRP);
        this.aMj.add(this.jRQ);
        this.aMj.add(this.jRR);
        this.jRO.addAdapters(this.aMj);
    }

    public void setDatas(List<m> list) {
        if (this.jRO != null) {
            this.jRO.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jRO != null && (this.jRO.getAdapter() instanceof y)) {
            ((y) this.jRO.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jRP.E(onClickListener);
        this.jRQ.E(onClickListener);
    }
}
