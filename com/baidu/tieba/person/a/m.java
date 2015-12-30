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
public class m extends c<com.baidu.tieba.person.data.g, com.baidu.tieba.person.b.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    public m(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public com.baidu.tieba.person.b.e a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(n.h.person_info_forum_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.g gVar, com.baidu.tieba.person.b.e eVar) {
        a(eVar, view);
        if (gVar != null && this.aVr) {
            ar(view);
            if (gVar.cRM) {
                eVar.bfI.setVisibility(0);
            } else {
                eVar.bfI.setVisibility(8);
            }
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, View view) {
        if (eVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(view, n.f.addresslist_item_bg);
            as.j(eVar.bfI, n.d.cp_bg_line_c);
            as.c(eVar.cSG, n.f.icon_mine_ba);
            as.h((View) eVar.cSH, n.d.cp_cont_f);
            as.c(eVar.cSI, n.f.icon_arrow_tab);
        }
    }

    private void ar(View view) {
        view.setOnClickListener(new n(this));
    }
}
