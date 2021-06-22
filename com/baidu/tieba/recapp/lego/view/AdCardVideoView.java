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
import d.a.n0.r.q.d;
import d.a.o0.k1.o.c;
import d.a.o0.t2.f0.b.e;
import d.a.o0.t2.n;
import d.a.o0.t2.r;
/* loaded from: classes5.dex */
public class AdCardVideoView extends AdCardBaseView implements r {
    public DistributeVideoView n0;
    public TbPageContext o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int jump2DownloadDetailPage = AdCardVideoView.this.n0.jump2DownloadDetailPage();
            if (AdCardVideoView.this.o != null) {
                AdCardVideoView.this.o.a(jump2DownloadDetailPage, null);
            }
        }
    }

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.o0 = tbPageContext;
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
            this.p0 = i2;
            this.q0 = d.a.o0.t2.f0.c.a.b(i2);
        } else {
            int i3 = this.G;
            this.p0 = i3;
            this.q0 = d.a.o0.t2.f0.c.a.a(i3);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n0.getLayoutParams();
        layoutParams.height = this.q0;
        layoutParams.width = this.p0;
        if (adCard.goodsStyle == 14 && !M0(adCard)) {
            int i4 = this.G / 2;
            this.r0 = i4;
            this.s0 = d.a.o0.t2.f0.c.a.b(i4);
        } else {
            int i5 = this.G;
            this.r0 = i5;
            this.s0 = d.a.o0.t2.f0.c.a.a(i5);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.width = this.r0;
        layoutParams2.height = this.s0;
        this.t.requestLayout();
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void d0(AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            return;
        }
        N0(adCard);
        this.n0.setPageContext(this.o0);
        this.n0.setVideoTailFrameData(adCard.tailFrame);
        this.n0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.p0, this.q0, this.r0, this.s0);
        this.n0.setScheme(adCard.getScheme());
        this.n0.setAdInfo(adCard);
        this.n0.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.n0.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i2 = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.T3) ? getPageTypeByBusiness() : advertAppInfo.T3;
            d dVar = advertAppInfo.S3;
            if (dVar != null) {
                i2 = dVar.f53763b;
                pageTypeByBusiness = dVar.f53762a;
            }
            this.n0.setStatisticInfo(advertAppInfo, i2, pageTypeByBusiness);
        }
        this.n0.setOnClickListener(new a());
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }

    @Override // d.a.o0.t2.r
    public n getVideoOrVrView() {
        return this.n0;
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
        this.n0 = distributeVideoView;
        distributeVideoView.setHolderView(view);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.a.o0.k1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        this.n0.setDownloadCallback(cVar);
    }
}
