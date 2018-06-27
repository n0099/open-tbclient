package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.d;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public i fYF;
    public j gjh;
    private b gji;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<h> bTf = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.fYF = new i(tbPageContext);
        this.gjh = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gaP);
        this.gji = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.gjh.a(this.gji);
        this.mAdapters.add(this.fYF);
        this.mAdapters.add(this.gjh);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void C(ArrayList<h> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.bTf.clear();
            this.bTf.addAll(arrayList);
            this.mListView.setData(this.bTf);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.mListView != null) {
            this.mListView.startPullRefresh();
        }
    }

    public boolean su(String str) {
        boolean z;
        if (ap.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.bTf == null) {
            return false;
        }
        Iterator<h> it = this.bTf.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            h next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.bTf = PersonPostModel.mergeDynamicThreadByTime(this.bTf);
            this.mListView.setData(this.bTf);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
