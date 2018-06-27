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
    public DistributeVideoView gng;
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
    protected void bv(View view) {
        if (view != null) {
            this.gng = (DistributeVideoView) view.findViewById(d.g.advert_video);
            this.gng.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.gng.setPageContext(this.mTbPageContext);
            this.gng.setVideoTailFrameData(adCard.tailFrame);
            this.gng.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.gng.setChargeInfo(adCard.chargeInfo);
            this.gng.setScheme(adCard.getScheme());
            this.gng.setParallelChargeInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.gng.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String str = "unknown";
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    str = advertAppInfo.advertAppContext.adE;
                }
                this.gng.setStatisticInfo(advertAppInfo, i, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        this.gng.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        return this.gng;
    }
}
