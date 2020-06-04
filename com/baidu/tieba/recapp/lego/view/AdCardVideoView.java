package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.e.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.j;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes13.dex */
public class AdCardVideoView extends AdCardBaseView implements j {
    public DistributeVideoView kKI;
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
    protected void cX(View view) {
        if (view != null) {
            float dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10);
            ((RoundRelativeLayout) view).setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
            this.kKI = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.kKI.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.kKI.setPageContext(this.mTbPageContext);
            this.kKI.setVideoTailFrameData(adCard.tailFrame);
            this.kKI.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.kKI.setChargeInfo(adCard.chargeInfo);
            this.kKI.setScheme(adCard.getScheme());
            this.kKI.setParallelChargeInfo(adCard);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kKI.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kMj.getLayoutParams();
            if (adCard.goodsStyle == 14) {
                int equipmentWidth = ((l.getEquipmentWidth(getContext()) - this.kMo) - this.kMp) / 2;
                layoutParams.width = equipmentWidth;
                layoutParams2.width = equipmentWidth;
                int bs = a.bs(layoutParams.width);
                layoutParams.height = bs;
                layoutParams2.height = bs;
                layoutParams.gravity = 3;
                layoutParams2.gravity = 3;
            } else {
                layoutParams.gravity = 1;
                layoutParams2.gravity = 1;
            }
            this.kMj.requestLayout();
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.kKI.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.kKI.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aOz()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardVideoView.this.kKI != null) {
                            AdCardVideoView.this.kKI.jump2DownloadDetailPage();
                            AdCardVideoView.this.cUU();
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
        this.kKI.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        return this.kKI;
    }
}
