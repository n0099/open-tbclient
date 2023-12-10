package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
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
/* loaded from: classes6.dex */
public class k3c extends d3c<r2c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ExpressInterstitialListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ r2c d;
        public final /* synthetic */ k3c e;

        public a(k3c k3cVar, r2c r2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k3cVar, r2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k3cVar;
            this.d = r2cVar;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.onAdShow((k3c) this.d, this.a, new String[0]);
                this.a = true;
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposureFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.onAdError(this.d, 0, "onADExposureFailed");
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c = true;
                this.e.onAdLoaded(this.d, new String[0]);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.e.onAdClicked((k3c) this.d, this.b, new String[0]);
                this.b = true;
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a) {
                this.e.onAdClose(this.d);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdFailed(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
                if (this.c) {
                    this.e.onAdError(this.d, i, str);
                } else {
                    this.e.onError(i, str);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onNoAd(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
                this.e.onError(i, str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                LogPrinter.d();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3c(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.INTERSTITIAL), pid);
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
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1]);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new y2c(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            r2c r2cVar = new r2c(context.getApplicationContext(), this.mPid.pid);
            r2cVar.setLoadListener(new a(this, r2cVar));
            LogPrinter.d("start load", new Object[0]);
            r2cVar.load();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        r2c r2cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (r2cVar = (r2c) obj) != null) {
            r2cVar.destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            r2c r2cVar = (r2c) obj;
            onShowStart(r2cVar);
            r2cVar.show(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
