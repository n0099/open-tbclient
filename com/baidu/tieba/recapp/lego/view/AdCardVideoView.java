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
import d.b.i0.r.q.d;
import d.b.j0.j1.o.c;
import d.b.j0.s2.m;
import d.b.j0.s2.q;
/* loaded from: classes4.dex */
public class AdCardVideoView extends AdCardBaseView implements q {
    public DistributeVideoView m0;
    public TbPageContext n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int jump2DownloadDetailPage = AdCardVideoView.this.m0.jump2DownloadDetailPage();
            if (AdCardVideoView.this.o != null) {
                AdCardVideoView.this.o.a(jump2DownloadDetailPage, null);
            }
        }
    }

    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n0 = tbPageContext;
    }

    private String getPageTypeByBusiness() {
        int businessType = getBusinessType();
        return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void A0(AdCard adCard) {
        if (adCard == null || adCard.videoInfo == null) {
            return;
        }
        g1(adCard);
        this.m0.setPageContext(this.n0);
        this.m0.setVideoTailFrameData(adCard.tailFrame);
        this.m0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.o0, this.p0, this.q0, this.r0);
        this.m0.setChargeInfo(adCard.chargeInfo);
        this.m0.setScheme(adCard.getScheme());
        this.m0.setAdInfo(adCard);
        this.m0.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.m0.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.c4) ? getPageTypeByBusiness() : advertAppInfo.c4;
            d dVar = advertAppInfo.Y3;
            if (dVar != null) {
                i = dVar.f51493b;
                pageTypeByBusiness = dVar.f51492a;
            }
            this.m0.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
        }
        this.m0.setOnClickListener(new a());
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void G0(View view) {
        if (view == null) {
            return;
        }
        float B0 = B0(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{B0, B0, B0, B0, B0, B0, B0, B0});
        xfremodeRoundLayout.setLayerType(2, null);
        DistributeVideoView distributeVideoView = (DistributeVideoView) view.findViewById(R.id.advert_video);
        this.m0 = distributeVideoView;
        distributeVideoView.setHolderView(view);
    }

    public boolean f1(AdCard adCard) {
        AdCard.f fVar;
        return adCard != null && adCard.goodsStyle == 14 && (fVar = adCard.verticalVideoStyle) != null && fVar.a();
    }

    public final void g1(AdCard adCard) {
        if (adCard.goodsStyle == 14) {
            int i = this.G / 2;
            this.o0 = i;
            this.p0 = d.b.j0.s2.c0.c.a.b(i);
        } else {
            int i2 = this.G;
            this.o0 = i2;
            this.p0 = d.b.j0.s2.c0.c.a.a(i2);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m0.getLayoutParams();
        layoutParams.height = this.p0;
        layoutParams.width = this.o0;
        if (adCard.goodsStyle == 14 && !f1(adCard)) {
            int i3 = this.G / 2;
            this.q0 = i3;
            this.r0 = d.b.j0.s2.c0.c.a.b(i3);
        } else {
            int i4 = this.G;
            this.q0 = i4;
            this.r0 = d.b.j0.s2.c0.c.a.a(i4);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.width = this.q0;
        layoutParams2.height = this.r0;
        this.t.requestLayout();
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.ad_card_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }

    @Override // d.b.j0.s2.q
    public m getVideoOrVrView() {
        return this.m0;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.b.j0.j1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        this.m0.setDownloadCallback(cVar);
    }
}
