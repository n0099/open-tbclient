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
    private ArrayList<n> gpY = new ArrayList<>();
    private BdTypeListView gzb;
    public j mMp;
    private c mMq;
    public i mzk;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gzb = bdTypeListView;
        y(tbPageContext);
    }

    private void y(TbPageContext<?> tbPageContext) {
        this.mzk = new i(tbPageContext);
        this.mMp = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mBI);
        this.mMq = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mMp.a(this.mMq);
        this.bns.add(this.mzk);
        this.bns.add(this.mMp);
        this.gzb.addAdapters(this.bns);
    }

    public void V(ArrayList<n> arrayList) {
        if (arrayList != null && this.gzb != null) {
            this.gpY.clear();
            this.gpY.addAll(arrayList);
            this.gzb.setData(this.gpY);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gzb != null) {
            this.gzb.startPullRefresh();
        }
    }

    public boolean QK(String str) {
        boolean z;
        if (au.isEmpty(str)) {
            return false;
        }
        if (this.gzb == null || this.gpY == null) {
            return false;
        }
        Iterator<n> it = this.gpY.iterator();
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
            this.gpY = PersonPostModel.mergeDynamicThreadByTime(this.gpY);
            this.gzb.setData(this.gpY);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
