package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdnName;
/* loaded from: classes8.dex */
public abstract class v5c<A extends b7c> extends ReporterPidLoader<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ModuleConfigKs e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v5c(FunAdType funAdType, Ssp.Pid pid, ModuleConfigKs moduleConfigKs) {
        this(funAdType, pid, true);
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
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = moduleConfigKs;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v5c(FunAdType funAdType, Ssp.Pid pid, boolean z) {
        this(funAdType, pid, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v5c(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2) {
        this(funAdType, pid, z, z2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v5c(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2, boolean z3) {
        super(funAdType, pid, z, z2, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ReporterPidLoader
    public AdReporter<A> createAdReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c7c(this.mPid) : (AdReporter) invokeV.objValue;
    }

    public KsVideoPlayConfig e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KsVideoPlayConfig.Builder showLandscape = new KsVideoPlayConfig.Builder().showLandscape(this.mPid.isHorizontal);
            ModuleConfigKs moduleConfigKs = this.e;
            return showLandscape.videoSoundEnable(moduleConfigKs == null || moduleConfigKs.ksVideoSoundEnable).build();
        }
        return (KsVideoPlayConfig) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public double getAdBiddingPrices(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            return ((b7c) obj).a() / 100.0d;
        }
        return invokeL.doubleValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        if (r6.equals(com.fun.ad.sdk.FunAdSdk.PLATFORM_CSJ) == false) goto L31;
     */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setAdBiddingResult(Object obj, String str, double d, double d2, boolean z, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{obj, str, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            b7c b7cVar = (b7c) obj;
            double d3 = d * 100.0d;
            double d4 = d2 * 100.0d;
            if (z) {
                b7cVar.c((long) d3, (long) d4);
                return;
            }
            int i4 = (int) (d3 + 100.0d);
            char c = 0;
            if (i == 5) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            if (FunAdSdk.PLATFORM_KS.equals(str)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            str.hashCode();
            int hashCode = str.hashCode();
            String str2 = "baidu";
            if (hashCode != 98810) {
                if (hashCode != 102199) {
                    if (hashCode == 93498907 && str.equals("baidu")) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (str.equals(FunAdSdk.PLATFORM_GDT)) {
                        c = 1;
                    }
                    c = 65535;
                }
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        str2 = "other";
                    }
                } else {
                    str2 = AdnName.GUANGDIANTONG;
                }
            } else {
                str2 = AdnName.CHUANSHANJIA;
            }
            b7cVar.b(i4, i2, i3, str2);
        }
    }
}
