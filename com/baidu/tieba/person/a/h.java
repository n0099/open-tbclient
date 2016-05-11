package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends c<com.baidu.tieba.person.data.f, com.baidu.tieba.person.b.f> {
    private com.baidu.tieba.person.data.f dxG;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.person.b.f b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.f(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.f fVar, com.baidu.tieba.person.b.f fVar2) {
        a(fVar2, view);
        if (fVar != null && this.bUL) {
            a(fVar2, fVar, view);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.f fVar, com.baidu.tieba.person.data.f fVar2, View view) {
        if (fVar2 != null) {
            this.userId = fVar2.userId;
            if (fVar2.sex == 2) {
                fVar.dBB.setText(this.mContext.getResources().getString(t.j.attention_to_her));
            } else {
                fVar.dBB.setText(this.mContext.getResources().getString(t.j.attention_to_him));
            }
            if (fVar2.dzq > 0) {
                fVar.dBC.setVisibility(0);
                fVar.dBq.setVisibility(0);
                fVar.dBp.setVisibility(4);
                fVar.dBC.setText(new StringBuilder(String.valueOf(fVar2.dzq)).toString());
            } else {
                fVar.dBC.setVisibility(4);
                fVar.dBq.setVisibility(4);
                fVar.dBp.setVisibility(0);
            }
            a(view, fVar2);
        }
    }

    private void a(com.baidu.tieba.person.b.f fVar, View view) {
        if (fVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(fVar.dBB, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(fVar.dBC, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.l(fVar.aGr, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.l(fVar.aOf, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(fVar.dBp, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(fVar.dBq, t.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            this.dxG = fVar;
            view.setOnClickListener(new i(this));
        }
    }
}
