package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class o extends c<com.baidu.tieba.person.data.h, com.baidu.tieba.person.b.g> {
    /* JADX INFO: Access modifiers changed from: protected */
    public o(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public com.baidu.tieba.person.b.g a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.g(LayoutInflater.from(this.mContext).inflate(n.h.person_info_friend_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.h hVar, com.baidu.tieba.person.b.g gVar) {
        a(gVar, view);
        if (hVar != null && this.aVr) {
            ar(view);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.g gVar, View view) {
        if (gVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(view, n.f.addresslist_item_bg);
            as.j(gVar.bfI, n.d.cp_bg_line_c);
            as.c(gVar.cSG, n.f.icon_mine_friend);
            as.c(gVar.cSI, n.f.icon_arrow_tab);
            as.h((View) gVar.cSH, n.d.cp_cont_f);
            as.j(gVar.cTa, n.d.cp_bg_line_c);
        }
    }

    private void ar(View view) {
        view.setOnClickListener(new p(this));
    }
}
