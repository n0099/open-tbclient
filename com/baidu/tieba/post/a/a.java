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
    private BdTypeListView dvB;
    public j iCP;
    private b iCQ;
    public i iqx;
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private ArrayList<m> hOo = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dvB = bdTypeListView;
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.iqx = new i(tbPageContext);
        this.iCP = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.isH);
        this.iCQ = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.iCP.a(this.iCQ);
        this.agQ.add(this.iqx);
        this.agQ.add(this.iCP);
        this.dvB.addAdapters(this.agQ);
    }

    public void K(ArrayList<m> arrayList) {
        if (arrayList != null && this.dvB != null) {
            this.hOo.clear();
            this.hOo.addAll(arrayList);
            this.dvB.setData(this.hOo);
        }
    }

    public void notifyDataSetChanged() {
        if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.dvB != null) {
            this.dvB.startPullRefresh();
        }
    }

    public boolean Cb(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.dvB == null || this.hOo == null) {
            return false;
        }
        Iterator<m> it = this.hOo.iterator();
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
            this.hOo = PersonPostModel.mergeDynamicThreadByTime(this.hOo);
            this.dvB.setData(this.hOo);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
