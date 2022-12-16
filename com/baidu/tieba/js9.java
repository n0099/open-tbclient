package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.PidLoaderSession;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class js9 extends es9<ns9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ns9, ExpressAdListenerWrapper<TTNativeExpressAd.ExpressAdInteractionListener>> f;

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final int b;
        public PidLoaderSession<ns9> c;
        public boolean d;
        public final /* synthetic */ js9 e;

        public b(js9 js9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = js9Var;
            this.d = false;
            this.b = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public js9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.DRAW), pid);
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
        this.f = new HashMap<>();
    }

    /* loaded from: classes5.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdSlot a;
        public final /* synthetic */ js9 b;

        public a(js9 js9Var, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js9Var, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = js9Var;
            this.a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.b.onError(i, str);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: com.bytedance.sdk.openadsdk.TTNativeExpressAd */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1, types: [A, com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressAdInteractionListener, com.baidu.tieba.ms9] */
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list != null && !list.isEmpty()) {
                    js9 js9Var = this.b;
                    String sid = this.a.getSid();
                    js9Var.getClass();
                    b bVar = new b(js9Var, list.size());
                    for (TTNativeExpressAd tTNativeExpressAd : list) {
                        ns9 ns9Var = new ns9(tTNativeExpressAd);
                        ExpressAdListenerWrapper expressAdListenerWrapper = new ExpressAdListenerWrapper();
                        ?? ms9Var = new ms9(js9Var, ns9Var, expressAdListenerWrapper, sid, bVar, tTNativeExpressAd);
                        expressAdListenerWrapper.listener = ms9Var;
                        tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.ExpressAdInteractionListener) ms9Var);
                        tTNativeExpressAd.render();
                    }
                    return;
                }
                onError(0, "NoFill");
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            ns9 ns9Var = (ns9) obj;
            this.f.remove(ns9Var);
            if (ns9Var != null) {
                ((TTNativeExpressAd) ns9Var.a).destroy();
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, obj)) == null) {
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, (ns9) obj, new os9(this, this));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            if (this.e == null) {
                this.e = TTAdSdk.getAdManager().createAdNative(context.getApplicationContext());
            }
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setExpressViewAcceptedSize(expressWidth, expressHeight).setImageAcceptedSize(640, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP).setAdCount(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 3));
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(context);
            onLoadStart(funAdSlot);
            createAdNative.loadExpressDrawFeedAd(adCount.build(), new a(this, funAdSlot));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            ns9 ns9Var = (ns9) obj;
            onShowStart(ns9Var);
            View expressAdView = ((TTNativeExpressAd) ns9Var.a).getExpressAdView();
            if (expressAdView.getParent() != null) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(expressAdView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
