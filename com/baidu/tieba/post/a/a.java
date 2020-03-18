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
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private ArrayList<m> eiP = new ArrayList<>();
    private BdTypeListView ekE;
    public j jCr;
    private b jCs;
    public i joh;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ekE = bdTypeListView;
        t(tbPageContext);
    }

    private void t(TbPageContext<?> tbPageContext) {
        this.joh = new i(tbPageContext);
        this.jCr = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.jqG);
        this.jCs = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.jCr.a(this.jCs);
        this.asP.add(this.joh);
        this.asP.add(this.jCr);
        this.ekE.addAdapters(this.asP);
    }

    public void S(ArrayList<m> arrayList) {
        if (arrayList != null && this.ekE != null) {
            this.eiP.clear();
            this.eiP.addAll(arrayList);
            this.ekE.setData(this.eiP);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.ekE != null) {
            this.ekE.startPullRefresh();
        }
    }

    public boolean Hl(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.ekE == null || this.eiP == null) {
            return false;
        }
        Iterator<m> it = this.eiP.iterator();
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
            this.eiP = PersonPostModel.mergeDynamicThreadByTime(this.eiP);
            this.ekE.setData(this.eiP);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
