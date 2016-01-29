package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends c<com.baidu.tieba.person.data.b, com.baidu.tieba.person.b.c> {
    private com.baidu.tieba.person.data.b dab;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.person.b.c b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.b.c cVar) {
        a(cVar, view);
        if (bVar != null && this.aXE) {
            a(cVar, bVar, view);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.c cVar, com.baidu.tieba.person.data.b bVar, View view) {
        if (bVar != null) {
            this.userId = bVar.userId;
            cVar.ddE.setText(this.mContext.getResources().getString(t.j.attention_other));
            if (bVar.dbD > 0) {
                cVar.ddG.setVisibility(4);
                cVar.ddF.setVisibility(0);
                cVar.ddH.setVisibility(0);
                cVar.ddF.setText(new StringBuilder(String.valueOf(bVar.dbD)).toString());
            } else {
                cVar.ddG.setVisibility(0);
                cVar.ddF.setVisibility(4);
                cVar.ddH.setVisibility(4);
            }
            a(view, bVar);
        }
    }

    private void a(com.baidu.tieba.person.b.c cVar, View view) {
        if (cVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(view, t.f.addresslist_item_bg);
            ar.b(cVar.ddE, t.d.cp_cont_f, 1);
            ar.b(cVar.ddF, t.d.cp_cont_c, 1);
            ar.b(cVar.ddG, t.d.cp_cont_d, 1);
            ar.c(cVar.ddH, t.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.dab = bVar;
            view.setOnClickListener(new e(this));
        }
    }
}
