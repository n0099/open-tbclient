package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.h29;
import com.baidu.tieba.j29;
import com.baidu.tieba.mw4;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.tieba.v09;
import com.baidu.tieba.z09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class AdCardVideoView extends AdCardBaseView implements z09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView i0;
    public TbPageContext j0;
    public int r0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d0189 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
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
                int jump2DownloadDetailPage = this.a.i0.jump2DownloadDetailPage();
                HashMap<String, Object> R = this.a.R("video");
                if (this.a.k != null) {
                    this.a.k.a(jump2DownloadDetailPage, R);
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
        this.j0 = tbPageContext;
        this.v0 = i;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v0 == 2) {
                return R.layout.obfuscated_res_0x7f0d0067;
            }
            return R.layout.obfuscated_res_0x7f0d0068;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.z09
    public v09 getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i0;
        }
        return (v09) invokeV.objValue;
    }

    public boolean A0(AdCard adCard) {
        InterceptResult invokeL;
        h29 h29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adCard)) == null) {
            if (adCard == null || adCard.goodsStyle != 14 || (h29Var = adCard.verticalVideoStyle) == null || !h29Var.a()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void setCustomViewRadius(@NonNull float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fArr) == null) {
            View view2 = this.o;
            if (view2 instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view2).setRoundLayoutRadius(fArr);
            }
            this.i0.setMaskViewRadius(fArr);
            this.o.postInvalidate();
        }
    }

    public final void B0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i = this.B / 2;
                this.r0 = i;
                this.s0 = j29.b(i);
            } else {
                int i2 = this.B;
                this.r0 = i2;
                this.s0 = j29.a(i2);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i0.getLayoutParams();
            layoutParams.height = this.s0;
            layoutParams.width = this.r0;
            if (adCard.goodsStyle == 14 && !A0(adCard)) {
                int i3 = this.B / 2;
                this.t0 = i3;
                this.u0 = j29.b(i3);
            } else {
                int i4 = this.B;
                this.t0 = i4;
                this.u0 = j29.a(i4);
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091755);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.width = this.t0;
            layoutParams2.height = this.u0;
            frameLayout.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(AdCard adCard) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) && adCard != null && adCard.videoInfo != null) {
            B0(adCard);
            this.i0.setAdInfo(adCard);
            this.i0.setPageContext(this.j0);
            this.i0.setVideoTailFrameData(adCard.tailFrame);
            this.i0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.r0, this.s0, this.t0, this.u0);
            this.i0.setScheme(adCard.getScheme());
            this.i0.setVideoScalingMode(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.i0.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                if (TextUtils.isEmpty(advertAppInfo.j)) {
                    str = getPageTypeByBusiness();
                } else {
                    str = advertAppInfo.j;
                }
                mw4 mw4Var = advertAppInfo.i;
                if (mw4Var != null) {
                    i = mw4Var.b;
                    str = mw4Var.a;
                }
                this.i0.setStatisticInfo(advertAppInfo, i, str);
            }
            this.i0.setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void c0(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        float[] W = W(R.string.J_X05);
        if (view2 instanceof XfremodeRoundLayout) {
            XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view2;
            xfremodeRoundLayout.setRoundLayoutRadius(W);
            xfremodeRoundLayout.setLayerType(2, null);
            this.i0 = (IHomeAdVideoView) view2.findViewById(R.id.obfuscated_res_0x7f09014d);
        }
    }
}
