package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.data.f;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.a.a<f, com.baidu.tieba.person.b.f> {
    private f egc;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.person.b.f a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.f(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.person.b.f fVar2) {
        a(fVar2, view);
        if (fVar != null && this.aMF) {
            a(fVar2, fVar, view);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.f fVar, f fVar2, View view) {
        if (fVar2 != null) {
            this.userId = fVar2.userId;
            if (fVar2.sex == 2) {
                fVar.eke.setText(this.mContext.getResources().getString(u.j.attention_to_her));
            } else {
                fVar.eke.setText(this.mContext.getResources().getString(u.j.attention_to_him));
            }
            if (fVar2.ehU > 0) {
                fVar.ekf.setVisibility(0);
                fVar.ejT.setVisibility(0);
                fVar.ejS.setVisibility(4);
                fVar.ekf.setText(new StringBuilder(String.valueOf(fVar2.ehU)).toString());
            } else {
                fVar.ekf.setVisibility(4);
                fVar.ejT.setVisibility(4);
                fVar.ejS.setVisibility(0);
            }
            a(view, fVar2);
        }
    }

    private void a(com.baidu.tieba.person.b.f fVar, View view) {
        if (fVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(view, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(fVar.eke, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(fVar.ekf, u.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.av.l(fVar.aGT, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.l(fVar.aRC, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(fVar.ejS, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(fVar.ejT, u.f.icon_arrow_tab);
        }
    }

    private void a(View view, f fVar) {
        if (fVar != null) {
            this.egc = fVar;
            view.setOnClickListener(new i(this));
        }
    }
}
