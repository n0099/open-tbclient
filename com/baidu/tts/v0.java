package com.baidu.tts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class v0 {
    public static /* synthetic */ Interceptable $ic;
    public static final v0 b;
    public static final v0 c;
    public static final v0 d;
    public static final v0 e;
    public static final v0 f;
    public static final /* synthetic */ v0[] g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722269719, "Lcom/baidu/tts/v0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722269719, "Lcom/baidu/tts/v0;");
                return;
            }
        }
        v0 v0Var = new v0("TTS_SERVER", 0, "https://tts.baidu.com/text2audio");
        b = v0Var;
        v0 v0Var2 = new v0("MODEL_SERVER", 1, "https://tts.baidu.com/bos/story.php?");
        c = v0Var2;
        v0 v0Var3 = new v0("STATISTICS_MODELLOAD_SERVER", 2, "https://upl.baidu.com/ttsdlstats");
        d = v0Var3;
        v0 v0Var4 = new v0("GETLICENSE_V1_SERVER", 3, "https://upl.baidu.com/offline/auth");
        e = v0Var4;
        v0 v0Var5 = new v0("GETLICENSE_V2_SERVER", 4, "https://upl.baidu.com/auth");
        f = v0Var5;
        g = new v0[]{v0Var, v0Var2, v0Var3, v0Var4, v0Var5};
    }

    public v0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str2;
    }

    public static v0 valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (v0) Enum.valueOf(v0.class, str);
        }
        return (v0) invokeL.objValue;
    }

    public static v0[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (v0[]) g.clone();
        }
        return (v0[]) invokeV.objValue;
    }
}
