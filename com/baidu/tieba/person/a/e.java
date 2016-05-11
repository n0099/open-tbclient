package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends c<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.d> {
    private com.baidu.tieba.person.data.c dxB;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.person.b.d b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.d(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.d dVar) {
        a(dVar, view);
        if (cVar != null && this.bUL) {
            a(dVar, cVar, view);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.d dVar, com.baidu.tieba.person.data.c cVar, View view) {
        if (cVar != null) {
            this.userId = cVar.userId;
            dVar.dBn.setText(this.mContext.getResources().getString(t.j.attention_other));
            if (cVar.dzk > 0) {
                dVar.dBp.setVisibility(4);
                dVar.dBo.setVisibility(0);
                dVar.dBq.setVisibility(0);
                dVar.dBo.setText(new StringBuilder(String.valueOf(cVar.dzk)).toString());
            } else {
                dVar.dBp.setVisibility(0);
                dVar.dBo.setVisibility(4);
                dVar.dBq.setVisibility(4);
            }
            a(view, cVar);
        }
    }

    private void a(com.baidu.tieba.person.b.d dVar, View view) {
        if (dVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(dVar.dBn, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(dVar.dBo, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(dVar.dBp, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(dVar.dBq, t.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.dxB = cVar;
            view.setOnClickListener(new f(this));
        }
    }
}
