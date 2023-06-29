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
public final class qh1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948091727, "Lcom/baidu/tieba/qh1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948091727, "Lcom/baidu/tieba/qh1;");
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends jh1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi1 a;
        public final /* synthetic */ JSONObject b;

        public a(mi1 mi1Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi1Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi1Var;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.jh1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                mi1 mi1Var = this.a;
                if (mi1Var != null) {
                    mi1Var.a(1, str);
                }
                uh1.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jh1
        /* renamed from: d */
        public void c(String str) {
            mi1 mi1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (mi1Var = this.a) != null) {
                mi1Var.a(0, "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends jh1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi1 a;

        public b(mi1 mi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jh1
        /* renamed from: d */
        public void c(String str) {
            mi1 mi1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (mi1Var = this.a) != null) {
                mi1Var.a(0, "");
            }
        }

        @Override // com.baidu.tieba.jh1
        public void a(Throwable th, int i, String str) {
            mi1 mi1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) && (mi1Var = this.a) != null) {
                mi1Var.a(1, str);
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

    public static final void c(JSONObject jSONObject, mi1 mi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, jSONObject, mi1Var) != null) || jSONObject == null) {
            return;
        }
        lh1 lh1Var = new lh1();
        sh1.d(lh1Var);
        kh1 e = sh1.e(jSONObject);
        sh1.c(lh1Var, e.a("bduss"));
        HttpSigner.b(e);
        new ph1(false).a(th1.f(), lh1Var, e, new a(mi1Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, mi1 mi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, mi1Var) != null) || jSONArray == null) {
            return;
        }
        lh1 lh1Var = new lh1();
        sh1.d(lh1Var);
        kh1 kh1Var = new kh1();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        kh1Var.d("batchData", jSONArray2);
        HttpSigner.b(kh1Var);
        new ph1(false).a(th1.a(), lh1Var, kh1Var, new b(mi1Var));
    }
}
