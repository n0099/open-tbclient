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
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private HTypeListView jgd;
    private c jge;
    private b jgf;
    private a jgg;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jgd = hTypeListView;
        wM();
    }

    private void wM() {
        this.jge = new c(this.mTbPageContext, n.MO);
        this.jgf = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jgo);
        this.jgg = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfT);
        this.asF.add(this.jge);
        this.asF.add(this.jgf);
        this.asF.add(this.jgg);
        this.jgd.addAdapters(this.asF);
    }

    public void setDatas(List<m> list) {
        if (this.jgd != null) {
            this.jgd.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jgd != null && (this.jgd.getAdapter() instanceof v)) {
            ((v) this.jgd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jge.D(onClickListener);
        this.jgf.D(onClickListener);
    }
}
