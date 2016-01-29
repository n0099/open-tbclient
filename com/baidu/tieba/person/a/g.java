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
public class g extends c<com.baidu.tieba.person.data.e, com.baidu.tieba.person.b.e> {
    private com.baidu.tieba.person.data.e dag;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public com.baidu.tieba.person.b.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.e eVar, com.baidu.tieba.person.b.e eVar2) {
        a(eVar2, view);
        if (eVar != null && this.aXE) {
            a(eVar2, eVar, view);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.e eVar2, View view) {
        if (eVar2 != null) {
            this.userId = eVar2.userId;
            if (eVar2.sex == 2) {
                eVar.ddS.setText(this.mContext.getResources().getString(t.j.attention_to_her));
            } else {
                eVar.ddS.setText(this.mContext.getResources().getString(t.j.attention_to_him));
            }
            if (eVar2.dbJ > 0) {
                eVar.ddT.setVisibility(0);
                eVar.ddH.setVisibility(0);
                eVar.ddG.setVisibility(4);
                eVar.ddT.setText(new StringBuilder(String.valueOf(eVar2.dbJ)).toString());
            } else {
                eVar.ddT.setVisibility(4);
                eVar.ddH.setVisibility(4);
                eVar.ddG.setVisibility(0);
            }
            a(view, eVar2);
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar, View view) {
        if (eVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(view, t.f.addresslist_item_bg);
            ar.b(eVar.ddS, t.d.cp_cont_f, 1);
            ar.b(eVar.ddT, t.d.cp_cont_c, 1);
            ar.l(eVar.aHm, t.d.cp_bg_line_b);
            ar.l(eVar.aOS, t.d.cp_bg_line_c);
            ar.b(eVar.ddG, t.d.cp_cont_d, 1);
            ar.c(eVar.ddH, t.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.e eVar) {
        if (eVar != null) {
            this.dag = eVar;
            view.setOnClickListener(new h(this));
        }
    }
}
