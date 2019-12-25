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
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private ArrayList<m> eea = new ArrayList<>();
    private BdTypeListView efM;
    public i jhT;
    public j jwh;
    private b jwi;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.efM = bdTypeListView;
        s(tbPageContext);
    }

    private void s(TbPageContext<?> tbPageContext) {
        this.jhT = new i(tbPageContext);
        this.jwh = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.jks);
        this.jwi = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.jwh.a(this.jwi);
        this.aoz.add(this.jhT);
        this.aoz.add(this.jwh);
        this.efM.addAdapters(this.aoz);
    }

    public void Q(ArrayList<m> arrayList) {
        if (arrayList != null && this.efM != null) {
            this.eea.clear();
            this.eea.addAll(arrayList);
            this.efM.setData(this.eea);
        }
    }

    public void notifyDataSetChanged() {
        if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.efM != null) {
            this.efM.startPullRefresh();
        }
    }

    public boolean GN(String str) {
        boolean z;
        if (aq.isEmpty(str)) {
            return false;
        }
        if (this.efM == null || this.eea == null) {
            return false;
        }
        Iterator<m> it = this.eea.iterator();
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
            this.eea = PersonPostModel.mergeDynamicThreadByTime(this.eea);
            this.efM.setData(this.eea);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
