package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.d;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public j gAb;
    private b gAc;
    public i gpo;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<h> ciz = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.gpo = new i(tbPageContext);
        this.gAb = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gry);
        this.gAc = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.gAb.a(this.gAc);
        this.mAdapters.add(this.gpo);
        this.mAdapters.add(this.gAb);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void C(ArrayList<h> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.ciz.clear();
            this.ciz.addAll(arrayList);
            this.mListView.setData(this.ciz);
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

    public boolean tD(String str) {
        boolean z;
        if (ao.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.ciz == null) {
            return false;
        }
        Iterator<h> it = this.ciz.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            h next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.ciz = PersonPostModel.mergeDynamicThreadByTime(this.ciz);
            this.mListView.setData(this.ciz);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
