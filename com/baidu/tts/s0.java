package com.baidu.tts;

import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class s0 {
    public static /* synthetic */ Interceptable $ic;
    public static final s0 b;
    public static final s0 c;
    public static final s0 d;
    public static final s0 e;
    public static final s0 f;
    public static final /* synthetic */ s0[] g;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722266836, "Lcom/baidu/tts/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722266836, "Lcom/baidu/tts/s0;");
                return;
            }
        }
        s0 s0Var = new s0(EngineName.DEFAULT_ENGINE, 0, 6L, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
        b = s0Var;
        s0 s0Var2 = new s0("TWO_SECOND", 1, 2L, 2000L);
        c = s0Var2;
        s0 s0Var3 = new s0("THREE_SECOND", 2, 3L, 3000L);
        d = s0Var3;
        s0 s0Var4 = new s0("FOUR_SECOND", 3, 4L, 4000L);
        e = s0Var4;
        s0 s0Var5 = new s0("ONE_SECOND", 4, 1L, IMLikeRequest.TIME_INTERVAL);
        f = s0Var5;
        g = new s0[]{s0Var, s0Var2, s0Var3, s0Var4, s0Var5};
    }

    public s0(String str, int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j2;
    }

    public static s0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (s0) Enum.valueOf(s0.class, str);
        }
        return (s0) invokeL.objValue;
    }

    public static s0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (s0[]) g.clone();
        }
        return (s0[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (int) this.a;
        }
        return invokeV.intValue;
    }
}
