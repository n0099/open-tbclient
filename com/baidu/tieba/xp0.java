package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.lp.reward.NadRewardVideoActivity;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes8.dex */
public class xp0 extends vj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "rewardImpl" : (String) invokeV.objValue;
    }

    public xp0() {
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

    @Override // com.baidu.tieba.vj0
    public boolean b(@NonNull Context context, @NonNull zj0 zj0Var, @Nullable Map<String, Object> map, @Nullable dk0 dk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zj0Var, map, dk0Var)) == null) {
            super.b(context, zj0Var, map, dk0Var);
            HashMap<String, String> d = zj0Var.d();
            int i = 0;
            if (d.isEmpty()) {
                c(dk0Var, zj0Var, 202, false);
                return true;
            }
            Intent intent = new Intent(context, NadRewardVideoActivity.class);
            intent.putExtra("params", d);
            boolean d2 = v51.d(context, intent);
            if (!d2) {
                i = 1001;
            }
            c(dk0Var, zj0Var, i, d2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
