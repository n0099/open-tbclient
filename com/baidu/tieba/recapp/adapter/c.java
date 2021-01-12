package com.baidu.tieba.recapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.p;
/* loaded from: classes7.dex */
public class c extends k<bz, FrsAppEmptyHolder> implements o {
    private p fZO;

    public c(p pVar, BdUniqueId bdUniqueId) {
        super(pVar.getTbPageContext(), bdUniqueId);
        this.fZO = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cT */
    public FrsAppEmptyHolder e(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new FrsAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, FrsAppEmptyHolder frsAppEmptyHolder) {
        if (bzVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bzVar;
            com.baidu.tbadk.core.data.c.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1), advertAppInfo.eJr.eJF == -1001);
        }
        return frsAppEmptyHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
    }
}
