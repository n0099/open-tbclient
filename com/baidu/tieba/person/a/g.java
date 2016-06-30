package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personInfo.bp;
import com.baidu.tieba.personInfo.f;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.d, com.baidu.tieba.person.b.e> {
    private com.baidu.tieba.personInfo.b efZ;
    private f efz;
    private int ega;
    private int egb;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(f fVar, BdUniqueId bdUniqueId) {
        super(fVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.ega = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds26);
        this.egb = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds26);
        this.efz = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public com.baidu.tieba.person.b.e a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.d dVar, com.baidu.tieba.person.b.e eVar) {
        a(eVar, view);
        if (dVar != null && this.aMF) {
            a(eVar, dVar);
            a(eVar);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.d dVar) {
        bp aLZ;
        if (dVar != null && eVar != null && eVar.ejU != null && this.efz != null && (aLZ = this.efz.aLZ()) != null) {
            if (aLZ.aMR() && !aLZ.getIsSelf()) {
                eVar.ejW.setVisibility(8);
                b(eVar);
            } else if (dVar.ehQ != null && dVar.ehQ.size() > 0) {
                eVar.ejW.setVisibility(0);
                eVar.ejV.setVisibility(8);
                eVar.ejX.a(b(dVar.ehQ, 2), -1, this.efZ);
                eVar.ejY.a(b(dVar.ehQ, 1), 1, this.efZ);
                eVar.ejZ.a(b(dVar.ehQ, 4), -1, this.efZ);
                eVar.eka.a(b(dVar.ehQ, 3), 2, this.efZ);
                eVar.ekb.a(b(dVar.ehQ, 0), 3, this.efZ);
                eVar.ekc.a(b(dVar.ehQ, 5), -1, this.efZ);
                this.efz.aMp().a(1, eVar.ejY);
                if (aLZ.getIsSelf() && !aLZ.aMR()) {
                    this.efz.aMp().a(2, eVar.eka);
                    if (this.efz.eoV > 0) {
                        this.efz.aMp().m(true, 2);
                    }
                }
                if (aLZ.getIsSelf()) {
                    this.efz.aMp().a(3, eVar.ekb);
                }
                if (!aLZ.aMR()) {
                    eVar.ejW.setPadding(0, 0, 0, this.egb);
                } else {
                    eVar.ejW.setPadding(0, this.ega, 0, this.egb);
                }
            } else {
                eVar.ejW.setVisibility(8);
                eVar.ejV.setVisibility(8);
            }
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar) {
        if (eVar != null && eVar.ejU != null && this.efz != null) {
            bp aLZ = this.efz.aLZ();
            if (aLZ != null && aLZ.aMR()) {
                eVar.ejU.setVisibility(0);
                eVar.ejU.a(this.efz.aLZ(), this.efz.aMa());
                return;
            }
            eVar.ejU.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.person.b.e eVar) {
        if (eVar != null && eVar.ejV != null && this.efz != null && this.efz.aLZ() != null) {
            bp aLZ = this.efz.aLZ();
            if (aLZ.aMR() && !aLZ.getIsSelf()) {
                eVar.ejV.setVisibility(0);
                eVar.ejV.setData(aLZ);
                return;
            }
            eVar.ejV.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar, View view) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (eVar.aeK != skinType) {
            eVar.ejX.setIcon(u.f.icon_mine_history);
            eVar.ejX.n(this.efz.getPageContext());
            eVar.ejY.setIcon(u.f.icon_mine_collect);
            eVar.ejY.n(this.efz.getPageContext());
            eVar.ejZ.setIcon(u.f.icon_mine_follow);
            eVar.ejZ.n(this.efz.getPageContext());
            eVar.eka.setIcon(u.f.icon_mine_fans);
            eVar.eka.n(this.efz.getPageContext());
            eVar.ekb.setIcon(u.f.icon_mine_friend);
            eVar.ekb.n(this.efz.getPageContext());
            eVar.ekc.setIcon(u.f.icon_mine_trends);
            eVar.ekc.n(this.efz.getPageContext());
            eVar.ejU.n(this.efz.getPageContext());
            eVar.ejV.n(this.efz.getPageContext());
            com.baidu.tbadk.core.util.av.l(view, u.d.cp_bg_line_d);
            eVar.aeK = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        this.efZ = bVar;
    }

    private com.baidu.tieba.person.data.e b(ArrayList<com.baidu.tieba.person.data.e> arrayList, int i) {
        if (com.baidu.tbadk.core.util.y.s(arrayList) > 0) {
            Iterator<com.baidu.tieba.person.data.e> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.person.data.e next = it.next();
                if (next != null && next.mType == i) {
                    return next;
                }
            }
        }
        return null;
    }
}
