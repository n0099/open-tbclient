package com.baidu.tieba.post.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
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
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private ArrayList<q> ffB = new ArrayList<>();
    private BdTypeListView fml;
    public i kLv;
    private b kZA;
    public j kZz;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fml = bdTypeListView;
        y(tbPageContext);
    }

    private void y(TbPageContext<?> tbPageContext) {
        this.kLv = new i(tbPageContext);
        this.kZz = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.kNU);
        this.kZA = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.kZz.a(this.kZA);
        this.aUP.add(this.kLv);
        this.aUP.add(this.kZz);
        this.fml.addAdapters(this.aUP);
    }

    public void T(ArrayList<q> arrayList) {
        if (arrayList != null && this.fml != null) {
            this.ffB.clear();
            this.ffB.addAll(arrayList);
            this.fml.setData(this.ffB);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fml.getAdapter() instanceof f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.fml != null) {
            this.fml.startPullRefresh();
        }
    }

    public boolean Lk(String str) {
        boolean z;
        if (ar.isEmpty(str)) {
            return false;
        }
        if (this.fml == null || this.ffB == null) {
            return false;
        }
        Iterator<q> it = this.ffB.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            q next = it.next();
            if ((next instanceof CardPersonDynamicThreadData) && ar.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                z = true;
                it.remove();
                break;
            }
        }
        if (z) {
            this.ffB = PersonPostModel.mergeDynamicThreadByTime(this.ffB);
            this.fml.setData(this.ffB);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
