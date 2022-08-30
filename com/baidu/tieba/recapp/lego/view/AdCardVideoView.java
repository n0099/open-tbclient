package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.switchs.VideoCardLazyInitSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ac8;
import com.baidu.tieba.id8;
import com.baidu.tieba.kd8;
import com.baidu.tieba.mo4;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.tieba.wb8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AdCardVideoView extends AdCardBaseView implements ac8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView a0;
    public TbPageContext b0;
    public int c0;
    public int d0;
    public int e0;
    public int f0;
    public int g0;

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
                int jump2DownloadDetailPage = this.a.a0.jump2DownloadDetailPage();
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
        this.b0 = tbPageContext;
        this.g0 = i;
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
        r0(adCard);
        this.a0.setPageContext(this.b0);
        this.a0.setVideoTailFrameData(adCard.tailFrame);
        this.a0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.c0, this.d0, this.e0, this.f0);
        this.a0.setScheme(adCard.getScheme());
        this.a0.setAdInfo(adCard);
        this.a0.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.a0.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.j) ? getPageTypeByBusiness() : advertAppInfo.j;
            mo4 mo4Var = advertAppInfo.i;
            if (mo4Var != null) {
                i = mo4Var.b;
                pageTypeByBusiness = mo4Var.a;
            }
            this.a0.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
        }
        this.a0.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || view2 == null) {
            return;
        }
        float P = P(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view2;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{P, P, P, P, P, P, P, P});
        xfremodeRoundLayout.setLayerType(2, null);
        this.a0 = (IHomeAdVideoView) view2.findViewById(R.id.obfuscated_res_0x7f09014b);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.g0 == 2 && VideoCardLazyInitSwitch.getIsOn()) ? R.layout.obfuscated_res_0x7f0d0064 : R.layout.obfuscated_res_0x7f0d0065 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0174 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ac8
    public wb8 getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a0 : (wb8) invokeV.objValue;
    }

    public boolean q0(AdCard adCard) {
        InterceptResult invokeL;
        id8 id8Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adCard)) == null) ? adCard != null && adCard.goodsStyle == 14 && (id8Var = adCard.verticalVideoStyle) != null && id8Var.a() : invokeL.booleanValue;
    }

    public final void r0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i = this.B / 2;
                this.c0 = i;
                this.d0 = kd8.b(i);
            } else {
                int i2 = this.B;
                this.c0 = i2;
                this.d0 = kd8.a(i2);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a0.getLayoutParams();
            layoutParams.height = this.d0;
            layoutParams.width = this.c0;
            if (adCard.goodsStyle == 14 && !q0(adCard)) {
                int i3 = this.B / 2;
                this.e0 = i3;
                this.f0 = kd8.b(i3);
            } else {
                int i4 = this.B;
                this.e0 = i4;
                this.f0 = kd8.a(i4);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams2.width = this.e0;
            layoutParams2.height = this.f0;
            this.o.requestLayout();
        }
    }
}
