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
    public j gJI;
    private b gJJ;
    public i gyV;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<h> cmC = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.gyV = new i(tbPageContext);
        this.gJI = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gBf);
        this.gJJ = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.gJI.a(this.gJJ);
        this.mAdapters.add(this.gyV);
        this.mAdapters.add(this.gJI);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void C(ArrayList<h> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.cmC.clear();
            this.cmC.addAll(arrayList);
            this.mListView.setData(this.cmC);
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

    public boolean ui(String str) {
        boolean z;
        if (ao.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.cmC == null) {
            return false;
        }
        Iterator<h> it = this.cmC.iterator();
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
            this.cmC = PersonPostModel.mergeDynamicThreadByTime(this.cmC);
            this.mListView.setData(this.cmC);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
