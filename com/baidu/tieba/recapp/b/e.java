package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.n;
/* loaded from: classes20.dex */
public class e extends com.baidu.tieba.frs.k<bw, f> implements m {
    private n fki;

    public e(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext(), bdUniqueId);
        this.fki = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public f b(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new f(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, f fVar) {
        if (bwVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bwVar;
            com.baidu.tbadk.core.data.b.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1), advertAppInfo.dWo.dWB == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
