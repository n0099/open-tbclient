package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends c<com.baidu.tieba.person.data.h, com.baidu.tieba.person.b.g> {
    /* JADX INFO: Access modifiers changed from: protected */
    public n(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.tieba.person.b.g b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.g(LayoutInflater.from(this.mContext).inflate(t.h.person_info_forum_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.h hVar, com.baidu.tieba.person.b.g gVar) {
        a(gVar, view);
        if (hVar != null && this.bUL) {
            aT(view);
            if (hVar.dzf) {
                gVar.biC.setVisibility(0);
            } else {
                gVar.biC.setVisibility(8);
            }
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.g gVar, View view) {
        if (gVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(gVar.biC, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(gVar.cJU, t.f.icon_mine_ba_feed);
            com.baidu.tbadk.core.util.at.j((View) gVar.dBD, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.c(gVar.dBE, t.f.icon_arrow_tab);
        }
    }

    private void aT(View view) {
        view.setOnClickListener(new o(this));
    }
}
