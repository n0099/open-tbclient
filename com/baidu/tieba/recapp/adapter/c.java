package com.baidu.tieba.recapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.p;
/* loaded from: classes8.dex */
public class c extends k<cb, FrsAppEmptyHolder> implements o {
    private p gch;

    public c(p pVar, BdUniqueId bdUniqueId) {
        super(pVar.getTbPageContext(), bdUniqueId);
        this.gch = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cU */
    public FrsAppEmptyHolder e(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new FrsAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, FrsAppEmptyHolder frsAppEmptyHolder) {
        if (cbVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cbVar;
            if (cCh()) {
                cbVar.position = i - this.jfG.getTopThreadSize();
            }
            com.baidu.tbadk.core.data.d.a(advertAppInfo.advertAppContext, cbVar.position, advertAppInfo.eLD.eLR == -1001);
        }
        return frsAppEmptyHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
    }
}
