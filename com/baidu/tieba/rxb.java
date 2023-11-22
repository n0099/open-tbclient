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
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class rxb implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rxb() {
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
                case -2111208871:
                    if (str.equals(FunAdType.BAIDU_FEED)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1264614302:
                    if (str.equals(FunAdType.BAIDU_SPLASH)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -565764667:
                    if (str.equals(FunAdType.BAIDU_FULLSCREEN_VIDEO)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -117702953:
                    if (str.equals(FunAdType.BAIDU_FEED_EXPRESS)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 145313334:
                    if (str.equals(FunAdType.BAIDU_NATIVE_CPU)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 409835681:
                    if (str.equals(FunAdType.BAIDU_EXPRESS_INTERSTITIAL)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1371907441:
                    if (str.equals(FunAdType.BAIDU_REWARD_VIDEO)) {
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
                    return new qyb(pid);
                case 1:
                    return new zyb(pid);
                case 2:
                    return new uyb(pid);
                case 3:
                    return new iyb(pid);
                case 4:
                    return new vyb(pid);
                case 5:
                    return new oyb(pid);
                case 6:
                    return new yyb(pid);
                default:
                    LogPrinter.e("Not supported pid.type:%s", pid.type);
                    return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
