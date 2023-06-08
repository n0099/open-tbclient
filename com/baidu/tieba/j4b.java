package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j4b extends i4b<h4b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.DrawAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j4b a;

        public a(j4b j4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j4bVar;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onDrawAdLoad error: adList is null or empty", new Object[0]);
                    onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (KsDrawAd ksDrawAd : list) {
                    if (ksDrawAd != null) {
                        arrayList.add(new h4b(ksDrawAd));
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.a.onAdLoaded(arrayList);
                    return;
                }
                LogPrinter.e("onDrawAdLoad error: adList is null or empty", new Object[0]);
                onError(0, "NoFill");
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements KsDrawAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final String c;
        public final h4b d;
        public FunAdInteractionListener e;
        public final /* synthetic */ j4b f;

        public b(j4b j4bVar, h4b h4bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j4bVar, h4bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = j4bVar;
            this.d = h4bVar;
            this.c = str;
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f.onAdClicked((j4b) this.d, this.b, new String[0]);
                this.b = true;
                FunAdInteractionListener funAdInteractionListener = this.e;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(this.c, this.f.mPid.ssp.type, this.f.mPid.pid);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f.onAdShow((j4b) this.d, this.a, new String[0]);
                this.a = true;
                FunAdInteractionListener funAdInteractionListener = this.e;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(this.c, this.f.mPid.ssp.type, this.f.mPid.pid);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.e();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4b(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.DRAW), pid, true, true);
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
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new x4b(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            h4b h4bVar = (h4b) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 5)).build();
            onLoadStart(funAdSlot);
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager == null) {
                onError(FunAdSdk.PLATFORM_KS);
            } else {
                loadManager.loadDrawAd(build, new a(this));
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) {
            h4b h4bVar = (h4b) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, h4bVar, new m4b(this, this, h4bVar, str, context));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            h4b h4bVar = (h4b) obj;
            onShowStart(h4bVar);
            ((KsDrawAd) h4bVar.a).setAdInteractionListener(new b(this, h4bVar, str));
            View drawView = ((KsDrawAd) h4bVar.a).getDrawView(viewGroup.getContext());
            if (drawView == null) {
                LogPrinter.e("drawView is null", new Object[0]);
                return false;
            }
            if (drawView.getParent() != null) {
                ((ViewGroup) drawView.getParent()).removeView(drawView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(drawView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
