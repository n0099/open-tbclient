package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n1.o.c;
import d.a.q0.w2.f0.b.e;
import d.a.q0.w2.m;
import d.a.q0.w2.q;
/* loaded from: classes4.dex */
public class AdCardVideoView extends AdCardBaseView implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DistributeVideoView n0;
    public TbPageContext o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardVideoView f20648e;

        public a(AdCardVideoView adCardVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20648e = adCardVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int jump2DownloadDetailPage = this.f20648e.n0.jump2DownloadDetailPage();
                if (this.f20648e.o != null) {
                    this.f20648e.o.a(jump2DownloadDetailPage, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o0 = tbPageContext;
    }

    private String getPageTypeByBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int businessType = getBusinessType();
            return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
        }
        return (String) invokeV.objValue;
    }

    public boolean L0(AdCard adCard) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adCard)) == null) ? adCard != null && adCard.goodsStyle == 14 && (eVar = adCard.verticalVideoStyle) != null && eVar.a() : invokeL.booleanValue;
    }

    public final void M0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i2 = this.G / 2;
                this.p0 = i2;
                this.q0 = d.a.q0.w2.f0.c.a.b(i2);
            } else {
                int i3 = this.G;
                this.p0 = i3;
                this.q0 = d.a.q0.w2.f0.c.a.a(i3);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n0.getLayoutParams();
            layoutParams.height = this.q0;
            layoutParams.width = this.p0;
            if (adCard.goodsStyle == 14 && !L0(adCard)) {
                int i4 = this.G / 2;
                this.r0 = i4;
                this.s0 = d.a.q0.w2.f0.c.a.b(i4);
            } else {
                int i5 = this.G;
                this.r0 = i5;
                this.s0 = d.a.q0.w2.f0.c.a.a(i5);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams2.width = this.r0;
            layoutParams2.height = this.s0;
            this.t.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void c0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) || adCard == null || adCard.videoInfo == null) {
            return;
        }
        M0(adCard);
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
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.b4) ? getPageTypeByBusiness() : advertAppInfo.b4;
            d.a.p0.s.q.e eVar = advertAppInfo.a4;
            if (eVar != null) {
                i2 = eVar.f53297b;
                pageTypeByBusiness = eVar.f53296a;
            }
            this.n0.setStatisticInfo(advertAppInfo, i2, pageTypeByBusiness);
        }
        this.n0.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ad_card_video_view : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.card_ad : invokeV.intValue;
    }

    @Override // d.a.q0.w2.q
    public m getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n0 : (m) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void j0(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || view == null) {
            return;
        }
        float d0 = d0(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{d0, d0, d0, d0, d0, d0, d0, d0});
        xfremodeRoundLayout.setLayerType(2, null);
        DistributeVideoView distributeVideoView = (DistributeVideoView) view.findViewById(R.id.advert_video);
        this.n0 = distributeVideoView;
        distributeVideoView.setHolderView(view);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.a.q0.n1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            super.setDownloadAppCallback(cVar);
            this.n0.setDownloadCallback(cVar);
        }
    }
}
