package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends c<com.baidu.tieba.person.data.h, com.baidu.tieba.person.b.h> {
    /* JADX INFO: Access modifiers changed from: protected */
    public o(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public com.baidu.tieba.person.b.h b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.h(LayoutInflater.from(this.mContext).inflate(t.h.person_info_friend_feed_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.h hVar, com.baidu.tieba.person.b.h hVar2) {
        a(hVar2, view);
        if (hVar != null && this.aXE) {
            aH(view);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.h hVar, View view) {
        if (hVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(view, t.f.addresslist_item_bg);
            ar.l(hVar.biq, t.d.cp_bg_line_c);
            ar.c(hVar.ddU, t.f.icon_mine_friend_feed);
            ar.c(hVar.ddW, t.f.icon_arrow_tab);
            ar.j((View) hVar.ddV, t.d.cp_cont_f);
            ar.l(hVar.den, t.d.cp_bg_line_c);
        }
    }

    private void aH(View view) {
        view.setOnClickListener(new p(this));
    }
}
