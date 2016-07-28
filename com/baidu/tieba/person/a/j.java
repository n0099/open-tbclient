package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.person.holder.h;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.g, h> {
    private com.baidu.tieba.person.data.g eqd;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public h a(ViewGroup viewGroup) {
        return new h(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.g gVar, h hVar) {
        a(hVar, view);
        if (gVar != null && this.aNz) {
            a(hVar, gVar, view);
            this.aNz = false;
        }
        return view;
    }

    private void a(h hVar, com.baidu.tieba.person.data.g gVar, View view) {
        if (gVar != null) {
            this.userId = gVar.userId;
            if (gVar.sex == 2) {
                hVar.euD.setText(this.mContext.getResources().getString(u.j.attention_to_her));
            } else {
                hVar.euD.setText(this.mContext.getResources().getString(u.j.attention_to_him));
            }
            if (gVar.esa > 0) {
                hVar.euE.setVisibility(0);
                hVar.eut.setVisibility(0);
                hVar.eus.setVisibility(4);
                hVar.euE.setText(new StringBuilder(String.valueOf(gVar.esa)).toString());
            } else {
                hVar.euE.setVisibility(4);
                hVar.eut.setVisibility(4);
                hVar.eus.setVisibility(0);
            }
            a(view, gVar);
        }
    }

    private void a(h hVar, View view) {
        if (hVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(view, u.f.addresslist_item_bg);
            av.c(hVar.euD, u.d.cp_cont_f, 1);
            av.c(hVar.euE, u.d.cp_cont_c, 1);
            av.l(hVar.aHK, u.d.cp_bg_line_b);
            av.l(hVar.aSw, u.d.cp_bg_line_c);
            av.c(hVar.eus, u.d.cp_cont_d, 1);
            av.c(hVar.eut, u.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null) {
            this.eqd = gVar;
            view.setOnClickListener(new k(this));
        }
    }
}
