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
/* loaded from: classes7.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView anQ;
    public DistributeVideoView mTZ;
    private AdCard mWq;
    private XfremodeRoundLayout mXk;
    private TbImageView mXl;
    public ImageView mXo;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void ea(View view) {
        float dimensionPixelSize = this.eWx.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mXk = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mXl = (TbImageView) view.findViewById(R.id.ad_img);
        this.anQ = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mXo = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mXl.setPlaceHolder(3);
        this.mXk.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.mVP.setVisibility(8);
            return;
        }
        this.mWq = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.mVP.setVisibility(0);
            this.mXl.startLoad(str, 17, false);
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.blG()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 0;
                    if (AdCardSmallPicVideoView.this.mTZ == null) {
                        AdCardSmallPicVideoView.this.g(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mTZ != null) {
                        i = AdCardSmallPicVideoView.this.mTZ.jump2DownloadDetailPage();
                    }
                    if (AdCardSmallPicVideoView.this.leD != null) {
                        AdCardSmallPicVideoView.this.leD.d(i, null);
                    }
                }
            });
        }
        this.mXo.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.anQ.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AdCard adCard) {
        if (this.mTZ == null) {
            this.mTZ = new DistributeVideoView(getContext());
            this.mTZ.setPageContext(this.eWx);
            this.mTZ.setVideoTailFrameData(adCard.tailFrame);
            this.mTZ.setData(adCard.videoInfo);
            this.mTZ.setChargeInfo(adCard.chargeInfo);
            this.mTZ.setScheme(adCard.getScheme());
            this.mTZ.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mTZ.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
