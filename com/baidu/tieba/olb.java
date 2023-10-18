package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class olb extends flb<zkb> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<View, c> e;
    public final FunNativeAdListenerHelper<zkb, NativeResponse.AdInteractionListener> f;

    /* loaded from: classes7.dex */
    public class a implements BaiduNativeManager.FeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ olb a;

        public a(olb olbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olbVar;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.onError(i, str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeResponse nativeResponse : list) {
                    arrayList.add(new zkb(nativeResponse));
                }
                this.a.onAdLoaded(arrayList);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                this.a.onError(i, str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NativeResponse a;
        public final /* synthetic */ olb b;

        public c(olb olbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = olbVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            NativeResponse nativeResponse;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (nativeResponse = this.a) == null) {
                return;
            }
            nativeResponse.recordImpression(view2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public olb(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid, true, true);
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
        this.e = new HashMap<>();
        this.f = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new clb(pid) : (AdRipper) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements NativeResponse.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zkb a;
        public final /* synthetic */ olb b;

        public b(olb olbVar, zkb zkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olbVar, zkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = olbVar;
            this.a = zkbVar;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                LogPrinter.e("BaiduFeedAd showNativeAd onADExposureFailed code: " + i, new Object[0]);
                this.b.onAdError(this.a, i, "F:onADExposureFailed");
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.f.onAdShow(this.a);
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.f.onAdClick(this.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        zkb zkbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (zkbVar = (zkb) obj) != null) {
            this.f.destroy(zkbVar);
            synchronized (this.e) {
                Iterator<Map.Entry<View, c>> it = this.e.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<View, c> next = it.next();
                    View key = next.getKey();
                    c value = next.getValue();
                    if (value.a == zkbVar.a) {
                        synchronized (value.b.e) {
                            value.b.e.remove(key);
                        }
                        key.removeOnAttachStateChangeListener(value);
                        break;
                    }
                }
                zkbVar.a = null;
            }
        }
    }

    public void f(zkb zkbVar, String str, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{zkbVar, str, viewGroup, list, list2, funAdInteractionListener}) == null) {
            if (zkbVar.a == null) {
                onAdError(zkbVar, "ad is null");
                return;
            }
            b bVar = new b(this, zkbVar);
            synchronized (this.e) {
                c cVar = this.e.get(viewGroup);
                if (cVar == null) {
                    cVar = new c(this);
                    viewGroup.addOnAttachStateChangeListener(cVar);
                    this.e.put(viewGroup, cVar);
                }
                cVar.a = zkbVar.a;
            }
            this.f.startShow(zkbVar, str, this.mPid, bVar, funAdInteractionListener);
            zkbVar.a.registerViewForInteraction(viewGroup, list, list2, bVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, obj)) == null) {
            zkb zkbVar = (zkb) obj;
            NativeResponse nativeResponse = zkbVar.a;
            if (nativeResponse == null) {
                return null;
            }
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, zkbVar, new ukb(nativeResponse), new rlb(this, this, context, str));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            new BaiduNativeManager(context.getApplicationContext(), this.mPid.pid).loadFeedAd(new RequestParameters.Builder().downloadAppConfirmPolicy(1).build(), new a(this));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, activity, viewGroup, str, obj)) == null) {
            zkb zkbVar = (zkb) obj;
            onShowStart(zkbVar);
            NativeResponse nativeResponse = zkbVar.a;
            if (nativeResponse == null) {
                onAdError(zkbVar, "ad is null");
                return false;
            }
            View a2 = mkb.a(activity, nativeResponse, new plb(this, zkbVar));
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
