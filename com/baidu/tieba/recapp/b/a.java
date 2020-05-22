package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.d, b> implements com.baidu.tieba.recapp.l {
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public b b(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new b(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.d dVar, b bVar) {
        AdvertAppInfo bLH = dVar.bLH();
        if (bLH != null) {
            com.baidu.tbadk.core.data.b.c(bLH.advertAppContext, bLH.dAy, bLH.dAD.dAQ == -1001);
        }
        return bVar.getView();
    }

    @Override // com.baidu.tieba.recapp.l
    public void setIsFromCDN(boolean z) {
    }
}
