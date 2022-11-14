package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nq9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class pq9 extends FunNativeAd2Bridger<NativeUnifiedADData, com.fun.module.gdt.u> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nq9.c b;
    public final /* synthetic */ wq9 c;
    public final /* synthetic */ nq9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq9(nq9 nq9Var, ReporterPidLoader reporterPidLoader, NativeUnifiedADData nativeUnifiedADData, String str, wq9 wq9Var) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nq9Var, reporterPidLoader, nativeUnifiedADData, str, wq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ReporterPidLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = nq9Var;
        this.c = wq9Var;
        this.b = new nq9.c(nq9Var, nativeUnifiedADData, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, NativeUnifiedADData nativeUnifiedADData, BaseNativeAd2<NativeUnifiedADData, com.fun.module.gdt.u> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, nativeUnifiedADData, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.u uVar, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uVar, nativeUnifiedADData) == null) {
            uVar.b(nativeUnifiedADData);
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/app/Activity;Lcom/fun/ad/sdk/ExpressInflater;Ljava/lang/String;Lcom/qq/e/ads/nativ/NativeUnifiedADData;Lcom/fun/ad/sdk/internal/api/BaseNativeAd2<Lcom/qq/e/ads/nativ/NativeUnifiedADData;Lcom/fun/module/gdt/u;>;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void a(ExpressInflater expressInflater, String str, final NativeUnifiedADData nativeUnifiedADData, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, nativeUnifiedADData, funAdInteractionListener) == null) {
            final com.fun.module.gdt.u uVar = (com.fun.module.gdt.u) expressInflater.getExpressView();
            nq9 nq9Var = this.d;
            FunNativeAdListenerHelper<NativeUnifiedADData, NativeADEventListener> funNativeAdListenerHelper = nq9Var.e;
            pid = nq9Var.mPid;
            funNativeAdListenerHelper.startShow(nativeUnifiedADData, str, pid, this.b, funAdInteractionListener);
            this.b.d = new nq9.e() { // from class: com.baidu.tieba.xp9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.nq9.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        pq9.b(com.fun.module.gdt.u.this, nativeUnifiedADData);
                    }
                }
            };
            this.d.m(uVar, nativeUnifiedADData, this.b);
            expressInflater.inflate();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.gdt.u, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.u createExpressView(NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeUnifiedADData)) == null) {
            return this.d.f(FunAdSdk.getAppContext(), nativeUnifiedADData);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, NativeUnifiedADData nativeUnifiedADData, BaseNativeAd2<NativeUnifiedADData, com.fun.module.gdt.u> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, nativeUnifiedADData, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new oq9(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator<WeakReference<NativeAdContainer>> it = bq9.b.a.iterator();
                while (it.hasNext()) {
                    NativeAdContainer nativeAdContainer2 = it.next().get();
                    if (nativeAdContainer2 == null) {
                        it.remove();
                    } else if (nativeAdContainer2 == funNativeView.getRoot()) {
                        it.remove();
                        nativeAdContainer = nativeAdContainer2;
                        break;
                    }
                }
                nativeAdContainer = null;
            } else {
                if (inflate instanceof NativeAdContainer) {
                    nativeAdContainer = (NativeAdContainer) inflate;
                }
                nativeAdContainer = null;
            }
            this.d.p(nativeUnifiedADData2, str, nativeAdContainer, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
