package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.omb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.PidLoaderSession;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes7.dex */
public class rmb implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ qmb c;
    public final /* synthetic */ ExpressAdListenerWrapper d;
    public final /* synthetic */ String e;
    public final /* synthetic */ omb.b f;
    public final /* synthetic */ TTNativeExpressAd g;
    public final /* synthetic */ omb h;

    public rmb(omb ombVar, qmb qmbVar, ExpressAdListenerWrapper expressAdListenerWrapper, String str, omb.b bVar, TTNativeExpressAd tTNativeExpressAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ombVar, qmbVar, expressAdListenerWrapper, str, bVar, tTNativeExpressAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = ombVar;
        this.c = qmbVar;
        this.d = expressAdListenerWrapper;
        this.e = str;
        this.f = bVar;
        this.g = tTNativeExpressAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view2, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            LogPrinter.d();
            this.h.onAdClicked((omb) this.c, this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.d.funListener;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.h.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.h.mPid;
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
            LogPrinter.d();
            this.h.onAdShow((omb) this.c, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.d.funListener;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.h.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.h.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, str, i) == null) {
            LogPrinter.d();
            omb.b bVar = this.f;
            qmb qmbVar = this.c;
            if (!bVar.d) {
                int i2 = bVar.a + 1;
                bVar.a = i2;
                if (i2 == bVar.b) {
                    bVar.e.onAdError(qmbVar, i, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view2, float f, float f2) {
        boolean z;
        PidLoaderSession<qmb> session;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            LogPrinter.d();
            this.g.setCanInterruptVideoPlay(true);
            this.h.g.put(this.c, this.d);
            omb.b bVar = this.f;
            qmb qmbVar = this.c;
            if (!bVar.d) {
                bVar.e.onAdLoaded(qmbVar, new String[0]);
                bVar.d = true;
                session = bVar.e.getSession(qmbVar);
                bVar.c = session;
                return;
            }
            PidLoaderSession<qmb> pidLoaderSession = bVar.c;
            if (pidLoaderSession != null) {
                z = bVar.e.isSupportCaching;
                pidLoaderSession.cacheOrDestroy(qmbVar, z);
            }
        }
    }
}
