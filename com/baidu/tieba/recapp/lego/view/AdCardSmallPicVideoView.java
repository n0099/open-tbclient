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
import d.b.h0.r.q.d;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public TbImageView A;
    public TextView B;
    public DistributeVideoView C;
    public ImageView D;
    public XfremodeRoundLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard f20767e;

        public a(AdCard adCard) {
            this.f20767e = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCardSmallPicVideoView adCardSmallPicVideoView = AdCardSmallPicVideoView.this;
            if (adCardSmallPicVideoView.C == null) {
                adCardSmallPicVideoView.c0(this.f20767e);
            }
            DistributeVideoView distributeVideoView = AdCardSmallPicVideoView.this.C;
            int jump2DownloadDetailPage = distributeVideoView != null ? distributeVideoView.jump2DownloadDetailPage() : 0;
            if (AdCardSmallPicVideoView.this.o != null) {
                AdCardSmallPicVideoView.this.o.a(jump2DownloadDetailPage, null);
            }
        }
    }

    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    private String getPageTypeByBusiness() {
        int businessType = getBusinessType();
        return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void S(AdCard adCard) {
        VideoInfo videoInfo;
        if (adCard != null && (videoInfo = adCard.videoInfo) != null) {
            String str = videoInfo.thumbnail_url;
            if (!TextUtils.isEmpty(str)) {
                this.t.setVisibility(0);
                this.A.W(str, 17, false);
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.A4()) {
                this.r.setOnClickListener(new a(adCard));
            }
            this.D.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.B.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
            return;
        }
        this.t.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void U(View view) {
        float dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.z = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.A = (TbImageView) view.findViewById(R.id.ad_img);
        this.B = (TextView) view.findViewById(R.id.ad_video_duration);
        this.D = (ImageView) view.findViewById(R.id.video_play_icon);
        this.A.setPlaceHolder(3);
        this.z.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    public final void c0(AdCard adCard) {
        if (this.C != null) {
            return;
        }
        DistributeVideoView distributeVideoView = new DistributeVideoView(getContext());
        this.C = distributeVideoView;
        distributeVideoView.setPageContext(this.m);
        this.C.setVideoTailFrameData(adCard.tailFrame);
        this.C.setData(adCard.videoInfo);
        this.C.setChargeInfo(adCard.chargeInfo);
        this.C.setScheme(adCard.getScheme());
        this.C.setAdInfo(adCard);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (advertAppInfo != null) {
            int i = -1;
            String pageTypeByBusiness = getPageTypeByBusiness();
            d dVar = advertAppInfo.Y3;
            if (dVar != null) {
                i = dVar.f50749b;
                pageTypeByBusiness = dVar.f50748a;
            }
            this.C.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        return R.layout.ad_card_small_pic_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        return R.layout.card_small_pic_ad;
    }
}
