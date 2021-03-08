package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.a.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes7.dex */
public class AdCardVideoView extends AdCardBaseView implements n {
    public DistributeVideoView mTZ;
    private TbPageContext mTbPageContext;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mXq;
    private int mXr;

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void ea(View view) {
        if (view != null) {
            float HW = HW(R.string.J_X05);
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{HW, HW, HW, HW, HW, HW, HW, HW});
            ((XfremodeRoundLayout) view).setLayerType(2, null);
            this.mTZ = (DistributeVideoView) view.findViewById(R.id.advert_video);
            this.mTZ.setHolderView(view);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.videoInfo != null) {
            h(adCard);
            this.mTZ.setPageContext(this.mTbPageContext);
            this.mTZ.setVideoTailFrameData(adCard.tailFrame);
            this.mTZ.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.mVideoWidth, this.mVideoHeight, this.mXq, this.mXr);
            this.mTZ.setChargeInfo(adCard.chargeInfo);
            this.mTZ.setScheme(adCard.getScheme());
            this.mTZ.setAdInfo(adCard);
            this.mTZ.setVideoScalingMode(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.mTZ.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.page) ? getPageTypeByBusiness() : advertAppInfo.page;
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mTZ.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
            this.mTZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int jump2DownloadDetailPage = AdCardVideoView.this.mTZ.jump2DownloadDetailPage();
                    if (AdCardVideoView.this.leD != null) {
                        AdCardVideoView.this.leD.d(jump2DownloadDetailPage, null);
                    }
                }
            });
        }
    }

    private void h(AdCard adCard) {
        if (adCard.goodsStyle == 14) {
            this.mVideoWidth = this.mMaxWidth / 2;
            this.mVideoHeight = a.HT(this.mVideoWidth);
        } else {
            this.mVideoWidth = this.mMaxWidth;
            this.mVideoHeight = a.HV(this.mVideoWidth);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTZ.getLayoutParams();
        layoutParams.height = this.mVideoHeight;
        layoutParams.width = this.mVideoWidth;
        if (adCard.goodsStyle == 14 && !i(adCard)) {
            this.mXq = this.mMaxWidth / 2;
            this.mXr = a.HT(this.mXq);
        } else {
            this.mXq = this.mMaxWidth;
            this.mXr = a.HV(this.mXq);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mVP.getLayoutParams();
        layoutParams2.width = this.mXq;
        layoutParams2.height = this.mXr;
        this.mVP.requestLayout();
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
        this.mTZ.setDownloadCallback(cVar);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.n
    public k getVideoOrVrView() {
        return this.mTZ;
    }

    public boolean i(AdCard adCard) {
        return adCard != null && adCard.goodsStyle == 14 && adCard.verticalVideoStyle != null && adCard.verticalVideoStyle.isValid();
    }
}
