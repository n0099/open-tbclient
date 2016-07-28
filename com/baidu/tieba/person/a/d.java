package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.c, com.baidu.tieba.person.holder.f> {
    private com.baidu.tieba.person.data.c epW;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public com.baidu.tieba.person.holder.f a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.f(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.holder.f fVar) {
        a(fVar, view);
        if (cVar != null && this.aNz) {
            a(fVar, cVar, view);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.f fVar, com.baidu.tieba.person.data.c cVar, View view) {
        if (cVar != null) {
            this.userId = cVar.userId;
            fVar.euq.setText(this.mContext.getResources().getString(u.j.attention_other));
            if (cVar.erN > 0) {
                fVar.eus.setVisibility(4);
                fVar.eur.setVisibility(0);
                fVar.eut.setVisibility(0);
                fVar.eur.setText(new StringBuilder(String.valueOf(cVar.erN)).toString());
            } else {
                fVar.eus.setVisibility(0);
                fVar.eur.setVisibility(4);
                fVar.eut.setVisibility(4);
            }
            a(view, cVar);
        }
    }

    private void a(com.baidu.tieba.person.holder.f fVar, View view) {
        if (fVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(view, u.f.addresslist_item_bg);
            av.c(fVar.euq, u.d.cp_cont_f, 1);
            av.c(fVar.eur, u.d.cp_cont_c, 1);
            av.c(fVar.eus, u.d.cp_cont_d, 1);
            av.c(fVar.eut, u.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.epW = cVar;
            view.setOnClickListener(new e(this));
        }
    }
}
