package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.c;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private ArrayList<q> fTO = new ArrayList<>();
    private BdTypeListView gcr;
    public i lVe;
    public j mia;
    private c mib;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gcr = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.lVe = new i(tbPageContext);
        this.mia = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.lXA);
        this.mib = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mia.a(this.mib);
        this.bje.add(this.lVe);
        this.bje.add(this.mia);
        this.gcr.addAdapters(this.bje);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.gcr != null) {
            this.fTO.clear();
            this.fTO.addAll(arrayList);
            this.gcr.setData(this.fTO);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gcr.getAdapter() instanceof f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gcr != null) {
            this.gcr.startPullRefresh();
        }
    }

    public boolean QA(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.gcr == null || this.fTO == null) {
            return false;
        }
        Iterator<q> it = this.fTO.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            q next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && at.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.fTO = PersonPostModel.mergeDynamicThreadByTime(this.fTO);
            this.gcr.setData(this.fTO);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
