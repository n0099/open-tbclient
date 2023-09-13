package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frb;
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
public class jrb extends FunNativeAd2Bridger<vrb, com.fun.module.gdt.t> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final frb.c b;
    public final /* synthetic */ qrb c;
    public final /* synthetic */ frb d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jrb(frb frbVar, ReporterPidLoader reporterPidLoader, vrb vrbVar, String str, qrb qrbVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frbVar, reporterPidLoader, vrbVar, str, qrbVar};
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
        this.d = frbVar;
        this.c = qrbVar;
        this.b = new frb.c(frbVar, vrbVar, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, vrb vrbVar, BaseNativeAd2<vrb, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, vrbVar, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.t tVar, vrb vrbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tVar, vrbVar) == null) {
            tVar.b((NativeUnifiedADData) vrbVar.a);
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/app/Activity;Lcom/fun/ad/sdk/ExpressInflater;Ljava/lang/String;Lcom/baidu/tieba/vrb;Lcom/fun/ad/sdk/internal/api/BaseNativeAd2<Lcom/baidu/tieba/vrb;Lcom/fun/module/gdt/t;>;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void a(ExpressInflater expressInflater, String str, final vrb vrbVar, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, vrbVar, funAdInteractionListener) == null) {
            final com.fun.module.gdt.t tVar = (com.fun.module.gdt.t) expressInflater.getExpressView();
            frb frbVar = this.d;
            FunNativeAdListenerHelper<vrb, NativeADEventListener> funNativeAdListenerHelper = frbVar.e;
            pid = frbVar.mPid;
            funNativeAdListenerHelper.startShow(vrbVar, str, pid, this.b, funAdInteractionListener);
            this.b.d = new frb.e() { // from class: com.baidu.tieba.oqb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.frb.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        jrb.b(com.fun.module.gdt.t.this, vrbVar);
                    }
                }
            };
            this.d.n(tVar, vrbVar, this.b);
            expressInflater.inflate();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.gdt.t] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.t createExpressView(vrb vrbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vrbVar)) == null) {
            return this.d.g(FunAdSdk.getAppContext(), (NativeUnifiedADData) vrbVar.a);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, vrb vrbVar, BaseNativeAd2<vrb, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, vrbVar, baseNativeAd2, funAdInteractionListener}) == null) {
            vrb vrbVar2 = vrbVar;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new irb(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator<WeakReference<NativeAdContainer>> it = qqb.b.a.iterator();
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
            this.d.q(vrbVar2, str, nativeAdContainer2, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
