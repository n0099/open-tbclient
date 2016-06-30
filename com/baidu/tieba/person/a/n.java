package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.h, com.baidu.tieba.person.b.g> {
    /* JADX INFO: Access modifiers changed from: protected */
    public n(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public com.baidu.tieba.person.b.g a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.g(LayoutInflater.from(this.mContext).inflate(u.h.person_info_forum_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.h hVar, com.baidu.tieba.person.b.g gVar) {
        a(gVar, view);
        if (hVar != null && this.aMF) {
            bb(view);
            if (hVar.ehJ) {
                gVar.bLB.setVisibility(0);
            } else {
                gVar.bLB.setVisibility(8);
            }
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.g gVar, View view) {
        if (gVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(view, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(gVar.bLB, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(gVar.dpJ, u.f.icon_mine_ba_feed);
            com.baidu.tbadk.core.util.av.j((View) gVar.ekg, u.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.c(gVar.ekh, u.f.icon_arrow_tab);
        }
    }

    private void bb(View view) {
        view.setOnClickListener(new o(this));
    }
}
