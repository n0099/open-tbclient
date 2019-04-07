package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.m;
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
/* loaded from: classes6.dex */
public class a {
    public i hPL;
    public j ibX;
    private b ibY;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<m> dBA = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.hPL = new i(tbPageContext);
        this.ibX = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.hRV);
        this.ibY = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.ibX.a(this.ibY);
        this.mAdapters.add(this.hPL);
        this.mAdapters.add(this.ibX);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void F(ArrayList<m> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.dBA.clear();
            this.dBA.addAll(arrayList);
            this.mListView.setData(this.dBA);
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

    public boolean Bb(String str) {
        boolean z;
        if (ap.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.dBA == null) {
            return false;
        }
        Iterator<m> it = this.dBA.iterator();
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
            this.dBA = PersonPostModel.mergeDynamicThreadByTime(this.dBA);
            this.mListView.setData(this.dBA);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
