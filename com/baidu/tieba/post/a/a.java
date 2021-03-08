package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.c;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private BdTypeListView gAY;
    public i mBC;
    public j mOG;
    private c mOH;
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private ArrayList<n> grV = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
        y(tbPageContext);
    }

    private void y(TbPageContext<?> tbPageContext) {
        this.mBC = new i(tbPageContext);
        this.mOG = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mEd);
        this.mOH = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mOG.a(this.mOH);
        this.boS.add(this.mBC);
        this.boS.add(this.mOG);
        this.gAY.addAdapters(this.boS);
    }

    public void V(ArrayList<n> arrayList) {
        if (arrayList != null && this.gAY != null) {
            this.grV.clear();
            this.grV.addAll(arrayList);
            this.gAY.setData(this.grV);
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

    public boolean QR(String str) {
        boolean z;
        if (au.isEmpty(str)) {
            return false;
        }
        if (this.gAY == null || this.grV == null) {
            return false;
        }
        Iterator<n> it = this.grV.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            n next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && au.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.grV = PersonPostModel.mergeDynamicThreadByTime(this.grV);
            this.gAY.setData(this.grV);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
