package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.c;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private BdTypeListView gAY;
    public j mHP;
    private c mHQ;
    public i muP;
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private ArrayList<n> grW = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
        w(tbPageContext);
    }

    private void w(TbPageContext<?> tbPageContext) {
        this.muP = new i(tbPageContext);
        this.mHP = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mxm);
        this.mHQ = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mHP.a(this.mHQ);
        this.boM.add(this.muP);
        this.boM.add(this.mHP);
        this.gAY.addAdapters(this.boM);
    }

    public void ab(ArrayList<n> arrayList) {
        if (arrayList != null && this.gAY != null) {
            this.grW.clear();
            this.grW.addAll(arrayList);
            this.gAY.setData(this.grW);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gAY != null) {
            this.gAY.startPullRefresh();
        }
    }

    public boolean Ra(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.gAY == null || this.grW == null) {
            return false;
        }
        Iterator<n> it = this.grW.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            n next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && at.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.grW = PersonPostModel.mergeDynamicThreadByTime(this.grW);
            this.gAY.setData(this.grW);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
