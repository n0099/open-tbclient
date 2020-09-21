package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes23.dex */
public class a {
    private BdTypeListView fGf;
    public j lGn;
    private c lGo;
    public i ltw;
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private ArrayList<q> fzo = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fGf = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.ltw = new i(tbPageContext);
        this.lGn = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.lvS);
        this.lGo = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.lGn.a(this.lGo);
        this.bdV.add(this.ltw);
        this.bdV.add(this.lGn);
        this.fGf.addAdapters(this.bdV);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.fGf != null) {
            this.fzo.clear();
            this.fzo.addAll(arrayList);
            this.fGf.setData(this.fzo);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fGf.getAdapter() instanceof f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.fGf != null) {
            this.fGf.startPullRefresh();
        }
    }

    public boolean Pn(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.fGf == null || this.fzo == null) {
            return false;
        }
        Iterator<q> it = this.fzo.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            q next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && at.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.fzo = PersonPostModel.mergeDynamicThreadByTime(this.fzo);
            this.fGf.setData(this.fzo);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
