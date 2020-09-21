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
    public TextView alv;
    private AdCard jPJ;
    public DistributeVideoView lLx;
    private XfremodeRoundLayout lOi;
    private TbImageView lOj;
    public ImageView lOm;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void dq(View view) {
        float dimensionPixelSize = this.ehG.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lOi = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.lOj = (TbImageView) view.findViewById(R.id.ad_img);
        this.alv = (TextView) view.findViewById(R.id.ad_video_duration);
        this.lOm = (ImageView) view.findViewById(R.id.video_play_icon);
        this.lOj.setPlaceHolder(3);
        this.lOi.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.lMZ.setVisibility(8);
            return;
        }
        this.jPJ = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.lMZ.setVisibility(0);
            this.lOj.startLoad(str, 17, false);
        }
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.bdq()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.lLx == null) {
                        AdCardSmallPicVideoView.this.c(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.lLx != null) {
                        AdCardSmallPicVideoView.this.lLx.jump2DownloadDetailPage();
                    }
                    c.a(c.d(advertAppInfo));
                }
            });
        }
        this.lOm.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.alv.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdCard adCard) {
        if (this.lLx == null) {
            this.lLx = new DistributeVideoView(getContext());
            this.lLx.setPageContext(this.ehG);
            this.lLx.setVideoTailFrameData(adCard.tailFrame);
            this.lLx.setData(adCard.videoInfo);
            this.lLx.setChargeInfo(adCard.chargeInfo);
            this.lLx.setScheme(adCard.getScheme());
            this.lLx.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.lLx.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
