package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public j iEt;
    private b iEu;
    public i irX;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<m> dRB = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.irX = new i(tbPageContext);
        this.iEt = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.iuh);
        this.iEu = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.iEt.a(this.iEu);
        this.mAdapters.add(this.irX);
        this.mAdapters.add(this.iEt);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void I(ArrayList<m> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.dRB.clear();
            this.dRB.addAll(arrayList);
            this.mListView.setData(this.dRB);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.mListView != null) {
            this.mListView.startPullRefresh();
        }
    }

    public boolean DI(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.dRB == null) {
            return false;
        }
        Iterator<m> it = this.dRB.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            m next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && aq.bV(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.dRB = PersonPostModel.mergeDynamicThreadByTime(this.dRB);
            this.mListView.setData(this.dRB);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
