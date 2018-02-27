package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public i gnr;
    public j gxM;
    private b gxN;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<com.baidu.adp.widget.ListView.i> crv = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        o(tbPageContext);
    }

    private void o(TbPageContext<?> tbPageContext) {
        this.gnr = new i(tbPageContext);
        this.gxM = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gpI);
        this.gxN = new com.baidu.tieba.personExtra.i(tbPageContext, this, tbPageContext.getUniqueId());
        this.gxM.a(this.gxN);
        this.mAdapters.add(this.gnr);
        this.mAdapters.add(this.gxM);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void A(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.crv.clear();
            this.crv.addAll(arrayList);
            this.mListView.setData(this.crv);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.mListView != null) {
            this.mListView.startPullRefresh();
        }
    }

    public boolean ru(String str) {
        boolean z;
        if (am.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.crv == null) {
            return false;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.crv.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && am.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.crv = PersonPostModel.mergeDynamicThreadByTime(this.crv);
            this.mListView.setData(this.crv);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
