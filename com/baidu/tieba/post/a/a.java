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
    public i gnH;
    public j gyc;
    private b gyd;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private ArrayList<com.baidu.adp.widget.ListView.i> cry = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        o(tbPageContext);
    }

    private void o(TbPageContext<?> tbPageContext) {
        this.gnH = new i(tbPageContext);
        this.gyc = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.gpY);
        this.gyd = new com.baidu.tieba.personExtra.i(tbPageContext, this, tbPageContext.getUniqueId());
        this.gyc.a(this.gyd);
        this.mAdapters.add(this.gnH);
        this.mAdapters.add(this.gyc);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void A(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (arrayList != null && this.mListView != null) {
            this.cry.clear();
            this.cry.addAll(arrayList);
            this.mListView.setData(this.cry);
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
        if (this.mListView == null || this.cry == null) {
            return false;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.cry.iterator();
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
            this.cry = PersonPostModel.mergeDynamicThreadByTime(this.cry);
            this.mListView.setData(this.cry);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
