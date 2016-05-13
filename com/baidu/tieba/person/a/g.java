package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personInfo.bg;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends c<com.baidu.tieba.person.data.d, com.baidu.tieba.person.b.e> {
    private com.baidu.tieba.personInfo.b dxD;
    private int dxE;
    private int dxF;
    private com.baidu.tieba.personInfo.f dxd;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(com.baidu.tieba.personInfo.f fVar, BdUniqueId bdUniqueId) {
        super(fVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.dxE = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds26);
        this.dxF = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds26);
        this.dxd = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.tieba.person.b.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.d dVar, com.baidu.tieba.person.b.e eVar) {
        a(eVar, view);
        if (dVar != null && this.bUL) {
            a(eVar, dVar);
            a(eVar);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.d dVar) {
        bg aDe;
        if (dVar != null && eVar != null && eVar.dBr != null && this.dxd != null && (aDe = this.dxd.aDe()) != null) {
            if (aDe.aDW() && !aDe.getIsSelf()) {
                eVar.dBt.setVisibility(8);
                b(eVar);
            } else if (dVar.dzm != null && dVar.dzm.size() > 0) {
                eVar.dBt.setVisibility(0);
                eVar.dBs.setVisibility(8);
                eVar.dBu.a(b(dVar.dzm, 2), -1, this.dxD);
                eVar.dBv.a(b(dVar.dzm, 1), 1, this.dxD);
                eVar.dBw.a(b(dVar.dzm, 4), -1, this.dxD);
                eVar.dBx.a(b(dVar.dzm, 3), 2, this.dxD);
                eVar.dBy.a(b(dVar.dzm, 0), 3, this.dxD);
                eVar.dBz.a(b(dVar.dzm, 5), -1, this.dxD);
                this.dxd.aDu().a(1, eVar.dBv);
                if (aDe.getIsSelf() && !aDe.aDW()) {
                    this.dxd.aDu().a(2, eVar.dBx);
                    if (this.dxd.dFR > 0) {
                        this.dxd.aDu().j(true, 2);
                    }
                }
                if (aDe.getIsSelf()) {
                    this.dxd.aDu().a(3, eVar.dBy);
                }
                if (!aDe.aDW()) {
                    eVar.dBt.setPadding(0, 0, 0, this.dxF);
                } else {
                    eVar.dBt.setPadding(0, this.dxE, 0, this.dxF);
                }
            } else {
                eVar.dBt.setVisibility(8);
                eVar.dBs.setVisibility(8);
            }
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar) {
        if (eVar != null && eVar.dBr != null && this.dxd != null) {
            bg aDe = this.dxd.aDe();
            if (aDe != null && aDe.aDW()) {
                eVar.dBr.setVisibility(0);
                eVar.dBr.a(this.dxd.aDe(), this.dxd.aDf());
                return;
            }
            eVar.dBr.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.person.b.e eVar) {
        if (eVar != null && eVar.dBs != null && this.dxd != null && this.dxd.aDe() != null) {
            bg aDe = this.dxd.aDe();
            if (aDe.aDW() && !aDe.getIsSelf()) {
                eVar.dBs.setVisibility(0);
                eVar.dBs.setData(aDe);
                return;
            }
            eVar.dBs.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar, View view) {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (eVar.aej != skinType) {
            eVar.dBu.setIcon(t.f.icon_mine_history);
            eVar.dBu.g(this.dxd.getPageContext());
            eVar.dBv.setIcon(t.f.icon_mine_collect);
            eVar.dBv.g(this.dxd.getPageContext());
            eVar.dBw.setIcon(t.f.icon_mine_follow);
            eVar.dBw.g(this.dxd.getPageContext());
            eVar.dBx.setIcon(t.f.icon_mine_fans);
            eVar.dBx.g(this.dxd.getPageContext());
            eVar.dBy.setIcon(t.f.icon_mine_friend);
            eVar.dBy.g(this.dxd.getPageContext());
            eVar.dBz.setIcon(t.f.icon_mine_trends);
            eVar.dBz.g(this.dxd.getPageContext());
            eVar.dBr.g(this.dxd.getPageContext());
            eVar.dBs.g(this.dxd.getPageContext());
            com.baidu.tbadk.core.util.at.l(view, t.d.cp_bg_line_d);
            eVar.aej = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        this.dxD = bVar;
    }

    private com.baidu.tieba.person.data.e b(ArrayList<com.baidu.tieba.person.data.e> arrayList, int i) {
        if (com.baidu.tbadk.core.util.y.r(arrayList) > 0) {
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
