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
    public i fIf;
    public j fSO;
    private b fSP;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<h> bHH = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        o(tbPageContext);
    }

    private void o(TbPageContext<?> tbPageContext) {
        this.fIf = new i(tbPageContext);
        this.fSO = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.fKA);
        this.fSP = new d(tbPageContext, this, tbPageContext.getUniqueId());
        this.fSO.a(this.fSP);
        this.mAdapters.add(this.fIf);
        this.mAdapters.add(this.fSO);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void z(ArrayList<h> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.bHH.clear();
            this.bHH.addAll(arrayList);
            this.mListView.setData(this.bHH);
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

    public boolean rA(String str) {
        boolean z;
        if (an.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.bHH == null) {
            return false;
        }
        Iterator<h> it = this.bHH.iterator();
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
            this.bHH = PersonPostModel.mergeDynamicThreadByTime(this.bHH);
            this.mListView.setData(this.bHH);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
