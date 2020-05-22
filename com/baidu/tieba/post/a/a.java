package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
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
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private ArrayList<o> eVf = new ArrayList<>();
    private BdTypeListView faQ;
    public j kEv;
    private b kEw;
    public i kqs;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.faQ = bdTypeListView;
        v(tbPageContext);
    }

    private void v(TbPageContext<?> tbPageContext) {
        this.kqs = new i(tbPageContext);
        this.kEv = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.ksR);
        this.kEw = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.kEv.a(this.kEw);
        this.aSj.add(this.kqs);
        this.aSj.add(this.kEv);
        this.faQ.addAdapters(this.aSj);
    }

    public void T(ArrayList<o> arrayList) {
        if (arrayList != null && this.faQ != null) {
            this.eVf.clear();
            this.eVf.addAll(arrayList);
            this.faQ.setData(this.eVf);
        }
    }

    public void notifyDataSetChanged() {
        if (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.faQ != null) {
            this.faQ.startPullRefresh();
        }
    }

    public boolean KI(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.faQ == null || this.eVf == null) {
            return false;
        }
        Iterator<o> it = this.eVf.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            o next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && aq.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.eVf = PersonPostModel.mergeDynamicThreadByTime(this.eVf);
            this.faQ.setData(this.eVf);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
