package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.j;
import com.baidu.tieba.recapp.lego.a.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes7.dex */
public class AdCardVideoView extends AdCardBaseView implements m {
    public DistributeVideoView mIr;
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
    protected void ec(View view) {
        if (view != null) {
            float Hz = Hz(R.string.J_X05);
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{Hz, Hz, Hz, Hz, Hz, Hz, Hz, Hz});
            ((XfremodeRoundLayout) view).setLayerType(2, null);
            this.mIr = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.mIr.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.mIr.setPageContext(this.mTbPageContext);
            this.mIr.setVideoTailFrameData(adCard.tailFrame);
            this.mIr.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.mIr.setChargeInfo(adCard.chargeInfo);
            this.mIr.setScheme(adCard.getScheme());
            this.mIr.setAdInfo(adCard);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIr.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mJT.getLayoutParams();
            if (adCard.goodsStyle == 14) {
                ViewGroup.LayoutParams layoutParams3 = this.mKs.getLayoutParams();
                int equipmentWidth = layoutParams3.width > 0 ? layoutParams3.width / 2 : (l.getEquipmentWidth(getContext()) - (this.mJY * 2)) / 2;
                layoutParams.width = equipmentWidth;
                layoutParams2.width = equipmentWidth;
                int Hx = a.Hx(layoutParams.width);
                layoutParams.height = Hx;
                layoutParams2.height = Hx;
                layoutParams.gravity = 3;
                layoutParams2.gravity = 3;
            } else {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                layoutParams.gravity = 1;
                layoutParams2.gravity = 1;
            }
            this.mJT.requestLayout();
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.mIr.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.page) ? getPageTypeByBusiness() : advertAppInfo.page;
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mIr.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            this.mIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardVideoView.this.mIr.jump2DownloadDetailPage();
                    AdCardVideoView.this.dBw();
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
        this.mIr.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.m
    public j getVideoOrVrView() {
        return this.mIr;
    }
}
