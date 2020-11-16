package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.lego.a.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes25.dex */
public class AdCardVideoView extends AdCardBaseView implements l {
    private TbPageContext mTbPageContext;
    public DistributeVideoView mtA;

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void dH(View view) {
        if (view != null) {
            float Iv = Iv(R.string.J_X05);
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{Iv, Iv, Iv, Iv, Iv, Iv, Iv, Iv});
            ((XfremodeRoundLayout) view).setLayerType(2, null);
            this.mtA = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.mtA.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.mtA.setPageContext(this.mTbPageContext);
            this.mtA.setVideoTailFrameData(adCard.tailFrame);
            this.mtA.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.mtA.setChargeInfo(adCard.chargeInfo);
            this.mtA.setScheme(adCard.getScheme());
            this.mtA.setAdInfo(adCard);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mtA.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mvd.getLayoutParams();
            if (adCard.goodsStyle == 14) {
                ViewGroup.LayoutParams layoutParams3 = this.mvC.getLayoutParams();
                int equipmentWidth = layoutParams3.width > 0 ? layoutParams3.width / 2 : (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - (this.mvi * 2)) / 2;
                layoutParams.width = equipmentWidth;
                layoutParams2.width = equipmentWidth;
                int It = a.It(layoutParams.width);
                layoutParams.height = It;
                layoutParams2.height = It;
                layoutParams.gravity = 3;
                layoutParams2.gravity = 3;
            } else {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                layoutParams.gravity = 1;
                layoutParams2.gravity = 1;
            }
            this.mvd.requestLayout();
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.mtA.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mtA.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            this.mtA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardVideoView.this.mtA.jump2DownloadDetailPage();
                    AdCardVideoView.this.dAg();
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
        this.mtA.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.l
    public i getVideoOrVrView() {
        return this.mtA;
    }
}
