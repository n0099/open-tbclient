package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.max.ImmersiveVideoDetailActivity;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class rq0 extends bk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bk0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FunAdSdk.PLATFORM_MAX : (String) invokeV.objValue;
    }

    public rq0() {
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

    @Override // com.baidu.tieba.bk0
    public boolean b(@NonNull Context context, @NonNull fk0 fk0Var, @Nullable Map<String, Object> map, @Nullable jk0 jk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fk0Var, map, jk0Var)) == null) {
            super.b(context, fk0Var, map, jk0Var);
            HashMap<String, String> d = fk0Var.d();
            Intent intent = new Intent(context, ImmersiveVideoDetailActivity.class);
            intent.putExtra("map", d);
            return w61.d(context, intent);
        }
        return invokeLLLL.booleanValue;
    }
}
