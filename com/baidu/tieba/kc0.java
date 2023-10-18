package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.jc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class kc0 extends zd0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zd0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "dlink" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements jc0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he0 a;
        public final /* synthetic */ de0 b;
        public final /* synthetic */ kc0 c;

        public a(kc0 kc0Var, he0 he0Var, de0 de0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc0Var, he0Var, de0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kc0Var;
            this.a = he0Var;
            this.b = de0Var;
        }

        @Override // com.baidu.tieba.jc0.c
        public void onResult(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                kc0 kc0Var = this.c;
                he0 he0Var = this.a;
                de0 de0Var = this.b;
                if (z) {
                    i = 0;
                } else {
                    i = 1001;
                }
                kc0Var.c(he0Var, de0Var, i, z);
            }
        }
    }

    public kc0() {
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

    @Override // com.baidu.tieba.zd0
    public boolean b(@NonNull Context context, @NonNull de0 de0Var, @Nullable Map<String, Object> map, @Nullable he0 he0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, de0Var, map, he0Var)) == null) {
            super.b(context, de0Var, map, he0Var);
            new jc0().g(context, de0Var.d(), new a(this, he0Var, de0Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
