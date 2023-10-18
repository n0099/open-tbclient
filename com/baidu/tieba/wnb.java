package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class wnb implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ModuleConfigKs a;

    public wnb(ModuleConfigKs moduleConfigKs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moduleConfigKs};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = moduleConfigKs;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r2.equals(com.fun.ad.sdk.FunAdType.KS_NATIVE_EXPRESS) == false) goto L45;
     */
    @Override // com.fun.ad.sdk.internal.api.PidLoaderCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PidLoader create(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) {
            char c = 0;
            try {
                Long.parseLong(pid.pid);
                String str = pid.type;
                str.hashCode();
                switch (str.hashCode()) {
                    case -1377301807:
                        break;
                    case -1291455752:
                        if (str.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1187931233:
                        if (str.equals(FunAdType.KS_NATIVE)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1106926588:
                        if (str.equals(FunAdType.KS_REWARD_VIDEO)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1031178769:
                        if (str.equals(FunAdType.KS_SPLASH)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1860126748:
                        if (str.equals(FunAdType.KS_INTERSTITIAL_EXPRESS)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2017609999:
                        if (str.equals(FunAdType.KS_DRAW_VIDEO)) {
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
                        return new lob(pid);
                    case 1:
                        return new dob(pid, this.a);
                    case 2:
                        return new pob(pid);
                    case 3:
                        return new vob(pid, this.a);
                    case 4:
                        return new yob(pid);
                    case 5:
                        return new hob(pid, this.a);
                    case 6:
                        return new znb(pid);
                    default:
                        return null;
                }
            } catch (NumberFormatException unused) {
                LogPrinter.d("NumberFormatException for Pid:%s" + pid.pid, new Object[0]);
                return null;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
