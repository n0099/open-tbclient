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
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private ArrayList<q> fZE = new ArrayList<>();
    private BdTypeListView gih;
    public i mbd;
    public j mnY;
    private c mnZ;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gih = bdTypeListView;
        x(tbPageContext);
    }

    private void x(TbPageContext<?> tbPageContext) {
        this.mbd = new i(tbPageContext);
        this.mnY = new j(tbPageContext, com.baidu.tieba.personPolymeric.c.j.mdz);
        this.mnZ = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.mnY.a(this.mnZ);
        this.bky.add(this.mbd);
        this.bky.add(this.mnY);
        this.gih.addAdapters(this.bky);
    }

    public void aa(ArrayList<q> arrayList) {
        if (arrayList != null && this.gih != null) {
            this.fZE.clear();
            this.fZE.addAll(arrayList);
            this.gih.setData(this.fZE);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gih.getAdapter() instanceof f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void startPullRefresh() {
        if (this.gih != null) {
            this.gih.startPullRefresh();
        }
    }

    public boolean QR(String str) {
        boolean z;
        if (at.isEmpty(str)) {
            return false;
        }
        if (this.gih == null || this.fZE == null) {
            return false;
        }
        Iterator<q> it = this.fZE.iterator();
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
            this.fZE = PersonPostModel.mergeDynamicThreadByTime(this.fZE);
            this.gih.setData(this.fZE);
            notifyDataSetChanged();
            return z;
        }
        return z;
    }
}
