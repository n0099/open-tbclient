package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import d.a.m0.r.q.d;
import d.a.n0.k1.o.c;
import d.a.n0.t2.f0.b.e;
import d.a.n0.t2.n;
import d.a.n0.t2.r;
/* loaded from: classes5.dex */
public class AdCardVideoView extends AdCardBaseView implements r {
    public DistributeVideoView i0;
    public TbPageContext j0;
    public int k0;
    public int l0;
    public int m0;
    public int n0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int jump2DownloadDetailPage = AdCardVideoView.this.i0.jump2DownloadDetailPage();
            if (AdCardVideoView.this.o != null) {
                AdCardVideoView.this.o.a(jump2DownloadDetailPage, null);
            }
        }
    }

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.j0 = tbPageContext;
    }

    private String getPageTypeByBusiness() {
        int businessType = getBusinessType();
        return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
    }

    public boolean M0(AdCard adCard) {
        e eVar;
        return adCard != null && adCard.goodsStyle == 14 && (eVar = adCard.verticalVideoStyle) != null && eVar.a();
    }

    public final void N0(AdCard adCard) {
        if (adCard.goodsStyle == 14) {
            int i2 = this.G / 2;
            this.k0 = i2;
            this.l0 = d.a.n0.t2.f0.c.a.b(i2);
        } else {
            int i3 = this.G;
            this.k0 = i3;
            this.l0 = d.a.n0.t2.f0.c.a.a(i3);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i0.getLayoutParams();
        layoutParams.height = this.l0;
        layoutParams.width = this.k0;
        if (adCard.goodsStyle == 14 && !M0(adCard)) {
            int i4 = this.G / 2;
            this.m0 = i4;
            this.n0 = d.a.n0.t2.f0.c.a.b(i4);
        } else {
            int i5 = this.G;
            this.m0 = i5;
            this.n0 = d.a.n0.t2.f0.c.a.a(i5);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.width = this.m0;
        layoutParams2.height = this.n0;
        this.t.requestLayout();
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void d0(AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            return;
        }
        N0(adCard);
        this.i0.setPageContext(this.j0);
        this.i0.setVideoTailFrameData(adCard.tailFrame);
        this.i0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.k0, this.l0, this.m0, this.n0);
        this.i0.setScheme(adCard.getScheme());
        this.i0.setAdInfo(adCard);
        this.i0.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.i0.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i2 = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.T3) ? getPageTypeByBusiness() : advertAppInfo.T3;
            d dVar = advertAppInfo.S3;
            if (dVar != null) {
                i2 = dVar.f53656b;
                pageTypeByBusiness = dVar.f53655a;
            }
            this.i0.setStatisticInfo(advertAppInfo, i2, pageTypeByBusiness);
        }
        this.i0.setOnClickListener(new a());
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }

    @Override // d.a.n0.t2.r
    public n getVideoOrVrView() {
        return this.i0;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void k0(View view) {
        if (view == null) {
            return;
        }
        float e0 = e0(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{e0, e0, e0, e0, e0, e0, e0, e0});
        xfremodeRoundLayout.setLayerType(2, null);
        DistributeVideoView distributeVideoView = (DistributeVideoView) view.findViewById(R.id.advert_video);
        this.i0 = distributeVideoView;
        distributeVideoView.setHolderView(view);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.a.n0.k1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        this.i0.setDownloadCallback(cVar);
    }
}
