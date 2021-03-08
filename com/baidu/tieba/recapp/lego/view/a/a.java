package com.baidu.tieba.recapp.lego.view.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.view.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes7.dex */
public abstract class a implements e<AdCard> {
    protected boolean fyi;
    protected AdvertAppInfo kVX;
    private int mBusinessType;
    protected Context mContext;
    protected TbPageContext mPageContext;
    protected AdCard mWq;
    protected com.baidu.tieba.lego.card.a mYS;

    protected abstract void dcg();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mWq = adCard;
        this.kVX = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aP(Object obj) {
        if (obj instanceof AdCard) {
            this.mWq = (AdCard) obj;
            dcg();
            b(this.mWq);
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
    public void dcj() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aSZ() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cSL() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.mYS = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fyi = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void dck() {
    }
}
