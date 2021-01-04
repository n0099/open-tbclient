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
    protected AdCard mOZ;
    protected TbPageContext mPageContext;
    protected com.baidu.tieba.lego.card.a mRA;

    protected abstract void ddJ();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public void b(AdCard adCard) {
        this.mOZ = adCard;
        this.kQj = adCard.getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aN(Object obj) {
        if (obj instanceof AdCard) {
            this.mOZ = (AdCard) obj;
            ddJ();
            b(this.mOZ);
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
    public void ddM() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aWD() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cUp() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.mRA = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setFromCDN(boolean z) {
        this.fzb = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void ddN() {
    }
}
