package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.b, com.baidu.tieba.person.holder.a> {
    private View.OnClickListener aif;
    private TbPageContext bKX;
    private com.baidu.tieba.person.data.b eBE;
    protected int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aif = new c(this);
        this.bKX = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public com.baidu.tieba.person.holder.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.a(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_book_shelf, viewGroup, false), this.aif);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.holder.a aVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.aST) {
            a(aVar, bVar);
            this.aST = false;
        }
        com.baidu.tbadk.j.a.a(this.bKX, view);
        return view;
    }

    private void a(com.baidu.tieba.person.holder.a aVar, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null && aVar != null) {
            this.eBE = bVar;
            aVar.a(bVar);
        }
    }
}
