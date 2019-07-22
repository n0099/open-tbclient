package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.h<bg, f> implements m {
    private n cRf;

    public e(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext(), bdUniqueId);
        this.cRf = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new f(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, f fVar) {
        if (bgVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bgVar;
            com.baidu.tbadk.core.data.c.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1), advertAppInfo.bFd.bFq == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
