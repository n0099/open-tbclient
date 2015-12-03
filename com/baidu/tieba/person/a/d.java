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
public class d extends c<com.baidu.tieba.person.data.b, com.baidu.tieba.person.b.b> {
    private com.baidu.tieba.person.data.b cMh;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public com.baidu.tieba.person.b.b a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mContext).inflate(n.g.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.b.b bVar2) {
        a(bVar2, view);
        if (bVar != null && this.aRB) {
            a(bVar2, bVar, view);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.b bVar, com.baidu.tieba.person.data.b bVar2, View view) {
        if (bVar2 != null) {
            this.userId = bVar2.userId;
            bVar.cNO.setText(this.mContext.getResources().getString(n.i.attention_other));
            if (bVar2.cNl > 0) {
                bVar.cNQ.setVisibility(4);
                bVar.cNP.setVisibility(0);
                bVar.cNR.setVisibility(0);
                bVar.cNP.setText(new StringBuilder(String.valueOf(bVar2.cNl)).toString());
            } else {
                bVar.cNQ.setVisibility(0);
                bVar.cNP.setVisibility(4);
                bVar.cNR.setVisibility(4);
            }
            a(view, bVar2);
        }
    }

    private void a(com.baidu.tieba.person.b.b bVar, View view) {
        if (bVar.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(view, n.e.addresslist_item_bg);
            as.b(bVar.cNO, n.c.cp_cont_f, 1);
            as.b(bVar.cNP, n.c.cp_cont_c, 1);
            as.b(bVar.cNQ, n.c.cp_cont_d, 1);
            as.c(bVar.cNR, n.e.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.cMh = bVar;
            view.setOnClickListener(new e(this));
        }
    }
}
