package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.umb;
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
/* loaded from: classes9.dex */
public class ymb extends FunNativeAd2Bridger<knb, com.fun.module.gdt.t> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final umb.c b;
    public final /* synthetic */ fnb c;
    public final /* synthetic */ umb d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ymb(umb umbVar, ReporterPidLoader reporterPidLoader, knb knbVar, String str, fnb fnbVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {umbVar, reporterPidLoader, knbVar, str, fnbVar};
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
        this.d = umbVar;
        this.c = fnbVar;
        this.b = new umb.c(umbVar, knbVar, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, knb knbVar, BaseNativeAd2<knb, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, knbVar, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.t tVar, knb knbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tVar, knbVar) == null) {
            tVar.b((NativeUnifiedADData) knbVar.a);
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/app/Activity;Lcom/fun/ad/sdk/ExpressInflater;Ljava/lang/String;Lcom/baidu/tieba/knb;Lcom/fun/ad/sdk/internal/api/BaseNativeAd2<Lcom/baidu/tieba/knb;Lcom/fun/module/gdt/t;>;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void a(ExpressInflater expressInflater, String str, final knb knbVar, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, knbVar, funAdInteractionListener) == null) {
            final com.fun.module.gdt.t tVar = (com.fun.module.gdt.t) expressInflater.getExpressView();
            umb umbVar = this.d;
            FunNativeAdListenerHelper<knb, NativeADEventListener> funNativeAdListenerHelper = umbVar.e;
            pid = umbVar.mPid;
            funNativeAdListenerHelper.startShow(knbVar, str, pid, this.b, funAdInteractionListener);
            this.b.d = new umb.e() { // from class: com.baidu.tieba.dmb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.umb.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ymb.b(com.fun.module.gdt.t.this, knbVar);
                    }
                }
            };
            this.d.n(tVar, knbVar, this.b);
            expressInflater.inflate();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.gdt.t] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.t createExpressView(knb knbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, knbVar)) == null) {
            return this.d.g(FunAdSdk.getAppContext(), (NativeUnifiedADData) knbVar.a);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, knb knbVar, BaseNativeAd2<knb, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, knbVar, baseNativeAd2, funAdInteractionListener}) == null) {
            knb knbVar2 = knbVar;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new xmb(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator<WeakReference<NativeAdContainer>> it = fmb.b.a.iterator();
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
            this.d.q(knbVar2, str, nativeAdContainer2, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
