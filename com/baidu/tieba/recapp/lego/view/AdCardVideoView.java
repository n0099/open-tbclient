package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.g.a.e.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes26.dex */
public class AdCardVideoView extends AdCardBaseView implements k {
    private TbPageContext mTbPageContext;
    public DistributeVideoView mtk;

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void dD(View view) {
        if (view != null) {
            float dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10);
            ((RoundRelativeLayout) view).setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
            this.mtk = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.mtk.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.mtk.setPageContext(this.mTbPageContext);
            this.mtk.setVideoTailFrameData(adCard.tailFrame);
            this.mtk.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.mtk.setChargeInfo(adCard.chargeInfo);
            this.mtk.setScheme(adCard.getScheme());
            this.mtk.setAdInfo(adCard);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mtk.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.muM.getLayoutParams();
            if (adCard.goodsStyle == 14) {
                int equipmentWidth = ((l.getEquipmentWidth(getContext()) - this.muR) - this.muS) / 2;
                layoutParams.width = equipmentWidth;
                layoutParams2.width = equipmentWidth;
                int dn = a.dn(layoutParams.width);
                layoutParams.height = dn;
                layoutParams2.height = dn;
                layoutParams.gravity = 3;
                layoutParams2.gravity = 3;
            } else {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                layoutParams.gravity = 1;
                layoutParams2.gravity = 1;
            }
            this.muM.requestLayout();
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.mtk.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mtk.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            this.mtk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardVideoView.this.mtk.jump2DownloadDetailPage();
                    AdCardVideoView.this.dAG();
                }
            });
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
        this.mtk.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public h getVideoOrVrView() {
        return this.mtk;
    }
}
