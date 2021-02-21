package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.c;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private ArrayList<n> gqm = new ArrayList<>();
    private BdTypeListView gzp;
    public j mME;
    private c mMF;
    public i mzz;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gzp = bdTypeListView;
        y(tbPageContext);
    }

    private void y(TbPageContext<?> tbPageContext) {
        this.mzz = new i(tbPageContext);
        this.mME = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mBX);
        this.mMF = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mME.a(this.mMF);
        this.bns.add(this.mzz);
        this.bns.add(this.mME);
        this.gzp.addAdapters(this.bns);
    }

    public void V(ArrayList<n> arrayList) {
        if (arrayList != null && this.gzp != null) {
            this.gqm.clear();
            this.gqm.addAll(arrayList);
            this.gzp.setData(this.gqm);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gzp != null) {
            this.gzp.startPullRefresh();
        }
    }

    public boolean QL(String str) {
        boolean z;
        if (au.isEmpty(str)) {
            return false;
        }
        if (this.gzp == null || this.gqm == null) {
            return false;
        }
        Iterator<n> it = this.gqm.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            n next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && au.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.gqm = PersonPostModel.mergeDynamicThreadByTime(this.gqm);
            this.gzp.setData(this.gqm);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
