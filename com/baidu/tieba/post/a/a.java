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
/* loaded from: classes18.dex */
public class a {
    private BdTypeListView fCP;
    public i lko;
    public j lxl;
    private c lxm;
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private ArrayList<q> fwa = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fCP = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.lko = new i(tbPageContext);
        this.lxl = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.lmK);
        this.lxm = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.lxl.a(this.lxm);
        this.bbu.add(this.lko);
        this.bbu.add(this.lxl);
        this.fCP.addAdapters(this.bbu);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.fCP != null) {
            this.fwa.clear();
            this.fwa.addAll(arrayList);
            this.fCP.setData(this.fwa);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCP.getAdapter() instanceof f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.fCP != null) {
            this.fCP.startPullRefresh();
        }
    }

    public boolean OL(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.fCP == null || this.fwa == null) {
            return false;
        }
        Iterator<q> it = this.fwa.iterator();
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
            this.fwa = PersonPostModel.mergeDynamicThreadByTime(this.fwa);
            this.fCP.setData(this.fwa);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
