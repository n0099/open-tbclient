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
    private ArrayList<m> eim = new ArrayList<>();
    private BdTypeListView ekb;
    public j jAG;
    private b jAH;
    public i jmw;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ekb = bdTypeListView;
        s(tbPageContext);
    }

    private void s(TbPageContext<?> tbPageContext) {
        this.jmw = new i(tbPageContext);
        this.jAG = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.joV);
        this.jAH = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.jAG.a(this.jAH);
        this.asE.add(this.jmw);
        this.asE.add(this.jAG);
        this.ekb.addAdapters(this.asE);
    }

    public void S(ArrayList<m> arrayList) {
        if (arrayList != null && this.ekb != null) {
            this.eim.clear();
            this.eim.addAll(arrayList);
            this.ekb.setData(this.eim);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.ekb != null) {
            this.ekb.startPullRefresh();
        }
    }

    public boolean Hl(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.ekb == null || this.eim == null) {
            return false;
        }
        Iterator<m> it = this.eim.iterator();
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
            this.eim = PersonPostModel.mergeDynamicThreadByTime(this.eim);
            this.ekb.setData(this.eim);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
