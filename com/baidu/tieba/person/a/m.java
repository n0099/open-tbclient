package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m extends c<com.baidu.tieba.person.data.g, com.baidu.tieba.person.b.f> {
    /* JADX INFO: Access modifiers changed from: protected */
    public m(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public com.baidu.tieba.person.b.f b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.f(LayoutInflater.from(this.mContext).inflate(t.h.person_info_forum_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.g gVar, com.baidu.tieba.person.b.f fVar) {
        a(fVar, view);
        if (gVar != null && this.bcn) {
            aP(view);
            if (gVar.dwd) {
                fVar.bnb.setVisibility(0);
            } else {
                fVar.bnb.setVisibility(8);
            }
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.f fVar, View view) {
        if (fVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(view, t.f.addresslist_item_bg);
            at.l(fVar.bnb, t.d.cp_bg_line_c);
            at.c(fVar.cJc, t.f.icon_mine_ba_feed);
            at.j((View) fVar.dyv, t.d.cp_cont_f);
            at.c(fVar.dyw, t.f.icon_arrow_tab);
        }
    }

    private void aP(View view) {
        view.setOnClickListener(new n(this));
    }
}
