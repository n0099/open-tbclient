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
/* loaded from: classes23.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private ArrayList<q> fZl = new ArrayList<>();
    private BdTypeListView ghN;
    public i mbv;
    public j mot;
    private c mou;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ghN = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.mbv = new i(tbPageContext);
        this.mot = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mdR);
        this.mou = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mot.a(this.mou);
        this.biN.add(this.mbv);
        this.biN.add(this.mot);
        this.ghN.addAdapters(this.biN);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.ghN != null) {
            this.fZl.clear();
            this.fZl.addAll(arrayList);
            this.ghN.setData(this.fZl);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ghN.getAdapter() instanceof f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.ghN != null) {
            this.ghN.startPullRefresh();
        }
    }

    public boolean Qm(String str) {
        boolean z;
        if (au.isEmpty(str)) {
            return false;
        }
        if (this.ghN == null || this.fZl == null) {
            return false;
        }
        Iterator<q> it = this.fZl.iterator();
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
            this.fZl = PersonPostModel.mergeDynamicThreadByTime(this.fZl);
            this.ghN.setData(this.fZl);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
