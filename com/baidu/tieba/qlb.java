package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes7.dex */
public class qlb implements skb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ zkb c;
    public final /* synthetic */ rlb d;

    public qlb(rlb rlbVar, zkb zkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rlbVar, zkbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = rlbVar;
        this.c = zkbVar;
    }

    @Override // com.baidu.tieba.skb
    public void onADExposed() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.d.e.onAdShow((olb) this.c, this.a, new String[0]);
            this.a = true;
            rlb rlbVar = this.d;
            FunAdInteractionListener funAdInteractionListener = rlbVar.b;
            if (funAdInteractionListener != null) {
                String str = rlbVar.d;
                pid = rlbVar.e.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.d.e.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.baidu.tieba.skb
    public void onADExposureFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            LogPrinter.d();
            this.a = false;
            this.d.e.onAdError(this.c, i, "F:onADExposureFailed");
            rlb rlbVar = this.d;
            FunAdInteractionListener funAdInteractionListener = rlbVar.b;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(rlbVar.d);
            }
        }
    }

    @Override // com.baidu.tieba.skb
    public void onAdClick() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            this.d.e.onAdClicked((olb) this.c, this.b, new String[0]);
            this.b = true;
            rlb rlbVar = this.d;
            FunAdInteractionListener funAdInteractionListener = rlbVar.b;
            if (funAdInteractionListener != null) {
                String str = rlbVar.d;
                pid = rlbVar.e.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.d.e.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }
}
