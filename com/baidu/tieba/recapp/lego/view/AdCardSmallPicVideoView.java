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
    public TextView alO;
    private AdCard kxc;
    public DistributeVideoView mtk;
    private XfremodeRoundLayout mvV;
    private TbImageView mvW;
    public ImageView mvZ;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void dD(View view) {
        float dimensionPixelSize = this.eIc.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mvV = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mvW = (TbImageView) view.findViewById(R.id.ad_img);
        this.alO = (TextView) view.findViewById(R.id.ad_video_duration);
        this.mvZ = (ImageView) view.findViewById(R.id.video_play_icon);
        this.mvW.setPlaceHolder(3);
        this.mvV.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.muM.setVisibility(8);
            return;
        }
        this.kxc = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.muM.setVisibility(0);
            this.mvW.startLoad(str, 17, false);
        }
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.bks()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.mtk == null) {
                        AdCardSmallPicVideoView.this.c(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.mtk != null) {
                        AdCardSmallPicVideoView.this.mtk.jump2DownloadDetailPage();
                    }
                    c.a(c.d(advertAppInfo));
                }
            });
        }
        this.mvZ.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.alO.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdCard adCard) {
        if (this.mtk == null) {
            this.mtk = new DistributeVideoView(getContext());
            this.mtk.setPageContext(this.eIc);
            this.mtk.setVideoTailFrameData(adCard.tailFrame);
            this.mtk.setData(adCard.videoInfo);
            this.mtk.setChargeInfo(adCard.chargeInfo);
            this.mtk.setScheme(adCard.getScheme());
            this.mtk.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.mtk.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
