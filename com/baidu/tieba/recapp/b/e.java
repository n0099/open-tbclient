package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.recapp.m;
/* loaded from: classes13.dex */
public class e extends com.baidu.tieba.frs.h<bk, f> implements com.baidu.tieba.recapp.l {
    private m eHY;

    public e(m mVar, BdUniqueId bdUniqueId) {
        super(mVar.getTbPageContext(), bdUniqueId);
        this.eHY = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public f b(ViewGroup viewGroup) {
        View view = new View(this.mPageContext.getPageActivity());
        view.setVisibility(8);
        return new f(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, f fVar) {
        if (bkVar instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bkVar;
            com.baidu.tbadk.core.data.b.a(advertAppInfo.advertAppContext, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1), advertAppInfo.dAD.dAQ == -1001);
        }
        return fVar.getView();
    }

    @Override // com.baidu.tieba.recapp.l
    public void setIsFromCDN(boolean z) {
    }
}
