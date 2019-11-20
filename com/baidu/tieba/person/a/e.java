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
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private HTypeListView dij;
    private c ijv;
    private b ijw;
    private a ijx;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.dij = hTypeListView;
        sY();
    }

    private void sY() {
        this.ijv = new c(this.mTbPageContext, m.GX);
        this.ijw = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.ijF);
        this.ijx = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijf);
        this.agy.add(this.ijv);
        this.agy.add(this.ijw);
        this.agy.add(this.ijx);
        this.dij.addAdapters(this.agy);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.dij != null) {
            this.dij.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.dij != null && (this.dij.getAdapter() instanceof v)) {
            ((v) this.dij.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.ijv.C(onClickListener);
        this.ijw.C(onClickListener);
    }
}
