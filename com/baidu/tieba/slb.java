package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class slb extends flb<xkb> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements FullScreenVideoAd.FullScreenVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ xkb[] d;
        public final /* synthetic */ slb e;

        public a(slb slbVar, xkb[] xkbVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slbVar, xkbVarArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = slbVar;
            this.d = xkbVarArr;
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.onAdClicked((slb) this.d[0], this.b, new String[0]);
                this.b = true;
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                this.e.onAdClose(this.d[0]);
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                xkb xkbVar = this.d[0];
                if (this.c) {
                    this.e.onAdError(xkbVar, 0, str);
                } else {
                    this.e.onError(0, str);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                xkb xkbVar = this.d[0];
                this.c = true;
                this.e.onAdLoaded(xkbVar, new String[0]);
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.e.onAdShow((slb) this.d[0], this.a, new String[0]);
                this.a = true;
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                LogPrinter.d();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public slb(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.FULL_SCREEN), pid);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new elb(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            xkb xkbVar = (xkb) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            xkb xkbVar = new xkb(context.getApplicationContext(), this.mPid.pid, new a(this, r0), true ^ FunAdSdk.getFunAdConfig().isUseTextureView);
            xkb[] xkbVarArr = {xkbVar};
            xkbVar.load();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            xkb xkbVar = (xkb) obj;
            onShowStart(xkbVar);
            xkbVar.show();
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
