package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bg8;
import com.baidu.tieba.jh8;
import com.baidu.tieba.lh8;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.tieba.xf8;
import com.baidu.tieba.yr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AdCardVideoView extends AdCardBaseView implements bg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView b0;
    public TbPageContext c0;
    public int d0;
    public int e0;
    public int f0;
    public int g0;
    public int h0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0178 : invokeV.intValue;
    }

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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int jump2DownloadDetailPage = this.a.b0.jump2DownloadDetailPage();
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
        this.c0 = tbPageContext;
        this.h0 = i;
    }

    private String getPageTypeByBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int businessType = getBusinessType();
            if (businessType != 1) {
                if (businessType != 2 && businessType != 3) {
                    if (businessType != 4) {
                        return "unknown";
                    }
                    return "PB_BANNER";
                }
                return "HOME";
            }
            return "FRS";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h0 == 2) {
                return R.layout.obfuscated_res_0x7f0d0065;
            }
            return R.layout.obfuscated_res_0x7f0d0066;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bg8
    public xf8 getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b0;
        }
        return (xf8) invokeV.objValue;
    }

    public boolean q0(AdCard adCard) {
        InterceptResult invokeL;
        jh8 jh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adCard)) == null) {
            if (adCard == null || adCard.goodsStyle != 14 || (jh8Var = adCard.verticalVideoStyle) == null || !jh8Var.a()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) && adCard != null && adCard.videoInfo != null) {
            r0(adCard);
            this.b0.setPageContext(this.c0);
            this.b0.setVideoTailFrameData(adCard.tailFrame);
            this.b0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.d0, this.e0, this.f0, this.g0);
            this.b0.setScheme(adCard.getScheme());
            this.b0.setAdInfo(adCard);
            this.b0.setVideoScalingMode(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.b0.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                if (TextUtils.isEmpty(advertAppInfo.j)) {
                    str = getPageTypeByBusiness();
                } else {
                    str = advertAppInfo.j;
                }
                yr4 yr4Var = advertAppInfo.i;
                if (yr4Var != null) {
                    i = yr4Var.b;
                    str = yr4Var.a;
                }
                this.b0.setStatisticInfo(advertAppInfo, i, str);
            }
            this.b0.setOnClickListener(new a(this));
        }
    }

    public final void r0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i = this.B / 2;
                this.d0 = i;
                this.e0 = lh8.b(i);
            } else {
                int i2 = this.B;
                this.d0 = i2;
                this.e0 = lh8.a(i2);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b0.getLayoutParams();
            layoutParams.height = this.e0;
            layoutParams.width = this.d0;
            if (adCard.goodsStyle == 14 && !q0(adCard)) {
                int i3 = this.B / 2;
                this.f0 = i3;
                this.g0 = lh8.b(i3);
            } else {
                int i4 = this.B;
                this.f0 = i4;
                this.g0 = lh8.a(i4);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams2.width = this.f0;
            layoutParams2.height = this.g0;
            this.o.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null) {
            return;
        }
        float P = P(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view2;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{P, P, P, P, P, P, P, P});
        xfremodeRoundLayout.setLayerType(2, null);
        this.b0 = (IHomeAdVideoView) view2.findViewById(R.id.obfuscated_res_0x7f090153);
    }
}
