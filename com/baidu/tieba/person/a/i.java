package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.personInfo.bn;
import com.baidu.tieba.personInfo.h;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.e, com.baidu.tieba.person.holder.g> {
    private h epz;
    private com.baidu.tieba.personInfo.d eqa;
    private int eqb;
    private int eqc;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(h hVar, BdUniqueId bdUniqueId) {
        super(hVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.eqb = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds26);
        this.eqc = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds26);
        this.epz = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public com.baidu.tieba.person.holder.g a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.g(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.e eVar, com.baidu.tieba.person.holder.g gVar) {
        a(gVar, view);
        if (eVar != null && this.aNz) {
            a(gVar, eVar);
            a(gVar);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.g gVar, com.baidu.tieba.person.data.e eVar) {
        bn aPe;
        if (eVar != null && gVar != null && gVar.euu != null && this.epz != null && (aPe = this.epz.aPe()) != null) {
            if (aPe.aPU() && !aPe.getIsSelf()) {
                gVar.euw.setVisibility(8);
                b(gVar);
            } else if (eVar.erW != null && eVar.erW.size() > 0) {
                gVar.euw.setVisibility(0);
                gVar.euv.setVisibility(8);
                gVar.eux.a(b(eVar.erW, 2), -1, this.eqa);
                gVar.euy.a(b(eVar.erW, 1), 1, this.eqa);
                gVar.euz.a(b(eVar.erW, 4), -1, this.eqa);
                gVar.euA.a(b(eVar.erW, 3), 2, this.eqa);
                gVar.euB.a(b(eVar.erW, 0), 3, this.eqa);
                this.epz.aPu().a(1, gVar.euy);
                if (aPe.getIsSelf() && !aPe.aPU()) {
                    this.epz.aPu().a(2, gVar.euA);
                    if (this.epz.eAL > 0) {
                        this.epz.aPu().n(true, 2);
                    }
                }
                if (aPe.getIsSelf()) {
                    this.epz.aPu().a(3, gVar.euB);
                }
                if (!aPe.aPU()) {
                    gVar.euw.setPadding(0, 0, 0, this.eqc);
                } else {
                    gVar.euw.setPadding(0, this.eqb, 0, this.eqc);
                }
            } else {
                gVar.euw.setVisibility(8);
                gVar.euv.setVisibility(8);
            }
        }
    }

    private void a(com.baidu.tieba.person.holder.g gVar) {
        if (gVar != null && gVar.euu != null && this.epz != null) {
            bn aPe = this.epz.aPe();
            if (aPe != null && aPe.aPU()) {
                gVar.euu.setVisibility(0);
                gVar.euu.a(this.epz.aPe(), this.epz.aPf());
                return;
            }
            gVar.euu.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.person.holder.g gVar) {
        if (gVar != null && gVar.euv != null && this.epz != null && this.epz.aPe() != null) {
            bn aPe = this.epz.aPe();
            if (aPe.aPU() && !aPe.getIsSelf()) {
                gVar.euv.setVisibility(0);
                gVar.euv.setData(aPe);
                return;
            }
            gVar.euv.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.person.holder.g gVar, View view) {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (gVar.afy != skinType) {
            gVar.eux.setIcon(u.f.icon_mine_history);
            gVar.eux.n(this.epz.getPageContext());
            gVar.euy.setIcon(u.f.icon_mine_collect);
            gVar.euy.n(this.epz.getPageContext());
            gVar.euz.setIcon(u.f.icon_mine_follow);
            gVar.euz.n(this.epz.getPageContext());
            gVar.euA.setIcon(u.f.icon_mine_fans);
            gVar.euA.n(this.epz.getPageContext());
            gVar.euB.setIcon(u.f.icon_mine_friend);
            gVar.euB.n(this.epz.getPageContext());
            gVar.euu.n(this.epz.getPageContext());
            gVar.euv.n(this.epz.getPageContext());
            av.l(view, u.d.cp_bg_line_d);
            gVar.afy = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.d dVar) {
        this.eqa = dVar;
    }

    private com.baidu.tieba.person.data.f b(ArrayList<com.baidu.tieba.person.data.f> arrayList, int i) {
        if (com.baidu.tbadk.core.util.y.s(arrayList) > 0) {
            Iterator<com.baidu.tieba.person.data.f> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.person.data.f next = it.next();
                if (next != null && next.mType == i) {
                    return next;
                }
            }
        }
        return null;
    }
}
