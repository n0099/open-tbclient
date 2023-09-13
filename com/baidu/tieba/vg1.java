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
/* loaded from: classes8.dex */
public final class vg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948239721, "Lcom/baidu/tieba/vg1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948239721, "Lcom/baidu/tieba/vg1;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh1 a;
        public final /* synthetic */ JSONObject b;

        public a(rh1 rh1Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh1Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh1Var;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                rh1 rh1Var = this.a;
                if (rh1Var != null) {
                    rh1Var.a(1, str);
                }
                zg1.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            rh1 rh1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (rh1Var = this.a) != null) {
                rh1Var.a(0, "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh1 a;

        public b(rh1 rh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            rh1 rh1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (rh1Var = this.a) != null) {
                rh1Var.a(0, "");
            }
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            rh1 rh1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) && (rh1Var = this.a) != null) {
                rh1Var.a(1, str);
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

    public static final void c(JSONObject jSONObject, rh1 rh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, jSONObject, rh1Var) != null) || jSONObject == null) {
            return;
        }
        qg1 qg1Var = new qg1();
        xg1.d(qg1Var);
        pg1 e = xg1.e(jSONObject);
        xg1.c(qg1Var, e.a("bduss"));
        HttpSigner.b(e);
        new ug1(false).a(yg1.f(), qg1Var, e, new a(rh1Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, rh1 rh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, rh1Var) != null) || jSONArray == null) {
            return;
        }
        qg1 qg1Var = new qg1();
        xg1.d(qg1Var);
        pg1 pg1Var = new pg1();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        pg1Var.d("batchData", jSONArray2);
        HttpSigner.b(pg1Var);
        new ug1(false).a(yg1.a(), qg1Var, pg1Var, new b(rh1Var));
    }
}
