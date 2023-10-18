package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.FrsPage.DataRes;
/* loaded from: classes7.dex */
public class o85 {
    public static /* synthetic */ Interceptable $ic;
    public static final o85 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986141, "Lcom/baidu/tieba/o85;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986141, "Lcom/baidu/tieba/o85;");
                return;
            }
        }
        a = new o85(false);
    }

    public o85(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static o85 a(@Nullable JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            boolean z = false;
            if (jSONObject != null) {
                i = jSONObject.optInt("voice_room_config");
            } else {
                i = 0;
            }
            if (i == 1) {
                z = true;
            }
            return new o85(z);
        }
        return (o85) invokeL.objValue;
    }

    @NonNull
    public static o85 b(@Nullable DataRes dataRes) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dataRes)) == null) {
            boolean z = false;
            if (dataRes != null) {
                i = dataRes.voice_room_config.intValue();
            } else {
                i = 0;
            }
            if (i == 1) {
                z = true;
            }
            return new o85(z);
        }
        return (o85) invokeL.objValue;
    }
}
