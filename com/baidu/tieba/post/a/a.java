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
    private BdTypeListView fCT;
    public i lkz;
    public j lxw;
    private c lxx;
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private ArrayList<q> fwe = new ArrayList<>();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fCT = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.lkz = new i(tbPageContext);
        this.lxw = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.lmV);
        this.lxx = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.lxw.a(this.lxx);
        this.bbw.add(this.lkz);
        this.bbw.add(this.lxw);
        this.fCT.addAdapters(this.bbw);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.fCT != null) {
            this.fwe.clear();
            this.fwe.addAll(arrayList);
            this.fCT.setData(this.fwe);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCT.getAdapter() instanceof f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.fCT != null) {
            this.fCT.startPullRefresh();
        }
    }

    public boolean OM(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.fCT == null || this.fwe == null) {
            return false;
        }
        Iterator<q> it = this.fwe.iterator();
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
            this.fwe = PersonPostModel.mergeDynamicThreadByTime(this.fwe);
            this.fCT.setData(this.fwe);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
