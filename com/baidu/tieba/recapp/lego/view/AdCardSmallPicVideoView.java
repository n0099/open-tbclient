package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.c;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes26.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView amU;
    public DistributeVideoView mHH;
    private AdCard mJQ;
    private XfremodeRoundLayout mKI;
    private TbImageView mKJ;
    public ImageView mKM;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void dS(View view) {
        float dimensionPixelSize = this.eNx.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mKI = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mKJ = (TbImageView) view.findViewById(R.id.ad_img);
        this.amU = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mKM = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mKJ.setPlaceHolder(3);
        this.mKI.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.mJp.setVisibility(8);
            return;
        }
        this.mJQ = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.mJp.setVisibility(0);
            this.mKJ.startLoad(str, 17, false);
        }
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.bmE()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.mHH == null) {
                        AdCardSmallPicVideoView.this.f(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mHH != null) {
                        AdCardSmallPicVideoView.this.mHH.jump2DownloadDetailPage();
                    }
                    c.a(c.c(advertAppInfo));
                }
            });
        }
        this.mKM.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.amU.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AdCard adCard) {
        if (this.mHH == null) {
            this.mHH = new DistributeVideoView(getContext());
            this.mHH.setPageContext(this.eNx);
            this.mHH.setVideoTailFrameData(adCard.tailFrame);
            this.mHH.setData(adCard.videoInfo);
            this.mHH.setChargeInfo(adCard.chargeInfo);
            this.mHH.setScheme(adCard.getScheme());
            this.mHH.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mHH.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
}
