package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y34 implements qx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public x34 b;

    /* loaded from: classes8.dex */
    public class a implements zo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;
        public final /* synthetic */ y34 b;

        public a(y34 y34Var, zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y34Var, zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y34Var;
            this.a = zo2Var;
        }

        @Override // com.baidu.tieba.zo2
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.b.g(false);
                this.a.onFail(i, str);
            }
        }

        @Override // com.baidu.tieba.zo2
        public void onSuccess(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.b.g(true);
                this.a.onSuccess(jSONObject);
            }
        }
    }

    public y34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new x34();
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 != null) {
                return b0.O();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String d = d();
            if (TextUtils.isEmpty(d) || (bool = this.a.get(d)) == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qx1
    @Nullable
    public v32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull zo2 zo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, zo2Var)) == null) {
            if (f()) {
                zo2Var.onSuccess(null);
                return null;
            }
            return this.b.a(jSONObject, c(zo2Var));
        }
        return (v32) invokeLLL.objValue;
    }

    public final zo2 c(@NonNull zo2 zo2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zo2Var)) == null) {
            return new a(this, zo2Var);
        }
        return (zo2) invokeL.objValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return TextUtils.equals(this.b.a, str);
        }
        return invokeL.booleanValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            String d = d();
            if (TextUtils.isEmpty(d)) {
                return;
            }
            this.a.put(d, Boolean.valueOf(z));
        }
    }
}
