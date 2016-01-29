package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends c<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.d> {
    private com.baidu.tieba.personInfo.f cZH;
    private com.baidu.tieba.personInfo.b dad;
    private int dae;
    private int daf;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(com.baidu.tieba.personInfo.f fVar, BdUniqueId bdUniqueId) {
        super(fVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.dae = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds26);
        this.daf = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds26);
        this.cZH = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.person.b.d b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.d dVar) {
        a(dVar, view);
        if (cVar != null && this.aXE) {
            a(dVar, cVar);
            a(dVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.d dVar, com.baidu.tieba.person.data.c cVar) {
        bf avb;
        if (cVar != null && dVar != null && dVar.ddI != null && this.cZH != null && (avb = this.cZH.avb()) != null) {
            if (avb.avS() && !avb.getIsSelf()) {
                dVar.ddK.setVisibility(8);
                b(dVar);
            } else if (cVar.dbF != null && cVar.dbF.size() > 0) {
                dVar.ddK.setVisibility(0);
                dVar.ddJ.setVisibility(8);
                dVar.ddL.a(b(cVar.dbF, 2), -1, this.dad);
                dVar.ddM.a(b(cVar.dbF, 1), 1, this.dad);
                dVar.ddN.a(b(cVar.dbF, 4), -1, this.dad);
                dVar.ddO.a(b(cVar.dbF, 3), 2, this.dad);
                dVar.ddP.a(b(cVar.dbF, 0), 3, this.dad);
                dVar.ddQ.a(b(cVar.dbF, 5), -1, this.dad);
                this.cZH.avq().a(1, dVar.ddM);
                if (avb.getIsSelf() && !avb.avS()) {
                    this.cZH.avq().a(2, dVar.ddO);
                    if (this.cZH.dii > 0) {
                        this.cZH.avq().f(true, 2);
                    }
                }
                if (avb.getIsSelf()) {
                    this.cZH.avq().a(3, dVar.ddP);
                }
                if (!avb.avS()) {
                    dVar.ddK.setPadding(0, 0, 0, this.daf);
                } else {
                    dVar.ddK.setPadding(0, this.dae, 0, this.daf);
                }
            } else {
                dVar.ddK.setVisibility(8);
                dVar.ddJ.setVisibility(8);
            }
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar) {
        if (dVar != null && dVar.ddI != null && this.cZH != null) {
            bf avb = this.cZH.avb();
            if (avb != null && avb.avS()) {
                dVar.ddI.setVisibility(0);
                dVar.ddI.a(this.cZH.avb(), this.cZH.avc());
                return;
            }
            dVar.ddI.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.person.b.d dVar) {
        if (dVar != null && dVar.ddJ != null && this.cZH != null && this.cZH.avb() != null) {
            bf avb = this.cZH.avb();
            if (avb.avS() && !avb.getIsSelf()) {
                dVar.ddJ.setVisibility(0);
                dVar.ddJ.setData(avb);
                return;
            }
            dVar.ddJ.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (dVar.ahU != skinType) {
            dVar.ddL.setIcon(t.f.icon_mine_history);
            dVar.ddL.f(this.cZH.getPageContext());
            dVar.ddM.setIcon(t.f.icon_mine_collect);
            dVar.ddM.f(this.cZH.getPageContext());
            dVar.ddN.setIcon(t.f.icon_mine_follow);
            dVar.ddN.f(this.cZH.getPageContext());
            dVar.ddO.setIcon(t.f.icon_mine_fans);
            dVar.ddO.f(this.cZH.getPageContext());
            dVar.ddP.setIcon(t.f.icon_mine_friend);
            dVar.ddP.f(this.cZH.getPageContext());
            dVar.ddQ.setIcon(t.f.icon_mine_trends);
            dVar.ddQ.f(this.cZH.getPageContext());
            dVar.ddI.f(this.cZH.getPageContext());
            dVar.ddJ.f(this.cZH.getPageContext());
            ar.l(view, t.d.cp_bg_line_d);
            dVar.ahU = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        this.dad = bVar;
    }

    private com.baidu.tieba.person.data.d b(ArrayList<com.baidu.tieba.person.data.d> arrayList, int i) {
        if (com.baidu.tbadk.core.util.x.o(arrayList) > 0) {
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
