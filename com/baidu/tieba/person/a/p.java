package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.i, com.baidu.tieba.person.b.i> {
    /* JADX INFO: Access modifiers changed from: protected */
    public p(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public com.baidu.tieba.person.b.i a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.i(LayoutInflater.from(this.mContext).inflate(u.h.person_info_friend_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.b.i iVar2) {
        a(iVar2, view);
        if (iVar != null && this.aMF) {
            bb(view);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.i iVar, View view) {
        if (iVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(view, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(iVar.bLB, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(iVar.dpJ, u.f.icon_mine_friend_feed);
            com.baidu.tbadk.core.util.av.c(iVar.ekh, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.j((View) iVar.ekg, u.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.l(iVar.bni, u.d.cp_bg_line_c);
        }
    }

    private void bb(View view) {
        view.setOnClickListener(new q(this));
    }
}
