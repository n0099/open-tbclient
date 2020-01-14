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
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private ArrayList<m> eei = new ArrayList<>();
    private BdTypeListView efW;
    public i jlA;
    public j jzO;
    private b jzP;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.efW = bdTypeListView;
        s(tbPageContext);
    }

    private void s(TbPageContext<?> tbPageContext) {
        this.jlA = new i(tbPageContext);
        this.jzO = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.jnZ);
        this.jzP = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.jzO.a(this.jzP);
        this.apl.add(this.jlA);
        this.apl.add(this.jzO);
        this.efW.addAdapters(this.apl);
    }

    public void Q(ArrayList<m> arrayList) {
        if (arrayList != null && this.efW != null) {
            this.eei.clear();
            this.eei.addAll(arrayList);
            this.efW.setData(this.eei);
        }
    }

    public void notifyDataSetChanged() {
        if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.efW != null) {
            this.efW.startPullRefresh();
        }
    }

    public boolean GX(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.efW == null || this.eei == null) {
            return false;
        }
        Iterator<m> it = this.eei.iterator();
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
            this.eei = PersonPostModel.mergeDynamicThreadByTime(this.eei);
            this.efW.setData(this.eei);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
