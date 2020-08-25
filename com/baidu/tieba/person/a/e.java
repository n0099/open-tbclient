package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private HTypeListView ldt;
    private c ldu;
    private b ldv;
    private a ldw;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.ldt = hTypeListView;
        Jv();
    }

    private void Jv() {
        this.ldu = new c(this.mTbPageContext, m.ahK);
        this.ldv = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ldE);
        this.ldw = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ldj);
        this.bbu.add(this.ldu);
        this.bbu.add(this.ldv);
        this.bbu.add(this.ldw);
        this.ldt.addAdapters(this.bbu);
    }

    public void setDatas(List<q> list) {
        if (this.ldt != null) {
            this.ldt.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ldt != null && (this.ldt.getAdapter() instanceof af)) {
            ((af) this.ldt.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ldu.F(onClickListener);
        this.ldv.F(onClickListener);
    }
}
