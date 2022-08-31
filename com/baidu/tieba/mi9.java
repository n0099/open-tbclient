package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes5.dex */
public class mi9 implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ ei9 c;
    public final /* synthetic */ ExpressAdListenerWrapper d;
    public final /* synthetic */ String e;
    public final /* synthetic */ ki9 f;

    public mi9(ki9 ki9Var, ei9 ei9Var, ExpressAdListenerWrapper expressAdListenerWrapper, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ki9Var, ei9Var, expressAdListenerWrapper, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = ki9Var;
        this.c = ei9Var;
        this.d = expressAdListenerWrapper;
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view2, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            LogPrinter.e("CSJNativeExpressAd onAdClicked type: " + i, new Object[0]);
            this.f.onAdClicked(this.c, this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.d.funListener;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view2, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            LogPrinter.e("CSJNativeExpressAd onAdShow type: " + i, new Object[0]);
            this.f.onAdShow(this.c, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.d.funListener;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, str, i) == null) {
            LogPrinter.e("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i, new Object[0]);
            this.f.onError(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            LogPrinter.e("CSJNativeExpressAd onRenderSuccess width: " + f + ", height:" + f2, new Object[0]);
            this.f.f.put(this.c, this.d);
            this.f.onAdLoaded((ki9) this.c);
        }
    }
}
