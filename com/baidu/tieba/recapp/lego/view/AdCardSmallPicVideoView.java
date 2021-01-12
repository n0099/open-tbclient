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
import com.baidu.tieba.lego.card.a.c;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
/* loaded from: classes7.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView amI;
    public DistributeVideoView mIr;
    private AdCard mKu;
    private XfremodeRoundLayout mLm;
    private TbImageView mLn;
    public ImageView mLq;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void ec(View view) {
        float dimensionPixelSize = this.eSJ.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mLm = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mLn = (TbImageView) view.findViewById(R.id.ad_img);
        this.amI = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mLq = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mLn.setPlaceHolder(3);
        this.mLm.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.mJT.setVisibility(8);
            return;
        }
        this.mKu = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.mJT.setVisibility(0);
            this.mLn.startLoad(str, 17, false);
        }
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.blm()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.mIr == null) {
                        AdCardSmallPicVideoView.this.f(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mIr != null) {
                        AdCardSmallPicVideoView.this.mIr.jump2DownloadDetailPage();
                    }
                    c.a(c.c(advertAppInfo));
                }
            });
        }
        this.mLq.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.amI.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AdCard adCard) {
        if (this.mIr == null) {
            this.mIr = new DistributeVideoView(getContext());
            this.mIr.setPageContext(this.eSJ);
            this.mIr.setVideoTailFrameData(adCard.tailFrame);
            this.mIr.setData(adCard.videoInfo);
            this.mIr.setChargeInfo(adCard.chargeInfo);
            this.mIr.setScheme(adCard.getScheme());
            this.mIr.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mIr.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
