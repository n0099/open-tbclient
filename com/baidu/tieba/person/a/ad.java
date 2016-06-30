package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.q, com.baidu.tieba.person.b.n> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ad(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public com.baidu.tieba.person.b.n a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.n(LayoutInflater.from(this.mContext).inflate(u.h.person_info_togetherhi_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.q qVar, com.baidu.tieba.person.b.n nVar) {
        a(nVar, view);
        if (qVar != null && this.aMF) {
            bb(view);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.n nVar, View view) {
        if (nVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(view, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(nVar.bLB, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(nVar.dpJ, u.f.icon_mine_hi);
            com.baidu.tbadk.core.util.av.c(nVar.ekh, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.j((View) nVar.ekg, u.d.cp_cont_f);
        }
    }

    private void bb(View view) {
        view.setOnClickListener(new ae(this));
    }
}
