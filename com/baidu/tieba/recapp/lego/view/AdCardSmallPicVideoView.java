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
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes20.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView ajE;
    public DistributeVideoView llR;
    private XfremodeRoundLayout loG;
    private TbImageView loH;
    public ImageView loK;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void de(View view) {
        float dimensionPixelSize = this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.loG = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.loH = (TbImageView) view.findViewById(R.id.ad_img);
        this.ajE = (TextView) view.findViewById(R.id.ad_video_duration);
        this.loK = (ImageView) view.findViewById(R.id.video_play_icon);
        this.loH.setPlaceHolder(3);
        this.loG.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.lnu.setVisibility(8);
            return;
        }
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.lnu.setVisibility(0);
            this.loH.startLoad(str, 17, false);
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.aUf()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.llR == null) {
                        AdCardSmallPicVideoView.this.c(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.llR != null) {
                        AdCardSmallPicVideoView.this.llR.jump2DownloadDetailPage();
                    }
                }
            });
        }
        this.loK.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.ajE.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdCard adCard) {
        if (this.llR == null) {
            this.llR = new DistributeVideoView(getContext());
            this.llR.setPageContext(this.dVN);
            this.llR.setVideoTailFrameData(adCard.tailFrame);
            this.llR.setData(adCard.videoInfo);
            this.llR.setChargeInfo(adCard.chargeInfo);
            this.llR.setScheme(adCard.getScheme());
            this.llR.setParallelChargeInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.llR.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
