package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personExtra.e;
import com.baidu.tieba.personPolymeric.a.i;
import com.baidu.tieba.personPolymeric.a.j;
import com.baidu.tieba.personPolymeric.b.b;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private ArrayList<q> fkE = new ArrayList<>();
    private BdTypeListView frv;
    public i kUx;
    public j lgS;
    private b lgT;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.frv = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.kUx = new i(tbPageContext);
        this.lgS = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.kWT);
        this.lgT = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.lgS.a(this.lgT);
        this.aWf.add(this.kUx);
        this.aWf.add(this.lgS);
        this.frv.addAdapters(this.aWf);
    }

    public void U(ArrayList<q> arrayList) {
        if (arrayList != null && this.frv != null) {
            this.fkE.clear();
            this.fkE.addAll(arrayList);
            this.frv.setData(this.fkE);
        }
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() instanceof f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.frv != null) {
            this.frv.startPullRefresh();
        }
    }

    public boolean LS(String str) {
        boolean z;
        if (as.isEmpty(str)) {
            return false;
        }
        if (this.frv == null || this.fkE == null) {
            return false;
        }
        Iterator<q> it = this.fkE.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            q next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && as.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.fkE = PersonPostModel.mergeDynamicThreadByTime(this.fkE);
            this.frv.setData(this.fkE);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
