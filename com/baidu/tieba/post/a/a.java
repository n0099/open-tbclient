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
    private ArrayList<q> ghw = new ArrayList<>();
    private BdTypeListView gpX;
    public j mCx;
    private c mCy;
    public i mpB;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gpX = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.mpB = new i(tbPageContext);
        this.mCx = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mrX);
        this.mCy = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mCx.a(this.mCy);
        this.bnf.add(this.mpB);
        this.bnf.add(this.mCx);
        this.gpX.addAdapters(this.bnf);
    }

    public void ab(ArrayList<q> arrayList) {
        if (arrayList != null && this.gpX != null) {
            this.ghw.clear();
            this.ghw.addAll(arrayList);
            this.gpX.setData(this.ghw);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpX.getAdapter() instanceof f) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gpX != null) {
            this.gpX.startPullRefresh();
        }
    }

    public boolean Rv(String str) {
        boolean z;
        if (au.isEmpty(str)) {
            return false;
        }
        if (this.gpX == null || this.ghw == null) {
            return false;
        }
        Iterator<q> it = this.ghw.iterator();
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
            this.ghw = PersonPostModel.mergeDynamicThreadByTime(this.ghw);
            this.gpX.setData(this.ghw);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
