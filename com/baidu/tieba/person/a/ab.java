package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.p, com.baidu.tieba.person.holder.n> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ab(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public com.baidu.tieba.person.holder.n a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.n(LayoutInflater.from(this.mContext).inflate(u.h.person_info_togetherhi_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.p pVar, com.baidu.tieba.person.holder.n nVar) {
        a(nVar, view);
        if (pVar != null && this.aNz) {
            bb(view);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.n nVar, View view) {
        if (nVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(view, u.f.addresslist_item_bg);
            av.l(nVar.bNl, u.d.cp_bg_line_c);
            av.c(nVar.dsQ, u.f.icon_mine_hi);
            av.c(nVar.ewJ, u.f.icon_arrow_tab);
            av.j((View) nVar.ewI, u.d.cp_cont_f);
        }
    }

    private void bb(View view) {
        view.setOnClickListener(new ac(this));
    }
}
