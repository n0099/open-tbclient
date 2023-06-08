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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.List;
/* loaded from: classes8.dex */
public class v0b extends h1b<k1b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0b(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.BANNER), pid);
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

    @Override // com.baidu.tieba.h1b
    public void f(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            this.e.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build(), new a(this, funAdSlot));
        }
    }

    /* loaded from: classes8.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdSlot a;
        public final /* synthetic */ v0b b;

        public a(v0b v0bVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0bVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v0bVar;
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

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.e("CSJBannerExpressAd onNativeExpressAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    TTNativeExpressAd tTNativeExpressAd = list.get(0);
                    v0b v0bVar = this.b;
                    k1b k1bVar = new k1b(tTNativeExpressAd);
                    this.a.getSid();
                    v0bVar.getClass();
                    tTNativeExpressAd.setExpressInteractionListener(new y0b(v0bVar, k1bVar));
                    tTNativeExpressAd.render();
                    return;
                }
                LogPrinter.e("CSJBannerExpressAd onError: adList is null or empty", new Object[0]);
                this.b.onError(0, "NoFill");
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        k1b k1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (k1bVar = (k1b) obj) != null) {
            ((TTNativeExpressAd) k1bVar.a).destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, obj)) == null) {
            k1b k1bVar = (k1b) obj;
            onShowStart(k1bVar);
            ((TTNativeExpressAd) k1bVar.a).setSlideIntervalTime(this.mPid.interval);
            View expressAdView = ((TTNativeExpressAd) k1bVar.a).getExpressAdView();
            if (expressAdView.getParent() != null) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            ((TTNativeExpressAd) k1bVar.a).setDislikeCallback(activity, new z0b(this, expressAdView, k1bVar));
            ((TTNativeExpressAd) k1bVar.a).setDownloadListener(new x0b(null));
            viewGroup.removeAllViews();
            viewGroup.addView(expressAdView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
