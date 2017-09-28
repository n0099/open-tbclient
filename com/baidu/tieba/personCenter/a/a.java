package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.a, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a>> {
    private com.baidu.tieba.d.a faa;
    private TbPageContext mG;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.a aVar = new com.baidu.tieba.personCenter.view.a(this.mG);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("friend_enter_change_tip", false)) {
            this.faa = new com.baidu.tieba.d.a(this.mG, aVar.aVt());
            this.faa.ie(d.g.bg_tip_blue_up_left);
            this.faa.ih(95);
        }
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a> aVar2) {
        aVar2.Yr().a(aVar);
        return aVar2.getView();
    }

    public void aVm() {
        if (this.faa != null && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("friend_enter_change_tip", false)) {
            this.faa.m11if(5000);
            this.faa.jA(this.mG.getString(d.l.friend_enter_change_tip));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("friend_enter_change_tip", true);
        }
    }

    public void destroy() {
        if (this.faa != null) {
            this.faa.Zz();
        }
    }
}
