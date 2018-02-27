package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes3.dex */
public class e extends a implements com.baidu.tieba.recapp.k {
    public DistributeVideoView gBR;
    private TbPageContext mTbPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        if (view != null) {
            this.gBR = (DistributeVideoView) view.findViewById(d.g.advert_video);
            this.gBR.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.gBR.setPageContext(this.mTbPageContext);
            this.gBR.setVideoTailFrameData(adCard.tailFrame);
            this.gBR.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.gBR.setChargeInfo(adCard.chargeInfo);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.gBR.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                this.gBR.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.aJX);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        super.setDownloadAppCallback(cVar);
        this.gBR.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public com.baidu.tieba.recapp.i getVideoOrVrView() {
        return this.gBR;
    }
}
