package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes6.dex */
public class uoa implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uoa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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
                case -1303381232:
                    if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -942661506:
                    if (str.equals(FunAdType.GDT_SPLASH)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -596233886:
                    if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 114133351:
                    if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 125016359:
                    if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 425812868:
                    if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 543046357:
                    if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1990506825:
                    if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                        c = 7;
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
                    return new zoa(pid);
                case 1:
                    return new ipa(pid);
                case 2:
                    return new cpa(pid);
                case 3:
                    return new jpa(pid);
                case 4:
                    return new kpa(pid);
                case 5:
                    return new epa(pid);
                case 6:
                    return new hpa(pid);
                case 7:
                    return new yoa(pid);
                default:
                    return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
