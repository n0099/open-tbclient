package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements xi3<e93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw1 a;

        public a(lw1 lw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(e93 e93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e93Var) == null) {
                if (e93Var == null || e93Var.d || e93Var.j != 1) {
                    qz3.c(this.a, false, "system deny");
                } else {
                    qz3.c(this.a, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948109087, "Lcom/baidu/tieba/qz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948109087, "Lcom/baidu/tieba/qz3;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void b(JsObject jsObject) {
        lw1 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jsObject) != null) || (F = lw1.F(jsObject)) == null) {
            return;
        }
        e43 b0 = e43.b0();
        if (b0 == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            b0.e0().e("mapp_enable_eval", new a(F));
        }
    }

    public static void c(lw1 lw1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{lw1Var, Boolean.valueOf(z), str}) == null) {
            if (a) {
                Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
            }
            ny3 ny3Var = new ny3();
            ny3Var.errMsg = str;
            q64.call(lw1Var, z, ny3Var);
        }
    }
}
