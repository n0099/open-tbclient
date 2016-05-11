package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p extends c<com.baidu.tieba.person.data.i, com.baidu.tieba.person.b.i> {
    /* JADX INFO: Access modifiers changed from: protected */
    public p(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.tieba.person.b.i b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.i(LayoutInflater.from(this.mContext).inflate(t.h.person_info_friend_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.b.i iVar2) {
        a(iVar2, view);
        if (iVar != null && this.bUL) {
            aT(view);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.i iVar, View view) {
        if (iVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(iVar.biC, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(iVar.cJU, t.f.icon_mine_friend_feed);
            com.baidu.tbadk.core.util.at.c(iVar.dBE, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.j((View) iVar.dBD, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.l(iVar.bMZ, t.d.cp_bg_line_c);
        }
    }

    private void aT(View view) {
        view.setOnClickListener(new q(this));
    }
}
