package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private ArrayList<q> ghy = new ArrayList<>();
    private BdTypeListView gpZ;
    private c mCA;
    public j mCz;
    public i mpD;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gpZ = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.mpD = new i(tbPageContext);
        this.mCz = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mrZ);
        this.mCA = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mCz.a(this.mCA);
        this.bnf.add(this.mpD);
        this.bnf.add(this.mCz);
        this.gpZ.addAdapters(this.bnf);
    }

    public void ab(ArrayList<q> arrayList) {
        if (arrayList != null && this.gpZ != null) {
            this.ghy.clear();
            this.ghy.addAll(arrayList);
            this.gpZ.setData(this.ghy);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpZ.getAdapter() instanceof f) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gpZ != null) {
            this.gpZ.startPullRefresh();
        }
    }

    public boolean Rv(String str) {
        boolean z;
        if (au.isEmpty(str)) {
            return false;
        }
        if (this.gpZ == null || this.ghy == null) {
            return false;
        }
        Iterator<q> it = this.ghy.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            q next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && au.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.ghy = PersonPostModel.mergeDynamicThreadByTime(this.ghy);
            this.gpZ.setData(this.ghy);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
