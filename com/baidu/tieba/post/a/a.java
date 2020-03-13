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
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private ArrayList<m> eiz = new ArrayList<>();
    private BdTypeListView eko;
    public j jAS;
    private b jAT;
    public i jmI;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eko = bdTypeListView;
        s(tbPageContext);
    }

    private void s(TbPageContext<?> tbPageContext) {
        this.jmI = new i(tbPageContext);
        this.jAS = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.jph);
        this.jAT = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.jAS.a(this.jAT);
        this.asF.add(this.jmI);
        this.asF.add(this.jAS);
        this.eko.addAdapters(this.asF);
    }

    public void S(ArrayList<m> arrayList) {
        if (arrayList != null && this.eko != null) {
            this.eiz.clear();
            this.eiz.addAll(arrayList);
            this.eko.setData(this.eiz);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.eko != null) {
            this.eko.startPullRefresh();
        }
    }

    public boolean Hm(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.eko == null || this.eiz == null) {
            return false;
        }
        Iterator<m> it = this.eiz.iterator();
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
            this.eiz = PersonPostModel.mergeDynamicThreadByTime(this.eiz);
            this.eko.setData(this.eiz);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
