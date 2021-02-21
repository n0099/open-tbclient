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
/* loaded from: classes8.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView amy;
    public DistributeVideoView mRT;
    private AdCard mUg;
    private XfremodeRoundLayout mVb;
    private TbImageView mVc;
    public ImageView mVf;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void ea(View view) {
        float dimensionPixelSize = this.eUY.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mVb = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mVc = (TbImageView) view.findViewById(R.id.ad_img);
        this.amy = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mVf = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mVc.setPlaceHolder(3);
        this.mVb.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.mTE.setVisibility(8);
            return;
        }
        this.mUg = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.mTE.setVisibility(0);
            this.mVc.startLoad(str, 17, false);
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.blE()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 0;
                    if (AdCardSmallPicVideoView.this.mRT == null) {
                        AdCardSmallPicVideoView.this.g(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mRT != null) {
                        i = AdCardSmallPicVideoView.this.mRT.jump2DownloadDetailPage();
                    }
                    if (AdCardSmallPicVideoView.this.lcA != null) {
                        AdCardSmallPicVideoView.this.lcA.d(i, null);
                    }
                }
            });
        }
        this.mVf.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.amy.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AdCard adCard) {
        if (this.mRT == null) {
            this.mRT = new DistributeVideoView(getContext());
            this.mRT.setPageContext(this.eUY);
            this.mRT.setVideoTailFrameData(adCard.tailFrame);
            this.mRT.setData(adCard.videoInfo);
            this.mRT.setChargeInfo(adCard.chargeInfo);
            this.mRT.setScheme(adCard.getScheme());
            this.mRT.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mRT.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
