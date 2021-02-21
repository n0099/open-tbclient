package com.baidu.tieba.recapp.lego.view.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes8.dex */
public abstract class a implements e<AdCard> {
    protected boolean fwJ;
    protected AdvertAppInfo kTV;
    private int mBusinessType;
    protected Context mContext;
    protected TbPageContext mPageContext;
    protected AdCard mUg;
    protected com.baidu.tieba.lego.card.a mWH;

    protected abstract void dbX();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mUg = adCard;
        this.kTV = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aN(Object obj) {
        if (obj instanceof AdCard) {
            this.mUg = (AdCard) obj;
            dbX();
            b(this.mUg);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setPosition(int i) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setBusinessType(int i) {
        this.mBusinessType = i;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void dca() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aSW() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cSE() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.mWH = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fwJ = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void dcb() {
    }
}
