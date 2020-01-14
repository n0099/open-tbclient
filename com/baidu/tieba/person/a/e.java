package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private HTypeListView jeT;
    private c jeU;
    private b jeV;
    private a jeW;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jeT = hTypeListView;
        vi();
    }

    private void vi() {
        this.jeU = new c(this.mTbPageContext, n.Mm);
        this.jeV = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jfe);
        this.jeW = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jeJ);
        this.apl.add(this.jeU);
        this.apl.add(this.jeV);
        this.apl.add(this.jeW);
        this.jeT.addAdapters(this.apl);
    }

    public void setDatas(List<m> list) {
        if (this.jeT != null) {
            this.jeT.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jeT != null && (this.jeT.getAdapter() instanceof v)) {
            ((v) this.jeT.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jeU.C(onClickListener);
        this.jeV.C(onClickListener);
    }
}
