package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes3.dex */
public class AdCardVideoView extends AdCardBaseView implements k {
    public DistributeVideoView gjp;
    private TbPageContext mTbPageContext;

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bu(View view) {
        if (view != null) {
            this.gjp = (DistributeVideoView) view.findViewById(d.g.advert_video);
            this.gjp.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.gjp.setPageContext(this.mTbPageContext);
            this.gjp.setVideoTailFrameData(adCard.tailFrame);
            this.gjp.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.gjp.setChargeInfo(adCard.chargeInfo);
            this.gjp.setScheme(adCard.getScheme());
            this.gjp.setParallelChargeInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.gjp.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                this.gjp.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.adp);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        this.gjp.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        return this.gjp;
    }
}
