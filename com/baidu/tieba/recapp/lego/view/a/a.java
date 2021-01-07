package com.baidu.tieba.recapp.lego.view.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes8.dex */
public abstract class a implements e<AdCard> {
    protected boolean fzb;
    protected AdvertAppInfo kQj;
    private int mBusinessType;
    protected Context mContext;
    protected AdCard mOY;
    protected TbPageContext mPageContext;
    protected com.baidu.tieba.lego.card.a mRz;

    protected abstract void ddK();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mOY = adCard;
        this.kQj = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aN(Object obj) {
        if (obj instanceof AdCard) {
            this.mOY = (AdCard) obj;
            ddK();
            b(this.mOY);
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
    public void ddN() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aWE() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cUq() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.mRz = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fzb = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void ddO() {
    }
}
