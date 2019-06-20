package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
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
    public i iiC;
    public j iuG;
    private b iuH;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<m> dMb = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.iiC = new i(tbPageContext);
        this.iuG = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.ikM);
        this.iuH = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.iuG.a(this.iuH);
        this.mAdapters.add(this.iiC);
        this.mAdapters.add(this.iuG);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void I(ArrayList<m> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.dMb.clear();
            this.dMb.addAll(arrayList);
            this.mListView.setData(this.dMb);
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

    public boolean Cv(String str) {
        boolean z;
        if (ap.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.dMb == null) {
            return false;
        }
        Iterator<m> it = this.dMb.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            m next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.dMb = PersonPostModel.mergeDynamicThreadByTime(this.dMb);
            this.mListView.setData(this.dMb);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
