package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.d> {
    private com.baidu.tieba.person.data.c efX;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public com.baidu.tieba.person.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.d dVar) {
        a(dVar, view);
        if (cVar != null && this.aMF) {
            a(dVar, cVar, view);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.d dVar, com.baidu.tieba.person.data.c cVar, View view) {
        if (cVar != null) {
            this.userId = cVar.userId;
            dVar.ejQ.setText(this.mContext.getResources().getString(u.j.attention_other));
            if (cVar.ehO > 0) {
                dVar.ejS.setVisibility(4);
                dVar.ejR.setVisibility(0);
                dVar.ejT.setVisibility(0);
                dVar.ejR.setText(new StringBuilder(String.valueOf(cVar.ehO)).toString());
            } else {
                dVar.ejS.setVisibility(0);
                dVar.ejR.setVisibility(4);
                dVar.ejT.setVisibility(4);
            }
            a(view, cVar);
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar, View view) {
        if (dVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(view, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(dVar.ejQ, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(dVar.ejR, u.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.av.c(dVar.ejS, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(dVar.ejT, u.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.efX = cVar;
            view.setOnClickListener(new e(this));
        }
    }
}
