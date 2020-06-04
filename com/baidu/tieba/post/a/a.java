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
    private ArrayList<o> eVq = new ArrayList<>();
    private BdTypeListView fbb;
    public j kFD;
    private b kFE;
    public i kry;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fbb = bdTypeListView;
        v(tbPageContext);
    }

    private void v(TbPageContext<?> tbPageContext) {
        this.kry = new i(tbPageContext);
        this.kFD = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.ktX);
        this.kFE = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.kFD.a(this.kFE);
        this.aSj.add(this.kry);
        this.aSj.add(this.kFD);
        this.fbb.addAdapters(this.aSj);
    }

    public void T(ArrayList<o> arrayList) {
        if (arrayList != null && this.fbb != null) {
            this.eVq.clear();
            this.eVq.addAll(arrayList);
            this.fbb.setData(this.eVq);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.fbb != null) {
            this.fbb.startPullRefresh();
        }
    }

    public boolean KJ(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.fbb == null || this.eVq == null) {
            return false;
        }
        Iterator<o> it = this.eVq.iterator();
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
            this.eVq = PersonPostModel.mergeDynamicThreadByTime(this.eVq);
            this.fbb.setData(this.eVq);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
