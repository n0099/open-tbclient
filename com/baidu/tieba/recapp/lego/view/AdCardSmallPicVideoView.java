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
/* loaded from: classes13.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView ain;
    public DistributeVideoView kJA;
    private XfremodeRoundLayout kMj;
    private TbImageView kMk;
    public ImageView kMn;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void cX(View view) {
        float dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.kMj = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.kMk = (TbImageView) view.findViewById(R.id.ad_img);
        this.ain = (TextView) view.findViewById(R.id.ad_video_duration);
        this.kMn = (ImageView) view.findViewById(R.id.video_play_icon);
        this.kMk.setPlaceHolder(3);
        this.kMj.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.kLa.setVisibility(8);
            return;
        }
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.kLa.setVisibility(0);
            this.kMk.startLoad(str, 17, false);
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.aOz()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.kJA == null) {
                        AdCardSmallPicVideoView.this.c(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.kJA != null) {
                        AdCardSmallPicVideoView.this.kJA.jump2DownloadDetailPage();
                    }
                }
            });
        }
        this.kMn.setImageDrawable(SvgManager.aUV().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.ain.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdCard adCard) {
        if (this.kJA == null) {
            this.kJA = new DistributeVideoView(getContext());
            this.kJA.setPageContext(this.dIF);
            this.kJA.setVideoTailFrameData(adCard.tailFrame);
            this.kJA.setData(adCard.videoInfo);
            this.kJA.setChargeInfo(adCard.chargeInfo);
            this.kJA.setScheme(adCard.getScheme());
            this.kJA.setParallelChargeInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.kJA.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
