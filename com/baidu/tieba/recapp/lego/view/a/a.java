package com.baidu.tieba.recapp.lego.view.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes26.dex */
public abstract class a implements e<AdCard> {
    protected boolean fpu;
    protected AdvertAppInfo kLa;
    private int mBusinessType;
    protected Context mContext;
    protected AdCard mJS;
    protected com.baidu.tieba.lego.card.a mMr;
    protected TbPageContext mPageContext;

    protected abstract void ddY();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mJS = adCard;
        this.kLa = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aN(Object obj) {
        if (obj instanceof AdCard) {
            this.mJS = (AdCard) obj;
            ddY();
            b(this.mJS);
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
    public void deb() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aUj() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cRj() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.mMr = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fpu = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void dec() {
    }
}
