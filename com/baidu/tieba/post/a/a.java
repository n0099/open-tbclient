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
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private ArrayList<m> eIA = new ArrayList<>();
    private BdTypeListView eOe;
    public i jYv;
    public j kmw;
    private b kmx;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eOe = bdTypeListView;
        v(tbPageContext);
    }

    private void v(TbPageContext<?> tbPageContext) {
        this.jYv = new i(tbPageContext);
        this.kmw = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.kaV);
        this.kmx = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.kmw.a(this.kmx);
        this.aMd.add(this.jYv);
        this.aMd.add(this.kmw);
        this.eOe.addAdapters(this.aMd);
    }

    public void T(ArrayList<m> arrayList) {
        if (arrayList != null && this.eOe != null) {
            this.eIA.clear();
            this.eIA.addAll(arrayList);
            this.eOe.setData(this.eIA);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.eOe != null) {
            this.eOe.startPullRefresh();
        }
    }

    public boolean IT(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.eOe == null || this.eIA == null) {
            return false;
        }
        Iterator<m> it = this.eIA.iterator();
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
            this.eIA = PersonPostModel.mergeDynamicThreadByTime(this.eIA);
            this.eOe.setData(this.eIA);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
