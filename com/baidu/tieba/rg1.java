package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class rg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948120557, "Lcom/baidu/tieba/rg1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948120557, "Lcom/baidu/tieba/rg1;");
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh1 a;
        public final /* synthetic */ JSONObject b;

        public a(nh1 nh1Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh1Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh1Var;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                nh1 nh1Var = this.a;
                if (nh1Var != null) {
                    nh1Var.a(1, str);
                }
                vg1.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
        /* renamed from: d */
        public void c(String str) {
            nh1 nh1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (nh1Var = this.a) != null) {
                nh1Var.a(0, "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh1 a;

        public b(nh1 nh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
        /* renamed from: d */
        public void c(String str) {
            nh1 nh1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (nh1Var = this.a) != null) {
                nh1Var.a(0, "");
            }
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            nh1 nh1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) && (nh1Var = this.a) != null) {
                nh1Var.a(1, str);
            }
        }
    }

    public static final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return invokeV.intValue;
    }

    public static final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            a = i;
        }
    }

    public static final void c(JSONObject jSONObject, nh1 nh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, jSONObject, nh1Var) != null) || jSONObject == null) {
            return;
        }
        mg1 mg1Var = new mg1();
        tg1.d(mg1Var);
        lg1 e = tg1.e(jSONObject);
        tg1.c(mg1Var, e.a("bduss"));
        HttpSigner.b(e);
        new qg1(false).a(ug1.f(), mg1Var, e, new a(nh1Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, nh1 nh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, nh1Var) != null) || jSONArray == null) {
            return;
        }
        mg1 mg1Var = new mg1();
        tg1.d(mg1Var);
        lg1 lg1Var = new lg1();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        lg1Var.d("batchData", jSONArray2);
        HttpSigner.b(lg1Var);
        new qg1(false).a(ug1.a(), mg1Var, lg1Var, new b(nh1Var));
    }
}
