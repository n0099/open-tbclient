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
    private com.baidu.tieba.person.data.e cQC;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public com.baidu.tieba.person.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(n.h.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.e eVar, com.baidu.tieba.person.b.d dVar) {
        a(dVar, view);
        if (eVar != null && this.aVr) {
            a(dVar, eVar, view);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.d dVar, com.baidu.tieba.person.data.e eVar, View view) {
        if (eVar != null) {
            this.userId = eVar.userId;
            if (eVar.sex == 2) {
                dVar.cSE.setText(this.mContext.getResources().getString(n.j.attention_to_her));
            } else {
                dVar.cSE.setText(this.mContext.getResources().getString(n.j.attention_to_him));
            }
            if (eVar.cRV > 0) {
                dVar.cSF.setVisibility(0);
                dVar.cSx.setVisibility(0);
                dVar.cSw.setVisibility(4);
                dVar.cSF.setText(new StringBuilder(String.valueOf(eVar.cRV)).toString());
            } else {
                dVar.cSF.setVisibility(4);
                dVar.cSx.setVisibility(4);
                dVar.cSw.setVisibility(0);
            }
            a(view, eVar);
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar, View view) {
        if (dVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(view, n.f.addresslist_item_bg);
            as.b(dVar.cSE, n.d.cp_cont_f, 1);
            as.b(dVar.cSF, n.d.cp_cont_c, 1);
            as.j(dVar.line, n.d.cp_bg_line_b);
            as.j(dVar.aPe, n.d.cp_bg_line_c);
            as.b(dVar.cSw, n.d.cp_cont_d, 1);
            as.c(dVar.cSx, n.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.e eVar) {
        if (eVar != null) {
            this.cQC = eVar;
            view.setOnClickListener(new h(this));
        }
    }
}
