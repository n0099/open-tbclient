package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public i iiy;
    public j iuC;
    private b iuD;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<m> dMa = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.iiy = new i(tbPageContext);
        this.iuC = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.ikI);
        this.iuD = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.iuC.a(this.iuD);
        this.mAdapters.add(this.iiy);
        this.mAdapters.add(this.iuC);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void I(ArrayList<m> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.dMa.clear();
            this.dMa.addAll(arrayList);
            this.mListView.setData(this.dMa);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.mListView != null) {
            this.mListView.startPullRefresh();
        }
    }

    public boolean Ct(String str) {
        boolean z;
        if (ap.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.dMa == null) {
            return false;
        }
        Iterator<m> it = this.dMa.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            m next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.dMa = PersonPostModel.mergeDynamicThreadByTime(this.dMa);
            this.mListView.setData(this.dMa);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
