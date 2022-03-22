package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import c.a.o0.r.r.e;
import c.a.p0.b2.o.c;
import c.a.p0.l3.j0.b.g;
import c.a.p0.l3.n;
import c.a.p0.l3.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.switchs.VideoCardLazyInitSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AdCardVideoView extends AdCardBaseView implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView j0;
    public TbPageContext k0;
    public int l0;
    public int m0;
    public int n0;
    public int o0;
    public int p0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardVideoView a;

        public a(AdCardVideoView adCardVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int jump2DownloadDetailPage = this.a.j0.jump2DownloadDetailPage();
                HashMap<String, Object> M = this.a.M("video");
                if (this.a.k != null) {
                    this.a.k.a(jump2DownloadDetailPage, M);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardVideoView(TbPageContext<?> tbPageContext, int i) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
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
        this.k0 = tbPageContext;
        this.p0 = i;
    }

    private String getPageTypeByBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int businessType = getBusinessType();
            return businessType != 1 ? (businessType == 2 || businessType == 3) ? "HOME" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) || adCard == null || adCard.videoInfo == null) {
            return;
        }
        t0(adCard);
        this.j0.setPageContext(this.k0);
        this.j0.setVideoTailFrameData(adCard.tailFrame);
        this.j0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.l0, this.m0, this.n0, this.o0);
        this.j0.setScheme(adCard.getScheme());
        this.j0.setAdInfo(adCard);
        this.j0.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.j0.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.k) ? getPageTypeByBusiness() : advertAppInfo.k;
            e eVar = advertAppInfo.j;
            if (eVar != null) {
                i = eVar.f10837b;
                pageTypeByBusiness = eVar.a;
            }
            this.j0.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
        }
        this.j0.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        float P = P(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{P, P, P, P, P, P, P, P});
        xfremodeRoundLayout.setLayerType(2, null);
        this.j0 = (IHomeAdVideoView) view.findViewById(R.id.obfuscated_res_0x7f090148);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.p0 == 2 && VideoCardLazyInitSwitch.getIsOn()) ? R.layout.obfuscated_res_0x7f0d0066 : R.layout.obfuscated_res_0x7f0d0069 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0178 : invokeV.intValue;
    }

    @Override // c.a.p0.l3.s
    public n getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j0 : (n) invokeV.objValue;
    }

    public boolean s0(AdCard adCard) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adCard)) == null) ? adCard != null && adCard.goodsStyle == 14 && (gVar = adCard.verticalVideoStyle) != null && gVar.a() : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, c.a.p0.b2.o.l.e
    public void setDownloadAppCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            super.setDownloadAppCallback(cVar);
            this.j0.setDownloadCallback(cVar);
        }
    }

    public final void t0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i = this.B / 2;
                this.l0 = i;
                this.m0 = c.a.p0.l3.j0.c.a.b(i);
            } else {
                int i2 = this.B;
                this.l0 = i2;
                this.m0 = c.a.p0.l3.j0.c.a.a(i2);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j0.getLayoutParams();
            layoutParams.height = this.m0;
            layoutParams.width = this.l0;
            if (adCard.goodsStyle == 14 && !s0(adCard)) {
                int i3 = this.B / 2;
                this.n0 = i3;
                this.o0 = c.a.p0.l3.j0.c.a.b(i3);
            } else {
                int i4 = this.B;
                this.n0 = i4;
                this.o0 = c.a.p0.l3.j0.c.a.a(i4);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams2.width = this.n0;
            layoutParams2.height = this.o0;
            this.o.requestLayout();
        }
    }
}
