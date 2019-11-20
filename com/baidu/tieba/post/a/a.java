package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeListView duK;
    public j iBY;
    private b iBZ;
    public i ipG;
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private ArrayList<m> hNx = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.duK = bdTypeListView;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.ipG = new i(tbPageContext);
        this.iBY = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.irQ);
        this.iBZ = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.iBY.a(this.iBZ);
        this.agy.add(this.ipG);
        this.agy.add(this.iBY);
        this.duK.addAdapters(this.agy);
    }

    public void K(ArrayList<m> arrayList) {
        if (arrayList != null && this.duK != null) {
            this.hNx.clear();
            this.hNx.addAll(arrayList);
            this.duK.setData(this.hNx);
        }
    }

    public void notifyDataSetChanged() {
        if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.duK != null) {
            this.duK.startPullRefresh();
        }
    }

    public boolean Cb(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.duK == null || this.hNx == null) {
            return false;
        }
        Iterator<m> it = this.hNx.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            m next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && aq.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.hNx = PersonPostModel.mergeDynamicThreadByTime(this.hNx);
            this.duK.setData(this.hNx);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
