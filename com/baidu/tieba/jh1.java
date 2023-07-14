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
/* loaded from: classes6.dex */
public final class jh1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947883190, "Lcom/baidu/tieba/jh1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947883190, "Lcom/baidu/tieba/jh1;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends ch1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi1 a;
        public final /* synthetic */ JSONObject b;

        public a(fi1 fi1Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi1Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi1Var;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.ch1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                fi1 fi1Var = this.a;
                if (fi1Var != null) {
                    fi1Var.a(1, str);
                }
                nh1.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
        /* renamed from: d */
        public void c(String str) {
            fi1 fi1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (fi1Var = this.a) != null) {
                fi1Var.a(0, "");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ch1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi1 a;

        public b(fi1 fi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
        /* renamed from: d */
        public void c(String str) {
            fi1 fi1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (fi1Var = this.a) != null) {
                fi1Var.a(0, "");
            }
        }

        @Override // com.baidu.tieba.ch1
        public void a(Throwable th, int i, String str) {
            fi1 fi1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) && (fi1Var = this.a) != null) {
                fi1Var.a(1, str);
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

    public static final void c(JSONObject jSONObject, fi1 fi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, jSONObject, fi1Var) != null) || jSONObject == null) {
            return;
        }
        eh1 eh1Var = new eh1();
        lh1.d(eh1Var);
        dh1 e = lh1.e(jSONObject);
        lh1.c(eh1Var, e.a("bduss"));
        HttpSigner.b(e);
        new ih1(false).a(mh1.f(), eh1Var, e, new a(fi1Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, fi1 fi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, fi1Var) != null) || jSONArray == null) {
            return;
        }
        eh1 eh1Var = new eh1();
        lh1.d(eh1Var);
        dh1 dh1Var = new dh1();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        dh1Var.d("batchData", jSONArray2);
        HttpSigner.b(dh1Var);
        new ih1(false).a(mh1.a(), eh1Var, dh1Var, new b(fi1Var));
    }
}
