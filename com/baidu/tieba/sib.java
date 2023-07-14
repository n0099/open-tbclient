package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
/* loaded from: classes7.dex */
public class sib extends cib<yib> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements UnifiedBannerADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public yib c;
        public final /* synthetic */ UnifiedBannerView[] d;
        public final /* synthetic */ sib e;

        public a(sib sibVar, UnifiedBannerView[] unifiedBannerViewArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sibVar, unifiedBannerViewArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sibVar;
            this.d = unifiedBannerViewArr;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.e.onAdClicked((sib) this.c, this.b, new String[0]);
                this.b = true;
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.e();
                this.e.onAdClose(this.c);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.e.onAdShow((sib) this.c, this.a, new String[0]);
                this.a = true;
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.d();
                yib yibVar = new yib(this.d[0]);
                this.c = yibVar;
                this.e.onAdLoaded(yibVar, new String[0]);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, adError) == null) {
                this.e.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sib(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.BANNER), pid, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new jib(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cib
    public void e(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            if (!(context instanceof Activity)) {
                onError(0, "NoA");
                return;
            }
            UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.mPid.pid, new a(this, r6));
            unifiedBannerView.setRefresh(0);
            unifiedBannerView.loadAD();
            UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        yib yibVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (yibVar = (yib) obj) != null) {
            ((UnifiedBannerView) yibVar.a).destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            yib yibVar = (yib) obj;
            onShowStart(yibVar);
            if (((UnifiedBannerView) yibVar.a).getParent() != null) {
                ((ViewGroup) ((UnifiedBannerView) yibVar.a).getParent()).removeView((View) yibVar.a);
            }
            viewGroup.removeAllViews();
            int width = viewGroup.getWidth();
            viewGroup.addView((View) yibVar.a, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
