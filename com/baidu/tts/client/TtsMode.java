package com.baidu.tts.client;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.t0;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class TtsMode {
    public static /* synthetic */ Interceptable $ic;
    public static final TtsMode MIX;
    public static final TtsMode OFFLINE;
    public static final TtsMode ONLINE;
    public static final /* synthetic */ TtsMode[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public final t0 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(992050367, "Lcom/baidu/tts/client/TtsMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(992050367, "Lcom/baidu/tts/client/TtsMode;");
                return;
            }
        }
        TtsMode ttsMode = new TtsMode("ONLINE", 0, t0.c);
        ONLINE = ttsMode;
        TtsMode ttsMode2 = new TtsMode("OFFLINE", 1, t0.d);
        OFFLINE = ttsMode2;
        TtsMode ttsMode3 = new TtsMode("MIX", 2, t0.e);
        MIX = ttsMode3;
        b = new TtsMode[]{ttsMode, ttsMode2, ttsMode3};
    }

    public TtsMode(String str, int i, t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), t0Var};
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
        this.a = t0Var;
    }

    public static TtsMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (TtsMode) Enum.valueOf(TtsMode.class, str);
        }
        return (TtsMode) invokeL.objValue;
    }

    public static TtsMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (TtsMode[]) b.clone();
        }
        return (TtsMode[]) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.b;
        }
        return (String) invokeV.objValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.a;
        }
        return invokeV.intValue;
    }

    public t0 getTtsEnum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (t0) invokeV.objValue;
    }
}
