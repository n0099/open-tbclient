package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private ArrayList<n> gnp = new ArrayList<>();
    private BdTypeListView gwr;
    public j mDi;
    private c mDj;
    public i mqk;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gwr = bdTypeListView;
        w(tbPageContext);
    }

    private void w(TbPageContext<?> tbPageContext) {
        this.mqk = new i(tbPageContext);
        this.mDi = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.msI);
        this.mDj = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mDi.a(this.mDj);
        this.bjZ.add(this.mqk);
        this.bjZ.add(this.mDi);
        this.gwr.addAdapters(this.bjZ);
    }

    public void W(ArrayList<n> arrayList) {
        if (arrayList != null && this.gwr != null) {
            this.gnp.clear();
            this.gnp.addAll(arrayList);
            this.gwr.setData(this.gnp);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gwr != null) {
            this.gwr.startPullRefresh();
        }
    }

    public boolean PT(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.gwr == null || this.gnp == null) {
            return false;
        }
        Iterator<n> it = this.gnp.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            n next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && at.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.gnp = PersonPostModel.mergeDynamicThreadByTime(this.gnp);
            this.gwr.setData(this.gnp);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
