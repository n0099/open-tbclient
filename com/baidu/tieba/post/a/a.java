package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
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
    public j gKM;
    private b gKN;
    public i gzZ;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<h> cnn = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.gzZ = new i(tbPageContext);
        this.gKM = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gCj);
        this.gKN = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.gKM.a(this.gKN);
        this.mAdapters.add(this.gzZ);
        this.mAdapters.add(this.gKM);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void C(ArrayList<h> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.cnn.clear();
            this.cnn.addAll(arrayList);
            this.mListView.setData(this.cnn);
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

    public boolean uy(String str) {
        boolean z;
        if (ao.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.cnn == null) {
            return false;
        }
        Iterator<h> it = this.cnn.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            h next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.cnn = PersonPostModel.mergeDynamicThreadByTime(this.cnn);
            this.mListView.setData(this.cnn);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
