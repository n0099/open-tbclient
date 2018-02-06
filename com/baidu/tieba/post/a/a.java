package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public i gnC;
    public j gxX;
    private b gxY;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<com.baidu.adp.widget.ListView.i> crH = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        o(tbPageContext);
    }

    private void o(TbPageContext<?> tbPageContext) {
        this.gnC = new i(tbPageContext);
        this.gxX = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gpT);
        this.gxY = new com.baidu.tieba.personExtra.i(tbPageContext, this, tbPageContext.getUniqueId());
        this.gxX.a(this.gxY);
        this.mAdapters.add(this.gnC);
        this.mAdapters.add(this.gxX);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void A(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.crH.clear();
            this.crH.addAll(arrayList);
            this.mListView.setData(this.crH);
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

    public boolean ru(String str) {
        boolean z;
        if (am.isEmpty(str)) {
            return false;
        }
        if (this.mListView == null || this.crH == null) {
            return false;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.crH.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && am.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.crH = PersonPostModel.mergeDynamicThreadByTime(this.crH);
            this.mListView.setData(this.crH);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
