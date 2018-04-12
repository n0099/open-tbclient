package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.f<bd, f> implements m {
    private n aXq;

    public e(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.aeY(), bdUniqueId);
        this.aXq = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        View view2 = new View(this.mPageContext.getPageActivity());
        view2.setVisibility(8);
        return new f(view2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, f fVar) {
        if (bdVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bdVar;
            com.baidu.tbadk.core.data.b.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1), advertAppInfo.Wb.Wn == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
