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
/* loaded from: classes20.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TextView akT;
    private AdCard jHb;
    public DistributeVideoView lCs;
    private XfremodeRoundLayout lFb;
    private TbImageView lFc;
    public ImageView lFf;

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void di(View view) {
        float dimensionPixelSize = this.efn.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lFb = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.lFc = (TbImageView) view.findViewById(R.id.ad_img);
        this.akT = (TextView) view.findViewById(R.id.ad_video_duration);
        this.lFf = (ImageView) view.findViewById(R.id.video_play_icon);
        this.lFc.setPlaceHolder(3);
        this.lFb.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(final AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            this.lDU.setVisibility(8);
            return;
        }
        this.jHb = adCard;
        String str = adCard.videoInfo.thumbnail_url;
        if (!TextUtils.isEmpty(str)) {
            this.lDU.setVisibility(0);
            this.lFc.startLoad(str, 17, false);
        }
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardSmallPicVideoView.this.lCs == null) {
                        AdCardSmallPicVideoView.this.c(adCard);
                    }
                    if (AdCardSmallPicVideoView.this.lCs != null) {
                        AdCardSmallPicVideoView.this.lCs.jump2DownloadDetailPage();
                    }
                    c.a(c.d(advertAppInfo));
                }
            });
        }
        this.lFf.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.akT.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdCard adCard) {
        if (this.lCs == null) {
            this.lCs = new DistributeVideoView(getContext());
            this.lCs.setPageContext(this.efn);
            this.lCs.setVideoTailFrameData(adCard.tailFrame);
            this.lCs.setData(adCard.videoInfo);
            this.lCs.setChargeInfo(adCard.chargeInfo);
            this.lCs.setScheme(adCard.getScheme());
            this.lCs.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                if (advertAppInfo.advertAppContext != null) {
                    i = advertAppInfo.advertAppContext.pn;
                    pageTypeByBusiness = advertAppInfo.advertAppContext.page;
                }
                this.lCs.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
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
