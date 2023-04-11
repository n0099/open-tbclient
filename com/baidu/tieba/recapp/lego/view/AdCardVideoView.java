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
import com.baidu.tieba.ac9;
import com.baidu.tieba.ay5;
import com.baidu.tieba.la9;
import com.baidu.tieba.ow4;
import com.baidu.tieba.pa9;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.tieba.yb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class AdCardVideoView extends AdCardBaseView implements pa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView j0;
    public TbPageContext r0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;

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
                int jump2DownloadDetailPage = this.a.j0.jump2DownloadDetailPage();
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
        this.r0 = tbPageContext;
        this.w0 = i;
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
            if (this.w0 == 2) {
                return R.layout.obfuscated_res_0x7f0d0067;
            }
            return R.layout.obfuscated_res_0x7f0d0068;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pa9
    public la9 getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j0;
        }
        return (la9) invokeV.objValue;
    }

    public boolean A0(AdCard adCard) {
        InterceptResult invokeL;
        yb9 yb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adCard)) == null) {
            if (adCard == null || adCard.goodsStyle != 14 || (yb9Var = adCard.verticalVideoStyle) == null || !yb9Var.a()) {
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
            this.j0.setMaskViewRadius(fArr);
            this.o.postInvalidate();
        }
    }

    public final void B0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                if (ay5.a().b("tieba_ad_mini_video_size_optimize_switch", 0) == 1) {
                    int i = (this.B * 2) / 3;
                    this.s0 = i;
                    this.t0 = (i * 4) / 3;
                } else {
                    int i2 = this.B / 2;
                    this.s0 = i2;
                    this.t0 = ac9.b(i2);
                }
            } else {
                int i3 = this.B;
                this.s0 = i3;
                this.t0 = ac9.a(i3);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j0.getLayoutParams();
            layoutParams.height = this.t0;
            layoutParams.width = this.s0;
            if (adCard.goodsStyle == 14 && !A0(adCard)) {
                if (ay5.a().b("tieba_ad_mini_video_size_optimize_switch", 0) == 1) {
                    this.u0 = (this.B * 2) / 3;
                    this.v0 = (this.s0 * 4) / 3;
                } else {
                    int i4 = this.B / 2;
                    this.u0 = i4;
                    this.v0 = ac9.b(i4);
                }
            } else {
                int i5 = this.B;
                this.u0 = i5;
                this.v0 = ac9.a(i5);
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091758);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.width = this.u0;
            layoutParams2.height = this.v0;
            frameLayout.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(AdCard adCard) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) && adCard != null && adCard.videoInfo != null) {
            B0(adCard);
            this.j0.setAdInfo(adCard);
            this.j0.setPageContext(this.r0);
            this.j0.setVideoTailFrameData(adCard.tailFrame);
            this.j0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.s0, this.t0, this.u0, this.v0);
            this.j0.setScheme(adCard.getScheme());
            this.j0.setVideoScalingMode(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.j0.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                if (TextUtils.isEmpty(advertAppInfo.j)) {
                    str = getPageTypeByBusiness();
                } else {
                    str = advertAppInfo.j;
                }
                ow4 ow4Var = advertAppInfo.i;
                if (ow4Var != null) {
                    i = ow4Var.b;
                    str = ow4Var.a;
                }
                this.j0.setStatisticInfo(advertAppInfo, i, str);
            }
            this.j0.setOnClickListener(new a(this));
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
            this.j0 = (IHomeAdVideoView) view2.findViewById(R.id.obfuscated_res_0x7f09014b);
        }
    }
}
