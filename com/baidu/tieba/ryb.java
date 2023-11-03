package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class ryb implements txb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ ayb c;
    public final /* synthetic */ syb d;

    public ryb(syb sybVar, ayb aybVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sybVar, aybVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = sybVar;
        this.c = aybVar;
    }

    @Override // com.baidu.tieba.txb
    public void onADExposed() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.d.e.onAdShow((pyb) this.c, this.a, new String[0]);
            this.a = true;
            syb sybVar = this.d;
            FunAdInteractionListener funAdInteractionListener = sybVar.b;
            if (funAdInteractionListener != null) {
                String str = sybVar.d;
                pid = sybVar.e.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.d.e.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.baidu.tieba.txb
    public void onADExposureFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            LogPrinter.d();
            this.a = false;
            this.d.e.onAdError(this.c, i, "F:onADExposureFailed");
            syb sybVar = this.d;
            FunAdInteractionListener funAdInteractionListener = sybVar.b;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(sybVar.d);
            }
        }
    }

    @Override // com.baidu.tieba.txb
    public void onAdClick() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            this.d.e.onAdClicked((pyb) this.c, this.b, new String[0]);
            this.b = true;
            syb sybVar = this.d;
            FunAdInteractionListener funAdInteractionListener = sybVar.b;
            if (funAdInteractionListener != null) {
                String str = sybVar.d;
                pid = sybVar.e.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.d.e.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }
}
