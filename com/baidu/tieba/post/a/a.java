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
    public i hPZ;
    public j icl;
    private b icm;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<m> dCk = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        q(tbPageContext);
    }

    private void q(TbPageContext<?> tbPageContext) {
        this.hPZ = new i(tbPageContext);
        this.icl = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.hSj);
        this.icm = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.icl.a(this.icm);
        this.mAdapters.add(this.hPZ);
        this.mAdapters.add(this.icl);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void F(ArrayList<m> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.dCk.clear();
            this.dCk.addAll(arrayList);
            this.mListView.setData(this.dCk);
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

    public boolean Bc(String str) {
        boolean z;
        if (ap.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.dCk == null) {
            return false;
        }
        Iterator<m> it = this.dCk.iterator();
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
            this.dCk = PersonPostModel.mergeDynamicThreadByTime(this.dCk);
            this.mListView.setData(this.dCk);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
