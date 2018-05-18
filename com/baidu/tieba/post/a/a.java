package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
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
    public i fJi;
    public j fTR;
    private b fTS;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<h> bIV = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        p(tbPageContext);
    }

    private void p(TbPageContext<?> tbPageContext) {
        this.fJi = new i(tbPageContext);
        this.fTR = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.fLD);
        this.fTS = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.fTR.a(this.fTS);
        this.mAdapters.add(this.fJi);
        this.mAdapters.add(this.fTR);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void z(ArrayList<h> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.bIV.clear();
            this.bIV.addAll(arrayList);
            this.mListView.setData(this.bIV);
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

    public boolean rD(String str) {
        boolean z;
        if (an.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.bIV == null) {
            return false;
        }
        Iterator<h> it = this.bIV.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            h next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && an.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.bIV = PersonPostModel.mergeDynamicThreadByTime(this.bIV);
            this.mListView.setData(this.bIV);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
