package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class g extends c<com.baidu.tieba.person.data.e, com.baidu.tieba.person.b.d> {
    private com.baidu.tieba.person.data.e cMk;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public com.baidu.tieba.person.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(n.g.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.e eVar, com.baidu.tieba.person.b.d dVar) {
        a(dVar, view);
        if (eVar != null && this.aRB) {
            a(dVar, eVar, view);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.d dVar, com.baidu.tieba.person.data.e eVar, View view) {
        if (eVar != null) {
            this.userId = eVar.userId;
            if (eVar.sex == 2) {
                dVar.cNY.setText(this.mContext.getResources().getString(n.i.attention_to_her));
            } else {
                dVar.cNY.setText(this.mContext.getResources().getString(n.i.attention_to_him));
            }
            if (eVar.cNr > 0) {
                dVar.cNZ.setVisibility(0);
                dVar.cNR.setVisibility(0);
                dVar.cNQ.setVisibility(4);
                dVar.cNZ.setText(new StringBuilder(String.valueOf(eVar.cNr)).toString());
            } else {
                dVar.cNZ.setVisibility(4);
                dVar.cNR.setVisibility(4);
                dVar.cNQ.setVisibility(0);
            }
            a(view, eVar);
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar, View view) {
        if (dVar.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(view, n.e.addresslist_item_bg);
            as.b(dVar.cNY, n.c.cp_cont_f, 1);
            as.b(dVar.cNZ, n.c.cp_cont_c, 1);
            as.j(dVar.line, n.c.cp_bg_line_b);
            as.j(dVar.cyG, n.c.cp_bg_line_c);
            as.b(dVar.cNQ, n.c.cp_cont_d, 1);
            as.c(dVar.cNR, n.e.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.e eVar) {
        if (eVar != null) {
            this.cMk = eVar;
            view.setOnClickListener(new h(this));
        }
    }
}
