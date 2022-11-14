package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
/* loaded from: classes5.dex */
public class sq9 extends ReporterPidLoader<UnifiedBannerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements UnifiedBannerADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ UnifiedBannerView[] c;
        public final /* synthetic */ sq9 d;

        public a(sq9 sq9Var, UnifiedBannerView[] unifiedBannerViewArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq9Var, unifiedBannerViewArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sq9Var;
            this.c = unifiedBannerViewArr;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.d.onAdClicked(this.c[0], this.b, new String[0]);
                this.b = true;
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.e();
                this.d.onAdClose(this.c[0]);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.d.onAdShow(this.c[0], this.a, new String[0]);
                this.a = true;
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogPrinter.e();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                LogPrinter.d();
                this.d.onAdLoaded((sq9) this.c[0]);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                this.d.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq9(Ssp.Pid pid) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new eq9(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
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
        UnifiedBannerView unifiedBannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (unifiedBannerView = (UnifiedBannerView) obj) != null) {
            unifiedBannerView.destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public double getAdBiddingPrices(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            return ((UnifiedBannerView) obj).getECPM() / 100.0d;
        }
        return invokeL.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void setAdBiddingResult(Object obj, double d, double d2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{obj, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            UnifiedBannerView unifiedBannerView = (UnifiedBannerView) obj;
            double d3 = d * 100.0d;
            if (z) {
                unifiedBannerView.sendWinNotification((int) d3);
                return;
            }
            int i2 = 1;
            if (i == 3) {
                i2 = 2;
            } else if (i == 5) {
                i2 = 3;
            }
            unifiedBannerView.sendLossNotification((int) d3, i2, "");
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, activity, viewGroup, str, obj)) == null) {
            UnifiedBannerView unifiedBannerView = (UnifiedBannerView) obj;
            onShowStart(unifiedBannerView);
            if (unifiedBannerView.getParent() != null) {
                ((ViewGroup) unifiedBannerView.getParent()).removeView(unifiedBannerView);
            }
            viewGroup.removeAllViews();
            int width = viewGroup.getWidth();
            viewGroup.addView(unifiedBannerView, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
