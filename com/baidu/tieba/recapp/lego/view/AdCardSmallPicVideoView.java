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
/* loaded from: classes25.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView alU;
    public DistributeVideoView mtA;
    private AdCard mvE;
    public ImageView mwA;
    private XfremodeRoundLayout mww;
    private TbImageView mwx;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void dH(View view) {
        float dimensionPixelSize = this.eGu.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mww = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mwx = (TbImageView) view.findViewById(R.id.ad_img);
        this.alU = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mwA = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mwx.setPlaceHolder(3);
        this.mww.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.mvd.setVisibility(8);
            return;
        }
        this.mvE = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.mvd.setVisibility(0);
            this.mwx.startLoad(str, 17, false);
        }
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.bju()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.mtA == null) {
                        AdCardSmallPicVideoView.this.f(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mtA != null) {
                        AdCardSmallPicVideoView.this.mtA.jump2DownloadDetailPage();
                    }
                    c.a(c.c(advertAppInfo));
                }
            });
        }
        this.mwA.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.alU.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AdCard adCard) {
        if (this.mtA == null) {
            this.mtA = new DistributeVideoView(getContext());
            this.mtA.setPageContext(this.eGu);
            this.mtA.setVideoTailFrameData(adCard.tailFrame);
            this.mtA.setData(adCard.videoInfo);
            this.mtA.setChargeInfo(adCard.chargeInfo);
            this.mtA.setScheme(adCard.getScheme());
            this.mtA.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mtA.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
