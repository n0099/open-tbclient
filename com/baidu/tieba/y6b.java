package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class y6b extends b6b<l6b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y6b(Ssp.Pid pid, ModuleConfigKs moduleConfigKs) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.REWARD), pid, moduleConfigKs);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid, moduleConfigKs};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], (ModuleConfigKs) objArr2[2]);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new p6b(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            l6b l6bVar = (l6b) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String tid = getTid(valueOf);
            String buildExtra = buildExtra(context, tid, valueOf, funAdSlot.getAppExtraData());
            HashMap hashMap = new HashMap();
            hashMap.put("thirdUserId", FunAdSdk.getFunAdConfig().userId);
            hashMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, buildExtra);
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(1).rewardCallbackExtraData(hashMap).build();
            onLoadStart(funAdSlot, tid);
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager == null) {
                onError(FunAdSdk.PLATFORM_KS);
            } else {
                loadManager.loadRewardVideoAd(build, new a(this, tid));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements KsLoadManager.RewardVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ y6b b;

        public a(y6b y6bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y6bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y6bVar;
            this.a = str;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.b.onError(i, str, this.a);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list != null && !list.isEmpty()) {
                    KsRewardVideoAd ksRewardVideoAd = list.get(0);
                    if (ksRewardVideoAd == null) {
                        LogPrinter.e("onNativeAdLoad error: ad is null or empty", new Object[0]);
                        this.b.onError(0, "No Fill", this.a);
                        return;
                    }
                    l6b l6bVar = new l6b(ksRewardVideoAd);
                    y6b y6bVar = this.b;
                    String str = this.a;
                    y6bVar.getClass();
                    ksRewardVideoAd.setRewardAdInteractionListener(new z6b(y6bVar, l6bVar, str));
                    y6b y6bVar2 = this.b;
                    String str2 = this.a;
                    y6bVar2.getClass();
                    if (ksRewardVideoAd != null) {
                        ksRewardVideoAd.setRewardPlayAgainInteractionListener(new a7b(y6bVar2, l6bVar, str2));
                    }
                    this.b.onAdLoaded(l6bVar, this.a);
                    return;
                }
                LogPrinter.e("onNativeAdLoad error: adList is null or empty", new Object[0]);
                this.b.onError(0, "No Fill", this.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            l6b l6bVar = (l6b) obj;
            onShowStart(l6bVar);
            if (!((KsRewardVideoAd) l6bVar.a).isAdEnable()) {
                LogPrinter.e("Ad isn't ready now", new Object[0]);
                onAdError(l6bVar, 0, "F:ad disable");
                return false;
            }
            ((KsRewardVideoAd) l6bVar.a).showRewardVideoAd(activity, e());
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
