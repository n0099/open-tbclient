package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.h<bh, f> implements m {
    private n dbz;

    public e(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext(), bdUniqueId);
        this.dbz = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bX */
    public f b(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new f(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, f fVar) {
        if (bhVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bhVar;
            com.baidu.tbadk.core.data.c.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1), advertAppInfo.bXu.bXH == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
