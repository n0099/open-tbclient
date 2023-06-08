package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.channel.ModuleConfigGdt;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes7.dex */
public class r2b implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ModuleConfigGdt a;

    public r2b(ModuleConfigGdt moduleConfigGdt) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moduleConfigGdt};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = moduleConfigGdt;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fun.ad.sdk.internal.api.PidLoaderCreator
    public PidLoader create(Ssp.Pid pid) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) {
            String str = pid.type;
            str.hashCode();
            switch (str.hashCode()) {
                case -942661506:
                    if (str.equals(FunAdType.GDT_SPLASH)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -596233886:
                    if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 114133351:
                    if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 125016359:
                    if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 425812868:
                    if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 543046357:
                    if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1990506825:
                    if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return new k3b(pid);
                case 1:
                    return new y2b(pid);
                case 2:
                    return new l3b(pid);
                case 3:
                    return new m3b(pid, this.a);
                case 4:
                    return new e3b(pid);
                case 5:
                    return new j3b(pid, this.a);
                case 6:
                    return new x2b(pid, this.a);
                default:
                    return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
