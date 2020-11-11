package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.m;
/* loaded from: classes26.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, b> implements m {
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cG */
    public b c(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new b(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, b bVar) {
        AdvertAppInfo coL = eVar.coL();
        if (coL != null) {
            com.baidu.tbadk.core.data.b.c(coL.advertAppContext, coL.eyS, coL.eyX.ezk == -1001);
        }
        return bVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
