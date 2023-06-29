package com.baidu.tieba.immessagecenter.msgtab.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/data/CacheDataType;", "", "(Ljava/lang/String;I)V", "LAST_REQUEST_DATA", "RECOMMEND_DATA", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CacheDataType {
    public static final /* synthetic */ CacheDataType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CacheDataType LAST_REQUEST_DATA;
    public static final CacheDataType RECOMMEND_DATA;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ CacheDataType[] $values() {
        return new CacheDataType[]{LAST_REQUEST_DATA, RECOMMEND_DATA};
    }

    public static CacheDataType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CacheDataType) Enum.valueOf(CacheDataType.class, str) : (CacheDataType) invokeL.objValue;
    }

    public static CacheDataType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CacheDataType[]) $VALUES.clone() : (CacheDataType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1237516452, "Lcom/baidu/tieba/immessagecenter/msgtab/data/CacheDataType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1237516452, "Lcom/baidu/tieba/immessagecenter/msgtab/data/CacheDataType;");
                return;
            }
        }
        LAST_REQUEST_DATA = new CacheDataType("LAST_REQUEST_DATA", 0);
        RECOMMEND_DATA = new CacheDataType("RECOMMEND_DATA", 1);
        $VALUES = $values();
    }

    public CacheDataType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }
}
