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
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private ArrayList<m> eIF = new ArrayList<>();
    private BdTypeListView eOj;
    public i jYz;
    public j kmA;
    private b kmB;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eOj = bdTypeListView;
        v(tbPageContext);
    }

    private void v(TbPageContext<?> tbPageContext) {
        this.jYz = new i(tbPageContext);
        this.kmA = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.kaZ);
        this.kmB = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.kmA.a(this.kmB);
        this.aMj.add(this.jYz);
        this.aMj.add(this.kmA);
        this.eOj.addAdapters(this.aMj);
    }

    public void T(ArrayList<m> arrayList) {
        if (arrayList != null && this.eOj != null) {
            this.eIF.clear();
            this.eIF.addAll(arrayList);
            this.eOj.setData(this.eIF);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.eOj != null) {
            this.eOj.startPullRefresh();
        }
    }

    public boolean IW(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.eOj == null || this.eIF == null) {
            return false;
        }
        Iterator<m> it = this.eIF.iterator();
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
            this.eIF = PersonPostModel.mergeDynamicThreadByTime(this.eIF);
            this.eOj.setData(this.eIF);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
