package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class w2b implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ g3b c;
    public final /* synthetic */ FunAdInteractionListener d;
    public final /* synthetic */ String e;
    public final /* synthetic */ t2b f;

    public w2b(t2b t2bVar, g3b g3bVar, FunAdInteractionListener funAdInteractionListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t2bVar, g3bVar, funAdInteractionListener, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = t2bVar;
        this.c = g3bVar;
        this.d = funAdInteractionListener;
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, tTNativeAd) == null) {
            LogPrinter.d();
            this.f.onAdClicked((t2b) this.c, this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.d;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tTNativeAd) == null) {
            LogPrinter.d();
            this.f.onAdClicked((t2b) this.c, this.b, new String[0]);
            this.b = true;
            FunAdInteractionListener funAdInteractionListener = this.d;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            this.f.onAdShow((t2b) this.c, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.d;
            if (funAdInteractionListener != null) {
                String str = this.e;
                pid = this.f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }
}
