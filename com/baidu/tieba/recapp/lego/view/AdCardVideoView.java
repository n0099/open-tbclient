package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes11.dex */
public class AdCardVideoView extends AdCardBaseView implements k {
    public DistributeVideoView jFn;
    private TbPageContext mTbPageContext;

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cN(View view) {
        if (view != null) {
            float dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10);
            ((RoundRelativeLayout) view).setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
            this.jFn = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.jFn.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.jFn.setPageContext(this.mTbPageContext);
            this.jFn.setVideoTailFrameData(adCard.tailFrame);
            this.jFn.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.jFn.setChargeInfo(adCard.chargeInfo);
            this.jFn.setScheme(adCard.getScheme());
            this.jFn.setParallelChargeInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.jFn.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.jFn.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aya()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardVideoView.this.jFn != null) {
                            AdCardVideoView.this.jFn.jump2DownloadDetailPage();
                            AdCardVideoView.this.cBp();
                        }
                    }
                });
            }
        }
    }

    private String getPageTypeByBusiness() {
        switch (getBusinessType()) {
            case 1:
                return "FRS";
            case 2:
            case 3:
                return "NEWINDEX";
            case 4:
                return "PB_BANNER";
            default:
                return "unknown";
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        this.jFn.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        return this.jFn;
    }
}
