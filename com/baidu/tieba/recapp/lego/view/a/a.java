package com.baidu.tieba.recapp.lego.view.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes7.dex */
public abstract class a implements e<AdCard> {
    protected boolean fut;
    protected AdvertAppInfo kLE;
    private int mBusinessType;
    protected Context mContext;
    protected AdCard mKu;
    protected com.baidu.tieba.lego.card.a mMT;
    protected TbPageContext mPageContext;

    protected abstract void cZS();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mKu = adCard;
        this.kLE = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aN(Object obj) {
        if (obj instanceof AdCard) {
            this.mKu = (AdCard) obj;
            cZS();
            b(this.mKu);
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
    public void cZV() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aSK() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cQy() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.mMT = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fut = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cZW() {
    }
}
