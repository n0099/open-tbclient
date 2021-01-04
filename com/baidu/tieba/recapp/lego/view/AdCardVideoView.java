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
/* loaded from: classes8.dex */
public class AdCardVideoView extends AdCardBaseView implements m {
    public DistributeVideoView mMZ;
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
            float Jg = Jg(R.string.J_X05);
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{Jg, Jg, Jg, Jg, Jg, Jg, Jg, Jg});
            ((XfremodeRoundLayout) view).setLayerType(2, null);
            this.mMZ = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.mMZ.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            this.mMZ.setPageContext(this.mTbPageContext);
            this.mMZ.setVideoTailFrameData(adCard.tailFrame);
            this.mMZ.setData(adCard.videoInfo, this.mMaxWidth, this.mImageHeight, this.mImageWidth);
            this.mMZ.setChargeInfo(adCard.chargeInfo);
            this.mMZ.setScheme(adCard.getScheme());
            this.mMZ.setAdInfo(adCard);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mMZ.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mOy.getLayoutParams();
            if (adCard.goodsStyle == 14) {
                ViewGroup.LayoutParams layoutParams3 = this.mOX.getLayoutParams();
                int equipmentWidth = layoutParams3.width > 0 ? layoutParams3.width / 2 : (l.getEquipmentWidth(getContext()) - (this.mOD * 2)) / 2;
                layoutParams.width = equipmentWidth;
                layoutParams2.width = equipmentWidth;
                int Je = a.Je(layoutParams.width);
                layoutParams.height = Je;
                layoutParams2.height = Je;
                layoutParams.gravity = 3;
                layoutParams2.gravity = 3;
            } else {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                layoutParams.gravity = 1;
                layoutParams2.gravity = 1;
            }
            this.mOy.requestLayout();
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.mMZ.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.page) ? getPageTypeByBusiness() : advertAppInfo.page;
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mMZ.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            this.mMZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardVideoView.this.mMZ.jump2DownloadDetailPage();
                    AdCardVideoView.this.dFn();
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
        this.mMZ.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.m
    public j getVideoOrVrView() {
        return this.mMZ;
    }
}
