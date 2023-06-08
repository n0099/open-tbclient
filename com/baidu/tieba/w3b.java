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
/* loaded from: classes8.dex */
public class w3b implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w3b() {
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
                case -1900686778:
                    if (str.equals(FunAdType.JY_NATIVE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1743934314:
                    if (str.equals(FunAdType.JY_SPLASH)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1659486968:
                    if (str.equals(FunAdType.JY_DRAW_VIDEO)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -39027267:
                    if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1872382491:
                    if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                return null;
                            }
                            return new z3b(pid);
                        }
                        return new c4b(pid);
                    }
                    return new x3b(pid);
                }
                return new d4b(pid);
            }
            return new a4b(pid);
        }
        return (PidLoader) invokeL.objValue;
    }
}
