package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private HTypeListView djb;
    private c ikm;
    private b ikn;
    private a iko;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.djb = hTypeListView;
        sX();
    }

    private void sX() {
        this.ikm = new c(this.mTbPageContext, m.Hx);
        this.ikn = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ikw);
        this.iko = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijW);
        this.agQ.add(this.ikm);
        this.agQ.add(this.ikn);
        this.agQ.add(this.iko);
        this.djb.addAdapters(this.agQ);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.djb != null) {
            this.djb.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.djb != null && (this.djb.getAdapter() instanceof v)) {
            ((v) this.djb.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ikm.C(onClickListener);
        this.ikn.C(onClickListener);
    }
}
