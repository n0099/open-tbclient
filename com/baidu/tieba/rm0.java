package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.om0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class rm0 extends dj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "scheduledDownload" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements om0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj0 a;
        public final /* synthetic */ hj0 b;
        public final /* synthetic */ rm0 c;

        public a(rm0 rm0Var, lj0 lj0Var, hj0 hj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm0Var, lj0Var, hj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rm0Var;
            this.a = lj0Var;
            this.b = hj0Var;
        }

        @Override // com.baidu.tieba.om0.b
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.c.c(this.a, this.b, 0, true);
                } else {
                    this.c.c(this.a, this.b, 202, true);
                }
            }
        }
    }

    public rm0() {
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

    @Override // com.baidu.tieba.dj0
    public boolean b(@NonNull Context context, @NonNull hj0 hj0Var, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hj0Var, map, lj0Var)) == null) {
            super.b(context, hj0Var, map, lj0Var);
            om0.b().c(context, hj0Var.d(), new a(this, lj0Var, hj0Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
