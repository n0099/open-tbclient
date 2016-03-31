package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends c<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.d> {
    private com.baidu.tieba.personInfo.b duH;
    private int duI;
    private int duJ;
    private com.baidu.tieba.personInfo.f duk;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(com.baidu.tieba.personInfo.f fVar, BdUniqueId bdUniqueId) {
        super(fVar.getBaseFragmentActivity().getPageContext().getPageActivity(), bdUniqueId);
        this.duI = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds26);
        this.duJ = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds26);
        this.duk = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public com.baidu.tieba.person.b.d b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_enter_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.d dVar) {
        a(dVar, view);
        if (cVar != null && this.bcn) {
            a(dVar, cVar);
            a(dVar);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.d dVar, com.baidu.tieba.person.data.c cVar) {
        bf aCH;
        if (cVar != null && dVar != null && dVar.dyj != null && this.duk != null && (aCH = this.duk.aCH()) != null) {
            if (aCH.aDx() && !aCH.getIsSelf()) {
                dVar.dyl.setVisibility(8);
                b(dVar);
            } else if (cVar.dwi != null && cVar.dwi.size() > 0) {
                dVar.dyl.setVisibility(0);
                dVar.dyk.setVisibility(8);
                dVar.dym.a(b(cVar.dwi, 2), -1, this.duH);
                dVar.dyn.a(b(cVar.dwi, 1), 1, this.duH);
                dVar.dyo.a(b(cVar.dwi, 4), -1, this.duH);
                dVar.dyp.a(b(cVar.dwi, 3), 2, this.duH);
                dVar.dyq.a(b(cVar.dwi, 0), 3, this.duH);
                dVar.dyr.a(b(cVar.dwi, 5), -1, this.duH);
                this.duk.aCW().a(1, dVar.dyn);
                if (aCH.getIsSelf() && !aCH.aDx()) {
                    this.duk.aCW().a(2, dVar.dyp);
                    if (this.duk.dCK > 0) {
                        this.duk.aCW().h(true, 2);
                    }
                }
                if (aCH.getIsSelf()) {
                    this.duk.aCW().a(3, dVar.dyq);
                }
                if (!aCH.aDx()) {
                    dVar.dyl.setPadding(0, 0, 0, this.duJ);
                } else {
                    dVar.dyl.setPadding(0, this.duI, 0, this.duJ);
                }
            } else {
                dVar.dyl.setVisibility(8);
                dVar.dyk.setVisibility(8);
            }
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar) {
        if (dVar != null && dVar.dyj != null && this.duk != null) {
            bf aCH = this.duk.aCH();
            if (aCH != null && aCH.aDx()) {
                dVar.dyj.setVisibility(0);
                dVar.dyj.a(this.duk.aCH(), this.duk.aCI());
                return;
            }
            dVar.dyj.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.person.b.d dVar) {
        if (dVar != null && dVar.dyk != null && this.duk != null && this.duk.aCH() != null) {
            bf aCH = this.duk.aCH();
            if (aCH.aDx() && !aCH.getIsSelf()) {
                dVar.dyk.setVisibility(0);
                dVar.dyk.setData(aCH);
                return;
            }
            dVar.dyk.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (dVar.aik != skinType) {
            dVar.dym.setIcon(t.f.icon_mine_history);
            dVar.dym.f(this.duk.getPageContext());
            dVar.dyn.setIcon(t.f.icon_mine_collect);
            dVar.dyn.f(this.duk.getPageContext());
            dVar.dyo.setIcon(t.f.icon_mine_follow);
            dVar.dyo.f(this.duk.getPageContext());
            dVar.dyp.setIcon(t.f.icon_mine_fans);
            dVar.dyp.f(this.duk.getPageContext());
            dVar.dyq.setIcon(t.f.icon_mine_friend);
            dVar.dyq.f(this.duk.getPageContext());
            dVar.dyr.setIcon(t.f.icon_mine_trends);
            dVar.dyr.f(this.duk.getPageContext());
            dVar.dyj.f(this.duk.getPageContext());
            dVar.dyk.f(this.duk.getPageContext());
            at.l(view, t.d.cp_bg_line_d);
            dVar.aik = skinType;
        }
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        this.duH = bVar;
    }

    private com.baidu.tieba.person.data.d b(ArrayList<com.baidu.tieba.person.data.d> arrayList, int i) {
        if (com.baidu.tbadk.core.util.y.p(arrayList) > 0) {
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
