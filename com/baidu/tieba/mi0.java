package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.li0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class mi0 extends bk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bk0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "dlink" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements li0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jk0 a;
        public final /* synthetic */ fk0 b;
        public final /* synthetic */ mi0 c;

        public a(mi0 mi0Var, jk0 jk0Var, fk0 fk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi0Var, jk0Var, fk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mi0Var;
            this.a = jk0Var;
            this.b = fk0Var;
        }

        @Override // com.baidu.tieba.li0.c
        public void onResult(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                mi0 mi0Var = this.c;
                jk0 jk0Var = this.a;
                fk0 fk0Var = this.b;
                if (z) {
                    i = 0;
                } else {
                    i = 1001;
                }
                mi0Var.c(jk0Var, fk0Var, i, z);
            }
        }
    }

    public mi0() {
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
            new li0().g(context, fk0Var.d(), new a(this, jk0Var, fk0Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
