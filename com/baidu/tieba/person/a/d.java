package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends c<com.baidu.tieba.person.data.b, com.baidu.tieba.person.b.c> {
    private com.baidu.tieba.person.data.b duF;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.tieba.person.b.c b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.b.c cVar) {
        a(cVar, view);
        if (bVar != null && this.bcn) {
            a(cVar, bVar, view);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.c cVar, com.baidu.tieba.person.data.b bVar, View view) {
        if (bVar != null) {
            this.userId = bVar.userId;
            cVar.dyf.setText(this.mContext.getResources().getString(t.j.attention_other));
            if (bVar.dwg > 0) {
                cVar.dyh.setVisibility(4);
                cVar.dyg.setVisibility(0);
                cVar.dyi.setVisibility(0);
                cVar.dyg.setText(new StringBuilder(String.valueOf(bVar.dwg)).toString());
            } else {
                cVar.dyh.setVisibility(0);
                cVar.dyg.setVisibility(4);
                cVar.dyi.setVisibility(4);
            }
            a(view, bVar);
        }
    }

    private void a(com.baidu.tieba.person.b.c cVar, View view) {
        if (cVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(view, t.f.addresslist_item_bg);
            at.b(cVar.dyf, t.d.cp_cont_f, 1);
            at.b(cVar.dyg, t.d.cp_cont_c, 1);
            at.b(cVar.dyh, t.d.cp_cont_d, 1);
            at.c(cVar.dyi, t.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.duF = bVar;
            view.setOnClickListener(new e(this));
        }
    }
}
