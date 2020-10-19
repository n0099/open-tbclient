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
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private ArrayList<q> fLx = new ArrayList<>();
    private BdTypeListView fSo;
    public i lII;
    public j lVB;
    private c lVC;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fSo = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.lII = new i(tbPageContext);
        this.lVB = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.lLe);
        this.lVC = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.lVB.a(this.lVC);
        this.bhH.add(this.lII);
        this.bhH.add(this.lVB);
        this.fSo.addAdapters(this.bhH);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.fSo != null) {
            this.fLx.clear();
            this.fLx.addAll(arrayList);
            this.fSo.setData(this.fLx);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fSo.getAdapter() instanceof f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.fSo != null) {
            this.fSo.startPullRefresh();
        }
    }

    public boolean Qc(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.fSo == null || this.fLx == null) {
            return false;
        }
        Iterator<q> it = this.fLx.iterator();
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
            this.fLx = PersonPostModel.mergeDynamicThreadByTime(this.fLx);
            this.fSo.setData(this.fLx);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
