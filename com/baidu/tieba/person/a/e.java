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
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private HTypeListView ldA;
    private c ldB;
    private b ldC;
    private a ldD;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.ldA = hTypeListView;
        Jv();
    }

    private void Jv() {
        this.ldB = new c(this.mTbPageContext, m.ahM);
        this.ldC = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ldL);
        this.ldD = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ldq);
        this.bbw.add(this.ldB);
        this.bbw.add(this.ldC);
        this.bbw.add(this.ldD);
        this.ldA.addAdapters(this.bbw);
    }

    public void setDatas(List<q> list) {
        if (this.ldA != null) {
            this.ldA.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ldA != null && (this.ldA.getAdapter() instanceof af)) {
            ((af) this.ldA.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ldB.F(onClickListener);
        this.ldC.F(onClickListener);
    }
}
