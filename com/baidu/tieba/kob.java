package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gob;
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
/* loaded from: classes6.dex */
public class kob extends FunNativeAd2Bridger<wob, com.fun.module.gdt.t> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gob.c b;
    public final /* synthetic */ rob c;
    public final /* synthetic */ gob d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kob(gob gobVar, ReporterPidLoader reporterPidLoader, wob wobVar, String str, rob robVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gobVar, reporterPidLoader, wobVar, str, robVar};
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
        this.d = gobVar;
        this.c = robVar;
        this.b = new gob.c(gobVar, wobVar, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, wob wobVar, BaseNativeAd2<wob, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, wobVar, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.t tVar, wob wobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tVar, wobVar) == null) {
            tVar.b((NativeUnifiedADData) wobVar.a);
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/app/Activity;Lcom/fun/ad/sdk/ExpressInflater;Ljava/lang/String;Lcom/baidu/tieba/wob;Lcom/fun/ad/sdk/internal/api/BaseNativeAd2<Lcom/baidu/tieba/wob;Lcom/fun/module/gdt/t;>;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void a(ExpressInflater expressInflater, String str, final wob wobVar, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, wobVar, funAdInteractionListener) == null) {
            final com.fun.module.gdt.t tVar = (com.fun.module.gdt.t) expressInflater.getExpressView();
            gob gobVar = this.d;
            FunNativeAdListenerHelper<wob, NativeADEventListener> funNativeAdListenerHelper = gobVar.e;
            pid = gobVar.mPid;
            funNativeAdListenerHelper.startShow(wobVar, str, pid, this.b, funAdInteractionListener);
            this.b.d = new gob.e() { // from class: com.baidu.tieba.pnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gob.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kob.b(com.fun.module.gdt.t.this, wobVar);
                    }
                }
            };
            this.d.n(tVar, wobVar, this.b);
            expressInflater.inflate();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.gdt.t] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.t createExpressView(wob wobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wobVar)) == null) {
            return this.d.g(FunAdSdk.getAppContext(), (NativeUnifiedADData) wobVar.a);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, wob wobVar, BaseNativeAd2<wob, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, wobVar, baseNativeAd2, funAdInteractionListener}) == null) {
            wob wobVar2 = wobVar;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new job(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator<WeakReference<NativeAdContainer>> it = rnb.b.a.iterator();
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
            this.d.q(wobVar2, str, nativeAdContainer2, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
