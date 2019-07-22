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
    public j iAX;
    private b iAY;
    public i ioU;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<m> dPJ = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.ioU = new i(tbPageContext);
        this.iAX = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.ire);
        this.iAY = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.iAX.a(this.iAY);
        this.mAdapters.add(this.ioU);
        this.mAdapters.add(this.iAX);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void I(ArrayList<m> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.dPJ.clear();
            this.dPJ.addAll(arrayList);
            this.mListView.setData(this.dPJ);
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

    public boolean Di(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.dPJ == null) {
            return false;
        }
        Iterator<m> it = this.dPJ.iterator();
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
            this.dPJ = PersonPostModel.mergeDynamicThreadByTime(this.dPJ);
            this.mListView.setData(this.dPJ);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
