package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r4c;
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
/* loaded from: classes8.dex */
public class v4c extends FunNativeAd2Bridger<h5c, com.fun.module.gdt.t> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r4c.c b;
    public final /* synthetic */ c5c c;
    public final /* synthetic */ r4c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v4c(r4c r4cVar, ReporterPidLoader reporterPidLoader, h5c h5cVar, String str, c5c c5cVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r4cVar, reporterPidLoader, h5cVar, str, c5cVar};
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
        this.d = r4cVar;
        this.c = c5cVar;
        this.b = new r4c.c(r4cVar, h5cVar, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, h5c h5cVar, BaseNativeAd2<h5c, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, h5cVar, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.t tVar, h5c h5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tVar, h5cVar) == null) {
            tVar.b((NativeUnifiedADData) h5cVar.a);
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/app/Activity;Lcom/fun/ad/sdk/ExpressInflater;Ljava/lang/String;Lcom/baidu/tieba/h5c;Lcom/fun/ad/sdk/internal/api/BaseNativeAd2<Lcom/baidu/tieba/h5c;Lcom/fun/module/gdt/t;>;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void a(ExpressInflater expressInflater, String str, final h5c h5cVar, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, h5cVar, funAdInteractionListener) == null) {
            final com.fun.module.gdt.t tVar = (com.fun.module.gdt.t) expressInflater.getExpressView();
            r4c r4cVar = this.d;
            FunNativeAdListenerHelper<h5c, NativeADEventListener> funNativeAdListenerHelper = r4cVar.e;
            pid = r4cVar.mPid;
            funNativeAdListenerHelper.startShow(h5cVar, str, pid, this.b, funAdInteractionListener);
            this.b.d = new r4c.e() { // from class: com.baidu.tieba.a4c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.r4c.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        v4c.b(com.fun.module.gdt.t.this, h5cVar);
                    }
                }
            };
            this.d.n(tVar, h5cVar, this.b);
            expressInflater.inflate();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.gdt.t] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.t createExpressView(h5c h5cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h5cVar)) == null) {
            return this.d.g(FunAdSdk.getAppContext(), (NativeUnifiedADData) h5cVar.a);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, h5c h5cVar, BaseNativeAd2<h5c, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, h5cVar, baseNativeAd2, funAdInteractionListener}) == null) {
            h5c h5cVar2 = h5cVar;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new u4c(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator<WeakReference<NativeAdContainer>> it = c4c.b.a.iterator();
                while (it.hasNext()) {
                    NativeAdContainer nativeAdContainer3 = it.next().get();
                    if (nativeAdContainer3 == null) {
                        it.remove();
                    } else if (nativeAdContainer3 == funNativeView.getRoot()) {
                        it.remove();
                        nativeAdContainer2 = nativeAdContainer3;
                        break;
                    }
                }
                if (funNativeView.getRoot() instanceof NativeAdContainer) {
                    nativeAdContainer = (NativeAdContainer) funNativeView.getRoot();
                    nativeAdContainer2 = nativeAdContainer;
                }
                nativeAdContainer2 = null;
            } else {
                if (inflate instanceof NativeAdContainer) {
                    nativeAdContainer = (NativeAdContainer) inflate;
                    nativeAdContainer2 = nativeAdContainer;
                }
                nativeAdContainer2 = null;
            }
            this.d.q(h5cVar2, str, nativeAdContainer2, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
