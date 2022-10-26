package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.to9;
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
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class vo9 extends FunNativeAd2Bridger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final to9.c b;
    public final /* synthetic */ cp9 c;
    public final /* synthetic */ to9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo9(to9 to9Var, ReporterPidLoader reporterPidLoader, NativeUnifiedADData nativeUnifiedADData, String str, cp9 cp9Var) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {to9Var, reporterPidLoader, nativeUnifiedADData, str, cp9Var};
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
        this.d = to9Var;
        this.c = cp9Var;
        this.b = new to9.c(to9Var, nativeUnifiedADData, str);
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, (NativeUnifiedADData) obj, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.u uVar, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uVar, nativeUnifiedADData) == null) {
            uVar.b(nativeUnifiedADData);
        }
    }

    public void a(ExpressInflater expressInflater, String str, final NativeUnifiedADData nativeUnifiedADData, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, nativeUnifiedADData, funAdInteractionListener) == null) {
            final com.fun.module.gdt.u uVar = (com.fun.module.gdt.u) expressInflater.getExpressView();
            to9 to9Var = this.d;
            FunNativeAdListenerHelper funNativeAdListenerHelper = to9Var.e;
            pid = to9Var.mPid;
            funNativeAdListenerHelper.startShow(nativeUnifiedADData, str, pid, this.b, funAdInteractionListener);
            this.b.d = new to9.e() { // from class: com.baidu.tieba.do9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.to9.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        vo9.b(com.fun.module.gdt.u.this, nativeUnifiedADData);
                    }
                }
            };
            this.d.m(uVar, nativeUnifiedADData, this.b);
            expressInflater.inflate();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            return this.d.f(FunAdSdk.getAppContext(), (NativeUnifiedADData) obj);
        }
        return (View) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) obj;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new uo9(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator it = ho9.b.a.iterator();
                while (it.hasNext()) {
                    NativeAdContainer nativeAdContainer2 = (NativeAdContainer) ((WeakReference) it.next()).get();
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
            this.d.p(nativeUnifiedADData, str, nativeAdContainer, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
