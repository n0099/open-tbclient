package com.baidu.tieba.recapp.lego.view.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes25.dex */
public abstract class a implements e<AdCard> {
    protected boolean fhT;
    protected AdvertAppInfo kxG;
    private int mBusinessType;
    protected Context mContext;
    protected TbPageContext mPageContext;
    protected AdCard mvE;
    protected com.baidu.tieba.lego.card.a myd;

    protected abstract void cYM();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mvE = adCard;
        this.kxG = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aN(Object obj) {
        if (obj instanceof AdCard) {
            this.mvE = (AdCard) obj;
            cYM();
            b(this.mvE);
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
    public void cYP() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aRe() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cLU() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.myd = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fhT = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cYQ() {
    }
}
