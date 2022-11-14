package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.kwad.sdk.api.KsVideoPlayConfig;
/* loaded from: classes5.dex */
public abstract class or9<A> extends ReporterPidLoader<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ModuleConfigKs e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public or9(FunAdType funAdType, Ssp.Pid pid, ModuleConfigKs moduleConfigKs) {
        super(funAdType, pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, moduleConfigKs};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = moduleConfigKs;
    }

    public KsVideoPlayConfig e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KsVideoPlayConfig.Builder().showLandscape(this.mPid.isHorizontal).videoSoundEnable(this.e.ksVideoSoundEnable).build() : (KsVideoPlayConfig) invokeV.objValue;
    }
}
