package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class q34 implements cx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q34() {
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

    @Override // com.baidu.tieba.cx1
    @Nullable
    public h32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lo2 lo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lo2Var)) == null) {
            return p34.b().a(str, jSONObject, lo2Var);
        }
        return (h32) invokeLLL.objValue;
    }
}
