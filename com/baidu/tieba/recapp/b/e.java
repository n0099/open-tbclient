package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.p;
/* loaded from: classes26.dex */
public class e extends com.baidu.tieba.frs.k<by, f> implements o {
    private p fUS;

    public e(p pVar, BdUniqueId bdUniqueId) {
        super(pVar.getTbPageContext(), bdUniqueId);
        this.fUS = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cH */
    public f c(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new f(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, f fVar) {
        if (byVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) byVar;
            com.baidu.tbadk.core.data.c.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1), advertAppInfo.eEm.eEA == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
    }
}
