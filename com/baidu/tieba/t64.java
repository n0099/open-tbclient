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
/* loaded from: classes8.dex */
public class t64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements aq3<hg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o32 a;

        public a(o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hg3 hg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hg3Var) == null) {
                if (hg3Var == null || hg3Var.d || hg3Var.j != 1) {
                    t64.c(this.a, false, "system deny");
                } else {
                    t64.c(this.a, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133143, "Lcom/baidu/tieba/t64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133143, "Lcom/baidu/tieba/t64;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void b(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jsObject) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        hb3 b0 = hb3.b0();
        if (b0 == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            b0.e0().e("mapp_enable_eval", new a(F));
        }
    }

    public static void c(o32 o32Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{o32Var, Boolean.valueOf(z), str}) == null) {
            if (a) {
                Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
            }
            q54 q54Var = new q54();
            q54Var.errMsg = str;
            td4.call(o32Var, z, q54Var);
        }
    }
}
