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
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private ArrayList<m> eil = new ArrayList<>();
    private BdTypeListView eka;
    public j jAE;
    private b jAF;
    public i jmu;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eka = bdTypeListView;
        s(tbPageContext);
    }

    private void s(TbPageContext<?> tbPageContext) {
        this.jmu = new i(tbPageContext);
        this.jAE = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.joT);
        this.jAF = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.jAE.a(this.jAF);
        this.asE.add(this.jmu);
        this.asE.add(this.jAE);
        this.eka.addAdapters(this.asE);
    }

    public void S(ArrayList<m> arrayList) {
        if (arrayList != null && this.eka != null) {
            this.eil.clear();
            this.eil.addAll(arrayList);
            this.eka.setData(this.eil);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.eka != null) {
            this.eka.startPullRefresh();
        }
    }

    public boolean Hl(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.eka == null || this.eil == null) {
            return false;
        }
        Iterator<m> it = this.eil.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            m next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && aq.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.eil = PersonPostModel.mergeDynamicThreadByTime(this.eil);
            this.eka.setData(this.eil);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
