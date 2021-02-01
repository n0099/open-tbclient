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
    public DistributeVideoView mRB;
    private AdCard mTF;
    private XfremodeRoundLayout mUA;
    private TbImageView mUB;
    public ImageView mUE;

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
        this.mUA = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mUB = (TbImageView) view.findViewById(R.id.ad_img);
        this.amy = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mUE = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mUB.setPlaceHolder(3);
        this.mUA.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.mTc.setVisibility(8);
            return;
        }
        this.mTF = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.mTc.setVisibility(0);
            this.mUB.startLoad(str, 17, false);
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.blE()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 0;
                    if (AdCardSmallPicVideoView.this.mRB == null) {
                        AdCardSmallPicVideoView.this.g(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mRB != null) {
                        i = AdCardSmallPicVideoView.this.mRB.jump2DownloadDetailPage();
                    }
                    if (AdCardSmallPicVideoView.this.lcl != null) {
                        AdCardSmallPicVideoView.this.lcl.d(i, null);
                    }
                }
            });
        }
        this.mUE.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.amy.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AdCard adCard) {
        if (this.mRB == null) {
            this.mRB = new DistributeVideoView(getContext());
            this.mRB.setPageContext(this.eUY);
            this.mRB.setVideoTailFrameData(adCard.tailFrame);
            this.mRB.setData(adCard.videoInfo);
            this.mRB.setChargeInfo(adCard.chargeInfo);
            this.mRB.setScheme(adCard.getScheme());
            this.mRB.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mRB.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
