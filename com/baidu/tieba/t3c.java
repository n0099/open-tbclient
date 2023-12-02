package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RewardVideoAd;
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
public class t3c extends c3c<y2c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements RewardVideoAd.RewardVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ y2c[] d;
        public final /* synthetic */ String e;
        public final /* synthetic */ t3c f;

        public a(t3c t3cVar, y2c[] y2cVarArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t3cVar, y2cVarArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = t3cVar;
            this.d = y2cVarArr;
            this.e = str;
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.onAdClicked((t3c) this.d[0], this.b, this.e);
                this.b = true;
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                this.f.onAdClose((t3c) this.d[0], this.e);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                LogPrinter.d("Baidu reward error reason:" + str, new Object[0]);
                y2c y2cVar = this.d[0];
                if (this.c) {
                    this.f.onAdError(y2cVar, 0, str, this.e);
                } else {
                    this.f.onError(0, str, this.e);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                y2c y2cVar = this.d[0];
                this.c = true;
                this.f.onAdLoaded(y2cVar, this.e);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f.onAdShow((t3c) this.d[0], this.a, this.e);
                this.a = true;
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public void onRewardVerify(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                this.f.onRewardedVideo(this.d[0], z, this.e);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                LogPrinter.d();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t3c(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.REWARD), pid);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new f3c(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            y2c y2cVar = (y2c) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String tid = getTid(valueOf);
            String buildExtra = buildExtra(context, tid, valueOf, funAdSlot.getAppExtraData());
            onLoadStart(funAdSlot, tid);
            y2c y2cVar = new y2c(context.getApplicationContext(), this.mPid.pid, new a(this, r2, tid), true ^ FunAdSdk.getFunAdConfig().isUseTextureView);
            y2cVar.setDownloadAppConfirmPolicy(3);
            y2cVar.setUserId(FunAdSdk.getBaiduCustomUserId());
            y2cVar.setExtraInfo(buildExtra);
            y2c[] y2cVarArr = {y2cVar};
            y2cVar.load();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            y2c y2cVar = (y2c) obj;
            onShowStart(y2cVar);
            y2cVar.setShowDialogOnSkip(true);
            y2cVar.setUseRewardCountdown(true);
            y2cVar.show();
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
