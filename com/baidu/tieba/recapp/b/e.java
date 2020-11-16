package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.o;
/* loaded from: classes25.dex */
public class e extends com.baidu.tieba.frs.k<bx, f> implements n {
    private o fNh;

    public e(o oVar, BdUniqueId bdUniqueId) {
        super(oVar.getTbPageContext(), bdUniqueId);
        this.fNh = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cE */
    public f c(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new f(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, f fVar) {
        if (bxVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bxVar;
            com.baidu.tbadk.core.data.c.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1), advertAppInfo.exl.exz == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.n
    public void setIsFromCDN(boolean z) {
    }
}
