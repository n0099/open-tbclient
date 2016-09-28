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
    private View.OnClickListener ahN;
    private TbPageContext bKY;
    private com.baidu.tieba.person.data.b eDH;
    protected int mSkinType;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahN = new c(this);
        this.bKY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public com.baidu.tieba.person.holder.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.a(LayoutInflater.from(this.mContext).inflate(r.h.personinfo_book_shelf, viewGroup, false), this.ahN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.holder.a aVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.aTD) {
            a(aVar, bVar);
            this.aTD = false;
        }
        com.baidu.tbadk.i.a.a(this.bKY, view);
        return view;
    }

    private void a(com.baidu.tieba.person.holder.a aVar, com.baidu.tieba.person.data.b bVar) {
        if (bVar != null && aVar != null) {
            this.eDH = bVar;
            aVar.a(bVar);
        }
    }
}
