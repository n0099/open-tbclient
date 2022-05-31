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
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g78;
import com.repackage.k78;
import com.repackage.s88;
import com.repackage.tm4;
import com.repackage.u88;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdCardVideoView extends AdCardBaseView implements k78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView V;
    public TbPageContext W;
    public int g0;
    public int h0;
    public int i0;
    public int j0;
    public int k0;

    /* loaded from: classes3.dex */
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
                int jump2DownloadDetailPage = this.a.V.jump2DownloadDetailPage();
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
        this.W = tbPageContext;
        this.k0 = i;
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
        q0(adCard);
        this.V.setPageContext(this.W);
        this.V.setVideoTailFrameData(adCard.tailFrame);
        this.V.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.g0, this.h0, this.i0, this.j0);
        this.V.setScheme(adCard.getScheme());
        this.V.setAdInfo(adCard);
        this.V.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.V.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.j) ? getPageTypeByBusiness() : advertAppInfo.j;
            tm4 tm4Var = advertAppInfo.i;
            if (tm4Var != null) {
                i = tm4Var.b;
                pageTypeByBusiness = tm4Var.a;
            }
            this.V.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
        }
        this.V.setOnClickListener(new a(this));
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
        this.V = (IHomeAdVideoView) view2.findViewById(R.id.obfuscated_res_0x7f090144);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.k0 == 2 && VideoCardLazyInitSwitch.getIsOn()) ? R.layout.obfuscated_res_0x7f0d0064 : R.layout.obfuscated_res_0x7f0d0065 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0175 : invokeV.intValue;
    }

    @Override // com.repackage.k78
    public g78 getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.V : (g78) invokeV.objValue;
    }

    public boolean p0(AdCard adCard) {
        InterceptResult invokeL;
        s88 s88Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adCard)) == null) ? adCard != null && adCard.goodsStyle == 14 && (s88Var = adCard.verticalVideoStyle) != null && s88Var.a() : invokeL.booleanValue;
    }

    public final void q0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i = this.B / 2;
                this.g0 = i;
                this.h0 = u88.b(i);
            } else {
                int i2 = this.B;
                this.g0 = i2;
                this.h0 = u88.a(i2);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
            layoutParams.height = this.h0;
            layoutParams.width = this.g0;
            if (adCard.goodsStyle == 14 && !p0(adCard)) {
                int i3 = this.B / 2;
                this.i0 = i3;
                this.j0 = u88.b(i3);
            } else {
                int i4 = this.B;
                this.i0 = i4;
                this.j0 = u88.a(i4);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams2.width = this.i0;
            layoutParams2.height = this.j0;
            this.o.requestLayout();
        }
    }
}
