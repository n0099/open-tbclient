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
public class tob implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tob() {
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
                case -2105157443:
                    if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1412451668:
                    if (str.equals(FunAdType.CSJ_INTERSITIAL_2)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1263692214:
                    if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1071311851:
                    if (str.equals(FunAdType.CSJ_DRAW_NATIVE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -950004865:
                    if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 347930415:
                    if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 556489085:
                    if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1168375858:
                    if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1319012390:
                    if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1328722634:
                    if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1922685617:
                    if (str.equals(FunAdType.CSJ_NATIVE)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 2079438081:
                    if (str.equals(FunAdType.CSJ_SPLASH)) {
                        c = 11;
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
                    return new npb(pid);
                case 1:
                    return new ypb(pid);
                case 2:
                    return new aqb(pid);
                case 3:
                    return new jpb(pid);
                case 4:
                    return new bqb(pid);
                case 5:
                    return new sob(pid);
                case 6:
                    return new bpb(FunAdType.obtainType(pid, FunAdType.AdType.BANNER), pid);
                case 7:
                    return new jqb(pid);
                case '\b':
                    return new tpb(FunAdType.obtainType(pid, FunAdType.AdType.FULL_SCREEN), pid);
                case '\t':
                    return new wob(pid);
                case '\n':
                    return new iqb(pid);
                case 11:
                    return new vob(pid);
                default:
                    LogPrinter.e("Not supported pid.type:%s", pid.type);
                    return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
