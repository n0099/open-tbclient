package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ad extends c<com.baidu.tieba.person.data.q, com.baidu.tieba.person.b.n> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ad(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public com.baidu.tieba.person.b.n b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.n(LayoutInflater.from(this.mContext).inflate(t.h.person_info_togetherhi_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.q qVar, com.baidu.tieba.person.b.n nVar) {
        a(nVar, view);
        if (qVar != null && this.bUL) {
            aT(view);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.n nVar, View view) {
        if (nVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(nVar.biC, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(nVar.cJU, t.f.icon_mine_hi);
            com.baidu.tbadk.core.util.at.c(nVar.dBE, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.j((View) nVar.dBD, t.d.cp_cont_f);
        }
    }

    private void aT(View view) {
        view.setOnClickListener(new ae(this));
    }
}
