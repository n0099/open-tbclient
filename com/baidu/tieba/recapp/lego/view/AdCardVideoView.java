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
    public DistributeVideoView leC;
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
    protected void cY(View view) {
        if (view != null) {
            float dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10);
            ((RoundRelativeLayout) view).setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
            this.leC = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.leC.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.leC.setPageContext(this.mTbPageContext);
            this.leC.setVideoTailFrameData(adCard.tailFrame);
            this.leC.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.leC.setChargeInfo(adCard.chargeInfo);
            this.leC.setScheme(adCard.getScheme());
            this.leC.setParallelChargeInfo(adCard);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leC.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lgd.getLayoutParams();
            if (adCard.goodsStyle == 14) {
                int equipmentWidth = ((l.getEquipmentWidth(getContext()) - this.lgi) - this.lgj) / 2;
                layoutParams.width = equipmentWidth;
                layoutParams2.width = equipmentWidth;
                int bx = a.bx(layoutParams.width);
                layoutParams.height = bx;
                layoutParams2.height = bx;
                layoutParams.gravity = 3;
                layoutParams2.gravity = 3;
            } else {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                layoutParams.gravity = 1;
                layoutParams2.gravity = 1;
            }
            this.lgd.requestLayout();
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.leC.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.leC.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aQj()) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardVideoView.this.leC != null) {
                            AdCardVideoView.this.leC.jump2DownloadDetailPage();
                            AdCardVideoView.this.cZk();
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
        this.leC.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.j
    public h getVideoOrVrView() {
        return this.leC;
    }
}
