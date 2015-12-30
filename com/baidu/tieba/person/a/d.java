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
    private com.baidu.tieba.person.data.b cQz;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public com.baidu.tieba.person.b.b a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mContext).inflate(n.h.personinfo_attention_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.b.b bVar2) {
        a(bVar2, view);
        if (bVar != null && this.aVr) {
            a(bVar2, bVar, view);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.b bVar, com.baidu.tieba.person.data.b bVar2, View view) {
        if (bVar2 != null) {
            this.userId = bVar2.userId;
            bVar.cSu.setText(this.mContext.getResources().getString(n.j.attention_other));
            if (bVar2.cRP > 0) {
                bVar.cSw.setVisibility(4);
                bVar.cSv.setVisibility(0);
                bVar.cSx.setVisibility(0);
                bVar.cSv.setText(new StringBuilder(String.valueOf(bVar2.cRP)).toString());
            } else {
                bVar.cSw.setVisibility(0);
                bVar.cSv.setVisibility(4);
                bVar.cSx.setVisibility(4);
            }
            a(view, bVar2);
        }
    }

    private void a(com.baidu.tieba.person.b.b bVar, View view) {
        if (bVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(view, n.f.addresslist_item_bg);
            as.b(bVar.cSu, n.d.cp_cont_f, 1);
            as.b(bVar.cSv, n.d.cp_cont_c, 1);
            as.b(bVar.cSw, n.d.cp_cont_d, 1);
            as.c(bVar.cSx, n.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.cQz = bVar;
            view.setOnClickListener(new e(this));
        }
    }
}
