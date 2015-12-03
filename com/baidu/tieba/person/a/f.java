package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends c<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.c> {
    private com.baidu.tieba.personInfo.d cLT;
    private com.baidu.tieba.personInfo.a cMj;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(com.baidu.tieba.personInfo.d dVar, BdUniqueId bdUniqueId) {
        super(dVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.cLT = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public com.baidu.tieba.person.b.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mContext).inflate(n.g.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.c cVar2) {
        a(cVar2, view);
        if (cVar != null && this.aRB) {
            a(cVar2, cVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.c cVar, com.baidu.tieba.person.data.c cVar2) {
        if (cVar2 != null && cVar2.cNn != null && cVar2.cNn.size() > 0) {
            cVar.cNS.a(a(cVar2.cNn, 2), -1, this.cMj);
            cVar.cNT.a(a(cVar2.cNn, 1), 1, this.cMj);
            cVar.cNU.a(a(cVar2.cNn, 4), -1, this.cMj);
            cVar.cNV.a(a(cVar2.cNn, 3), 2, this.cMj);
            cVar.cNW.a(a(cVar2.cNn, 0), 3, this.cMj);
            this.cLT.aoO().a(2, cVar.cNV);
            this.cLT.aoO().a(1, cVar.cNT);
            this.cLT.aoO().a(3, cVar.cNW);
        }
    }

    private void a(com.baidu.tieba.person.b.c cVar, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (cVar.afY != skinType) {
            cVar.cNS.setIcon(n.e.icon_mine_history);
            cVar.cNS.f(this.cLT.getPageContext());
            cVar.cNT.setIcon(n.e.icon_mine_collect);
            cVar.cNT.f(this.cLT.getPageContext());
            cVar.cNU.setIcon(n.e.icon_mine_follow);
            cVar.cNU.f(this.cLT.getPageContext());
            cVar.cNV.setIcon(n.e.icon_mine_fans);
            cVar.cNV.f(this.cLT.getPageContext());
            cVar.cNW.setIcon(n.e.icon_mine_chat);
            cVar.cNW.f(this.cLT.getPageContext());
            as.j(view, n.c.cp_bg_line_d);
            cVar.afY = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.a aVar) {
        this.cMj = aVar;
    }

    private com.baidu.tieba.person.data.d a(ArrayList<com.baidu.tieba.person.data.d> arrayList, int i) {
        if (com.baidu.tbadk.core.util.y.k(arrayList) > 0) {
            Iterator<com.baidu.tieba.person.data.d> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.person.data.d next = it.next();
                if (next != null && next.mType == i) {
                    return next;
                }
            }
        }
        return null;
    }
}
