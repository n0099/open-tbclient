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
    private com.baidu.tieba.personInfo.a cQB;
    private com.baidu.tieba.personInfo.d cQj;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(com.baidu.tieba.personInfo.d dVar, BdUniqueId bdUniqueId) {
        super(dVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.cQj = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public com.baidu.tieba.person.b.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mContext).inflate(n.h.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.c cVar2) {
        a(cVar2, view);
        if (cVar != null && this.aVr) {
            a(cVar2, cVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.c cVar, com.baidu.tieba.person.data.c cVar2) {
        if (cVar2 != null && cVar2.cRR != null && cVar2.cRR.size() > 0) {
            cVar.cSy.a(b(cVar2.cRR, 2), -1, this.cQB);
            cVar.cSz.a(b(cVar2.cRR, 1), 1, this.cQB);
            cVar.cSA.a(b(cVar2.cRR, 4), -1, this.cQB);
            cVar.cSB.a(b(cVar2.cRR, 3), 2, this.cQB);
            cVar.cSC.a(b(cVar2.cRR, 0), 3, this.cQB);
            this.cQj.apZ().a(2, cVar.cSB);
            this.cQj.apZ().a(1, cVar.cSz);
            this.cQj.apZ().a(3, cVar.cSC);
        }
    }

    private void a(com.baidu.tieba.person.b.c cVar, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (cVar.ahf != skinType) {
            cVar.cSy.setIcon(n.f.icon_mine_history);
            cVar.cSy.f(this.cQj.getPageContext());
            cVar.cSz.setIcon(n.f.icon_mine_collect);
            cVar.cSz.f(this.cQj.getPageContext());
            cVar.cSA.setIcon(n.f.icon_mine_follow);
            cVar.cSA.f(this.cQj.getPageContext());
            cVar.cSB.setIcon(n.f.icon_mine_fans);
            cVar.cSB.f(this.cQj.getPageContext());
            cVar.cSC.setIcon(n.f.icon_mine_chat);
            cVar.cSC.f(this.cQj.getPageContext());
            as.j(view, n.d.cp_bg_line_d);
            cVar.ahf = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.a aVar) {
        this.cQB = aVar;
    }

    private com.baidu.tieba.person.data.d b(ArrayList<com.baidu.tieba.person.data.d> arrayList, int i) {
        if (com.baidu.tbadk.core.util.y.l(arrayList) > 0) {
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
