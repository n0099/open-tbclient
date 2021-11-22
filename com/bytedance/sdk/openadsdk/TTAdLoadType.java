package com.bytedance.sdk.openadsdk;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class TTAdLoadType {
    public static /* synthetic */ Interceptable $ic;
    public static final TTAdLoadType LOAD;
    public static final TTAdLoadType PRELOAD;
    public static final TTAdLoadType UNKNOWN;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ TTAdLoadType[] f62471a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-397224445, "Lcom/bytedance/sdk/openadsdk/TTAdLoadType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-397224445, "Lcom/bytedance/sdk/openadsdk/TTAdLoadType;");
                return;
            }
        }
        UNKNOWN = new TTAdLoadType(RomUtils.UNKNOWN, 0);
        PRELOAD = new TTAdLoadType("PRELOAD", 1);
        TTAdLoadType tTAdLoadType = new TTAdLoadType("LOAD", 2);
        LOAD = tTAdLoadType;
        f62471a = new TTAdLoadType[]{UNKNOWN, PRELOAD, tTAdLoadType};
    }

    public TTAdLoadType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static TTAdLoadType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TTAdLoadType) Enum.valueOf(TTAdLoadType.class, str) : (TTAdLoadType) invokeL.objValue;
    }

    public static TTAdLoadType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TTAdLoadType[]) f62471a.clone() : (TTAdLoadType[]) invokeV.objValue;
    }
}
