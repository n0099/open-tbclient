package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.b, com.baidu.tieba.person.holder.a> {
    private View.OnClickListener aLT;
    private TbPageContext bBE;
    private com.baidu.tieba.person.data.b exR;
    protected int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.aLT = new c(this);
        this.bBE = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public com.baidu.tieba.person.holder.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.a(LayoutInflater.from(this.mContext).inflate(r.j.personinfo_book_shelf, viewGroup, false), this.aLT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.holder.a aVar) {
        a(aVar, bVar);
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.i.a.a(this.bBE, view);
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.a aVar, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null && aVar != null) {
            this.exR = bVar;
            aVar.a(bVar);
        }
    }
}
