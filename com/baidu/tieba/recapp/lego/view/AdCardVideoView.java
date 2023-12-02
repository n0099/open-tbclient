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
import com.baidu.tieba.aja;
import com.baidu.tieba.cja;
import com.baidu.tieba.kha;
import com.baidu.tieba.kw4;
import com.baidu.tieba.oha;
import com.baidu.tieba.p16;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.IHomeAdVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class AdCardVideoView extends AdCardBaseView implements oha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHomeAdVideoView f0;
    public TbPageContext g0;
    public int h0;
    public int i0;
    public int j0;
    public int r0;
    public int s0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a9 : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
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
                int jump2DownloadDetailPage = this.a.f0.jump2DownloadDetailPage();
                HashMap<String, Object> T2 = this.a.T("video");
                if (this.a.k != null) {
                    this.a.k.a(jump2DownloadDetailPage, T2);
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
        this.g0 = tbPageContext;
        this.s0 = i;
    }

    public boolean C0(AdCard adCard) {
        InterceptResult invokeL;
        aja ajaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adCard)) == null) {
            if (adCard == null || adCard.goodsStyle != 14 || (ajaVar = adCard.verticalVideoStyle) == null || !ajaVar.a()) {
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
            this.f0.setMaskViewRadius(fArr);
            this.o.postInvalidate();
        }
    }

    private String getPageTypeByBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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
            if (this.s0 == 2) {
                return R.layout.obfuscated_res_0x7f0d006b;
            }
            return R.layout.obfuscated_res_0x7f0d006c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.oha
    public kha getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f0;
        }
        return (kha) invokeV.objValue;
    }

    public final void D0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                if (p16.a().b("tieba_ad_mini_video_size_optimize_switch", 0) == 1) {
                    int i = (this.x * 2) / 3;
                    this.h0 = i;
                    this.i0 = (i * 4) / 3;
                } else {
                    int i2 = this.x / 2;
                    this.h0 = i2;
                    this.i0 = cja.b(i2);
                }
            } else {
                int i3 = this.x;
                this.h0 = i3;
                this.i0 = cja.a(i3);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.height = this.i0;
            layoutParams.width = this.h0;
            if (adCard.goodsStyle == 14 && !C0(adCard)) {
                if (p16.a().b("tieba_ad_mini_video_size_optimize_switch", 0) == 1) {
                    this.j0 = (this.x * 2) / 3;
                    this.r0 = (this.h0 * 4) / 3;
                } else {
                    int i4 = this.x / 2;
                    this.j0 = i4;
                    this.r0 = cja.b(i4);
                }
            } else {
                int i5 = this.x;
                this.j0 = i5;
                this.r0 = cja.a(i5);
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09193e);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.width = this.j0;
            layoutParams2.height = this.r0;
            frameLayout.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void W(AdCard adCard) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) && adCard != null && adCard.videoInfo != null) {
            D0(adCard);
            this.f0.setAdInfo(adCard);
            this.f0.setPageContext(this.g0);
            this.f0.setVideoTailFrameData(adCard.tailFrame);
            this.f0.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.h0, this.i0, this.j0, this.r0);
            this.f0.setScheme(adCard.getScheme());
            this.f0.setVideoScalingMode(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            this.f0.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null) {
                int i = -1;
                if (TextUtils.isEmpty(advertAppInfo.j)) {
                    str = getPageTypeByBusiness();
                } else {
                    str = advertAppInfo.j;
                }
                kw4 kw4Var = advertAppInfo.i;
                if (kw4Var != null) {
                    i = kw4Var.b;
                    str = kw4Var.a;
                }
                this.f0.setStatisticInfo(advertAppInfo, i, str);
            }
            this.f0.setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void e0(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        float[] Y = Y(R.string.J_X05);
        if (view2 instanceof XfremodeRoundLayout) {
            XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view2;
            xfremodeRoundLayout.setRoundLayoutRadius(Y);
            xfremodeRoundLayout.setLayerType(2, null);
            this.f0 = (IHomeAdVideoView) view2.findViewById(R.id.obfuscated_res_0x7f09016d);
        }
    }
}
