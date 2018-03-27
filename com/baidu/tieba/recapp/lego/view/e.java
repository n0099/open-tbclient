package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes3.dex */
public class e extends a implements com.baidu.tieba.recapp.k {
    public DistributeVideoView gCh;
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
            this.gCh = (DistributeVideoView) view.findViewById(d.g.advert_video);
            this.gCh.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.gCh.setPageContext(this.mTbPageContext);
            this.gCh.setVideoTailFrameData(adCard.tailFrame);
            this.gCh.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.gCh.setChargeInfo(adCard.chargeInfo);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.gCh.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                this.gCh.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.aJY);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        super.setDownloadAppCallback(cVar);
        this.gCh.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public com.baidu.tieba.recapp.i getVideoOrVrView() {
        return this.gCh;
    }
}
