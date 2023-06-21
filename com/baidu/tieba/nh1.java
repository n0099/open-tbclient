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
public final class nh1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948002354, "Lcom/baidu/tieba/nh1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948002354, "Lcom/baidu/tieba/nh1;");
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends gh1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji1 a;
        public final /* synthetic */ JSONObject b;

        public a(ji1 ji1Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji1Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji1Var;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.gh1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                ji1 ji1Var = this.a;
                if (ji1Var != null) {
                    ji1Var.a(1, str);
                }
                rh1.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gh1
        /* renamed from: d */
        public void c(String str) {
            ji1 ji1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (ji1Var = this.a) != null) {
                ji1Var.a(0, "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends gh1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji1 a;

        public b(ji1 ji1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gh1
        /* renamed from: d */
        public void c(String str) {
            ji1 ji1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (ji1Var = this.a) != null) {
                ji1Var.a(0, "");
            }
        }

        @Override // com.baidu.tieba.gh1
        public void a(Throwable th, int i, String str) {
            ji1 ji1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) && (ji1Var = this.a) != null) {
                ji1Var.a(1, str);
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

    public static final void c(JSONObject jSONObject, ji1 ji1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, jSONObject, ji1Var) != null) || jSONObject == null) {
            return;
        }
        ih1 ih1Var = new ih1();
        ph1.d(ih1Var);
        hh1 e = ph1.e(jSONObject);
        ph1.c(ih1Var, e.a("bduss"));
        HttpSigner.b(e);
        new mh1(false).a(qh1.f(), ih1Var, e, new a(ji1Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, ji1 ji1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, ji1Var) != null) || jSONArray == null) {
            return;
        }
        ih1 ih1Var = new ih1();
        ph1.d(ih1Var);
        hh1 hh1Var = new hh1();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        hh1Var.d("batchData", jSONArray2);
        HttpSigner.b(hh1Var);
        new mh1(false).a(qh1.a(), ih1Var, hh1Var, new b(ji1Var));
    }
}
